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
public class Notas_model extends Conexion {

    public boolean llenoPrimerParcial(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(n.parcial) "
                    + "FROM notas n, estudiante e, asignacionpracticas asp, materia m "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND e.idEstudiante = n.idEstudiante "
                    + "AND m.idMateria = n.idMateria "
                    + "AND e.ciEstudiante = ? "
                    + "AND n.parcial = 1 ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1) == 20;
        } catch (Exception ex) {
            System.err.println("Error llenoPrimerParcial: " + ex);
            return false;
        }
    }

    public boolean llenoSegundoParcial(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(n.parcial) "
                    + "FROM notas n, estudiante e, asignacionpracticas asp, materia m "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND e.idEstudiante = n.idEstudiante "
                    + "AND m.idMateria = n.idMateria "
                    + "AND e.ciEstudiante = ? "
                    + "AND n.parcial = 2 ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1) == 20;
        } catch (Exception ex) {
            System.err.println("Error llenoSegundoParcial: " + ex);
            return false;
        }
    }

    public boolean llenoFinal(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(n.parcial) "
                    + "FROM notas n, estudiante e, asignacionpracticas asp, materia m "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND e.idEstudiante = n.idEstudiante "
                    + "AND m.idMateria = n.idMateria "
                    + "AND e.ciEstudiante = ? "
                    + "AND n.parcial = 3 ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1) == 20;
        } catch (Exception ex) {
            System.err.println("Error llenoFinal: " + ex);
            return false;
        }
    }

    public boolean evaluacionCompletaTutor(String CI_estudiante) {
        return llenoPrimerParcial(CI_estudiante) && llenoSegundoParcial(CI_estudiante);
    }

    public int getParcial(String CI_estudiante) {

        if (!llenoPrimerParcial(CI_estudiante)) {
            return 1;
        } else if (!llenoSegundoParcial(CI_estudiante)) {
            return 2;
        } else if (!llenoFinal(CI_estudiante)) {
            return 3;
        } else {
            return 0;
        }
    }

    public ResultSet getTotalNotasPrimerParcial(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(n.nota), SUM(n.nota) "
                    + "FROM estudiante e, materia m, asignacionpracticas asp, "
                    + "tutor t, docente d, dimensiones dim, criterios cri, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND cri.idCriterios = n.idCriterios "
                    + "AND e.idEstudiante = n.idEstudiante "
                    + "AND e.ciEstudiante = ? "
                    + "AND n.parcial = 1";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getTotalNotasPrimerParcial: " + ex);
            return null;
        }
    }

    public ResultSet getTotalNotasSegundoParcial(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(n.nota), SUM(n.nota) "
                    + "FROM estudiante e, materia m, asignacionpracticas asp, "
                    + "tutor t, docente d, dimensiones dim, criterios cri, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND cri.idCriterios = n.idCriterios "
                    + "AND e.idEstudiante = n.idEstudiante "
                    + "AND e.ciEstudiante = ? "
                    + "AND n.parcial = 2";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getTotalNotasSegundoParcial: " + ex);
            return null;
        }
    }

    public ResultSet getTotalNotasFinal(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(n.nota), SUM(n.nota) "
                    + "FROM estudiante e, materia m, asignacionpracticas asp, "
                    + "tutor t, docente d, dimensiones dim, criterios cri, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND cri.idCriterios = n.idCriterios "
                    + "AND e.idEstudiante = n.idEstudiante "
                    + "AND e.ciEstudiante = ? "
                    + "AND n.parcial = 3";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getTotalNotasFinal: " + ex);
            return null;
        }

    }

    public boolean newNota(Notas nota) {
        return false;
    }

}
