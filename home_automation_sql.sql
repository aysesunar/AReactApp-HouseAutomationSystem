-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 27, 2021 at 09:48 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `home_automation`
--

-- --------------------------------------------------------

--
-- Table structure for table `airconditioner`
--

DROP TABLE IF EXISTS `airconditioner`;
CREATE TABLE IF NOT EXISTS `airconditioner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `room_id` int(11) NOT NULL,
  `state` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `airconditioner`
--

INSERT INTO `airconditioner` (`id`, `name`, `room_id`, `state`) VALUES
(1, 'AC1', 1, b'1'),
(2, 'AC2', 2, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `curtain`
--

DROP TABLE IF EXISTS `curtain`;
CREATE TABLE IF NOT EXISTS `curtain` (
  `id` int(31) NOT NULL AUTO_INCREMENT,
  `name` varchar(31) NOT NULL,
  `state` tinyint(1) NOT NULL,
  `room_id` int(31) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `curtain`
--

INSERT INTO `curtain` (`id`, `name`, `state`, `room_id`) VALUES
(1, 'curtain 1', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `light`
--

DROP TABLE IF EXISTS `light`;
CREATE TABLE IF NOT EXISTS `light` (
  `id` int(31) NOT NULL AUTO_INCREMENT,
  `name` varchar(31) NOT NULL,
  `state` tinyint(1) NOT NULL,
  `room_id` int(31) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `light`
--

INSERT INTO `light` (`id`, `name`, `state`, `room_id`) VALUES
(1, 'light 1', 1, 1),
(2, 'light 1', 1, 2),
(3, 'light 2', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(31) NOT NULL AUTO_INCREMENT,
  `name` varchar(31) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `name`) VALUES
(1, 'Kitchen'),
(2, 'Living Room');

-- --------------------------------------------------------

--
-- Table structure for table `television`
--

DROP TABLE IF EXISTS `television`;
CREATE TABLE IF NOT EXISTS `television` (
  `id` int(31) NOT NULL AUTO_INCREMENT,
  `name` varchar(31) NOT NULL,
  `state` tinyint(1) NOT NULL,
  `room_id` int(31) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `television`
--

INSERT INTO `television` (`id`, `name`, `state`, `room_id`) VALUES
(1, 'living room television', 1, 2),
(2, 'kitchen TV', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `temperature`
--

DROP TABLE IF EXISTS `temperature`;
CREATE TABLE IF NOT EXISTS `temperature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `degree` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `room_id` int(11) NOT NULL,
  `state` bit(1) DEFAULT NULL,
  `temperature` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `temperature`
--

INSERT INTO `temperature` (`id`, `degree`, `name`, `room_id`, `state`, `temperature`) VALUES
(1, 25, NULL, 0, NULL, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
