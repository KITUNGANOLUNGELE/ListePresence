-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 22 fév. 2022 à 05:41
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tpo`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id_etudiant` varchar(6) NOT NULL,
  `nom_etudiant` varchar(20) NOT NULL,
  `postnom_etudiant` varchar(20) NOT NULL,
  `prenom_etudiant` varchar(20) NOT NULL,
  `date_presence` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id_etudiant`, `nom_etudiant`, `postnom_etudiant`, `prenom_etudiant`, `date_presence`) VALUES
('1', 'KITUNGANO', 'LUNGELE', 'Henock', '21 février 2022'),
('2', 'TUYISHIME', 'Isaac', 'Isaac', '21 février 2022'),
('3', 'KATEMBO', 'KIKANAVYA', 'EMMANUEL', '21 février 2022'),
('4', 'MULEY', 'LUBWENDE', 'Glody', '21 février 2022'),
('5', 'KYAKIMWA', 'VIKASIMBAKI', 'Neema', '21 février 2022'),
('6', 'BAMBA', 'CHRISTELLE', 'Olivia', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `presence`
--

CREATE TABLE `presence` (
  `id_presence` bigint(20) NOT NULL,
  `date_presence` text NOT NULL,
  `satus_presence` varchar(20) NOT NULL,
  `id_etudiant` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `presence`
--

INSERT INTO `presence` (`id_presence`, `date_presence`, `satus_presence`, `id_etudiant`) VALUES
(2, '21 févriver 2022', 'present', '1'),
(3, '21 févriver 2022', 'present', '2'),
(4, '21 févriver 2022', 'present', '3'),
(5, '21 févriver 2022', 'present', '4'),
(6, '21 févriver 2022', 'present', '5');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id_etudiant`);

--
-- Index pour la table `presence`
--
ALTER TABLE `presence`
  ADD PRIMARY KEY (`id_presence`),
  ADD KEY `id_etudiant` (`id_etudiant`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `presence`
--
ALTER TABLE `presence`
  MODIFY `id_presence` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `presence`
--
ALTER TABLE `presence`
  ADD CONSTRAINT `presence_ibfk_1` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
