/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;
import java.text.DecimalFormat;

/**
 *
 * @author WarMachine
 */
public class ControladorVarios extends Conexion {

    Estudiante_model estMo = new Estudiante_model();
    Practicas_model praMo = new Practicas_model();
    Tutor_model tutMo = new Tutor_model();
    Carrera_model carMo = new Carrera_model();
    Materia_model maMo = new Materia_model();
    Empresa_model emMo = new Empresa_model();
    Usuario_model usMo = new Usuario_model();
    AsignacionPracticas_model aspMo = new AsignacionPracticas_model();
    Notas_model notMo = new Notas_model();
    DecimalFormat df = new DecimalFormat("#.00");

    String htmlcode = "";
    int numero;
    boolean bandera;

    public String getNombreEstudiante(String CI_estudiante) {
        htmlcode = estMo.getNombreCompleto(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getNombreEstudiante.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public int cantidadEstudiantes() {
        numero = estMo.contar_estudiantes();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadEstudiantes.getCloseConexion: " + e);
        }
        return numero;
    }

    public int getPracticasActivas() {
        numero = aspMo.getCantidadPracticasEstado(1);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getPracticasActivas.getCloseConexion: " + e);
        }
        return numero;
    }

    public int cantidadParciales() {
        numero = praMo.contar_parciales();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadParciales.getCloseConexion: " + e);
        }
        return numero;
    }

    public int cantidadParcialesXestado(int estado) {
        numero = praMo.contar_parciales_estado(estado);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadParcialesXestado.getCloseConexion: " + e);
        }
        return numero;
    }

    public int cantidadTutores() {
        numero = tutMo.contar_tutor();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadTutores.getCloseConexion: " + e);
        }
        return numero;
    }

    public int cantidadCarreras() {
        numero = carMo.contar_carrera(2);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadCarreras.getCloseConexion: " + e);
        }
        return numero;
    }

    public int cantidadMaterias() {
        numero = maMo.countMaterias();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadMaterias.getCloseConexion: " + e);
        }
        return numero;
    }

    public int cantidadEmpresas() {
        numero = emMo.contar_empresa();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadEmpresas.getCloseConexion: " + e);
        }
        return numero;
    }

    public String getBienvenida(String user) {
        htmlcode = "Bienvenid@ Sr/a ";
        htmlcode += tutMo.getNombreTutor(user);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getBienvenida.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String getNombreEmpresa(String user) {
        String nombreEmpresa = emMo.nombre_empresa(user);
        try {
            if (nombreEmpresa.equals("")) {
                htmlcode = "no existe";
            } else {
                htmlcode = nombreEmpresa;
            }
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getNombreEmpresa.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String getUserViewDocente(String user) {
        ResultSet usuario = usMo.getDatosDocente(user);
        htmlcode = "";
        try {
            usuario.next();
            htmlcode = "<div class=\"background\">\n"
                    + "     <img src = \"../../img/fcea/docentes/fondo.jpg\">\n"
                    + "</div>\n"
                    + "<a href =\"#!user\"><img class=\"circle\" src=\"../../img/fcea/docentes/" + usuario.getString(1) + "\"> </a>\n"
                    + "<a href =\"#!name\"><span class=\"yellow-text name\">" + usuario.getString(3) + " " + usuario.getString(4) + " " + usuario.getString(5) + " " + usuario.getString(6) + "</span></a>\n"
                    + "<a href =\"#!email\"><span class=\"yellow-text email\">" + usuario.getString(2) + "</span></a>\n";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getUserViewDocente: " + e);
        }
        return htmlcode;
    }

    public String getUserViewRoot(String user) {
        ResultSet usuario = usMo.getDatosRoot(user);
        htmlcode = "";
        try {
            usuario.next();
            htmlcode = "<div class=\"background\">\n"
                    + "     <img src = \"../../img/root/fondo.jpg\">\n"
                    + "</div>\n"
                    + "<a href =\"#!user\"><img class=\"circle\" src=\"../../img/root/" + usuario.getString(1) + "\"> </a>\n"
                    + "<a href =\"#!name\"><span class=\"yellow-text name\">Root</span></a>\n"
                    + "<a href =\"#!email\"><span class=\"yellow-text email\">root@root.com</span></a>\n";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getUserViewDocente: " + e);
        }
        return htmlcode;
    }

    public String getUserViewTutor(String user) {
        ResultSet usuario = usMo.getDatosTutor(user);
        htmlcode = "";
        try {
            usuario.next();
            htmlcode = "<div class=\"background\">\n"
                    + "     <img src = \"../../img/fcea/tutores/fondo.jpg\">\n"
                    + "</div>\n"
                    + "<a href =\"#!user\"><img class=\"circle\" src=\"../../img/fcea/tutores/" + usuario.getString(1) + "\"> </a>\n"
                    + "<a href =\"#!name\"><span class=\"yellow-text name\">" + usuario.getString(3) + " " + usuario.getString(4) + " " + usuario.getString(5) + " " + usuario.getString(6) + "</span></a>\n"
                    + "<a href =\"#!email\"><span class=\"yellow-text email\">" + usuario.getString(2) + "</span></a>\n";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getUserViewTutor: " + e);
        }
        return htmlcode;
    }

    public String cambiarEstadoParciales() {
        int contador = 0;
        ResultSet parciales = praMo.verParciales();
        htmlcode = "";
        try {
            htmlcode = "           <div class=\"container\">\n"
                    + "                    <div class=\"row\">\n"
                    + "                        <div class=\"col s12\">\n"
                    + "                            <h3 class=\"center\">Evaluaciones</h3>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"row\">\n"
                    + "                        <div class=\"col s3\"></div>\n"
                    + "                        <div class=\"col s6\">\n"
                    + "                            <table class=\"bordered\">\n"
                    + "                                <thead>\n"
                    + "                                    <tr>\n"
                    + "                                        <th>#</th>\n"
                    + "                                        <th>Evaluacion</th>\n"
                    + "                                        <th>Estado</th>\n"
                    + "                                        <th class=\"center\">Cambiar Estado</th>\n"
                    + "                                    </tr>\n"
                    + "                                </thead>\n"
                    + "                                <tbody>\n";
            while (parciales.next()) {
                contador++;
                htmlcode += "                                    <tr>\n"
                        + "                                        <td>" + contador + "</td>\n"
                        + "                                        <td>" + parciales.getString(3) + "</td>\n";
                if (parciales.getInt(2) == 1) {
                    htmlcode += "                                        <td>Activo</td>\n";
                } else {
                    htmlcode += "                                        <td>Inactivo</td>\n";
                }
                htmlcode += "                                        <td><div class=\"center-align\"><a id=\"baja_parcial\" data-id=\"" + parciales.getInt(1) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Dar de Baja\"><i class=\"material-icons yellow-text\">redo</i></a></div></td>\n"
                        + "                                    </tr>\n";
            }
            htmlcode += "                                </tbody>\n"
                    + "                            </table>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("error en cambiarEstadoParciales:" + e);
        }
        System.out.println("htmlcode " + htmlcode);
        return htmlcode;
    }

    public String getDatosEstudiante(String CI_estudiante) {
        ResultSet datos = estMo.getDatosEst(CI_estudiante);
        ResultSet practicasEstudiante = aspMo.getAllPracticasEstudiante(CI_estudiante);
        double notaTotal = 0;
        double notaFinal = 0;
        htmlcode = "";
        try {
            datos.next();
            htmlcode = "<div class=\"container yellow-text\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <br>\n"
                    + "                            <div class=\"col s2\">\n"
                    + "                                <img class=\"responsive-img materialboxed\" src=\"../../img/fcea/estudiantes/" + datos.getString(8) + "\" width=\"200\" alt=\"" + datos.getString(1) + "\" >\n"
                    + "                            </div>\n"
                    + "                            <div class=\"col s10\">\n"
                    + "                                <h2 class=\"center\">" + datos.getString(3) + " " + datos.getString(4) + ", " + datos.getString(1) + " " + datos.getString(2) + "</h2>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s6\">\n"
                    + "                                <h4><i class=\"material-icons yellow-text small\">fingerprint</i>  CI:  " + datos.getString(5) + "</h4>\n"
                    + "                            </div>\n"
                    + "                            <div class=\"col s6\">\n"
                    + "                                <h4><i class=\"material-icons yellow-text small\">contacts</i>  Telefono: " + datos.getString(6) + "</h4>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s6\">\n";
            if (datos.getInt(7) == 1) {
                htmlcode += "                                <h4>Estado:  <span class=\"green-text\">Activo</span>  <i class=\"material-icons green-text small\">sentiment_very_satisfied</i></h4>\n";
            } else {
                htmlcode += "                                <h4>Estado:  <span class=\"red-text\">Inactivo</span>  <i class=\"material-icons red-text small\">sentiment_very_dissatisfied</i></h4>\n";
            }
            if (aspMo.getRealizoPracticas(CI_estudiante)) {
                htmlcode += "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"row\">\n"
                        + "                            <div class=\"col s12\">\n"
                        + "                                 <table class=\"bordered responsive-table\">\n"
                        + "                                     <thead>\n"
                        + "                                         <tr>\n"
                        + "                                             <th>Materia</th>\n"
                        + "                                             <th>Primer Parcial</th>\n"
                        + "                                             <th>Segundo Parcial</th>\n"
                        + "                                             <th>Examen Final</th>\n"
                        + "                                             <th>Nota Total</th>\n"
                        + "                                         </tr>\n"
                        + "                                     </thead>\n"
                        + "                                     <tbody>\n";
                while (practicasEstudiante.next()) {
                    htmlcode += "                         <tr>\n"
                            + "                                <td>" + practicasEstudiante.getString(1) + "</td>\n";
                    int c = 0;
                    double notaParcial = 0;
                    while (c <= 3) {
                        c++;
                        switch (c) {
                            case 1:
                                notaParcial = (notMo.getNotaByPracticas(CI_estudiante, c, practicasEstudiante.getInt(2)) / 2) * 0.35;
                                htmlcode += "                                <td>" + df.format(notaParcial) + "</td>\n";
                                notaTotal = notaTotal + notaParcial;
                                break;
                            case 2:
                                notaParcial = (notMo.getNotaByPracticas(CI_estudiante, c, practicasEstudiante.getInt(2)) / 2) * 0.35;
                                htmlcode += "                                <td>" + df.format(notaParcial) + "</td>\n";
                                notaTotal = notaTotal + notaParcial;
                                break;
                            case 3:
                                notaParcial = (notMo.getNotaByPracticas(CI_estudiante, c, practicasEstudiante.getInt(2)) / 2) * 0.30;
                                htmlcode += "                                <td>" + df.format(notaParcial) + "</td>\n";
                                notaTotal = notaTotal + notaParcial;
                                break;
                            default:
                                break;
                        }
                    }
                    htmlcode += "                                <td>" + df.format(notaTotal) + "</td>\n"
                            + "                            </tr>\n";
                    notaTotal = 0;
                    notaParcial = 0;
                }
                htmlcode += "                         </tbody>\n"
                        + "                    </table>\n"
                        + "                            </div>\n"
                        + "                        </div>\n";
                if (notMo.evaluacionCompletaDocente(CI_estudiante)) {
                    htmlcode += "                   <div class=\"row\">\n"
                            + "                            <div class=\"col s12\">\n"
                            + "                                <h3 class=\"center\">Opciones de Final de Semestre</h3>\n"
                            + "                            </div>\n";
                    notaFinal = (((notMo.getNotaPrimerParcial(CI_estudiante) / 2) * 0.35) + ((notMo.getNotaSegundoParcial(CI_estudiante) / 2) * 0.35) + ((notMo.getNotaExamenFinal(CI_estudiante) / 2) * 0.3));
                    if (notaFinal >= 50.5) {
                        htmlcode += "                            <div class=\"col s6 center\">\n"
                                + "                                <h4 class=\"center\">Aprobar</h4>\n"
                                + "                                <a id=\"aprobar_estudiante\" data-id=\"" + CI_estudiante + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Aprobar\"><i class=\"material-icons yellow-text\">visibility</i></a>\n"
                                + "                            </div>\n";
                    } else {
                        htmlcode += "                            <div class=\"col s6 center\">\n"
                                + "                                <h4 class=\"center\">Reprobar</h4>\n"
                                + "                                <a id=\"reprobar_estudiante\" data-id=\"" + CI_estudiante + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Reprobar\"><i class=\"material-icons yellow-text\">visibility</i></a>\n"
                                + "                            </div>\n";
                    }

                    htmlcode += "                            <div class=\"col s6 center\">\n"
                            + "                                <h4 class=\"center\">Finalizar?</h4>\n"
                            + "                                <a id=\"finalizar_evaluacion_estudiante\" data-id=\"" + CI_estudiante + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Finalizar - Archivar\"><i class=\"material-icons yellow-text\">visibility</i></a>\n"
                            + "                            </div>\n"
                            + "                        </div>";
                }
                htmlcode += "                    </div>\n";
            } else {
                htmlcode += "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"row\">\n";
                if (estMo.getEstadoEst(CI_estudiante) == 1) {
                    htmlcode += "                            <div class=\"col s12 center-align\">\n"
                            + "                                 <a href=\"asignar_practica.jsp?ci=" + CI_estudiante + "\" id=\"asignar_practica\" class=\"waves-effect waves-light waves-teal yellow accent-2 blue-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Asignar Practica\"><i class=\"material-icons left\">clear_all</i>Asignar Practica</a>\n"
                            + "                                 <br/> <br/> <br/> <br/>\n"
                            + "                            </div>\n"
                            + "                        </div>\n"
                            + "                    </div>\n";
                } else {
                    htmlcode += "                      </div>\n"
                            + "                   </div>\n";
                }

            }
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getNombreEstudiante: " + e);
        }
        return htmlcode;
    }

    public String getDatosEstudianteTutor(String CI_estudiante) {
        ResultSet datos = estMo.getDatosEst(CI_estudiante);
        ResultSet practicasEstudiante = aspMo.getPracticasEstudiante(CI_estudiante);
        double notaTotal = 0;
        htmlcode = "";
        try {
            datos.next();
            htmlcode = "<div class=\"container yellow-text\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <br>\n"
                    + "                            <div class=\"col s2\">\n"
                    + "                                <img class=\"responsive-img materialboxed\" src=\"../../img/fcea/estudiantes/" + datos.getString(8) + "\" width=\"200\" alt=\"" + datos.getString(1) + "\" >\n"
                    + "                            </div>\n"
                    + "                            <div class=\"col s10\">\n"
                    + "                                <h2 class=\"center\">" + datos.getString(3) + " " + datos.getString(4) + ", " + datos.getString(1) + " " + datos.getString(2) + "</h2>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s6\">\n"
                    + "                                <h4><i class=\"material-icons yellow-text small\">fingerprint</i>  CI:  " + datos.getString(5) + "</h4>\n"
                    + "                            </div>\n"
                    + "                            <div class=\"col s6\">\n"
                    + "                                <h4><i class=\"material-icons yellow-text small\">contacts</i>  Teléfono: " + datos.getString(6) + "</h4>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s6\">\n";
            if (datos.getInt(7) == 1) {
                htmlcode += "                                <h4>Estado:  <span class=\"green-text\">Activo</span>  <i class=\"material-icons green-text small\">sentiment_very_satisfied</i></h4>\n";
            } else {
                htmlcode += "                                <h4>Estado:  <span class=\"red-text\">Inactivo</span>  <i class=\"material-icons red-text small\">sentiment_very_dissatisfied</i></h4>\n";
            }
            htmlcode += "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s12\">\n"
                    + "                                 <table class=\"bordered responsive-table\">\n"
                    + "                                     <thead>\n"
                    + "                                         <tr>\n"
                    + "                                             <th>Materia</th>\n"
                    + "                                             <th>Primer Parcial</th>\n"
                    + "                                             <th>Segundo Parcial</th>\n"
                    + "                                         </tr>\n"
                    + "                                     </thead>\n"
                    + "                                     <tbody>\n";
            while (practicasEstudiante.next()) {
                htmlcode += "                         <tr>\n"
                        + "                                <td>" + practicasEstudiante.getString(1) + "</td>\n";
                int c = 0;
                int notaParcial = 0;
                while (c <= 3) {
                    c++;
                    switch (c) {
                        case 1:
                            notaParcial = (notMo.getNotaByPracticas(CI_estudiante, c, practicasEstudiante.getInt(2)));
                            System.out.println("nota sin redondeo:_ " + notaParcial);
                            htmlcode += "                                <td>" + notaParcial + "</td>\n";
                            notaTotal = notaTotal + notaParcial;
                            break;
                        case 2:
                            notaParcial = (notMo.getNotaByPracticas(CI_estudiante, c, practicasEstudiante.getInt(2)));
                            htmlcode += "                                <td>" + notaParcial + "</td>\n";
                            notaTotal = notaTotal + notaParcial;
                            break;
                        default:
                            break;
                    }
                }
                htmlcode += "                            </tr>\n";
                notaTotal = 0;
                notaParcial = 0;
            }
            htmlcode += "                         </tbody>\n"
                    + "                    </table>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </div>\n";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getNombreEstudiante: " + e);
        }
        System.out.println("" + htmlcode);
        return htmlcode;
    }

    public String getDatosTutor(String usuario) {
        htmlcode = "";
        ResultSet user = usMo.getDatosUsuario(usuario);
        try {
            user.next();
            htmlcode += "         <div class=\"modal-content blue darken-3\">\n"
                    + "                    <div class=\"row\">\n"
                    + "                        <div class=\"col s3\">\n"
                    + "                            <br>\n"
                    + "                            <img class=\"responsive-img materialboxed\" src=\"../../img/fcea/tutores/" + user.getString(3) + "\">\n"
                    + "                        </div>\n"
                    + "                        <div class=\"col s9\">\n"
                    + "                            <h4 class=\"center\">" + user.getString(6) + " " + user.getString(7) + ", " + user.getString(4) + " " + user.getString(5) + "</h4>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"row\">\n"
                    + "                        <div class=\"col s12\">\n"
                    + "                            <form class=\"col s12 yellow-text\" >\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix\">perm_identity</i>\n"
                    + "                                        <input id=\"usuario\" name=\"usuario\" class=\"yellow-text\" disabled value=\"" + user.getString(1) + "\" type=\"text\">\n"
                    + "                                        <label for=\"usuario\">Usuario</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix\">lock_outline</i>\n"
                    + "                                        <input id=\"pass\" name=\"pass\" value=\"" + user.getString(2) + "\" type=\"text\">\n"
                    + "                                        <label for=\"pass\">Contraseña</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </form>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "\n"
                    + "                <div class=\"modal-footer blue darken-3 yellow-text\">\n"
                    + "                    <div class=\"col s6\">\n"
                    + "                        <a id=\"actualizarUsuarioT\" data-id=\"\" class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\">\n"
                    + "                            Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                    + "                        </a>\n"
                    + "                    </div>\n"
                    + "                    <div id=\"notificacionACTutor\">\n"
                    + "                    </div>\n"
                    + "                </div>";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getDatosTutor.getCloseConexion: " + e);
        }
        return htmlcode;
    }

}
