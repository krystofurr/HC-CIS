SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ProjectPortfolio` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `ProjectPortfolio` ;

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


-- --------------------------------------------------------

--
-- Table structure for table `ProjectStatus`
--

CREATE TABLE IF NOT EXISTS `ProjectStatus` (
  `statID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`statID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;


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


-- --------------------------------------------------------

--
-- Table structure for table `useraccess`
--

CREATE TABLE IF NOT EXISTS `useraccess` (
  `userAccessId` int(3) NOT NULL,
  `username` varchar(100) NOT NULL COMMENT 'Unique user name for app',
  `password` varchar(128) NOT NULL,
  `userTypeCode` int(3) NOT NULL COMMENT 'Code type #1',
  `createdDateTime` datetime DEFAULT NULL COMMENT 'When user was created.',
  PRIMARY KEY (`userAccessId`),
  KEY `codeValueSequence_idx` (`userTypeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD CONSTRAINT `profile_userAccessId` FOREIGN KEY (`userAccessId`) REFERENCES `useraccess` (`userAccessId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
ALTER TABLE `useraccess`
  ADD CONSTRAINT `codeValueSequence` FOREIGN KEY (`userTypeCode`) REFERENCES `CodeValue` (`codeValueSequence`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
