<?php

/*

################## CIS-2286 Internet Programming Part I PWC ##################
	 Author: Christopher Sigouin
	 Date: February 7, 2015
	 Purpose: Assignment 3
	 Dependencies:  None

	 This config page should allow for easy change of the quantity for selling,
	 the pricing, file access and other constants throughout the entire site.

*/

$debug = false; # For debugging purposes

// Price for Quantity ($)
define('PRICE_POTATOES', 5);
define('PRICE_CARROTS', 2.75); 
define('PRICE_SPROUTS', 3); 
define('PRICE_CAULIFLOWER', 3.75); 

// Quantity for Price. 
define('QUANTITY_POTATOES', 5); # lbs
define('QUANTITY_CARROTS', 3); # lbs
define('QUANTITY_SPROUTS', 1); # lbs
define('QUANTITY_CAULIFLOWER', 1); # each head

define('DELIVERY_QUALIFIER', 50); # Anything over $50 is FREE. Otherwise it's $5
define('TAX_RATE', .15); # 15%
define('DELIVERY_COST', 5); # $5 Delivery Cost

define('ORDER_SIZE', 16); # Number of array elements in an order

// Setup the time, date, and year for Atlantic Canada.
date_default_timezone_set('America/Halifax'); 
$orderTimeAndDate = date("g:i A T | F j | Y");

// File access variables
$DOCUMENT_ROOT = $_SERVER['DOCUMENT_ROOT'];
$myDir = "$DOCUMENT_ROOT/../orders/";
$myFile = "veggie-orders.txt";

// Labels for a single order table
$fieldSubHeadings = array("", "POTATOES (lbs): ", "CARROTS (lbs): ", "SPROUTS (lbs): ", "CAULIFLOWER (units): ", "TOTAL COST( B4 TAX & DEL ): ",
						  "DELIVERY COST: ", "TAX RATE (".(TAX_RATE * 100)."%): ", "TOTAL COST( AFTER TAX & DEL ): ", "FIRSTNAME", "LASTNAME",
						  "EMAIL", "PHONE NUMBER");

?>

