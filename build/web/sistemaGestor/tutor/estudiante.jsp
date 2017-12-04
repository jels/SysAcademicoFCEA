<%-- 
    Document   : estudiante
    Created on : 06/09/2017, 06:36:45 PM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorMateria"%>
<%@page import="Controller.ControladorVarios"%>
<%@page import="Controller.ControladorEstudiante"%>
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
%>
<!DOCTYPE html>
<html lang="en">
    <% ControladorEstudiante conEst = new ControladorEstudiante();%>
    <% ControladorVarios conVar = new ControladorVarios();%>
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
                            <li><a href="perfil.jsp" class="tooltipped" data-position="button" data-tooltip="Mi Cuenta"><i class="material-icons yellow-text">account_circle</i></a></li>
                            <li><a href="../../web-fcea/index.jsp" class="tooltipped" data-position="button" data-tooltip="Salir"><i class="material-icons yellow-text">directions_run</i></a></li>
                        </ul>
                    </div>
                    <div class="container">
                        <div class="nav-content">
                            <div class="col s12">
                                <ul class="tabs  blue darken-3 tabs-fixed-width">
                                    <li class="tab col s3"><a class="yellow-text" href="#cantidad">Resumen</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#show">Mostrar</a></li>
                                </ul>
                            </div>
                        </div>
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
                                        <i class="material-icons yellow-text">face</i>Estudiante
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
            <!-- Fin NAV -->

            <div class="row blue darken-3">

                <!-- Inicio del cantidad -->
                <div id="cantidad" class="col s12">                    
                    <div class="container">
                        <h1 class="center yellow-text">Estudiantes</h1>
                        <div class="row">
                            <div class="col s12">
                                <h2 class="center yellow-text"><%=conEst.cantidadEstudiantes_tutor(usuario)%></h2>
                                <h3 class="center yellow-text">Registrados en La Empresa <%=conVar.getNombreEmpresa(usuario)%></h3>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s6">
                                <h2 class="center yellow-text"><%=conEst.getEvaluadosPrimerParcial(usuario)%></h2>
                                <h5 class="center yellow-text">Evaluados Primer Parcial</h5>
                            </div>
                            <div class="col s6">
                                <h2 class="center yellow-text"><%=conEst.getEvaluadosSegundoParcial(usuario)%></h2>
                                <h5 class="center yellow-text">Evaluados Segundo Parcial</h5>
                            </div>

                        </div>
                    </div>
                </div>
                <!-- Fin del cantidad -->

                <!-- Inicio del show --> 
                <div id="show">
                    <%=conEst.verEstudiantesXTutor(usuario)%>
                </div>
                <!-- Fin del show -->

                <!-- Inicio del search -->
                <div id="search" class="modal modal-fixed-footer blue darken-3 yellow-text">
                    <div class="modal-content blue darken-3">
                        <div class="row">
                            <h1 class="center yellow-text">Buscar Estudiante</h1>
                            <form method="post" class="col s12 yellow-text" >
                                <div class="row">
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix">account_circle</i>
                                        <input id="apellido_estudiante" type="text">
                                        <label for="apellido_estudiante">Apellido Paterno</label>
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
                            <div id="verNotaAsignada"></div>

                        </div>

                    </div>

                    <div class="modal-footer blue darken-3 yellow-text">
                        <button class="modal-action modal-close waves-effect waves-teal yellow accent-2 blue-text text-darken-3 waves-yellow btn-flat">
                            Cerrar<i class="material-icons right">clear_all</i>
                        </button>
                    </div>
                </div>
                <!-- Final del Modal search --> 

                <!-- Inicio del Modal verNotaAsignada -->
                <div id="verNotaAsignada" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <div id="ver_Nota_Asignada_estudiante"></div> 

                </div>
                <!-- Final del Modal verNotaAsignada --> 

                <!-- Inicio del Modal verReporte -->
                <div id="verReporte" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <div id="ver_Nota_Asignada_estudiante"></div> 

                </div>
                <!-- Final del Modal verReporte -->  

            </div>

        </main>

        <%@include file="foother.jsp" %>

    </body>
</html>