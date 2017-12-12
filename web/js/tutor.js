//Estudiante--Inicio
//Buscar un estudiante
$(function () {
    $('#buscar_estudiante').click(function (e) {
        e.preventDefault();

        var apellido_estudiante = document.getElementById('apellido_estudiante').value;
        var CI_estudiante = document.getElementById('ci_estudiante').value;
        var tutor = $(this).attr('data-id');
        alert(tutor);
        if (apellido_estudiante.length > 0 || CI_estudiante.length > 0) {
            $.post('../../practicas.do', {
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
//Guardar la nota del estudiante
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

        alert(CI_estudiante);
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
                                        Correcto\n\
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
//ver las notas de un estudiante
$(function () {
    $('tr #ver_nota_estudiante').click(function (e) {
        e.preventDefault();
        var CI_estudiante = $(this).attr('data-id');
        $('#ver_Nota_Asignada_estudiante').html("");
        $('#verNotaAsignada').modal('open');
        alert(CI_estudiante);
        $.post('../../estudiante.do', {
            accion: "verNotaAsignada",
            CI_estudiante: CI_estudiante
        }, function (responseText) {
            $('#ver_Nota_Asignada_estudiante').html(responseText);
        });
        return false;
    });
});
//guardar la practica por el parcial
$(function () {
    $('#guardarPractica1').click(function (e) {
        e.preventDefault();
        var CI_estudiante = $(this).attr('data-id');
        var fechaInicio = document.getElementById('fechaInicio1').value;
        var fechaFin = document.getElementById('fechaFin1').value;
        var funcionPracticante = document.getElementById('funcionPracticante1').value;
        var cantidadHoras = document.getElementById('horasDePractica1').value;
        var observacionEstudiante = document.getElementById('observacionEstudiante1').value;
        var parcial = 1;
        if (fechaInicio.length > 0 && fechaFin.length > 0 && funcionPracticante.length > 0 && cantidadHoras.length > 0 &&
                observacionEstudiante.length > 0) {
            var opcion = confirm("Seguro que desea guardar estos datos?");
            if (opcion) {
                $.post('../../practicas.do', {
                    accion: "practicas",
                    fechaInicio: fechaInicio,
                    fechaFin: fechaFin,
                    funcionPracticante: funcionPracticante,
                    cantidadHoras: cantidadHoras,
                    observacionEstudiante: observacionEstudiante,
                    CI_estudiante: CI_estudiante,
                    parcial: parcial
                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionNewPractica1').html("\
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
                        $('#notificacionNewPractica1').html("\
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
            alert("Rellene todos los campos");
        }

    });
});

$(function () {
    $('#guardarPractica2').click(function (e) {
        e.preventDefault();
        var CI_estudiante = $(this).attr('data-id');
        var fechaInicio = document.getElementById('fechaInicio2').value;
        var fechaFin = document.getElementById('fechaFin2').value;
        var funcionPracticante = document.getElementById('funcionPracticante2').value;
        var cantidadHoras = document.getElementById('horasDePractica2').value;
        var observacionEstudiante = document.getElementById('observacionEstudiante2').value;
        var parcial = 2;
        if (fechaInicio.length > 0 && fechaFin.length > 0 && funcionPracticante.length > 0 && cantidadHoras.length > 0 &&
                observacionEstudiante.length > 0) {
            var opcion = confirm("Seguro que desea guardar estos datos?");
            if (opcion) {
                $.post('../../practicas.do', {
                    accion: "practicas",
                    fechaInicio: fechaInicio,
                    fechaFin: fechaFin,
                    funcionPracticante: funcionPracticante,
                    cantidadHoras: cantidadHoras,
                    observacionEstudiante: observacionEstudiante,
                    CI_estudiante: CI_estudiante,
                    parcial: parcial
                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionNewPractica2').html("\
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
                        $('#notificacionNewPractica2').html("\
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
            alert("Rellene todos los campos");
        }

    });
});

$(function () {
    $('#eliminar_registroPrimer').click(function (e) {
        e.preventDefault();
        var idRegistro = $(this).attr('data-id');
        var opcion = confirm("Seguro que desea Eliminar el Registro?");
        if (opcion) {
            $.post('../../practicas.do', {
                accion: "eliminar_registro",
                idRegistro: idRegistro
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Registro Eliminado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);

                } else {
                    alert("Error al Eliminar el Registro");
                }
            });
        }
    });
});

$(function () {
    $('#eliminar_registroSegundo').click(function (e) {
        e.preventDefault();
        var idRegistro = $(this).attr('data-id');
        var opcion = confirm("Seguro que desea Eliminar el Registro?");
        if (opcion) {
            $.post('../../practicas.do', {
                accion: "eliminar_registro",
                idRegistro: idRegistro
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Registro Eliminado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);

                } else {
                    alert("Error al Eliminar el Registro");
                }
            });
        }
    });
});

$(function () {
    $('tr #eliminar_detalle').click(function (e) {
        e.preventDefault();
        var idDetalle = $(this).attr('data-id');
        var opcion = confirm("Seguro que desea Eliminar el Registro?");
        if (opcion) {
            $.post('../../practicas.do', {
                accion: "eliminar_detalle",
                idDetalle: idDetalle
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Detalle Eliminado");
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);

                } else {
                    alert("Error al Eliminar el Detalle");
                }
            });
        }

    });
});

$(function () {
    $('#guardarPracticaDetalle1').click(function (e) {
        e.preventDefault();
        var idPractica = $(this).attr('data-id');
        var tareaAsignada = document.getElementById('tareaAsignada1').value;
        var observacionTarea = document.getElementById('observacionTarea1').value;
        if (tareaAsignada.length > 0 && observacionTarea.length > 0) {
            var opcion = confirm("Seguro que desea guardar este detalle?");
            if (opcion) {
                $.post('../../practicas.do', {
                    accion: "detalle_practica",
                    tareaAsignada: tareaAsignada,
                    observacionTarea: observacionTarea,
                    idPractica: idPractica
                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionNewDetallePractica1').html("\
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
                        $('#notificacionNewDetallePractica1').html("\
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
            alert("Rellene todos los campos");
        }

    });
});

$(function () {
    $('#guardarPracticaDetalle2').click(function (e) {
        e.preventDefault();
        var idPractica = $(this).attr('data-id');
        var tareaAsignada = document.getElementById('tareaAsignada2').value;
        var observacionTarea = document.getElementById('observacionTarea2').value;
        if (tareaAsignada.length > 0 && observacionTarea.length > 0) {
            var opcion = confirm("Seguro que desea guardar este detalle?");
            if (opcion) {
                $.post('../../practicas.do', {
                    accion: "detalle_practica",
                    tareaAsignada: tareaAsignada,
                    observacionTarea: observacionTarea,
                    idPractica: idPractica
                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionNewDetallePractica2').html("\
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
                        $('#notificacionNewDetallePractica2').html("\
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
            alert("Rellene todos los campos");
        }

    });
});

$(function () {
    $('#actualizarUsuarioT').click(function (e) {
        e.preventDefault();

        var usuario = document.getElementById('usuario').value;
        var pass = document.getElementById('pass').value;

        if (pass.length > 0) {
            var opcion = confirm("Seguro que desea guardar esta Nota?");
            if (opcion) {
                $.post('../../var.do', {
                    accion: "updatePassT",
                    usuario: usuario,
                    pass: pass
                }, function (responseText) {
                    if (responseText === "true") {
                        $('#notificacionACTutor').html("<a class=\"waves-effect waves-light waves-teal yellow green-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Notas Guardadas Correctamente\">\n\
                                    <i class=\"material-icons right\">done_all</i>\n\
                                        Actualizado..!!\n\
                                    <i class=\"material-icons left\">done_all</i>\n\
                                </a>");
                        setTimeout(function () {
                            window.location.href = "../login.jsp";
                        }, 2000);

                    } else {
                        $('#notificacionACTutor').html("<a class=\"waves-effect waves-light waves-teal yellow red-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Error al Guardar Notas\">\n\
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
//Estudiante--Fin