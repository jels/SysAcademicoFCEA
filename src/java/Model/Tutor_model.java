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
public class Tutor_model extends Conexion {

    public boolean existeTutor(String ciTutor) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT idTutor "
                    + "FROM tutor "
                    + "WHERE ciTutor = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, ciTutor);
            rs = pst.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            System.err.println("Error existeTutor: " + ex);
            return false;
        }

    }

    public boolean crear_tutor(Tutor tutor) {

        if (existeTutor(tutor.getCiPersona())) {
            return false;
        } else {
            PreparedStatement pst;
            ResultSet rs;
            try {
                String consulta = "INSERT INTO tutor(idUsuario, idEmpresa, primerNombreTutor, "
                        + "segundoNombreTutor, primerApellidoTutor, segundoApellidoTutor, "
                        + "ciTutor, telefonoTutor, estadoTutor, "
                        + "cargoTutor, fotoTutor, fondoTutor) "
                        + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
                pst = getConnection().prepareStatement(consulta);
                pst.setInt(1, tutor.getIdUsuario());
                pst.setInt(2, tutor.getIdEmpresa());
                pst.setString(3, tutor.getPrimerNombrePersona());
                pst.setString(4, tutor.getSegundoNombrePersona());
                pst.setString(5, tutor.getPrimerApellidoPersona());
                pst.setString(6, tutor.getSegundoApellidoPersona());
                pst.setString(7, tutor.getCiPersona());
                pst.setString(8, tutor.getTelefonoPersona());
                pst.setInt(9, tutor.getEstadoPersona());
                pst.setString(10, tutor.getCargoTutor());
                pst.setString(11, tutor.getFotoTutor());
                pst.setString(12, tutor.getFondoTutor());
                return pst.executeUpdate() == 1;

            } catch (Exception ex) {
                System.err.println("Error crear_tutor: " + ex);
                return false;
            }
        }

    }

    public int getEstadoTutor(int idTutor) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT estadoTutor "
                    + "FROM tutor "
                    + "WHERE idTutor = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idTutor);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("estado: " + rs.getInt(1));
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error getEstadoTutor: " + ex);
            return 0;
        }
    }

    public boolean bajaTutor(int idTutor, int estado) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE tutor "
                    + "SET estadoTutor = ? "
                    + "WHERE idTutor = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            pst.setInt(2, idTutor);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error bajaTutor: " + ex);
            return false;
        }
    }

    public boolean actualizar_tutor(Docente tutor) {
        return false;
    }

    public int contar_tutor() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idTutor) FROM tutor WHERE estadoTutor = 1";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error contar_tutor: " + ex);
            return 0;
        }
    }

    public int contar_tutorEstado(int idEmpresa, int estado) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idTutor) "
                    + "FROM tutor "
                    + "WHERE estadoTutor = ? "
                    + "AND idEmpresa = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            pst.setInt(2, idEmpresa);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error contar_tutorEstado: " + ex);
            return 0;
        }
    }

    public int contar_tutorEmpresa(int idEmpresa) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idTutor) "
                    + "FROM tutor "
                    + "WHERE idEmpresa = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idEmpresa);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error contar_tutorEstado: " + ex);
            return 0;
        }
    }

    public ResultSet ver_Tutores() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT idTutor, primerNombreTutor, "
                    + "segundoNombreTutor, primerApellidoTutor, "
                    + "segundoApellidoTutor, ciTutor, telefonoTutor, "
                    + "estadoTutor, cargoTutor, fotoTutor, fondoTutor "
                    + "FROM tutor";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error ver_Tutores: " + ex);
            return rs;
        }
    }

    public String getNombreTutor(String user) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT t.primerNombreTutor, t.segundoNombreTutor, "
                    + "t.primerApellidoTutor, t.segundoApellidoTutor "
                    + "FROM tutor t, usuarios u "
                    + "WHERE u.idUsuario=t.idUsuario "
                    + "AND u.nombreUsuario = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, user);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);
            } else {
                return "";
            }
        } catch (Exception ex) {
            System.err.println("Error contar_tutor: " + ex);
            return "";
        }
    }

    public ResultSet getTutoresXempresa(int idEmpresa) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT t.idTutor, t.primerNombreTutor, "
                    + "t.segundoNombreTutor, t.primerApellidoTutor, "
                    + "t.segundoApellidoTutor, t.ciTutor, t.telefonoTutor, "
                    + "t.cargoTutor, t.estadoTutor, "
                    + "t.fotoTutor "
                    + "FROM empresa e, tutor t "
                    + "WHERE e.idEmpresa = t.idEmpresa "
                    + "AND e.idEmpresa = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idEmpresa);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getTutoresXempresa: " + ex);
            return rs;
        }
    }

}
