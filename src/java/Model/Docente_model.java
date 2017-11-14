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
public class Docente_model extends Conexion {

    public boolean crear_docente(Docente doc) {
        return false;
    }

    public boolean actualizar_docente(Docente doc) {
        return false;
    }

    public int contar_docente() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idDocente) FROM docente WHERE estadoDocente = 1";
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

    public ResultSet ver_docente() {
        return null;
    }

}
