<?php

/*
	################## CIS-2286 Internet Programming Part I PWC ##################
		Author: Christopher Sigouin
		Date: April 24, 2015
		Purpose: Assignment 9
		Dependencies: style_employeeInfo.css
*/

error_reporting(E_ERROR | E_WARNING | E_PARSE);
require_once("db_connect.php");

?>

<!DOCTYPE html>

	<html>
		<head>
			<title>Assignment 8 - Christopher Sigouin</title>
			<link rel="stylesheet" type="text/css" href="style_employeeInfo.css">
		</head>
		<body>
			<div id="empData" class="center">

			<?php

			// Is the ID set?
			if(isset($_GET['id'])){

				// Constant to hold the value that the database shows for no ' to_date ' present
				define('NO_END_DATE', "9999-01-01");
				// Boolean value used to control the freeing of resources
				$scriptFailed = false;

				// Store the ID value in $id
				$id = $_GET['id'];
				// Sanitize user input
			    $id = $db->real_escape_string($id);

			    // Define SQL queries

				$queryEmployee = "SELECT birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no = $id;";

				// Employees can possibly have old titles.  Find the newest title
				$queryTitle = "SELECT title FROM titles WHERE emp_no = $id AND to_date = '".NO_END_DATE."';";

				// Employees can possible have old departments.  Find the newest department
				$queryDepartment = "SELECT dept_name FROM departments 
				 		   		   WHERE dept_no = ( SELECT dept_no FROM dept_emp WHERE emp_no = $id AND to_date = '".NO_END_DATE."');";

				$querySalaryInfo = "SELECT salary, from_date, to_date FROM salaries 
						   		   WHERE emp_no = $id ORDER BY to_date DESC LIMIT 4;";

				// Run the queries against the database...
			
				$resultEmployee = $db->query($queryEmployee);
				$resultTitle = $db->query($queryTitle);
				$resultDepartment = $db->query($queryDepartment);
				$resultSalaryInfo = $db->query($querySalaryInfo);
				// Store the boolean value if the queries fail.  Used below for error message and to skip freeing resources
				$queryFailure = (!$resultEmployee || !$resultTitle || !$resultDepartment || !$resultSalaryInfo );

				// Check the results of the queries for errors
				if($queryFailure)
					echo "There was an error found with the query.  Please try again.";
				else {
					
					/* 
						Display the data as per format below...
					
							Georgi Facello, Software Engineer (this should be bolded and left aligned)

							Hired: 1986-06-26    (note the bolded labels - these should all be left aligned)

							Gender: M

							DOB: 1953-09-02

							Department: Development

							Salary History:
					
					*/

					
					$rowEmployee = $resultEmployee->fetch_object();
					$rowTitle = $resultTitle->fetch_object();
					$rowDepartment = $resultDepartment->fetch_object();

					echo '<span class="bold">'.$rowEmployee->first_name.' '.$rowEmployee->last_name.', ';
						// If there are no rows found in the result set, this means the employee was terminated?
						 if($rowTitle->title == null )
						 	echo "TERMINATED";
						 else
						 	echo $rowTitle->title;
					echo '</span></br></br>'.
					     '<span class="bold">Hired: </span>'.$rowEmployee->hire_date.'</br></br>'.
					     '<span class="bold">Gender: </span>'.$rowEmployee->gender.'</br></br>'.
					     '<span class="bold">DOB: </span>'.$rowEmployee->birth_date.'</br></br>'.
					     '<span class="bold">Department: </span>';
					     // If there are no rows found in the result set, this means the employee was terminated?
					     if($rowDepartment->dept_name == null )
					     	echo "TERMINATED";
					     else
					     	echo $rowDepartment->dept_name;
					echo '</br></br>'.
					     '<span class="bold">Salary History: </span></br></br>';

					// Start a table for the data
					echo "<table class=\"tableBorder\">";
					// Boolean to ensure control of the table header tags
					$firstTimeLooping = true;

					// Loop through the results of the $resultSalaryInfo result set
					while($row = $resultSalaryInfo->fetch_object()) {

						if($firstTimeLooping) {
							echo '<tr>';
				            echo '<th>Salary</th><th>Start Date</th><th>End Date</th>';
				            echo '</tr>';
				            // Make sure this doesn't display again
				            $firstTimeLooping = false;	
				            // Reset the pointer to display all the rows
				           
						}

						echo "<tr>";
						echo '<td>$'.$row->salary.'</td>';
						echo '<td>'.$row->from_date.'</td>';
						if($row->to_date == NO_END_DATE)
							echo '<td>-</td>';
						else
							echo '<td>'.$row->to_date.'</td>';
						echo "</tr>";
					}

					echo "</table>";

					

				}

			} else {

				$scriptFailed = true;

				// Find out how many employee records are in the database
				$queryNumberOfEmployees = "SELECT * FROM employees";
				// Query the database
				$resultNumberOfEmployees = $db->query($queryNumberOfEmployees);

				echo "<p>Your missing something to run this script! But look on the bright side. There are $resultNumberOfEmployees->num_rows". 
				     " records in the employees table. </p>";

			}

			// Boolean values control which resources are released based on script flow
			if($scriptFailed) {
				$resultNumberOfEmployees->free();
			} else {	
				if(!$queryFailure) {		
					$resultEmployee->free();
					$resultDepartment->free();
					$resultSalaryInfo->free();
				}
			}

			// Close the connection
			$db->close();

			?>
	
		</div>
	</body>
</html>