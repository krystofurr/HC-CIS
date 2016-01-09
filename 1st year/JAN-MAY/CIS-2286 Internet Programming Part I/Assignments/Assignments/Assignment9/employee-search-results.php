<?php

/*
	################## CIS-2286 Internet Programming Part I PWC ##################
		Author: Christopher Sigouin
		Date: April 24, 2015
		Purpose: Assignment 9
		Dependencies: style_employee-search.css

		ISSUES:
			- Need a better way to to get the field values from the sorting methods on the selection from
			  employee-search. ( ie. assign emp_no to Employee Number without hard coding it )
*/


if(isset($_GET['submit'])) {

	// Start HTML
	?>
	<!DOCTYPE html>

	<html>
		<head>
			<title>Assignment 9 - Christopher Sigouin</title>
			<link rel="stylesheet" type="text/css" href="style_employee-search.css">
		</head>
		<body>
		<div id="employeeArea" class="center">
		<?php

	// Store field data.
	$firstName = $_GET['firstName']; # Empty field is ok
	$lastName = $_GET['lastName']; # Empty field is ok
	$resultType = $_GET['resultType'];
	$sortType = $_GET['sortType'];
	$orderType = $_GET['orderType'];

	// Establish database connection
	require_once("config.php"); # For access to some of the array's
	require_once("db_connect.php");

	// Sanitize Input
	$firstName = $db->real_escape_string($firstName);
	$lastName = $db->real_escape_string($lastName);

	// Queries
	$query = 'SELECT first_name, last_name, emp_no, hire_date, birth_date, gender'.
	         ' FROM employees'.
	         ' WHERE (first_name LIKE "'.$firstName.'%") AND (last_name LIKE "'.$lastName.'%")'.
	         ' ORDER BY '.$sortingTypes[$sortType].' '.$orderTypes[$orderType].
	         ' LIMIT '.$resultType;
	$result = $db->query($query);

	// Error check result set
	if(!$result){
		echo '<p>There was an error with your query.  Please try again <a href="employee-search.php">HERE</a></p>';
		$result->free();
		$db->close();
		exit;
	}
	$noResults = ($result->num_rows == 0);
	if($noResults) {
		echo '<p>There were no results found with your search.  Please try again <a href="employee-search.php">HERE</a></p>';
		$result->free();
		$db->close();
		exit;
	}

	// Display
	$firstTime = true;
	$counter = 1;
	$tableHeaders = array("Name", "Employee Number", "Hire Date", "Birth Date", "Gender" );
	echo '<a href="employee-search.php">BACK TO SEARCH</a></br></br><table>';
	while( $row = $result->fetch_object()) {

		// Zebra stripe the rows for all odd rows
		if( $counter % 2 == 1)
			echo '<tr class="zebraStripe">';
		else
			echo '<tr>';

		// Display the table headers
		if($firstTime){
			foreach($tableHeaders as $value){
				echo '<th>'.$value.'</th>';
			}
			$firstTime = false;

		// Display the data
		} else {
			echo '<td class="name">'.$row->last_name.', '.$row->first_name.'</td>'.
				 '<td><a href="employeeInfo.php?id='.$row->emp_no.'">'.$row->emp_no.'</a></td>'.
				 '<td>'.$row->hire_date.'</td>'.
				 '<td>'.$row->birth_date.'</td>'.
				 '<td>'.$row->gender.'</td>';
		}
		echo '</tr>';
		++$counter; // Increment for zebra striping?>
	}
	echo '</table>';
	echo '</br><a href="employee-search.php">BACK TO SEARCH</a>';
	// Free up database resources
	$result->free();
	$db->close();

} else {

	// Return to employee-search.php if opened directly
	header("location:employee-search.php");
}

?>

		</div>
	</body>
</html>