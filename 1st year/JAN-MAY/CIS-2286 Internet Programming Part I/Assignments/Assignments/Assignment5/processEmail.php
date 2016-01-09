<?php

/* 
	################## CIS-2286 Internet Programming Part I PWC ##################
     Author: Christopher Sigouin
     Date: March 3, 2015
     Purpose: Assignment 5
     Dependencies: mystyle.css
*/
	error_reporting(E_ALL);
	define('DEBUG', false); # Debugging purposes
	define('REGEX_EMAIL', "/^[a-zA-Z0-9_\-.]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-.]+$/" ); # RegEx pattern for email
	define('MESSAGE_CHAR_LIMIT', 500); # Message Limit
	include "toolbox/myFunctions.php";

?>
	<!DOCTYPE html>
	<html>
		<head>
			<title>Process Email</title>
			<link rel="stylesheet" type="text/css" href="css/mystyle.css">
		</head>
		<body>
			<div id="container">
				<div id="headerContent" class="center">
						<h1>The Big Boss Company</h1>
				</div>
<?php
	if(isset($_POST['submit'])) {

		// Get the form data and trim whitespace
		$email = trim($_POST['email']);
		$message = trim($_POST['message']);
		$errors = []; // Error array

		// Validate the form fields for empty, numeric and RegEx pattern ( Email )
		if(isFormFieldInvalid( $email, array('numeric', 'empty')) || !preg_match(REGEX_EMAIL, $email) ) {
			$errors[] = 'Email address is not valid!';
		}
		if(isFormFieldInvalid( $message, array('empty'))) {
			$errors[] = 'Message is empty!';
		}

		// Validate for the 500 character message limit ( 1 - 500 inclusive )
		$numberOfCharacters = strlen($message);

		$charOverLimit = $numberOfCharacters - MESSAGE_CHAR_LIMIT;
		if($numberOfCharacters > MESSAGE_CHAR_LIMIT )
			$errors[] = 'Your message has <span class="fail">'. $charOverLimit. '</span> characters over the '. MESSAGE_CHAR_LIMIT. 
		                ' character limit!';

		if(count($errors) > 0) {
			echo '<div class="textCenter">';
			foreach($errors as $errorType) {
				echo '<p>'.$errorType. '</p>';
			}
			echo '<br/><p>Please review your entry <a href="javascript:history.back()">HERE</a></p></div>';
		} else {

			if(DEBUG)
				var_dump($_POST);
			// Display the message will be sent!
			echo '<p class="textCenter">Your message is acceptable and will be sent to the appropriate department.  
			     Thank you!</p>';
		}
?>
			</div> <!-- END: <div id="container"> -->
		</body>
	</html>

<?php
		
	} else {

		header("location:emailForm.php");
	}

?>
