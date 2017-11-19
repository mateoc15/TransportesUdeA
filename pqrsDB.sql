-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2016 a las 01:47:59
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pqrsdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employee`
--

CREATE TABLE `employee` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `salary` double NOT NULL,
  `email` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `employee`
--

INSERT INTO `employee` (`id`, `name`, `last_name`, `salary`, `email`, `start_date`, `password`) VALUES
('1', 'Pepe', 'Perez', 10000, 'pepito@gmail.com', '2015-03-12', 'qwerty'),
('1010101', 'alejojojo', 'jojojojo', 101010, 'alejo@isaza.com', '2016-11-20', 'YWxlam9pc2F6YTEyMw=='),
('11111111', '111111111', '11111111111', 11111, '111@111.com', '2016-11-20', 'MTExMTExMTEx'),
('1202', 'alejo', 'isaza', 10000000, 'alejo@alejo.com', '2016-11-18', 'cGFzc3dvcmQxMjM='),
('2', 'Catalina', 'Rengifo', 10.5, 'catalina@gmail.com', '2015-04-04', 'password'),
('5', 'Manuel', 'Artemio', 311231.5, 'manuel@hotmail.com', '2014-03-04', '123'),
('6', 'david', 'Ospina', 41231.6, 'checho@gmail.com', '2014-02-21', '12345'),
('9090', 'jorge', 'kokok', 101010, 'ko@ko.com', '2016-11-20', 'a29rbzEyMzQ1Ng=='),
('90909', 'rjorjo', 'joajaojaojao', 12121212, 'joajoa@jajaiji.com', '2016-11-20', 'amFpamFpamFpag==');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `report`
--

CREATE TABLE `report` (
  `id` int(5) NOT NULL,
  `description` text NOT NULL,
  `status` varchar(255) NOT NULL,
  `id_report_type` varchar(255) NOT NULL,
  `id_emp` varchar(255) DEFAULT NULL,
  `id_user` varchar(255) NOT NULL,
  `create_date` date NOT NULL,
  `response` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `report`
--

INSERT INTO `report` (`id`, `description`, `status`, `id_report_type`, `id_emp`, `id_user`, `create_date`, `response`) VALUES
(2, 'Deberían de ponerle 5 a estos muchachos desarrolladores', 'Revisado', '1', '1', '90909090', '2016-10-17', 'ahora no monito'),
(3, 'epa epa epa rico', 'Revisado', '1', '1010101', '1', '2016-11-09', '121212'),
(4, 'epa epa epa rico', 'Revisado', '1', '1010101', '1', '2016-11-09', '1212'),
(6, 'epa epa epa rico', 'Revisado', '3', '1010101', '1', '2016-11-09', '121212'),
(7, 'sabe que usd es un mal ejemplo', 'Pendiente', '3', NULL, '90909090', '2016-11-20', NULL),
(8, 'kodkeodkoekd edeodked edoedomed', 'Revisado', '2', '1202', '909090909', '2016-11-21', 'parcerito sabe que todo bn todo bonito'),
(10, 'nononon como asi eso no aguanta', 'Pendiente', '2', NULL, '909090909', '2016-11-21', NULL),
(11, 'hola como estan bn o q', 'Pendiente', '3', NULL, '909090909', '2016-11-21', NULL),
(12, 'qwqw', 'Pendiente', '2', NULL, '909090909', '2016-11-21', NULL),
(13, '12121212', 'Pendiente', '1', NULL, '909090909', '2016-11-21', NULL),
(14, 'qwqwqw', 'Pendiente', '4', NULL, '909090909', '2016-11-21', NULL),
(15, 'qwqwqw', 'Pendiente', '4', NULL, '909090909', '2016-11-21', NULL),
(16, 'qwqwqw', 'Pendiente', '2', NULL, '909090909', '2016-11-21', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `report_type`
--

CREATE TABLE `report_type` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `report_type`
--

INSERT INTO `report_type` (`id`, `name`) VALUES
('1', 'Peticion'),
('2', 'Queja'),
('3', 'Reclamo'),
('4', 'Solicitud');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`, `phone`, `city`, `last_name`, `password`, `email`) VALUES
('1', 'Camila', '6522858', 'lejos', 'Largo', '456123', 'nomelose@live.com'),
('101010101', 'kaoakoakaok', '1010101', 'akoakoakoa', 'kaokoakoakoa', 'a2Fva2Fva2Fva2Fv', 'kaokaokaoa@jkaokaoako.com'),
('1111111111111', '111111111111111', '12', 'aaaaaa', '11111111111111', 'b2FvYW9hb2FvYW8=', '111111111111@kkakaa.com'),
('2', 'Andres', '3052485852', 'Bogota', 'Rodriguez', '123456', 'noresponder@yahoo.es'),
('20', 'Elisa', '858', 'muy lejos', 'tutucuerpo', '654123', 'que@gmail.com'),
('90909090', 'alejo', '90909090', 'ñññññ', 'isaza', 'a29rb2tvMTIz', 'koko@koko.com'),
('909090909', 'lalalal', '81818', 'mememe', 'isaza', 'bGFsYWxhMTIz', 'lalala@lalala.com'),
('90909090909', 'akakakkakaka', '1010101010', 'medlemeo', 'kakakakakak', 'amFqYWphamFhag==', 'kakakaka@jajaj'),
('plplplpl', 'jajhajajajaju', '12912891289', 'ksiwiosjwid', 'pakaokjai', 'aWFqaWFqaWFqaWE=', 'kaijai@jaijaija'),
('{"0":{"ng339":13},"1":{"ng339":21},"id":{"ng339":13},"password":{"ng339":13}}', 'kjwjwidjiwdji', '121212989', 'jdijwdijwidji', 'jiwdjiwjdi', 'amRqcWlkamk=', 'jiwdjiwjd@jhwduwjhud'),
('{"ng339":13}', '121212121212', '1212121212', '12121212', '12121212121', 'MTIxMjEyMTIxMjEy', '12121221@1212');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `idx_report__id_emp` (`id_emp`);

--
-- Indices de la tabla `report_type`
--
ALTER TABLE `report_type`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `report`
--
ALTER TABLE `report`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `fk_report__id_emp` FOREIGN KEY (`id_emp`) REFERENCES `employee` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
