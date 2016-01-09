<?php

/*################## CIS-2286 Internet Programming Part I PWC ##################
	Author: Christopher Sigouin
	Date: March 27, 2015
	Purpose: Assignment 6
	Dependencies: 

*/

/**
 * contains an include('header.php')
 * 
 */
function header_top() {
	include('header.php');
}

/**
 * contains an include('footer.php')
 * 
 */
function footer() {
	include ('footer.php');
}

/**
 * echo "<p>$value</p>";
 * @param  string $value [String to place between HTML tags <p></p>]
 * 
 */
function para($value) {
	echo "<p>$value</p>";
}

/**
 * echo "<h1 style='$style'>$value</h1> tag. 
 * @param  string $value [String to place between HTML tags <h1></h1>]
 * @param  string $style [String to use as a CSS style]
 * 
 */
function heading1($value, $style="") {
	echo "<h1 style='$style'>$value</h1>";
}

/**
 * An unordered list. $value is an array in this case.
 * Will echo an error string if the value is not an array and is not empty
 * 
 * @param  [array] $value [An array of values to display in an unordered list]
 * 
 */
function ulist($value = array()) {
	
		// Display the array in an unordered list
		echo "<ul>";
		for($i = 0; $i < count($value); ++$i) {
			echo "<li>".$value[$i]."</li>";	
		}
		echo "</ul>";
	
}

/**
 * Function returns a string consisting of your name (or nickname) followed by copyright (&copy;) (or copyleft) 
 * and the current year.
 * 
 * @return [String] [Returns a string]
 */
function stamp() {

	$name = "Christopher Sigouin";
	$currentYear = date("Y");
	$copyright = "&copy";

	return "<div class=\"textCenter\">$name $copyright $currentYear</div>";
}

/**
 * 
 * Using "pass by reference",
 * 		Changes the string values of an array to all uppercase
 * 
 * 
 */
function ulistUppercase(&$value = array()) {

	foreach($value as $arrayValue) {
		$arrayValue = strtoupper($arrayValue);
	}
}

/**
 * Using "pass by reference", 
 * 		Function works in two ways:
 *
 *  1)  If the content is an array 
 *  		This function will iterate through the array applying the tagType to
 *  		each value in the array and echo to the screen
 *
 *  2)  If the content is not an array 
 *  		This function will apply the tagType to the content and return
 *  		the value as a string.  Can be used as well within an array to
 *  		be reused again with the same method.
 *   	
 * @return  [String] [Returns a string]
 */
function createHTML($tagType = 'div', &$content = array()) {
	
	// If the content is an array	
	if(gettype($content) == "array") {
		foreach($content as $value) {
			$value = "<$tagType>$value</$tagType>";
			echo $value;	
		}
	// If it's not an array
	} else {
		$content = "<$tagType>$content</$tagType>";
		return $content;
	}
}



?>