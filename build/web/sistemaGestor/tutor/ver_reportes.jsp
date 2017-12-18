<%-- 
    Document   : verReporteParcial
    Created on : 03/12/2017, 09:34:23 PM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorPracticas"%>
<%@page import="Controller.ControladorVarios"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("usuario");
    String rol = (String) objsession.getAttribute("rol");
    if (objsession.equals(false) || usuario == null) {
        //esta linea es la que ayuda a que no salga el error de null...
        session.invalidate();
        response.sendRedirect("../../index.jsp");

    } else if (rol.equals("Docente")) {
        response.sendRedirect("../docente/menu.jsp");
    } else if (rol.equals("Tutor")) {

    } else {
        response.sendRedirect("../../index.jsp");
    }
    String CI_estudiante = request.getParameter("ci");
%>
<!DOCTYPE html>
<html lang="en">
    <% ControladorVarios conVar = new ControladorVarios();%>
    <% ControladorPracticas conPra = new ControladorPracticas();%>

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
                            <li><a href="#perfil" class="tooltipped" data-position="button" data-tooltip="Mi Cuenta"><i class="material-icons yellow-text">account_circle</i></a></li>
                            <li><a href="../../web-fcea/index.jsp" class="tooltipped" data-position="button" data-tooltip="Salir"><i class="material-icons yellow-text">directions_run</i></a></li>
                        </ul>
                    </div>
                    <div class="container">
                        <div class="nav-content">
                            <div class="col s12">
                                <ul class="tabs blue darken-3 tabs-fixed-width">
                                    <li class="tab col s3"><a class="yellow-text" href="#primer">Primer Parcial</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#segundo">Segundo Parcial</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#constancia">Constancia</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </header>  
        <!-- Final HEADER nav-->

        <main>

            <!-- Inicio NAV -->
            <div class="container">
                <div class="row">
                    <div class="col s12 m9 l10">
                        <div id="structure" class="section scrollspy">
                            <ul id="slide-out" class="side-nav blue darken-3" style="width: 240px">
                                <li>
                                    <div class="user-view">
                                        <%=conVar.getUserViewTutor(usuario)%>
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
                                    <a href="estudiante.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">fast_rewind</i>Regresar
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Fin NAV -->


            <!-- Inicio del MENU -->
            <div class="row blue darken-3">

                <!-- Inicio del primer -->
                <div id="primer" class="col s12 blue darken-3 yellow-text">
                    <%
                        if (conPra.activoParcial(1)) {
                    %>

                    <div class="row">
                        <h4 class="center">Estudiante: <%=conVar.getNombreEstudiante(CI_estudiante)%></h4>
                        <h6 class="center">Para imprimir haga click en el logo de la universidad o de la facultad</h6>
                    </div>
                    <div class="row">
                        <iframe src="reportes/evaluacion_parcial.jsp?ci=<%=CI_estudiante%>&parcial=1" style="border:2px solid white;" width="100%" height="500"></iframe>
                    </div>

                    <%
                    } else {
                    %>

                    <div class="row">
                        <h4 class="center">Estudiante: <%=conVar.getNombreEstudiante(CI_estudiante)%></h4>
                    </div>
                    <div class="row">
                        <div class="container">
                            <h5 class="center">Aún no esta habilitado el parcial</h5>
                            <h5 class="center">Disculpe las molestias</h5>
                        </div>
                    </div>

                    <%
                        }
                    %>

                </div>
                <!-- Fin primer -->

                <!-- Inicio del segundo -->
                <div id="segundo" class="col s12 blue darken-3 yellow-text">

                    <%
                        if (conPra.activoParcial(2)) {
                    %>

                    <div class="row">
                        <h4 class="center">Estudiante: <%=conVar.getNombreEstudiante(CI_estudiante)%></h4>
                        <h6 class="center">Para imprimir haga click en el logo de la universidad o de la facultad</h6>
                    </div>
                    <div class="row">
                        <iframe src="reportes/evaluacion_parcial.jsp?ci=<%=CI_estudiante%>&parcial=2" style="border:2px solid white;" width="100%" height="500"></iframe>
                    </div>

                    <%
                    } else {
                    %>

                    <div class="row">
                        <h4 class="center">Estudiante: <%=conVar.getNombreEstudiante(CI_estudiante)%></h4>
                    </div>
                    <div class="row">
                        <div class="container">
                            <h5 class="center">Aún no esta habilitado el parcial</h5>
                            <h5 class="center">Disculpe las molestias</h5>
                        </div>
                    </div>

                    <%
                        }
                    %>



                </div>
                <!-- Fin segundo -->

                <!-- Inicio del constancia -->
                <div id="constancia" class="col s12 blue darken-3 yellow-text">
                    <%
                        if (conPra.activoConstancia(CI_estudiante)) {
                    %>

                    <div class="row">
                        <h4 class="center">Estudiante: <%=conVar.getNombreEstudiante(CI_estudiante)%></h4>
                        <h6 class="center">Para imprimir haga click en el logo de la universidad o de la facultad</h6>
                    </div>
                    <div class="row">
                        <iframe src="reportes/constancia_final.jsp?ci=<%=CI_estudiante%>" style="border:2px solid white;" width="100%" height="500"></iframe>
                    </div>

                    <%
                    } else {
                    %>

                    <div class="row">
                        <h4 class="center">Estudiante: <%=conVar.getNombreEstudiante(CI_estudiante)%></h4>
                    </div>
                    <div class="row">
                        <div class="container">
                            <h5 class="center">Aún no esta habilitado la constancia</h5>
                            <h5 class="center">Concluya las evaluciones del Primer Parcial y las del Segundo Parcial</h5>
                        </div>
                    </div>

                    <%
                        }
                    %>

                </div>
                <!-- Fin constancia -->

                <div id="perfil" class="modal blue darken-3 yellow-text">

                    <%=conVar.getDatosTutor(usuario)%>

                </div>

            </div>
            <!-- Final del MENU -->

        </main>

        <%@include file="foother.jsp" %>

    </body>

</html>