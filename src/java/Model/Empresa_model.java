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
public class Empresa_model extends Conexion {

    public int contar_empresa() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idEmpresa) FROM empresa WHERE estadoEmpresa = 1";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error contar_empresa: " + ex);
            return 0;
        }
    }

    public String nombre_empresa(String tutor) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT e.nombreEmpresa "
                    + "FROM tutor t, empresa e, usuarios u "
                    + "WHERE e.idEmpresa = t.idEmpresa "
                    + "AND u.idUsuario = t.idUsuario "
                    + "AND e.estadoEmpresa = 1 "
                    + "AND u.nombreUsuario = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, tutor);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return "";
            }
        } catch (Exception ex) {
            System.err.println("Error nombre_empresa: " + ex);
            return "";
        }
    }

    public int getCantidadEmpresas() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idEmpresa) FROM empresa";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error getCantidadEmpresas: " + ex);
            return 0;
        }
    }

    public int getCantidadEmpresasEstado(int estado) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idEmpresa) "
                    + "FROM empresa "
                    + "WHERE estadoEmpresa = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error getCantidadEmpresasEstado: " + ex);
            return 0;
        }
    }

    public ResultSet getEmpresas() {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT idEmpresa, nombreEmpresa, "
                    + "direccionEmpresa, telefonoEmpresa, "
                    + "rubroEmpresa, estadoEmpresa "
                    + "FROM empresa "
                    + "ORDER BY estadoEmpresa DESC, nombreEmpresa ASC ";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getEmpresas: " + ex);
            return null;
        }
    }

    public boolean nueva_empresa(Empresa emp) {

        PreparedStatement pst = null;

        try {
            String consulta = "INSERT INTO empresa "
                    + "(idRepresentante, nombreEmpresa, direccionEmpresa, "
                    + "telefonoEmpresa, rubroEmpresa, estadoEmpresa) "
                    + "VALUES  ( ? , ? , ? , ? , ? , ? )";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, emp.getIdRepresentante());
            pst.setString(2, emp.getNombreEmpresa());
            pst.setString(3, emp.getDireccionEmpresa());
            pst.setString(4, emp.getTelefonoEmpresa());
            pst.setString(5, emp.getRubroEmpresa());
            pst.setInt(6, emp.getEstadoEmpresa());

            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error nueva_empresa: " + ex);
            return false;
        }

    }

    public boolean darBajaEmpresa(int idEmpresa) {
        PreparedStatement pst = null;
        int estado;
        if (verificarEstadoEmpresa(idEmpresa) == 1) {
            estado = 0;
        } else {
            estado = 1;
        }
        try {
            String consulta = "UPDATE empresa SET estadoEmpresa = ? WHERE idEmpresa = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            pst.setInt(2, idEmpresa);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error darBajaEmpresa: " + ex);
            return false;
        }

    }

    private int verificarEstadoEmpresa(int idEmpresa) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT estadoEmpresa "
                    + "FROM empresa "
                    + "WHERE idEmpresa = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idEmpresa);
            rs = pst.executeQuery();
            rs.next();
            System.out.println("estado: " + rs.getInt(1));
            return rs.getInt(1);

        } catch (Exception ex) {
            System.err.println("Error verificarEstadoEmpresa: " + ex);
            return 0;
        }

    }

}
