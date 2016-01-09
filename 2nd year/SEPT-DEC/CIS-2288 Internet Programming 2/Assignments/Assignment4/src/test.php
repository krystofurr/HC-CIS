<?php
    require __DIR__ . '/vendor/autoload.php';

    define('APPLICATION_NAME', 'CIS2288 - Assignment4 - Public Google Calendar');
	define('CREDENTIALS_PATH', '~/.credentials/calendar-php-quickstart.json');
	define('CLIENT_SECRET_PATH', '/home/csigouin/.credentials/client_secret_web.json');

    session_start();

    // ********************************************************  //
    // Get these values from https://console.developers.google.com
    // Be sure to enable the Analytics API
    // ********************************************************    //
    $accessData = json_decode(file_get_contents(CLIENT_SECRET_PATH), true);

    $client_id = $accessData['web']['client_id'];
    $client_secret = $accessData['web']['client_secret'];
    $redirect_uri = $accessData['web']['redirect_uris'][0];

    $client = new Google_Client();
    $client->setApplicationName(APPLICATION_NAME);
    $client->setClientId($client_id);
    $client->setClientSecret($client_secret);
    $client->setRedirectUri($redirect_uri);
    $client->setAccessType('offline');   // Gets us our refreshtoken

    $client->setScopes(array('https://www.googleapis.com/auth/calendar.readonly'));


    //For loging out.
    if (isset($_GET['logout'])) {
	unset($_SESSION['token']);
    }


    // Step 2: The user accepted your access now you need to exchange it.
    if (isset($_GET['code'])) {

	$client->authenticate($_GET['code']);
	$_SESSION['token'] = $client->getAccessToken();
	$redirect = 'http://' . $_SERVER['HTTP_HOST'] . $_SERVER['PHP_SELF'];
	header('Location: ' . filter_var($redirect, FILTER_SANITIZE_URL));
    }

    // Step 1:  The user has not authenticated we give them a link to login
    if (!isset($_SESSION['token'])) {

	$authUrl = $client->createAuthUrl();

	print "<a class='login' href='$authUrl'>Connect Me!</a>";
    }


    // Step 3: We have access we can now create our service
    if (isset($_SESSION['token'])) {
	$client->setAccessToken($_SESSION['token']);
	print "<a class='logout' href='http://csigouin.hccis.info/Assignment4/test.php?logout=1'>LogOut</a><br>";

	$service = new Google_Service_Calendar($client);

	$calendarList  = $service->calendarList->listCalendarList();;

	while(true) {
		foreach ($calendarList->getItems() as $calendarListEntry) {

			echo $calendarListEntry->getSummary()."<br>\n";


			// get events
			$events = $service->events->listEvents($calendarListEntry->id);


			foreach ($events->getItems() as $event) {
			    echo "-----".$event->getSummary()."<br>";
			}
		}
		$pageToken = $calendarList->getNextPageToken();
		if ($pageToken) {
			$optParams = array('pageToken' => $pageToken);
			$calendarList = $service->calendarList->listCalendarList($optParams);
		} else {
			break;
		}
	}
    }
?>