<?php
/*
################## CIS-2286 Internet Programming Part I PWC ##################
	Author: Christopher Sigouin
	Date: April 8, 2015
	Purpose: Assignment 7
	Dependencies:
*/



if(isset($_POST['submit']))	{

	// ----------- Start loading the HTML
	?>
	<!DOCTYPE html>
	<html>
		<head>
			<title>Book Processing Page</title>
			<link rel="stylesheet" type="text/css" href="styles.css">
		</head>
		<body>
			<div id="container" class="center">
				<div id="textContainer" class="center">
				
				<?php // ----------- Stop loading the HTML

				// Validation
				require("myFunctions.php");
				
				// Array for the verifyFormField method. Has to have NO elements to start
				$errors = array();

				// verifyFormField ( Field Name, Field Value, Types to check, Error array for display )
				verifyFormField("Title", $_POST['title'], array("numeric", "empty"), $errors);
				verifyFormField("Author", $_POST['author'], array("numeric", "empty"), $errors);
				verifyFormField("ISBN", $_POST['isbn'], array("string", "empty"), $errors);
				verifyFormField("Page Count", $_POST['pageCount'], array("string", "empty"), $errors);
				verifyFormField("Weight", $_POST['weight'], array("string", "empty"), $errors);
				verifyFormField("Language", $_POST['language'], array("numeric", "empty"), $errors);
				
				// If there are errors...
				if(count($errors) != 0 ) {

					// Display the errors
					foreach($errors as $value) {
						echo '<p class="error">'.$value.'</p>';
					}

					echo '<p><br>You have some errors. <br/><a href="addBook.php" onclick="javascript: history.back()">Go back?</a></p>';

				} else {
					
					// Continue with the script...
					require("book.class.php");

					// Create the instance of a Book
					$book = new BookClass();

					// Assign values
					$book->title = $_POST['title'];
					$book->author = $_POST['author'];
					$book->isbn = $_POST['isbn'];
					$book->pageCount = $_POST['pageCount'];
					$book->weight = $_POST['weight'];
					$book->language = $_POST['language'];

					// Show the book details
					echo $book->printDetails();

				} // END: if(!count($errors) == 0) {
				?>

				</div>
			</div>
		</body>
	</html>

	<?php


} else {

	// Return to addBook.php
	header("location:addBook.php");

}

?>