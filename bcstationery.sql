-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2018 at 05:07 PM
-- Server version: 5.7.14
-- PHP Version: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bcstationery`
--
CREATE DATABASE IF NOT EXISTS `bcstationery` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bcstationery`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `FirstName`, `LastName`, `Username`, `Password`) VALUES
(1, 'Charne', 'Jordaan', 'charnej', 'charnej');

-- --------------------------------------------------------

--
-- Table structure for table `campuslocation`
--

CREATE TABLE `campuslocation` (
  `CampusID` int(11) NOT NULL,
  `CampusName` varchar(50) NOT NULL,
  `StreetNr` varchar(50) NOT NULL,
  `StreetName` varchar(50) NOT NULL,
  `Suburb` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Province` varchar(50) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `Postal Code` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `campuslocation`
--

INSERT INTO `campuslocation` (`CampusID`, `CampusName`, `StreetNr`, `StreetName`, `Suburb`, `City`, `Province`, `Country`, `Postal Code`) VALUES
(1, 'Pretoria Campus', '138 ', 'Sixth Ave', 'Heatherdale', 'Pretoria', 'Gauteng', 'South Africa', '0182'),
(2, 'Kempton Park Campus', '45A', 'Long St', 'Kempton Park', 'Johannesburg', 'Gauteng', 'South Africa', '1619');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `CategoryID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CategoryID`, `Name`) VALUES
(1, 'Pens, Pencils, & Markers'),
(2, 'Punches & Staplers'),
(3, 'Correction');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `DepartmentID` int(11) NOT NULL,
  `DepartmentName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`DepartmentID`, `DepartmentName`) VALUES
(1, 'Lecturer'),
(2, 'Management'),
(3, 'Administration'),
(4, 'Cleaning'),
(5, 'Maintenance');

-- --------------------------------------------------------

--
-- Table structure for table `purchaseorders`
--

CREATE TABLE `purchaseorders` (
  `OrderNr` int(11) NOT NULL,
  `OrderDate` date NOT NULL,
  `StockID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `StaffID` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Cellphone` varchar(10) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Department` int(11) NOT NULL,
  `CampusLocation` int(11) NOT NULL,
  `Accepted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaffID`, `FirstName`, `LastName`, `Email`, `Cellphone`, `Username`, `Password`, `Department`, `CampusLocation`, `Accepted`) VALUES
(1, 'Clark', 'Kent', 'clarky@bc.ac.za', '0825564879', 'clarkk', '1234', 1, 1, 0),
(2, 'Ilicia', 'Jordaan', 'iliciaj@bc.ac.za', '0829772558', 'iliciaj', '1234', 1, 1, 1),
(3, 'Stefan', 'Smith', 'stefans@bc.ac.za', '0789723368', 'stefans', '0000', 2, 1, 1),
(4, 'Carlien', 'Sadie', 'carliens@bc.ac.za', '0842397785', 'carliens', '12345', 3, 1, 1),
(5, 'Adri', 'Koen', 'adri@bc.ac.za', '0873483312', 'adrik', '12345', 1, 1, 1),
(6, 'Joe', 'Smith', 'joes@bc.ac.za', '0837193287', 'joe', '1234', 5, 1, 0),
(7, 'Sarita', 'Jordaan', 'saritaj@bc.ac.za', '0825564218', 'saritaj', '12345', 1, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `staffrequest`
--

CREATE TABLE `staffrequest` (
  `RequestNr` int(11) NOT NULL,
  `RequestDate` date NOT NULL,
  `StaffID` int(11) NOT NULL,
  `StockID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Complete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `StockID` int(11) NOT NULL,
  `ProductName` varchar(50) NOT NULL,
  `Manufacturer` varchar(50) NOT NULL,
  `Category` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int(11) NOT NULL,
  `EntryDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`StockID`, `ProductName`, `Manufacturer`, `Category`, `Price`, `Quantity`, `EntryDate`) VALUES
(1, 'Clic Ballpoint Pen Black 4 Pack Blue', 'BIC ', 1, 32, 10, '2018-10-17'),
(2, 'Clic Ballpoint Pen Green 2 Pack Green', 'BIC', 1, 19.8, 10, '2018-10-12'),
(3, '105 Steel Stapler Silver', 'PARROT ', 2, 69.8, 5, '2018-10-12'),
(4, 'Full Strip Stapler', 'ARO ', 2, 79.8, 5, '2018-10-12'),
(5, 'Gel Retractable Pen - Red', 'Pilot', 1, 30, 12, '2018-10-17'),
(6, 'Eco HB Pencils - Blister of 8', 'Staedtler ', 1, 45.95, 20, '2018-10-17');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `campuslocation`
--
ALTER TABLE `campuslocation`
  ADD PRIMARY KEY (`CampusID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CategoryID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DepartmentID`);

--
-- Indexes for table `purchaseorders`
--
ALTER TABLE `purchaseorders`
  ADD PRIMARY KEY (`OrderNr`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`StaffID`);

--
-- Indexes for table `staffrequest`
--
ALTER TABLE `staffrequest`
  ADD PRIMARY KEY (`RequestNr`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`StockID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `campuslocation`
--
ALTER TABLE `campuslocation`
  MODIFY `CampusID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `CategoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `DepartmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `purchaseorders`
--
ALTER TABLE `purchaseorders`
  MODIFY `OrderNr` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `StaffID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `staffrequest`
--
ALTER TABLE `staffrequest`
  MODIFY `RequestNr` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `StockID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
