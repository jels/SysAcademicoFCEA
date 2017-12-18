<%-- 
    Document   : evaluacionParcial
    Created on : 03/12/2017, 09:28:09 PM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorReportes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String CI_estudiante = request.getParameter("ci");
    int parcial = Integer.parseInt(request.getParameter("parcial"));

%>

<!DOCTYPE html>
<html>
    <% ControladorReportes conRep = new ControladorReportes();%>
    <head>
        <title>hola</title>
        <link rel="stylesheet" href="../../../css/materialize.min.css">
        <script src="../../../js/materialize.min.js"></script>
        <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">

        <script language="Javascript">
            function imprSelec(nombre) {
                var ficha = document.getElementById(nombre);
                var ventimp = window.open(' ', 'popimpr');
                ventimp.document.write(ficha.innerHTML);
                ventimp.document.close();
                var css = ventimp.document.createElement("link");
                css.setAttribute("href", "../../../css/materialize.min.css");
                css.setAttribute("rel", "stylesheet");
                css.setAttribute("type", "text/css");
                ventimp.document.head.appendChild(css);
                ventimp.print( );
                ventimp.close();
            }
        </script>

    </head>
    <body class="white black-text">
        <%
            if (conRep.getEvaluacionCompleta(CI_estudiante, parcial)) {
        %>

        <div id="imprimeme">

            <main>
                <div style="margin-left: 1cm;">
                    <div class="row">
                        <div class="col s2">
                            <a  href="javascript:imprSelec('imprimeme')"><img class="responsive-img" src="../../../img/fcea/uab.bmp" width="50"></a>
                        </div>
                        <div class="col s8">
                            <p class="center-align">
                                <font size=2>UNIVERSIDAD ADVENTISTA DE BOLIVIA</font><br/>
                                <font size=2>FACULTAD DE CIENCIAS ECONÓMICAS Y ADMINISTRATIVAS</font><br/>
                                <font size=5>FORMULARIO DE EVALUACIÓN</font><br/>
                                <font size=4>PRÁCTICA PRE-PROFECIONAL</font><br/>
                            </p>

                        </div>
                        <div class="col s2">
                            <a  href="javascript:imprSelec('imprimeme')"><img class="responsive-img" src="../../../img/fcea/logo-fcea.jpg" width="70"></a>
                        </div>
                        <div class="col s7">
                            <p class="left-align">
                            <font size=3>Carrera: &nbsp;<tt><i><b><%=conRep.getNombreCarreraEstudiante(CI_estudiante)%></b></i></tt></font><br/>
                            <font size=3>Ingreso: &nbsp;<tt><i><b><%=conRep.getIngresoEstudiante(CI_estudiante)%></b></i></tt></font><br/>
                            <font size=3>Coordinador Académico: &nbsp;<tt><i><b><%=conRep.getCoordinadorAcademico(CI_estudiante)%></b></i></tt></font>
                            </p>
                        </div>
                        <div class="col s5">
                            <p class="left-align">
                            <font size=3>Semestre: &nbsp;<tt><i><b><%=conRep.getSemestreMateria(CI_estudiante)%></b></i></tt></font><br/>
                            <font size=3>Gestión Academica: &nbsp;<tt><i><b><%=conRep.getGestionActual(CI_estudiante)%></b></i></tt></font><br/>
                            <font size=3>Prácticas: &nbsp;<tt><i><b><%=conRep.getMateriaCursando(CI_estudiante)%></b></i></tt></font>
                            </p>
                        </div>
                    </div>
                    <div class="row">

                        <p>
                            <span style="margin-right: 1cm;"><b>I.</b></span>
                            <b>DATOS GENERALES:</b><br/><br/>
                            <span style="margin-right: 1cm;"></span><span style="margin-right: 0.5cm;">1.</span>Practicante: &nbsp; <tt><i><b><%=conRep.getNombreEstudiante(CI_estudiante)%></b></i></tt><br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.5cm;">2.</span>Periodo de evaluación:<br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.8cm;"></span>Del: &nbsp; <tt><i><b><%=conRep.getPeriodoEvaluacionInicio(CI_estudiante)%></b></i></tt><span style="margin-right: 2cm;"></span>Al: &nbsp; <tt><i><b><%=conRep.getPeriodoEvaluacionFin(CI_estudiante)%></b></i></tt><span style="margin-right: 3cm;"></span>Total Hrs: &nbsp;<tt><i><b><%=conRep.getTotalHoras(CI_estudiante, parcial)%></b></i></tt><br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.5cm;">3.</span>Razon Social de la Empresa / Institución:<br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.8cm;"></span><tt><i><b><%=conRep.getNombreEmpresa(CI_estudiante)%></b></i></tt><br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.8cm;"></span>Dirección: &nbsp; <tt><i><b><%=conRep.getDireccionEmpresa(CI_estudiante)%></b></i></tt><span style="margin-right: 1cm;"></span>Teléfono: &nbsp; <tt><i><b><%=conRep.getTelefonoEmpresa(CI_estudiante)%></b></i></tt><br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.5cm;">4.</span>Tutor / Supervisor de la Empresa / Institución:<br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.8cm;"></span>Nombre: &nbsp; <tt><i><b><%=conRep.getNombreTutor(CI_estudiante)%></b></i></tt><br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.8cm;"></span>Cargo: &nbsp;&nbsp;<tt><i><b><%=conRep.getCargoTutor(CI_estudiante)%></b></i></tt><br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.5cm;">5.</span>Área de Práctica Asignada: &nbsp; <tt><i><b><%=conRep.getAreaPractica(CI_estudiante)%></b></i></tt><br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.5cm;">6.</span>Función: &nbsp;&nbsp;<tt><i><b><%=conRep.getFuncionParcial(CI_estudiante, parcial)%></b></i></tt><br/>
                        <span style="margin-right: 1cm;"></span><span style="margin-right: 0.5cm;">7.</span>Tareas Asignadas:<span style="margin-right: 3cm;"></span><%=conRep.getPeriodo(parcial)%><br/>
                            <%=conRep.getTareasAsignadas(CI_estudiante, parcial)%>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        </p>
                        <p>
                            <span style="margin-right: 1cm;"><b>II.</b></span>
                            <b>INSTRUCCIONES PARA LA EVALUACIÓN:</b><br/><br/>
                            <span style="margin-right: 1cm;"></span><span style="margin-right: 0.5cm;">1.</span>Asignar la calificación de acuerdo a los siguientes parámetros<br/>
                            <span style="margin-right: 3cm;"></span><span style="margin-right: 1cm;">-</span><span style="margin-right: 1cm;">Insuficiente:</span>De 0 a 5 Pts.<br/>
                            <span style="margin-right: 3cm;"></span><span style="margin-right: 1cm;">-</span><span style="margin-right: 1.26cm;">Suficiente:</span>De 6 a 7 Pts.<br/>
                            <span style="margin-right: 3cm;"></span><span style="margin-right: 1cm;">-</span><span style="margin-right: 1.1cm;">Destacado:</span>De 8 a 9 Pts.<br/>
                            <span style="margin-right: 3cm;"></span><span style="margin-right: 1cm;">-</span><span style="margin-right: 1.45cm;">Exelente:</span>10 Pts.<br/>
                        </p>                        
                        <br/>
                        <br/>
                        <br/>
                        <br/>

                    </div>
                    <div class="row">
                        <p>
                            <span style="margin-right: 1cm;"><b>III.</b></span>
                            <b>CRITERIOS PARA LA EVALUACIÓN:</b><br/><br/>
                        </p>
                    </div>
                    <%=conRep.getReporteParcialTutor(CI_estudiante, parcial)%>
                    <div class="row">
                        <p>
                            La nota de prácticas que se asigna al estudiante es la suma de los criterios dividido en dos (A+B+C+D)/2:<br/>
                            TOTAL PUNTAJE:&nbsp; Numeral (<span style="margin-right: 0.5cm;"></span><tt><i><b><%=conRep.getTotalNotaNumeral(CI_estudiante, parcial)%></b></i></tt><span style="margin-right: 0.5cm;"></span>) Literal (<span style="margin-right: 0.5cm;"></span><tt><i><b><%=conRep.getTotalNotaLiteral(CI_estudiante, parcial)%></b></i></tt><span style="margin-right: 0.5cm;"></span>)
                        </p>
                    </div>
                    <div class="row">
                        <div class="col s12 right-align">
                            <p>
                                Lugar y Fecha : Cbba - <%=conRep.getFechaFinPracticas(CI_estudiante) %>
                            </p>
                        </div>
                    </div>
                    <br/><br/>
                    <div class="row">
                        <div class="col s12 right-align">

                            <p>
                                __________________________________________<br/>
                                Firma y Sello del Representante de la Empresa
                            </p>
                        </div>
                    </div>
                </div>
            </main>
        </div>

        <%
        } else {
        %>

        <div class="container">
            <div class="row">
                <div class="col s12 blue-text">
                    <h2 class="center">Aún no ha concluido con la evaluación</h2>
                    <h3 class="center">Finalice primeramente la evaluación y luego regrese para imprimir la evaluación del parcial</h3>
                </div>

            </div>
        </div>

        <%
            }
        %>

    </body>
</html>
