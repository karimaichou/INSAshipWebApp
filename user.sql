-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 06 Janvier 2017 à 16:35
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `insaship`
--

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `DTYPE` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `dateInscription` datetime DEFAULT NULL,
  `dateOfBirth` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `scholarYear` int(11) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `verified` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`DTYPE`, `id`, `email`, `firstName`, `lastName`, `password`, `username`, `address`, `dateInscription`, `dateOfBirth`, `description`, `sex`, `year`, `telephone`, `scholarYear`, `token`, `verified`) VALUES
('Student', 1, 'karima.ichou@gmail.com', 'karima', 'ichou', 'oma', 'karima.ichou@gmai.com', '15 avenue colonel Roche 31400 toulouse', '2016-11-23 00:00:00', '1994-02-01 00:00:00', 'final year software engineering student at insa Toulouse', 'female', NULL, '0669541224', 5, NULL, 1),
('Company', 2, 'contact@orange-test.fr', NULL, NULL, 'orange', 'Orange', '109 Avenue du Général Eisenhower, 31000 Toulouse', '2017-01-06 00:00:00', NULL, NULL, NULL, NULL, '0567483948', NULL, NULL, 1),
('Company', 3, 'contact@airbus-test.fr', NULL, NULL, 'airbus', 'Airbus', 'AEROPARK,, 3 Chemin de Laporte, 31300 Toulouse', '2017-01-05 00:00:00', NULL, NULL, NULL, NULL, '05 34 46 90 00', NULL, NULL, 1),
('Company', 4, 'ssi-toulouse@ssi.fr', NULL, NULL, 'rhssitoulouse', 'ssiEtudiant', '116 Route Espagne', '2017-01-01 00:00:00', NULL, NULL, NULL, NULL, '05 61 16 20 57', NULL, NULL, 1),
('INSA', 5, 'contact@insa-toulouse.fr', NULL, NULL, 'toulouseinsa', 'insatoulouse', NULL, '2017-01-06 00:00:00', NULL, NULL, NULL, 5, '0547382910', NULL, NULL, 1),
('INSA', 6, 'contact-emmanuel@insa-toulouse.fr', NULL, NULL, 'emmanuelnsa', 'emmanuel', NULL, '2017-01-05 00:00:00', NULL, NULL, NULL, 4, '0656435687', NULL, NULL, 1),
('Student', 7, 'borek-stastny@gmail.com', 'borek', 'stastny', 'borekborek', 'borekStastny', 'r4, 135 avenue rangueil 31400 toulouse', '2017-01-06 00:00:00', '1994-08-06 00:00:00', 'student at Insa of toulouse from Prague :)', 'm', NULL, '0648595736', 4, NULL, 1),
('FSD', 8, 'fsd-toulouse@fsd.fr', NULL, NULL, 'securityfsd', 'fsdToulouse', '134 avenue de rangueil, 31400 toulouse', '2017-01-01 00:00:00', NULL, NULL, NULL, NULL, '0648329371', NULL, NULL, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
