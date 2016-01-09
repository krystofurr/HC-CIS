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
 * If you are looking for a way to count the total number of times a specific value appears in array, 
 * use this function
 * @param  [type] $match [description]
 * @param  [type] $array [description]
 * @return [type]        [description]
 */
function array_value_count ($match, $array) 
{ 
    $count = 0; 
    
    foreach ($array as $key => $value) 
    { 
        if ($value == $match) 
        { 
            $count++; 
        } 
    } 
    
    return $count; 
} 

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
 * Checks all string values that are provided against the value of the form field.
 * Keep in mind when using the function that you are entering string values for 
 * what the user SHOULD NOT BE ENTERING. Will return TRUE IF INVALID. FALSE IF VALID
 * 
 * Valid checkTypes - string, numeric, empty, not_empty, isset, is_not_set
 * 
 * @param  [type]  $field    [The Form field]
 * @param  [array]  $checkType  [An array that holds the string values of what to check]
 * @return boolean $invalid    [true - field is invalid , false - field is valid]
 */
function verifyFormField($fieldType, $field, $checkType, &$errorArray )	{
	$invalid = false; 

		// Cycle through each type to check against
		foreach($checkType as $value) {

			if( $value === "empty"){
				if( empty($field) ) {
					$invalid = true;
					$errorArray[] = $fieldType.' cannot be empty!';
				}	
			}

			if( $value === "string"){
				if( !is_numeric($field) ) {
					$invalid = true;
					// If it's a string and it's not empty then...
					if( !empty($field) )
						$errorArray[] = $fieldType.' cannot be string!';
				}	
			}

			if( $value === "numeric"){
				if( is_numeric($field) ) {
					$invalid = true;
					$errorArray[] = $fieldType.' cannot be numeric!';
				}	
			}

			if( $value === "not_empty"){
				if( !empty($field) ) {
					$invalid = true;
					$errorArray[] = $fieldType.' cannot be empty!';
				}	
			}

			if( $value === "isset"){
				if( isset($field) ) {
					$invalid = true;
					$errorArray[] = $fieldType.' cannot be set!';
				}		
			}

			if( $value === "is_not_set"){
				if( !isset($field) ) {
					$invalid = true;
					$errorArray[] = $fieldType.' cannot be not set!';
				}		
			}
		}

	return $invalid;
} # END OF FUNCTION: isFormFieldValid


?>