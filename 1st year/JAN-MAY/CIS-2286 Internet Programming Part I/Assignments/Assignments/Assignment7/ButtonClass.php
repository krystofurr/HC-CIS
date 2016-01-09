<?php
/*
################## CIS-2286 Internet Programming Part I PWC ##################
	Author: Christopher Sigouin
	Date: April 8, 2015
	Purpose: Assignment 7
	Dependencies:
*/


/**
 *
 *	ButtonClass( Name, Value, ID, Class )
 *	Creates a button for a HTML page
 * 
 */
class ButtonClass {

	protected $buttonName, $buttonValue, $id, $class;

	/**
	 * Constructor supplies the attributes for the button input tag
	 * @param string $buttonName  [Name parameter]
	 * @param string $buttonValue [Value parameter]
	 * @param string $id          [ID parameter]
	 * @param string $class       [Class parameter]
	 */
	function __construct($buttonName="", $buttonValue="", $id ="", $class="") {
		$this->buttonName = ( empty($buttonName) ) ? "" : "name=\"$buttonName\"";
		$this->buttonValue = ( empty($buttonValue) ) ? "" : "value=\"$buttonValue\"";
		$this->id = ( empty($id) ) ? "" : "id=\"$id\"";
		$this->class = ( empty($class) ) ? "" : "class=\"$class\"";
	}

	function __get($name){

		return $this->$name;
	}
	
	function __set($name,$value) {

		$this->$name = $value;
	}

	/**
	 * Displays the HTML for the button to be displayed
	 * 
	 * @return void
	 */
	function displayButton() {
		echo "<input $this->id $this->class type=\"submit\" $this->buttonName $this->buttonValue />";
		echo "<br/>";
	}

}


?>