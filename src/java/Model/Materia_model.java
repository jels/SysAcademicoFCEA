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
public class Materia_model extends Conexion {

    //SELECT m.idMateria, m.nombreMateria, m.descripcionMateria, m.semestreMateria, m.horasPracticas, m.estadoMateria, c.abreviaturaCarrera FROM materia m, carrera c WHERE c.idCarrera=m.idCarrera ORDER BY m.idCarrera, m.estadoMateria ASC 
    public int countMaterias() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT count(idMateria) FROM materia WHERE estadoMateria = 1";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error contar_Materias: " + ex);
            return 0;
        }
    }
    
    public ResultSet ver_materias() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.idMateria, m.nombreMateria, "
                    + "m.descripcionMateria, m.semestreMateria, "
                    + "m.horasPracticas, m.estadoMateria, c.abreviaturaCarrera "
                    + "FROM materia m, carrera c "
                    + "WHERE c.idCarrera=m.idCarrera "
                    + "ORDER BY m.idCarrera, m.estadoMateria ASC";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            return rs;
            
        } catch (Exception ex) {
            System.err.println("Error ver_materias: " + ex);
            return null;
        }
    }

    //SELECT m.idMateria, m.nombreMateria, m.descripcionMateria, m.semestreMateria, m.horasPracticas, m.estadoMateria, c.abreviaturaCarrera FROM materia m, carrera c WHERE c.idCarrera=m.idCarrera AND m.idMateria = ?
    public ResultSet getMateria(int idMateria) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT c.nombreCarrera, m.idMateria, "
                    + "m.nombreMateria, m.descripcionMateria, "
                    + "m.semestreMateria, m.horasPracticas, m.estadoMateria "
                    + "FROM carrera c ,materia m "
                    + "WHERE c.idCarrera=m.idCarrera "
                    + "AND m.idMateria = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idMateria);
            rs = pst.executeQuery();
            return rs;
            
        } catch (Exception ex) {
            System.err.println("Error getMateria: " + ex);
            return null;
        }
    }
    
    public int getIdMateria(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.idMateria "
                    + "FROM estudiante e, asignacionpracticas asp, materia m "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND e.ciEstudiante = ? "
                    + "AND asp.estadoPractica = 1 ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error getIdMateria: " + ex);
            return 0;
        }
    }
    
}
