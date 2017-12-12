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
public class Docente_model extends Conexion {

    String texto;
    int numero;

    public boolean crear_docente(Docente doc) {
        return false;
    }

    public boolean actualizar_docente(Docente doc) {
        return false;
    }

    public int contar_docente() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idDocente) FROM docente WHERE estadoDocente = 1";
            pst = getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error contar_empresa: " + ex);
            return 0;
        }
    }

    public ResultSet ver_docente() {
        return null;
    }

    public int getIdDocente(String usuario) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT d.idDocente "
                    + "FROM usuarios u, docente d "
                    + "WHERE u.idUsuario = d.idUsuario "
                    + "AND u.nombreUsuario = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (Exception ex) {
            System.err.println("Error getIdDocente: " + ex);
            return 0;
        }
    }

    public String getNombreDocente(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT d.primerNombreDocente, d.segundoNombreDocente, "
                    + "d.primerApellidoDocente, d.segundoApellidoDocente "
                    + "FROM estudiante e, asignacionpracticas asp, docente d "
                    + "WHERE  e.idEstudiante = asp.idEstudiante "
                    + "AND d.idDocente = asp.idDocente "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1) + " " + rs.getString(2) + ", " + rs.getString(3) + " " + rs.getString(4);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getNombreDocente: " + ex);
            return texto;
        }
    }

}
