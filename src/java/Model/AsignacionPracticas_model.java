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

        int count = 1;
        int parcial1 = 0;
        int parcial2 = 0;
        int parcial3 = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String consulta = "";
        try {
            while (count <= 3) {
                switch (count) {
                    case 1:
                        consulta = "SELECT COUNT(n.parcial) "
                                + "FROM asignacionpracticas asp, "
                                + "estudiante e, notas n "
                                + "WHERE e.idEstudiante = asp.idEstudiante "
                                + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                                + "AND asp.estadoPractica = 1 "
                                + "AND n.parcial = 1 "
                                + "AND e.ciEstudiante = ? ";
                        pst = getConnection().prepareStatement(consulta);
                        pst.setString(1, CI_estudiante);
                        rs = pst.executeQuery();
                        rs.next();
                        parcial1 = rs.getInt(1);
                        break;
                    case 2:
                        consulta = "SELECT COUNT(n.parcial) "
                                + "FROM asignacionpracticas asp, "
                                + "estudiante e, notas n "
                                + "WHERE e.idEstudiante = asp.idEstudiante "
                                + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                                + "AND asp.estadoPractica = 1 "
                                + "AND n.parcial = 2 "
                                + "AND e.ciEstudiante = ? ";
                        pst = getConnection().prepareStatement(consulta);
                        pst.setString(1, CI_estudiante);
                        rs = pst.executeQuery();
                        rs.next();
                        parcial1 = rs.getInt(1);
                        break;
                    case 3:
                        consulta = "SELECT COUNT(n.parcial) "
                                + "FROM asignacionpracticas asp, "
                                + "estudiante e, notas n "
                                + "WHERE e.idEstudiante = asp.idEstudiante "
                                + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                                + "AND asp.estadoPractica = 1 "
                                + "AND n.parcial = 3 "
                                + "AND e.ciEstudiante = ? ";
                        pst = getConnection().prepareStatement(consulta);
                        pst.setString(1, CI_estudiante);
                        rs = pst.executeQuery();
                        rs.next();
                        parcial1 = rs.getInt(1);
                        break;
                    default:
                        break;
                }
                count++;
            }
            if (parcial1 == 0) {
                return 1;
            } else if (parcial2 == 0) {
                return 2;
            } else if (parcial3 == 0) {
                return 3;
            } else {
                return 0;
            }

        } catch (Exception ex) {
            System.err.println("Error getParcialEstudiante: " + ex);
            return 0;
        }
    }

    public int getIdAsignacionPractica(String CI_Estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.idAsignacionPractica "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND e.ciEstudiante = ? "
                    + "AND asp.estadoPractica = 1 ";
            pst = getConnection().prepareStatement(consulta);
            System.out.println("CI: " + CI_Estudiante);
            pst.setString(1, CI_Estudiante);
            rs = pst.executeQuery();
            rs.next();
            System.out.println("getIdAsignacionPractica: " + rs.getInt(1));
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
