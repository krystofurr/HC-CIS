<?php

/*

################## CIS-2286 Internet Programming Part I PWC ##################
	 Author: Christopher Sigouin
	 Date: February 7, 2015
	 Purpose: Assignment 3
	 Dependencies:  style.css, navMenu.css, configMain.php, myFunctions.php, navMenu.php
	 References: See below...

 	BANNER IMAGE: http://www.freeclipartpics.com/vegetable-clipart-images/
 */

include "toolbox/configMain.php";
include "toolbox/myFunctions.php";

$page = "order"; # Used with navMenu.php ( Great idea btw Don :P )

?>

<!DOCTYPE html>
<html>
	<head>
		<title>Order Vegetables Page</title>
		<link rel ="stylesheet" type="text/css" href="css/style.css">
		<link rel ="stylesheet" type="text/css" href="css/navMenu.css">
	</head>
	<body>
		<div id="container" class="center">
			<h1>Organic Veggies! Come get em!</h1>
			<?php include "toolbox/navMenu.php"; ?>
		</div>

		<div class="formLayout center">
			<form method="post" action="processVeggies.php">
				<fieldset>

					<label>hiddy hoooo blah blah</label>
					<input type="submit" name="submit" value="Submit Order"/><br/>
				</fieldset>
			</form>
		</div>
	</body>
</html>