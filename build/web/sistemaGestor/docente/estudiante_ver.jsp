<%-- 
    Document   : estudiante_ver
    Created on : 15/11/2017, 11:04:20 AM
    Author     : WarMachine
--%>


<%@page import="Controller.ControladorMateria"%>
<%@page import="Controller.ControladorEstudiante"%>
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

    } else if (rol.equals("Tutor")) {
        response.sendRedirect("../tutor/menu.jsp");
    } else if (rol.equals("Docente")) {

    } else {
        response.sendRedirect("../../index.jsp");
    }

    String CI_estudiante = request.getParameter("ci");

%>

<!DOCTYPE html>
<html lang="en">
    <% ControladorVarios conVar = new ControladorVarios();%>
    <% ControladorEstudiante conEst = new ControladorEstudiante();%>
    <% ControladorMateria conMat = new ControladorMateria();%>


    <%@include file="head.jsp" %>

    <body class="yellow accent-2">

        <!-- Inicio HEADER -->
        <header>
            <div class="fixed-action-btn vertical click-to-toggle">
                <a href="#" class="btn tooltipped button-collapse btn-floating btn-large blue darken-4 pulse" data-activates="slide-out" data-position="left" data-tooltip="Menu">
                    <i class="material-icons yellow-text">apps</i>
                </a>
            </div>
            <div class="navbar-fixed">
                <nav class="blue darken-3">
                    <div class="nav-wrapper">
                        <a href="#" class="brand-logo center yellow-text hide-on-med-and-down">Sistema Gestor de Practicas</a>
                        <ul id="nav-mobile" class="right">
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Ayuda"><i class="material-icons yellow-text">help</i></a></li>
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Foro"><i class="material-icons yellow-text">forum</i></a></li>
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Mi Cuenta"><i class="material-icons yellow-text">account_circle</i></a></li>
                            <li><a href="../../index.jsp" class="tooltipped" data-position="button" data-tooltip="Salir"><i class="material-icons yellow-text">directions_run</i></a></li>
                        </ul>
                    </div>
                    <div class="container">
                        <div class="nav-content">
                            <div class="col s12">
                                <ul class="tabs blue darken-3 tabs-fixed-width">
                                    <li class="tab col s3"><a class="yellow-text" href="#datos">Datos del Estudiante</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#notas">Notas</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#update">Actualizar</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </header>  
        <!-- Final HEADER nav-->

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
                                        <i class="material-icons yellow-text">face</i>Estudiante
                                    </a>
                                </li>
                                <li>
                                    <a href="docente.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">card_travel</i>Docente
                                    </a>
                                </li>
                                <li>
                                    <a href="tutor.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">contacts</i>Tutor
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
                                    <a href="ayuda.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">help</i>Ayuda
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Final del NAV-->

            <!-- Inicio del MENU -->
            <div class="row blue darken-3">

                <div id="datos" class="col s12">

                    <%=conVar.getDatosEstudiante(CI_estudiante)%>

                </div>
                <div id="notas" class="blue darken-3 yellow-text">

                    <%=conMat.getEvaluacionDocente(CI_estudiante)%>

                </div>
                <div id="update" class="blue darken-3 yellow-text">

                    <%=conEst.viewUpdateEstudiante(CI_estudiante)%>

                </div>


                <div id="search" class="modal modal-fixed-footer blue darken-3 yellow-text ">
                    <div class="modal-content blue darken-3">
                        <div class="row">
                            <h1 class="center yellow-text">Buscar Estudiante</h1>
                            <form method="post" class="col s12 yellow-text" >
                                <div class="row">
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix">account_circle</i>
                                        <input id="apellido_estudiante" type="text">
                                        <label for="apellido_estudiante">Apellido</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix">contact_mail</i>
                                        <input id="ci_estudiante" type="text">
                                        <label for="ci_estudiante"># de Carnet</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <a id="buscar_estudiante" data-id="<%=usuario%>" class="waves-effect waves-light waves-teal yellow accent-2 blue-text text-darken-3 btn-large"> 
                                            <i class="material-icons right">search</i>Buscar
                                        </a>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="row">
                            <div id="ver_estudiante_buscado"></div>

                        </div>

                    </div>

                    <div class="modal-footer blue darken-3 yellow-text">
                        <button class="modal-action modal-close waves-effect waves-teal yellow accent-2 blue-text text-darken-3 waves-yellow btn-flat">
                            Cerrar<i class="material-icons right">clear_all</i>
                        </button>
                    </div>
                </div>

            </div>
            <!-- Final del MENU -->

        </main>

        <%@include file="foother.jsp" %>
    </body>
</html>