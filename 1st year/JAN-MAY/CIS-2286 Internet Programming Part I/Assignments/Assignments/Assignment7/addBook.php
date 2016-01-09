<?php
/*
################## CIS-2286 Internet Programming Part I PWC ##################
	Author: Christopher Sigouin
	Date: April 8, 2015
	Purpose: Assignment 7
	Dependencies:
*/

require("ButtonClass.php");
// Instantiate the ButtonClass to make a button object
$button = new ButtonClass("submit", "Add Book", "", "");
?>

<!DOCTYPE html>

<html>
	<head>
		<title>Book Processing Page</title>
		<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<body>
		<div id="container" class="center textCenter">
		<form name="myForm" method="post" action="process.php">
			<fieldset>
			<legend>Book Processing</legend>
				<p>Please enter information about a book below:</p>
				<ol>
					<li>
						<label for="title">Title</label>
						<input type="text" name="title" />
					</li>
					<li>
						<label for="author">Author</label>
						<input type="text" name="author" />
					</li>
					<li>
						<label for="isbn">ISBN</label>
						<input type="text" name="isbn" />
					</li>
					<li>
						<label for="pageCount">Page Count</label>
						<input type="text" name="pageCount" />
					</li>
					<li>
						<label for="weight">Shipping Weight</label>
						<input type="text" name="weight" />
					</li>
					<li>
						<label for="language">Language</label>
						<input type="text" name="language" />
					</li>
					<li>
						<?php echo $button->displayButton(); ?>
					</li>
				</ol>
			</fieldset>
		</form>
	</body>
</html>

