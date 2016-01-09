<!DOCTYPE html>
<!-- 
################## CIS-2286 Internet Programming Part I PWC ##################
	Author: Christopher Sigouin
	Date: Jan 19, 2015
	Purpose: Assignment 1 / Resume with PHP
	Dependencies: style.css
	
 -->
<html>
	<head>
		<meta charset="utf-8">
		<title>Resume of Christopher Sigouin</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
		
		<!-- NAME AND ADDRESS SECTION START-->
		<table>
			<tr>
				<td>
					<h1>Christopher Sigouin</h1>
				</td>
			</tr>
			<tr>
				<td>
					<h5>7 Selkirk Ave, Cornwall PEI, COA 1H5 - H: (902)628-6964 - C: (902)393-6872 - csigouin@gmail.com</h5>
					<p>____________________________________________________________________________</p>
					<h4>An intelligent and proficient entry level IT professional seeking employment as a software developer.</h4>
				</td>
			</tr>
		</table>
		<!-- NAME AND ADDRESS SECTION START END-->
		
		<!-- SUMMARY OF QUALIFICATIONS SECTION START-->
		
		<h2>Summary of Qualifications</h2>
		<ul>
			<li>Familiar with multiple programming languages</li>
			<li>Experience with object oriented software programming</li>
			<li>Excellent troubleshooting and problem solving abilities</li>
			<li>Self-motivated , proactive and goal driven attitude</li>
			<li>Efficient under pressure and stressful situations</li>
		</ul>
		<!-- SUMMARY OF QUALIFICATIONS SECTION END-->
		
		<!-- TECHNICAL SKILLS SECTION START -->
		<h2>Technical Skills</h2>
		<table class="techSkills">
			<tr>
				<td>
					<h4>Operating Systems:</h4>
				</td>
				<td>
					Windows 98/NT/2000/ME/XP, Windows 7, Ubuntu Linux
				</td>
			</tr>
			<tr>
				<td>
					<h4>Programming</h4>
				</td>
				<td>
					<!-- INTERNAL TABLE - PROGRAMMING SECTION -->
					<table>
						<tr>
							<td>
								Web Based:
							</td>
							<td>
								HTML 5, CSS3, Javascript, VisualScript, Jquery, PHP, ASP, SQL
							</td>
						</tr>
						<tr>
							<td>
								Software Based:
							</td>
							<td>
								Java, C++, C#
							</td>
						</tr>
					</table>
					<!-- END OF INTERNAL TABLE - PROGRAMMING SECTION -->
				</td>
			</tr>
			<tr>
				<td>
					<h4>Database Systems:</h4>
				</td>
				<td>
					 MySQL, Microsoft Access
				</td>
			</tr>
			<tr>
				<td>
					<h4>Applications:</h4>
				</td>
				<td>
						MS Office, Open Office, NetBeans IDE, Eclipse IDE, XAMPP, GIMP, MySQL 
						Workbench, Visual Microsoft C++, Notepad++
				</td>
			</tr>
		</table>
		<!-- TECHNICAL SKILLS SECTION END-->
		
		<!-- EDUCATION SECTION START -->
		<h2>Education</h2>
		<table class="education">
			<tr>
				<td>
					<p>Credit for Academic Math 621B</p>
					<h4>Holland College</h4>
				</td>
				<td>
					2013 - Present
				</td>
			</tr>
			<tr>
				<td>
					<p>Graduated with Web Development / E-Commerce Diploma</p>
					<h4>Eastern College ( Formely CompuCollege: School of Business )</h4>
				</td>
				<td>
					2001 - 2002
				</td>
			</tr>
			<tr>
				<td>
					<p>Graduated with Academic Status</p>
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
			<h2>Achievements</h2>
			<p>
				Awarded " Excellence in Programming " from CompuCollege: School of Business in recognition
				of high achievements, object oriented solutions and work ethic.
			</p>
			<p>
				Received incentives for consistency of call times and hitting targeted goals
			</p>
		</div>
		<!-- ACHIEVEMENTS SECTION END -->
		
		<!-- WORK EXPERIENCE SECTION START -->
		<h2>
			Work History
		</h2>
		<table class="workHistory">
			<tr>
				<td>
					<p>Technical/Customer Service Representative</p>
					<h4>Bell Aliant</h4>
				</td>
				<td>
					July 2012 - Oct 2013
				</td>
			</tr>
			<tr>
				<td>
					<p>Technical Support Representative</p>
					<h4>Atleka</h4>
				</td>
				<td>
					Aug 2006 - July 2012
				</td>
			</tr>
			<tr>
				<td>
					<p>Survey Interviewer</p>
					<h4>Vision Research</h4>
				</td>
				<td>
					July 2006 - Aug 2006
				</td>
			</tr>
			<tr>
				<td>
					<p>Machinist Apprentice</p>
					<h4>Tube Fab Inc</h4>
				</td>
				<td>
					May 2006 - June 2006
				</td>
			</tr>
		</table>
		<!-- WORK EXPERENCE SECTION END -->
		
		<!-- REFERENCES SECTION START -->
		<h2>
			References
		</h2>
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
		<?php
		/*
		Please format it exactly like this:  
		"Served at 5:13PM EST on September 19, 2015." Please center this text in a div with an id of 'footer'. 
		As well, please use the arial font and a font size of 20px. 
		Set the font color to #307D7E and put it in italics. 
		*/
		date_default_timezone_set('America/New_York'); # Set the timezone for EST in Manhattan, NYC
	
		$time = date("g:i:sA T"); # variable for the time
		$today = date("F j, Y"); # variable for the date

		echo "<div id=\"footer\">Served at $time on $today</div>";
		
		?>

	</body>
</html>
