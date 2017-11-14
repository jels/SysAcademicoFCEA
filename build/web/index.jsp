<%-- 
    Document   : index
    Created on : 23/08/2017, 10:54:04 AM
    Author     : WarMachine
--%>



<% 
    response.sendRedirect("web-fcea/index.jsp");
%>

<!--

<% //@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="msapplication-tap-highlight" content="no">
        <meta name="description" content="">
        <meta name="keywords" content="">
        <title>Facultades de la UAB</title>
        <link rel="icon" href="img/logos/uab.png" sizes="32x32">
        <link rel="stylesheet" href="css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    </head>

    <body class="green darken-4">
        <div class="container">
            <div class="white-text">
                <h2 class="center">Bienvenidos a las Facultades de la UAB</h2>
            </div>
        </div>
        <main>

            <div class="container">
                <div class="row">
                    <div class="col s4">
                        <a href="#"><img src="img/logos/ingenieria.jpg" alt="ingenieria" class="circle responsive-img"></a>
                        <br><br>
                        <a href="#"><img src="img/logos/educacion.jpg" alt="educacion" class="circle responsive-img"></a>
                    </div>
                    <div class="col s4">
                        <br><br><br><br><br><br><br>
                        <a href="#"><img src="img/logos/teologia.png" alt="teologia" class="circle responsive-img"></a>
                    </div>
                    <div class="col s4">
                        <a href="web-fcea/index.jsp"><img src="img/logos/fcea.jpg" alt="fcea" class="circle responsive-img"></a>
                        <br><br>
                        <a href="#"><img src="img/logos/salud2.jpg" alt="salud" class="circle responsive-img"></a>
                    </div>
                </div>
            </div>
        </main>

        <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
        <script src="../js/materialize.min.js"></script>
        <script src="../js/validaciones.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('.slider').slider();
                $('.button-collapse').sideNav();
                $('.materialboxed').materialbox();
                $('.modal').modal();
                $('.tooltipped').tooltip({delay: 50});
            });
        </script>
    </body>
</html>
-->