<%-- 
    Document   : estudiante_ver
    Created on : 17/11/2017, 12:06:42 AM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorAsignacionPractica"%>
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
    <% ControladorEstudiante conEst = new ControladorEstudiante();%>
    <% ControladorMateria conMat = new ControladorMateria();%>
    <% ControladorAsignacionPractica conAsp = new ControladorAsignacionPractica();%>


    <%@include file="head.jsp" %>

    <body class="yellow accent-2">

        <!-- Inicio HEADER -->
        <header>
            <div class="fixed-action-btn vertical click-to-toggle">
                <a href="#" class="btn tooltipped button-collapse btn-floating btn-large blue darken-4 pulse" data-activates="slide-out" data-position="left" data-tooltip="Men�">
                    <i class="material-icons yellow-text">apps</i>
                </a>
            </div>
            <div class="navbar-fixed">
                <nav class="blue darken-3">
                    <div class="nav-wrapper">
                        <a href="#" class="brand-logo center yellow-text hide-on-med-and-down">Sistema Gestor de Pr�cticas</a>
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
                                <ul class="tabs blue darken-3 tabs-fixed-width">
                                    <li class="tab col s4"><a class="yellow-text" href="#datos">Datos del Estudiante</a></li>
                                    <li class="tab col s4"><a class="yellow-text" href="#detalle">Detalle Pr�ctica</a></li>
                                    <li class="tab col s4"><a class="yellow-text" href="#evaluacion">Evaluaciones</a></li>
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

                <!-- Inicio del datos -->
                <div id="datos" class="col s12 blue darken-3 yellow-text">

                    <%=conVar.getDatosEstudianteTutor(CI_estudiante)%>

                </div>
                <!-- Fin datos -->

                <!-- Inicio del evaluacion -->
                <div id="evaluacion" class="col s12 blue darken-3 yellow-text">

                    <%=conMat.getEvaluacion(CI_estudiante)%>

                </div>
                <!-- Fin evaluacion -->

                <!-- Inicio del detalle -->
                <div id="detalle" class="col s12 blue darken-3 yellow-text">

                    <%=conAsp.verDetallePracticaXtutor(CI_estudiante)%>

                </div>
                <!-- Fin detalle -->

                <!-- Inicio del newPractica  -->
                <div id="newPracticaPrimer" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <%=conAsp.modalNewPractica(CI_estudiante, 1)%>

                </div>

                <div id="newPracticaSegundo" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <%=conAsp.modalNewPractica(CI_estudiante, 2)%>

                </div>
                <!-- Fin newPractica -->

                <!-- Inicio del newDetallePractica-->
                <div id="newDetallePracticaPrimer" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <%=conAsp.modalDetallePractica(CI_estudiante, 1)%>

                </div> 

                <div id="newDetallePracticaSegundo" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <%=conAsp.modalDetallePractica(CI_estudiante, 2)%>

                </div> 
                <!-- Fin newDetallePractica -->

                <div id="perfil" class="modal blue darken-3 yellow-text">

                    <%=conVar.getDatosTutor(usuario)%>

                </div>

            </div>
            <!-- Final del MENU -->

        </main>

        <%@include file="foother.jsp" %>

    </body>

</html>