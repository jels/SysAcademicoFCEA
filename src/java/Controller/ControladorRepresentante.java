/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;

/**
 *
 * @author WarMachine
 */
public class ControladorRepresentante extends Conexion {

    String htmlcode = "";
    Representante_model repMo = new Representante_model();
    int contador;
    boolean bandera;

    public int getIdRepresentante(String ci) {
        contador = repMo.getIdRepresentante(ci);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getIdRepresentante.getCloseConexion: " + e);
        }
        return contador;
    }

    public boolean newRepresentante(Representante rep) {
        bandera = repMo.crear_representante(rep);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en newRepresentante.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean borrarRepresentante(String ci) {
        bandera = repMo.borrar_representante(ci);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en borrarRepresentante.getCloseConexion: " + e);
        }
        return false;
    }

    public String editarRepresentante(int idEmpresa) {
        htmlcode = "";

        ResultSet representante = repMo.getRepresentanteEmpresa(idEmpresa);
        try {
            representante.next();
            htmlcode = "            <div class=\"container\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h3 class=\"center yellow-text\">Actualizar Datos del Representante</h3>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <form id=\"updateRepresentante\" class=\"col s12 yellow-text\">\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"pNombreRepresentanteAC\" type=\"text\" value=\"" + representante.getString(2) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Nombre\">Primer Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"sNombreRepresentanteAC\" type=\"text\" value=\"" + representante.getString(3) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Nombre\">Segundo Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"pApellidoRepresentanteAC\" type=\"text\" value=\"" + representante.getString(4) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Apellido\">Primer Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"sApellidoRepresentanteAC\" type=\"text\" value=\"" + representante.getString(5) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Apellido\">Segundo Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">fingerprint</i>\n"
                    + "                                        <input id=\"ciRepresentanteAC\" type=\"text\" value=\"" + representante.getString(6) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"CIRep\">N° de Carnet</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">contact_phone</i>\n"
                    + "                                        <input id=\"telefonoRepresentanteAC\" type=\"text\" value=\"" + representante.getString(7) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Telefono\">Teléfono</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">supervisor_account</i>\n"
                    + "                                        <input id=\"cargoRepresentanteAC\" type=\"text\" value=\"" + representante.getString(8) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Cargo\">Cargo</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </form>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"col s6\">\n"
                    + "                            <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"actualizarRepresentante\" data-id=\"" + representante.getInt(1) + "\">\n"
                    + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                    + "                            </button>\n"
                    + "                            <br><br><br><br>\n"
                    + "                        </div>\n"
                    + "                        <div id=\"notificacionUPRepresentante\">\n"
                    + "                        </div>\n"
                    + "                    </div>";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en editarRepresentante: " + e);
        }
        return htmlcode;
    }

    public boolean updateRepresentante(Representante rep) {
        bandera = repMo.actualizarRepresentante(rep);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en updateRepresentante: " + e);
        }
        return bandera;
    }

}
