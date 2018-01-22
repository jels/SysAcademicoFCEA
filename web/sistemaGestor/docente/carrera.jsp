<%-- 
    Document   : carreras
    Created on : 06/09/2017, 06:37:30 PM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorCarrera"%>
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
    <% ControladorCarrera conCar = new ControladorCarrera();%>
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

            <div class="row blue darken-3">

                <!-- Inicio cantidad -->

                <div id="cantidad" class="col s12"> 

                    <div class="container">
                        <h1 class="center yellow-text">Carreras</h1>
                        <h2 class="center yellow-text"><%=conCar.cantidadCarreras(usuario)%></h2>
                        <h3 class="center yellow-text">Todas las Carreras de la Facultad de Ciencias Económicas y Administrativas </h3>
                    </div>

                </div>
                <!-- Final cantidad-->

                <!-- Inicio del show -->
                <div id="show">
                    <%=conCar.verCarreras(usuario)%>
                </div>
                <!-- Final del show-->

                <!-- Inicio del MENU -->
                <!-- Modal Structure -->
                <div id="new" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <div class="modal-content blue darken-3">
                        <div class="row">
                            <h1 class="center yellow-text">Nueva Carrera</h1>
                        </div>
                        <div class="row">
                            <form method="POST" action="../../carrera.do" enctype="multipart/form-data" id="nuevacarrera" class="col s12 yellow-text">
                                <!--Datos de la carrera -->
                                <h4>Datos de la Carrera</h4>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="nombreCarrera" type="text" class="validate">
                                        <label class="yellow-text" for="Nombre Carrera">Nombre Carrera</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="abreviaturaCarrera" type="text" >
                                        <label class="yellow-text" for="Abreviatura">Abreviatura</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <textarea id="descripcionCarrera" class="materialize-textarea"></textarea>
                                        <label for="Descripcion">Descripción</label>
                                    </div>
                                </div>
                                <h4>Datos del Coordinador</h4>
                                <!--Datos del Coordinador -->
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="primerNombreCoordinador" type="text" class="validate">
                                        <label class="yellow-text" for="Primer Nombre">Primer Nombre</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="segundoNombreCoordinador" type="text" >
                                        <label class="yellow-text" for="Segundo Nombre">Segundo Nombre</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="primerApellidoCoordinador" type="text" class="validate">
                                        <label class="yellow-text" for="Primer Apellido">Primer Apellido</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="segundoApellidoCoordinador" type="text" >
                                        <label class="yellow-text" for="Segundo Apellido">Segundo Apellido</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">fingerprint</i>
                                        <input id="ciCoordinador" type="text" class="validate">
                                        <label class="yellow-text" for="# de Carnet">N° de Carnet</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">contact_phone</i>
                                        <input id="telefonoCoordinador" type="text" >
                                        <label class="yellow-text" for="Telefono">Teléfono</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="file-field input-field col s6">
                                        <div class="btn blue yellow-text">
                                            <span>Foto</span>
                                            <input type="file" id="fotoCoordinador">
                                        </div>
                                        <div class="file-path-wrapper">
                                            <input class="file-path validate" type="text"  placeholder="Seleccione una Foto">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer blue darken-3 yellow-text">
                        <div class="col s6">
                            <button class="btn waves-effect waves-light yellow accent-2 blue-text left tooltipped" type="button" id="newcarrera" data-id="<%=usuario%>" data-position="button" data-tooltip="Guardar y Validar">
                                Validar y Guardar<i class="material-icons right">save</i>
                            </button>
                        </div>
                        <div id="notificacionNewCarrera">
                        </div>
                    </div>

                </div>

            </div>


            <!-- Final del NAV-->

            <!-- Final del MENU -->


        </main>

        <%@include file="foother.jsp" %>

    </body>
</html>