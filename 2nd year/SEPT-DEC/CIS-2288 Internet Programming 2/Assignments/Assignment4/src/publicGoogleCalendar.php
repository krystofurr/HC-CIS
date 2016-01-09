<?php

/*

 .d8b.  .d8888. .d8888. d888888b  d888b  d8b   db .88b  d88. d88888b d8b   db d888888b     j88D
d8' `8b 88'  YP 88'  YP   `88'   88' Y8b 888o  88 88'YbdP`88 88'     888o  88 `~~88~~'    j8~88
88ooo88 `8bo.   `8bo.      88    88      88V8o 88 88  88  88 88ooooo 88V8o 88    88      j8' 88
88~~~88   `Y8b.   `Y8b.    88    88  ooo 88 V8o88 88  88  88 88~~~~~ 88 V8o88    88      V88888D
88   88 db   8D db   8D   .88.   88. ~8~ 88  V888 88  88  88 88.     88  V888    88          88
YP   YP `8888Y' `8888Y' Y888888P  Y888P  VP   V8P YP  YP  YP Y88888P VP   V8P    YP          VP

Program name:       Assignment 4
Author:             Christopher Sigouin & Nimna Nekanayaka
Version:            1.0
Description:        Google API with PHP
Dependencies:       n/a
Database file:      n/a
Change History:     2015.11.09 Original version by CJS

*/

$groupMembers = array('Nimna Nekanayaka', 'Christopher Sigouin');
date_default_timezone_set('America/Halifax');


require __DIR__ . '/vendor/autoload.php';

define('APPLICATION_NAME', 'CIS2288 - Assignment4 - Public Google Calendar');
define('CREDENTIALS_PATH', '/home/csigouin/.credentials/calendar-php-quickstart.json');
define('CLIENT_SECRET_PATH', '/home/csigouin/.credentials/client_secret_web.json');
define('SCOPES', implode(' ', array(
        Google_Service_Calendar::CALENDAR_READONLY)
));

// COMMENTED OUT AS THIS WAS PART OF THE CLI EXAMPLE

// if (php_sapi_name() != 'cli') {
//     throw new Exception('This application must be run on the command line.');
// }

/**
 * EXAMPLE CODE FROM GOOLE API CALENDAR QUICKSTART
 * REF: https://developers.google.com/google-apps/calendar/
 *
 * Returns an authorized API client.
 * @return Google_Client the authorized client object
 */
function getClient() {
    $client = new Google_Client();
    $client->setApplicationName(APPLICATION_NAME);
    $client->setScopes(SCOPES);
    $client->setAuthConfigFile(CLIENT_SECRET_PATH);
    $client->setAccessType('offline');

    // Load previously authorized credentials from a file.
    $credentialsPath = expandHomeDirectory(CREDENTIALS_PATH);
    if (file_exists($credentialsPath)) {
        $accessToken = file_get_contents($credentialsPath);
    } else {
        // Request authorization from the user.
        $authUrl = $client->createAuthUrl();
        printf("Open the following link in your browser:\n%s\n", $authUrl);
        print 'Enter verification code: ';
        $authCode = trim(fgets(STDIN));

        // Exchange authorization code for an access token.
        $accessToken = $client->authenticate($authCode);

        // Store the credentials to disk.
        if(!file_exists(dirname($credentialsPath))) {
            mkdir(dirname($credentialsPath), 0700, true);
        }
        file_put_contents($credentialsPath, $accessToken);
        printf("Credentials saved to %s\n", $credentialsPath);
    }
    $client->setAccessToken($accessToken);

    // Refresh the token if it's expired.
    if ($client->isAccessTokenExpired()) {
        $client->refreshToken($client->getRefreshToken());
        file_put_contents($credentialsPath, $client->getAccessToken());
    }
    return $client;
}

/**
 * Expands the home directory alias '~' to the full path.
 * @param string $path the path to expand.
 * @return string the expanded path.
 */
function expandHomeDirectory($path) {
    $homeDirectory = getenv('HOME');
    if (empty($homeDirectory)) {
        $homeDirectory = getenv("HOMEDRIVE") . getenv("HOMEPATH");
    }
    return str_replace('~', realpath($homeDirectory), $path);
}

// Get the API client and construct the service object.
$client = getClient();
$service = new Google_Service_Calendar($client);

?>





<!DOCTYPE html>
<html>
    <head>
        <title>CIS2288 - ASSIGNMENT 4 - PUBLIC GOOGLE CALENDAR</title>
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

        <!-- CUSTOM CSS -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <h2 class="text-center">PUBLIC GOOGLE CALENDAR</h2>

        <div class="row">
            <div class="text-center col-sm-offset-4 col-sm-4 bg-info">
                Group Members: </br>

                <?php
                    foreach($groupMembers as $member) {
                        echo $member.'</br>';
                    }

                ?>

            </div>
        </div>


        <!-- CALENDAR CODE HERE -->

        <!-- SPACER -->
        <div style="height: 50px;"></div>
        <!-- /SPACER -->

        <table style="width: 80%; margin: 0 auto;" class="text-center table-bordered table table-striped table-hover">
            <thead>
                <tr>
                    <th colspan='4'>CALENDAR DATA</th>
                </tr>
                <tr>
                    <th>Event Name</th>
                    <th>Description</th>
                    <th>Location</th>
                    <th>Start Time / End Time</th>
                </tr>
            </thead>
            <tbody>


				<?php
					// Print the next 10 events on the user's calendar.
				$calendarId = 'primary';
				$optParams = array(
				    'maxResults' => 10,
				    'orderBy' => 'startTime',
				    'singleEvents' => TRUE,
				    'timeMin' => date('c'),
				);
				$results = $service->events->listEvents($calendarId, $optParams);

				if (count($results->getItems()) == 0) {
				    $output = "No upcoming events found.";
				} else {

				    foreach ($results->getItems() as $event) {
				        $start = $event->start->dateTime;
				        if (empty($start)) {
				            $start = $event->start->date;
				        }
				        $output = $event->getSummary().'=>'.$start;
				        echo '<tr>'.
				        	 '<td>'.$event->summary.'</td>'.
				        	 '<td>'.$event->description.'</td>'.
				        	 '<td>'.$event->location.'</td>'.
				        	 '<td>'.date("F j, Y, g:i a",strtotime($event->start->dateTime)).' to '.date("g:i a",strtotime($event->end->dateTime)).'</td>'.
				        	 '</tr>';
				    }
				}

				?>



            </tbody>
        </table>

        <br/>

        <img class="calendarImages img-responsive" src="img/calendarView.png" />
        <br/>
        <img class="calendarImages img-responsive"src="img/calendarDetailsView.png" />
    </body>
</html>




