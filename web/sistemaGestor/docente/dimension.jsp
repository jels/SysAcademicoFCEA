<%-- 
    Document   : dimension
    Created on : 27/11/2017, 12:34:31 AM
    Author     : WarMachine
--%>


<%@page import="Controller.ControladorMateria"%>
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
    int idDimension = Integer.parseInt(request.getParameter("dimension"));
    int idMateria = Integer.parseInt(request.getParameter("materia"));
    String abreviatura = request.getParameter("carrera");
%>

<!DOCTYPE html>
<html lang="es">
    <% ControladorVarios conVar = new ControladorVarios();%>
    <% ControladorMateria conMat = new ControladorMateria();%>
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
                                    <li class="tab col s3"><a class="yellow-text" href="#resumen">Resumen</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#criterios">Criterios</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#editar">Editar</a></li>
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
                                    <a href="materia.jsp?materia=<%=idMateria%>&carrera=<%=abreviatura%>" class="waves-effect yellow-text">
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

                <!-- Inicio resumen -->

                <div id="resumen" class="col s12 blue darken-3 yellow-text">

                    <%=conMat.viewDimension(idDimension)%>

                </div>
                <!-- Final resumen-->

                <!-- Inicio del criterios -->
                <div id="criterios" class="col s12 blue darken-3 yellow-text">

                    <%=conMat.getViewCriteriosXDimension(idDimension, idMateria, abreviatura)%>

                </div>
                <!-- Final del criterios-->

                <!-- Inicio del editar -->
                <div id="editar" class="col s12 blue darken-3 yellow-text">
                    <%=conMat.editarDimension(idDimension)%>
                </div>
                <!-- Final del editar-->

                <!-- Inicio del new-->
                <div id="new" class="modal modal-fixed-footer blue darken-3 yellow-text">
                    <%
                        if (conMat.getCantidadCriteriosXDimension(idDimension) >= 5) {
                    %>
                    <div class="modal-content blue darken-3">
                        <div class="col s12 center">
                            <h3>No puede crear mas criterios hasta que desactive alguno de los que están activos</h3>
                        </div>
                    </div>
                    <div class="modal-footer blue darken-3 yellow-text">
                        <div class="col s12">
                            <button class="btn waves-effect waves-light modal-close yellow accent-2 blue-text right tooltipped" type="button" data-position="button" data-tooltip="Cerrar">
                                Cerrar<i class="material-icons right">clear_all</i>
                            </button>
                        </div>
                    </div>
                    <%
                    } else {
                    %>
                    <div class="modal-content blue darken-3">
                        <div class="row">
                            <h1 class="center yellow-text">Nuevo Criterio</h1>
                        </div>
                        <div class="row">
                            <form method="POST" id="newCrite" class="col s12 yellow-text">
                                <!--Datos del Criterio -->
                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix yellow-text">library_add</i>
                                        <input id="nombreCriterio" type="text" class="validate">
                                        <label class="yellow-text" for="Nombre Criterio">Nombre Criterio</label>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer blue darken-3 yellow-text">
                        <div class="col s6">
                            <button class="btn waves-effect waves-light yellow accent-2 blue-text left tooltipped" type="button" id="nuevoCriterio"  data-position="button" data-tooltip="Guardar y Validar" data-id=<%=idDimension%> >
                                Validar y Guardar<i class="material-icons right">save</i>
                            </button>
                        </div>
                        <div id="notificacionNewCriterio">
                        </div>
                    </div>
                    <%
                        }
                    %>

                </div>
                <!-- Final del dimensiones-->

            </div>

            <!-- Final del MENU -->

        </main>

        <%@include file="foother.jsp" %>

    </body>

</html>