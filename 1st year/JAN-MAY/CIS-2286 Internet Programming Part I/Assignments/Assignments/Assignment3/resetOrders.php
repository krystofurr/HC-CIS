<!--

################## CIS-2286 Internet Programming Part I PWC ##################
     Author: Christopher Sigouin
     Date: February 7, 2015
     Purpose: Assignment 3
     Dependencies:  style.css, navMenu.css, configMain.php, navMenu.php
     References: 

 	BANNER IMAGE: http://www.freeclipartpics.com/vegetable-clipart-images/

 	NOTE: I did the reset page to give an additional prompt for the user for
 		  safety concerns.

-->

<?php

include "toolbox/configMain.php";
$page = "reset"; # Used with navMenu.php ( Great idea btw Don :P )

?>

<!DOCTYPE html>
<html>
	<head>
		<title>Reset Orders Page</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/navMenu.css">
	</head>
	
	<body>
	<div id="container" class="center">
			<h1>Organic Veggies! Come get em!</h1>
			<?php include "toolbox/navMenu.php"; ?>
	</div>
	<div class="orderResults center">

	<?php

	// Reset the page only if the user chooses 'YES'
	if( isset($_POST['yes']) ) {


		@ $fp = fopen($myDir.$myFile, "w");
		$isLocked = flock($fp, LOCK_EX); # Writing - No Share ( Prevent any other content from being added )
		if(!$isLocked){
			echo "<p>Could not lock the file for writing!</p>";
			exit;	
		}

		if (!$fp) {
			echo "Could not open the file to remove all orders!  Sorry about that! :\<br/>";
			exit;
		} else
			echo "File is now emptied! :D";	

		$isUnlocked = flock($fp, LOCK_UN); # Unlock the file
		if(!$isUnlocked){
			echo "<p>Could not unlock the file!</p>";
			exit;	
		}

	// Go back to orderVegetables.php if user chooses 'NO'
	} else if( isset($_POST['no']) ) {

		header("location:orderVegetables.php");

	// Check to see if a file exists, then ask the user what they want to do
	} else {

		if(file_exists($myDir.$myFile)) {
			if(filesize($myDir.$myFile) != 0) {
				echo "Are you sure you want to delete the orders in veggie-orders.txt?"
				?>
				<div class="resetFormLayout">
				<form method="post" action="resetOrders.php">
					<table class="center">
						<tr>
							<td><input type="submit" name="yes" value="YES"/></td>
							<td><input type="submit" name="no" value="NO"/></td>
						</tr>
					</table>
				</form>
				</div>
				<?php
			} else {
				echo "There are no orders to delete! Go back to <a href=\"orderVegetables.php\">ORDER PAGE</a>";
			}
		} else {

			echo "<p>A file does not exist yet to view!  You will have to create an order first!</p>";

		} // END: if(file_exists($myDir.$myFile)) {
	} // END: if( isset($_POST['yes']) ) {

?>
	</div>
	</body>
</html>