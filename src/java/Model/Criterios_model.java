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
public class Criterios_model extends Conexion {

    public ResultSet getCriterios(int id) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT c.nombreCriterio, c.idCriterios "
                    + "FROM criterios c, dimensiones d "
                    + "WHERE d.idDimensiones=c.idDimensiones "
                    + "AND d.estadoDimension = 1 "
                    + "AND c.estadoCriterio = 1 "
                    + "AND d.idDimensiones = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getCriterios: " + ex);
            return null;
        }
    }

    public ResultSet getListaCriterio(int idMateria) {
        
        return null;

    }

    public ResultSet getViewCriterio(int id) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("id cons: " + id);
        try {
            String consulta = "SELECT * "
                    + "FROM criterios "
                    + "WHERE idCriterios = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getViewCriterio: " + ex);
            return null;
        }
    }

}
