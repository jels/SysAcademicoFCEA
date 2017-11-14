<%-- 
    Document   : foother
    Created on : 23/08/2017, 05:07:13 PM
    Author     : WarMachine
--%>


<footer class="page-footer blue darken-3 yellow-text">
    <div class="container"  id="contactos">
        <div class="row">
            <div class="col l5 s12">
                <h5 class="white-text">Facultad de Ciencias Economicas y Administrativas</h5>
                <p class="grey-text text-lighten-4"></p>
            </div>
            <div class="col l4 s12">
                <h5 class="white-text">Enlaces</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="#">Testimonios</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Noticias</a></li>
                </ul>
            </div>
            <div class="col l3 s12 center-align">
                <h5 class="white-text">Contactenos</h5>
                <form data-form-output="form-output-global" data-form-type="subscribe" method="post" action="#" class="rd-mailform form-classic form-inline offset-top-15 center-align" novalidate="novalidate">
                    <div class="form-group has-error center-align">
                        <input id="contact-email" type="email" name="email" data-constraints="@Email @Required" class="form-control form-control-has-validation"><span class="form-validation">Ingresa tu E-Mail</span>
                    </div>
                    <button class="btn waves-effect waves-light green darken-4" type="submit" name="action">Enviar</button>
                </form>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container orange-text text-lighten-4">
            © 2017 Copyright
            <a class="orange-text text-lighten-4 right" href="#">LynxLion.net</a>
        </div>
    </div>
</footer>





<!--  Scripts-->
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/materialize.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.slider').slider();
        $(".button-collapse").sideNav();
        $('.materialboxed').materialbox();
        $('.modal').modal();
        $('.tooltipped').tooltip({delay: 50});
    });
</script>