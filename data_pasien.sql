-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2018 at 10:09 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `databaseai`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `ID` int(11) NOT NULL,
  `JK` char(1) NOT NULL,
  `tinggi` varchar(10) NOT NULL,
  `berat` varchar(10) NOT NULL,
  `usia` varchar(10) NOT NULL,
  `hasil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`ID`, `JK`, `tinggi`, `berat`, `usia`, `hasil`) VALUES
(1, 'P', 'TINGGI', 'BERAT', 'TUA', 'HIPERTENSI'),
(2, 'W', 'PENDEK', 'RINGAN', 'MUDA', 'HIPOTENSI'),
(3, 'W', 'TINGGI', 'RINGAN', 'MUDA', 'HIPOTENSI'),
(4, 'P', 'TINGGI', 'BERAT', 'MUDA', 'HIPOTENSI'),
(5, 'P', 'TINGGI', 'BERAT', 'TUA', 'HIPERTENSI'),
(6, 'P', 'PENDEK', 'BERAT', 'MUDA', 'HIPERTENSI'),
(7, 'P', 'PENDEK', 'BERAT', 'TUA', 'HIPERTENSI'),
(8, 'P', 'TINGGI', 'RINGAN', 'MUDA', 'HIPERTENSI'),
(9, 'W', 'TINGGI', 'BERAT', 'TUA', 'HIPERTENSI'),
(10, 'W', 'TINGGI', 'BERAT', 'TUA', 'HIPERTENSI'),
(11, 'P', 'PENDEK', 'RINGAN', 'MUDA', 'HIPOTENSI'),
(12, 'P', 'PENDEK', 'RINGAN', 'TUA', 'HIPOTENSI'),
(13, 'W', 'PENDEK', 'BERAT', 'TUA', 'HIPERTENSI'),
(14, 'W', 'PENDEK', 'RINGAN', 'TUA', 'HIPERTENSI'),
(15, 'P', 'TINGGI', 'BERAT', 'TUA', 'HIPERTENSI'),
(16, 'P', 'TINGGI', 'RINGAN', 'TUA', 'HIPERTENSI'),
(17, 'P', 'TINGGI', 'BERAT', 'TUA', 'HIPERTENSI'),
(18, 'W', 'PENDEK', 'BERAT', 'MUDA', 'HIPERTENSI'),
(19, 'P', 'PENDEK', 'RINGAN', 'MUDA', 'HIPOTENSI'),
(20, 'W', 'TINGGI', 'RINGAN', 'MUDA', 'HIPOTENSI'),
(21, 'W', 'PENDEK', 'RINGAN', 'MUDA', 'HIPOTENSI'),
(22, 'W', 'PENDEK', 'RINGAN', 'TUA', 'HIPOTENSI'),
(23, 'P', 'TINGGI', 'BERAT', 'TUA', 'HIPERTENSI'),
(24, 'P', 'TINGGI', 'RINGAN', 'TUA', 'HIPERTENSI'),
(25, 'P', 'TINGGI', 'BERAT', 'TUA', 'HIPERTENSI'),
(26, 'W', 'PENDEK', 'BERAT', 'TUA', 'HIPERTENSI'),
(27, 'W', 'TINGGI', 'RINGAN', 'TUA', 'HIPOTENSI'),
(28, 'W', 'PENDEK', 'RINGAN', 'MUDA', 'HIPOTENSI'),
(29, 'P', 'PENDEK', 'RINGAN', 'MUDA', 'HIPOTENSI'),
(30, 'W', 'PENDEK', 'RINGAN', 'MUDA', 'HIPOTENSI');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data`
--
ALTER TABLE `data`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
