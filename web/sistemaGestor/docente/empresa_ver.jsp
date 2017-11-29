<%-- 
    Document   : empresa_ver
    Created on : 27/11/2017, 09:08:22 PM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorEmpresa"%>
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
    <% ControladorEmpresa conEmp = new ControladorEmpresa(); %>
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

                <!-- Inicio del cantidad -->
                <div id="cantidad" class="col s12">                    
                    <div class="container">
                        <h1 class="center yellow-text">Empresas</h1>
                        <div class="row">
                            <div class="col s12">
                                <h2 class="center yellow-text"><%=conEmp.countEmpresas()%></h2>
                                <h3 class="center yellow-text">Total de Empresas Almacenadas</h3>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s6">
                                <h2 class="center yellow-text"><%=conEmp.countEmpresasActivas()%></h2>
                                <h5 class="center yellow-text">Empresas Activas</h5>
                            </div>
                            <div class="col s6">
                                <h2 class="center yellow-text"><%=conEmp.countEmpresasInactivas()%></h2>
                                <h5 class="center yellow-text">Empresas Inactivas</h5>
                            </div>

                        </div>
                    </div>
                </div>
                <!-- Final del cantidad-->

                <!-- Inicio del show -->
                <div id="show">

                </div>
                <!-- Final del show -->

                <!-- Inicio del Modal search -->
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
                            <div id="ver_estudiante_buscado"></div>

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
                <!-- Final del verNotaAsignada --> 

                <!-- Inicio del Modal verReporte -->
                <div id="verReporte" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <div id="ver_Nota_Asignada_estudiante"></div> 

                </div>
                <!-- Final del verReporte --> 


            </div>

            <!-- Final del MENU -->



        </main>

        <%@include file="foother.jsp" %>

    </body>
</html>