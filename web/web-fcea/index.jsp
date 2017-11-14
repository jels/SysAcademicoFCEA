<%-- 
    Document   : index
    Created on : 17/09/2017, 04:08:25 PM
    Author     : WarMachine
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%
    session.invalidate();
%>
<!DOCTYPE html>
<html>

    <%@include file="head.jsp" %>

    <body class="yellow accent-2">
        <header>
            <div class="fixed-action-btn vertical click-to-toggle">
                <a class="btn-floating btn-large black pulse">
                    <i class="material-icons ">menu</i>
                </a>
                <ul>
                    <li><a href="../sistemaGestor/login.jsp" class="btn-floating btn tooltipped orange" data-position="left" data-delay="50" data-tooltip="Login"><i class="material-icons">lock</i></a></li>
                    <li><a href="index.jsp" class="btn-floating btn tooltipped grey" data-position="left" data-delay="50" data-tooltip="Inicio"><i class="material-icons">dashboard</i></a></li>
                    <li><a href="#" class="btn-floating btn tooltipped red" data-position="left" data-delay="50" data-tooltip="Noticias"><i class="material-icons">list</i></a></li>
                    <li><a href="#" class="btn-floating btn tooltipped light-green" data-position="left" data-delay="50" data-tooltip="Testimonios"><i class="material-icons">comment</i></a></li>
                    <li><a href="#" class="btn-floating btn tooltipped deep-purple" data-position="left" data-delay="50" data-tooltip="Multimedia"><i class="material-icons">perm_media</i></a></li>
                    <li><a href="#" class="btn-floating btn tooltipped blue-grey" data-position="left" data-delay="50" data-tooltip="Carreras"><i class="material-icons">info</i></a></li>
                    <li><a href="#" class="btn-floating btn tooltipped blue-grey" data-position="left" data-delay="50" data-tooltip="Contactos"><i class="material-icons">perm_identity</i></a></li>
                </ul>
            </div>

            <div class="navbar">

                <nav class="blue darken-3">
                    <div class="nav-wrapper">
                        <a href="#" class="brand-logo center yellow-text hide-on-med-and-down">Bienvenidos a FCEA</a>
                        <ul id="nav-mobile" class="right">
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Ayuda"><i class="material-icons yellow-text">help</i></a></li>
                            <li><a href="#" class="tooltipped" data-position="button" data-tooltip="Foro"><i class="material-icons yellow-text">forum</i></a></li>
                            <li><a href="../sistemaGestor/login.jsp" class="tooltipped" data-position="button" data-tooltip="Login"><i class="material-icons yellow-text">lock</i></a></li>
                        </ul>
                    </div>
                </nav>

            </div>
        </header>
        <div class="section">
            <div class="row">
                <div class="col s12">
                    <div class="slider">
                        <ul class="slides">
                            <li>
                                <img src="../img/fcea/fcea.jpg" class="responsive-img">
                            </li>
                            <li>
                                <img src="../img/fcea/fcea3.jpg" class="responsive-img">
                            </li>
                            <li>
                                <img src="../img/fcea/fcea2.png" class="responsive-img">
                            </li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
        
        <div class="section">
            <div class="row">
                <div class="col s12">
        
                </div>
            </div>
        </div>
        
        
        <%@include file="foother.jsp" %>
    </body>


</html>