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
public class Dimension_model extends Conexion {

    public ResultSet getDimensiones(int id) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT d.idDimensiones, d.nombreDimension, d.estadoDimension "
                    + "FROM materia m, dimensiones d "
                    + "WHERE d.idMateria=m.idMateria "
                    + "AND d.estadoDimension = 1 "
                    + "AND m.idMateria = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            System.err.println("Error getDimensiones: " + ex);
            return null;
        }
    }

}
