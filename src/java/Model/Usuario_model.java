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
            System.err.println("Error_existenciaUser: " + ex);
            return false;
        }
    }

    public boolean crear_usuario(Usuario us) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "INSERT INTO usuarios(nombreUsuario, passwordUsuario, idRol, imagenUsuario) "
                    + "VALUES (?,?,?,?)";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, us.getNombreUsuario());
            pst.setString(2, us.getPassUsuario());
            pst.setInt(3, us.getIdRol());
            pst.setString(4, us.getImagenUsuario());
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error_crear_usuario: " + ex);
            return false;
        }

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

    public boolean existenciaUserAC(Usuario us, int idUsuario) {

        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT nombreUsuario FROM usuarios WHERE nombreUsuario = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, us.getNombreUsuario());
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1) == idUsuario;
        } catch (Exception ex) {
            System.err.println("Error_ existenciaUserAC: " + ex);
            return false;
        }
    }

    public String getRol(Usuario us) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT r.nombreRol FROM rol r, usuarios u WHERE r.idRol = u.idRol AND u.nombreUsuario = ?";
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
            String consulta = "SELECT u.imagenUsuario, u.nombreUsuario, "
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
            String consulta = "SELECT u.imagenUsuario, "
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

    public ResultSet getDatosRoot(String user) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("id cons: " + user);
        try {
            String consulta = "SELECT imagenUsuario "
                    + "FROM usuarios "
                    + "WHERE nombreUsuario = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, user);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getDatosRoot: " + ex);
            return null;
        }
    }

    public boolean borrarUser(Usuario us) {
        PreparedStatement pst = null;
        int idUsuario = encontrarID(us);

        try {
            String consulta = "DELETE FROM usuarios WHERE idUsuario = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idUsuario);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error borrarUser: " + ex);
            return false;
        }
    }

    public int getIdRol(String rol) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("id cons: " + rol);
        try {
            String consulta = "SELECT idRol "
                    + "FROM rol "
                    + "WHERE nombreRol = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, rol);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (Exception ex) {
            System.err.println("Error getIdRol: " + ex);
            return 0;
        }
    }

    public void max_connections() {
        PreparedStatement pst;
        try {
            String consulta = "SET GLOBAL max_connections = 100000";
            pst = getConnection().prepareStatement(consulta);
            pst.executeQuery();
        } catch (Exception ex) {
            System.err.println("Error getIdRol: " + ex);
        }
    }

    public boolean actualizar_usuario(Usuario us) {
        int idUsuario = encontrarID(us);
        if (!existenciaUserAC(us, idUsuario)) {
            return false;
        } else {
            PreparedStatement pst;
            ResultSet rs;
            try {
                String consulta = "UPDATE usuarios "
                        + "SET nombreUsuario = ? , "
                        + "passwordUsuario = ? "
                        + "WHERE idUsuario = ? ";
                pst = getConnection().prepareStatement(consulta);
                pst.setString(1, us.getNombreUsuario());
                pst.setString(2, us.getPassUsuario());
                pst.setInt(3, idUsuario);
                return pst.executeUpdate() == 1;
            } catch (Exception ex) {
                System.err.println("Error actualizar_usuario: " + ex);
                return false;
            }
        }

    }

    public ResultSet getDatosUsuario(String usuario) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT u.nombreUsuario, u.passwordUsuario, "
                    + "u.imagenUsuario, t.primerNombreTutor, "
                    + "t.segundoNombreTutor, t.primerApellidoTutor, "
                    + "t.segundoApellidoTutor "
                    + "FROM usuarios u, tutor t "
                    + "WHERE u.idUsuario = t.idUsuario "
                    + "AND u.nombreUsuario = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getDatosUsuario: " + ex);
            return null;
        }
    }

    public boolean updateUser(Usuario us) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE usuarios "
                    + "SET passwordUsuario = ? "
                    + "WHERE nombreUsuario = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, us.getPassUsuario());
            pst.setString(2, us.getNombreUsuario());
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error updateUser: " + ex);
            return false;
        }
    }

}
