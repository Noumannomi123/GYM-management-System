-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 13, 2024 at 09:41 PM
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
(1, 'user3', 'Josh', 'josh@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
CREATE TABLE IF NOT EXISTS `appointments` (
  `HCID` int(11) NOT NULL AUTO_INCREMENT,
  `memberID` int(11) NOT NULL,
  `Date` varchar(20) DEFAULT NULL,
  `Time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`HCID`,`memberID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`HCID`, `memberID`, `Date`, `Time`) VALUES
(2, 1, '2023-11-13', '04:00 PM'),
(2, 2, '2023-11-16', '01:00 PM');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
CREATE TABLE IF NOT EXISTS `class` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`ID`, `Name`) VALUES
(1, 'Weight Loss Class'),
(2, 'Muscle Building Class'),
(3, 'Functional Fitness Class');

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
CREATE TABLE IF NOT EXISTS `enrollment` (
  `classID` int(11) NOT NULL,
  `memberID` int(11) NOT NULL,
  `dayOfWeek` varchar(20) NOT NULL,
  `timeofday` varchar(20) NOT NULL,
  PRIMARY KEY (`classID`,`memberID`),
  KEY `memberID` (`memberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`classID`, `memberID`, `dayOfWeek`, `timeofday`) VALUES
(1, 2, ' Tuesday', '8:00 AM - 11:00 AM'),
(2, 1, ' Tuesday', '8:00 AM - 11:00 AM'),
(3, 2, ' Tuesday', '8:00 AM - 11:00 AM');

-- --------------------------------------------------------

--
-- Table structure for table `fitnessgoals`
--

DROP TABLE IF EXISTS `fitnessgoals`;
CREATE TABLE IF NOT EXISTS `fitnessgoals` (
  `goalID` int(11) NOT NULL,
  `MemberID` int(11) NOT NULL,
  `GoalName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goalID`,`MemberID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fitnessgoals`
--

INSERT INTO `fitnessgoals` (`goalID`, `MemberID`, `GoalName`) VALUES
(1, 1, 'Muscle Gain'),
(2, 2, 'Muscle Gain');

-- --------------------------------------------------------

--
-- Table structure for table `healthcarepro`
--

DROP TABLE IF EXISTS `healthcarepro`;
CREATE TABLE IF NOT EXISTS `healthcarepro` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Unique Name` (`Name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `healthcarepro`
--

INSERT INTO `healthcarepro` (`ID`, `Name`, `Email`) VALUES
(1, 'Dr. Smith', 'dr.smith@example.com'),
(2, 'Dr. Johnson', 'dr.johnson@example.com'),
(3, 'Dr. Williams', 'dr.williams@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `MemberID` int(11) NOT NULL,
  `UserName` varchar(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `MedicalCondition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MemberID`) USING BTREE,
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`MemberID`, `UserName`, `Name`, `Email`, `MedicalCondition`) VALUES
(1, 'johndoe', 'John Doe', 'john@example.com', 'No medical conditions'),
(2, 'janesmith', 'Jane Smith', 'jane@example.com', 'Asthma');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE IF NOT EXISTS `userlogin` (
  `UserName` varchar(10) NOT NULL,
  `UserType` varchar(50) NOT NULL,
  `Password` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`UserName`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`UserName`, `UserType`, `Password`) VALUES
('janesmith', 'Member', 'password'),
('Joe', 'Staff', 'elgzvRjl'),
('johndoe', 'Member', 'password'),
('Newly', 'Staff', 'erDCeTz0'),
('user3', 'Admin', 'adminpas'),
('user5', 'Registration manager', 'regmanag');

--
-- Triggers `userlogin`
--
DROP TRIGGER IF EXISTS `insert_staff`;
DELIMITER $$
CREATE TRIGGER `insert_staff` AFTER INSERT ON `userlogin` FOR EACH ROW BEGIN
    -- Insert a corresponding row into the Staff table
    INSERT INTO Staff (UserName) VALUES (NEW.UserName);
END
$$
DELIMITER ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_Admin_UserLogin` FOREIGN KEY (`UserName`) REFERENCES `userlogin` (`UserName`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`memberID`) REFERENCES `member` (`MemberID`);

--
-- Constraints for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD CONSTRAINT `enrollment_ibfk_1` FOREIGN KEY (`classID`) REFERENCES `class` (`ID`),
  ADD CONSTRAINT `enrollment_ibfk_2` FOREIGN KEY (`memberID`) REFERENCES `member` (`MemberID`);

--
-- Constraints for table `fitnessgoals`
--
ALTER TABLE `fitnessgoals`
  ADD CONSTRAINT `fitnessgoals_ibfk_1` FOREIGN KEY (`MemberID`) REFERENCES `member` (`MemberID`) ON DELETE CASCADE ON UPDATE CASCADE;

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
