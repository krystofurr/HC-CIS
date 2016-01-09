<?php

/*

	################## CIS-2286 Internet Programming Part I PWC ##################
     Author: Christopher Sigouin
     Date: January 29, 2015
     Purpose: Assignment 2
     Dependencies:  taxReturn.php, myFunctions.php, style.css
     References:

     http://upload.wikimedia.org/wikipedia/commons/a/a3/PEI-flag_contour.png
     http://www.officialpsds.com/images/thumbs/Canadian-Guap-psd5349.png
     http://fla.fg-a.com/flags/maple-leaf.png
     http://cdn.shopify.com/s/files/1/0185/5092/products/persons-0206_large.png?v=1369544013
     http://previews.123rf.com/images/studiom1/studiom11202/studiom1120200389/9033805-tax-magnifying-
     	glass-over-background-with-different-association-terms-vector-illustration.jpg

 */

include "myFunctions.php";
$debugging = false; # For text output statements on parts of the script

if( isset($_POST['submit']) ) {

?>

	<!DOCTYPE html>
	<html>
		<head>
			<title>2014 PEI Income Tax Return Form (For residents of PEI only)</title>
			<link rel="stylesheet" type="text/css" href="style.css">
		</head>
		<body>
			<div id="header">
				<h1>2014 PEI Income Tax Return Form</h1>
				<h2>(For residents of PEI only)</h2>
			</div>
		</body>
	</html>

	<?php

	// Defined tax rate at 30%
	define('TAX_RATE', .30);
	define('NON_STUDENT_EXEMPT_AMOUNT', 14995);
	define('STUDENT_EXEMPT_AMOUNT', 21000); 

	// Store the form values
	$title = $_POST['title'];
	$firstName = $_POST['firstName'];
	$lastName = $_POST['lastName'];
	$address = $_POST['address']; 
	$postalCode = $_POST['postalCode']; 
	$totalIncome = $_POST['totalIncome'];

	if( $debugging ) {
		var_dump($_POST);
	}

	// Error check the form values
	$errors = [];

	if( empty($title) ) {
		array_push($errors, "You did not choose your title!");
	}

	$invalidStatus = isFormFieldInvalid($firstName, array("numeric", "empty"));
	if($invalidStatus){
		array_push($errors, "'First Name' field is not valid!");
	}
	$invalidStatus = isFormFieldInvalid($lastName, array("numeric", "empty"));
	if($invalidStatus){
		array_push($errors, "'Last Name' field is not valid!");
	}
	$invalidStatus = isFormFieldInvalid($address, array("empty"));
	if($invalidStatus){
		array_push($errors, "'Address' field is not valid!");
	}
	$invalidStatus = isFormFieldInvalid($postalCode, array("empty"));
	if($invalidStatus){
		array_push($errors, "'Postal Code' field is not valid!");
	}
	$invalidStatus = isFormFieldInvalid($totalIncome, array("string", "empty"));
	if($invalidStatus){
		array_push($errors, "'Total Income' field is not valid!");
	}

	// Based on the errors...display what's wrong or display the output
	if( count($errors) > 0) {
		echo "<div class='container'>";
		foreach($errors as $output){
			echo $output."<br/>";
		}
		echo "<a href=\"taxReturn.php\">CLICK HERE TO GO BACK</a>".
			 "</div>";

	} else {

		// Setup the time, date, and year for Atlantic Canada.
		date_default_timezone_set('America/Halifax'); 
		$timeDateYearString = date("g:i A T | F j | Y"); 
		

		/*
			Calculate Tax and Set Student Status
			( $14,995 exempt NON-STUDENT, $21,000 exempt STUDENT )
		*/
	
		// If a student...
		if( isset($_POST['student'])) {
			$studentStatus = "Full Time Student";
			if( $totalIncome > STUDENT_EXEMPT_AMOUNT){
				$totalTaxableIncome = $totalIncome - STUDENT_EXEMPT_AMOUNT;
				$taxDeductionAmount = $totalTaxableIncome * TAX_RATE;
				$totalIncomeAfterTax = $totalIncome - $taxDeductionAmount;
			} else {
				// Incase they enter $21,000 or less
				$totalTaxableIncome = 0;
				$taxDeductionAmount = 0;
				$totalIncomeAfterTax = $totalIncome;
			}
		// If a non-student
		} else {
			$studentStatus = "Non - Student";
			if( $totalIncome > NON_STUDENT_EXEMPT_AMOUNT ){
				$totalTaxableIncome = $totalIncome - NON_STUDENT_EXEMPT_AMOUNT;
				$taxDeductionAmount = $totalTaxableIncome * TAX_RATE;
				$totalIncomeAfterTax = $totalIncome - $taxDeductionAmount;
			} else {
				// Incase they enter $14,995 or less
				$totalTaxableIncome = 0;
				$taxDeductionAmount = 0;
				$totalIncomeAfterTax = $totalIncome;
			}	
		}

		?>
		
		<!-- HTML - MAIN OUTPUT -->
		<div class="container">
			<div><?php echo $timeDateYearString ?></div>
			<br/>
			<div><span class="heading">Title:</span> <?php echo $title ?></div>
			<div><span class="heading">First Name:</span> <?php echo $firstName ?></div>
			<div><span class="heading">Last Name:</span> <?php echo $lastName ?></div>
			<div><span class="heading">Address:</span> <?php echo $address ?></div>
			<div><span class="heading">Postal Code:</span> <?php echo $postalCode ?></div>
			<div><span class="heading">Student Status:</span> <?php echo $studentStatus ?></div>
			<div><span class="heading">Total Income:</span> <?php echo formatCurrency($totalIncome) ?></div>
			<br/>
			<div><span class="heading">Tax Rate:</span> <?php echo (TAX_RATE * 100). "%"; ?></div>
			<div><span class="heading">Tax Deduction:</span> <?php echo formatCurrency($taxDeductionAmount); ?></div>
			<div><span class="heading">Total Income(After Tax):</span> <?php echo formatCurrency($totalIncomeAfterTax); ?></div>
			<br/>
			<a href="taxReturn.php">CLICK HERE TO PROCESS ANOTHER?</a>
		</div>

		<?php	

/*
	Tax percentage [use 30% as a flat tax and store it in a defined constant[
Amount of tax deducted [include dollar sign and two decimal places - that is, format for currency[
Amount of income after tax [format this for currency[ 
Their title, name, address, and postal code.
The time, date, and year for Atlantic Canada.
/15 Business Rules [!![
Only tax income greater than $14,995.  The first $14,995 is exempt.
If the user is a fulltime student, only tax income greater than $21,000.  The first $21,000 is exempt from tax.
/10 Comments, Code Formatting, Submission Packaging, Proper HTML/CSS
Total: /70
*/


	}

} else {

	// Go back to the main page
	header("location:taxReturn.php");
}

?>

