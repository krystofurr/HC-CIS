<? php

/*

################## CIS-2286 Internet Programming Part I PWC ##################
     Author: Christopher Sigouin
     Date: January 29, 2015
     Purpose: Assignment 2
     Dependencies:  style.css
     References: ( mostly for the banner image )

     http://upload.wikimedia.org/wikipedia/commons/a/a3/PEI-flag_contour.png
     http://www.officialpsds.com/images/thumbs/Canadian-Guap-psd5349.png
     http://fla.fg-a.com/flags/maple-leaf.png
     http://cdn.shopify.com/s/files/1/0185/5092/products/persons-0206_large.png?v=1369544013
     http://previews.123rf.com/images/studiom1/studiom11202/studiom1120200389/9033805-tax-magnifying-
     	glass-over-background-with-different-association-terms-vector-illustration.jpg

 */

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

		<form method="post" action="processTaxReturn.php">
			<div class="container">
				<fieldset>
							<label for="firstName">Title:</label>
							<select name="title">
								<option value="">---</option>
								<option value="Mr.">Mr.</option>
								<option value="Mrs.">Mrs.</option>
								<option value="Ms.">Ms.</option>
								<option value="Dr.">Dr.</option>
								<option value="Capt.">Capt.</option>
							</select>
							<br/>
							<label for="firstName">First Name:</label>
							<input type="text" name="firstName" size="20">
							<br/>
							<label for="lastName">Last Name:</label>
							<input type="text" name="lastName" size="20">
							<br/>
							<label for="">Address:</label>
							<input type="text" name="address" size="20">
							<br/>
							<label for="">Postal Code:</label>
							<input type="text" name="postalCode" size="20">
							<br/>
							<label for="">Are you a student?</label>
							<input type="checkbox" name="student">
							<br/>
							<label for="">Total Income:</label>
							<input type="text" name="totalIncome" size="20">
				</fieldset>
			</div>
			<input class="center" type="submit" name="submit">

		</form>
	</body>
</html>