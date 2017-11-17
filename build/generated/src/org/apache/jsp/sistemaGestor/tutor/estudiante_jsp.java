package org.apache.jsp.sistemaGestor.tutor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Controller.ControladorMateria;
import Controller.ControladorVarios;
import Controller.ControladorEstudiante;

public final class estudiante_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/sistemaGestor/tutor/head.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("usuario");
    String rol = (String) objsession.getAttribute("rol");
    if (objsession.equals(false) || usuario == null) {
        //esta linea es la que ayuda a que no salga el error de null...
        session.invalidate();
        response.sendRedirect("../../index.jsp");

    } else if (rol.equals("Docente")) {
        response.sendRedirect("../docente/menu.jsp");
    } else if (rol.equals("Tutor")) {

    } else {
        response.sendRedirect("../../index.jsp");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    ");
 ControladorEstudiante conEst = new ControladorEstudiante();
      out.write("\n");
      out.write("    ");
 ControladorVarios conVar = new ControladorVarios();
      out.write("\n");
      out.write("    ");
 ControladorMateria conMat = new ControladorMateria();
      out.write("\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"msapplication-tap-highlight\" content=\"no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"keywords\" content=\"\">\n");
      out.write("    <title>Sistema Gestor de Practicas - FCEA</title>\n");
      out.write("    <!-- Favicons-->\n");
      out.write("    <link rel=\"icon\" href=\"../../img/logos/fcea.jpg\" sizes=\"32x32\">\n");
      out.write("    <!-- CORE CSS-->\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../css/normalize.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../css/materialize.min.css\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Raleway\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body class=\"yellow accent-2\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <header>\n");
      out.write("            <!-- Inicio HEADER -->\n");
      out.write("            <div class=\"fixed-action-btn vertical click-to-toggle\">\n");
      out.write("                <a href=\"#\" class=\"btn tooltipped button-collapse btn-floating btn-large blue darken-4 pulse\" data-activates=\"slide-out\" data-position=\"left\" data-tooltip=\"Menu\">\n");
      out.write("                    <i class=\"material-icons yellow-text\">apps</i>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"navbar-fixed\">\n");
      out.write("                <nav class=\"blue darken-3\">\n");
      out.write("                    <div class=\"nav-wrapper\">\n");
      out.write("                        <a href=\"#\" class=\"brand-logo center yellow-text hide-on-med-and-down\">Sistema Gestor de Practicas</a>\n");
      out.write("                        <ul id=\"nav-mobile\" class=\"right\">\n");
      out.write("                            <li><a href=\"#\" class=\"tooltipped\" data-position=\"button\" data-tooltip=\"Ayuda\"><i class=\"material-icons yellow-text\">help</i></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"tooltipped\" data-position=\"button\" data-tooltip=\"Foro\"><i class=\"material-icons yellow-text\">forum</i></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"tooltipped\" data-position=\"button\" data-tooltip=\"Mi Cuenta\"><i class=\"material-icons yellow-text\">account_circle</i></a></li>\n");
      out.write("                            <li><a href=\"../../web-fcea/index.jsp\" class=\"tooltipped\" data-position=\"button\" data-tooltip=\"Salir\"><i class=\"material-icons yellow-text\">directions_run</i></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"nav-content\">\n");
      out.write("                            <div class=\"col s12\">\n");
      out.write("                                <ul class=\"tabs  blue darken-3 tabs-fixed-width\">\n");
      out.write("                                    <li class=\"tab col s3\"><a class=\"yellow-text\" href=\"#cantidad\">Resumen</a></li>\n");
      out.write("                                    <li class=\"tab col s3\"><a class=\"yellow-text\" href=\"#show\">Mostrar</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <!-- Final HEADER -->\n");
      out.write("        <main>\n");
      out.write("            <!-- Inicio NAV -->\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col s12 m9 l10\">\n");
      out.write("                        <div id=\"structure\" class=\"section scrollspy\">\n");
      out.write("                            <ul id=\"slide-out\" class=\"side-nav blue darken-3\" style=\"width: 240px\">\n");
      out.write("                                <li>\n");
      out.write("                                    <div class=\"user-view\">\n");
      out.write("                                        ");
      out.print(conVar.getUserViewTutor(usuario));
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"../../index.jsp\" class=\"waves-effect yellow-text\">\n");
      out.write("                                        <i class=\"material-icons yellow-text\">home</i>Sitio Web\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"menu.jsp\" class=\"waves-effect yellow-text\">\n");
      out.write("                                        <i class=\"material-icons yellow-text\">dashboard</i>Inicio\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"estudiante.jsp\" class=\"waves-effect yellow-text\">\n");
      out.write("                                        <i class=\"material-icons yellow-text\">face</i>Estudiante\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"ayuda.jsp\" class=\"waves-effect yellow-text\">\n");
      out.write("                                        <i class=\"material-icons yellow-text\">help</i>Ayuda\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Fin NAV -->\n");
      out.write("\n");
      out.write("            <div class=\"row blue darken-3\">\n");
      out.write("                <div id=\"cantidad\" class=\"col s12\">                    \n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h1 class=\"center yellow-text\">Estudiantes</h1>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col s12\">\n");
      out.write("                                <h2 class=\"center yellow-text\">");
      out.print(conEst.cantidadEstudiantes_tutor(usuario));
      out.write("</h2>\n");
      out.write("                                <h3 class=\"center yellow-text\">Registrados en La Empresa ");
      out.print(conVar.getNombreEmpresa(usuario));
      out.write("</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col s4\">\n");
      out.write("                                <h2 class=\"center yellow-text\">1</h2>\n");
      out.write("                                <h5 class=\"center yellow-text\">Evaluados Primer Parcial</h5>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col s4\">\n");
      out.write("                                <h2 class=\"center yellow-text\">1</h2>\n");
      out.write("                                <h5 class=\"center yellow-text\">Evaluados Segundo Parcial</h5>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col s4\">\n");
      out.write("                                <h2 class=\"center yellow-text\">1</h2>\n");
      out.write("                                <h5 class=\"center yellow-text\">Faltan Evaluar</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"show\">\n");
      out.write("                    ");
      out.print(conEst.verEstudiantesXTutor(usuario));
      out.write("\n");
      out.write("\n");
      out.write("                    <!-- Inicio del Modal search -->\n");
      out.write("                    <div id=\"search\" class=\"modal modal-fixed-footer blue darken-3 yellow-text\">\n");
      out.write("                        <div class=\"modal-content blue darken-3\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <h1 class=\"center yellow-text\">Buscar Estudiante</h1>\n");
      out.write("                                <form method=\"post\" class=\"col s12 yellow-text\" >\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"input-field col s4\">\n");
      out.write("                                            <i class=\"material-icons prefix\">account_circle</i>\n");
      out.write("                                            <input id=\"apellido_estudiante\" type=\"text\">\n");
      out.write("                                            <label for=\"apellido_estudiante\">Apellido Paterno</label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"input-field col s4\">\n");
      out.write("                                            <i class=\"material-icons prefix\">contact_mail</i>\n");
      out.write("                                            <input id=\"ci_estudiante\" type=\"text\">\n");
      out.write("                                            <label for=\"ci_estudiante\"># de Carnet</label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"input-field col s4\">\n");
      out.write("                                            <a id=\"buscar_estudiante\" data-id=\"");
      out.print(usuario);
      out.write("\" class=\"waves-effect waves-light waves-teal yellow accent-2 blue-text text-darken-3 btn-large\"> \n");
      out.write("                                                <i class=\"material-icons right\">search</i>Buscar\n");
      out.write("                                            </a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div id=\"ver_estudiante_buscado\"></div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"modal-footer blue darken-3 yellow-text\">\n");
      out.write("                            <button class=\"modal-action modal-close waves-effect waves-teal yellow accent-2 blue-text text-darken-3 waves-yellow btn-flat\">\n");
      out.write("                                Cerrar<i class=\"material-icons right\">clear_all</i>\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Final del Modal --> \n");
      out.write("\n");
      out.write("                    <!-- Inicio del Modal Asignar Notas -->\n");
      out.write("                    <div id=\"verNotaAsignada\" class=\"modal modal-fixed-footer blue darken-3 yellow-text\">\n");
      out.write("\n");
      out.write("                        <div id=\"ver_Nota_Asignada_estudiante\"></div> \n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Final del Modal --> \n");
      out.write("\n");
      out.write("                    <!-- Inicio del Modal Asignar Notas -->\n");
      out.write("                    <div id=\"verReporte\" class=\"modal modal-fixed-footer blue darken-3 yellow-text\">\n");
      out.write("\n");
      out.write("                        <div id=\"ver_Nota_Asignada_estudiante\"></div> \n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Final del Modal --> \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </main>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- //////////////////////////////////////////////////////////////////////////// -->\n");
      out.write("        <!-- START FOOTER -->\n");
      out.write("        <footer class=\"page-footer blue darken-3\">\n");
      out.write("            <div class=\"footer-copyright\">\n");
      out.write("                <div class=\"container orange-text text-lighten-4\">\n");
      out.write("                    © 2017 Copyright\n");
      out.write("                    <a class=\"orange-text text-lighten-4 right\" href=\"#\">LynxLion.net</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        <!-- END FOOTER -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- ================================================\n");
      out.write("        Scripts\n");
      out.write("        ================================================ -->\n");
      out.write("        <script type=\"text/javascript\" src=\"../../js/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"../../js/materialize.min.js\"></script>\n");
      out.write("        <script src=\"../../js/tutor.js\"></script>\n");
      out.write("        <script src=\"../../../js/tutor.js\"></script>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('.slider').slider();\n");
      out.write("                $('.button-collapse').sideNav();\n");
      out.write("                $('.materialboxed').materialbox();\n");
      out.write("                $('.modal').modal();\n");
      out.write("                $('.tooltipped').tooltip({delay: 50});\n");
      out.write("                $('.collapsible').collapsible();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
