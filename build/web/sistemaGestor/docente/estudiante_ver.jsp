<%-- 
    Document   : estudiante_ver
    Created on : 15/11/2017, 11:04:20 AM
    Author     : WarMachine
--%>


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

    } else if (rol.equals("Tutor")) {
        response.sendRedirect("../tutor/menu.jsp");
    } else if (rol.equals("Docente")) {

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
                            <li><a href="../../index.jsp" class="tooltipped" data-position="button" data-tooltip="Salir"><i class="material-icons yellow-text">directions_run</i></a></li>
                        </ul>
                    </div>
                    <div class="container">
                        <div class="nav-content">
                            <div class="col s12">
                                <ul class="tabs blue darken-3 tabs-fixed-width">
                                    <li class="tab col s3"><a class="yellow-text" href="#datos">Datos del Estudiante</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#notas">Notas</a></li>
                                    <li class="tab col s3"><a class="yellow-text" href="#update">Actualizar</a></li>
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
            <div class="row blue darken-3">

                <div id="datos" class="col s12">

                    <div class="container yellow-text">
                        <div class="row">
                            <br>
                            <div class="col s2">
                                <img class="responsive-img materialboxed" src="../../img/fcea/estudiantes/imagen1.jpg" width="200" alt="Juan" >
                            </div>
                            <div class="col s10">
                                <h2 class="center">Arza Perez, Juan Mario</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s6">
                                <h4><i class="material-icons yellow-text small">fingerprint</i>  CI:  9879872</h4>
                            </div>
                            <div class="col s6">
                                <h4><i class="material-icons yellow-text small">contacts</i>  Telefono: 87687678</h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s6">
                                <h4>Estado:  <span class="green-text">Activo</span>  <i class="material-icons green-text small">sentiment_very_satisfied</i></h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <table class="bordered responsive-table">
                                    <thead>
                                        <tr>
                                            <th>Materia</th>
                                            <th>Primer Parcial</th>
                                            <th>Segundo Parcial</th>
                                            <th>Examen Final</th>
                                            <th>Nota Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Practica Empresarial II</td>
                                            <td>19,25</td>
                                            <td>35,00</td>
                                            <td>,00</td>
                                            <td>54,25</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <div id="notas" class="blue darken-3 yellow-text">

                    <div class="row">
                        <h3 class="center">Arza Perez, Juan Mario</h3>
                        <div class="col s3">
                            <h4 class="center">Primer Parcial</h4>
                            <h3 class="center">19.25</h3>
                        </div>
                        <div class="col s3">
                            <h4 class="center">Segundo Parcial</h4>
                            <h3 class="center">35.0</h3>
                        </div>
                        <div class="col s6">
                            <div class="row">
                                <form>       
                                    <h5 class="center">Evaluacion Examen Final</h5>
                                    <div class="col s6">
                                        <table class="bordered">
                                            <thead>
                                                <tr>
                                                    <th>A - Organizacion y Ejecucion del Trabajo</th>
                                                    <th>Puntaje</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td value="1" id="criterio1">1 - Demuestra Seguridad y Habilidad en Trabajo</td>
                                                    <td><input id="nota1" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="3" id="criterio2">2 - Es ordenando y prolijo. Realiza las tareas asignadas con esmero y dedicación.</td>
                                                    <td><input id="nota2" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="4" id="criterio3">3 - Planifica el trabajo a realizar.</td>
                                                    <td><input id="nota3" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="5" id="criterio4">4 - Distribuye el tiempo según las necesidades.</td>
                                                    <td><input id="nota4" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="6" id="criterio5">5 - Usa adecuadamente los equipos tecnológicos proporcionados.</td>
                                                    <td><input id="nota5" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <table class="bordered">
                                            <thead>
                                                <tr>
                                                    <th>B - Capacidad Empresarial</th>
                                                    <th>Puntaje</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td value="18" id="criterio6">6 - Identifica los objetivos de la unidad donde trabaja.</td>
                                                    <td><input id="nota6" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="19" id="criterio7">7 - Es capaz de identificar situaciones que requieren la oportuna intervención profesional en su área de trabajo.</td>
                                                    <td><input id="nota7" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="20" id="criterio8">8 - En sus intervenciones, propone soluciones acertadas a los problemas existentes.</td>
                                                    <td><input id="nota8" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="21" id="criterio9">9 - Presenta propuestas creativas e innovadoras para optimizar el trabajo.</td>
                                                    <td><input id="nota9" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="22" id="criterio10">10 - Integra adecuadamente la teoría y práctica que permite mantener la rigurosidad científica.</td>
                                                    <td><input id="nota10" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="col s6">
                                        <table class="bordered">
                                            <thead>
                                                <tr>
                                                    <th>C - Aspecto Actitudinal</th>
                                                    <th>Puntaje</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td value="23" id="criterio11">11 - Es respetuoso con el equipo de trabajo y la atención a las personas.</td>
                                                    <td><input id="nota11" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="24" id="criterio12">12 - La indumentaria, el uso del lenguaje y la puntualidad caracteriza al practicante.</td>
                                                    <td><input id="nota12" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="25" id="criterio13">13 - Es asertivo y empático con las personas.</td>
                                                    <td><input id="nota13" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="26" id="criterio14">14 - Denota interés por aprender cosas nuevas.</td>
                                                    <td><input id="nota14" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="27" id="criterio15">15 - Reacciona de forma proactiva frente a las situaciones que le corresponde enfrentar.</td>
                                                    <td><input id="nota15" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <table class="bordered">
                                            <thead>
                                                <tr>
                                                    <th>D - Proyeccion Educativa</th>
                                                    <th>Puntaje</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td value="28" id="criterio16">16 - Se comunica con propiedad y fluidez.</td>
                                                    <td><input id="nota16" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="29" id="criterio17">17 - Participa activamente en las actividades programadas por la empresa/institución.</td>
                                                    <td><input id="nota17" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="30" id="criterio18">18 - Es cortés y tiene buen trato con sus semejantes.</td>
                                                    <td><input id="nota18" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="31" id="criterio19">19 - Su comportamiento denota poseer altos valores éticos y morales.</td>
                                                    <td><input id="nota19" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                                <tr>
                                                    <td value="32" id="criterio20">20 - Es colaborador, capaz de integrarse al equipo de trabajo.</td>
                                                    <td><input id="nota20" type="number" min="1" max="10" class="validate bold" style="width: 60px; font-size: 30px"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </form>
                            </div>
                            <div class="col s6 center-aling">
                                <button class="btn waves-effect waves-light yellow accent-2 blue-text left tooltipped" data-position="button" data-tooltip="Guardar" type="button" data-id="9879872" id="guardarNuevaNota">
                                    Validar y Guardar<i class="material-icons right">save</i>
                                </button>
                                <br><br><br><br>
                            </div>
                            <div id="notaGuardada" class="col s6 center-aling">
                            </div>
                        </div>

                    </div>
                    <div id="update" class="blue darken-3 yellow-text">

                        <div class="container">
                            <form method="post" id="estAc" class="col s12 yellow-text">
                                <div class="row">
                                    <h1 class="center yellow-text">Actualizar Datos del Estudiante</h1>
                                </div>
                                <div class="row">
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix yellow-text">assignment_ind</i>
                                            <input id="primerNombreAc" type="text" value="Juan" class="validate">
                                            <label class="yellow-text" for="Primer Nombre">Primer Nombre</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix yellow-text">assignment_ind</i>
                                            <input id="segundoNombreAc" type="text" value="Mario">
                                            <label class="yellow-text" for="Segundo Nombre">Segundo Nombre</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix yellow-text">wc</i>
                                            <input id="primerApellidoAc" type="text" value="Arza" class="validate">
                                            <label class="yellow-text" for="Primer Apellido">Primer Apellido</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix yellow-text">wc</i>
                                            <input id="segundoApellidoAc" type="text" value="Perez" class="validate">
                                            <label class="yellow-text" for="Segundo Apellido">Segundo Apellido</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix yellow-text">fingerprint</i>
                                            <input id="ciAc" type="text" disabled value="9879872" class="validate">
                                            <label class="yellow-text" for="ci"># de Carnet</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <i class="material-icons prefix yellow-text">contact_phone</i>
                                            <input id="celularAc" type="text" value="87687678" class="validate">
                                            <label class="yellow-text" for="celular">Telefono - Celular</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col s6">
                                    <a class="btn waves-effect waves-light yellow accent-2 blue-text left" type="button" id="estudianteAc">
                                        Actualizar<i class="material-icons right">save</i>
                                    </a>
                                </div>
                                <div id="notificacionEstudianteAc">
                                </div>
                                <br><br><br>
                            </form>
                        </div>

                    </div>


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

                </div>
            </div>
            <!-- Final del MENU -->

        </main>

        <%@include file="foother.jsp" %>
    </body>
</html>