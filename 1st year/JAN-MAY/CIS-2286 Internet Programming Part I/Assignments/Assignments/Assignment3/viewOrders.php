<!--

################## CIS-2286 Internet Programming Part I PWC ##################
     Author: Christopher Sigouin
     Date: February 7, 2015
     Purpose: Assignment 3
     Dependencies:  style.css, navMenu.css, navMenu.php, configMain.php
     References:

 	BANNER IMAGE: http://www.freeclipartpics.com/vegetable-clipart-images/
-->

<?php

include "toolbox/configMain.php";
include "toolbox/myFunctions.php";
$page = "view"; # Used with navMenu.php ( Great idea btw Don :P )

?>

<!DOCTYPE html>
		<title>Title Page</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/navMenu.css">
	</head>

	<body>
	<div id="container" class="center">
			<h1>fsdfdsafdsafsa Come get em!</h1>
			<?php include "toolbox/navMenu.php"; ?>
	</div>
	<div class="orderResults center">

	<?php

	if(file_exists($myDir.$myFile)) {
		if(filesize($myDir.$myFile) != 0) {
			$fileSize = filesize($myDir.$myFile);

			if($debug)
			// OPEN THE FILE ( read only )
			@ $fp = fopen($myDir.$myFile, 'rb');
			$isLocked = flock($fp, LOCK_SH); # Reading - Share
			if(!$isLocked){
				echo "<p>Could not lock the file!</p>";
				exit;
			}

			//Friendly error for FOPEN
			if (!$fp) {
				echo "<p>Couldn't open the file! Panic!</p>";
				exit;
			}

			$orderLine = [];
			$orderLine = fgetcsv($fp, $fileSize, "\t");

			/*
				Because the last \t in the data string is required incase further orders
				are entered, need to make sure I remove the last empty element it makes

			 */
			unset($orderLine[(count($orderLine)-1)]);

			if( $debug ) {
				echo "There are: ". count($orderLine)." elements<br/>";
				var_dump($orderLine);
			}

			// Main method to display the list
			echo "<p>Displaying all records!</p>";
			processOrderList($orderLine, $fieldSubHeadings);

			$isUnlocked = flock($fp, LOCK_UN);

			if(!$isUnlocked){
				echo "<p>Could not unlock the file!</p>";
				exit;
			}

			fclose($fp);

		} else {

			echo "<p> Go back to <a href=\"orderVegetables.php\">ORDER PAGE</a></p>";
		}
	} else {
		echo "<p>A file does not exist yet to view!  You will have to create an order first!</p>";
	}
	?>
	</div>

	<script type='text/javascript' id="__bs_script__">//<![CDATA[
    document.write("<script async src='http://HOST:3000/browser-sync/browser-sync-client.2.7.1.js'><\/script>".replace("HOST", location.hostname));
//]]></script>
	</body>
</html>