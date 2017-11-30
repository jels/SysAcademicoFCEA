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

    boolean bandera;
    Usuario_model usMo = new Usuario_model();
    int numero;
    String dato;
    Usuario us = new Usuario();

    public boolean loginUser(Usuario us) {
        bandera = usMo.existencia(us);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en loginUser.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean newUser(Usuario us) {

        if (usMo.existenciaUser(us)) {
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
            bandera = usMo.crear_usuario(us);
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en contarTutores.getCloseConexion: " + e);
            }
            return bandera;
        }
    }

    public int findID(Usuario us) {

        numero = usMo.encontrarID(us);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en findID.getCloseConexion: " + e);
        }
        return numero;
    }

    public int findRol(String rol) {
        numero = usMo.getIdRol(rol);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en findRol.getCloseConexion: " + e);
        }
        return numero;
    }

    public String getRol(String username) {

        us.setNombreUsuario(username);
        dato = usMo.getRol(us);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getRol.getCloseConexion: " + e);
        }

        return dato;
    }

    public boolean borrarUsuario(Usuario us) {

        bandera = usMo.borrarUser(us);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en borrarUsuario.getCloseConexion: " + e);
        }

        return false;
    }

}
