<%-- 
    Document   : menu
    Created on : 23/08/2017, 05:04:45 PM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorVarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("usuario");
    if (usuario.equals("root")) {

    } else if (objsession.equals(false)) {//esta linea es la que ayuda a que no salga el error de null...
        response.sendRedirect("index.jsp");
    } else if (usuario == null) {
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
    <% ControladorVarios conVar = new ControladorVarios();%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="msapplication-tap-highlight" content="no">
        <meta name="description" content="">
        <meta name="keywords" content="">
        <title>Control Root</title>
        <!-- Favicons-->
        <link rel="icon" href="../img/root/perfil.png" sizes="32x32">
        <!-- CORE CSS-->    
        <link rel="stylesheet" href="../css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>

    <body class="teal accent-2">

        <!-- //////////////////////////////////////////////////////////////////////////// -->
        <!-- START HEADER -->
        <header>
            <div class="fixed-action-btn vertical click-to-toggle">
                <a href="#" class="btn tooltipped button-collapse btn-floating btn-large orange darken-2 pulse" data-activates="slide-out" data-position="left" data-tooltip="Menu">
                    <i class="material-icons white-text">apps</i>
                </a>
            </div>
            <div class="navbar-fixed">
                <nav class="orange darken-2">
                    <div class="nav-wrapper">
                        <a href="#" class="brand-logo center white-text hide-on-med-and-down">Bienvenido <%=usuario%></a>
                        <ul id="nav-mobile" class="right">
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Ayuda"><i class="material-icons white-text">help</i></a></li>
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Foro"><i class="material-icons white-text">forum</i></a></li>
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Mi Cuenta"><i class="material-icons white-text">account_circle</i></a></li>
                            <li><a href="../index.jsp" class="tooltipped" data-position="button" data-tooltip="Salir"><i class="material-icons white-text">directions_run</i></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- end header nav-->
        </header>
        <!-- END HEADER -->
        <main>
            <div class="container">
                <div class="row">
                    <div class="col s12 m9 l10">
                        <div id="structure" class="section scrollspy">
                            <ul id="slide-out" class="side-nav orange darken-2" style="width: 240px">
                                <li>
                                    <div class="user-view">
                                        <%=conVar.getUserViewRoot(usuario)%>
                                    </div>
                                </li>
                                <li>
                                    <a href="../index.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">home</i>Sitio Web
                                    </a>
                                </li>
                                <li>
                                    <a href="menu.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">dashboard</i>Inicio
                                    </a>
                                </li>
                                <li>
                                    <a href="estudiante.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">face</i>Estudiante
                                    </a>
                                </li>
                                <li>
                                    <a href="docente.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">card_travel</i>Docente
                                    </a>
                                </li>
                                <li>
                                    <a href="tutor.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">contacts</i>Tutor
                                    </a>
                                </li>
                                <li>
                                    <a href="materias.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">storage</i>Materias
                                    </a>
                                </li>
                                <li>
                                    <a href="carreras.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">format_list_bulleted</i>Carreras
                                    </a>
                                </li>
                                <li>
                                    <a href="empresas.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">store</i>Empresas
                                    </a>
                                </li>
                                <li>
                                    <a href="usuarios.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">people</i>Usuarios
                                    </a>
                                </li>
                                <li>
                                    <a href="ayuda.jsp" class="waves-effect white-text">
                                        <i class="material-icons white-text">help</i>Ayuda
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col s4">
                        <div class="card orange darken-2 white-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">face</i></span>
                                <h5 class="center">Estudiantes</h5>
                                <p class="truncate">Una descripcion de los la tabla estudiantes</p>
                            </div>
                            <div class="card-action center">
                                <h5><a href="#" class="white-text">50</a></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col s4">
                        <div class="card orange darken-2 white-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">card_travel</i></span>
                                <h5 class="center">Docentes</h5>
                                <p class="truncate">Una descripcion de los la tabla Docentes</p>
                            </div>
                            <div class="card-action center">
                                <h5><a href="#" class="white-text">3</a></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col s4">
                        <div class="card orange darken-2 white-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">contacts</i></span>
                                <h5 class="center">Tutores</h5>
                                <p class="truncate">Una descripcion de los la tabla Tutores</p>
                            </div>
                            <div class="card-action center">
                                <h5><a href="#" class="white-text">10</a></h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </main>

        <!-- //////////////////////////////////////////////////////////////////////////// -->
        <!-- START FOOTER -->
        <footer class="page-footer orange darken-2">
            <div class="footer-copyright">
                <div class="container white-text text-lighten-4">
                    © 2017 Copyright
                    <a class="white-text text-lighten-4 right" href="#">LynxLion.net</a>
                </div>
            </div>
        </footer>
        <!-- END FOOTER -->


        <!-- ================================================
        Scripts
        ================================================ -->
        <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
        <script src="../js/materialize.min.js"></script>
        <script src="../js/rootvalidaciones.js"></script>

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
