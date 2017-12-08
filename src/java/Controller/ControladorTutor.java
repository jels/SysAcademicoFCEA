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
public class ControladorTutor extends Conexion {

    String htmlcode = "";
    int contador;
    boolean bandera;
    Tutor_model tutMo = new Tutor_model();

    public String verTutores() {
        htmlcode = "";
        htmlcode = "          <div class=\"container\">\n"
                + "                        <div class=\"row\">\n"
                + "                            <div class=\"col s12\">\n"
                + "                                <h1 class=\"center yellow-text\">Tutores</h1>\n"
                + "                                <a href=\"#search\" class=\"waves-effect waves-light yellow accent-2 blue-text text-darken-3 btn-large modal-trigger\"><i class=\"material-icons right\">search</i>Buscar</a>\n"
                + "                                <a href=\"#new\" class=\"waves-effect waves-light yellow accent-2 blue-text text-darken-3 btn-large right modal-trigger\"><i class=\"material-icons left\">person_add</i>Nuevo</a>\n"
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
                + "                                    <th>Cargo</th>\n"
                + "                                    <th>Estado</th>\n"
                + "                                    <th class=\"center-align\">Ver</th>\n"
                + "                                    <th class=\"center-align\">Actualizar</th>\n"
                + "                                    <th class=\"center-align\">Dar de Baja</th>\n"
                + "                                    <th class=\"center-align\">Eliminar</th>\n"
                + "                                </tr>\n"
                + "                            </thead>\n"
                + "                            <tbody>\n";
        ResultSet tut;
        tut = tutMo.ver_Tutores();
        int i = 1;
        try {
            if (tut == null) {
            } else {
                while (tut.next()) {
                    System.out.println("ci: " + tut.getString(7));
                    htmlcode += "                <tr>\n"
                            + "                    <td>" + i + "</td>\n"
                            + "                    <td><img class=\"responsive-img materialboxed\" src=\"" + tut.getString(10) + "\" alt=\"" + tut.getString(2) + "\" width=\"50\"></td>\n"
                            + "                    <td>" + tut.getString(2) + " " + tut.getString(3) + " " + tut.getString(4) + " " + tut.getString(5) + "</td>\n"
                            + "                    <td id=\"CI_tutor\">" + tut.getString(6) + "</td>\n"
                            + "                    <td>" + tut.getString(7) + "</td>\n";
                    if (tut.getString(9).length() > 20) {
                        htmlcode += "                    <td>" + tut.getString(9).substring(0, 20) + "</td>\n";
                    } else {
                        htmlcode += "                    <td>" + tut.getString(9) + "</td>\n";
                    }

                    if (tut.getInt(8) == 1) {
                        htmlcode += "                    <td>Activo</td>\n";
                    } else {
                        htmlcode += "                    <td>Inactivo</td>\n";

                    }
                    htmlcode += "                  <td><div class=\"center-align\">  <a href=\"#show_tut\" data-id=\"" + tut.getString(1) + "\" id=\"ver_tutor\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text modal-trigger\" data-position=\"button\" data-tooltip=\"Actualizar\"><i class=\"material-icons yellow-text\">description</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\">  <a data-id=\"" + tut.getString(1) + "\" id=\"actualizar_tutor\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text modal-trigger\" data-position=\"button\" data-tooltip=\"Actualizar\"><i class=\"material-icons yellow-text\">border_color</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\">  <a id=\"baja_tutor\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Dar de Baja\"><i class=\"material-icons yellow-text\">redo</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\">  <a id=\"eliminar_tutor\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Eliminar\"><i class=\"material-icons yellow-text\">delete_forever</i></a></div></td>\n"
                            + "                  </tr>"
                            + "";
                    i++;
                }
            }
            getCloseConexion();
        } catch (SQLException ex) {
            System.out.println("Error en verTutores: " + ex);
        }
        htmlcode += "                        </tbody>\n"
                + "                        </table>\n"
                + "                    </div>";
        return htmlcode;
    }

    public boolean darBajaTutor(int idTutor) {
        try {
            if (tutMo.getEstadoTutor(idTutor) == 1) {
                bandera = tutMo.bajaTutor(idTutor, 0);
                getCloseConexion();
            } else {
                bandera = tutMo.bajaTutor(idTutor, 1);
                getCloseConexion();
            }
            System.out.println("??" + bandera);
        } catch (Exception e) {
            System.out.println("Error en darBajaTutor.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean eliminarTutor(String id) {

        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en eliminarTutor.getCloseConexion: " + e);
        }
        return false;
    }

    public boolean nuevoTutor(Tutor tutor) {
        bandera = tutMo.crear_tutor(tutor);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en nuevoTutor.getCloseConexion: " + e);
        }
        return bandera;
    }

    public String getEditarTutor(int idTutor) {
        htmlcode = "";

        ResultSet tutor = tutMo.getTutor(idTutor);
        try {
            tutor.next();
            htmlcode = "            <div class=\"container\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h3 class=\"center yellow-text\">Actualizar Datos del Tutor</h3>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <form id=\"updateTutor\" action=\"../../tutor.do\" class=\"col s12 yellow-text\">\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"pNombreTutorAC\" name=\"pNombreTutorAC\" type=\"text\" value=\"" + tutor.getString(2) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Nombre\">Primer Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"sNombreTutorAC\" name=\"sNombreTutorAC\" type=\"text\" value=\"" + tutor.getString(3) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Nombre\">Segundo Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"pApellidoTutorAC\" name=\"pApellidoTutorAC\" type=\"text\" value=\"" + tutor.getString(4) + "\"class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Apellido\">Primer Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"sApellidoTutorAC\" name=\"sApellidoTutorAC\" type=\"text\" value=\"" + tutor.getString(5) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Apellido\">Segundo Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">fingerprint</i>\n"
                    + "                                        <input id=\"ciTutorAC\" name=\"ciTutorAC\" type=\"text\" value=\"" + tutor.getString(6) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"CIRep\"># de Carnet</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">contact_phone</i>\n"
                    + "                                        <input id=\"telefonoTutorAC\" name=\"telefonoTutorAC\" type=\"text\" value=\"" + tutor.getString(7) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Telefono\">Telefono</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">supervisor_account</i>\n"
                    + "                                        <input id=\"cargoTutorAC\" name=\"cargoTutorAC\" type=\"text\" value=\"" + tutor.getString(8) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Cargo\">Cargo</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">person</i>\n"
                    + "                                        <input id=\"userTutorAC\" name=\"userTutorAC\" type=\"text\" value=\"" + tutor.getString(10) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"CIRep\">Usuario</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">lock_outline</i>\n"
                    + "                                        <input id=\"passTutorAC\" name=\"passTutorAC\" type=\"text\" value=\"" + tutor.getString(11) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Telefono\">Contraceña</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                    <input type=\"hidden\" name=\"idTutor\" id=\"id_tutor\" value=\"" + idTutor + "\"/>\n"
                    + "                                    <input type=\"hidden\" name=\"accion_tutor\" id=\"accionTutor\" value=\"update_tutor\"/>\n"
                    + "                            </form>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"col s6\">\n"
                    + "                            <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"actualizarTutor\" data-id=\"" + tutor.getInt(1) + "\">\n"
                    + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                    + "                            </button>\n"
                    + "                            <br><br><br><br>\n"
                    + "                        </div>\n"
                    + "                        <div id=\"notificacionUPTutor\">\n"
                    + "                        </div>\n"
                    + "                    </div>";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en editarTutor: " + e);
        }
        return htmlcode;
    }

    public String editarTutor(int idTutor) {

        htmlcode = "";
        ResultSet tutor = tutMo.getTutor(idTutor);
        try {
            tutor.next();
            htmlcode = "                 <div class=\"container\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h1 class=\"center yellow-text\">Actualizar Empresa</h1>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <form id=\"updateEmpresa\" class=\"col s12 yellow-text\">\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">store</i>\n"
                    + "                                        <input id=\"primerNombreTU\" type=\"text\" value=\"" + tutor.getString(2) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Nombre\">Primer Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">directions</i>\n"
                    + "                                        <input id=\"segundoNombreTU\" type=\"text\" value=\"" + tutor.getString(3) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Nombre\">Segundo Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">contacts</i>\n"
                    + "                                        <input id=\"primerApellidoTU\" type=\"text\" value=\"" + tutor.getString(4) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Apellido\">Primer Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">description</i>\n"
                    + "                                        <input id=\"segundoApellidoTU\" type=\"text\" value=\"" + tutor.getString(5) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Apellido\">Segundo Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s4\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">contacts</i>\n"
                    + "                                        <input id=\"ciTU\" type=\"text\" value=\"" + tutor.getString(6) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"CI\"># de Carnet</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s4\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">description</i>\n"
                    + "                                        <input id=\"telefonoTU\" type=\"text\" value=\"" + tutor.getString(7) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Telefono\">Telefono</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s4\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">description</i>\n"
                    + "                                        <input id=\"cargoTU\" type=\"text\" value=\"" + tutor.getString(8) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Cargo\">Cargo</label>\n"
                    + "                                    </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">contacts</i>\n"
                    + "                                        <input id=\"fotoTU\" type=\"text\" value=\"" + tutor.getString(9) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Telefono\">Foto</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">description</i>\n"
                    + "                                        <input id=\"fondoTU\" type=\"text\" value=\"" + tutor.getString(10) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Rubro\">Fondo</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </form>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"col s6\">\n"
                    + "                            <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"actualizarTutor\" data-id=\"" + idTutor + "\">\n"
                    + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                    + "                            </button>\n"
                    + "                            <br><br><br><br>\n"
                    + "                        </div>\n"
                    + "                        <div id=\"notificacionUPTutor\">\n"
                    + "                        </div>\n"
                    + "                    </div>";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en editarEmpresa: " + e);
        }
        return htmlcode;
    }

    public boolean updateTutor(Tutor tut) {
        bandera = tutMo.actualizar_tutor(tut);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en updateTutor.getCloseConexion: " + e);
        }
        return bandera;
    }

    public String modalSearchTutor() {
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modalSearchTutor.getCloseConexion: " + e);
        }
        return "";
    }

}
