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
<html lang="en">
    <% ControladorVarios conVar = new ControladorVarios();%>

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
                                    <a href="tutor.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">contacts</i>Tutor
                                    </a>
                                </li>
                                <li>
                                    <a href="materia.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">storage</i>Materias
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
            <div class="container">
                <div class="row">
                    <div class="col s4">
                        <div class="card blue darken-3 yellow-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">face</i></span>
                                <h5 class="center">Estudiantes</h5>
                                <p class="truncate">Una descripcion de los la tabla estudiantes</p>
                            </div>
                            <div class="card-action center">
                                <h5><a href="estudiante.jsp" class="yellow-text"> <%=conVar.cantidadEstudiantes()%></a></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col s4">
                        <div class="card blue darken-3 yellow-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">card_travel</i></span>
                                <h5 class="center">Docentes</h5>
                                <p class="truncate">Una descripcion de los la tabla Docentes</p>
                            </div>
                            <div class="card-action center">
                                <h5><a href="docente.jsp" class="yellow-text"><%=conVar.cantidadDocentes()%></a></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col s4">
                        <div class="card blue darken-3 yellow-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">contacts</i></span>
                                <h5 class="center">Tutores</h5>
                                <p class="truncate">Una descripcion de los la tabla Tutores</p>
                            </div>
                            <div class="card-action center">
                                <h5><a href="tutor.jsp" class="yellow-text"><%=conVar.cantidadTutores()%></a></h5>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s4">
                        <div class="card blue darken-3 yellow-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">format_list_bulleted</i></span>
                                <h5 class="center">Carreras</h5>
                                <p class="truncate">Una descripcion de los la tabla Carreras</p>
                            </div>
                            <div class="card-action center">
                                <h5><a href="carrera.jsp" class="yellow-text"><%=conVar.cantidadCarreras()%></a></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col s4">
                        <div class="card blue darken-3 yellow-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">storage</i></span>
                                <h5 class="center">Materias</h5>
                                <p class="truncate">Una descripcion de los la tabla Materias</p>
                            </div>
                            <div class="card-action center">
                                <h5><a href="materia.jsp" class="yellow-text"><%=conVar.cantidadMaterias()%></a></h5>
                            </div>
                        </div>
                    </div>
                    <div class="col s4">
                        <div class="card blue darken-3 yellow-text hoverable">
                            <div class="card-content">
                                <span class="card-title center"><i class="medium material-icons">store</i></span>
                                <h5 class="center">Empresas</h5>
                                <p class="truncate">Una descripcion de los la tabla Empresas</p>
                            </div>
                            <div class="card-action center">
                                <h5><a href="empresa.jsp" class="yellow-text"><%=conVar.cantidadEmpresas()%></a></h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Final del MENU -->



        </main>

        <%@include file="foother.jsp" %>

    </body>
</html>