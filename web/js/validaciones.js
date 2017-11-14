



//window.addEventListener('load', function () {
//    document.getElementById('insertarmateria').addEventListener('click', function () {
//        //alert('click...');
//        var nombremateria = document.getElementById('nombremateria').value;
//        var descripcionmateria = document.getElementById('descripcionmateria').value;
//        var bandera = false;
//        if (nombremateria.length > 0 && descripcionmateria.length > 0) {
//            bandera = true;
//        }
//        if (bandera) {
////            alert('Campos llenos...');
//            $.post('reg-mat.do', {
//                nombremateria: nombremateria,
//                descripcionmateria: descripcionmateria
//            }, function (responseText) {
//                if (responseText === "true") {
//                    alert('Materia registrada correctamente');
//                    // $('#tabla').html("<div class=\"panel-body\"><div class=\"alert alert-success text-center\">Usuario Correcto</div></div>");
//                    window.location.href = "materia.jsp";
//                } else {
//                    alert('Hubo un error al registrar materia');
//                    // $('#tabla').html("<div class=\"panel-body\"><div class=\"alert alert-danger text-center\">Usuario Incorrecto</div></div>");
//                }
//            });
////            document.getElementById('formInicio').submit();
//        } else {
//            alert('Rellene todos los campos...');
//        }
//    });
//});
//window.addEventListener('load', function () {
//    document.getElementById('cerrarsession').addEventListener('click', function () {
//        alert('Esta Cerrando la Session...');
//        $('#closesession').html("<% session.invalidate(); %>");
//        window.location.href = "index.jsp";
//    });
//});
//window.addEventListener('load', function () {
//    document.getElementById('insertarrol').addEventListener('click', function () {
//        var nombreRol = document.getElementById('nombreRol').value;
//        var descripcionRol = document.getElementById('descripcionRol').value;
//        var bandera = false;
//        if (nombreRol.length > 0 && descripcionRol.length > 0) {
//            bandera = true;
//        }
//        if (bandera) {
//            $.post('regrol.do', {
//                nombreRol: nombreRol,
//                descripcionRol: descripcionRol
//            }, function (responseText) {
//                if (responseText === "true") {
//                    $('#notificacionrol').html("<div class=\"panel-body\"><div class=\"alert alert-success text-center\">Rol Creado Correctamente</div></div>");
//                    window.location.href = "new_rol.jsp";
//                } else {
//                    $('#notificacionrol').html("<div class=\"panel-body\"><div class=\"alert alert-danger text-center\">Error Al Crear el Rol</div></div>");
//                }
//            });
//        } else {
//            alert('Rellene todos los campos...');
//        }
//    });
//});
//window.addEventListener('load', function () {
//    document.getElementById('insertarUser').addEventListener('click', function () {
//        var nombreUsuario = document.getElementById('nombreUsuario').value;
//        var passUsuario = document.getElementById('passUsuario').value;
//        var idRol = document.getElementById('idRol').value;
//        var bandera = false;
//        if (nombreUsuario.length > 0 && passUsuario.length > 0 && idRol.length > 0) {
//            bandera = true;
//        }
//
//        if (bandera) {
//            $.post('reguser.do', {
//                nombreUsuario: nombreUsuario,
//                passUsuario: passUsuario,
//                idRol: idRol
//            }, function (responseText) {
//                if (responseText === "true") {
//                    $('#notificacion').html("<div class=\"panel-body\"><div class=\"alert alert-success text-center\">Usuario Creado Correctamente</div></div>");
//                    window.location.href = "new_user.jsp";
//                } else {
//                    $('#notificacion').html("<div class=\"panel-body\"><div class=\"alert alert-danger text-center\">Usuario Existente</div></div>");
//                }
//            });
//        } else {
//            alert('Rellene todos los campos...');
//        }
//    });
//});
//window.addEventListener('load', function () {
//    document.getElementById('newMatricula').addEventListener('click', function () {
////        var banderaP = false;
//        var primerNombreP = document.getElementById('primerNombreP').value;
//        var segundoNombreP = document.getElementById('segundoNombreP').value;
//        var primerApelidoP = document.getElementById('primerApelidoP').value;
//        var segundoApelidoP = document.getElementById('segundoApelidoP').value;
//        var ciP = document.getElementById('ciP').value;
//        var nacionalidadP = document.getElementById('nacionalidadP').value;
//        var internadoP = document.getElementById('internadoP').value;
//        var direccionP = document.getElementById('direccionP').value;
//        var telefonoP = document.getElementById('telefonoP').value;
//        var nacimientoP = document.getElementById('nacimientoP').value;
//        var sexoP = document.getElementById('sexoP').value;
//        var emailP = document.getElementById('emailP').value;
//        var profecionP = document.getElementById('profecionP').value;
//        var primerNombreE = document.getElementById('primerNombreE').value;
//        var segundoNombreE = document.getElementById('segundoNombreE').value;
//        var primerApelidoE = document.getElementById('primerApelidoE').value;
//        var segundoApelidoE = document.getElementById('segundoApelidoE').value;
//        var ciE = document.getElementById('ciE').value;
//        var nacionalidadE = document.getElementById('nacionalidadE').value;
//        var internadoE = document.getElementById('internadoE').value;
//        var direccionE = document.getElementById('direccionE').value;
//        var telefonoE = document.getElementById('telefonoE').value;
//        var nacimientoE = document.getElementById('nacimientoE').value;
//        var sexoE = document.getElementById('sexoE').value;
//        var emailE = document.getElementById('emailE').value;
//        var profecionE = document.getElementById('profecionE').value;
//        var tipoEstudioE = document.getElementById('tipoEstudioE').value;
//        var estudioMusicaE = document.getElementById('estudioMusicaE').value;
//        var disponeInstrumentoE = document.getElementById('disponeInstrumentoE').value;
//        var descripcionE = document.getElementById('descripcionE').value;
//        var banderaE = primerNombreE.length > 0 && primerApelidoE.length > 0 && ciE.length > 0 && nacionalidadE.length > 0 && internadoE.length > 0 && direccionE.length > 0 && telefonoE.length > 0 && nacimientoE.length > 0 && sexoE.length > 0 && emailE.length > 0 && profecionE.length > 0 && tipoEstudioE.length > 0 && estudioMusicaE.length > 0 && disponeInstrumentoE.length > 0 && descripcionE.length > 0;
//        var banderaP = primerNombreP.length > 0 && primerApelidoP.length > 0 && ciP.length > 0 && nacionalidadP.length > 0 && internadoP.length > 0 && direccionP.length > 0 && telefonoP.length > 0 && nacimientoP.length > 0 && sexoP.length > 0 && emailP.length > 0 && profecionP.length > 0;
//        if (banderaP && banderaE) {
//            banderaP = true;
//        }
//        if (banderaP) {
//            $.post('reg-persona.do', {
//                primerNombreP: primerNombreP,
//                segundoNombreP: segundoNombreP,
//                primerApelidoP: primerApelidoP,
//                segundoApelidoP: segundoApelidoP,
//                ciP: ciP,
//                nacionalidadP: nacionalidadP,
//                internadoP: internadoP,
//                direccionP: direccionP,
//                telefonoP: telefonoP,
//                nacimientoP: nacimientoP,
//                sexoP: sexoP,
//                emailP: emailP,
//                profecionP: profecionP,
//                primerNombreE: primerNombreE,
//                segundoNombreE: segundoNombreE,
//                primerApelidoE: primerApelidoE,
//                segundoApelidoE: segundoApelidoE,
//                ciE: ciE,
//                nacionalidadE: nacionalidadE,
//                internadoE: internadoE,
//                direccionE: direccionE,
//                telefonoE: telefonoE,
//                nacimientoE: nacimientoE,
//                sexoE: sexoE,
//                emailE: emailE,
//                profecionE: profecionE,
//                tipoEstudioE: tipoEstudioE,
//                estudioMusicaE: estudioMusicaE,
//                disponeInstrumentoE: disponeInstrumentoE,
//                descripcionE: descripcionE
//
//            }, function (responseText) {
//                if (responseText === "true") {
//                    $('#notificacionNewEst').html("<div class=\"panel-body\"><div class=\"alert alert-success text-center\">Estudiante Creado Correctamente</div></div>");
//                    alert('Registro Exitoso...');
//                    window.location.href = "new_matricula.jsp#curso";
//                } else {
//                    $('#notificacionNewEst').html("<div class=\"panel-body\"><div class=\"alert alert-danger text-center\">Error Al Crear el Estudiante \n Estudiante Existente</div></div>");
//                    alert('Registro Fallido...');
//                }
//            });
//        } else {
//            alert('Rellene todos los campos...');
//        }
//    });
//});

//$(document).ready(function () {
//    $('#enviarDatos').click(function (event) {
//        var username = $('#username').val();
//        var password = $('#password').val();
//        //alert("usuario: " + username);
//        //alert("pass: " + password);
//        // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
//        $.post('login.do', {
//            username: username,
//            password: password
//        }, function (responseText) {
//
//            $('#tabla').html(responseText);
//        });
//        //alert("hola");
//    });
//});