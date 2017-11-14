/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WarMachine
 */
public class ControladorTutor extends Conexion {

    public int contarTutores() {

        Tutor_model tutMo = new Tutor_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en contarTutores.getCloseConexion: " + e);
        }
        return tutMo.contar_tutor();

    }

    public String verTutores() {

        String htmlcode = "          <div class=\"container\">\n"
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
        Tutor_model tutMo = new Tutor_model();
        tut = tutMo.ver_Tutores();
        int i = 1;
        if (tut == null) {

        } else {
            try {
                //SELECT idTutor, primerNombreTutor, segundoNombreTutor, 
                //primerApellidoTutor, segundoApellidoTutor, ciTutor, telefonoTutor, 
                //estadoTutor, cargoTutor, fotoTutor, fondoTutor
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
            } catch (SQLException ex) {
                System.out.println("Error en verTutores: " + ex);
            }

        }
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verTutores.getCloseConexion: " + e);
        }
        return htmlcode += "                        </tbody>\n"
                + "                        </table>\n"
                + "                    </div>";
    }

    public String modal_newTutor() {

        String htmlcode = "<div class=\"modal-content blue darken-3\">\n"
                + "                        <div class=\"row\">\n"
                + "                            <h1 class=\"center yellow-text\">Nuevo Tutor</h1>\n"
                + "                        </div>\n"
                + "                        <div class=\"row\">\n"
                + "                            <form method=\"post\" id=\"nuevotut\" action=\"../tutor.do\" class=\"col s12 yellow-text\" enctype=\"multipart/form-data\">\n"
                + "                                <div class=\"row\">\n"
                + "                                    <div class=\"input-field col s4\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                + "                                        <input id=\"primerNombreT\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"Primer Nombre\">Primer Nombre</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s4\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                + "                                        <input id=\"segundoNombreT\" type=\"text\" >\n"
                + "                                        <label class=\"yellow-text\" for=\"Segundo Nombre\">Segundo Nombre</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s4\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                + "                                        <input id=\"primerApellidoT\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"Primer Apellido\">Primer Apellido</label>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                                <div class=\"row\">\n"
                + "                                    <div class=\"input-field col s4\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                + "                                        <input id=\"segundoApellidoT\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"Segundo Apellido\">Segundo Apellido</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s4\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                + "                                        <input id=\"celularT\" type=\"text\" >\n"
                + "                                        <label class=\"yellow-text\" for=\"celularT\">Celular</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s4\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                + "                                        <input id=\"ciT\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"ciT\">CI</label>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                                <div class=\"row\">\n"
                + "                                    <div class=\"input-field col s4\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                + "                                        <input id=\"cargoT\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"cargoT\">Cargo</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s4\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                + "                                        <input id=\"nombreUsuarioT\" type=\"text\" >\n"
                + "                                        <label class=\"yellow-text\" for=\"nombreUsuarioT\">Usuario</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s4\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                + "                                        <input id=\"passUsuarioT\" type=\"password\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"passUsuarioT\">Contraceña</label>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                                <div class=\"row\">\n"
                + "                                    <div class=\"file-field input-field col s6\">\n"
                + "                                        <div class=\"btn blue yellow-text\">\n"
                + "                                            <span>Perfil</span>\n"
                + "                                            <input type=\"file\" id=\"imagenT\">\n"
                + "                                        </div>\n"
                + "                                        <div class=\"file-path-wrapper\">\n"
                + "                                            <input class=\"file-path validate\" type=\"text\"  placeholder=\"Seleccione una Foto\">\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"file-field input-field col s6\">\n"
                + "                                        <div class=\"btn blue yellow-text\">\n"
                + "                                            <span>Fondo</span>\n"
                + "                                            <input type=\"file\" id=\"fondoT\">\n"
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
                + "                            <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"nuevotutor\">\n"
                + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                + "                            </button>\n"
                + "                        </div>\n"
                + "                        <div id=\"notificacionnewTutor\">\n"
                + "\n"
                + "                        </div>"
                + "                    </div>";
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modal_newTutor.getCloseConexion: " + e);
        }
        return htmlcode;

    }

    public boolean bajaTutor(String id) {
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en bajaTutor.getCloseConexion: " + e);
        }
        return false;
    }

    public boolean eliminarTutor(String id) {
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en eliminarTutor.getCloseConexion: " + e);
        }
        return false;
    }

    public boolean newTutor(Tutor tut) {

        Tutor_model tutMo = new Tutor_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en newTutor.getCloseConexion: " + e);
        }
        return tutMo.crear_tutor(tut);

    }

    public String updateTutor() {
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en updateTutor.getCloseConexion: " + e);
        }
        return "";
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
