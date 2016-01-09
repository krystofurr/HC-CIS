<?php

/*
	################## CIS-2286 Internet Programming Part I PWC ##################
		Author: Christopher Sigouin
		Date: April 24, 2015
		Purpose: Assignment 9
		Dependencies: style.css


*/

/*

	This page is so you can edit the select options fields a little
	more easily.  You can also set the default values from this page
	without editing the html.

*/

// RETURN RESULT TYPES
$resultTypes = array(25, 100, 250, 500, 750); 
// Default Return Result Type
define('DEFAULT_RETURN_VALUE', 100);

// SORTING TYPES
$sortingTypes = array("Employee Number"=>"emp_no", "First Name"=>"first_name", "Last Name"=>"last_name", 
	                  "Birth Date"=>"birth_date");
// Default Sorting Type
define('DEFAULT_SORTING_TYPE', "Last Name");

// ORDER TYPES
$orderTypes = array("Ascending"=>"ASC", "Descending"=>"DESC");
// Default Order Type
define('DEFAULT_ORDER_TYPE', "Ascending");

?>