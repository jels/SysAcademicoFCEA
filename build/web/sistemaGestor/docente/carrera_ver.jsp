<%-- 
    Document   : carrera_ver
    Created on : 26/11/2017, 08:10:16 AM
    Author     : WarMachine
--%>
<%@page import="Controller.ControladorMateria"%>
<%@page import="Controller.ControladorCarrera"%>
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
    String carrera = request.getParameter("carrera");

%>

<!DOCTYPE html>
<html lang="en">
    <% ControladorVarios conVar = new ControladorVarios();%>
    <% ControladorCarrera conCar = new ControladorCarrera();%>
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
                            <li><a href="../../web-fcea/index.jsp" class="tooltipped" data-position="button" data-tooltip="Salir"><i class="material-icons yellow-text">directions_run</i></a></li>
                        </ul>
                    </div>
                    <div class="container">
                        <div class="nav-content">
                            <div class="col s12">
                                <ul class="tabs blue darken-3 tabs-fixed-width">
                                    <li class="tab col s3"><a class="yellow-text" href="#resumen">Resumen</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#materias">Materias</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#editar">Editar</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#editarCoordinador">Coordinador</a></li>
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
                                    <a href="../../index.jsps" class="waves-effect yellow-text">
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
            <div class="row blue darken-3 yellow-text">

                <!-- Inicio del resumen-->
                <div id="resumen" class="col s12 blue darken-3 yellow-text">                    
                    <%=conCar.verCarrera(carrera)%>
                </div>
                <!-- Final del resumen-->

                <!-- Inicio del materias-->
                <div id="materias">
                    <%=conMat.verMateriaXCarrera(carrera)%>
                </div>
                <!-- Final del materias-->

                <!-- Inicio Modal new -->
                <div id="new" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <div class="modal-content blue darken-3">
                        <div class="row">
                            <h1 class="center yellow-text">Nueva Materia</h1>
                        </div>
                        <div class="row">
                            <form id="nuevamat" class="col s12 yellow-text">
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="nombreMat" type="text" class="validate">
                                        <label class="yellow-text" for="Nombre Materia">Nombre Materia</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="semestreMat" type="text" >
                                        <label class="yellow-text" for="Semestre">Semestre</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="horasPracticas" type="number" class="validate">
                                        <label class="yellow-text" for="Horas Practicas">Horas Practicas</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="descripcionMateria" type="text" class="validate">
                                        <label class="yellow-text" for="Descripcion Materia">Descripcion Materia</label>
                                    </div>
                                </div>
                            </form>
                        </div>


                    </div>

                    <div class="modal-footer blue darken-3 yellow-text">
                        <div class="col s6">
                            <button class="btn waves-effect waves-light yellow accent-2 blue-text left" type="button" id="nuevaMateria" data-id=<%=carrera%> >
                                Validar y Guardar<i class="material-icons right">save</i>
                            </button>
                        </div>
                        <div id="notificacionNewMateria">
                        </div>
                    </div>

                </div>
                <!-- Final Modal new -->

                <!-- Inicio del editar-->
                <div id="editar" class="col s12">
                    <%=conCar.editarCarrera(carrera)%>
                </div>
                <!-- Final del editar-->

                <!-- Inicio del editarCoordinador-->
                <div id="editarCoordinador" class="col s12">
                    <%=conCar.editarCoordinador(carrera)%>
                </div>
                <!-- Final del editarCoordinador-->

            </div>
            <!-- Final del MENU -->


        </main>

        <%@include file="foother.jsp" %>

    </body>
</html>