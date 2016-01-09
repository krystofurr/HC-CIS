<?php

/*

################## CIS-2286 Internet Programming Part I PWC ##################
	     Author: Christopher Sigouin
	     Date: February 7, 2015
	     Purpose: Assignment 3
	     Dependencies:  none
	     References: none

FUNCTION LIST SO FAR:

formatCurrency( $theAmount )
isFormFieldInvalid( $element, $checkType )

*/

/**
 * Will return a formatted version of an amount for currency display purposes
 * 
 * @param  [type] $theAmount [The numeric value unformatted]
 * @return [type]            [Returns a formatted string]
 */
function formatCurrency( $theAmount ) {
	return "$".number_format($theAmount, 2);
}

/**
 * Checks all string values that are provided against the value of the form element.
 * Keep in mind when using the function that you are entering values for 
 * what the user SHOULD NOT BE ENTERING. Will return TRUE IF INVALID. FALSE IF VALID
 * 
 * Valid checkTypes - string, numeric, empty, not_empty, isset, is_not_set
 *
 * EXAMPLE - isFormFieldInvalid( $testField, array("string, empty"))
 * 
 * @param  [type]  $element    [The Form Element]
 * @param  [array]  $checkType  [An array that holds the string values of what to check]
 * @return boolean $invalid    [true - element is invalid , false - element is valid]
 */
function isFormFieldInvalid( $element, $checkType )	{
	$invalid = false; 

	foreach($checkType as $value) {
		if( $value === "string"){
			if( !is_numeric($element) ) {
				$invalid = true;
			}	
		}

		if( $value === "numeric"){
			if( is_numeric($element) ) {
				$invalid = true;
			}	
		}

		if( $value === "empty"){
			if( empty($element) ) {
				$invalid = true;
			}	
		}

		if( $value === "not_empty"){
			if( !empty($element) ) {
				$invalid = true;
			}	
		}

		if( $value === "isset"){
			if( isset($element) ) {
				$invalid = true;
			}		
		}

		if( $value === "is_not_set"){
			if( !isset($element) ) {
				$invalid = true;
			}		
		}
	}

	return $invalid;
} # END OF FUNCTION: isFormElementValid



/**
 * displaySingleOrder
 *
 * Prints a table for each order on the page and adds appropriate labels
 * for each as well from the defined $fieldSubHeadings array
 * 
 * @param  [type] $singleOrders [description]
 * @param  [type] $headings     [description]
 * @return [type]               [description]
 */
function displaySingleOrder( $singleOrders, $labels  ) {

	echo "<table class='orderTableView center'>\n";
	for($i = 0; $i < count($singleOrders); ++$i ) {
		if( $i == 0 ) {
			echo "<tr><td class='orderHeading' colspan='2'>$singleOrders[$i]</td></tr>\n";
		} else {
			echo "<tr><td class='orderLabel'>$labels[$i]<td>$singleOrders[$i]</td></tr>\n";		
		}
			
	}
	echo "</table>\n\n";
}

/**
 *  processOrderList
 * 
 *  The idea of this function is to take the full array of data that is gained from 
 *  the text file, assign each value to another array's element ( singleOrderFields )
 *  until you reach 13 ( b/c there are 13 pieces of data per order ).  Once 13 is
 *  reached display the singleOrderFields array, reset the array ( including a local counter )
 *  and start again.  The index of the full array does not change.  It keeps going
 *  but the function adds each of it's value in increments of 13 until it resets the 
 *  singleOrderFields array again.
 * 
 * @param  [type] $fullArray    [description]
 * @param  [type] $singleOrders [description]
 * @param  [type] $headings     [description]
 * @return [type]               [description]
 */
function processOrderList( $fullArray, $headings ) {
	$singleOrderCount = 0;
	$singleOrders = []; # An array for a single order

	// Loop through the entire order array
	for($i = 0; $i <= count($fullArray); ++$i) {

		// If you reach the end of an order, display it
		if( $singleOrderCount == 13 )	{
			displaySingleOrder( $singleOrders, $headings );	

			// If there are more orders left in the array to work...
			if( $i < count($fullArray) ) {	
			
				// Reset the array
				$singleOrders = [];
				// Reset the counter
				$singleOrderCount = 0;
				
				// Store the first value into the singleOrderFields array	
				$singleOrders[$singleOrderCount] = $fullArray[$i];
				// echo "Started a new array with first value: ". $fullArray[$i]."<br/>";
				++$singleOrderCount;
			}
		

		} else {
			// Store the elements into the singleOrderFields array
			$singleOrders[$singleOrderCount] = $fullArray[$i];
			// echo "Stored a value in the array: ". $fullArray[$i]."<br/>";
			// echo "singleOrderCount is: ".$singleOrderCount;
			++$singleOrderCount;
		}
	} 
}


/**
 *  processOrderList
 * 
 *  To display the most recent order on the processVeggie.php page
 * 
 * @param  [type] $fullArray    [description]
 * @param  [type] $singleOrders [description]
 * @param  [type] $headings     [description]
 * @return [type]               [description]
 */
function processOrder( $fullArray, $headings ) {
	$singleOrderCount = 0;
	$singleOrders = []; # An array for a single order

	// Loop through the entire order array
	for($i = 0; $i <= count($fullArray); ++$i) {

		// If you reach the end of an order, display it
		if( $singleOrderCount == 13 )	{
			displaySingleOrder( $singleOrders, $headings );	
			break; # Stop processing the list.  We just want the most recent order
			
		} else {
			// Store the elements into the singleOrderFields array
			$singleOrders[$singleOrderCount] = $fullArray[$i];
			++$singleOrderCount;
		}
	} 
}


?>