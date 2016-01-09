<?php

/*
	################## CIS-2286 Internet Programming Part I PWC ##################
		Author: Christopher Sigouin
		Date: April 24, 2015
		Purpose: Assignment 9
		Dependencies:
*/

# DATABASE CONNECTION FILE

$mysql_server = "localhost";
$mysql_user = "root";
$mysql_password = "d3ck3r";
$mysql_db = "employees";
@ $db = new mysqli($mysql_server, $mysql_user, $mysql_password, $mysql_db);
if ($db->connect_errno) {
	printf("Connection failed: %s \n", $mysqli->connect_error);
	exit();
}

$db->set_charset("utf8");

?>
