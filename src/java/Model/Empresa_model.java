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

}
