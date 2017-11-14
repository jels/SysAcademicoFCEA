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

    public boolean crear_tutor(Tutor tutor) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "INSERT INTO tutor(idUsuario, primerNombreTutor, "
                    + "segundoNombreTutor, primerApellidoTutor, "
                    + "segundoApellidoTutor, ciTutor, telefonoTutor, "
                    + "estadoTutor, cargoTutor, fotoTutor, fondoTutor) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, tutor.getIdUsuario());
            pst.setString(2, tutor.getPrimerNombrePersona());
            pst.setString(3, tutor.getSegundoNombrePersona());
            pst.setString(4, tutor.getPrimerApellidoPersona());
            pst.setString(5, tutor.getSegundoApellidoPersona());
            pst.setString(6, tutor.getCiPersona());
            pst.setString(7, tutor.getTelefonoPersona());
            pst.setInt(8, tutor.getEstadoPersona());
            pst.setString(9, tutor.getCargoTutor());
            pst.setString(10, tutor.getFotoTutor());
            pst.setString(11, tutor.getFondoTutor());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error crear_tutor: " + ex);
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

}
