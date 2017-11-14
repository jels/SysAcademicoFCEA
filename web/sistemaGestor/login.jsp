<%-- 
    Document   : login
    Created on : 23/08/2017, 05:04:36 PM
    Author     : WarMachine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="msapplication-tap-highlight" content="no">
        <meta name="description" content="">
        <meta name="keywords" content="">
        <title>Iniciar Sesión</title>

        <link href="../css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection">
        <link href="../css/style.css" type="text/css" rel="stylesheet" media="screen,projection">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    </head>

    <body class="cyan loaded">
        <!-- Start Page Loading -->
        <div id="loader-wrapper">
            <div id="loader"></div>        
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>
        </div>
        <!-- End Page Loading -->



        <div id="login-page" class="row">
            <br><br>
            <div class="col s12 z-depth-4 card-panel">
                <form action="login.do" class="login-form">
                    <div class="row">
                        <div class="input-field col s12 center">
                            <img src="../img/login.png" alt="" class="circle responsive-img valign profile-image-login">
                        </div>
                    </div>
                    <div id="login"></div>
                    <div class="row margin">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">perm_identity</i>
                            <input id="username" type="text" class="validate">
                            <label for="username" >Username</label>
                        </div>
                    </div>
                    <div class="row margin">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">lock_outline</i>
                            <input id="password" type="password"  class="validate">
                            <label for="password">Password</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input type="button" id="enviardatos" value="Iniciar Sesion" class="btn waves-effect waves-light col s12"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <p class="margin right-align medium-small"><a href="#">Olvidaste Tu Contraceña?</a></p>
                        </div>          
                    </div>
                </form>
            </div>
        </div>




        <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="../js/materialize.min.js"></script>
        <script type="text/javascript" src="../js/login.js"></script>

    </body>

</html>