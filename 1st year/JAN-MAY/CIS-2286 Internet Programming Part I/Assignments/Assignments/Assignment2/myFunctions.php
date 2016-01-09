<?php

/*

################## CIS-2286 Internet Programming Part I PWC ##################
	     Author: Christopher Sigouin
	     Date: January 29, 2015
	     Purpose: Assignment 2
	     Dependencies:  none
	     References: none

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
 * Keep in mind when using the function that you are entering string values for 
 * what the user SHOULD NOT BE ENTERING. Will return TRUE IF INVALID. FALSE IF VALID
 * 
 * Valid checkTypes - string, numeric, empty, not_empty, isset, is_not_set
 * 
 * @param  [type]  $element    [The Form Element]
 * @param  [array]  $checkType  [An array that holds the string values of what to check]
 * @return boolean $invalid    [true - element is invalid , false - element is valid]
 */
function isFormFieldInvalid( $element, $checkType )	{
	$invalid = false; 
	$numberOfTypes = count($checkType);

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


?>