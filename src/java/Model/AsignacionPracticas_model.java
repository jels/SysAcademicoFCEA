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
public class AsignacionPracticas_model extends Conexion {

    public int getParcialEstudiante(String CI_estudiante) {
        return 1;
    }

    public boolean newPractica(AsignacionPracticas as) {

        return false;
    }

    public int getIDMateria(String CI_estudiante) {
        
        
        
        return 0;
    }

    public int getIdAsignacionPractica(String CI_Estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.idMateria "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ?";
            pst = getConnection().prepareStatement(consulta);
            System.out.println("CI: " + CI_Estudiante);
            pst.setString(1, CI_Estudiante);
            rs = pst.executeQuery();
            rs.next();
            System.out.println("idMateria: " + rs.getInt(1));
            return rs.getInt(1);

        } catch (Exception ex) {
            System.err.println("Error getIdAsignacionPractica: " + ex);
            return 0;
        }

    }

    public boolean getRealizaPractica(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT e.idEstudiante "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs.next();

        } catch (Exception ex) {
            System.err.println("Error getIdAsignacionPractica: " + ex);
            return false;
        }

    }

    public ResultSet getAllPracticasEstudiante(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.nombreMateria, asp.idAsignacionPractica "
                    + "FROM estudiante e, materia m, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getAllPracticasEstudiante: " + ex);
            return rs;
        }

    }

    public ResultSet getPracticasEstudiante(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.nombreMateria, asp.idAsignacionPractica "
                    + "FROM estudiante e, materia m, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getAllPracticasEstudiante: " + ex);
            return rs;
        }

    }

    public boolean getRealizoPracticas(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.nombreMateria, asp.idAsignacionPractica "
                    + "FROM estudiante e, materia m, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs.next();

        } catch (Exception ex) {
            System.err.println("Error getRealizoPracticas: " + ex);
            return false;
        }
    }

}
