//Estudiante---Inicio...
//Nuevo Estudiante...
$(function () {
    $('#nuevoestudiante').click(function (e) {
        e.preventDefault();
        var primerNombreEstudiante = document.getElementById('primerNombre').value;
        var primerApellidoEstudiante = document.getElementById('primerApellido').value;
        var segundoNombreEstudiante = document.getElementById('segundoNombre').value;
        var segundoApellidoEstudiante = document.getElementById('segundoApellido').value;
        var celularEstudiante = document.getElementById('celular').value;
        var ciEstudiante = document.getElementById('ci').value;
        var bandera = false;
        var imagen = false;
        var imagenE = document.getElementById('imagenE').files;
        if (imagenE.length === 1) {
            for (var i = 0; i < imagenE.length; i++) {
                var name = imagenE[i].name;
                var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
                if (ext !== 'jpg') {
                    alert('Archivo ' + name + ' incorrecto, solo imagenes jpg...');
                    imagen = false;
                }
                imagen = true;
            }
        } else {
            alert("Por favor seleccione 1 Foto de Tipo jpg");
            imagen = false;
        }
        if (primerNombreEstudiante.length > 0 && primerApellidoEstudiante.length > 0 &&
                segundoApellidoEstudiante.length > 0 &&
                celularEstudiante.length > 0 && ciEstudiante.length > 0) {
            bandera = true;
        }
        if (bandera && imagen) {
            var opcion = confirm("Desea Crear Un nuevo Estudiante?");
            if (opcion) {
                var data = new FormData($('#formNewEst')[0]);
                $.ajax({
                    url: "../../estudiante.do",
                    type: "post",
                    data: data,
                    contentType: false,
                    processData: false,
                    success: function (responseText) {
                        if (responseText === "true") {
                            $('#notificacionnewEstudiante').html("\
                            <div class=\"col s6\">\n\
                                <button class=\"btn waves effect waves light green yellow-text right\" type=\"button\" id=\"nuevoestudiante\">\n\
                                    Estudiante Creado..!<i class=\"material-icons right\">assignment_turned_in</i>\n\
                                </button>\n\
                            </div>");
                            setTimeout(function () {
                                location.reload(true);
                            }, 2000);
                        } else {
                            $('#notificacionnewEstudiante').html("\
                            <div class=\"col s6\">\n\
                                <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                                    <i class=\"material-icons left\">clear</i>\n\
                                        Error Estudiante..!!!\n\
                                    <i class=\"material-icons right\">clear</i>\n\
                                </button>\n\
                            </div>");
                        }
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }


    });
});
//Update estudiante error
$(function () {
    $('#updateEstudiante').click(function (e) {
        e.preventDefault();
        var primerNombreEstudiante = document.getElementById('primerNombreAc').value;
        var primerApellidoEstudiante = document.getElementById('primerApellidoAc').value;
        var segundoApellidoEstudiante = document.getElementById('segundoApellidoAc').value;
        var celularEstudiante = document.getElementById('celularAc').value;
        var ciEstudiante = document.getElementById('ciAc').value;
        var bandera = false;
        var imagen = false;
        var imagenE = document.getElementById('fotoAC').files;
        if (imagenE.length === 1) {
            for (var i = 0; i < imagenE.length; i++) {
                var name = imagenE[i].name;
                var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
                if (ext !== 'jpg') {
                    alert('Archivo ' + name + ' incorrecto, solo imagenes jpg...');
                    imagen = false;
                } else {
                    imagen = true;
                }
            }
        } else {
            alert("Por favor seleccione 1 Foto de Tipo jpg");
            imagen = false;
        }
        if (primerNombreEstudiante.length > 0 && primerApellidoEstudiante.length > 0 &&
                segundoApellidoEstudiante.length > 0 &&
                celularEstudiante.length > 0 && ciEstudiante.length > 0) {
            bandera = true;
        }
        if (bandera && imagen) {
            var opcion = confirm("Desea Actualizar el Estudiante?");
            if (opcion) {
                var data = new FormData($('#estAc')[0]);
                $.ajax({
                    url: "../../estudiante.do",
                    type: "post",
                    data: data,
                    contentType: false,
                    processData: false,
                    success: function (responseText) {
                        if (responseText === "true") {
                            $('#notificacionEstudianteAc').html("\
                            <div class=\"col s6\">\n\
                                <button class=\"btn waves effect waves light green yellow-text right\" type=\"button\" id=\"nuevoestudiante\">\n\
                                    Estudiante Actualizado..!<i class=\"material-icons right\">assignment_turned_in</i>\n\
                                </button>\n\
                            </div>");
                            setTimeout(function () {
                                window.location.href = "estudiante.jsp";
                            }, 2000);
                        } else {
                            $('#notificacionEstudianteAc').html("\
                            <div class=\"col s6\">\n\
                                <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                                    <i class=\"material-icons left\">clear</i>\n\
                                        Error Actualizando..!!!\n\
                                    <i class=\"material-icons right\">clear</i>\n\
                                </button>\n\
                            </div>");
                        }
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }


    });
});
//dar de Baja estudiante...
$(function () {
    $('tr #baja_estudiante').click(function (e) {
        e.preventDefault();
        var opcion = confirm("Desea Cambiar El estado del Estudiante?");
        if (opcion) {
            var CI_estudiante = $(this).attr('data-id');
            $.post('../../practicas.do', {
                accion: "baja_estudiante",
                CI_estudiante: CI_estudiante
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Estudiante Actualizado");
                    window.location.href = "estudiante.jsp";
                } else {
                    alert("Error al Actualizar Estudiante");
                }
            });
        }
    });
});
//buscar estudiante...
$(function () {
    $('#buscar_estudiante').click(function (e) {
        e.preventDefault();
        var apellido_estudiante = document.getElementById('apellido_estudiante').value;
        var CI_estudiante = document.getElementById('ci_estudiante').value;
        var tutor = $(this).attr('data-id');
        alert(tutor);
        if (apellido_estudiante.length > 0 || CI_estudiante.length > 0) {
            $.post('../../estudiante.do', {
                accion: "buscar_estudiante",
                apellido_estudiante: apellido_estudiante,
                CI_estudiante: CI_estudiante,
                tutor: tutor
            }, function (responseText) {
                if (responseText !== "false") {
                    $('#ver_estudiante_buscado').html(responseText);
                } else {
                    $('#ver_estudiante_buscado').html("<div class=\"panel-body\"><div class=\"alert alert-danger text-center\">Error...Buscando el estudiante...</div></div>");
                }
            });
        } else {
            alert("Tiene que rellenar alguno de los campos");
        }

    });
});
//Actualizacion del estudiante...
$(function () {
    $('#estudianteAc').click(function (e) {
        e.preventDefault();
        var primerNombreEstudianteAc = document.getElementById('primerNombreAc').value;
        var primerApellidoEstudianteAc = document.getElementById('primerApellidoAc').value;
        var segundoNombreEstudianteAc = document.getElementById('segundoNombreAc').value;
        var segundoApellidoEstudianteAc = document.getElementById('segundoApellidoAc').value;
        var celularEstudianteAc = document.getElementById('celularAc').value;
        var ciEstudianteAc = document.getElementById('ciAc').value;
        var bandera = false;
        if (primerNombreEstudianteAc.length > 0 && primerApellidoEstudianteAc.length > 0 &&
                segundoApellidoEstudianteAc.length > 0 &&
                celularEstudianteAc.length > 0 && ciEstudianteAc.length > 0) {
            bandera = true;
        }
        if (bandera) {
            $.post('../../estudiante.do', {
                accion: "update",
                primerNombreEstudianteAc: primerNombreEstudianteAc,
                primerApellidoEstudianteAc: primerApellidoEstudianteAc,
                segundoNombreEstudianteAc: segundoNombreEstudianteAc,
                segundoApellidoEstudianteAc: segundoApellidoEstudianteAc,
                celularEstudianteAc: celularEstudianteAc,
                ciEstudianteAc: ciEstudianteAc

            }, function (responseText) {
                if (responseText === "true") {
                    $('#notificacionEstudianteAc').html("<div class=\"col s6\">\n\
                                <button class=\"btn waves effect waves light green yellow-text right\" type=\"button\" id=\"nuevoestudiante\">\n\
                                    Estudiante Actualizado..!<i class=\"material-icons right\">assignment_turned_in</i>\n\
                                </button>\n\
                            </div>");
                    setTimeout(function () {
                        window.location.href = "estudiante.jsp";
                    }, 2000);
                } else {
                    $('#notificacionEstudianteAc').html("<div class=\"row\">\n\
                                                        <div class=\"container\">\n\
                                                        <div class=\"container\">\n\
                                                        <h5 class=\"center-align yellow-text red accent-4\">\n\
                                                        Error al Actualizar el Estudiante\n\
                                                        </h5>\n\
                                                        </div>\n\
                                                        </div>\n\
                                                        </div>");
                }
            });
        } else {
            alert('Rellene todos los campos...');
        }
    });
});
//guardar la nota del estudiante...
$(function () {
    $('#guardarNuevaNota').click(function (e) {
        e.preventDefault();
        var nota1 = document.getElementById('nota1').value;
        var nota2 = document.getElementById('nota2').value;
        var nota3 = document.getElementById('nota3').value;
        var nota4 = document.getElementById('nota4').value;
        var nota5 = document.getElementById('nota5').value;
        var nota6 = document.getElementById('nota6').value;
        var nota7 = document.getElementById('nota7').value;
        var nota8 = document.getElementById('nota8').value;
        var nota9 = document.getElementById('nota9').value;
        var nota10 = document.getElementById('nota10').value;
        var nota11 = document.getElementById('nota11').value;
        var nota12 = document.getElementById('nota12').value;
        var nota13 = document.getElementById('nota13').value;
        var nota14 = document.getElementById('nota14').value;
        var nota15 = document.getElementById('nota15').value;
        var nota16 = document.getElementById('nota16').value;
        var nota17 = document.getElementById('nota17').value;
        var nota18 = document.getElementById('nota18').value;
        var nota19 = document.getElementById('nota19').value;
        var nota20 = document.getElementById('nota20').value;
        var CI_estudiante = $(this).attr('data-id');
        if (nota1 > 0 && nota2 > 0 && nota3 > 0 && nota4 > 0 &&
                nota5 > 0 && nota6 > 0 && nota7 > 0 && nota8 > 0 &&
                nota9 > 0 && nota10 > 0 && nota11 > 0 && nota12 > 0 &&
                nota13 > 0 && nota14 > 0 && nota15 > 0 && nota16 > 0 &&
                nota17 > 0 && nota18 > 0 && nota19 > 0 && nota20 > 0) {
            var opcion = confirm("Seguro que desea guardar esta Nota?");
            if (opcion) {
                $.post('../../practicas.do', {
                    accion: "cargar_nota_estudiante",
                    nota1: nota1,
                    nota2: nota2,
                    nota3: nota3,
                    nota4: nota4,
                    nota5: nota5,
                    nota6: nota6,
                    nota7: nota7,
                    nota8: nota8,
                    nota9: nota9,
                    nota10: nota10,
                    nota11: nota11,
                    nota12: nota12,
                    nota13: nota13,
                    nota14: nota14,
                    nota15: nota15,
                    nota16: nota16,
                    nota17: nota17,
                    nota18: nota18,
                    nota19: nota19,
                    nota20: nota20,
                    CI_estudiante: CI_estudiante
                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notaGuardada').html("<a class=\"waves-effect waves-light waves-teal yellow green-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Notas Guardadas Correctamente\">\n\
                                    <i class=\"material-icons right\">done_all</i>\n\
                                    <i class=\"material-icons left\">done_all</i>\n\
                                </a>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notaGuardada').html("<a class=\"waves-effect waves-light waves-teal yellow red-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Error al Guardar Notas\">\n\
                                    <i class=\"material-icons right\">close</i>\n\
                                    <i class=\"material-icons center\">pan_tool</i>\n\
                                    <i class=\"material-icons left\">close</i>\n\
                                </a>");
                    }
                });
            } else {

            }

        } else {
            alert("Tiene que rellenar alguno de los campos");
        }

    });
});
//Estudiante---Fin...

//Carrera---Inicio...
//Nueva Carrera...
$(function () {
    $('#newcarrera').click(function (e) {
        e.preventDefault();
        var docente = $(this).attr('data-id');
        var nombreCarrera = document.getElementById('nombreCarrera').value;
        var abreviaturaCarrera = document.getElementById('abreviaturaCarrera').value;
        var descripcionCarrera = document.getElementById('descripcionCarrera').value;
        var primerNombreCoordinador = document.getElementById('primerNombreCoordinador').value;
        var segundoNombreCoordinador = document.getElementById('segundoNombreCoordinador').value;
        var primerApellidoCoordinador = document.getElementById('primerApellidoCoordinador').value;
        var segundoApellidoCoordinador = document.getElementById('segundoApellidoCoordinador').value;
        var ciCoordinador = document.getElementById('ciCoordinador').value;
        var telefonoCoordinador = document.getElementById('telefonoCoordinador').value;
        var fotoCoordinador = document.getElementById('fotoCoordinador').value;
        var bandera = false;
        if (nombreCarrera.length > 0 && abreviaturaCarrera.length > 0 &&
                descripcionCarrera.length > 0 &&
                primerNombreCoordinador.length > 0 && primerApellidoCoordinador.length > 0 &&
                segundoApellidoCoordinador.length > 0 && ciCoordinador.length > 0 &&
                telefonoCoordinador.length > 0 && fotoCoordinador.length > 0) {
            bandera = true;
        }

        if (bandera) {
            var opcion = confirm("Seguro que Desea Crear Una nueva Carrera?");
            if (opcion) {
                $.post('../../carrera.do', {
                    accion: "crear",
                    nombreCarrera: nombreCarrera,
                    abreviaturaCarrera: abreviaturaCarrera,
                    descripcionCarrera: descripcionCarrera,
                    primerNombreCoordinador: primerNombreCoordinador,
                    segundoNombreCoordinador: segundoNombreCoordinador,
                    primerApellidoCoordinador: primerApellidoCoordinador,
                    segundoApellidoCoordinador: segundoApellidoCoordinador,
                    ciCoordinador: ciCoordinador,
                    telefonoCoordinador: telefonoCoordinador,
                    fotoCoordinador: fotoCoordinador,
                    docente: docente

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionNewCarrera').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Creado...!!!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            window.location.href = "carrera.jsp";
                        }, 2000);
                    } else {
                        $('#notificacionNewCarrera').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }
    });
});
//dar de Baja Carrera...
$(function () {
    $('tr #baja_carrera').click(function (e) {
        e.preventDefault();
        var opcion = confirm("Desea Cambiar El estado de la Carrera?");
        if (opcion) {
            var abreviatura = $(this).attr('data-id');
            alert(abreviatura);
            $.post('../../carrera.do', {
                accion: "baja",
                abreviatura: abreviatura
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Carrera Actualizada");
                    window.location.href = "carrera.jsp";
                } else {
                    alert("Error al Actualizar la Carrera");
                }
            });
        }
    });
});
////Actualizacion del Carrera...
$(function () {
    $('#actualizarCarrera').click(function (e) {
        e.preventDefault();
        var idCarrera = $(this).attr('data-id');
        alert(idCarrera);
        var nombreCarrera = document.getElementById('nombreCarreraAC').value;
        var abreviaturaCarrera = document.getElementById('abreviaturaCarreraAC').value;
        var descripcionCarrera = document.getElementById('descripcionCarreraAC').value;
        var bandera = false;
        if (nombreCarrera.length > 0 && abreviaturaCarrera.length > 0 &&
                descripcionCarrera.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Seguro que Desea Crear Una nueva Carrera?");
            if (opcion) {
                $.post('../../carrera.do', {
                    accion: "update",
                    nombreCarrera: nombreCarrera,
                    abreviaturaCarrera: abreviaturaCarrera,
                    descripcionCarrera: descripcionCarrera,
                    idCarrera: idCarrera

                }, function (responseText) {
                    alert(responseText);
                    if (responseText === "true") {
                        $('#notificacionUpdateCarrera').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Actualizado...!!!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            window.location.href = "carrera.jsp";
                        }, 2000);
                    } else {
                        $('#notificacionUpdateCarrera').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }
    });
});
//Carrera---Fin...

//actualizacion del coordinador
$(function () {
    $('#actualizarCoordinador').click(function (e) {
        e.preventDefault();
        var idCoordinador = $(this).attr('data-id');
        var primerNombreCoordinador = document.getElementById('primerNombreCoordinadorAC').value;
        var segundoNombreCoordinador = document.getElementById('segundoNombreCoordinadorAC').value;
        var primerApellidoCoordinador = document.getElementById('primerApellidoCoordinadorAC').value;
        var segundoApellidoCoordinador = document.getElementById('segundoApellidoCoordinadorAC').value;
        var ciCoordinador = document.getElementById('ciCoordinadorAC').value;
        var telefonoCoordinador = document.getElementById('telefonoCoordinadorAC').value;
        var fotoCoordinador = document.getElementById('fotoCoordinadorAC').value;
        var bandera = false;
        if (primerNombreCoordinador.length > 0 && primerApellidoCoordinador.length > 0 &&
                segundoApellidoCoordinador.length > 0 && ciCoordinador.length > 0 &&
                telefonoCoordinador.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Seguro que Desea Crear Una nueva Carrera?");
            if (opcion) {
                $.post('../../carrera.do', {
                    accion: "updateCoordinador",
                    primerNombreCoordinador: primerNombreCoordinador,
                    segundoNombreCoordinador: segundoNombreCoordinador,
                    primerApellidoCoordinador: primerApellidoCoordinador,
                    segundoApellidoCoordinador: segundoApellidoCoordinador,
                    ciCoordinador: ciCoordinador,
                    telefonoCoordinador: telefonoCoordinador,
                    fotoCoordinador: fotoCoordinador,
                    idCoordinador: idCoordinador

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionUpdateCoordinador').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Actualizado...!!!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionUpdateCoordinador').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }
    });
});
//Materia---Inicio...
//Nueva Materia...
$(function () {
    $('#nuevaMateria').click(function (e) {
        e.preventDefault();
        var carrera = $(this).attr('data-id');
        var nombreMateria = document.getElementById('nombreMat').value;
        var semestreMateria = document.getElementById('semestreMat').value;
        var descripcionMateria = document.getElementById('descripcionMateria').value;
        var horasPracticas = document.getElementById('horasPracticas').value;
        var estadoMateria = 1;
        var bandera = false;
        if (nombreMateria.length > 0 && semestreMateria.length > 0 &&
                descripcionMateria.length > 0 &&
                horasPracticas.length > 0) {
            bandera = true;
        }


        if (bandera) {
            var opcion = confirm("Desea Crear Una nueva Materia?");
            if (opcion) {
                $.post('../../materia.do', {
                    accion: "crear",
                    nombreMateria: nombreMateria,
                    semestreMateria: semestreMateria,
                    descripcionMateria: descripcionMateria,
                    horasPracticas: horasPracticas,
                    estadoMateria: estadoMateria,
                    carrera: carrera

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionNewMateria').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Creacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            window.location.href = "carrera_ver.jsp?carrera=" + carrera;
                        }, 2000);
                    } else {
                        $('#notificacionNewMateria').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//dar de Baja Materia...
$(function () {
    $('tr #baja_materia').click(function (e) {
        e.preventDefault();
        var idMateria = $(this).attr('data-id');
        var opcion = confirm("Desea Cambiar El estado de la Materia?");
        if (opcion) {

            alert(idMateria);
            $.post('../../materia.do', {
                accion: "baja",
                idMateria: idMateria
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Materia Actualizado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);
                } else {
                    alert("Error al Actualizar Materia");
                }
            });
        }
    });
});
//Actualizacion del Materia...
$(function () {
    $('#actualizarMateria').click(function (e) {
        e.preventDefault();
        var idMateria = $(this).attr('data-id');
        var nombreMateria = document.getElementById('nombreMatAC').value;
        var semestreMateria = document.getElementById('semestreMatAC').value;
        var descripcionMateria = document.getElementById('descripcionMateriaAC').value;
        var horasPracticas = document.getElementById('horasPracticasAC').value;
        var estadoMateria = 1;
        var bandera = false;
        if (nombreMateria.length > 0 && semestreMateria.length > 0 &&
                descripcionMateria.length > 0 &&
                horasPracticas.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Desea Crear Una nueva Materia?");
            if (opcion) {
                $.post('../../materia.do', {
                    accion: "update",
                    nombreMateria: nombreMateria,
                    semestreMateria: semestreMateria,
                    descripcionMateria: descripcionMateria,
                    horasPracticas: horasPracticas,
                    estadoMateria: estadoMateria,
                    idMateria: idMateria

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionACMateria').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Actualizada...!!!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionACMateria').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//Materia---Fin...

//Dimensiones---Inicio...
//Nueva Dimension nuevaDimension
$(function () {
    $('#nuevaDimension').click(function (e) {
        e.preventDefault();
        var idMateria = $(this).attr('data-id');
        var nombreDimension = document.getElementById('nombreDimension').value;
        var estadoDimension = 1;
        var bandera = false;
        if (nombreDimension.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Desea Crear Una nueva Dimension?");
            if (opcion) {
                $.post('../../dimensiones.do', {
                    accion: "crear",
                    nombreDimension: nombreDimension,
                    estadoDimension: estadoDimension,
                    idMateria: idMateria

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionNewDimension').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Creacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionNewDimension').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//baja dimension
$(function () {
    $('tr #baja_dimension').click(function (e) {
        e.preventDefault();
        var idDimension = $(this).attr('data-id');
        var opcion = confirm("Desea Cambiar El estado de la Dimension?");
        if (opcion) {
            $.post('../../dimensiones.do', {
                accion: "baja",
                idDimension: idDimension
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Dimension Actualizado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);
                } else {
                    alert("Error al Actualizar la Dimension");
                }
            });
        }
    });
});
//Actualizar Dimension
$(function () {
    $('#actualizarDimension').click(function (e) {
        e.preventDefault();
        var idDimension = $(this).attr('data-id');
        var nombreDimension = document.getElementById('nombreDimensionAC').value;
        var estadoDimension = 1;
        var bandera = false;
        if (nombreDimension.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Seguro que Desea Actualizar?");
            if (opcion) {
                $.post('../../dimensiones.do', {
                    accion: "update",
                    nombreDimension: nombreDimension,
                    estadoDimension: estadoDimension,
                    idDimension: idDimension

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionActDimension').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Actualizacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionActDimension').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//Dimensiones---Fin...

//Criterios---Inicio...
//Nuevo Criterio nuevaDimension
$(function () {
    $('#nuevoCriterio').click(function (e) {
        e.preventDefault();
        var idDimension = $(this).attr('data-id');
        var nombreCriterio = document.getElementById('nombreCriterio').value;
        var estadoCriterio = 1;
        var bandera = false;
        if (nombreCriterio.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Desea Crear Un nuevo Criterio?");
            if (opcion) {
                $.post('../../criterios.do', {
                    accion: "crear_criterio",
                    nombreCriterio: nombreCriterio,
                    estadoCriterio: estadoCriterio,
                    idDimension: idDimension

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionNewCriterio').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Creacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionNewCriterio').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//baja Criterio
$(function () {
    $('tr #baja_criterio').click(function (e) {
        e.preventDefault();
        var idCriterio = $(this).attr('data-id');
        var opcion = confirm("Desea Cambiar El estado del Criterio?");
        if (opcion) {
            $.post('../../criterios.do', {
                accion: "baja_criterio",
                idCriterio: idCriterio
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Criterio Actualizado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);
                } else {
                    alert("Error al Actualizar el Criterio");
                }
            });
        }
    });
});
//Actualizar Criterio
$(function () {
    $('#actualizarCriterio').click(function (e) {
        e.preventDefault();
        var idCriterio = $(this).attr('data-id');
        var nombreCriterio = document.getElementById('nombreCriterioAC').value;
        var bandera = false;
        if (nombreCriterio.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Seguro que Desea Actualizar?");
            if (opcion) {
                $.post('../../criterios.do', {
                    accion: "update",
                    nombreCriterio: nombreCriterio,
                    idCriterio: idCriterio

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionActCriterio').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Actualizacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionActCriterio').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//Criterios---Fin...

//Empresas---Inicio...
//Nueva empresa
$(function () {
    $('#nuevaEmpresa').click(function (e) {
        e.preventDefault();
        var nombreEmpresa = document.getElementById('nombreEmpresa').value;
        var direccionEmpresa = document.getElementById('direccionEmpresa').value;
        var telefonoEmpresa = document.getElementById('telefonoEmpresa').value;
        var rubroEmpresa = document.getElementById('rubroEmpresa').value;
        var primerNombreRepresentante = document.getElementById('primerNombreRepresentante').value;
        var segundoNombreRepresentante = document.getElementById('segundoNombreRepresentante').value;
        var primerApellidoRepresentante = document.getElementById('primerApellidoRepresentante').value;
        var segundoApellidoRepresentante = document.getElementById('segundoApellidoRepresentante').value;
        var ciRepresentante = document.getElementById('ciRepresentante').value;
        var celularRepresentante = document.getElementById('celularRepresentante').value;
        var cargoRepresentante = document.getElementById('cargoRepresentante').value;
        var estadoEmpresa = 1;
        var estadoRepresentante = 1;
        var bandera = false;
        if (nombreEmpresa.length > 0 && direccionEmpresa.length > 0 &&
                telefonoEmpresa.length > 0 && rubroEmpresa.length > 0 &&
                primerNombreRepresentante.length > 0 && primerApellidoRepresentante.length > 0 &&
                segundoApellidoRepresentante.length > 0 && ciRepresentante.length > 0 &&
                celularRepresentante.length > 0 && cargoRepresentante.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Desea Crear Una nueva Empresa?");
            if (opcion) {
                $.post('../../empresa.do', {
                    accion: "crear",
                    nombreEmpresa: nombreEmpresa,
                    direccionEmpresa: direccionEmpresa,
                    telefonoEmpresa: telefonoEmpresa,
                    rubroEmpresa: rubroEmpresa,
                    primerNombreRepresentante: primerNombreRepresentante,
                    segundoNombreRepresentante: segundoNombreRepresentante,
                    primerApellidoRepresentante: primerApellidoRepresentante,
                    segundoApellidoRepresentante: segundoApellidoRepresentante,
                    ciRepresentante: ciRepresentante,
                    celularRepresentante: celularRepresentante,
                    cargoRepresentante: cargoRepresentante,
                    estadoEmpresa: estadoEmpresa,
                    estadoRepresentante: estadoRepresentante

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionNewEmpresa').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Creacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionNewEmpresa').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//baja empresa
$(function () {
    $('tr #baja_empresa').click(function (e) {
        e.preventDefault();
        var idEmpresa = $(this).attr('data-id');
        var opcion = confirm("Desea Cambiar El estado de la Empresa?");
        if (opcion) {
            $.post('../../empresa.do', {
                accion: "baja",
                idEmpresa: idEmpresa
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Empresa Actualizado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);
                } else {
                    alert("Error al Actualizar la Empresa");
                }
            });
        }
    });
});
//Actualizar Empresa...
$(function () {
    $('#actualizarEmpresa').click(function (e) {
        e.preventDefault();
        var idEmpresa = $(this).attr('data-id');
        var nombreEmpresa = document.getElementById('nombreEmpresaAC').value;
        var direccionEmpresa = document.getElementById('direccionEmpresaAC').value;
        var telefonoEmpresa = document.getElementById('telefonoEmpresaAC').value;
        var rubroEmpresa = document.getElementById('rubroEmpresaAC').value;
        var bandera = false;
        if (nombreEmpresa.length > 0 && direccionEmpresa.length > 0 &&
                telefonoEmpresa.length > 0 && rubroEmpresa.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Desea Actualizar Los datos de la Empresa?");
            if (opcion) {
                $.post('../../empresa.do', {
                    accion: "update",
                    nombreEmpresa: nombreEmpresa,
                    direccionEmpresa: direccionEmpresa,
                    telefonoEmpresa: telefonoEmpresa,
                    rubroEmpresa: rubroEmpresa,
                    idEmpresa: idEmpresa

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionUPEmpresa').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Creacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionUPEmpresa').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//Actualizar Representante
$(function () {
    $('#actualizarRepresentante').click(function (e) {
        e.preventDefault();
        var primerNombreRepresentante = document.getElementById('pNombreRepresentanteAC').value;
        var segundoNombreRepresentante = document.getElementById('sNombreRepresentanteAC').value;
        var primerApellidoRepresentante = document.getElementById('pApellidoRepresentanteAC').value;
        var segundoApellidoRepresentante = document.getElementById('sApellidoRepresentanteAC').value;
        var ciRepresentante = document.getElementById('ciRepresentanteAC').value;
        var celularRepresentante = document.getElementById('telefonoRepresentanteAC').value;
        var cargoRepresentante = document.getElementById('cargoRepresentanteAC').value;
        var idRepresentante = $(this).attr('data-id');
        var bandera = false;
        if (primerNombreRepresentante.length > 0 && primerApellidoRepresentante.length > 0 &&
                segundoApellidoRepresentante.length > 0 && ciRepresentante.length > 0 &&
                celularRepresentante.length > 0 && cargoRepresentante.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Desea Actualizar El Representante?");
            if (opcion) {
                $.post('../../empresa.do', {
                    accion: "update_representante",
                    primerNombreRepresentante: primerNombreRepresentante,
                    segundoNombreRepresentante: segundoNombreRepresentante,
                    primerApellidoRepresentante: primerApellidoRepresentante,
                    segundoApellidoRepresentante: segundoApellidoRepresentante,
                    ciRepresentante: ciRepresentante,
                    celularRepresentante: celularRepresentante,
                    cargoRepresentante: cargoRepresentante,
                    idRepresentante: idRepresentante

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionUPRepresentante').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Actualizacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionUPRepresentante').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//Actualizar Dimension
$(function () {
    $('#actualizarDimension').click(function (e) {
        e.preventDefault();
        var idDimension = $(this).attr('data-id');
        var nombreDimension = document.getElementById('nombreDimensionAC').value;
        var estadoDimension = 1;
        var bandera = false;
        if (nombreDimension.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Seguro que Desea Actualizar?");
            if (opcion) {
                $.post('../../dimensiones.do', {
                    accion: "update",
                    nombreDimension: nombreDimension,
                    estadoDimension: estadoDimension,
                    idDimension: idDimension

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionActDimension').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Actualizacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionActDimension').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//Empresas---Fin...

//Tutores---Inicio...
//Nuevo tutor
$(function () {
    $('#crear_tutor').click(function (e) {
        e.preventDefault();
        var primerNombreT = document.getElementById('primerNombreT').value;
        var segundoNombreT = document.getElementById('segundoNombreT').value;
        var primerApellidoT = document.getElementById('primerApellidoT').value;
        var segundoApellidoT = document.getElementById('segundoApellidoT').value;
        var celularT = document.getElementById('celularT').value;
        var ciT = document.getElementById('ciT').value;
        var cargoT = document.getElementById('cargoT').value;
        var nombreUsuarioT = document.getElementById('nombreUsuarioT').value;
        var passUsuarioT = document.getElementById('passUsuarioT').value;
        var imagenT = document.getElementById('imagenT').files;
        if (imagenT.length === 1) {
            for (var i = 0; i < imagenT.length; i++) {
                var name = imagenT[i].name;
                var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
                if (ext !== 'jpg') {
                    alert('Archivo ' + name + ' incorrecto, solo imagenes jpg...');
                }
            }
        } else {
            alert("Por favor seleccione 5 archivos de tipo imagen");
        }
        var bandera = false;
        if (primerNombreT.length > 0 && primerApellidoT.length > 0 &&
                segundoApellidoT.length > 0 && celularT.length > 0 &&
                ciT.length > 0 && cargoT.length > 0 &&
                nombreUsuarioT.length > 0 && passUsuarioT.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Desea Crear Un nuevo Tutor?");
            if (opcion) {
                var data = new FormData($('#nuevo_tutor')[0]);
                $.ajax({
                    url: "../../tutor.do",
                    type: "post",
                    data: data,
                    contentType: false,
                    processData: false,
                    success: function (responseText) {
                        if (responseText === "true") {
                            $('#notificacionNewTutor').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Creacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                            setTimeout(function () {
                                location.reload(true);
                            }, 2000);
                        } else {
                            $('#notificacionNewTutor').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                        }
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//baja Tutores
$(function () {
    $('tr #baja_tutor').click(function (e) {
        e.preventDefault();
        var idTutor = $(this).attr('data-id');
        var opcion = confirm("Desea Cambiar El estado del Tutor?");
        if (opcion) {
            $.post('../../empresa.do', {
                accion: "baja_tutor",
                idTutor: idTutor
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Tutor Actualizado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);
                } else {
                    alert("Error al Actualizar El Tutor");
                }
            });
        }
    });
});
//Actualizar tutor
$(function () {
    $('#actualizarTutor').click(function (e) {
        e.preventDefault();
        var idTutor = $(this).attr('data-id');
        var primerNombreT = document.getElementById('pNombreTutorAC').value;
        var segundoNombreT = document.getElementById('sNombreTutorAC').value;
        var primerApellidoT = document.getElementById('pApellidoTutorAC').value;
        var segundoApellidoT = document.getElementById('sApellidoTutorAC').value;
        var celularT = document.getElementById('telefonoTutorAC').value;
        var ciT = document.getElementById('ciTutorAC').value;
        var cargoT = document.getElementById('cargoTutorAC').value;
        var nombreUsuarioT = document.getElementById('userTutorAC').value;
        var passUsuarioT = document.getElementById('passTutorAC').value;
        var bandera = false;
        if (primerNombreT.length > 0 && primerApellidoT.length > 0 &&
                segundoApellidoT.length > 0 && celularT.length > 0 &&
                ciT.length > 0 && cargoT.length > 0 &&
                nombreUsuarioT.length > 0 && passUsuarioT.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Desea Actualizar el Tutor?");
            if (opcion) {
                var data = new FormData($('#updateTutor')[0]);
                $.ajax({
                    url: "../../tutor.do",
                    type: "post",
                    data: data,
                    contentType: false,
                    processData: false,
                    success: function (responseText) {
                        if (responseText === "true") {
                            $('#notificacionUPTutor').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Actualizacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                            setTimeout(function () {
                                location.reload(true);
                            }, 2000);
                        } else {
                            $('#notificacionUPTutor').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                        }
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//Tutores---Fin...

//Parcial---Inicio...
//parcial estado...
$(function () {
    $('tr #baja_parcial').click(function (e) {
        e.preventDefault();
        var idParcial = $(this).attr('data-id');
        var opcion = confirm("Desea Cambiar El estado de este Parcial?");
        if (opcion) {
            $.post('../../practicas.do', {
                accion: "parcial",
                idParcial: idParcial
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Parcial Activado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);
                } else {
                    alert("Error al Activar el Parcial");
                }
            });
        }
    });
});
//Parcial---Fin...

//Practicas---Inicio...
$(function () {
    $('#asignacionPractica').click(function (e) {
        e.preventDefault();
        var CI_estudiante = $(this).attr('data-id');
        var docente = document.getElementById('docente').value;
        var tutor = document.getElementById('tutor').value;
        var materia = document.getElementById('materia').value;
        var areaPractica = document.getElementById('areaPractica').value;
        var ingresoEs = document.getElementById('ingresoEs').value;
        var gestionActual = document.getElementById('gestionActual').value;
        var fechaInicioPra = document.getElementById('fechaInicioPra').value;
        var fechaFinPra = document.getElementById('fechaFinPra').value;
        var aprobo = 0;
        var estado = 1;
        var bandera = false;
        if (docente.length > 0 && tutor.length > 0 &&
                materia.length > 0 && areaPractica.length > 0 &&
                ingresoEs.length > 0 && gestionActual.length > 0 &&
                fechaInicioPra.length > 0 && fechaFinPra.length > 0) {
            bandera = true;
        }
        if (bandera) {
            var opcion = confirm("Desea Asignar Esta Practica?");
            if (opcion) {
                $.post('../../practicas.do', {
                    accion: "crear_asignacionPractica",
                    docente: docente,
                    tutor: tutor,
                    materia: materia,
                    areaPractica: areaPractica,
                    ingresoEs: ingresoEs,
                    gestionActual: gestionActual,
                    fechaInicioPra: fechaInicioPra,
                    fechaFinPra: fechaFinPra,
                    aprobo: aprobo,
                    estado: estado,
                    CI_estudiante: CI_estudiante

                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionAsignacionPractica').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light green yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Carrera Creada Correctamente...\">\n\
                            <i class=\"material-icons left\">done_all</i>\n\
                                Asignacion Exitosa.!\n\
                            <i class=\"material-icons right\">done_all</i>\n\
                        </button>\n\
                    </div>");
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    } else {
                        $('#notificacionAsignacionPractica').html("\
                    <div class=\"col s6\">\n\
                        <button class=\"btn waves-effect waves-light red yellow-text right tooltipped\" type=\"button\" data-position=\"button\" data-tooltip=\"Error al Crear La Carrera\">\n\
                            <i class=\"material-icons left\">clear</i>\n\
                                Error al Asignar..!!!\n\
                            <i class=\"material-icons right\">clear</i>\n\
                        </button>\n\
                    </div>");
                    }
                });
            }
        } else {
            alert('Rellene todos los campos...');
        }

    });
});
//eliminar Asignacion Practica
$(function () {
    $('tr #eliminar_asignacionPractica').click(function (e) {
        e.preventDefault();
        var idAsignacion = $(this).attr('data-id');
        var opcion = confirm("Desea Eliminar esta Practica?");
        if (opcion) {
            $.post('../../practicas.do', {
                accion: "eliminar_asignacionPractica",
                idAsignacion: idAsignacion
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Asignacion Eliminarda");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);
                } else {
                    alert("Error al Eliminar practica");
                }
            });
        }
    });
});
//Aprobar al estudiante
$(function () {
    $('#aprobar_estudiante').click(function (e) {
        e.preventDefault();
        var CI_estudiante = $(this).attr('data-id');
        var opcion = confirm("Desea Aprobar al estudiante?");
        if (opcion) {
            $.post('../../practicas.do', {
                accion: "aprobar_estudiante",
                CI_estudiante: CI_estudiante
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Estudiante Aprobado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                } else {
                    alert("Error al aprobar al estudiante");
                }
            });
        }
    });
});
//Reprobar al estudiante
$(function () {
    $('#reprobar_estudiante').click(function (e) {
        e.preventDefault();
        var CI_estudiante = $(this).attr('data-id');
        var opcion = confirm("Desea Reprobar al estudiante?");
        if (opcion) {
            $.post('../../practicas.do', {
                accion: "reprobar_estudiante",
                CI_estudiante: CI_estudiante
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Estudiante Reprobado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                } else {
                    alert("Error al reprobar al estudiante");
                }
            });
        }
    });
});
//Practicas---Fin...


