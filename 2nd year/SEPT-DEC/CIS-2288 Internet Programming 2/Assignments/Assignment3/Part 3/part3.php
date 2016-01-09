<?php

/*

 ____            _     _____           _____                            _
|  _ \ __ _ _ __| |_  |___ /          |  ___|__  _ __ ___  ___ __ _ ___| |_
| |_) / _` | '__| __|   |_ \   _____  | |_ / _ \| '__/ _ \/ __/ _` / __| __|
|  __/ (_| | |  | |_   ___) | |_____| |  _| (_) | | |  __/ (_| (_| \__ \ |_
|_|   \__,_|_|   \__| |____/          |_|  \___/|_|  \___|\___\__,_|___/\__|


Program name:       Assignment 3 - Part 3
    Author:             Christopher Sigouin
    Version:            1.0
    Description:        Using PHP to pull in XML and style ( No XSLT involved )
    Dependencies:       n/a
    Database file:      n/a
    Change History:     2015.11.04 Original version by CJS

*/

$xmlObject = new SimpleXMLElement("forecast.xml", 0, TRUE);
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Assignment 3 - Part 3</title>
        <style>
            table {
                width: 50%;
                border-collapse: separate;
            }

            table, td {
                border: 1px solid black;
            }

            td {
                vertical-align: text-top;
            }

            img { /* Images needed to be scaled down a little */
                max-width: 100px; /* If changed to a percentage, the output is strange */
                height: auto;
            }

            .degrees {
                font-style: italic;
            }

            .highLowTemps { /* Used for High and Low Temps */
                margin-bottom: 20px;
            }

            .grayTopBorder { /* Provides a gray divider between day elements */
                padding-top: 10px;
                border-top: 3px solid #D7D7D7;
            }
        </style>
	</head>
	<body>
        <h1>Forecast for <?php echo $xmlObject->location->city.', '.$xmlObject->location->province.' ,'.$xmlObject->location->country; ?></h1>
        <h2 class="degrees">Degrees in <?php echo $xmlObject->location->degrees; ?></h2>
        <h2>Five day forecast</h2>
    	<table>
    		<tr>
                <?php
                    // Initialize variables for output
                    $date = $conditionImage = $highTemp = $lowTemp = $description = '';
                    $totalDailyElements = $tempHighTotalCount = $tempLowTotalCount = 0;
                    // Get a count of all child elements and retrieve each 'day' element
                    $totalDailyElements = count($xmlObject->daily->children());
                    $dayElement = $xmlObject->xpath("daily/day/*");
                    // Loop through each set and output on the last child element
                    foreach($dayElement as $dayValue) {
                        switch($dayValue->getName()) {
                            case 'date':
                                $date = $dayValue;
                                break;
                            case 'high':
                                $highTemp += intval($dayValue);
                                $tempHighTotalCount = $highTemp;
                                break;
                            case 'low':
                                $lowTemp += intval($dayValue);
                                $tempLowTotalCount = $lowTemp;
                                break;
                            case 'condition':
                                // Choose image based on condition
                                switch($dayValue) {
                                    case "sun-cloud":
                                        $conditionImage = '<img src="../Part 2/images/sun-cloud.jpg" />';
                                        break;
                                    case "sun":
                                        $conditionImage = '<img src="../Part 2/images/sun.jpg" />';
                                        break;
                                    case "overcast":
                                        $conditionImage = '<img src="../Part 2/images/overcast.jpg" />';
                                        break;
                                    case "rain":
                                        $conditionImage = '<img src="../Part 2/images/rain.jpg" />';
                                        break;
                                    case "snow":
                                        $conditionImage = '<img src="../Part 2/images/snow.jpg" />';
                                        break;
                                }
                                break;
                            case 'description':
                                $description = $dayValue;
                                $output =   '<td>'.$date.'<br/>'.
                                            $conditionImage.'</br>'.
                                            '<div class="highLowTemps">High: '.$highTemp.'<br/>Low: '.$lowTemp.'</div>'.
                                            '<div class="grayTopBorder">'.$description.'</div></td>';
                                echo $output;
                                break;
                        } // END: SWITCH
                    } // END: FOREACH
                ?>
    		</tr>
    	</table>
        <?php echo 'Average High: '.($tempHighTotalCount/$totalDailyElements).' Average Low: '.($tempLowTotalCount/$totalDailyElements).''; ?>
	</body>
</html>

