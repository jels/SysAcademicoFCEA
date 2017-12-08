<%-- 
    Document   : empresas
    Created on : 06/09/2017, 06:37:37 PM
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
                                    <a href="practicas.jsp" class="waves-effect yellow-text">
                                        <i class="material-icons yellow-text">format_list_bulleted</i>Practicas
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
                    <%=conEmp.verEmpresas()%>
                </div>
                <!-- Final del show -->

                <!-- Inicio del Modal search -->
                <div id="search" class="modal modal-fixed-footer blue darken-3 yellow-text">
                    <div class="modal-content blue darken-3">
                        <div class="row">
                            <h1 class="center yellow-text">Buscar Empresa</h1>
                            <form method="post" class="col s12 yellow-text" >
                                <div class="row">
                                    <div class="input-field col s8">
                                        <i class="material-icons prefix">store</i>
                                        <input id="nombreEmpresaBuscar" type="text">
                                        <label for="nombreEmpresaBuscar">Nombre Empresa</label>
                                    </div>
                                    <div class="input-field col s4">
                                        <a  class="waves-effect waves-light waves-teal yellow accent-2 blue-text text-darken-3 btn-large"> 
                                            <i class="material-icons right">search</i>Buscar
                                        </a>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="row">
                            <div id="ver_empresa_buscada"></div>
                        </div>
                    </div>
                    <div class="modal-footer blue darken-3 yellow-text">
                        <button class="modal-action modal-close waves-effect waves-teal yellow accent-2 blue-text text-darken-3 waves-yellow btn-flat">
                            Cerrar<i class="material-icons right">clear_all</i>
                        </button>
                    </div>
                </div>
                <!-- Final del Modal search --> 

                <!-- Inicio del Modal new -->
                <div id="new" class="modal modal-fixed-footer blue darken-3 yellow-text">

                    <div class="modal-content blue darken-3">
                        <div class="row">
                            <h1 class="center yellow-text">Nueva Empresa</h1>
                        </div>
                        <div class="row">
                            <form method="post" id="newEmpresa" action="../../estudiante.do" class="col s12 yellow-text" >
                                <h5>Datos de la Empresa</h5>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">store</i>
                                        <input id="nombreEmpresa" type="text" class="validate">
                                        <label class="yellow-text" for="Nombre Empresa">Nombre</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">directions</i>
                                        <input id="direccionEmpresa" type="text" >
                                        <label class="yellow-text" for="Direccion Empresa">Direccion</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">contacts</i>
                                        <input id="telefonoEmpresa" type="text" class="validate">
                                        <label class="yellow-text" for="Telefono Empresa">Telefono</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">description</i>
                                        <input id="rubroEmpresa" type="text" class="validate">
                                        <label class="yellow-text" for="Rubro Empresa">Rubro</label>
                                    </div>
                                </div>
                                <h5>Datos del Representante de la Empresa</h5>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="primerNombreRepresentante" type="text" class="validate">
                                        <label class="yellow-text" for="primerNombreRepresentante">Primer Nombre</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">assignment_ind</i>
                                        <input id="segundoNombreRepresentante" type="text" class="validate">
                                        <label class="yellow-text" for="segundoNombreRepresentante">Segundo Nombre</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="primerApellidoRepresentante" type="text" class="validate">
                                        <label class="yellow-text" for="primerApellidoRepresentante">Primer Apellido</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">wc</i>
                                        <input id="segundoApellidoRepresentante" type="text" class="validate">
                                        <label class="yellow-text" for="segundoApellidoRepresentante">Segundo Apellido</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">fingerprint</i>
                                        <input id="ciRepresentante" type="text" class="validate">
                                        <label class="yellow-text" for="ciRepresentante"># de Carnet</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">contact_phone</i>
                                        <input id="celularRepresentante" type="text" class="validate">
                                        <label class="yellow-text" for="celularRepresentante">Telefono - Celular</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix yellow-text">supervisor_account</i>
                                        <input id="cargoRepresentante" type="text" class="validate">
                                        <label class="yellow-text" for="cargoRepresentante">Cargo</label>
                                    </div>
                                </div>


                            </form>
                        </div>


                    </div>

                    <div class="modal-footer blue darken-3 yellow-text">
                        <div class="col s6">
                            <button class="btn waves-effect waves-light yellow accent-2 blue-text left" type="button" id="nuevaEmpresa">
                                Validar y Guardar<i class="material-icons right">save</i>
                            </button>
                        </div>
                        <div id="notificacionNewEmpresa">
                        </div>
                    </div>

                </div>
                <!-- Final del new --> 

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