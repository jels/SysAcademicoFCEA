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

    String htmlcode;
    int contador;
    boolean bandera;
    Tutor_model tutMo = new Tutor_model();

    public String verTutores() {
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

    public boolean bajaTutor(String idTutor) {

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
