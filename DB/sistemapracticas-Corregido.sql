-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2017 a las 00:53:11
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemapracticas`
--
CREATE DATABASE IF NOT EXISTS `sistemapracticas` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `sistemapracticas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacionpracticas`
--

CREATE TABLE `asignacionpracticas` (
  `idAsignacionPractica` int(11) NOT NULL,
  `idEstudiante` int(11) NOT NULL,
  `idDocente` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL,
  `idTutor` int(11) NOT NULL,
  `ingresoEstudiante` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `gestionAcademica` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `fechaInicioPractica` date NOT NULL,
  `fechaFinPractica` date NOT NULL,
  `areaPractica` varchar(500) COLLATE latin1_spanish_ci NOT NULL,
  `totalHoras` int(11) NOT NULL,
  `aprobadoMateria` int(11) NOT NULL,
  `estadoPractica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `asignacionpracticas`
--

INSERT INTO `asignacionpracticas` (`idAsignacionPractica`, `idEstudiante`, `idDocente`, `idMateria`, `idTutor`, `ingresoEstudiante`, `gestionAcademica`, `fechaInicioPractica`, `fechaFinPractica`, `areaPractica`, `totalHoras`, `aprobadoMateria`, `estadoPractica`) VALUES
(1, 1, 1, 1, 1, '2012-A', '2017-A', '2017-03-07', '2017-06-01', 'Facultad de Ciencias Economicas y Administrativas', 300, 1, 0),
(4, 1, 1, 5, 1, '2012-A', '2017-B', '2017-08-07', '2017-12-01', 'Facultad de Ingenieria', 350, 0, 1),
(6, 6, 1, 1, 1, '2012-A', '2017-B', '2017-08-07', '2017-08-07', 'Sistemas', 200, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `idCarrera` int(11) NOT NULL,
  `idFacultad` int(11) NOT NULL,
  `idCoordinador` int(11) NOT NULL,
  `nombreCarrera` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `abreviaturaCarrera` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `descripcionCarrera` text COLLATE latin1_spanish_ci NOT NULL,
  `estadoCarrera` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`idCarrera`, `idFacultad`, `idCoordinador`, `nombreCarrera`, `abreviaturaCarrera`, `descripcionCarrera`, `estadoCarrera`) VALUES
(1, 2, 1, 'Licenciatura en Administracion de Empresas', 'Adm', 'La carrera de Administracion de Empresas', 1),
(2, 2, 1, 'Licenciatura en Contaduria Publica', 'Con', 'La carrera de Contaduria Publica', 1),
(3, 2, 1, 'Licenciatura en Ingenieria Comercial', 'Ico', 'La carrera de Ingenieria Comercial', 1),
(7, 2, 4, 'Licenciatura en Ingenieria', 'Ifi', 'es la licenciatura en ingenieria financiera....', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coordinador`
--

CREATE TABLE `coordinador` (
  `idCoordinador` int(11) NOT NULL,
  `primerNombreCoordinador` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `segundoNombreCoordinador` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `primerApellidoCoordinador` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `segundoApellidoCoordinador` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ciCoordinador` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `telefonoCoordinador` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `estadoCoordinador` int(11) NOT NULL,
  `fotoCoordinador` varchar(100) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `coordinador`
--

INSERT INTO `coordinador` (`idCoordinador`, `primerNombreCoordinador`, `segundoNombreCoordinador`, `primerApellidoCoordinador`, `segundoApellidoCoordinador`, `ciCoordinador`, `telefonoCoordinador`, `estadoCoordinador`, `fotoCoordinador`) VALUES
(1, 'Juan', 'Elias', 'Rodriguez', 'Sauer', '3968935', '69546746', 1, 'Lindsay-VargasCarrasco.jpg'),
(4, 'Elias', '', 'Estigarribia', 'Perez', '68547844', '69386875', 1, 'imagen7.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `criterios`
--

CREATE TABLE `criterios` (
  `idCriterios` int(11) NOT NULL,
  `idDimensiones` int(11) NOT NULL,
  `nombreCriterio` varchar(300) COLLATE latin1_spanish_ci NOT NULL,
  `estadoCriterio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `criterios`
--

INSERT INTO `criterios` (`idCriterios`, `idDimensiones`, `nombreCriterio`, `estadoCriterio`) VALUES
(1, 1, 'Demuestra Seguridad y Habilidad en Trabajo', 1),
(3, 1, 'Es ordenando y prolijo. Realiza las tareas asignadas con esmero y dedicación.', 1),
(4, 1, 'Planifica el trabajo a realizar.', 1),
(5, 1, 'Distribuye el tiempo según las necesidades.', 1),
(6, 1, 'Usa adecuadamente los equipos tecnológicos proporcionados.', 1),
(18, 5, 'Identifica los objetivos de la unidad donde trabaja.', 1),
(19, 5, 'Es capaz de identificar situaciones que requieren la oportuna intervención profesional en su área de trabajo.', 1),
(20, 5, 'En sus intervenciones, propone soluciones acertadas a los problemas existentes.', 1),
(21, 5, 'Presenta propuestas creativas e innovadoras para optimizar el trabajo.', 1),
(22, 5, 'Integra adecuadamente la teoría y práctica que permite mantener la rigurosidad científica.', 1),
(23, 6, 'Es respetuoso con el equipo de trabajo y la atención a las personas.', 1),
(24, 6, 'La indumentaria, el uso del lenguaje y la puntualidad caracteriza al practicante.', 1),
(25, 6, 'Es asertivo y empático con las personas.', 1),
(26, 6, 'Denota interés por aprender cosas nuevas.', 1),
(27, 6, 'Reacciona de forma proactiva frente a las situaciones que le corresponde enfrentar.', 1),
(28, 7, 'Se comunica con propiedad y fluidez.', 1),
(29, 7, 'Participa activamente en las actividades programadas por la empresa/institución.', 1),
(30, 7, 'Es cortés y tiene buen trato con sus semejantes.', 1),
(31, 7, 'Su comportamiento denota poseer altos valores éticos y morales.', 1),
(32, 7, 'Es colaborador, capaz de integrarse al equipo de trabajo.', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallepracticas`
--

CREATE TABLE `detallepracticas` (
  `idDetalles` int(11) NOT NULL,
  `idPracticas` int(11) NOT NULL,
  `tareaAsignada` varchar(500) COLLATE latin1_spanish_ci NOT NULL,
  `observacionTarea` text COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dimensiones`
--

CREATE TABLE `dimensiones` (
  `idDimensiones` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL,
  `nombreDimension` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `estadoDimension` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `dimensiones`
--

INSERT INTO `dimensiones` (`idDimensiones`, `idMateria`, `nombreDimension`, `estadoDimension`) VALUES
(1, 5, 'Organizacion y Ejecucion del Trabajo', 1),
(2, 2, 'Organizacion y Ejecucion del Trabajo', 1),
(3, 3, 'Organizacion y Ejecucion del Trabajo', 1),
(5, 5, 'Capacidad Empresarial', 1),
(6, 5, 'Aspecto Actitudinal', 1),
(7, 5, 'Proyeccion Educativa', 1),
(8, 5, 'Proyectoasldkhash', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

CREATE TABLE `docente` (
  `idDocente` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idFacultad` int(11) NOT NULL,
  `primerNombreDocente` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `segundoNombreDocente` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `primerApellidoDocente` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `segundoApellidoDocente` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ciDocente` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `telefonoDocente` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `estadoDocente` int(11) NOT NULL,
  `fotoDocente` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fondoDocente` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `docente`
--

INSERT INTO `docente` (`idDocente`, `idUsuario`, `idFacultad`, `primerNombreDocente`, `segundoNombreDocente`, `primerApellidoDocente`, `segundoApellidoDocente`, `ciDocente`, `telefonoDocente`, `estadoDocente`, `fotoDocente`, `fondoDocente`) VALUES
(1, 1, 2, 'Lindsay', '', 'Vargas', 'Carrazco', '39901291', '987986', 1, '../img/fcea/estudiantes/Lindsay-VargasCarrasco.jpg', '../img/fcea/estudiantes/lluvia.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL,
  `idRepresentante` int(11) NOT NULL,
  `nombreEmpresa` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `direccionEmpresa` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  `telefonoEmpresa` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `rubroEmpresa` text COLLATE latin1_spanish_ci NOT NULL,
  `estadoEmpresa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`idEmpresa`, `idRepresentante`, `nombreEmpresa`, `direccionEmpresa`, `telefonoEmpresa`, `rubroEmpresa`, `estadoEmpresa`) VALUES
(1, 1, 'Rico Pan', 'Vinto-pairumani', '9876876', 'Panaderia', 1),
(2, 2, 'Universidad Adventista de Bolivia', 'Av. Simon I. Patiño Km 1 1/2', '4263330', 'Universidad', 1),
(3, 3, 'Consultor Y Logistica \"Teran\"', 'Av. Ernesto Cespedes y Sucre', '79360915', 'Consultora', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `idEstudiante` int(11) NOT NULL,
  `primerNombreEstudiante` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `segundoNombreEstudiante` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `primerApellidoEstudiante` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `segundoApellidoEstudiante` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ciEstudiante` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `telefonoEstudiante` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `estadoEstudiante` int(11) NOT NULL,
  `fotoEstudiante` varchar(200) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`idEstudiante`, `primerNombreEstudiante`, `segundoNombreEstudiante`, `primerApellidoEstudiante`, `segundoApellidoEstudiante`, `ciEstudiante`, `telefonoEstudiante`, `estadoEstudiante`, `fotoEstudiante`) VALUES
(1, 'Elias', 'Jonathan', 'Leonardi', 'Sauer', 'E-10132446', '69546746', 1, 'imagen4.jpg'),
(6, 'Joel', '', 'Vargas', 'Carrasco', '76830293', '78678554', 1, 'imagen7.jpg'),
(8, 'Lizeth', '', 'Camacho', 'Rodriguez', '8812776', '69752621', 1, 'foto1.jpeg'),
(9, 'Liseth', 'Dayana', 'Calderon', 'Castro', '7227586', '75168900', 1, 'foto2.jpg'),
(10, 'Lucero', 'Neidy', 'Bustamante', 'Jaldin', '9301697', '76921770', 1, 'foto4.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facultad`
--

CREATE TABLE `facultad` (
  `idFacultad` int(11) NOT NULL,
  `idUniversidad` int(11) NOT NULL,
  `nombreFacultad` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `abreviaturaFacultad` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `descripcionFacultad` text COLLATE latin1_spanish_ci NOT NULL,
  `estadoFacultad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `facultad`
--

INSERT INTO `facultad` (`idFacultad`, `idUniversidad`, `nombreFacultad`, `abreviaturaFacultad`, `descripcionFacultad`, `estadoFacultad`) VALUES
(1, 1, 'Faculta de Teologia', 'FT', 'La facultad de Teologia', 1),
(2, 1, 'Facultad de Ciencias Economicas y Administrativas', 'FCEA', 'La facultad de FCEA', 1),
(3, 1, 'Facultad de Ingenieria', 'FI', 'La facultad de Ingenieria', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `idCarrera` int(11) NOT NULL,
  `nombreMateria` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `semestreMateria` varchar(5) COLLATE latin1_spanish_ci NOT NULL,
  `descripcionMateria` text COLLATE latin1_spanish_ci NOT NULL,
  `horasPracticas` int(11) NOT NULL,
  `estadoMateria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `idCarrera`, `nombreMateria`, `semestreMateria`, `descripcionMateria`, `horasPracticas`, `estadoMateria`) VALUES
(1, 1, 'Practica Empresarial I', 'VI', 'Aqui viene toda la descripcion de la materia de practica empresarial I correspondiente a la carrera de Licenciatura en Administracion de Empresas', 10, 1),
(2, 2, 'Practica Empresarial I', 'VI', 'Descripcion', 10, 1),
(3, 3, 'Practica Empresarial I', 'VI', 'Descripcion', 10, 1),
(5, 1, 'Practica Empresarial II', 'VII', 'Descripcion diferente ahora', 30, 1),
(6, 2, 'Practica Empresarial II', 'VII', 'Descripcion', 15, 1),
(9, 1, 'Practica Empresarial III', 'VIII', 'Descripcion', 20, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `idNotas` int(11) NOT NULL,
  `idAsignacionPractica` int(11) NOT NULL,
  `idCriterios` int(11) NOT NULL,
  `idParcial` int(11) NOT NULL,
  `nota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`idNotas`, `idAsignacionPractica`, `idCriterios`, `idParcial`, `nota`) VALUES
(1, 4, 1, 1, 10),
(2, 4, 3, 1, 10),
(3, 4, 4, 1, 5),
(4, 4, 5, 1, 10),
(5, 4, 6, 1, 10),
(6, 4, 18, 1, 10),
(7, 4, 19, 1, 7),
(8, 4, 20, 1, 10),
(9, 4, 21, 1, 10),
(10, 4, 22, 1, 10),
(11, 4, 23, 1, 10),
(12, 4, 24, 1, 10),
(13, 4, 25, 1, 10),
(14, 4, 26, 1, 10),
(15, 4, 27, 1, 10),
(16, 4, 28, 1, 10),
(17, 4, 29, 1, 10),
(18, 4, 30, 1, 4),
(19, 4, 31, 1, 10),
(20, 4, 32, 1, 10),
(21, 4, 1, 2, 10),
(22, 4, 3, 2, 10),
(23, 4, 4, 2, 10),
(24, 4, 5, 2, 10),
(25, 4, 6, 2, 10),
(26, 4, 18, 2, 10),
(27, 4, 19, 2, 10),
(28, 4, 20, 2, 10),
(29, 4, 21, 2, 10),
(30, 4, 22, 2, 10),
(31, 4, 23, 2, 10),
(32, 4, 24, 2, 10),
(33, 4, 25, 2, 10),
(34, 4, 26, 2, 10),
(35, 4, 27, 2, 10),
(36, 4, 28, 2, 10),
(37, 4, 29, 2, 10),
(38, 4, 30, 2, 10),
(39, 4, 31, 2, 10),
(40, 4, 32, 2, 10),
(61, 4, 1, 3, 5),
(62, 4, 3, 3, 6),
(63, 4, 4, 3, 8),
(64, 4, 5, 3, 4),
(65, 4, 6, 3, 9),
(66, 4, 18, 3, 2),
(67, 4, 19, 3, 10),
(68, 4, 20, 3, 10),
(69, 4, 21, 3, 10),
(70, 4, 22, 3, 5),
(71, 4, 23, 3, 8),
(72, 4, 24, 3, 6),
(73, 4, 25, 3, 4),
(74, 4, 26, 3, 7),
(75, 4, 27, 3, 3),
(76, 4, 28, 3, 1),
(77, 4, 29, 3, 10),
(78, 4, 30, 3, 10),
(79, 4, 31, 3, 5),
(80, 4, 32, 3, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parcial`
--

CREATE TABLE `parcial` (
  `idParcial` int(11) NOT NULL,
  `estadoParcial` int(2) NOT NULL,
  `nombreParcial` varchar(30) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `parcial`
--

INSERT INTO `parcial` (`idParcial`, `estadoParcial`, `nombreParcial`) VALUES
(1, 0, 'Primer Parcial'),
(2, 0, 'Segundo Parcial'),
(3, 0, 'Examen Final');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practicas`
--

CREATE TABLE `practicas` (
  `idPracticas` int(11) NOT NULL,
  `idAsignacionPractica` int(11) NOT NULL,
  `idParcial` int(11) NOT NULL,
  `fechaInicioEvaluacion` date NOT NULL,
  `fechaFinEvaluacion` date NOT NULL,
  `funcionPractica` varchar(500) COLLATE latin1_spanish_ci NOT NULL,
  `cantidadHoras` int(11) NOT NULL,
  `observacionEstudiante` text COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `practicas`
--

INSERT INTO `practicas` (`idPracticas`, `idAsignacionPractica`, `idParcial`, `fechaInicioEvaluacion`, `fechaFinEvaluacion`, `funcionPractica`, `cantidadHoras`, `observacionEstudiante`) VALUES
(1, 4, 1, '2017-11-01', '2017-11-30', 'Ayudante Varios', 80, 'Sin Observaciones');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `representante`
--

CREATE TABLE `representante` (
  `idRepresentante` int(11) NOT NULL,
  `primerNombreRepresentante` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `segundoNombreRepresentante` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `primerApellidoRepresentante` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `seguntoApellidoRepresentante` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ciRepresentante` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `telefonoRepresentante` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `estadoRepresentante` int(11) NOT NULL,
  `cargoRepresentante` varchar(100) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `representante`
--

INSERT INTO `representante` (`idRepresentante`, `primerNombreRepresentante`, `segundoNombreRepresentante`, `primerApellidoRepresentante`, `seguntoApellidoRepresentante`, `ciRepresentante`, `telefonoRepresentante`, `estadoRepresentante`, `cargoRepresentante`) VALUES
(1, 'Juan', 'Ramon', 'Sauer', 'Leonardi', '1015809', '871263', 1, 'Administrador'),
(2, 'Pablo', 'E', 'Paco', 'D', '5878457', '71737654', 1, 'Jefe Finanzas Alumnos'),
(3, 'Ramiro', '', 'Teran', 'Encinas', '000000', '00000000', 1, 'Gerente General');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `nombreRol` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `descripcionRol` text COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombreRol`, `descripcionRol`) VALUES
(1, 'Root', 'Es El super-Administrador'),
(2, 'Docente', 'Es el docente de las practicas empresariales, el que se encarga de distribuir a los estudiantes en las diferentes empresas'),
(3, 'Tutor', 'Son los tutores que son asignados en las diferentes empresas donde se les envia a los estudiantes.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutor`
--

CREATE TABLE `tutor` (
  `idTutor` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idEmpresa` int(11) NOT NULL,
  `primerNombreTutor` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `segundoNombreTutor` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `primerApellidoTutor` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `segundoApellidoTutor` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ciTutor` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `telefonoTutor` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `estadoTutor` int(11) NOT NULL,
  `cargoTutor` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `fotoTutor` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fondoTutor` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tutor`
--

INSERT INTO `tutor` (`idTutor`, `idUsuario`, `idEmpresa`, `primerNombreTutor`, `segundoNombreTutor`, `primerApellidoTutor`, `segundoApellidoTutor`, `ciTutor`, `telefonoTutor`, `estadoTutor`, `cargoTutor`, `fotoTutor`, `fondoTutor`) VALUES
(1, 2, 1, 'Elias', '', 'Sauer', '', '987676', '67288773', 1, 'Contador', '../img/fcea/tutores/Lindsay-VargasCarrasco.jpg', '../img/fcea/tutores/lluvia.jpg'),
(7, 16, 1, 'Mario', '', 'Rodriguez', 'Peña', '4537298', '67853632', 1, 'Administrador', '../img/fcea/tutores/Mario.jpg', '../img/fcea/tutores/lluvia.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `universidad`
--

CREATE TABLE `universidad` (
  `idUniversidad` int(11) NOT NULL,
  `nombreUniversidad` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `abreviaturaUniversidad` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `direccionUniversidad` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `telefonoUniversidad` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `estadoUniversidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `universidad`
--

INSERT INTO `universidad` (`idUniversidad`, `nombreUniversidad`, `abreviaturaUniversidad`, `direccionUniversidad`, `telefonoUniversidad`, `estadoUniversidad`) VALUES
(1, 'Universidad Adventista de Bolivia', 'UAB', 'Simon I. Patiño Km 1', '800109191', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `idRol` int(11) NOT NULL,
  `nombreUsuario` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `passwordUsuario` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `imagenUsuario` varchar(200) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fondoPerfilUser` varchar(200) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `idRol`, `nombreUsuario`, `passwordUsuario`, `imagenUsuario`, `fondoPerfilUser`) VALUES
(1, 2, 'lind', '123', 'Lindsay-VargasCarrasco.jpg', 'lluvia.jpg'),
(2, 3, 'elias', 'elias', 'Mario.jpg', 'lluvia.jpg'),
(3, 1, 'root', '159951', 'perfil.png', 'fondo.jpg'),
(16, 3, 'mrodriguez', '123', 'imagenT', 'fondoT');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignacionpracticas`
--
ALTER TABLE `asignacionpracticas`
  ADD PRIMARY KEY (`idAsignacionPractica`),
  ADD KEY `idMaterias` (`idMateria`),
  ADD KEY `idTutor` (`idTutor`),
  ADD KEY `idDocente` (`idDocente`),
  ADD KEY `idEstudiante` (`idEstudiante`);

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`idCarrera`),
  ADD KEY `idFacultad` (`idFacultad`),
  ADD KEY `idCoordinador` (`idCoordinador`);

--
-- Indices de la tabla `coordinador`
--
ALTER TABLE `coordinador`
  ADD PRIMARY KEY (`idCoordinador`);

--
-- Indices de la tabla `criterios`
--
ALTER TABLE `criterios`
  ADD PRIMARY KEY (`idCriterios`),
  ADD KEY `idDimensiones` (`idDimensiones`);

--
-- Indices de la tabla `detallepracticas`
--
ALTER TABLE `detallepracticas`
  ADD PRIMARY KEY (`idDetalles`),
  ADD KEY `idPracticas` (`idPracticas`);

--
-- Indices de la tabla `dimensiones`
--
ALTER TABLE `dimensiones`
  ADD PRIMARY KEY (`idDimensiones`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `docente`
--
ALTER TABLE `docente`
  ADD PRIMARY KEY (`idDocente`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idFacultad` (`idFacultad`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`idEmpresa`),
  ADD KEY `idRepresentante` (`idRepresentante`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`idEstudiante`);

--
-- Indices de la tabla `facultad`
--
ALTER TABLE `facultad`
  ADD PRIMARY KEY (`idFacultad`),
  ADD KEY `idUniversidad` (`idUniversidad`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`),
  ADD KEY `idCarrera` (`idCarrera`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`idNotas`),
  ADD KEY `idCriterios` (`idCriterios`),
  ADD KEY `idAsignacionPractica` (`idAsignacionPractica`),
  ADD KEY `idParcial` (`idParcial`);

--
-- Indices de la tabla `parcial`
--
ALTER TABLE `parcial`
  ADD PRIMARY KEY (`idParcial`);

--
-- Indices de la tabla `practicas`
--
ALTER TABLE `practicas`
  ADD PRIMARY KEY (`idPracticas`),
  ADD KEY `idAsignacionPracticas` (`idAsignacionPractica`),
  ADD KEY `idParcial` (`idParcial`);

--
-- Indices de la tabla `representante`
--
ALTER TABLE `representante`
  ADD PRIMARY KEY (`idRepresentante`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`idTutor`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idEmpresa` (`idEmpresa`);

--
-- Indices de la tabla `universidad`
--
ALTER TABLE `universidad`
  ADD PRIMARY KEY (`idUniversidad`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `idRol` (`idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignacionpracticas`
--
ALTER TABLE `asignacionpracticas`
  MODIFY `idAsignacionPractica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `carrera`
--
ALTER TABLE `carrera`
  MODIFY `idCarrera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `coordinador`
--
ALTER TABLE `coordinador`
  MODIFY `idCoordinador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `criterios`
--
ALTER TABLE `criterios`
  MODIFY `idCriterios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT de la tabla `detallepracticas`
--
ALTER TABLE `detallepracticas`
  MODIFY `idDetalles` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `dimensiones`
--
ALTER TABLE `dimensiones`
  MODIFY `idDimensiones` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `docente`
--
ALTER TABLE `docente`
  MODIFY `idDocente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `idEmpresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `idEstudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `facultad`
--
ALTER TABLE `facultad`
  MODIFY `idFacultad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `notas`
--
ALTER TABLE `notas`
  MODIFY `idNotas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
--
-- AUTO_INCREMENT de la tabla `parcial`
--
ALTER TABLE `parcial`
  MODIFY `idParcial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `practicas`
--
ALTER TABLE `practicas`
  MODIFY `idPracticas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `representante`
--
ALTER TABLE `representante`
  MODIFY `idRepresentante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tutor`
--
ALTER TABLE `tutor`
  MODIFY `idTutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `universidad`
--
ALTER TABLE `universidad`
  MODIFY `idUniversidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignacionpracticas`
--
ALTER TABLE `asignacionpracticas`
  ADD CONSTRAINT `asignacionpracticas_ibfk_3` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `asignacionpracticas_ibfk_4` FOREIGN KEY (`idTutor`) REFERENCES `tutor` (`idTutor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `asignacionpracticas_ibfk_5` FOREIGN KEY (`idDocente`) REFERENCES `docente` (`idDocente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `asignacionpracticas_ibfk_6` FOREIGN KEY (`idEstudiante`) REFERENCES `estudiante` (`idEstudiante`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD CONSTRAINT `carrera_ibfk_1` FOREIGN KEY (`idFacultad`) REFERENCES `facultad` (`idFacultad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `carrera_ibfk_2` FOREIGN KEY (`idCoordinador`) REFERENCES `coordinador` (`idCoordinador`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `criterios`
--
ALTER TABLE `criterios`
  ADD CONSTRAINT `criterios_ibfk_1` FOREIGN KEY (`idDimensiones`) REFERENCES `dimensiones` (`idDimensiones`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detallepracticas`
--
ALTER TABLE `detallepracticas`
  ADD CONSTRAINT `detallepracticas_ibfk_1` FOREIGN KEY (`idPracticas`) REFERENCES `practicas` (`idPracticas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `dimensiones`
--
ALTER TABLE `dimensiones`
  ADD CONSTRAINT `dimensiones_ibfk_1` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `docente`
--
ALTER TABLE `docente`
  ADD CONSTRAINT `docente_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `docente_ibfk_2` FOREIGN KEY (`idFacultad`) REFERENCES `facultad` (`idFacultad`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `empresa_ibfk_1` FOREIGN KEY (`idRepresentante`) REFERENCES `representante` (`idRepresentante`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `facultad`
--
ALTER TABLE `facultad`
  ADD CONSTRAINT `facultad_ibfk_1` FOREIGN KEY (`idUniversidad`) REFERENCES `universidad` (`idUniversidad`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `materia`
--
ALTER TABLE `materia`
  ADD CONSTRAINT `materia_ibfk_1` FOREIGN KEY (`idCarrera`) REFERENCES `carrera` (`idCarrera`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`idCriterios`) REFERENCES `criterios` (`idCriterios`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`idAsignacionPractica`) REFERENCES `asignacionpracticas` (`idAsignacionPractica`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notas_ibfk_3` FOREIGN KEY (`idParcial`) REFERENCES `parcial` (`idParcial`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `practicas`
--
ALTER TABLE `practicas`
  ADD CONSTRAINT `practicas_ibfk_1` FOREIGN KEY (`idAsignacionPractica`) REFERENCES `asignacionpracticas` (`idAsignacionPractica`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `practicas_ibfk_2` FOREIGN KEY (`idParcial`) REFERENCES `parcial` (`idParcial`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tutor`
--
ALTER TABLE `tutor`
  ADD CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tutor_ibfk_2` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
