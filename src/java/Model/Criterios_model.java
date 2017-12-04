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

    public int getCantidadCriteriosXDimension(int idDimension) {
        PreparedStatement pst;
        ResultSet rs;
        System.out.println("idDimension: " + idDimension);
        try {
            String consulta = "SELECT COUNT(c.idCriterios) "
                    + "FROM dimensiones d, criterios c "
                    + "WHERE d.idDimensiones = c.idDimensiones "
                    + "AND c.estadoCriterio = 1 "
                    + "AND d.idDimensiones = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idDimension);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception ex) {
            System.err.println("Error getCantidadCriteriosXDimension: " + ex);
            return 0;
        }
    }

    public ResultSet getListaCriterioXEst(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT cri.idCriterios "
                    + "FROM estudiante e, materia m, asignacionpracticas asp, "
                    + "dimensiones dim, criterios cri "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getListaCriterioXEst: " + ex);
            return null;
        }
    }

    public ResultSet getListaCriterioXDimnension(int idDimension) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT c.idCriterios, c.nombreCriterio, c.estadoCriterio "
                    + "FROM dimensiones d, criterios c "
                    + "WHERE d.idDimensiones = c.idDimensiones "
                    + "AND d.idDimensiones = ? "
                    + "ORDER BY c.estadoCriterio DESC, c.nombreCriterio ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idDimension);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getListaCriterioXDimnension: " + ex);
            return null;
        }
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

    public boolean nuevo_criterio(Criterios cri) {

        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "INSERT INTO criterios "
                    + "(idDimensiones, nombreCriterio, estadoCriterio) "
                    + "VALUES ( ? , ? , ? )";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, cri.getIdDimension());
            pst.setString(2, cri.getNombreCriterio());
            pst.setInt(3, cri.getEstadoCriterio());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error nuevo_criterio: " + ex);
            return false;
        }
    }

    public boolean update_criterio(Criterios cri) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE criterios "
                    + "SET nombreCriterio = ? "
                    + "WHERE idCriterios = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, cri.getNombreCriterio());
            pst.setInt(2, cri.getIdCriterio());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error update_criterio: " + ex);
            return false;
        }
    }

    public boolean baja_criterio(int idCriterio, int estado) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE criterios "
                    + "SET estadoCriterio = ? "
                    + "WHERE idCriterios = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            pst.setInt(2, idCriterio);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error baja_criterio: " + ex);
            return false;
        }
    }

    public int getEstadoCriterio(int idCriterio) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT estadoCriterio "
                    + "FROM criterios "
                    + "WHERE idCriterios = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idCriterio);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception ex) {
            System.err.println("Error getEstadoCriterio: " + ex);
            return 0;
        }
    }

    public ResultSet getDatosCriterio(int idCriterio) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT idCriterios, nombreCriterio "
                    + "FROM criterios "
                    + "WHERE idCriterios = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idCriterio);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            System.err.println("Error getDatosCriterio: " + ex);
            return null;
        }
    }

}
