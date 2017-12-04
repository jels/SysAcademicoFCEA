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

}
