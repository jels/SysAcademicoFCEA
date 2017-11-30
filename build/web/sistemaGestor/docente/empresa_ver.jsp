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
    int idEmpresa = Integer.parseInt(request.getParameter("empresa"));

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
                                    <li class="tab col s3"><a class="yellow-text" href="#resumen">Resumen</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#editar">Editar</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#representante">Representante</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#tutores">Tutores</a></li>
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

            <div class="row blue darken-3">

                <!-- Inicio del resumen -->
                <div id="resumen" class="col s12 yellow-text">                    

                    <%=conEmp.verResumenXempresa(idEmpresa)%>

                </div>
                <!-- Final del resumen-->

                <!-- Inicio del editar -->
                <div id="editar" class="col s12 yellow-text">
                    <div class="container">
                        <div class="row">

                        </div>
                    </div>
                </div>
                <!-- Final del editar -->

                <!-- Inicio del representante -->
                <div id="representante" class="col s12 yellow-text">
                    <div class="container">
                        <div class="row">
                            <h1 class="center yellow-text">Representante</h1>
                        </div>
                    </div>
                </div>
                <!-- Final del representante -->

                <!-- Inicio del tutores -->
                <div id="tutores" class="col s12 yellow-text">                    
                    <%=conEmp.verTutoresXempresa(idEmpresa)%>
                </div>
                <!-- Final del tutores-->

                <!-- Inicio del Modal new -->
                <div id="new" class="modal modal-fixed-footer blue darken-3 yellow-text">
                    <div class="modal-content blue darken-3">
                        <div class="row">
                            <h1 class="center yellow-text">Nuevo Tutor</h1>
                        </div>
                        <div class="row">
                            <form method="post" id="crear_tut" class="col s12 yellow-text" enctype="multipart/form-data">
                                <div class="row">
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="primerNombreT" type="text" class="validate">
                                        <label class="yellow-text" for="Primer Nombre">Primer Nombre</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="segundoNombreT" type="text" >
                                        <label class="yellow-text" for="Segundo Nombre">Segundo Nombre</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="primerApellidoT" type="text" class="validate">
                                        <label class="yellow-text" for="Primer Apellido">Primer Apellido</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="segundoApellidoT" type="text" class="validate">
                                        <label class="yellow-text" for="Segundo Apellido">Segundo Apellido</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="celularT" type="text" >
                                        <label class="yellow-text" for="celularT">Celular</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="ciT" type="text" class="validate">
                                        <label class="yellow-text" for="ciT">CI</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="cargoT" type="text" class="validate">
                                        <label class="yellow-text" for="cargoT">Cargo</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="nombreUsuarioT" type="text" >
                                        <label class="yellow-text" for="nombreUsuarioT">Usuario</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="passUsuarioT" type="password" class="validate">
                                        <label class="yellow-text" for="passUsuarioT">Contraceña</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="file-field input-field col s6">
                                        <div class="btn blue yellow-text">
                                            <span>Perfil</span>
                                            <input type="file" id="imagenT">
                                        </div>
                                        <div class="file-path-wrapper">
                                            <input class="file-path validate" type="text"  placeholder="Seleccione una Foto">
                                        </div>
                                    </div>
                                    <div class="file-field input-field col s6">
                                        <div class="btn blue yellow-text">
                                            <span>Fondo</span>
                                            <input type="file" id="fondoT">
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
                            <button class="btn waves-effect waves-light yellow accent-2 blue-text left" type="button" id="crear_tutor"  data-id=<%=idEmpresa%>>
                                Validar y Guardar<i class="material-icons right">save</i>
                            </button>
                        </div>
                        <div id="notificacionNewTutor"></div>                    
                    </div>
                </div>
                <!-- Final del Modal new --> 

            </div>

            <!-- Final del MENU -->

        </main>

        <%@include file="foother.jsp" %>

    </body>
</html>