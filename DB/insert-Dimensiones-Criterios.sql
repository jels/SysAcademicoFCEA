--
-- Volcado de datos para la tabla `dimensiones`
--

INSERT INTO `dimensiones` (`idMateria`, `nombreDimension`, `estadoDimension`) VALUES
(5, 'Organizacion y Ejecucion del Trabajo', 1),
(5, 'Capacidad Empresarial', 1),
(5, 'Aspecto Actitudinal', 1),
(5, 'Proyeccion Educativa', 1);

-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `criterios`
--

INSERT INTO `criterios` (`idDimensiones`, `nombreCriterio`, `estadoCriterio`) VALUES
(1, 'Demuestra Seguridad y Habilidad en Trabajo', 1),
(1, 'Es ordenando y prolijo. Realiza las tareas asignadas con esmero y dedicación.', 1),
(1, 'Planifica el trabajo a realizar.', 1),
(1, 'Distribuye el tiempo según las necesidades.', 1),
(1, 'Usa adecuadamente los equipos tecnológicos proporcionados.', 1),
(5, 'Identifica los objetivos de la unidad donde trabaja.', 1),
(5, 'Es capaz de identificar situaciones que requieren la oportuna intervención profesional en su área de trabajo.', 1),
(5, 'En sus intervenciones, propone soluciones acertadas a los problemas existentes.', 1),
(5, 'Presenta propuestas creativas e innovadoras para optimizar el trabajo.', 1),
(5, 'Integra adecuadamente la teoría y práctica que permite mantener la rigurosidad científica.', 1),
(6, 'Es respetuoso con el equipo de trabajo y la atención a las personas.', 1),
(6, 'La indumentaria, el uso del lenguaje y la puntualidad caracteriza al practicante.', 1),
(6, 'Es asertivo y empático con las personas.', 1),
(6, 'Denota interés por aprender cosas nuevas.', 1),
(6, 'Reacciona de forma proactiva frente a las situaciones que le corresponde enfrentar.', 1),
(7, 'Se comunica con propiedad y fluidez.', 1),
(7, 'Participa activamente en las actividades programadas por la empresa/institución.', 1),
(7, 'Es cortés y tiene buen trato con sus semejantes.', 1),
(7, 'Su comportamiento denota poseer altos valores éticos y morales.', 1),
(7, 'Es colaborador, capaz de integrarse al equipo de trabajo.', 1);

-- --------------------------------------------------------


INSERT INTO `coordinador` (`idCoordinador`, `primerNombreCoordinador`, `segundoNombreCoordinador`, `primerApellidoCoordinador`, `segundoApellidoCoordinador`, `ciCoordinador`, `telefonoCoordinador`, `estadoCoordinador`) VALUES
(1, 'Jonathan', 'Elias', 'Leonardi', 'Sauer', '3968935', '69546746', 1);

INSERT INTO `estudiante` (`idEstudiante`, `primerNombreEstudiante`, `segundoNombreEstudiante`, `primerApellidoEstudiante`, `segundoApellidoEstudiante`, `ciEstudiante`, `telefonoEstudiante`, `estadoEstudiante`, `fotoEstudiante`) VALUES
(1, 'Elias', 'Jonathan', 'Leonardi', 'Sauer', 'E-10132446', '69546746', 1, 'imagen4.jpg'),
(2, 'Lindsay', '', 'Vargas', 'Carrazco', '981371123', '2586347', 0, 'imagen4.jpg'),
(4, 'Elias', 'Sauer', 'Leonardi', 'Vargas', '78274829', '91876773', 1, 'Hugo-Campos.jpg'),
(5, 'Bruce', '', 'Martinez', 'Velazquez', '3845752', '71737619', 1, 'imagen4.jpg'),
(6, 'Joel', '', 'Vargas', 'Carrasco', '76830293', '78678554', 1, 'imagen7.jpg'),
(7, 'Juan', 'Mario', 'Arza', 'Perez', '9879872', '87687678', 1, 'imagen1.jpg');

INSERT INTO `representante` (`idRepresentante`, `nombreRepresentante`, `apellidoRepresentante`, `ciRepresentante`, `telefonoRepresentante`, `estadoRepresentante`, `cargoRepresentante`) VALUES
(1, 'Juan', 'Ramon Leonardi', '1015809', '871263', 1, 'Administrador');

INSERT INTO `tutor` (`idTutor`, `idUsuario`, `idEmpresa`, `primerNombreTutor`, `segundoNombreTutor`, `primerApellidoTutor`, `segundoApellidoTutor`, `ciTutor`, `telefonoTutor`, `estadoTutor`, `cargoTutor`, `fotoTutor`, `fondoTutor`) VALUES
(1, 2, 1, 'Elias', '', 'Sauer', '', '987676', '67288773', 1, 'Contador', '../img/fcea/tutores/Lindsay-VargasCarrasco.jpg', '../img/fcea/tutores/lluvia.jpg'),
(7, 16, 1, 'Mario', '', 'Rodriguez', 'Peña', '4537298', '67853632', 1, 'Administrador', '../img/fcea/tutores/Mario.jpg', '../img/fcea/tutores/lluvia.jpg');

INSERT INTO `empresa` (`idEmpresa`, `idRepresentante`, `nombreEmpresa`, `direccionEmpresa`, `telefonoEmpresa`, `rubroEmpresa`, `estadoEmpresa`) VALUES
(1, 1, 'Rico Pan', 'Vinto-pairumani', '9876876', 'Panaderia', 1);


INSERT INTO `asignacionpracticas` (`idAsignacionPractica`, `idEstudiante`, `idDocente`, `idMateria`, `idTutor`, `ingresoEstudiante`, `gestionAcademica`, `fechaInicioPractica`, `fechaFinPractica`, `areaPractica`, `totalHoras`, `aprobadoMateria`, `estadoPractica`) VALUES
(1, 1, 1, 1, 1, '2012-A', '2017-A', '2017-03-07', '2017-06-01', 'Facultad de Ciencias Economicas y Administrativas', 300, 1, 0),
(2, 5, 1, 5, 1, '2014-B', '2017-B', '2017-08-07', '2017-12-01', 'Contabilidad', 150, 0, 1),
(4, 1, 1, 5, 1, '2012-A', '2017-B', '2017-08-07', '2017-12-01', 'Facultad de Ingenieria', 350, 0, 1),
(5, 7, 1, 5, 1, '2013-A', '2017-B', '2017-08-07', '2017-12-01', 'Facultad de Ingenieria', 250, 0, 1);