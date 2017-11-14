/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WarMachine
 */
public class Usuario_model extends Conexion {

    public boolean existencia(Usuario us) {

        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT nombreUsuario, passwordUsuario FROM usuarios WHERE nombreUsuario = ? AND passwordUsuario = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, us.getNombreUsuario());
            pst.setString(2, us.getPassUsuario());
            rs = pst.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            System.err.println("Error_existencia: " + ex);
            return false;
        }
    }

    public boolean existenciaUser(Usuario us) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT nombreUsuario FROM usuarios WHERE nombreUsuario = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, us.getNombreUsuario());
            rs = pst.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            System.err.println("Error_existencia: " + ex);
            return false;
        }
    }

    public boolean crear_usuario(Usuario us) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "INSERT INTO usuarios(nombreUsuario, passwordUsuario, idRol, imagenUsuario, fondoPerfilUser) "
                    + "VALUES (?,?,?,?,?)";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, us.getNombreUsuario());
            pst.setString(2, us.getPassUsuario());
            pst.setInt(3, us.getIdRol());
            pst.setString(4, us.getImagenUsuario());
            pst.setString(5, us.getFondoUsuario());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error_existencia: " + ex);
            return false;
        }

    }

    public boolean actualizar_usuario(Usuario user) {
        return false;
    }

    public int contar_usuario() {

        return 0;
    }

    public ArrayList<Usuario> ver_usuario() {
        return null;
    }

    public int encontrarID(Usuario us) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT idUsuario FROM usuarios WHERE nombreUsuario = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, us.getNombreUsuario());
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("ID usuario: " + rs.getInt(1));
                return rs.getInt(1);
            } else {
                return 0;
            }

        } catch (Exception ex) {
            System.err.println("Error encontrarID: " + ex);
            return 0;
        }
    }

    public String getRol(Usuario us) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT r.nombreRol FROM rol r, usuarios u WHERE r.idRol=u.idRol AND u.nombreUsuario = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, us.getNombreUsuario());
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("rol: " + rs.getString(1));
                return rs.getString(1);
            } else {
                return "";
            }

        } catch (Exception ex) {
            System.err.println("Error getRol: " + ex);
            return "";
        }
    }

    public ResultSet getDatosTutor(String user) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("id cons: " + user);
        try {
            String consulta = "SELECT u.imagenUsuario, u.fondoPerfilUser, u.nombreUsuario, "
                    + "t.primerNombreTutor, t.segundoNombreTutor, t.primerApellidoTutor, "
                    + "t.segundoApellidoTutor, t.cargoTutor "
                    + "FROM tutor t, usuarios u "
                    + "WHERE u.idUsuario=t.idUsuario "
                    + "AND u.nombreUsuario = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, user);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getDatosTutor: " + ex);
            return null;
        }
    }

    public ResultSet getDatosDocente(String user) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("id cons: " + user);
        try {
            String consulta = "SELECT u.imagenUsuario, u.fondoPerfilUser, "
                    + "u.nombreUsuario, d.primerNombreDocente, d.segundoNombreDocente, "
                    + "d.primerApellidoDocente, d.segundoApellidoDocente "
                    + "FROM docente d, usuarios u "
                    + "WHERE u.idUsuario=d.idUsuario "
                    + "AND u.nombreUsuario = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, user);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getDatosDocente: " + ex);
            return null;
        }
    }

}
