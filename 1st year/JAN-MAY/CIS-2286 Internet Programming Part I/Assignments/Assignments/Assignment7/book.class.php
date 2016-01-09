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
 *	BookClass
 *
 * 	A class that represents a book object.  Holds attributes that 
 * 	make up a book.  You can also set and get all attributes.  
 * 	Also the following methods are available to call:
 * 		printDetails()
 * 
 */
class BookClass {

	// Constant variable used to display a message in the constructor
	const BOOK_CREATED = '<h3>Book Created</h3>';

	// Private members or attributes of the BookClass
	private $title, $author, $isbn, $pageCount, $weight, $language;

	/**
	 * Constructor generates a message once a book is instantiated
	 */
	function __construct() {
		// static member uses self. object member uses this
		echo self::BOOK_CREATED;	
	}

	/**
	 * Getter method to retrieve any value from any member of the BookClass
	 * 
	 * @param  $name [Name of the attribute to retrieve]
	 * @return [Returns the value of the attribute]
	 */
	function __get($name){

		return $this->$name;
	}
	
	/**
	 * Setter method to set all private members of the BookClass
	 * 
	 * @param $name  [Name of the attribute to set]
	 * @param $value [Value to assign to the attribute]
	 */
	function __set($name,$value) {

		$this->$name = $value;
	}

	/**
	 * printDetails()
	 *
	 * Used to display all attributes of a book to the screen. Call this
	 * method using a book object after instantiation using the BookClass
	 *
	 * @return void
	 */
	function printDetails() {
		echo'<p><span class="heading">Title:</span> '.$this->title.'</p>'.
			'<p><p><span class="heading">Author:</span> '.$this->author.'</p>'.
			'<p><span class="heading">ISBN:</span> '.$this->isbn.'</p>'.
			'<p><span class="heading">Page Count:</span> '.$this->pageCount.'</p>'.
			'<p><span class="heading">Weight:</span> '.$this->weight.'</p>'.
			'<p><span class="heading">Language:</span> '.$this->language.'</p><br/>'.
			'<a href="addBook.php">Add another book!</a>';	
	}

}

?>