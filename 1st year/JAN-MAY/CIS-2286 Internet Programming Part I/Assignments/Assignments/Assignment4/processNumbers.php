<?php

/*
################## CIS-2286 Internet Programming Part I PWC ##################
	Author: Christopher Sigouin
	Date: February 18, 2015
	Purpose: Assignment 4
	Dependencies: mystyle.css

*/
define('DEBUG', false); # For debugging purposes

$DOCUMENT_ROOT = $_SERVER['DOCUMENT_ROOT'];	
// Pull the information from the 'scores.txt' file and store in an array
$scores = file("$DOCUMENT_ROOT/scores.txt");
// Ensure the array is completely numeric ( Have to use 'Pass by Reference' to resubmit the new type )
foreach($scores as &$value) {
	$value = floatval($value);
}
// Associative array to display the output
$answerArray = array( 'Valid number count'=>0, 'Maximum number'=>0, 'Minimum number'=>0, 'Average'=>0 ); 

// Sort the numbers ascending
sort($scores, SORT_NUMERIC);

// Find the maximum number
$answerArray['Maximum number'] = end($scores);

// Reset the pointer
reset($scores);

// Find the minimum number
$answerArray['Minimum number'] = current($scores);

// Reset the pointer
reset($scores);

/* 

  If a number is less than 0 ignore it
  If a number is greater than 100 ignore it
  Find the total number of valid numbers

*/

$validNumbers = 0;
$total = 0;
foreach($scores as $value) {
	if(DEBUG)
			echo "Value is a: ". gettype($value);
	if($value >= 0 && $value <= 100) {
		++$validNumbers; # Count the number of valid numbers
		$total += $value; # Add up all the valid numbers
	}
}

$answerArray['Valid number count'] = $validNumbers; 

// Calculate the average of all valid numbers
$answerArray['Average'] = number_format(($total / $validNumbers), 2);

?>

<!DOCTYPE html>
<html>
	<head>
		<title>ASSIGNMENT 4 - CHRISTOHER SIGOUIN - CIS-2286 Internet Programming Part I PWC</title>
		<style>
			body { /* Formatting for all elements between <body> tags */
				font-size: 30px;
				color: #fff;
				background-color: #2C3539; /* dark grey? */
			}

			#container { /* Attached to single DIV on the page */
				width: 600px;
				border: solid green 3px;
				padding: 20px;
				background-color: #000;
				margin: 0 auto;
			}
		</style>

	</head>
	<body>
		<div id="container">
		<?php

			// Display output
			foreach ($answerArray as $key => $value) {
				echo $key.": ".$value."<br />";
			}

		?>
		</div>
	</body>
</html>