<?php

/*################## CIS-2286 Internet Programming Part I PWC ##################
	Author: Christopher Sigouin
	Date: March 27, 2015
	Purpose: Assignment 6
	Dependencies: 

*/
error_reporting(E_ERROR | E_WARNING | E_PARSE | E_NOTICE);
//error_reporting(E_ALL);
date_default_timezone_set('America/Halifax'); # Set the timezone
require('functions.php'); # All functions required on the page

// Use with ulist() function
$qualifications = array("Familiar with multiple programming languages",
						"Experience with object oriented software programming",
	                    "Excellent troubleshooting and problem solving abilities",
	                    "Self-motivated , proactive and goal driven attitude", 
	                    "Efficient under pressure and stressful situations");

// Resume content
$sub_heading1 = "Summary of Qualifications";
$sub_heading2 = "Technical Skills";
$sub_heading3 = "Education";
$sub_heading4 = "Achievements";
$sub_heading5 = "Work History";
$sub_heading6 = "References";

$skills_section1 = array(createHTML("h4", $value = "Operating Systems:"), 
	                     "Windows 98/NT/2000/ME/XP, Windows 7, Ubuntu Linux" );
$skills_section2 = array(createHTML("h4", $value = "Programming:"));
$skills_section3 = array(createHTML("h4", $value = "Database Systems:"),
	                     "MySQL, Microsoft Access");
$skills_section4 = array(createHTML("h4", $value = "Applications:" ),
	                     "MS Office, Open Office, NetBeans IDE, Eclipse IDE, XAMPP, GIMP, MySQL 
							Workbench, Visual Microsoft C++, Notepad++");

$skills_subSection1 = array("Web Based:", "HTML 5, CSS3, Javascript, VisualScript, Jquery, PHP, ASP, SQL");
$skills_subSection2 = array("Software Based:", "Java, C++, C#");


header_top(); ?>

<!-- NAME AND ADDRESS SECTION START-->
<table>
	<tr>
		<td>
			<?php heading1("Christopher Sigouin", "color: red;"); ?>
		</td>
	</tr>
	<tr>
		<td>
			<h5>7 Selkirk Ave, Cornwall PEI, COA 1H5 - H: (902)628-6964 - C: (902)393-6872 - csigouin@gmail.com</h5>
			<?php para("____________________________________________________________________________"); ?>
			<h4>An intelligent and proficient entry level IT professional seeking employment as a software developer.</h4>
		</td>
	</tr>
</table>
<!-- NAME AND ADDRESS SECTION START END-->

<!-- SUMMARY OF QUALIFICATIONS SECTION START-->
<?php 

	createHTML("h2", $sub_heading1);
	ulistUppercase($qualifications); 
	ulist($qualifications); 

?>

<!-- SUMMARY OF QUALIFICATIONS SECTION END-->

<!-- TECHNICAL SKILLS SECTION START -->
<?php createHTML("h2", $sub_heading2); ?>
<table class="techSkills">
	<tr>
		<?php createHTML("td", $skills_section1); ?>
	</tr>
	<tr>
		<?php createHTML("td", $skills_section2); ?>
		<td>
			<!-- INTERNAL TABLE - PROGRAMMING SECTION -->
			<table>
				<tr>
					<?php createHTML("td", $skills_subSection1); ?>
				</tr>
				<tr>
					<?php createHTML("td", $skills_subSection2); ?>
				</tr>
			</table>
			<!-- END OF INTERNAL TABLE - PROGRAMMING SECTION -->
		</td>
	</tr>
	<tr>
		<?php createHTML("td", $skills_section3); ?>
	</tr>
	<tr>
		<?php createHTML("td", $skills_section4); ?>
	</tr>
</table>
<!-- TECHNICAL SKILLS SECTION END-->

<!-- EDUCATION SECTION START -->
<?php createHTML("h2", $sub_heading3); ?>
<table class="education">
	<tr>
		<td>
			<?php para("Credit for Academic Math 621B"); ?>
			<h4>Holland College</h4>
		</td>
		<td>
			2013 - Present
		</td>
	</tr>
	<tr>
		<td>
			<?php para("Graduated with Web Development / E-Commerce Diploma"); ?>
			<h4>Eastern College ( Formely CompuCollege: School of Business )</h4>
		</td>
		<td>
			2001 - 2002
		</td>
	</tr>
	<tr>
		<td>
			<?php para("Graduated with Academic Status"); ?>
			<h4>Bluefield High School</h4>
		</td>
		<td>
			1994 - 1998
		</td>
	</tr>
</table>
<!-- EDUCATION SECTION END-->

<!-- ACHIEVEMENTS SECTION START -->
<div class="achieve">
	<?php 

		createHTML("h2", $sub_heading4); 
	

		para("Awarded \" Excellence in Programming \" from CompuCollege: School of Business in recognition
			  of high achievements, object oriented solutions and work ethic.");
		
		para("Received incentives for consistency of call times and hitting targeted goals");	
	
	?>	
</div>
<!-- ACHIEVEMENTS SECTION END -->

<!-- WORK EXPERIENCE SECTION START -->
<?php createHTML("h2", $sub_heading5); ?>
<table class="workHistory">
	<tr>
		<td>
			<?php para("Technical/Customer Service Representative"); ?>
			<h4>Bell Aliant</h4>
		</td>
		<td>
			July 2012 - Oct 2013
		</td>
	</tr>
	<tr>
		<td>
			<?php para("Technical Support Representative"); ?>
			<h4>Atleka</h4>
		</td>
		<td>
			Aug 2006 - July 2012
		</td>
	</tr>
	<tr>
		<td>
			<?php para("Survey Interviewer"); ?>
			<h4>Vision Research</h4>
		</td>
		<td>
			July 2006 - Aug 2006
		</td>
	</tr>
	<tr>
		<td>
			<?php para("Tube Fab Inc"); ?>
			<h4></h4>
		</td>
		<td>
			May 2006 - June 2006
		</td>
	</tr>
</table>
<!-- WORK EXPERENCE SECTION END -->

<!-- REFERENCES SECTION START -->
<?php createHTML("h2", $sub_heading6); ?>
<table class="references">
	<tr>
		<!-- PROFESSIONAL ENTRY START -->
		<td>
			<h4>
				Professional
			</h4>
			<h5>
				Francis Jenkins ( Bell Aliant - Manager / Supervisor )
			</h5>
			<h4>
				C: 902-393-6545
			</h4>
		</td>
		<!-- PROFESSIONAL ENTRY END -->
		<!-- PERSONAL ENTRY START -->
		<td>
			<h4>
				Personal
			</h4>
			<h5>
				Paula Silliker ( AE Professor at Holland College )
			</h5>
			<h4>
				W: 902-566-9628
			</h4>
		</td>
		<!-- PERSONAL ENTRY END -->
	</tr>	
	<tr>
		<!-- PROFESSIONAL ENTRY START -->
		<td>
			<h5>
					Steve Duncan ( Atelka - Operations Manager )
			</h5>
			<h4>
				W: 902-629-3000
				C: 902-218-1075
			</h4>
		</td>
		<!-- PROFESSIONAL ENTRY END -->
		<!-- PERSONAL ENTRY START -->
		<td>
			<h5>
				PShelley Vissey ( Friend )
			</h5>
			<h4>
				H: 902-368-3182
			</h4>
		</td>
		<!-- PERSONAL ENTRY END -->
	</tr>
</table>
<!-- REFERENCES SECTION END -->

<?php footer(); ?>
