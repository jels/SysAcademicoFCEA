window.addEventListener('load', function () {
    document.getElementById('buscar_estudiante').addEventListener('click', function () {

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

window.addEventListener('load', function () {
    document.getElementById('estudianteAc').addEventListener('click', function () {

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
