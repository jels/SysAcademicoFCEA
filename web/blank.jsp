<%-- 
    Document   : blank
    Created on : 24/08/2017, 07:42:11 AM
    Author     : WarMachine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="msapplication-tap-highlight" content="no">
        <meta name="description" content="">
        <meta name="keywords" content="">
        <title>Pagina de Prueba</title>
        <!-- Favicons-->
        <link rel="icon" href="img/logos/fcea.jpg" sizes="32x32">
        <!-- CORE CSS-->    
        <link rel="stylesheet" href="css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>


    <body class="loaded yellow accent-1">



        <div class="container">
            <div class="row">
                <!-- Modal Trigger -->
                <a class="waves-effect waves-light btn modal-trigger" href="#modal1">Modal</a>

                <!-- Modal Structure -->
                <div id="modal1" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h2>Materia</h2>
                        <p>El contenido de la materia...!!!</p>
                        <h4>Las Dimensiones...</h4>
                        <ul class="collapsible blue darken-3 yellow-text" data-collapsible="accordion">
                            <li>
                                <div class="collapsible-header blue darken-3">
                                    <i class="material-icons">details</i>
                                    Dimension 1
                                    <span class="badge yellow-text">5</span>
                                </div>
                                <div class="collapsible-body">
                                    <h6>Criterio 1</h6>
                                    <h6>Criterio 2</h6>
                                    <h6>Criterio 3</h6>
                                    <h6>Criterio 4</h6>
                                    <h6>Criterio 5</h6>
                                </div>
                            </li>
                        </ul>
                        <a class="waves-effect waves-light btn modal-trigger" href="#modal2">Modal</a>

                    </div>
                    <div class="modal-footer">
                        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Agree</a>
                    </div>
                </div>
                <!-- Modal Structure -->
                <div id="modal2" class="modal modal-fixed-footer">
                    <div class="modal-content">
                        <h2>Materia</h2>
                        <p>El contenido de la materia...!!!</p>

                        <h4>Las Dimensiones...</h4>
                        <ul class="collapsible blue darken-3 yellow-text" data-collapsible="accordion">
                            <li>
                                <div class="collapsible-header blue darken-3">
                                    <i class="material-icons">details</i>
                                    Dimension 1
                                    <span class="badge yellow-text">5</span>
                                </div>
                                <div class="collapsible-body">
                                    <h6>Criterio 1</h6>
                                    <h6>Criterio 2</h6>
                                    <h6>Criterio 3</h6>
                                    <h6>Criterio 4</h6>
                                    <h6>Criterio 5</h6>
                                </div>
                            </li>
                        </ul>


                    </div>
                    <div class="modal-footer">
                        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Agree</a>
                    </div>
                </div>



            </div>
        </div>









        <!-- //////////////////////////////////////////////////////////////////////////// -->








        <!--  Scripts-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/materialize.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('.slider').slider();
                $(".button-collapse").sideNav();
                $('.materialboxed').materialbox();
                $('.modal').modal();
                $('.tooltipped').tooltip({delay: 50});
            });
        </script>
        <script>
            $(document).on("click", ".Modal", function () {
                var myDNI = $(this).data('id');
                $(".modal-body #DNI").val(myDNI);
            });
        </script>
    </body>
</html>
