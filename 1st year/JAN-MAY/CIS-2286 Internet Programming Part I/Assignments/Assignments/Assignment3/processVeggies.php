<!--

################## CIS-2286 Internet Programming Part I PWC ##################
     Author: Christopher Sigouin
     Date: February 7, 2015
     Purpose: Assignment 3
     Dependencies:  style.css, navMenu.css, navMenu.php, myFunctions.php, configMain.php
     References: 

 	BANNER IMAGE: http://www.freeclipartpics.com/vegetable-clipart-images/

-->

<!DOCTYPE html>
<html>
	<head>
		<title>Process Veggies Order Page</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/navMenu.css">
	</head>
	
	<body>
	<div id="container" class="center">
			<h1>Organic Veggies! Come get em!</h1>
			<?php include "toolbox/navMenu.php"; ?>
	</div>

	<?php


	include "toolbox/myFunctions.php";
	include "toolbox/configMain.php";

	$page = "";

	if( isset($_POST['submit']) ) {

		//Get the form values
		$veggiePotatoes = $_POST['veggiePotatoes'];
		$veggieCarrots = $_POST['veggieCarrots'];
		$veggieSprouts = $_POST['veggieSprouts'];
		$veggieCauliflower = $_POST['veggieCauliflower'];
		$firstName = $_POST['firstName'];
		$lastName = $_POST['lastName'];
		$email = $_POST['email'];
		$phoneNumber = $_POST['phoneNumber'];

		if( $debug ) {
			var_dump($_POST);
		}

		// ONLY APPLIES TO VEGETABLES...if fields are empty set to 0
		if(isFormFieldInvalid($veggiePotatoes, array("empty")))
			$veggiePotatoes = 0;
		if(isFormFieldInvalid( $veggieCarrots, array("empty") ) )
			$veggieCarrots = 0;
		if(isFormFieldInvalid( $veggieSprouts, array("empty") ) )
			$veggieSprouts = 0;
		if(isFormFieldInvalid( $veggieCauliflower, array("empty") ) )
			$veggieCauliflower = 0;

		// Error check the form values
		$errors = [];
		if(isFormFieldInvalid($veggiePotatoes, array("string")))
			array_push($errors, "Pototaes entry is invalid");
		if(isFormFieldInvalid( $veggieCarrots, array("string") ) )
			array_push($errors, "Carrots entry is invalid");
		if(isFormFieldInvalid( $veggieSprouts, array("string") ) )
			array_push($errors, "Sprouts entry is invalid");
		if(isFormFieldInvalid( $veggieCauliflower, array("string") ) )
			array_push($errors, "Cauliflower entry is invalid");
		if(isFormFieldInvalid( $firstName, array("numeric", "empty") ) )
			array_push($errors, "Firstname is invalid");
		if(isFormFieldInvalid( $lastName, array("numeric", "empty") ) )
			array_push($errors, "Lastname is invalid");
		if(isFormFieldInvalid( $email, array("empty") ) )
			array_push($errors, "Email is invalid");
		if(isFormFieldInvalid( $phoneNumber, array("string", "empty") ) )
			array_push($errors, "Phone number is invalid");
		
		// Start the DIV for the order results page to keep everything formatted
		?><div class="orderResults center"><?php

		// Display errors if any...
		if(count($errors) > 0) {
			
			foreach($errors as $theError) {
				echo $theError. "<br/>";
			}
			echo "<br/>There were some problems.  Please re-enter the order by clicking <a href=\"orderVegetables.php\">HERE</a>";
			
		} else {

		if($debug)
			echo " <br/>the directory is : ".$myDir."<br/>";

		//Make sure the directory is created
		if (!is_dir($myDir)) {
			if($debug)
				echo "There is no orders directory<br/>";
		    mkdir($myDir, 0777, true); // true for recursive create
		}

		// OPEN THE FILE ( create and append )
		@ $fp = fopen($myDir.$myFile, 'ab');
		$isLocked = flock($fp, LOCK_EX); # Writing - No Share
		if(!$isLocked){
			echo "<p>Could not lock the file for reading!</p>";
			exit;	
		}

		//Friendly error for FOPEN
		if (!$fp) {
			echo "Couldn't open the file! Panic!<br/>";
			exit;
		}

		// Calculate the cost
		$totalBeforeTax = ($veggiePotatoes * PRICE_POTATOES) + ($veggieCarrots * PRICE_CARROTS) + 
						  ($veggieSprouts * PRICE_SPROUTS) + ($veggieCauliflower * PRICE_CAULIFLOWER);

		// If the cost equals 0, meaning they didn't enter anything to order, but did enter other details
		if ($totalBeforeTax == 0){

			echo "<p>You didn't order any vegetables?  Do you not like vegetables? ".
				 "<br/><a href=\"orderVegetables.php\">BACK TO ORDER PAGE</a></p>";

		} else {

			// If the totalCost is less than or equal to the qualifier for free delivery...
			if( $totalBeforeTax > DELIVERY_QUALIFIER) {
				$displayDeliveryCost = formatCurrency(DELIVERY_COST); # Display purposes
				$deliveryCost = DELIVERY_COST;	
			} else {
				$displayDeliveryCost = "FREE!";
				$deliveryCost = 0;
			}

		    $totalWithDelivery = ($totalBeforeTax + $deliveryCost);
			$totalTax = ($totalWithDelivery * TAX_RATE);
			$finalTotal = $totalWithDelivery + $totalTax;

			// Order String - FOR FILE INPUT ( 13 ROWS )
			$clientOrder = $orderTimeAndDate."\t".
			               ($veggiePotatoes * QUANTITY_POTATOES)."\t".
			               ($veggieCarrots * QUANTITY_CARROTS)."\t".
			               ($veggieSprouts * QUANTITY_SPROUTS)."\t".
			               ($veggieCauliflower * QUANTITY_CAULIFLOWER)."\t".
			               formatCurrency($totalBeforeTax)."\t".
			               $displayDeliveryCost."\t".
			               formatCurrency($totalTax)."\t".
			               formatCurrency($finalTotal)."\t".
			               $firstName."\t".
			               $lastName."\t".
			               $email."\t".
			               $phoneNumber."\t";

			//Write the order to the text file
			echo fwrite($fp, $clientOrder) ? '<p>Thank you! Your order has been saved!<br/>'.
											 'You will be contacted within the next business day.<br/></p>' : 
											 '<p>There was an issue saving your order!</p>';

			$isUnlocked = flock($fp, LOCK_UN);
			if(!$isUnlocked){
				echo "<p>Could not unlock the file!</p>";
				exit;
			}

	        fclose($fp);

		    /*
		    	
		    	I chose to re-open the file again and display the first order from the text file

		     */
			@ $fp = fopen($myDir.$myFile, 'rb');
			$isLocked = flock($fp, LOCK_SH); # Reading - Share
			if(!$isLocked){
				echo "<p>Could not lock the file for reading!</p>";
				exit;	
			}

			//Friendly error for FOPEN
			if (!$fp) {
				echo "<p>Couldn't open the file! Panic!</p>";
				exit;
			}			        

			$fileSize = filesize($myDir.$myFile);               	
			$orderLine = [];
			$orderLine = fgetcsv($fp, $fileSize, "\t");

			if( $debug ) {
				echo "There are: ". count($orderLine)." elements<br/>";
				var_dump($orderLine);

			}

			// Main method to display the entry
			processOrder($orderLine, $fieldSubHeadings);

			$isUnlocked = flock($fp, LOCK_UN);
			if(!$isUnlocked){
				echo "<p>Could not unlock the file!</p>";
				exit;
			}

	        fclose($fp);
		}
	}
	?></div><?php

	} else {

		header("location:orderVegetables.php");

	} // END: if( isset($_POST['submit']) ) {
	?>
	</body>
</html>
