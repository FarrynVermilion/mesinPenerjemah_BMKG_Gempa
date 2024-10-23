-- phpMyAdmin SQL Dump
-- version 5.2.1deb3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 09, 2024 at 11:19 AM
-- Server version: 10.11.8-MariaDB-0ubuntu0.24.04.1
-- PHP Version: 8.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `BMKG`
--

-- --------------------------------------------------------

--
-- Table structure for table `Data_Gempa_Terkini`
--

CREATE TABLE `Data_Gempa_Terkini` (
  `id` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Jam` time NOT NULL,
  `Datetime` datetime NOT NULL,
  `Lintang` float(10,2) NOT NULL,
  `Bujur` float(10,2) NOT NULL,
  `Magnitude` float(10,2) NOT NULL,
  `Kedalaman` float(10,2) NOT NULL,
  `Wilayah` text NOT NULL,
  `Potensi` text NOT NULL,
  `Dirasakan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Data_Gempa_Terkini`
--

INSERT INTO `Data_Gempa_Terkini` (`id`, `Tanggal`, `Jam`, `Datetime`, `Lintang`, `Bujur`, `Magnitude`, `Kedalaman`, `Wilayah`, `Potensi`, `Dirasakan`) VALUES
(0, '2024-10-02', '08:09:18', '2024-10-02 08:09:18', 7.35, 106.49, 4.50, 36.00, 'Pusat gempa berada di darat 40 km BaratDaya Kab-Sukabumi', 'Gempa ini dirasakan untuk diteruskan pada masyarakat', 'IV Simpenan Sukabumi, III Cikakak, III Pelabuhan Ratu, III Sukabumi, II Kabandungan, III Bayah, III Panggarangan, III Malingping, II-III Rangkasbitung, IV Ujung Genteng, IV Tegalbuleud, III-IV Kalibunder');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
