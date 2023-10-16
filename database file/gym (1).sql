-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 16, 2023 at 11:49 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gym`
--
CREATE DATABASE IF NOT EXISTS `gym` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gym`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `AdminID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(10) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  PRIMARY KEY (`AdminID`),
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `UserName`, `Name`, `Email`) VALUES
(1, 'user3', 'John ', 'admin1@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `MemberID` int(11) NOT NULL,
  `UserName` varchar(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `PhNumber` varchar(15) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `MedicalCondition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MemberID`) USING BTREE,
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`MemberID`, `UserName`, `Name`, `PhNumber`, `Email`, `MedicalCondition`) VALUES
(1, 'user1', 'John Doe', '123-456-7890', 'john@example.com', 'No medical conditions'),
(2, 'user2', 'Jane Smith', '987-654-3210', 'jane@example.com', 'Asthma');

-- --------------------------------------------------------

--
-- Table structure for table `registrationmanager`
--

DROP TABLE IF EXISTS `registrationmanager`;
CREATE TABLE IF NOT EXISTS `registrationmanager` (
  `ManagerID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(10) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  PRIMARY KEY (`ManagerID`),
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registrationmanager`
--

INSERT INTO `registrationmanager` (`ManagerID`, `UserName`, `Name`, `Email`) VALUES
(1, 'user5', 'Johnson', 'regmanager1@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `StaffID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(10) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  PRIMARY KEY (`StaffID`),
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaffID`, `UserName`, `Name`, `Email`) VALUES
(1, 'user4', 'Joe', 'staff1@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE IF NOT EXISTS `userlogin` (
  `UserName` varchar(10) NOT NULL,
  `UserType` varchar(50) NOT NULL,
  `Password` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`UserName`,`UserType`),
  UNIQUE KEY `UserNameUnique` (`UserName`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`UserName`, `UserType`, `Password`) VALUES
('user1', 'Member', 'password'),
('user2', 'Member', 'password'),
('user3', 'Admin', 'adminpas'),
('user4', 'Staff', 'staffpas'),
('user5', 'Registration manager', 'regmanag');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_Admin_UserLogin` FOREIGN KEY (`UserName`) REFERENCES `userlogin` (`UserName`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `fk_1` FOREIGN KEY (`UserName`) REFERENCES `userlogin` (`UserName`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `registrationmanager`
--
ALTER TABLE `registrationmanager`
  ADD CONSTRAINT `fk_RegistrationManager_UserLogin` FOREIGN KEY (`UserName`) REFERENCES `userlogin` (`UserName`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `fk_Staff_UserLogin` FOREIGN KEY (`UserName`) REFERENCES `userlogin` (`UserName`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
