
//Estudiante---Inicio...
window.addEventListener('load', function () {
    document.getElementById('nuevoestudiante').addEventListener('click', function () {

        var primerNombreEstudiante = document.getElementById('primerNombre').value;
        var primerApellidoEstudiante = document.getElementById('primerApellido').value;
        var segundoNombreEstudiante = document.getElementById('segundoNombre').value;
        var segundoApellidoEstudiante = document.getElementById('segundoApellido').value;
        var celularEstudiante = document.getElementById('celular').value;
        var ciEstudiante = document.getElementById('ci').value;
        var fotoEstudiante = document.getElementById('foto').value;
        var bandera = false;
        if (primerNombreEstudiante.length > 0 && primerApellidoEstudiante.length > 0 &&
                segundoApellidoEstudiante.length > 0 &&
                celularEstudiante.length > 0 && ciEstudiante.length > 0 && fotoEstudiante.length > 0) {
            bandera = true;
        }
        if (bandera) {
            alert("nombre: " + fotoEstudiante.value);
            $.post('../../estudiante.do', {
                accion: "crear",
                primerNombreEstudiante: primerNombreEstudiante,
                primerApellidoEstudiante: primerApellidoEstudiante,
                segundoNombreEstudiante: segundoNombreEstudiante,
                segundoApellidoEstudiante: segundoApellidoEstudiante,
                celularEstudiante: celularEstudiante,
                ciEstudiante: ciEstudiante,
                fotoEstudiante: fotoEstudiante

            }, function (responseText) {
                if (responseText === "true") {
                    $('#notificacionnewEstudiante').html("<div class=\"col s6\">\n\
                                <button class=\"btn waves effect waves light green yellow-text right\" type=\"button\" id=\"nuevoestudiante\">\n\
                                    Estudiante Creado..!<i class=\"material-icons right\">assignment_turned_in</i>\n\
                                </button>\n\
                            </div>");
                    setTimeout(function () {
                        window.location.href = "estudiante.jsp";
                    }, 2000);
                } else {
                    $('#notificacionnewEstudiante').html("<div class=\"row\">\n\
                                                        <div class=\"container\">\n\
                                                        <div class=\"container\">\n\
                                                        <h5 class=\"center-align yellow-text red accent-4\">\n\
                                                        Error al Creado Estudiante o Estudiante Existente\n\
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

$(function () {
    $('tr #eliminar_estudiante').click(function (e) {
        e.preventDefault();
        var opcion = confirm("Desea Eliminar el Estudiante?");
        if (opcion) {
            var CIestudiante = $(this).parent().parent().find('#CI_estudiante').text();
            alert(CIestudiante);
            $.post('../../estudiante.do', {
                accion: "eliminar",
                CI_estudiante: CIestudiante
            }, function (responseText) {
                if (responseText === "true") {
                    alert("Estudiante Eliminado");
                    window.location.href = "estudiante.jsp";
                } else {
                    alert("Error al Eliminar Estudiante");
                }
            });
        }
    });
});
$(function () {
    $('tr #baja_estudiante').click(function (e) {
        e.preventDefault();
        var opcion = confirm("Desea Cambiar El estado del Estudiante?");
        if (opcion) {
            var CI_estudiante = $(this).parent().parent().find('#CI_estudiante').text();
            alert(CI_estudiante);
            $.post('../../estudiante.do', {
                accion: "baja",
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
//$(function () {
//    $('tr #actualizar_estudiante').click(function (e) {
//        e.preventDefault();
//        var CI_estudiante = $(this).attr('data-id');
//        alert(CI_estudiante);
//        $.post('../../estudiante.do', {
//            accion: "actualizar",
//            CI_estudiante: CI_estudiante
//        }, function (responseText) {
//            $('#test2').html(responseText);
//        });
//        return false;
//    });
//});

//$('#actualizar_estudiante').click(function (e) {
//    e.preventDefault();
//    var CIestudiante = $(this).parent().parent().find('#CI_estudiante').text();
//    var CIestudiante = $(this).attr('data-id');
//    alert(CIestudiante);
//    $.post('estudiante.jsp', {
//        CI_estudiante: CIestudiante
//    });
//});
//
//window.addEventListener('load', function () {
//    document.getElementById('actualizar_estudiante').addEventListener('click', function () {
//
//        var CIestudiante = $(this).attr('data-id');
//        //alert("nombre: " + CIestudiante);
//        $.post('estudiante.jsp', {
//            CI_Estudiante: CIestudiante
//        }, function (responseText) {
//            var response = $(responseText); // Parseando todo el resultado (contenido de la pagina estudiante.jsp)
//            var update = response.find("#update"); // Contiene el nodo div#update sacado del resultado
//            $('#update').replaceWith(update); // Reemplazar el antiguo node div#update con el nuevo sacado del resultado
//            $('#update').modal();  // Para forzar a q reconozca como una modal el nuevo contenido
//            $('#update').modal('open'); // Abrir modal
//            return false;
//        });
//
//
//    });
//});

$(function () {
    $('tr #actualizar_estudiante').click(function (e) {
        e.preventDefault();
        var CI_estudiante = $(this).attr('data-id');
        alert("nombre: " + CI_estudiante);
        $.post('../../estudiante.do', {
            accion: "actualizar",
            CI_estudiante: CI_estudiante
        }, function (responseText) {
            if (responseText !== "false") {
                $('#show_actualizar_estudiante').html(responseText);
            } else {
                $('#show_actualizar_estudiante').html(responseText);
            }
        });
    });
});
window.addEventListener('load', function () {
    document.getElementById('actualizar_estudiante').addEventListener('click', function () {




    });
});

//Estudiante---Fin...

//Tutor---Inicio...

window.addEventListener('load', function () {
    document.getElementById('nuevotutor').addEventListener('click', function () {
        alert("holaaaaa....");

        var primerNombreT = document.getElementById('primerNombreT').value;
        var primerApellidoT = document.getElementById('primerApellidoT').value;
        var segundoNombreT = document.getElementById('segundoNombreT').value;
        var segundoApellidoT = document.getElementById('segundoApellidoT').value;
        var celularT = document.getElementById('celularT').value;
        var ciT = document.getElementById('ciT').value;
        var imagenT = document.getElementById('imagenT').value;
        var fondoT = document.getElementById('fondoT').value;
        var cargoT = document.getElementById('cargoT').value;
        var nombreUsuarioT = document.getElementById('nombreUsuarioT').value;
        var passUsuarioT = document.getElementById('passUsuarioT').value;
        var banderaT = false;
        if (primerNombreT.length > 0 && primerApellidoT.length > 0 && segundoApellidoT.length > 0 &&
                celularT.length > 0 && ciT.length > 0 &&
                imagenT.length > 0 && fondoT.length > 0 && cargoT.length > 0 && nombreUsuarioT.length > 0 && passUsuarioT.length > 0) {
            banderaT = true;
        }
        if (banderaT) {
            alert("nombre Tutor: " + primerNombreT.value);
            $.post('../tutor.do', {
                accion: "crear",
                primerNombreT: primerNombreT,
                primerApellidoT: primerApellidoT,
                segundoNombreT: segundoNombreT,
                segundoApellidoT: segundoApellidoT,
                celularT: celularT,
                ciT: ciT,
                imagenT: imagenT,
                fondoT: fondoT,
                cargoT: cargoT,
                nombreUsuarioT: nombreUsuarioT,
                passUsuarioT: passUsuarioT


            }, function (responseText) {

                switch (responseText) {
                    case "true":
                        $('#notificacionnewTutor').html("<div class=\"col s6\">\n\
                                <button class=\"btn waves effect waves light green yellow-text right\" type=\"button\">\n\
                                    Tutor Creado..!<i class=\"material-icons right\">event_available</i>\n\
                                </button>\n\
                            </div>");
                        setTimeout(function () {
                            window.location.href = "tutor.jsp";
                        }, 2000);
                        break;
                    case "falseUser":
                        $('#notificacionnewTutor').html("<div class=\"col s6\">\n\
                                <button class=\"btn waves effect waves light red yellow-text right\" type=\"button\">\n\
                                    Usuario Existente<i class=\"material-icons right\">event_busy</i>\n\
                                </button>");
                        break;
                    case "falseTutor":
                        $('#notificacionnewTutor').html("<div class=\"col s6\">\n\
                                <button class=\"btn waves effect waves light red yellow-text right\" type=\"button\">\n\
                                    Tutor Existente<i class=\"material-icons right\">event_busy</i>\n\
                                </button>");
                        break;
                    default:
                        break;
                }

//                
//                if (responseText === "true") {
//                    $('#notificacionnewTutor').html("<div class=\"col s6\">\n\
//                                <button class=\"btn waves effect waves light green yellow-text right\" type=\"button\">\n\
//                                    Tutor Creado..!<i class=\"material-icons right\">event_available</i>\n\
//                                </button>\n\
//                            </div>");
//                    setTimeout(function () {
//                        window.location.href = "tutor.jsp";
//                    }, 2000);
//                } else {
//                    $('#notificacionnewTutor').html("<div class=\"col s6\">\n\
//                                <button class=\"btn waves effect waves light red yellow-text right\" type=\"button\">\n\
//                                    Error al Crear Tutor<i class=\"material-icons right\">event_busy</i>\n\
//                                </button>");
//                }
            });
        } else {
            alert('Rellene todos los campos...');
        }
    });
});


//Tutor---Fin...





