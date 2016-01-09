<!DOCTYPE html>
<!-- 
	################## CIS-2286 Internet Programming Part I PWC ##################
     Author: Christopher Sigouin
     Date: March 3, 2015
     Purpose: Assignment 5
     Dependencies:  mystyle.css

     IMAGE REFERENCES:
     	EMAIL IMAGE - http://tomgow.com/wp/wp-content/uploads/2011/10/bigstock-Email-icon-14464973.png
     	CLIPBOARD IMAGE - https://home.anticsdms.com/html/img/foot_icon_form.png
-->

<?php
	date_default_timezone_set('America/Halifax'); 
	$date = date("F j, Y"); # variable for the time
?>

<html>
	<head>
		<title>The Big Boss Company</title>
		<link rel="stylesheet" type="text/css" href="css/mystyle.css">
	</head>
	<body>
	
	<div id="container">
		<div id="headerContent" class="center">
				<h1>The Big Boss Company</h1>
		</div>
		
		<div id="myForm" class="center textCenter">
			<form method="post" action="processEmail.php">

				<label for="email">Email:</label>
				<input type="text" name="email"/>
	
				<label for="message">Message:</label>
				<textarea name="message"></textarea>
	
				<div class="warning textCenter">You must keep your message to less than 500 characters!</div>
		
				<input class="center" type="submit" value="Send" name="submit"/> 
			</form>
		</div>
		<div id="footer" class="textCenter center"><?php echo $date ?></div>
	</div>
	</body>
</html>