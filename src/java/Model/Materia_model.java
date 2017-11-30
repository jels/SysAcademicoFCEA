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

    public int countMaterias() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT count(idMateria) "
                    + "FROM materia "
                    + "WHERE estadoMateria = 1";
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

    public boolean newMateria(Materia mat) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "INSERT INTO materia "
                    + "(idCarrera, nombreMateria, "
                    + "semestreMateria, descripcionMateria, "
                    + "horasPracticas, estadoMateria) "
                    + "VALUES ( ? , ? , ? , ? , ? , ? )";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, mat.getIdCarrera());
            pst.setString(2, mat.getNombreMateria());
            pst.setString(3, mat.getSemestreMateria());
            pst.setString(4, mat.getDescripcionMateria());
            pst.setInt(5, mat.getHorasPracticas());
            pst.setInt(6, mat.getEstadoMateria());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error newMateria: " + ex);
            return false;
        }
    }

    public int getIdMateriaDimension(int idDimension) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.idMateria "
                    + "FROM materia m, dimensiones d "
                    + "WHERE m.idMateria = d.idMateria "
                    + "AND d.idDimensiones = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idDimension);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error getIdMateriaDimension: " + ex);
            return 0;
        }
    }

    public ResultSet ver_materias(String abreviatura) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.idMateria, m.nombreMateria, "
                    + "m.descripcionMateria, m.semestreMateria, "
                    + "m.horasPracticas, m.estadoMateria, c.abreviaturaCarrera "
                    + "FROM materia m, carrera c "
                    + "WHERE c.idCarrera = m.idCarrera "
                    + "AND c.abreviaturaCarrera = ? "
                    + "ORDER BY m.estadoMateria DESC, m.nombreMateria ASC";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, abreviatura);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error ver_materias: " + ex);
            return null;
        }
    }

    public ResultSet getMateria(int idMateria) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT c.nombreCarrera, m.idMateria, "
                    + "m.nombreMateria, m.descripcionMateria, "
                    + "m.semestreMateria, m.horasPracticas, m.estadoMateria "
                    + "FROM carrera c ,materia m "
                    + "WHERE c.idCarrera = m.idCarrera "
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

    public int getMateriasXCarrera(String abreviatura) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(m.idMateria) "
                    + "FROM carrera c, materia m "
                    + "WHERE c.idCarrera = m.idCarrera "
                    + "AND m.estadoMateria = 1 "
                    + "AND c.abreviaturaCarrera = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, abreviatura);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error getMateriasXCarrera: " + ex);
            return 0;
        }

    }

    public int getEstadoMateria(int idMateria) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT estadoMateria "
                    + "FROM materia "
                    + "WHERE idMateria = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idMateria);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);//quiere decir que no existe el carrera...
        } catch (Exception ex) {
            System.err.println("Error getEstadoMateria: " + ex);
            return 0;
        }
    }

    public boolean baja_materia(int idMateria, int estado) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE materia "
                    + "SET estadoMateria = ? "
                    + "WHERE idMateria = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            pst.setInt(2, idMateria);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error baja_materia: " + ex);
            return false;
        }
    }

    public String getNombreMateria(int idMateria) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT nombreMateria "
                    + "FROM materia "
                    + "WHERE idMateria = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idMateria);
            rs = pst.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error getNombreMateria: " + ex);
            return "";
        }
    }

    public boolean actualizarMateria(Materia materia) {
        PreparedStatement pst;
        try {
            String consulta = "UPDATE materia "
                    + "SET nombreMateria = ? , "
                    + "semestreMateria = ? , "
                    + "descripcionMateria = ? , "
                    + "horasPracticas = ? "
                    + "WHERE idMateria = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, materia.getNombreMateria());
            pst.setString(2, materia.getSemestreMateria());
            pst.setString(3, materia.getDescripcionMateria());
            pst.setInt(4, materia.getHorasPracticas());
            pst.setInt(5, materia.getIdMateria());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error actualizarMateria: " + ex);
            return false;
        }
    }

}
