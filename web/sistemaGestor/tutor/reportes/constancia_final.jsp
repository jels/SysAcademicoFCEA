<%-- 
    Document   : constanciaParciales
    Created on : 03/12/2017, 09:32:11 PM
    Author     : WarMachine
--%>

<%@page import="Controller.ControladorReportes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String CI_estudiante = request.getParameter("ci");
%>

<!DOCTYPE html>
<html>
    <% ControladorReportes conRep = new ControladorReportes();%>
    <head>
        <title>hola</title>
        <link rel="stylesheet" href="../../../css/materialize.min.css">
        <script src="../../../js/materialize.min.js"></script>
        <script type="text/javascript" src="../../../js/jquery-3.2.1.min.js"></script>
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
        <div id="imprimeme">
            <main>
                <div style="margin-left: 1cm;">
                    <div class="row">
                        <div class="col s2">
                            <a  href="javascript:imprSelec('imprimeme')"><img class="responsive-img" src="../../../img/fcea/uab.bmp" width="50"></a>
                        </div>
                        <div class="col s8">
                            <br/><br/><br/>
                            <p class="center-align">
                                <u>
                                    <font size=5>
                                    CONSTANCIA <br/>
                                    DE PRACTICA PRE PROFESIONAL
                                    </font><br/>
                                </u>
                            </p>
                        </div>
                        <div class="col s2">
                            <a  href="javascript:imprSelec('imprimeme')"><img class="responsive-img" src="../../../img/fcea/logo-fcea.jpg" width="70"></a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s12 left-align">
                            <p>
                                <font size=4>Por medio de la presente dejo constancia que el Sr. Srta </font>....................................<br/>
                                <font size=5><span style="margin-right: 4cm;"></span><tt><i><b><%=conRep.getNombreEstudiante(CI_estudiante)%></b></i></tt></font><br/>
                            <font size=1>(Nombres y Apellidos del solicitante, tal cual la partida de nacimiento)</font> ,<font size=4> identificado (a) con CI No</font> : <font size=5><tt><i><b><%=CI_estudiante%></b></i></tt></font> , <br/>
                            <font size=4>ha realizado sus Prácticas Pre-Profesionales en nuestra Empresa</font><br/>
                            <font size=5><tt><i><b><%=conRep.getNombreEmpresa(CI_estudiante)%></b></i></tt></font> <font size=4>en el Área de</font> <br/>
                            <font size=5><tt><i><b><%=conRep.getAreaPractica(CI_estudiante)%></b></i></tt></font> <font size=4>realizando las funciones de</font> <br/>
                            <font size=5><tt><i><b><%=conRep.getFuncionParcial(CI_estudiante, 1)%></b></i></tt></font> , <font size=5><tt><i><b><%=conRep.getFuncionParcial(CI_estudiante, 2)%></b></i></tt></font> <br/>
                            <font size=4>desde</font> <font size=5><tt><i><b><%=conRep.getFechaInicioPracticas(CI_estudiante)%></b></i></tt></font>  <font size=4>hasta</font> <font size=5><tt><i><b><%=conRep.getAreaPractica(CI_estudiante)%></b></i></tt></font> , <font size=4>acumulando un total de</font> <tt><i><b><%=conRep.getCantidadTotalHoras(CI_estudiante)%></b></i></tt> <br/>
                            <font size=4>horas de prácticas, habiendo aprobado satisfactoriamente  dando a conocer en todo</font> <br/>
                            <font size=4>momento responsabilidad  y  eficiencia.</font><br/><br/><br/>
                            <font size=4>Expedimos esta certificación de acuerdo al convenio y solicitud de la</font> <br/>
                            <font size=4>Universidad Adventista de Bolivia, referente a las prácticas profesionales.</font><br/>
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s12 left-align">
                            <p>
                                <i><font size=3>Lugar y Fecha: </font> <font size=3> Cbba - <%=conRep.getFechaSistema()%></font></i>
                            </p>
                        </div>
                    </div>
                    <br/><br/>
                    <div class="row">
                        <div class="col s12 center-align">
                            <p>
                                <i><font size=1>Sello empresa</font></i>
                            </p>
                        </div>
                    </div>
                    <br/><br/>
                    <div class="row">
                        <div class="col s12 right-align">
                            <p>
                                _______________________________________<br/>
                                <i><font size=3>Firma y Sello del Representante de la Empresa</font></i>
                            </p>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
