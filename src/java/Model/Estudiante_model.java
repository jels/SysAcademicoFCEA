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
public class Estudiante_model extends Conexion {

    public ResultSet getNombreEstudiante(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("CI_estduianre: " + CI_estudiante);
        try {
            String consulta = "SELECT primerNombreEstudiante, segundoNombreEstudiante, "
                    + "primerApellidoEstudiante, segundoApellidoEstudiante, ciEstudiante "
                    + "FROM estudiante "
                    + "WHERE ciEstudiante = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getNombreEstudiante: " + ex);
            return null;
        }
    }

    public ResultSet getDatosEst(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("CI_estduianre: " + CI_estudiante);
        try {
            String consulta = "SELECT primerNombreEstudiante, segundoNombreEstudiante, "
                    + "primerApellidoEstudiante, segundoApellidoEstudiante, ciEstudiante, "
                    + "telefonoEstudiante, estadoEstudiante, fotoEstudiante "
                    + "FROM estudiante "
                    + "WHERE ciEstudiante = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getDatosEst: " + ex);
            return null;
        }

    }

    public int getIDEstudiante(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT idEstudiante "
                    + "FROM estudiante "
                    + "WHERE ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error getIDEstudiante: " + ex);
            return 0;
        }

    }

    public boolean crear_estudiante(Estudiante est) {

        PreparedStatement pst = null;

        try {
            String consulta = "INSERT INTO estudiante(primerNombreEstudiante, "
                    + "segundoNombreEstudiante, primerApellidoEstudiante, "
                    + "segundoApellidoEstudiante, ciEstudiante, telefonoEstudiante, "
                    + "estadoEstudiante, fotoEstudiante)"
                    + " VALUES (?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, est.getPrimerNombrePersona());
            pst.setString(2, est.getSegundoNombrePersona());
            pst.setString(3, est.getPrimerApellidoPersona());
            pst.setString(4, est.getSegundoApellidoPersona());
            pst.setString(5, est.getCiPersona());
            pst.setString(6, est.getTelefonoPersona());
            pst.setInt(7, est.getEstadoPersona());
            pst.setString(8, est.getFotoEstudiante());
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error Crear_estudiante: " + ex);
            return false;
        }
    }

    public ResultSet buscarEstudiantexCI(String CI_estudiante, String tutor) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT e.fotoEstudiante, e.primerNombreEstudiante, e.segundoNombreEstudiante, "
                    + "e.primerApellidoEstudiante, e.segundoApellidoEstudiante, e.ciEstudiante, "
                    + "e.telefonoEstudiante, m.nombreMateria "
                    + "FROM estudiante e, tutor t, asignacionpracticas asp, usuarios u, materia m "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND u.idUsuario = t.idUsuario "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ?"
                    + "AND u.nombreUsuario = ? "
                    + "ORDER BY e.estadoEstudiante DESC, e.primerApellidoEstudiante ASC, e.segundoApellidoEstudiante ASC ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            pst.setString(2, tutor);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error buscarEstudiantexCI: " + ex);
            return null;
        }
    }

    public ResultSet buscarAllEstudiantexCI(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT fotoEstudiante, primerNombreEstudiante, "
                    + "segundoNombreEstudiante, primerApellidoEstudiante, "
                    + "segundoApellidoEstudiante, ciEstudiante, telefonoEstudiante "
                    + "FROM estudiante "
                    + "WHERE ciEstudiante = ? "
                    + "ORDER BY estadoEstudiante DESC, "
                    + "primerApellidoEstudiante ASC, segundoApellidoEstudiante ASC ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error buscarAllEstudiantexCI: " + ex);
            return null;
        }
    }

    public ResultSet buscarEstudiantexNombre(String nombre, String tutor) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT e.fotoEstudiante, e.primerNombreEstudiante, e.segundoNombreEstudiante, "
                    + "e.primerApellidoEstudiante, e.segundoApellidoEstudiante, e.ciEstudiante, "
                    + "e.telefonoEstudiante, m.nombreMateria "
                    + "FROM estudiante e, tutor t, asignacionpracticas asp, usuarios u, materia m "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND u.idUsuario = t.idUsuario "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.primerApellidoEstudiante = ? "
                    + "AND u.nombreUsuario = ? "
                    + "ORDER BY e.estadoEstudiante DESC, e.primerApellidoEstudiante ASC, e.segundoApellidoEstudiante ASC ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, tutor);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error buscarEstudiantexNombre: " + ex);
            return null;
        }
    }

    public ResultSet buscarAllEstudiantexNombre(String nombre) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT fotoEstudiante, primerNombreEstudiante, "
                    + "segundoNombreEstudiante, primerApellidoEstudiante, "
                    + "segundoApellidoEstudiante, ciEstudiante, telefonoEstudiante "
                    + "FROM estudiante "
                    + "WHERE primerApellidoEstudiante = ? "
                    + "ORDER BY estadoEstudiante DESC, "
                    + "primerApellidoEstudiante ASC, segundoApellidoEstudiante ASC ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            System.out.println("Consulta: " + consulta);
            return rs;

        } catch (Exception ex) {
            System.err.println("Error buscarEstudiantexNombre: " + ex);
            return null;
        }
    }

    public boolean actualizar_estudiante(String est) {
        return false;
    }

    public int contar_estudiantes() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idEstudiante) FROM estudiante WHERE estadoEstudiante = 1";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error contar_estudiantes: " + ex);
            return 0;
        }
    }

    public int contar_estudiantes_tutor(String tutor) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(e.idEstudiante) "
                    + "FROM estudiante e, tutor t, asignacionpracticas asp, usuarios u "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND u.idUsuario = t.idUsuario "
                    + "AND u.nombreUsuario = ? "
                    + "AND e.estadoEstudiante = 1 "
                    + "AND asp.estadoPractica = 1 ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, tutor);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error contar_estudiantes: " + ex);
            return 0;
        }
    }

    public ResultSet ver_estudiante() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT * FROM estudiante ORDER BY estadoEstudiante DESC, primerApellidoEstudiante ASC, segundoApellidoEstudiante ASC ";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error ver_estudiante: " + ex);
            return null;
        }

    }

    public boolean existenciaEstudiante(Estudiante est) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT ciEstudiante FROM estudiante WHERE ciEstudiante = ?";
            System.out.println("ci: " + est.getCiPersona());
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, est.getCiPersona());
            rs = pst.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            System.err.println("Error existenciaEstudiante: " + ex);
            return false;
        }

    }

    public boolean eliminar_estudiante(String CI_estudiante) {

        PreparedStatement pst = null;

        try {
            String consulta = "DELETE FROM estudiante WHERE ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error eliminar_estudiante: " + ex);
            return false;
        }

    }

    public boolean baja_estudiante(String CI_estudiante) {

        PreparedStatement pst = null;
        int estado;
        if (verificarEstado(CI_estudiante) == 1) {
            estado = 0;
        } else {
            estado = 1;
        }
        try {
            String consulta = "UPDATE estudiante SET estadoEstudiante = ? WHERE ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            pst.setString(2, CI_estudiante);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error baja_estudiante: " + ex);
            return false;
        }

    }

    private int verificarEstado(String ciEstudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT estadoEstudiante FROM estudiante WHERE ciEstudiante = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, ciEstudiante);
            rs = pst.executeQuery();
            rs.next();
            System.out.println("estado: " + rs.getInt(1));
            return rs.getInt(1);

        } catch (Exception ex) {
            System.err.println("Error verificarEstado: " + ex);
            return 0;
        }

    }

    public ResultSet editEstudiante(String est) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT * FROM estudiante WHERE ciEstudiante = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, est);
            rs = pst.executeQuery();
            System.out.print(consulta);
            return rs;

        } catch (Exception ex) {
            System.err.println("Error ver_estudiante: " + ex);
            return null;
        }

    }

    public boolean actualizaEstudiante(Estudiante est) {

        //UPDATE estudiante SET primerNombreEstudiante = ? ,segundoNombreEstudiante = ? ,primerApellidoEstudiante = ? ,segundoApellidoEstudiante = ? ,telefonoEstudiante = ? ,estadoEstudiante = ? ,fotoEstudiante = ? WHERE ciEstudiante = ?
        PreparedStatement pst;

        try {
            String consulta = "UPDATE estudiante "
                    + "SET primerNombreEstudiante = ?, "
                    + "segundoNombreEstudiante = ?, "
                    + "primerApellidoEstudiante = ?, "
                    + "segundoApellidoEstudiante = ?, "
                    + "telefonoEstudiante = ?, "
                    + "fotoEstudiante = ? "
                    + "WHERE ciEstudiante = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, est.getPrimerNombrePersona());
            pst.setString(2, est.getSegundoNombrePersona());
            pst.setString(3, est.getPrimerApellidoPersona());
            pst.setString(4, est.getSegundoApellidoPersona());
            pst.setString(5, est.getTelefonoPersona());
            pst.setString(6, est.getFotoEstudiante());
            pst.setString(7, est.getCiPersona());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error newEstudiant: " + ex);
            return false;
        }
    }

    public ResultSet ver_estudiante_Tutor(String tutor) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT e.fotoEstudiante, e.primerNombreEstudiante, "
                    + "e.segundoNombreEstudiante, e.primerApellidoEstudiante, "
                    + "e.segundoApellidoEstudiante, e.ciEstudiante, e.telefonoEstudiante, "
                    + "m.nombreMateria, c.nombreCarrera "
                    + "FROM estudiante e, tutor t, asignacionpracticas asp, "
                    + "usuarios u, materia m, carrera c "
                    + "WHERE c.idCarrera = m.idCarrera "
                    + "AND e.idEstudiante = asp.idEstudiante "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND u.idUsuario = t.idUsuario "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND asp.estadoPractica = 1 "
                    + "AND u.nombreUsuario = ? "
                    + "ORDER BY e.estadoEstudiante DESC, e.primerApellidoEstudiante ASC, e.segundoApellidoEstudiante ASC ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, tutor);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error ver_estudiante_Tutor: " + ex);
            return null;
        }
    }

}
