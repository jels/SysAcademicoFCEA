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

    public int cantidadEstudiantes() {
        Estudiante_model estMo = new Estudiante_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadEstudiantes.getCloseConexion: " + e);
        }
        return estMo.contar_estudiantes();
    }

    public int cantidadParciales() {
        Practicas_model pra = new Practicas_model();
        int cantidad = pra.contar_parciales();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadParciales.getCloseConexion: " + e);
        }
        return cantidad;
    }

    public int cantidadParcialesXestado(int estado) {
        Practicas_model pra = new Practicas_model();
        int cantidad = pra.contar_parciales_estado(estado);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadParcialesXestado.getCloseConexion: " + e);
        }
        return cantidad;
    }

    public int cantidadTutores() {
        Tutor_model tut = new Tutor_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadTutores.getCloseConexion: " + e);
        }
        return tut.contar_tutor();
    }

    public int cantidadCarreras() {
        Carrera_model carr = new Carrera_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadCarreras.getCloseConexion: " + e);
        }
        return carr.contar_carrera(2);
    }

    public int cantidadMaterias() {
        Materia_model mamo = new Materia_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadMaterias.getCloseConexion: " + e);
        }
        return mamo.countMaterias();
    }

    public int cantidadEmpresas() {
        Empresa_model empr = new Empresa_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadEmpresas.getCloseConexion: " + e);
        }
        return empr.contar_empresa();
    }

    public String getBienvenida(String user) {
        String htmlcode = "Bienvenid@ Sr/a ";
        Tutor_model tutmo = new Tutor_model();
        htmlcode += tutmo.getNombreTutor(user);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getBienvenida.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String getNombreEmpresa(String user) {
        String htmlcode;
        Empresa_model emp = new Empresa_model();
        String nombreEmpresa = emp.nombre_empresa(user);
        if (nombreEmpresa.equals("")) {
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en getNombreEmpresa.getCloseConexion: " + e);
            }
            return "no existe";
        } else {
            htmlcode = nombreEmpresa;
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en getNombreEmpresa.getCloseConexion: " + e);
            }
            return htmlcode;
        }

    }

    public String getUserViewDocente(String user) {
        String htmlcode = "";
        Usuario_model usm = new Usuario_model();
        ResultSet usuario = null;
        usuario = usm.getDatosDocente(user);
        System.out.println("user: " + user);
        try {
            usuario.next();
            htmlcode += "<div class=\"background\">\n"
                    + "     <img src = \"../../img/fcea/docentes/" + usuario.getString(2) + "\">\n"
                    + "</div>\n"
                    + "<a href =\"#!user\"><img class=\"circle\" src=\"../../img/fcea/docentes/" + usuario.getString(1) + "\"> </a>\n"
                    + "<a href =\"#!name\"><span class=\"yellow-text name\">" + usuario.getString(4) + " " + usuario.getString(5) + " " + usuario.getString(6) + " " + usuario.getString(7) + "</span></a>\n"
                    + "<a href =\"#!email\"><span class=\"yellow-text email\">" + usuario.getString(3) + "</span></a>\n";

        } catch (Exception e) {
            System.out.println("Error en getUserViewDocente: " + e);

        }
        System.out.println("htmlcode:------");
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getUserViewDocente.getCloseConexion: " + e);
        }
        return htmlcode;

    }

    public String getUserViewRoot(String user) {
        String htmlcode = "";
        Usuario_model usm = new Usuario_model();
        ResultSet usuario = null;
        usuario = usm.getDatosRoot(user);
        System.out.println("user: " + user);
        try {
            usuario.next();
            htmlcode += "<div class=\"background\">\n"
                    + "     <img src = \"../../img/root/" + usuario.getString(2) + "\">\n"
                    + "</div>\n"
                    + "<a href =\"#!user\"><img class=\"circle\" src=\"../../img/root/" + usuario.getString(1) + "\"> </a>\n"
                    + "<a href =\"#!name\"><span class=\"yellow-text name\">Root</span></a>\n"
                    + "<a href =\"#!email\"><span class=\"yellow-text email\">root@root.com</span></a>\n";

        } catch (Exception e) {
            System.out.println("Error en getUserViewDocente: " + e);

        }
        System.out.println("htmlcode:------");
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getUserViewRoot.getCloseConexion: " + e);
        }
        return htmlcode;

    }

    public String getUserViewTutor(String user) {
        String htmlcode = "";
        Usuario_model usm = new Usuario_model();
        ResultSet usuario = null;
        usuario = usm.getDatosTutor(user);
        System.out.println("user: " + user);
        try {
            usuario.next();
            htmlcode += "<div class=\"background\">\n"
                    + "     <img src = \"../../img/fcea/tutores/" + usuario.getString(2) + "\">\n"
                    + "</div>\n"
                    + "<a href =\"#!user\"><img class=\"circle\" src=\"../../img/fcea/tutores/" + usuario.getString(1) + "\"> </a>\n"
                    + "<a href =\"#!name\"><span class=\"yellow-text name\">" + usuario.getString(4) + " " + usuario.getString(5) + " " + usuario.getString(6) + " " + usuario.getString(7) + "</span></a>\n"
                    + "<a href =\"#!email\"><span class=\"yellow-text email\">" + usuario.getString(3) + "</span></a>\n";

        } catch (Exception e) {
            System.out.println("Error en getUserViewTutor: " + e);

        }
        System.out.println("htmlcode:------");
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getUserViewTutor.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String cambiarEstadoParciales() {
        String htmlcode = "";
        int contador = 0;
        Practicas_model praMo = new Practicas_model();
        ResultSet parciales = praMo.verParciales();

        try {

            htmlcode += "           <div class=\"container\">\n"
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
                    + "\n"
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

        } catch (Exception e) {
            System.out.println("error en cambiarEstadoParciales:" + e);
        }

        return htmlcode;
    }

    public String getDatosEstudiante(String CI_estudiante) {

        String htmlcode = "";
        DecimalFormat df = new DecimalFormat("#.00");

        Estudiante_model estMo = new Estudiante_model();
        ResultSet datos = null;
        datos = estMo.getDatosEst(CI_estudiante);
        AsignacionPracticas_model aspMo = new AsignacionPracticas_model();
        ResultSet practicasEstudiante;
        double notaTotal = 0;
        practicasEstudiante = aspMo.getAllPracticasEstudiante(CI_estudiante);
        Notas_model notMo = new Notas_model();

        try {
            datos.next();
            htmlcode += "<div class=\"container yellow-text\">\n"
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
                                System.out.println("nota sin redondeo:_ " + notaParcial);
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
                        + "                        </div>\n"
                        + "                    </div>\n";
            } else {
                htmlcode += "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"row\">\n"
                        + "                            <div class=\"col s12 center-align\">\n"
                        + "        <a href=\"asignar_practica.jsp?ci=" + CI_estudiante + "\" id=\"asignar_practica\" class=\"waves-effect waves-light waves-teal yellow accent-2 blue-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Asignar Practica\"><i class=\"material-icons left\">clear_all</i>Asignar Practica</a>\n"
                        + "         <br>\n"
                        + "         <br>\n"
                        + "         <br>\n"
                        + "         <br>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>\n";

            }

        } catch (Exception e) {
            System.out.println("Error en getNombreEstudiante: " + e);
        }

        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getDatosEstudiante.getCloseConexion: " + e);
        }
        System.out.println("htmlcode datos estudiantes: " + htmlcode);

        return htmlcode;
    }

    public String getDatosEstudianteTutor(String CI_estudiante) {

        String htmlcode = "";
        Estudiante_model estMo = new Estudiante_model();
        ResultSet datos = null;
        datos = estMo.getDatosEst(CI_estudiante);
        AsignacionPracticas_model aspMo = new AsignacionPracticas_model();
        ResultSet practicasEstudiante;
        double notaTotal = 0;
        practicasEstudiante = aspMo.getPracticasEstudiante(CI_estudiante);
        Notas_model notMo = new Notas_model();

        try {
            datos.next();
            htmlcode += "<div class=\"container yellow-text\">\n"
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

        } catch (Exception e) {
            System.out.println("Error en getNombreEstudiante: " + e);
        }

        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getDatosEstudiante.getCloseConexion: " + e);
        }
        return htmlcode;
    }

}
