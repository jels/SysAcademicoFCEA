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
public class ControladorUsuarios extends Conexion {

    public boolean loginUser(Usuario us) {
        Usuario_model usm = new Usuario_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en loginUser.getCloseConexion: " + e);
        }
        return usm.existencia(us);
    }

    public boolean newUser(Usuario us) {

        Usuario_model usm = new Usuario_model();
        if (usm.existenciaUser(us)) {
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en newUser.getCloseConexion: " + e);
            }
            return false;
        } else {
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en contarTutores.getCloseConexion: " + e);
            }
            return usm.crear_usuario(us);
        }
    }

    public int findID(Usuario us) {

        Usuario_model usm = new Usuario_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en findID.getCloseConexion: " + e);
        }
        return usm.encontrarID(us);
    }

}
