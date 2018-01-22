<%-- 
    Document   : estudiante
    Created on : 06/09/2017, 06:36:45 PM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorEstudiante"%>
<%@page import="Controller.ControladorVarios"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
    <% ControladorEstudiante conEst = new ControladorEstudiante();%>


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
                                    <li class="tab col s3"><a class="yellow-text" href="#cantidad">Resumen</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#show">Mostrar</a></li>
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
            <div class="row blue darken-3">

                <!-- Inicio del cantidad -->
                <div id="cantidad" class="col s12">                    
                    <div class="container">
                        <h1 class="center yellow-text">Estudiantes</h1>
                        <h2 class="center yellow-text"><%=conEst.cantidadEstudiantes()%></h2>
                        <h3 class="center yellow-text">Matriculados durante esta gestión académica en las materias de Prácticas Empresariales</h3>
                    </div>


                </div>
                <!-- Final del cantidad-->

                <!-- Inicio del show -->
                <div id="show">
                    <%=conEst.verEstudiantes()%>
                </div>
                <!-- Final del show-->

                <!-- Inicio del new -->
                <!-- Modal Structure -->
                <div id="new" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <div class="modal-content blue darken-3">
                        <div class="row">
                            <h1 class="center yellow-text">Nuevo Estudiante</h1>
                        </div>
                        <div class="row">
                            <form method="post" id="formNewEst" name="nuevo_estudiante" action="../../estudiante.do" class="col s12 yellow-text" enctype="multipart/form-data">
                                <input type="hidden" id="accion" name="accion" value="crear_estudiante" />
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="primerNombre" name="primerNombre" type="text" class="validate">
                                        <label class="yellow-text" for="Primer Nombre">Primer Nombre</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="segundoNombre" name="segundoNombre" type="text" >
                                        <label class="yellow-text" for="Segundo Nombre">Segundo Nombre</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="primerApellido" name="primerApellido" type="text" class="validate">
                                        <label class="yellow-text" for="Primer Apellido">Primer Apellido</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="segundoApellido" name="segundoApellido" type="text" class="validate">
                                        <label class="yellow-text" for="Segundo Apellido">Segundo Apellido</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">fingerprint</i>
                                        <input id="ci" name="ci" type="text" class="validate">
                                        <label class="yellow-text" for="ci">N° de Carnet</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">contact_phone</i>
                                        <input id="celular" name="celular" type="text" class="validate">
                                        <label class="yellow-text" for="celular">Teléfono - Celular</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <input type="hidden" id="idEstudiante" name="idEstudiante" value="null" />
                                    <div class="file-field input-field col s12">
                                        <div class="btn blue yellow-text">
                                            <span>Perfil</span>
                                            <input type="file" name="imagenEst" id="imagenE">
                                        </div>
                                        <div class="file-path-wrapper">
                                            <input id="imagenE_nombre" name="nombre_imagenE" class="file-path validate" type="text"  placeholder="Seleccione una Foto">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>


                    </div>

                    <div class="modal-footer blue darken-3 yellow-text">
                        <div class="col s6">
                            <button class="btn waves-effect waves-light yellow accent-2 blue-text left" type="button" id="nuevoestudiante" name="">
                                Validar y Guardar<i class="material-icons right">save</i>
                            </button>
                        </div>
                        <div id="notificacionnewEstudiante">
                        </div>
                    </div>

                </div>
                <!-- Final del new-->

                <!-- Inicio del search -->
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
                                        <label for="ci_estudiante">N° de Carnet</label>
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
                <!-- Final del search-->

            </div>
            <!-- Final del MENU -->

        </main>

        <%@include file="foother.jsp" %>
    </body>
</html>