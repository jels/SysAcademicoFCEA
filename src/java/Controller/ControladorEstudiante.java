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

    public int cantidadEstudiantes() {
        Estudiante_model estm = new Estudiante_model();
        System.out.println("Estudiantes: " + estm.contar_estudiantes());
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadEstudiantes.getCloseConexion: " + e);
        }
        return estm.contar_estudiantes();
    }

    public int cantidadEstudiantes_tutor(String tutor) {
        Estudiante_model estm = new Estudiante_model();
        System.out.println("Estudiantes: " + estm.contar_estudiantes_tutor(tutor));
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadEstudiantes_tutor.getCloseConexion: " + e);
        }
        return estm.contar_estudiantes_tutor(tutor);
    }

    public boolean newEstudiante(Estudiante est) {
        Estudiante_model estm = new Estudiante_model();
        if (!estm.existenciaEstudiante(est)) {
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en newEstudiante.getCloseConexion: " + e);
            }
            return estm.crear_estudiante(est);
        } else {
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en newEstudiante.getCloseConexion: " + e);
            }
            return false;
        }
    }

    public boolean eliminarEstudiante(String CI_estudiante) {

        Estudiante_model estm = new Estudiante_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en eliminarEstudiante.getCloseConexion: " + e);
        }
        return estm.eliminar_estudiante(CI_estudiante);

    }

    public boolean bajaEstudiante(String CI_estudiante) {

        Estudiante_model estm = new Estudiante_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en bajaEstudiante.getCloseConexion: " + e);
        }
        return estm.baja_estudiante(CI_estudiante);

    }

    public String verEstudiantesXTutor(String tutor) {
        String htmlcode;
        ResultSet rs;
        Estudiante_model estm = new Estudiante_model();
        rs = estm.ver_estudiante_Tutor(tutor);

        int i = 1;

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
                + "                                    <th class=\"center-align\">Asignar Nota</th>\n"
                + "                                    <th class=\"center-align\">Ver Notas</th>\n"
                + "                                    <th class=\"center-align\">Imprimir Evaluacion</th>\n"
                + "                                </tr>\n"
                + "                            </thead>\n"
                + "                            <tbody>\n";

        if (rs == null) {

        } else {
            try {
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
                            + "                    <td><div class=\"center-align\"><a data-id=\"" + rs.getString(6) + "\" id=\"ver_nota_estudiante\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Ver Nota\"><i class=\"material-icons yellow-text\">event_note</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\"><a data-id=\"" + rs.getString(6) + "\" id=\"ver_reporte\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Imprimir Evaluacion\"><i class=\"material-icons yellow-text\">print</i></a></div></td>\n";
                    i++;

                }
            } catch (SQLException ex) {
                System.out.println("Error en verEstudiantesXTutor: " + ex);
            }
        }
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verEstudiantesXTutor.getCloseConexion: " + e);
        }
        return htmlcode += "                        </tbody>\n"
                + "                        </table>\n"
                + "                    </div>";
    }

    public String verEstudiantes() {

        String htmlcode = "";
        ResultSet rs;
        Estudiante_model estm = new Estudiante_model();
        rs = estm.ver_estudiante();
        int i = 1;

        htmlcode += "          <div class=\"container\">\n"
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
                + "                                    <th class=\"center-align\">Ver</th>\n"
                + "                                    <th class=\"center-align\">Asignar Practicas</th>\n"
                + "                                    <th class=\"center-align\">Dar de Baja</th>\n"
                + "                                    <th class=\"center-align\">Eliminar</th>\n"
                + "                                </tr>\n"
                + "                            </thead>\n"
                + "                            <tbody>\n";

        if (rs == null) {

        } else {
            try {
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
                            + "                    <td><div class=\"center-align\">  <a id=\"baja_estudiante\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Dar de Baja\"><i class=\"material-icons yellow-text\">redo</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\">  <a id=\"eliminar_estudiante\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Eliminar\"><i class=\"material-icons yellow-text\">delete_forever</i></a></div></td>\n"
                            + "                  </tr>"
                            + "";
                    i++;

                }
            } catch (SQLException ex) {
                System.out.println("Error en verEstudiantes: " + ex);
            }

        }
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verEstudiantes.getCloseConexion: " + e);
        }
        return htmlcode += "                        </tbody>\n"
                + "                        </table>\n"
                + "                    </div>";
    }

    public boolean updateEstudiante(Estudiante est) {

        Estudiante_model estm = new Estudiante_model();
        if (estm.actualizaEstudiante(est)) {
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en updateEstudiante.getCloseConexion: " + e);
            }
            return true;
        } else {
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en updateEstudiante.getCloseConexion: " + e);
            }
            return false;
        }
    }

    public String modalNewEstudiante() {

        String htmlcode = "<div class=\"modal-content blue darken-3\">\n"
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
                + "\n"
                + "\n"
                + "                    </div>\n"
                + "\n"
                + "                    <div class=\"modal-footer blue darken-3 yellow-text\">\n"
                + "                        <div class=\"col s6\">\n"
                + "                            <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"nuevoestudiante\">\n"
                + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                + "                            </button>\n"
                + "                        </div>\n"
                + "                        <div id=\"notificacionnewEstudiante\">\n"
                + "                        </div>\n"
                + "                    </div>";

        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modalNewEstudiante.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String viewUpdateEstudiante(String CI_estudiante) {
        System.out.println("ci..." + CI_estudiante);
        Estudiante_model estmo = new Estudiante_model();
        ResultSet datos = estmo.editEstudiante(CI_estudiante);

        System.out.println("llego Update..." + CI_estudiante);
        String htmlcode = " ";

        try {
            if (!datos.next()) {
                return "";
            }
            System.out.println("nombre= " + datos.getString(5));
            htmlcode = "               <div class=\"container\">\n"
                    + "                        <form method=\"post\" id=\"estAc\" class=\"col s12 yellow-text\">\n"
                    + "                            <div class=\"row\">\n"
                    + "                                <h1 class=\"center yellow-text\">Actualizar Datos del Estudiante</h1>\n"
                    + "                            </div>\n"
                    + "                            <div class=\"row\">\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"primerNombreAc\" type=\"text\" value=\"" + datos.getString(2) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Nombre\">Primer Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"segundoNombreAc\" type=\"text\" value=\"" + datos.getString(3) + "\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Nombre\">Segundo Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"primerApellidoAc\" type=\"text\" value=\"" + datos.getString(4) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Apellido\">Primer Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"segundoApellidoAc\" type=\"text\" value=\"" + datos.getString(5) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Apellido\">Segundo Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">fingerprint</i>\n"
                    + "                                        <input id=\"ciAc\" type=\"text\" disabled value=\"" + datos.getString(6) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"ci\"># de Carnet</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">contact_phone</i>\n"
                    + "                                        <input id=\"celularAc\" type=\"text\" value=\"" + datos.getString(7) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"celular\">Telefono - Celular</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                            <div class=\"col s6\">\n"
                    + "                                <a class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"estudianteAc\">\n"
                    + "                                    Actualizar<i class=\"material-icons right\">save</i>\n"
                    + "                                </a>\n"
                    + "                            </div>\n"
                    + "                            <div id=\"notificacionEstudianteAc\">\n"
                    + "                            </div>\n"
                    + "                            <br><br><br>\n"
                    + "                        </form>\n"
                    + "                    </div>";
            System.out.println("Nombre: " + datos.getString(2));
        } catch (SQLException ex) {
            System.out.println("Error en updateEstudiante: " + ex);
        }
        System.out.println("htmlcode " + htmlcode);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modalUpdateEstudiante.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String modalBuscarEstudiante(String nombre, String CI_estudiante, String tutor) {
        String htmlcode;
        ControladorUsuarios conUs = new ControladorUsuarios();
        Estudiante_model estmo = new Estudiante_model();
        ResultSet rs;
        int i = 0;
        String rol = conUs.getRol(tutor);

        switch (rol) {
            case "Root":
                htmlcode = "";
                break;
            case "Docente":
                if (nombre.equals("")) {
                    System.out.println("CI_estudiante: " + CI_estudiante);
                    rs = estmo.buscarAllEstudiantexCI(CI_estudiante);
                } else {
                    System.out.println("nombre: " + nombre);
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
                    try {
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

                    } catch (Exception e) {
                        System.out.println("Error en modalBuscarEstudiante " + e);
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
                    rs = estmo.buscarEstudiantexCI(CI_estudiante, tutor);
                } else {
                    System.out.println("nombre: " + nombre);
                    rs = estmo.buscarEstudiantexNombre(nombre, tutor);
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
                    try {
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

                    } catch (Exception e) {
                        System.out.println("Error en modalBuscarEstudiante " + e);
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

        System.out.println("htmlcode: " + htmlcode);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modalBuscarEstudiante.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public int getIdAsignacionPractica(String CI_estudiante) {
        Estudiante_model estMo = new Estudiante_model();
        int idEstudiante = estMo.getIDEstudiante(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modalBuscarEstudiante.getCloseConexion: " + e);
        }
        return idEstudiante;
    }

}
