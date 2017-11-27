/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WarMachine
 */
public class Coordinador_model extends Conexion {

    public boolean crear_coordinador(Coordinador coor) {
        PreparedStatement pst;
        ResultSet rs;
        if (existeCoordinador(coor.getCiPersona())) { //como no existe entra en la funcion crear coordinador...
            try {
                String consulta = "INSERT INTO coordinador "
                        + "(primerNombreCoordinador, segundoNombreCoordinador, "
                        + "primerApellidoCoordinador, segundoApellidoCoordinador, "
                        + "ciCoordinador, telefonoCoordinador, estadoCoordinador, "
                        + "fotoCoordinador) "
                        + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";
                pst = getConnection().prepareStatement(consulta);
                pst.setString(1, coor.getPrimerNombrePersona());
                pst.setString(2, coor.getSegundoNombrePersona());
                pst.setString(3, coor.getPrimerApellidoPersona());
                pst.setString(4, coor.getSegundoApellidoPersona());
                pst.setString(5, coor.getCiPersona());
                pst.setString(6, coor.getTelefonoPersona());
                pst.setInt(7, coor.getEstadoPersona());
                pst.setString(8, coor.getFotoCoordinador());
                return pst.executeUpdate() == 1;

            } catch (Exception ex) {
                System.err.println("Error crear_coordinador: " + ex);
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean existeCoordinador(String ciCoordinador) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT COUNT(idCoordinador) "
                    + "FROM coordinador "
                    + "WHERE ciCoordinador = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, ciCoordinador);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1) == 0;//quiere decir que no existe el coordinador...
        } catch (Exception ex) {
            System.err.println("Error existeCoordinador: " + ex);
            return false;
        }
    }

    public boolean borrar_coordinador(String CI_Coordinador) {
        PreparedStatement pst = null;

        try {
            String consulta = "DELETE FROM coordinador WHERE ciCoordinador = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_Coordinador);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error borrar_coordinador: " + ex);
            return false;
        }
    }

    public int findIDCoordinador(String ciCoordinador) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT idCoordinador "
                    + "FROM coordinador "
                    + "WHERE ciCoordinador = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, ciCoordinador);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);//retorna el valor del idCoordinador...
        } catch (Exception ex) {
            System.err.println("Error existeCoordinador: " + ex);
            return 0;
        }
    }

    public boolean updateCoordinador(Coordinador coordinador) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE coordinador "
                    + "SET primerNombreCoordinador = ? , "
                    + "segundoNombreCoordinador = ? , "
                    + "primerApellidoCoordinador = ? , "
                    + "segundoApellidoCoordinador = ? , "
                    + "ciCoordinador = ? , "
                    + "telefonoCoordinador = ? , "
                    + "fotoCoordinador = ? "
                    + "WHERE idCoordinador = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, coordinador.getPrimerNombrePersona());
            pst.setString(2, coordinador.getSegundoNombrePersona());
            pst.setString(3, coordinador.getPrimerApellidoPersona());
            pst.setString(4, coordinador.getSegundoApellidoPersona());
            pst.setString(5, coordinador.getCiPersona());
            pst.setString(6, coordinador.getTelefonoPersona());
            pst.setString(7, coordinador.getFotoCoordinador());
            pst.setInt(8, coordinador.getIdPersona());

            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error updateCoordinador: " + ex);
            return false;
        }
    }

}
