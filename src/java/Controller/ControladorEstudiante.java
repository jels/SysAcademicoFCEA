/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WarMachine
 */
public class ControladorEstudiante extends Conexion {

    Estudiante_model estMo = new Estudiante_model();
    Notas_model notMo = new Notas_model();
    ControladorUsuarios conUs = new ControladorUsuarios();
    Estudiante_model estmo = new Estudiante_model();
    AsignacionPracticas_model aspMo = new AsignacionPracticas_model();

    int numero;
    boolean bandera;
    String htmlcode = "";

    public int cantidadEstudiantes() {
        numero = estMo.contar_estudiantes();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadEstudiantes.getCloseConexion: " + e);
        }
        return numero;
    }

    public int cantidadEstudiantes_tutor(String tutor) {
        numero = estMo.contar_estudiantes_tutor(tutor);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadEstudiantes_tutor.getCloseConexion: " + e);
        }
        return numero;
    }

    public boolean newEstudiante(Estudiante est) {
        try {
            if (!estMo.existenciaEstudiante(est)) {
                getCloseConexion();
                bandera = estMo.crear_estudiante(est);
                getCloseConexion();
            } else {
                getCloseConexion();
                bandera = false;
            }
        } catch (Exception e) {
            System.out.println("Error en newEstudiante.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean eliminarEstudiante(String CI_estudiante) {
        bandera = estMo.eliminar_estudiante(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en eliminarEstudiante.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean bajaEstudiante(String CI_estudiante) {
        bandera = estMo.baja_estudiante(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en bajaEstudiante.getCloseConexion: " + e);
        }
        return bandera;
    }

    public int getPractica(String CI_estudiante) {
        numero = notMo.getParcial(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getPractica.getCloseConexion: " + e);
        }
        return numero;
    }

    public int getEvaluadosPrimerParcial(String tutor) {
        ResultSet estudiantes = estMo.ver_estudiante_Tutor(tutor);
        int primerParcial = 0;
        try {
            while (estudiantes.next()) {
                if (notMo.llenoPrimerParcial(estudiantes.getString(6))) {
                    primerParcial++;
                }
            }
            getCloseConexion();
            return primerParcial;
        } catch (Exception e) {
            System.out.println("Error en getEvaluadosPrimerParcial: " + e);
            return 0;
        }
    }

    public int getEvaluadosSegundoParcial(String tutor) {
        ResultSet estudiantes = estMo.ver_estudiante_Tutor(tutor);
        int primerParcial = 0;
        try {
            while (estudiantes.next()) {
                if (notMo.llenoSegundoParcial(estudiantes.getString(6))) {
                    primerParcial++;
                }
            }
            getCloseConexion();
            return primerParcial;
        } catch (Exception e) {
            System.out.println("Error en getEvaluadosSegundoParcial: " + e);
            return 0;
        }
    }

    public String verEstudiantesXTutor(String tutor) {
        ResultSet rs;
        rs = estMo.ver_estudiante_Tutor(tutor);
        int i = 1;
        htmlcode = "";
        htmlcode = "          <div class=\"container\">\n"
                + "                        <div class=\"row\">\n"
                + "                            <div class=\"col s12\">\n"
                + "                                <h1 class=\"center yellow-text\">Estudiantes</h1>\n"
                + "                                <a href=\"#search\" class=\"waves-effect waves-light waves-teal yellow accent-2 blue-text text-darken-3 btn-large modal-trigger\"><i class=\"material-icons right\">search</i>Buscar</a>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>"
                + "                 <div class=\"container\">\n"
                + "                        <table class=\"highlight responsive-table blue darken-3 yellow-text\">\n"
                + "                            <thead>\n"
                + "                                <tr>\n"
                + "                                    <th>#</th>\n"
                + "                                    <th>Foto</th>\n"
                + "                                    <th>Nombre Completo</th>\n"
                + "                                    <th># de Carnet</th>\n"
                + "                                    <th>Celular</th>\n"
                + "                                    <th>Materia</th>\n"
                + "                                    <th>Carrera</th>\n"
                + "                                    <th class=\"center-align\">Evaluar</th>\n"
                + "                                    <th class=\"center-align\">Imprimir Evaluaciones</th>\n"
                + "                                </tr>\n"
                + "                            </thead>\n"
                + "                            <tbody>\n";
        try {
            if (rs == null) {

            } else {

                while (rs.next()) {
                    System.out.println(rs.getString(6));
                    htmlcode += "                <tr>\n"
                            + "                    <td>" + i + "</td>\n"
                            + "                    <td><img class=\"responsive-img materialboxed\" src=\"../../img/fcea/estudiantes/" + rs.getString(1) + "\" alt=\"" + rs.getString(2) + "\" width=\"50\"></td>\n"
                            + "                    <td>" + rs.getString(4) + " " + rs.getString(5) + ", " + rs.getString(2) + " " + rs.getString(3) + "</td>\n"
                            + "                    <td id=\"CI_estudiante\">" + rs.getString(6) + "</td>\n"
                            + "                    <td>" + rs.getString(7) + "</td>\n"
                            + "                    <td>" + rs.getString(8) + "</td>\n"
                            + "                    <td>" + rs.getString(9) + "</td>\n"
                            + "                    <td><div class=\"center-align\"><a href=\"estudiante_ver.jsp?ci=" + rs.getString(6) + "\" id=\"asignar_nota_estudiante\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Asignar Nota\"><i class=\"material-icons yellow-text\">event_note</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\"><a href=\"ver_reportes.jsp?ci=" + rs.getString(6) + "\" id=\"ver_reporte\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Imprimir Evaluacion\"><i class=\"material-icons yellow-text\">print</i></a></div></td>\n";
                    i++;

                }

            }
            getCloseConexion();
        } catch (SQLException ex) {
            System.out.println("Error en verEstudiantesXTutor: " + ex);
        }
        htmlcode += "                        </tbody>\n"
                + "                        </table>\n"
                + "                    </div>";
        return htmlcode;
    }

    public String verEstudiantes() {
        ResultSet rs;
        rs = estMo.ver_estudiante();
        int i = 1;
        htmlcode = "";
        htmlcode = "          <div class=\"container\">\n"
                + "                        <div class=\"row\">\n"
                + "                            <div class=\"col s12\">\n"
                + "                                <h1 class=\"center yellow-text\">Estudiantes</h1>\n"
                + "                                <a href=\"#search\" class=\"waves-effect waves-light yellow accent-2 blue-text text-darken-3 btn-large modal-trigger\"><i class=\"material-icons right\">search</i>Buscar</a>\n"
                + "                                <a href=\"#new\" class=\"waves-effect waves-light yellow accent-2 blue-text text-darken-3 btn-large right modal-trigger\"><i class=\"material-icons left\">person_add</i>Nuevo</a>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>"
                + "                 <div class=\"container\">\n"
                + "                        <table class=\"highlight responsive-table blue darken-3 yellow-text\">\n"
                + "                            <thead>\n"
                + "                                <tr class=\"\">\n"
                + "                                    <th>#</th>\n"
                + "                                    <th>Foto</th>\n"
                + "                                    <th>Nombre Completo</th>\n"
                + "                                    <th># de Carnet</th>\n"
                + "                                    <th>Celular</th>\n"
                + "                                    <th>Estado</th>\n"
                + "                                    <th class=\"center-align\">Ver - Actualizar</th>\n"
                + "                                    <th class=\"center-align\">Asignar Practicas</th>\n"
                + "                                    <th class=\"center-align\">Dar de Baja</th>\n"
                + "                                </tr>\n"
                + "                            </thead>\n"
                + "                            <tbody>\n";
        try {
            if (rs == null) {
            } else {
                while (rs.next()) {
                    htmlcode += "                <tr>\n"
                            + "                    <td>" + i + "</td>\n"
                            + "                    <td><img class=\"responsive-img materialboxed\" src=\"../../img/fcea/estudiantes/" + rs.getString(9) + "\" alt=\"" + rs.getString(2) + "\" width=\"50\"></td>\n"
                            + "                    <td>" + rs.getString(4) + " " + rs.getString(5) + ", " + rs.getString(2) + " " + rs.getString(3) + "</td>\n"
                            + "                    <td id=\"CI_estudiante\">" + rs.getString(6) + "</td>\n"
                            + "                    <td>" + rs.getString(7) + "</td>\n";
                    if (rs.getInt(8) == 1) {
                        htmlcode += "                    <td>Activo</td>\n";
                    } else {
                        htmlcode += "                    <td>Inactivo</td>\n";
                    }
                    System.out.println("CI_Estudiante: " + rs.getString(6));
                    htmlcode += "                  <td><div class=\"center-align\">  <a href=\"estudiante_ver.jsp?ci=" + rs.getString(6) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Ver - Actualizar\"><i class=\"material-icons yellow-text\">visibility</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\">  <a href=\"asignar_practica.jsp?ci=" + rs.getString(6) + "\" id=\"asignar_practica\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Asignar Practica\"><i class=\"material-icons yellow-text\">transfer_within_a_station</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\">  <a id=\"baja_estudiante\" data-id=\"" + rs.getString(6) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Dar de Baja\"><i class=\"material-icons yellow-text\">redo</i></a></div></td>\n"
                            + "                  </tr>"
                            + "";
                    i++;
                }
            }
            getCloseConexion();
        } catch (SQLException ex) {
            System.out.println("Error en verEstudiantes: " + ex);
        }
        htmlcode += "                        </tbody>\n"
                + "                        </table>\n"
                + "                    </div>";
        return htmlcode;
    }

    public boolean updateEstudiante(Estudiante est, String ciPersona) {
        try {
            if (estMo.actualizaEstudiante(est)) {
                getCloseConexion();
                bandera = true;
            } else {
                getCloseConexion();
                bandera = false;
            }
        } catch (Exception e) {
            System.out.println("Error en updateEstudiante.getCloseConexion: " + e);
        }
        return bandera;
    }

    public String modalNewEstudiante() {
        htmlcode = "";
        htmlcode = "                <div class=\"modal-content blue darken-3\">\n"
                + "                        <div class=\"row\">\n"
                + "                            <h1 class=\"center yellow-text\">Nuevo Estudiante</h1>\n"
                + "                        </div>\n"
                + "                        <div class=\"row\">\n"
                + "                            <form method=\"post\" id=\"nuevoest\" action=\"../estudiante.do\" class=\"col s12 yellow-text\" enctype=\"multipart/form-data\">\n"
                + "                                <div class=\"row\">\n"
                + "                                    <div class=\"input-field col s6\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                + "                                        <input id=\"primerNombre\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"Primer Nombre\">Primer Nombre</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s6\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                + "                                        <input id=\"segundoNombre\" type=\"text\" >\n"
                + "                                        <label class=\"yellow-text\" for=\"Segundo Nombre\">Segundo Nombre</label>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                                <div class=\"row\">\n"
                + "                                    <div class=\"input-field col s6\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                + "                                        <input id=\"primerApellido\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"Primer Apellido\">Primer Apellido</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s6\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                + "                                        <input id=\"segundoApellido\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"Segundo Apellido\">Segundo Apellido</label>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                                <div class=\"row\">\n"
                + "                                    <div class=\"input-field col s6\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">fingerprint</i>\n"
                + "                                        <input id=\"ci\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"ci\"># de Carnet</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s6\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">contact_phone</i>\n"
                + "                                        <input id=\"celular\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"celular\">Telefono - Celular</label>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                                <div class=\"row\">\n"
                + "                                    <div class=\"file-field input-field col s6\">\n"
                + "                                        <div class=\"btn blue yellow-text\">\n"
                + "                                            <span>Foto</span>\n"
                + "                                            <input type=\"file\" id=\"foto\">\n"
                + "                                        </div>\n"
                + "                                        <div class=\"file-path-wrapper\">\n"
                + "                                            <input class=\"file-path validate\" type=\"text\"  placeholder=\"Seleccione una Foto\">\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                            </form>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                    <div class=\"modal-footer blue darken-3 yellow-text\">\n"
                + "                        <div class=\"col s6\">\n"
                + "                            <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"nuevoestudiante\">\n"
                + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                + "                            </button>\n"
                + "                        </div>\n"
                + "                        <div id=\"notificacionnewEstudiante\">\n"
                + "                        </div>\n"
                + "                    </div>";
        return htmlcode;
    }

    public String viewUpdateEstudiante(String CI_estudiante) {
        ResultSet datos = estMo.editEstudiante(CI_estudiante);
        htmlcode = "";
        try {
            if (!datos.next()) {
                return "";
            }
            htmlcode = "               <div class=\"container\">\n"
                    + "                        <form method=\"post\" id=\"estAc\" name=\"estAc\" action=\"../../estudiante.do\" class=\"col s12 yellow-text\" enctype=\"multipart/form-data\">\n"
                    + "                            <input id=\"accion\" name=\"accion\" type=\"hidden\" value=\"update_estudiante\">\n"
                    + "                            <div class=\"row\">\n"
                    + "                                <h1 class=\"center yellow-text\">Actualizar Datos del Estudiante</h1>\n"
                    + "                            </div>\n"
                    + "                            <div class=\"row\">\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"primerNombreAc\" name=\"primerNombreAc\" type=\"text\" value=\"" + datos.getString(2) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Nombre\">Primer Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"segundoNombreAc\" name=\"segundoNombreAc\" type=\"text\" value=\"" + datos.getString(3) + "\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Nombre\">Segundo Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"primerApellidoAc\" name=\"primerApellidoAc\" type=\"text\" value=\"" + datos.getString(4) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Apellido\">Primer Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"segundoApellidoAc\" name=\"segundoApellidoAc\" type=\"text\" value=\"" + datos.getString(5) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Apellido\">Segundo Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">fingerprint</i>\n"
                    + "                                        <input id=\"ciAc\" name=\"ciAc\" type=\"text\" value=\"" + datos.getString(6) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"ci\"># de Carnet</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">contact_phone</i>\n"
                    + "                                        <input id=\"celularAc\" name=\"celularAc\" type=\"text\" value=\"" + datos.getString(7) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"celular\">Telefono - Celular</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"file-field input-field col s6\">\n"
                    + "                                        <div class=\"btn blue yellow-text\">\n"
                    + "                                            <span>Foto</span>\n"
                    + "                                            <input type=\"file\" id=\"fotoAC\" name=\"fotoAC\">\n"
                    + "                                        </div>\n"
                    + "                                        <div class=\"file-path-wrapper\">\n"
                    + "                                            <input class=\"file-path validate\" name=\"nombre_fotoAC\" id=\"nombre_fotoAC\" type=\"text\" value=\"" + datos.getString(9) + "\"  placeholder=\"Seleccione una Foto\">\n"
                    + "                                        </div>\n"
                    + "                                    </div>"
                    + "                                    <input id=\"ciEstudiante\" name=\"ciEstudiante\" type=\"hidden\" value=\"" + CI_estudiante + "\">\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                        </form>\n"
                    + "                            <div class=\"col s6\">\n"
                    + "                                <a class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"updateEstudiante\">\n"
                    + "                                    Actualizar<i class=\"material-icons right\">save</i>\n"
                    + "                                </a>\n"
                    + "                            <br><br><br>\n"
                    + "                            </div>\n"
                    + "                            <div id=\"notificacionEstudianteAc\">\n"
                    + "                            </div>\n"
                    + "                    </div>";
            getCloseConexion();
        } catch (SQLException ex) {
            System.out.println("Error en updateEstudiante: " + ex);
        }
        return htmlcode;
    }

    public String modalBuscarEstudiante(String nombre, String CI_estudiante, String user) {
        ResultSet rs;
        int i = 0;
        String rol = conUs.getRol(user);
        htmlcode = "";
        try {
            switch (rol) {
                case "Root":
                    htmlcode = "";
                    break;
                case "Docente":
                    if (nombre.equals("")) {
                        rs = estmo.buscarAllEstudiantexCI(CI_estudiante);
                    } else {
                        rs = estmo.buscarAllEstudiantexNombre(nombre);
                    }
                    if (rs != null) {
                        htmlcode = "<table class=\"highlight responsive-table\">\n"
                                + "  <thead>\n"
                                + "    <tr>\n"
                                + "      <th>#</th>\n"
                                + "      <th>Foto</th>\n"
                                + "      <th>Nombre Completo</th>\n"
                                + "      <th># de Carnet</th>\n"
                                + "      <th>Celular</th>\n"
                                + "    </tr>\n"
                                + "  </thead>\n"
                                + "  <tbody>";
                        while (rs.next()) {
                            System.out.println("nombre: " + rs.getString(1));
                            i++;
                            htmlcode += "      <tr>\n"
                                    + "          <td>" + i + "</td>\n"
                                    + "          <td><img class=\"responsive-img\" src=\"../../img/fcea/estudiantes/" + rs.getString(1) + "\" alt=\"" + rs.getString(2) + "\" width=\"50\"></td>\n"
                                    + "          <td>" + rs.getString(4) + " " + rs.getString(5) + ", " + rs.getString(2) + " " + rs.getString(3) + "</td>\n"
                                    + "          <td id=\"CI_estudiante\">" + rs.getString(6) + "</td>\n"
                                    + "          <td>" + rs.getString(7) + "</td>\n"
                                    + "        </tr>";
                        }
                        htmlcode += "   </tbody>\n"
                                + "</table>";
                    } else {
                        htmlcode = "    <div class=\"row\">\n"
                                + "        <div class=\"card-panel red center\">\n"
                                + "          <span class=\"white-text\">\n"
                                + "             El estudiante Solicitado no existe..."
                                + "          </span>\n"
                                + "        </div>\n"
                                + "    </div>\n"
                                + "            ";
                    }
                    break;
                case "Tutor":
                    if (nombre.equals("")) {
                        System.out.println("CI_estudiante: " + CI_estudiante);
                        rs = estmo.buscarEstudiantexCI(CI_estudiante, user);
                    } else {
                        System.out.println("nombre: " + nombre);
                        rs = estmo.buscarEstudiantexNombre(nombre, user);
                    }
                    if (rs != null) {
                        htmlcode = "<table class=\"highlight responsive-table\">\n"
                                + "  <thead>\n"
                                + "    <tr>\n"
                                + "      <th>#</th>\n"
                                + "      <th>Foto</th>\n"
                                + "      <th>Nombre Completo</th>\n"
                                + "      <th># de Carnet</th>\n"
                                + "      <th>Celular</th>\n"
                                + "      <th>Materia</th>\n"
                                + "    </tr>\n"
                                + "  </thead>\n"
                                + "  <tbody>";
                        while (rs.next()) {
                            System.out.println("nombre: " + rs.getString(1));
                            i++;
                            htmlcode += "      <tr>\n"
                                    + "          <td>" + i + "</td>\n"
                                    + "          <td><img class=\"responsive-img\" src=\"../../img/fcea/estudiantes/" + rs.getString(1) + "\" alt=\"" + rs.getString(2) + "\" width=\"50\"></td>\n"
                                    + "          <td>" + rs.getString(4) + " " + rs.getString(5) + ", " + rs.getString(2) + " " + rs.getString(3) + "</td>\n"
                                    + "          <td id=\"CI_estudiante\">" + rs.getString(6) + "</td>\n"
                                    + "          <td>" + rs.getString(7) + "</td>\n"
                                    + "          <td>" + rs.getString(8) + "</td>\n"
                                    + "        </tr>";
                        }
                        htmlcode += "   </tbody>\n"
                                + "</table>";
                    } else {
                        htmlcode = "    <div class=\"row\">\n"
                                + "        <div class=\"card-panel red center\">\n"
                                + "          <span class=\"white-text\">\n"
                                + "             El estudiante Solicitado no existe..."
                                + "          </span>\n"
                                + "        </div>\n"
                                + "    </div>\n"
                                + "            ";
                    }
                    break;
                default:
                    htmlcode = "";
                    break;
            }
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modalBuscarEstudiante: " + e);
        }
        return htmlcode;
    }

    public int getIdAsignacionPractica(String CI_estudiante) {
        numero = aspMo.getIdAsignacionPractica(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadEstudiantes_tutor.getCloseConexion: " + e);
        }
        return numero;
    }

    public int getIdEstudiante(String CI_estudiante) {
        numero = estMo.getIDEstudiante(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getIdEstudiante.getCloseConexion: " + e);
        }
        return numero;
    }

}
