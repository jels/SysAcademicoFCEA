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
                    + "FROM notas n, asignacionpracticas asp, estudiante e "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND n.parcial = 1 "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ?";
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
                    + "FROM notas n, asignacionpracticas asp, estudiante e "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND n.parcial = 2 "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ?";
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
                    + "FROM notas n, asignacionpracticas asp, estudiante e "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND n.parcial = 3 "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ?";
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

    public boolean evaluacionCompletaDocente(String CI_estudiante) {
        return llenoPrimerParcial(CI_estudiante) && llenoSegundoParcial(CI_estudiante) && llenoFinal(CI_estudiante);
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
                    + "FROM estudiante e, materia m, docente d, tutor t, "
                    + "asignacionpracticas asp, dimensiones dim, criterios cri, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND cri.idCriterios = n.idCriterios "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND e.ciEstudiante = ? "
                    + "AND asp.estadoPractica = 1 "
                    + "AND n.parcial = 1 ";
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
                    + "FROM estudiante e, materia m, docente d, tutor t, "
                    + "asignacionpracticas asp, dimensiones dim, criterios cri, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND cri.idCriterios = n.idCriterios "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND e.ciEstudiante = ? "
                    + "AND asp.estadoPractica = 1 "
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
                    + "FROM estudiante e, materia m, docente d, tutor t, "
                    + "asignacionpracticas asp, dimensiones dim, criterios cri, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND cri.idCriterios = n.idCriterios "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND e.ciEstudiante = ? "
                    + "AND asp.estadoPractica = 1 "
                    + "AND n.parcial = 3 ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getTotalNotasFinal: " + ex);
            return null;
        }
    }

    public int getNotaPrimerParcial(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(n.nota), SUM(n.nota) "
                    + "FROM estudiante e, materia m, docente d, tutor t, "
                    + "asignacionpracticas asp, dimensiones dim, criterios cri, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND cri.idCriterios = n.idCriterios "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND e.ciEstudiante = ? "
                    + "AND asp.estadoPractica = 1 "
                    + "AND n.parcial = 1 ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(2);

        } catch (Exception ex) {
            System.err.println("Error getNotaPrimerParcial: " + ex);
            return 0;
        }
    }

    public int getNotaSegundoParcial(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(n.nota), SUM(n.nota) "
                    + "FROM estudiante e, materia m, docente d, tutor t, "
                    + "asignacionpracticas asp, dimensiones dim, criterios cri, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND cri.idCriterios = n.idCriterios "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND e.ciEstudiante = ? "
                    + "AND asp.estadoPractica = 1 "
                    + "AND n.parcial = 2 ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(2);

        } catch (Exception ex) {
            System.err.println("Error getNotaPrimerParcial: " + ex);
            return 0;
        }
    }

    public int getNotaExamenFinal(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(n.nota), SUM(n.nota) "
                    + "FROM estudiante e, materia m, docente d, tutor t, "
                    + "asignacionpracticas asp, dimensiones dim, criterios cri, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND m.idMateria = dim.idMateria "
                    + "AND dim.idDimensiones = cri.idDimensiones "
                    + "AND cri.idCriterios = n.idCriterios "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND e.ciEstudiante = ? "
                    + "AND asp.estadoPractica = 1 "
                    + "AND n.parcial = 3 ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(2);

        } catch (Exception ex) {
            System.err.println("Error getNotaPrimerParcial: " + ex);
            return 0;
        }
    }

    public int getNotaByPracticas(String CI_estudiante, int parcial, int idAsignacionPractica) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT SUM(n.nota), COUNT(n.nota) "
                    + "FROM estudiante e, asignacionpracticas asp, notas n "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                    + "AND e.ciEstudiante = ? "
                    + "AND n.parcial = ? "
                    + "AND asp.idAsignacionPractica = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            pst.setInt(2, parcial);
            pst.setInt(3, idAsignacionPractica);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (Exception ex) {
            System.err.println("Error getNotaPrimerParcial: " + ex);
            return 0;
        }
    }

    public boolean newNota(int IdAsignacionPractica, int idCriterio, int nota, int parcial) {

        System.out.println("IDASP: " + IdAsignacionPractica);
        System.out.println("IDCRI: " + idCriterio);
        System.out.println("nota: " + nota);
        System.out.println("parcial: " + parcial);

        PreparedStatement pst;

        try {
            String consulta = "INSERT INTO notas"
                    + "(idAsignacionPractica, idCriterios, nota, parcial) "
                    + "VALUES (?,?,?,?)";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, IdAsignacionPractica);
            pst.setInt(2, idCriterio);
            pst.setInt(3, nota);
            pst.setInt(4, parcial);
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error newNota: " + ex);
            return false;
        }
    }
    
}
