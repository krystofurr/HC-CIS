-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 29, 2015 at 12:10 PM
-- Server version: 5.5.46-0ubuntu0.14.04.2
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ProjectPortfolio`
--

CREATE SCHEMA IF NOT EXISTS `bjmac_ProjectPortfolio` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `bjmac_ProjectPortfolio` ;

-- --------------------------------------------------------

--
-- Table structure for table `CodeType`
--

CREATE TABLE IF NOT EXISTS `CodeType` (
  `codeTypeId` int(3) NOT NULL COMMENT 'This is the primary key for code types',
  `englishDescription` varchar(100) NOT NULL COMMENT 'English description',
  `frenchDescription` varchar(100) DEFAULT NULL COMMENT 'French description',
  `createdDateTime` datetime DEFAULT NULL,
  `createdUserId` varchar(20) DEFAULT NULL,
  `updatedDateTime` datetime DEFAULT NULL,
  `updatedUserId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codeTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This hold the code types that are available for the applicat';

--
-- Dumping data for table `CodeType`
--

INSERT INTO `CodeType` (`codeTypeId`, `englishDescription`, `frenchDescription`, `createdDateTime`, `createdUserId`, `updatedDateTime`, `updatedUserId`) VALUES
(1, 'User Types', 'User Types FR', '2015-11-23 07:08:38', '', '2015-11-23 07:08:38', ''),
(11, 'Gender Types', 'User Types FR', '2015-11-29 18:10:24', '', '2015-11-29 18:10:24', '');


-- --------------------------------------------------------

--
-- Table structure for table `CodeValue`
--

CREATE TABLE IF NOT EXISTS `CodeValue` (
  `codeTypeId` int(3) NOT NULL COMMENT 'see code_type table',
  `codeValueSequence` int(3) NOT NULL,
  `englishDescription` varchar(100) NOT NULL COMMENT 'English description',
  `englishDescriptionShort` varchar(20) NOT NULL COMMENT 'English abbreviation for description',
  `frenchDescription` varchar(100) DEFAULT NULL COMMENT 'French description',
  `frenchDescriptionShort` varchar(20) DEFAULT NULL COMMENT 'French abbreviation for description',
  `createdDateTime` datetime DEFAULT NULL,
  `createdUserId` varchar(20) DEFAULT NULL,
  `updatedDateTime` datetime DEFAULT NULL,
  `updatedUserId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codeValueSequence`),
  KEY `codeTypeId_idx` (`codeTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This will hold code values for the application.';

--
-- Dumping data for table `CodeValue`
--

INSERT INTO `CodeValue` (`codeTypeId`, `codeValueSequence`, `englishDescription`, `englishDescriptionShort`, `frenchDescription`, `frenchDescriptionShort`, `createdDateTime`, `createdUserId`, `updatedDateTime`, `updatedUserId`) VALUES
(1, 1, 'General', 'General', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin'),
(11, 2, 'Boy', 'B', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin'),
(11, 3, 'Girl', 'G', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `Hyperlinks`
--

CREATE TABLE IF NOT EXISTS `Hyperlinks` (
  `hypID` int(11) NOT NULL AUTO_INCREMENT,
  `projID` int(11) DEFAULT NULL,
  `link` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`hypID`),
  KEY `proj_ID_idx` (`projID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='Hyperlinks that are used to link to resource pages that rela /* comment truncated */ /*te to the project itself*/' AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Hyperlinks`
--

INSERT INTO `Hyperlinks` (`hypID`, `projID`, `link`, `description`) VALUES
(1, 1, 'https://bitbucket.org/PortfolioX/cis2232_20152016_project_projectportfolio', 'This is Matt''s Bit Bucket link'),
(2, 2, 'https://bitbucket.org/PortfolioX/cis2232_20152016_project_projectportfolio', 'This is Chris''s Bit Bucket link');

-- --------------------------------------------------------

--
-- Table structure for table `Journals`
--

CREATE TABLE IF NOT EXISTS `Journals` (
  `jourID` int(11) NOT NULL AUTO_INCREMENT,
  `mileID` int(11) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `body` varchar(2000) DEFAULT NULL,
  `entryDate` int(11) DEFAULT NULL,
  PRIMARY KEY (`jourID`),
  KEY `mile_ID_idx` (`mileID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='Journal entries assigned to milestones' AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Journals`
--

INSERT INTO `Journals` (`jourID`, `mileID`, `title`, `body`, `entryDate`) VALUES
(1, 1, 'Analysis with use case diagrams', 'Today we designed some use case diagrams for the core elements of the new system.', 1448812911),
(2, 2, 'Analysis with use case diagrams', 'Today we designed some use case diagrams for the core elements of the new system.', 1448812911);

-- --------------------------------------------------------

--
-- Table structure for table `Milestones`
--

CREATE TABLE IF NOT EXISTS `Milestones` (
  `mileID` int(11) NOT NULL AUTO_INCREMENT,
  `projID` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `startDate` int(11) DEFAULT NULL,
  `endDate` int(11) DEFAULT NULL,
  PRIMARY KEY (`mileID`),
  KEY `proj_ID_idx` (`projID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Milestones`
--

INSERT INTO `Milestones` (`mileID`, `projID`, `description`, `startDate`, `endDate`) VALUES
(1, 1, 'Complete initial analysis and design phase', 1448812157, 1450569600),
(2, 2, 'Complete initial analysis and design phase', 1448812157, 1450569600),
(3, 1, 'Create first cut design class diagram', 1450670400, 1451016000),
(4, 2, 'Create first cut design class diagram', 1450670400, 1451016000);

-- --------------------------------------------------------

--
-- Table structure for table `Profiles`
--

CREATE TABLE IF NOT EXISTS `Profiles` (
  `profID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `biography` varchar(1000) DEFAULT NULL,
  `totalProjectsCompleted` int(11) DEFAULT NULL,
  `totalProjectsInProgress` int(11) DEFAULT NULL,
  `userAccessId` int(11) DEFAULT NULL,
  PRIMARY KEY (`profID`),
  KEY `userAccessId_idx` (`userAccessId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='Holds all profile information pertaining to a specific user' AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Profiles`
--

INSERT INTO `Profiles` (`profID`, `name`, `biography`, `totalProjectsCompleted`, `totalProjectsInProgress`, `userAccessId`) VALUES
(1, 'Matt''s Portfolio Profile', 'Matt''s Biography', 20, 10, 1),
(2, 'Chris''s Portfolio Page', 'Chris''s Biography', 20, 10, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Projects`
--

CREATE TABLE IF NOT EXISTS `Projects` (
  `projID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `statID` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `totalContributers` int(11) DEFAULT NULL,
  `profID` int(11) DEFAULT NULL,
  PRIMARY KEY (`projID`),
  KEY `prof_ID_idx` (`profID`),
  KEY `statID_idx` (`statID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='All data concerning a ''Project'' is contained here' AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Projects`
--

INSERT INTO `Projects` (`projID`, `name`, `statID`, `description`, `position`, `totalContributers`, `profID`) VALUES
(1, 'Matt''s First Project', 2, 'Matt''s description of the project here', 'Lead Developer', 5, 1),
(2, 'Chris''s First Project', 3, 'Chris''s description of the project here', 'Lead Developer', 5, 2),
(3, 'Matt''s Second Project', 2, 'Matt''s description of the second project here', 'Lead Developer', 5, 1),
(4, 'Chris''s Second Project', 3, 'Chris''s second description of the project here', 'Lead Developer', 5, 2),
(5, 'Chris''s Third Project', 3, 'Chris''s third description of the project here', 'Lead Developer', 5, 2),
(6, 'Matt''s Third Project', 2, 'Matt''s description of the third project here', 'Lead Developer', 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ProjectStatus`
--

CREATE TABLE IF NOT EXISTS `ProjectStatus` (
  `statID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`statID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `ProjectStatus`
--

INSERT INTO `ProjectStatus` (`statID`, `description`) VALUES
(1, 'Completed'),
(2, 'In Progress'),
(3, 'On Hold');

-- --------------------------------------------------------

--
-- Table structure for table `TechLearned`
--

CREATE TABLE IF NOT EXISTS `TechLearned` (
  `techID` int(11) NOT NULL,
  `profID` int(11) NOT NULL,
  PRIMARY KEY (`techID`,`profID`),
  KEY `prof_ID_idx` (`profID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Composite.  A user can learn many technologies and a technol /* comment truncated */ /*ogy can be learned by many users.*/';

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

-- --------------------------------------------------------

--
-- Table structure for table `Technologies`
--

CREATE TABLE IF NOT EXISTS `Technologies` (
  `techID` int(11) NOT NULL AUTO_INCREMENT,
  `shortDescription` varchar(50) DEFAULT NULL,
  `longDescription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`techID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='Key / Value table for all technologies' AUTO_INCREMENT=15 ;

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

-- --------------------------------------------------------

--
-- Table structure for table `TechUsed`
--

CREATE TABLE IF NOT EXISTS `TechUsed` (
  `projID` int(11) NOT NULL,
  `techID` int(11) NOT NULL,
  PRIMARY KEY (`projID`,`techID`),
  KEY `tech_ID_idx` (`techID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Composite table. Many projects can use many technologies.';

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

-- --------------------------------------------------------

--
-- Table structure for table `useraccess`
--

CREATE TABLE IF NOT EXISTS `UserAccess` (
  `userAccessId` int(3) NOT NULL,
  `username` varchar(100) NOT NULL COMMENT 'Unique user name for app',
  `password` varchar(128) NOT NULL,
  `userTypeCode` int(3) NOT NULL COMMENT 'Code type #1',
  `createdDateTime` datetime DEFAULT NULL COMMENT 'When user was created.',
  PRIMARY KEY (`userAccessId`),
  KEY `codeValueSequence_idx` (`userTypeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `useraccess`
--

INSERT INTO `UserAccess` (`userAccessId`, `username`, `password`, `userTypeCode`, `createdDateTime`) VALUES
(1, 'matt', '5f4dcc3b5aa765d61d8327deb882cf99', 1, '2015-11-29 00:00:00'),
(2, 'chris', '5f4dcc3b5aa765d61d8327deb882cf99', 1, '2015-11-29 00:00:00');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `CodeValue`
--
ALTER TABLE `CodeValue`
  ADD CONSTRAINT `codeTypeId` FOREIGN KEY (`codeTypeId`) REFERENCES `CodeType` (`codeTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Hyperlinks`
--
ALTER TABLE `Hyperlinks`
  ADD CONSTRAINT `hyper_projID` FOREIGN KEY (`projID`) REFERENCES `Projects` (`projID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Journals`
--
ALTER TABLE `Journals`
  ADD CONSTRAINT `jour_mileID` FOREIGN KEY (`mileID`) REFERENCES `Milestones` (`mileID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Milestones`
--
ALTER TABLE `Milestones`
  ADD CONSTRAINT `mile_projID` FOREIGN KEY (`projID`) REFERENCES `Projects` (`projID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Profiles`
--
ALTER TABLE `Profiles`
  ADD CONSTRAINT `profile_userAccessId` FOREIGN KEY (`userAccessId`) REFERENCES `UserAccess` (`userAccessId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Projects`
--
ALTER TABLE `Projects`
  ADD CONSTRAINT `proj_profID` FOREIGN KEY (`profID`) REFERENCES `Profiles` (`profID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `proj_statID` FOREIGN KEY (`statID`) REFERENCES `ProjectStatus` (`statID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `TechLearned`
--
ALTER TABLE `TechLearned`
  ADD CONSTRAINT `techLearned_techID` FOREIGN KEY (`techID`) REFERENCES `Technologies` (`techID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `techLearned_profID` FOREIGN KEY (`profID`) REFERENCES `Profiles` (`profID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `TechUsed`
--
ALTER TABLE `TechUsed`
  ADD CONSTRAINT `techUsed_projID` FOREIGN KEY (`projID`) REFERENCES `Projects` (`projID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `techUsed_techID` FOREIGN KEY (`techID`) REFERENCES `Technologies` (`techID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `useraccess`
--
ALTER TABLE `UserAccess`
  ADD CONSTRAINT `codeValueSequence` FOREIGN KEY (`userTypeCode`) REFERENCES `CodeValue` (`codeValueSequence`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
