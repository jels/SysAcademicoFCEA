/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;

/**
 *
 * @author WarMachine
 */
public class ControladorDocente extends Conexion {

    public String crearDocente() {
        String htmlcode = "";

        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en crearDocente.getCloseConexion: " + e);
        }

        return htmlcode;
    }

}
