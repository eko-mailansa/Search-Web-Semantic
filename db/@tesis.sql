-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 18, 2017 at 06:52 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `@tesis`
--

-- --------------------------------------------------------

--
-- Table structure for table `link`
--

CREATE TABLE IF NOT EXISTS `link` (
  `link_id` int(5) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) NOT NULL,
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `link`
--

INSERT INTO `link` (`link_id`, `link`) VALUES
(1, 'www.informatika.com'),
(2, 'www.google.com'),
(3, 'www.google.com'),
(4, 'www.google.com'),
(5, 'www.informatika.org');

-- --------------------------------------------------------

--
-- Table structure for table `tesis`
--

CREATE TABLE IF NOT EXISTS `tesis` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `judul` mediumtext NOT NULL,
  `abstrak` longtext NOT NULL,
  `penulis` varchar(255) NOT NULL,
  `penerbit` varchar(255) NOT NULL,
  `tahunTerbit` varchar(4) NOT NULL,
  `tipe` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tesis`
--

INSERT INTO `tesis` (`id`, `judul`, `abstrak`, `penulis`, `penerbit`, `tahunTerbit`, `tipe`) VALUES
(1, 'PENERAPAN WEB SEMANTIK PADA ONTOLOGI PERPUSTAKAAN DIGITAL PUSTAKA ILMIAH', 'Web adalah sebuah layanan internet yang sangat populer hingga saat ini. Web semantik adalah bagian dari teknologi web yang berkembang dan memiliki kemampuan dalam memahami makna dari sebuah kata, kalimat ataupun konsep.', 'eko', 'informatika', '2017', 'jurnal'),
(2, 'Foundations Of Semantic Web Technologies', 'Metadata and semantics for information search, integration and analysis has been practiced for three decades. Conceptual modeling and knowledge representation that enable rich description of information, and when needed\r\nassociated reasoning, have been with us for a while too. But as the Web brought much larger variety (heterogeneity) and size with it, coming together of the semantics, the Web technologies and all the data that goes with it, was inevitable. Nearly a decade after Tim Berners-Lee coined the term Semantic Web, it has transformed into a growing, important, and well recognized interdisciplinary area of Computer Science. W3C’s e?ort has led to widely adopted language standards, which has contributed to the development of Semantic Technologies for the Web of data, and a host of new and established companies are innovating tools, applications, products and services based on these standards and technologies at a rapid pace. With three key conferences focused on this topic, including the ?agship International Semantic Web Con-ference, as well as at least 20 other conferences o?ering Semantic Web as a signi?cant subarea of interest, the Semantic Web is a topic that is here to\r\nstay.', 'Pascal Hitzler, Markus Krötzsch, and Sebastian Rudolph', 'Taylor and Francis Group, LLC Chapman & Hall/CRC', '2010', 'ebook'),
(3, 'java', 'Java Programming', 'eko', 'andi', '2017', 'proceeding'),
(4, 'java server faces', 'EJB', 'eko', 'andi', '2017', 'jurnal');
