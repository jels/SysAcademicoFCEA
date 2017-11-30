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

    public boolean new_dimension(Dimension dimension) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "INSERT INTO dimensiones "
                    + "(idMateria, nombreDimension ,"
                    + "estadoDimension) "
                    + "VALUES ( ? , ? , ? )";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, dimension.getIdMateria());
            pst.setString(2, dimension.getNombreDimension());
            pst.setInt(3, dimension.getEstadoDimension());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error new_dimension: " + ex);
            return false;
        }
    }

    public int getCantidadDimensionesXMat(int idMateria) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT COUNT(d.idDimensiones) "
                    + "FROM materia m, dimensiones d "
                    + "WHERE m.idMateria = d.idMateria "
                    + "AND m.idMateria = ? "
                    + "AND d.estadoDimension = 1";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idMateria);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception ex) {
            System.err.println("Error getCantidadDimensionesXMat: " + ex);
            return 0;
        }
    }

    public ResultSet ver_dimensionesxmateria(int idMateria) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT d.idDimensiones, "
                    + "d.nombreDimension, d.estadoDimension "
                    + "FROM materia m, dimensiones d "
                    + "WHERE m.idMateria = d.idMateria "
                    + "AND m.idMateria = ? "
                    + "ORDER BY d.estadoDimension DESC, d.nombreDimension ASC";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idMateria);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            System.err.println("Error ver_dimensionesxmateria: " + ex);
            return null;
        }
    }

    public int getEstadoDimension(int idDimension) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT estadoDimension "
                    + "FROM dimensiones "
                    + "WHERE idDimensiones = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idDimension);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception ex) {
            System.err.println("Error getEstadoDimension: " + ex);
            return 0;
        }
    }

    public boolean baja_dimension(int idDimension, int estado) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE dimensiones "
                    + "SET estadoDimension = ? "
                    + "WHERE idDimensiones = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            pst.setInt(2, idDimension);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error baja_dimension: " + ex);
            return false;
        }
    }

    public String getNombreDimension(int idDimension) {

        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT nombreDimension "
                    + "FROM dimensiones "
                    + "WHERE idDimensiones = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idDimension);
            rs = pst.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error getEstadoDimension: " + ex);
            return "";
        }
    }

    public ResultSet getDimensionActualizar(int idDimension) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT idDimensiones, nombreDimension, "
                    + "estadoDimension "
                    + "FROM dimensiones "
                    + "WHERE idDimensiones = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idDimension);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            System.err.println("Error getDimensionActualizar: " + ex);
            return null;
        }
    }

    public boolean getUpdateDimension(Dimension dimension) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE dimensiones "
                    + "SET nombreDimension = ? "
                    + "WHERE idDimensiones = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, dimension.getNombreDimension());
            pst.setInt(2, dimension.getIdDimension());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error getUpdateDimension: " + ex);
            return false;
        }
    }

    public int getIdDimensionCriterio(int idCriterio) {

        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT d.idDimensiones "
                    + "FROM dimensiones d, criterios c "
                    + "WHERE d.idDimensiones = c.idDimensiones "
                    + "AND c.idCriterios = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idCriterio);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception ex) {
            System.err.println("Error getIdDimensionCriterio: " + ex);
            return 0;
        }
    }
}
