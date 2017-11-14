
window.addEventListener('load', function () {
//alert("Cargado");
    document.getElementById('enviardatos').addEventListener('click', function () {
//alert('click...');
        var nombre = document.getElementById('username').value;
        var pass = document.getElementById('password').value;
        var bandera = false;
        if (nombre.length > 0 && pass.length > 0) {
            bandera = true;
        }
        if (bandera) {
            $.post('../login.do', {
                username: nombre,
                password: pass
            }, function (responseText) {
                if (responseText === "true") {

                    $('#login').html("<div class=\"row margin center\"><i class=\"medium material-icons green-text\">event_available</i></div>");
                    setTimeout(function () {
                        window.location.href = "menu.jsp";
                    }, 2000);

                } else {
                    $('#login').html("<div class=\"row margin center\"><i class=\"medium material-icons red-text\">event_busy</i></div>");
                }


            });
//            document.getElementById('formInicio').submit();
        } else {
            alert('Rellene todos los campos...');
        }

    });
});

