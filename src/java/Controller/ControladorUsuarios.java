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

    Usuario_model usMo = new Usuario_model();
    Usuario us = new Usuario();
    boolean bandera;
    int numero;
    String dato = "";

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
        try {
            if (usMo.existenciaUser(us)) {
                getCloseConexion();
                return false;
            } else {
                getCloseConexion();
                bandera = usMo.crear_usuario(us);
                getCloseConexion();
            }
        } catch (Exception e) {
            System.out.println("Error en newUser.getCloseConexion: " + e);
        }
        return bandera;
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
        return bandera;
    }

    public boolean updateUser(Usuario us) {
        bandera = usMo.actualizar_usuario(us);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en updateUser: " + e);
        }
        return bandera;
    }

    public boolean actualizarUser(Usuario us) {
        bandera = usMo.updateUser(us);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error: actualizarUser: " + e);
        }
        return bandera;

    }

}
