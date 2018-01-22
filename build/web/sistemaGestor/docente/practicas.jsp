<%-- 
    Document   : practicas
    Created on : 08/12/2017, 02:58:10 AM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorAsignacionPractica"%>
<%@page import="Controller.ControladorPracticas"%>
<%@page import="Controller.ControladorVarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("usuario");
    String rol = (String) objsession.getAttribute("rol");
    if (objsession.equals(false) || usuario == null) {
        //esta linea es la que ayuda a que no salga el error de null...
        session.invalidate();
        response.sendRedirect("../../index.jsp");

    } else if (rol.equals("Tutor")) {
        response.sendRedirect("../tutor/menu.jsp");
    } else if (rol.equals("Docente")) {

    } else {
        response.sendRedirect("../../index.jsp");
    }
%>

<!DOCTYPE html>
<html lang="es">
    <% ControladorVarios conVar = new ControladorVarios();%>
    <% ControladorAsignacionPractica conAsp = new ControladorAsignacionPractica();%>

    <%@include file="head.jsp" %>

    <body class="yellow accent-2">

        <!-- Inicio HEADER -->
        <header>
            <div class="fixed-action-btn vertical click-to-toggle">
                <a href="#" class="btn tooltipped button-collapse btn-floating btn-large blue darken-4 pulse" data-activates="slide-out" data-position="left" data-tooltip="Menú">
                    <i class="material-icons yellow-text">apps</i>
                </a>
            </div>
            <div class="navbar-fixed">
                <nav class="blue darken-3">
                    <div class="nav-wrapper">
                        <a href="#" class="brand-logo center yellow-text hide-on-med-and-down">Sistema Gestor de Prácticas</a>
                        <ul id="nav-mobile" class="right">
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Ayuda"><i class="material-icons yellow-text">help</i></a></li>
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Foro"><i class="material-icons yellow-text">forum</i></a></li>
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Mi Cuenta"><i class="material-icons yellow-text">account_circle</i></a></li>
                            <li><a href="../../web-fcea/index.jsp" class="tooltipped" data-position="button" data-tooltip="Salir"><i class="material-icons yellow-text">directions_run</i></a></li>
                        </ul>
                    </div>
                    <div class="container">
                        <div class="nav-content">
                            <div class="col s12">
                                <ul class="tabs blue darken-3 tabs-fixed-width">
                                    <li class="tab col s4"><a class="yellow-text" href="#resumen">Resumen Actual</a></li>
                                    <li class="tab col s4"><a class="yellow-text" href="#activos">Prácticas Activas</a></li>
                                    <li class="tab col s4"><a class="yellow-text" href="#archivo">Archivo</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>

        </header>
        <!-- Final HEADER -->

        <main>

            <!-- Inicio del NAV-->
            <div class="container">
                <div class="row">
                    <div class="col s12 m9 l10">
                        <div id="structure" class="section scrollspy">
                            <ul id="slide-out" class="side-nav blue darken-3" style="width: 240px">
                                <li>
                                    <div class="user-view">
                                        <%=conVar.getUserViewDocente(usuario)%>
                                    </div>
                                </li>
                                <li>
                                    <a href="../../index.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">home</i>Sitio Web
                                    </a>
                                </li>
                                <li>
                                    <a href="menu.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">dashboard</i>Inicio
                                    </a>
                                </li>
                                <li>
                                    <a href="estudiante.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">face</i>Estudiantes
                                    </a>
                                </li>
                                <li>
                                    <a href="practicas.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">format_list_bulleted</i>Prácticas
                                    </a>
                                </li>
                                <li>
                                    <a href="docente.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">card_travel</i>Docentes
                                    </a>
                                </li>
                                <li>
                                    <a href="carrera.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">format_list_bulleted</i>Carreras
                                    </a>
                                </li>
                                <li>
                                    <a href="empresa.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">store</i>Empresas
                                    </a>
                                </li>
                                <li>
                                    <a href="usuario.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">people</i>Usuarios
                                    </a>
                                </li>
                                <li>
                                    <a href="menu.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">fast_rewind</i>Regresar
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Final del NAV-->


            <!-- Inicio del MENU -->
            <div class="row blue darken-3 yellow-text">

                <!-- Inicio del resumen-->
                <div id="resumen" class="col s12 blue darken-3 yellow-text">

                    <div class="container">
                        <div class="row">
                            <h2 class="center">Prácticas Activas</h2>
                            <h1 class="center"><%=conAsp.contarPracticasEstado(1)%></h1>                            
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <h2 class="center">Estudiantes evaluados por parcial</h2>
                            </div>
                            <div class="col s4">
                                <h3 class="center">1<sup>er</sup> Parcial</h3>
                                <h2 class="center"><%=conAsp.contarPracticasEstado(1)%></h2>
                            </div>
                            <div class="col s4">
                                <h3 class="center">2<sup>do</sup> Parcial</h3>
                                <h2 class="center"><%=conAsp.contarPracticasEstado(1)%></h2>
                            </div>
                            <div class="col s4">
                                <h3 class="center">Examen Final</h3>
                                <h2 class="center"><%=conAsp.contarPracticasEstado(1)%></h2>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- Final del resumen-->

                <!-- Inicio del activos-->
                <div id="activos" class="col s12 blue darken-3 yellow-text">

                    <%=conAsp.verPracticasActivas()%>

                </div>
                <!-- Final del activos-->

                <!-- Inicio del Archivo-->
                <div id="archivo" class="col s12 blue darken-3 yellow-text">

                    <%=conAsp.verPracticasArchivadas()%>

                </div>
                <!-- Final del Archivo-->

            </div>
            <!-- Final del MENU -->

        </main>

        <%@include file="foother.jsp" %>

    </body>
</html>