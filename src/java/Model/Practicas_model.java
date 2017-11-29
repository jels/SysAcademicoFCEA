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
public class Practicas_model extends Conexion {

    public boolean new_Practica(Practicas practica) {

        PreparedStatement pst = null;

        try {
            String consulta = "INSERT INTO practicas "
                    + "(idAsignacionPractica, fechaInicioEvaluacion, "
                    + "fechaFinEvaluacion, funcionPractica, "
                    + "cantidadHoras, observacionEstudiante) "
                    + "VALUES ( ? , ? , ? , ? , ? , ? )";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, practica.getIdAsignacionPractica());
            pst.setString(2, practica.getFechaInicioEvaluacion());
            pst.setString(3, practica.getFechaFinEvaluacion());
            pst.setString(4, practica.getFuncionPractica());
            pst.setInt(5, practica.getCantidadHoras());
            pst.setString(6, practica.getObservacionEstudiante());
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error new_Practica: " + ex);
            return false;
        }

    }

    public int getExistenciadeRegistros(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(p.idPracticas) "
                    + "FROM practicas p, asignacionpracticas asp, estudiante e "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error getExistenciadeRegistros: " + ex);
            return 0;
        }
    }

    public ResultSet parcialesActivos() {
        PreparedStatement pst = null;
        ResultSet parciales = null;
        try {
            String consulta = "SELECT idParcial "
                    + "FROM parcial "
                    + "WHERE estadoParcial = 1 ";
            pst = getConnection().prepareStatement(consulta);
            parciales = pst.executeQuery();
            return parciales;
        } catch (Exception ex) {
            System.err.println("Error parcialesActivos: " + ex);
            return null;
        }
    }

    public int contar_parciales() {
        PreparedStatement pst = null;
        ResultSet parciales = null;
        try {
            String consulta = "SELECT COUNT(idParcial) "
                    + "FROM parcial ";
            pst = getConnection().prepareStatement(consulta);
            parciales = pst.executeQuery();
            parciales.next();
            return parciales.getInt(1);
        } catch (Exception ex) {
            System.err.println("Error contar_parciales: " + ex);
            return 0;
        }
    }

    public int contar_parciales_estado(int estado) {
        PreparedStatement pst = null;
        ResultSet parciales = null;
        try {
            String consulta = "SELECT COUNT(idParcial) "
                    + "FROM parcial "
                    + "WHERE estadoParcial = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            parciales = pst.executeQuery();
            parciales.next();
            return parciales.getInt(1);
        } catch (Exception ex) {
            System.err.println("Error contar_parciales_estado: " + ex);
            return 0;
        }
    }

    public ResultSet verParciales() {

        PreparedStatement pst = null;
        ResultSet parciales = null;
        try {
            String consulta = "SELECT idParcial, estadoParcial, nombreParcial "
                    + "FROM parcial ";
            pst = getConnection().prepareStatement(consulta);
            parciales = pst.executeQuery();
            return parciales;
        } catch (Exception ex) {
            System.err.println("Error verParciales: " + ex);
            return null;
        }
    }

    public int getEstadoParcial(int idParcial) {
        PreparedStatement pst = null;
        ResultSet parciales = null;
        try {
            String consulta = "SELECT estadoParcial "
                    + "FROM parcial "
                    + "WHERE idParcial = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idParcial);
            parciales = pst.executeQuery();
            parciales.next();
            return parciales.getInt(1);
        } catch (Exception ex) {
            System.err.println("Error getEstadoParcial: " + ex);
            return 0;
        }
    }

    public boolean actualizarParcial(int idParcial, int estado) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE parcial "
                    + "SET estadoParcial = ? "
                    + "WHERE idParcial = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            pst.setInt(2, idParcial);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error actualizarParcial: " + ex);
            return false;
        }
    }

}
