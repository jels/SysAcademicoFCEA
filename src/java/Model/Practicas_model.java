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

    int numero;
    String texto;

    public boolean new_Practica(Practicas practica) {

        PreparedStatement pst = null;

        try {
            String consulta = "INSERT INTO practicas "
                    + "(idAsignacionPractica, fechaInicioEvaluacion, "
                    + "fechaFinEvaluacion, funcionPractica, "
                    + "cantidadHoras, observacionEstudiante, idParcial) "
                    + "VALUES ( ? , ? , ? , ? , ? , ? , ? )";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, practica.getIdAsignacionPractica());
            pst.setString(2, practica.getFechaInicioEvaluacion());
            pst.setString(3, practica.getFechaFinEvaluacion());
            pst.setString(4, practica.getFuncionPractica());
            pst.setInt(5, practica.getCantidadHoras());
            pst.setString(6, practica.getObservacionEstudiante());
            pst.setInt(7, practica.getIdParcial());
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error new_Practica: " + ex);
            return false;
        }

    }

    public int getExistenciadeRegistros(String CI_estudiante, int parcial) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(p.idPracticas) "
                    + "FROM practicas p, asignacionpracticas asp, estudiante e "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND asp.estadoPractica = 1 "
                    + "AND p.idParcial = ? "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, parcial);
            pst.setString(2, CI_estudiante);
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

    public ResultSet getDatosPracticaEstudiante(String CI_estudiante, int idPractica) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT p.idPracticas, p.fechaInicioEvaluacion, "
                    + "p.fechaFinEvaluacion, p.funcionPractica, "
                    + "p.cantidadHoras, p.observacionEstudiante "
                    + "FROM practicas p, asignacionpracticas asp, estudiante e "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND asp.estadoPractica = 1 "
                    + "AND p.idParcial = ? "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idPractica);
            pst.setString(2, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getDatosPractica: " + ex);
            return null;
        }
    }

    public boolean activoParcial(int idParcial) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT estadoParcial "
                    + "FROM parcial "
                    + "WHERE idParcial = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idParcial);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1) == 1;

        } catch (Exception ex) {
            System.err.println("Error activoParcial: " + ex);
            return false;
        }
    }

    public ResultSet getDetallesPractica(String CI_estudiante, int idPractica) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT det.idDetalles, "
                    + "det.tareaAsignada, det.observacionTarea "
                    + "FROM asignacionpracticas asp, estudiante e, "
                    + "practicas p, detallepracticas det "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND p.idPracticas = det.idPracticas "
                    + "AND asp.estadoPractica = 1 "
                    + "AND p.idParcial = ? "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idPractica);
            pst.setString(2, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getDetallesPractica: " + ex);
            return null;
        }
    }

    public boolean eliminarPractica(int idPractica) {
        PreparedStatement pst = null;
        try {
            String consulta = "DELETE FROM practicas WHERE idPracticas = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idPractica);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error eliminarPractica: " + ex);
            return false;
        }
    }

    public boolean eliminarDetalle(int idDetalle) {
        PreparedStatement pst = null;
        try {
            String consulta = "DELETE FROM detallepracticas WHERE idDetalles = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idDetalle);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error eliminarPractica: " + ex);
            return false;
        }
    }

    public boolean existeRegistroParcial(int parcial, String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(p.idPracticas) "
                    + "FROM practicas p, asignacionpracticas asp, estudiante e "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND asp.estadoPractica = 1 "
                    + "AND p.idParcial = ? "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, parcial);
            pst.setString(2, CI_estudiante);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 1;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error getExistenciadeRegistros: " + ex);
            return false;
        }
    }

    public int getIdPractica(String CI_estudiante, int parcial) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT p.idPracticas "
                    + "FROM practicas p, asignacionpracticas asp, estudiante e "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND asp.estadoPractica = 1 "
                    + "AND p.idParcial = ? "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, parcial);
            pst.setString(2, CI_estudiante);
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

    public boolean getRealizaPractica(String CI_estudiante) {

        return false;
    }

    public String getTotalHors(String CI_estudiante, int parcial) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT p.cantidadHoras "
                    + "FROM estudiante e, asignacionpracticas asp, practicas p "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND p.idParcial = ? "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, parcial);
            pst.setString(2, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getTotalHors: " + ex);
            return texto;
        }
    }

}
