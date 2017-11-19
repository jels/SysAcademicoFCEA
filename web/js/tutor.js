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
                $.post('../../estudiante.do', {
                    accion: "cargar_nota",
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
                            window.location.href = "estudiante.jsp";
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

$(function () {
    $('tr #ver_reporte').click(function (e) {
        e.preventDefault();
        var CI_estudiante = $(this).attr('data-id');
        $('#verReporteEstudiante').html("");
        $('#verReporte').modal('open');
        alert(CI_estudiante);
//        $.post('../../estudiante.do', {
//            accion: "verNotaAsignada",
//            CI_estudiante: CI_estudiante
//        }, function (responseText) {
//            $('#ver_Nota_Asignada_estudiante').html(responseText);
//        });
//        return false;
    });
});