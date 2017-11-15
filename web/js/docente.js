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