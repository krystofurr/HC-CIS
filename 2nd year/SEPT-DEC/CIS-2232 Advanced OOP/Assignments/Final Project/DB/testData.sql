USE ProjectPortfolio;



--
-- Dumping data for table `CodeType`
--

INSERT INTO `CodeType` (`codeTypeId`, `englishDescription`, `frenchDescription`, `createdDateTime`, `createdUserId`, `updatedDateTime`, `updatedUserId`) VALUES
(1, 'User Types', 'User Types FR', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', ''),
(11, 'Gender Types', 'User Types FR', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '');


--
-- Dumping data for table `CodeValue`
--

INSERT INTO `CodeValue` (`codeTypeId`, `codeValueSequence`, `englishDescription`, `englishDescriptionShort`, `frenchDescription`, `frenchDescriptionShort`, `createdDateTime`, `createdUserId`, `updatedDateTime`, `updatedUserId`) VALUES
(1, 1, 'General', 'General', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin'),
(11, 2, 'Boy', 'B', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin'),
(11, 3, 'Girl', 'G', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');


--
-- Dumping data for table `Hyperlinks`
--

INSERT INTO `Hyperlinks` (`hypID`, `projID`, `link`, `description`) VALUES
(1, 1, 'https://bitbucket.org/PortfolioX/cis2232_20152016_project_projectportfolio', 'This is Matt''s Bit Bucket link'),
(2, 2, 'https://bitbucket.org/PortfolioX/cis2232_20152016_project_projectportfolio', 'This is Chris''s Bit Bucket link');


--
-- Dumping data for table `Journals`
--

INSERT INTO `Journals` (`jourID`, `mileID`, `title`, `body`, `entryDate`) VALUES
(1, 1, 'Analysis with use case diagrams', 'Today we designed some use case diagrams for the core elements of the new system.', 1448812911),
(2, 2, 'Analysis with use case diagrams', 'Today we designed some use case diagrams for the core elements of the new system.', 1448812911);


--
-- Dumping data for table `Milestones`
--

INSERT INTO `Milestones` (`mileID`, `projID`, `description`, `startDate`, `endDate`) VALUES
(1, 1, 'Complete initial analysis and design phase', 1448812157, 1450569600),
(2, 2, 'Complete initial analysis and design phase', 1448812157, 1450569600),
(3, 1, 'Create first cut design class diagram', 1450670400, 1451016000),
(4, 2, 'Create first cut design class diagram', 1450670400, 1451016000);



--
-- Dumping data for table `Profiles`
--

INSERT INTO `Profiles` (`profID`, `name`, `biography`, `totalProjectsCompleted`, `totalProjectsInProgress`, `userAccessId`) VALUES
(1, 'Matt''s Portfolio Profile', 'Matt''s Biography', 20, 10, 1),
(2, 'Chris''s Portfolio Page', 'Chris''s Biography', 20, 10, 2);



--
-- Dumping data for table `Projects`
--

INSERT INTO `Projects` (`projID`, `name`, `statID`, `description`, `position`, `totalContributers`, `profID`) VALUES
(1, 'Matt''s First Project', 2, 'Matt''s description of the project here', 'Lead Developer', 5, 1),
(2, 'Chris''s First Project', 3, 'Chris''s description of the project here', 'Lead Developer', 5, 2);


--
-- Dumping data for table `ProjectStatus`
--

INSERT INTO `ProjectStatus` (`statID`, `description`) VALUES
(1, 'Completed'),
(2, 'In Progress'),
(3, 'On Hold');


--
-- Dumping data for table `TechLearned`
--

INSERT INTO `TechLearned` (`techID`, `profID`) VALUES
(2, 1),
(6, 1),
(7, 1),
(9, 1),
(14, 1),
(2, 2),
(6, 2),
(7, 2),
(9, 2),
(14, 2);



--
-- Dumping data for table `Technologies`
--

INSERT INTO `Technologies` (`techID`, `shortDescription`, `longDescription`) VALUES
(1, 'JavaSE', 'Java Standard Edition'),
(2, 'JavaEE', 'Java Enterprise Edition'),
(3, 'C++', 'C++'),
(4, 'C', 'C'),
(5, 'Python', 'Python'),
(6, 'HTML5', 'Hypertext Markup Language 5'),
(7, 'CSS', 'Cascading Style Sheet'),
(8, 'JS', 'Javascript'),
(9, 'jQuery', 'jQuery'),
(10, 'Ruby', 'Ruby'),
(11, 'PHP', 'Hypertext Preprocessor'),
(13, 'C#', 'C#'),
(14, 'XML', 'Extensible Markup Language');



--
-- Dumping data for table `TechUsed`
--

INSERT INTO `TechUsed` (`projID`, `techID`) VALUES
(1, 2),
(2, 2),
(1, 6),
(2, 6),
(1, 7),
(2, 7),
(1, 9),
(2, 9),
(1, 14),
(2, 14);



--
-- Dumping data for table `useraccess`
--

INSERT INTO `useraccess` (`userAccessId`, `username`, `password`, `userTypeCode`, `createdDateTime`) VALUES
(1, 'matt', 'password', 1, '2015-11-29 00:00:00'),
(2, 'chris', 'password', 1, '2015-11-29 00:00:00');


