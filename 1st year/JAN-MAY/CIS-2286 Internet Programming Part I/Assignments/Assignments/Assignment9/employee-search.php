<?php

/*
	################## CIS-2286 Internet Programming Part I PWC ##################
		Author: Christopher Sigouin
		Date: April 24, 2015
		Purpose: Assignment 9
		Dependencies: style_employee-search.css
*/

require_once("config.php");

?>

<!DOCTYPE html>

<html>
	<head>
		<title>Assignment 9 - Christopher Sigouin</title>
		<link rel="stylesheet" type="text/css" href="style_employee-search.css">
	</head>
	<body>
	<div id="employeeArea" class="center">
		<form name="myForm" action="employee-search-results.php" method="GET">
			<fieldset>
				<legend>Employee Search</legend>
					<ol>
						<li>
							<label for="firstName">First Name:</label>
							<input name="firstName" />
						</li>
						<li>
							<label for="lastName">Last Name:</label>
							<input name="lastName" />
						</li>
						<li>
							<label for="resultType">Number of Results Required:</label>
							<select name="resultType">
								<?php 
								foreach($resultTypes as $value) {
									if($value == DEFAULT_RETURN_VALUE)
										echo '<option value="'.$value.'" selected>'.$value.'</option>';
									else
										echo '<option value="'.$value.'">'.$value.'</option>';

								}
								?>
							</select>
						</li>
						<li>
							<label for="sortType">Sort by:</label>
							<select name="sortType">
								<?php 
								foreach($sortingTypes as $key=>$value) {
									if($key == DEFAULT_SORTING_TYPE)
										echo '<option value="'.$key.'" selected>'.$key.'</option>';
									else
										echo '<option value="'.$key.'">'.$key.'</option>';

								}
								?>
							</select>	
						</li>
						<li>
							<label for="orderType">Ordered by:</label>
							<select name="orderType">
							<?php 
								foreach($orderTypes as $key=>$value) {
									if($key == DEFAULT_ORDER_TYPE)
										echo '<option value="'.$key.'" selected>'.$key.'</option>';
									else
										echo '<option value="'.$key.'">'.$key.'</option>';

								}
							?>
							</select>
						</li>
					</ol>

					<input type="submit" name="submit">
			</fieldset>
		</form>
	</div>
	</body>
</html>