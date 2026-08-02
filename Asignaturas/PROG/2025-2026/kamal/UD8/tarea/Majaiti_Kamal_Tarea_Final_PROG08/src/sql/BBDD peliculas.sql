CREATE DATABASE IF NOT EXISTS peliculas;
CREATE USER IF NOT EXISTS 'user'@'localhost' IDENTIFIED BY 'P1234';
GRANT ALL PRIVILEGES ON peliculas.* TO 'user'@'localhost';
FLUSH PRIVILEGES;
USE peliculas;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-04-2026 a las 02:32:17
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `peliculas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catalogo`
--

CREATE TABLE `catalogo` (
  `pelicula_id` int(11) NOT NULL,
  `Titulo` varchar(100) DEFAULT NULL,
  `director` varchar(100) DEFAULT NULL,
  `Genero` varchar(50) DEFAULT NULL,
  `anio_estreno` int(11) DEFAULT NULL,
  `duracion_minutos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `catalogo`
--

INSERT INTO `catalogo` (`pelicula_id`, `Titulo`, `director`, `Genero`, `anio_estreno`, `duracion_minutos`) VALUES
(1, 'Inception', 'Christopher Nolan', 'Ciencia Ficcion', 2010, 148),
(2, 'Titanic', 'James Cameron', 'Drama', 1997, 195),
(3, 'The Matrix', 'Lana Wachowski', 'Accion', 1999, 200),
(4, 'Star wars', 'Kamal', 'Anime', 2022, 999),
(5, 'Ahora me ves', 'Maria nose', 'Ciencia Ficcion', 2019, 180),
(8, 'Los simpson', 'David Silverman', 'Dibujos animados', 2007, 87);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `catalogo`
--
ALTER TABLE `catalogo`
  ADD PRIMARY KEY (`pelicula_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `catalogo`
--
ALTER TABLE `catalogo`
  MODIFY `pelicula_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
