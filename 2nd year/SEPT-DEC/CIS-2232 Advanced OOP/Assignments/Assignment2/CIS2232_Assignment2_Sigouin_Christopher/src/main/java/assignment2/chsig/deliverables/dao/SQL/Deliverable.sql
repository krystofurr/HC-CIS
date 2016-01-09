-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 03, 2015 at 10:12 AM
-- Server version: 5.5.44-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `CIS2232_Assignment2_Sigouin_Christopher_DB`
--

CREATE DATABASE CIS2232_Assignment2_Sigouin_Christopher_DB;
USE CIS2232_Assignment2_Sigouin_Christopher_DB;
-- --------------------------------------------------------

--
-- Table structure for table `Deliverables`
--

CREATE TABLE IF NOT EXISTS `Deliverables` (
  `Deliv_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Deliv_Name` varchar(50) NOT NULL,
  `Deliv_Weight` int(11) NOT NULL,
  PRIMARY KEY (`Deliv_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Used to store all deliverables' AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
