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
public class ControladorEmpresa extends Conexion {

    Empresa_model empMo = new Empresa_model();
    int cantidad;
    String htmlcode;
    boolean bandera;

    public int countEmpresas() {
        cantidad = empMo.getCantidadEmpresas();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en countEmpresas.getCloseConexion: " + e);
        }
        return cantidad;
    }

    public int countEmpresasActivas() {
        cantidad = empMo.getCantidadEmpresasEstado(1);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en countEmpresasActivas.getCloseConexion: " + e);
        }
        return cantidad;
    }

    public int countEmpresasInactivas() {
        cantidad = empMo.getCantidadEmpresasEstado(0);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en countEmpresasInactivas.getCloseConexion: " + e);
        }
        return cantidad;
    }

    public String verEmpresas() {

        ResultSet empresa = empMo.getEmpresas();

        int i = 1;

        htmlcode = "          <div class=\"container\">\n"
                + "                        <div class=\"row\">\n"
                + "                            <div class=\"col s12\">\n"
                + "                                <h1 class=\"center yellow-text\">Empresas</h1>\n"
                + "                                <a href=\"#search\" class=\"waves-effect waves-light waves-teal yellow accent-2 blue-text text-darken-3 btn-large modal-trigger\"><i class=\"material-icons right\">search</i>Buscar</a>\n"
                + "                                <a href=\"#new\" class=\"waves-effect waves-light waves-teal yellow accent-2 blue-text text-darken-3 btn-large right modal-trigger\"><i class=\"material-icons left\">add_to_photos</i>Nueva</a>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>"
                + "                 <div class=\"container\">\n"
                + "                        <table class=\"highlight responsive-table blue darken-3 yellow-text\">\n"
                + "                            <thead>\n"
                + "                                <tr>\n"
                + "                                    <th>#</th>\n"
                + "                                    <th>Nombre</th>\n"
                + "                                    <th>Direccion</th>\n"
                + "                                    <th>Telefono</th>\n"
                + "                                    <th>Rubro</th>\n"
                + "                                    <th>Estado</th>\n"
                + "                                    <th class=\"center-align\">Ver - Editar</th>\n"
                + "                                    <th class=\"center-align\">Dar de Baja</th>\n"
                + "                                </tr>\n"
                + "                            </thead>\n"
                + "                            <tbody>\n";

        if (empresa == null) {

        } else {
            try {
                while (empresa.next()) {
                    System.out.println(empresa.getString(1));
                    htmlcode += "                <tr>\n"
                            + "                    <td>" + i + "</td>\n"
                            + "                    <td>" + empresa.getString(2) + "</td>\n"
                            + "                    <td>" + empresa.getString(3) + "</td>\n"
                            + "                    <td>" + empresa.getString(4) + "</td>\n"
                            + "                    <td>" + empresa.getString(5) + "</td>\n";
                    if (empresa.getInt(6) == 1) {
                        htmlcode += "                    <td>Activo</td>\n";
                    } else {
                        htmlcode += "                    <td>Inactivo</td>\n";
                    }

                    htmlcode += "                    <td><div class=\"center-align\">  <a id=\"ver_empresa\" href=\"empresa_ver.jsp?empresa=" + empresa.getString(1) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Ver - Editar\"><i class=\"material-icons yellow-text\">store</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\">  <a id=\"baja_empresa\" data-id=\"" + empresa.getString(1) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Dar de Baja\"><i class=\"material-icons yellow-text\">redo</i></a></div></td>\n";

                    i++;

                }
            } catch (SQLException ex) {
                System.out.println("Error en verEmpresas: " + ex);
            }
        }
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verEmpresas.getCloseConexion: " + e);
        }
        return htmlcode += "                        </tbody>\n"
                + "                        </table>\n"
                + "                    </div>";

    }

    public boolean newEmpresa(Empresa emp) {

        bandera = empMo.nueva_empresa(emp);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en newEmpresa.getCloseConexion: " + e);
        }

        return bandera;
    }

    public boolean bajaEmpresa(int idEmpresa) {
        
        bandera=empMo.darBajaEmpresa(idEmpresa);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en bajaEmpresa.getCloseConexion: " + e);
        }
        return bandera;
    }

}
