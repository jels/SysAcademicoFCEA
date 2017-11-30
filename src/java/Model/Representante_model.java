/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author WarMachine
 */
public class Representante_model extends Conexion {

    public boolean crear_representante(Representante rep) {

        PreparedStatement pst = null;

        try {
            String consulta = "INSERT INTO representante "
                    + "(primerNombreRepresentante, segundoNombreRepresentante, "
                    + "primerApellidoRepresentante, seguntoApellidoRepresentante, "
                    + "ciRepresentante, telefonoRepresentante, "
                    + "estadoRepresentante, cargoRepresentante) "
                    + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, rep.getPrimerNombrePersona());
            pst.setString(2, rep.getSegundoNombrePersona());
            pst.setString(3, rep.getPrimerApellidoPersona());
            pst.setString(4, rep.getSegundoApellidoPersona());
            pst.setString(5, rep.getCiPersona());
            pst.setString(6, rep.getTelefonoPersona());
            pst.setInt(7, rep.getEstadoPersona());
            pst.setString(8, rep.getCargoRepresentante());
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error crear_representante: " + ex);
            return false;
        }

    }

    public boolean actualizar_representante(Representante rep) {
        return false;
    }

    public int contar_representante() {
        return 0;
    }

    public ResultSet ver_representante() {
        return null;
    }

    public int getIdRepresentante(String ci) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT idRepresentante "
                    + "FROM representante "
                    + "WHERE ciRepresentante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, ci);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error getIdRepresentante: " + ex);
            return 0;
        }

    }

    public boolean borrar_representante(String ci) {

        PreparedStatement pst = null;

        try {
            String consulta = "DELETE FROM representante WHERE idRepresentante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, ci);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error borrar_representante: " + ex);
            return false;
        }

    }

    public String getNombreRepresentanteEmpresa(int idEmpresa) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nombre = "";
        try {
            String consulta = "SELECT r.primerNombreRepresentante, r.segundoNombreRepresentante, "
                    + "r.primerApellidoRepresentante, r.seguntoApellidoRepresentante "
                    + "FROM empresa e, representante r "
                    + "WHERE r.idRepresentante = e.idRepresentante "
                    + "AND e.idEmpresa = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idEmpresa);
            rs = pst.executeQuery();
            if (rs.next()) {
                nombre = rs.getString(3) + " " + rs.getString(4) + ", " + rs.getString(1) + " " + rs.getString(2);
                return nombre;
            } else {
                return "";
            }
        } catch (Exception ex) {
            System.err.println("Error getIdRepresentante: " + ex);
            return "";
        }
    }

}
