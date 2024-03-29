<%-- 
    Document   : menu
    Created on : 23/08/2017, 05:04:45 PM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorEstudiante"%>
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

    } else if (rol.equals("Docente")) {
        response.sendRedirect("../docente/menu.jsp");
    } else if (rol.equals("Tutor")) {

    } else {
        response.sendRedirect("../../index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">

    <%@include file="head.jsp" %>

    <body class="yellow accent-2">

        <% ControladorVarios conVar = new ControladorVarios();%>
        <% ControladorEstudiante conEst = new ControladorEstudiante();%>

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
                            <li><a href="#perfil" class="tooltipped modal-trigger" data-position="button" data-tooltip="Mi Cuenta"><i class="material-icons yellow-text">account_circle</i></a></li>
                            <li><a href="../../web-fcea/index.jsp" class="tooltipped" data-position="button" data-tooltip="Salir"><i class="material-icons yellow-text">directions_run</i></a></li>
                        </ul>
                    </div>
                </nav>
            </div>

        </header>
        <!-- Final HEADER -->
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
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Fin NAV -->

            <!-- Inicio menu tutor -->
            <h1 class="center blue-text"><%=conVar.getBienvenida(usuario)%></h1>
            <div class="container">
                <div class="row">
                    <div class="col s4">
                    </div>
                    <div class="col s4">
                        <div class="card blue darken-3 yellow-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">face</i></span>
                                <h5 class="center">Estudiantes</h5>
                            </div>
                            <div class="card-action center">
                                <h5><a href="estudiante.jsp" class="yellow-text"> <%=conEst.cantidadEstudiantes_tutor(usuario)%> </a></h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="perfil" class="modal blue darken-3 yellow-text">
                
                <%=conVar.getDatosTutor(usuario) %>

            </div>
            <!-- Inicio menu tutor -->

        </main>

        <%@include file="foother.jsp" %>

    </body>
</html>