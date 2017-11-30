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
public class Carrera_model extends Conexion {

    public int contar_carrera(int idFacultad) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idCarrera) FROM carrera WHERE estadoCarrera = 1 AND idFacultad = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idFacultad);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error contar_carrera: " + ex);
            return 0;
        }
    }

    public int findIdCarrera(String abreviatura) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT idCarrera "
                    + "FROM carrera "
                    + "WHERE abreviaturaCarrera = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, abreviatura);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error findIdCarrera: " + ex);
            return 0;
        }
    }

    public ResultSet getCarreras(int idFacultad) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT c.idCarrera, c.nombreCarrera, c.abreviaturaCarrera, "
                    + "c.descripcionCarrera, c.estadoCarrera "
                    + "FROM carrera c, facultad f "
                    + "WHERE f.idFacultad = c.idFacultad "
                    + "AND f.idFacultad = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idFacultad);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            System.err.println("Error contar_carrera: " + ex);
            return null;
        }
    }

    public String getNombreCarrera(String abreviatura) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT nombreCarrera "
                    + "FROM carrera "
                    + "WHERE abreviaturaCarrera = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, abreviatura);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return "";
            }
        } catch (Exception ex) {
            System.err.println("Error getNombreCarrera: " + ex);
            return "";
        }

    }

    public String getNombreCoordinador(String abreviatura) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nombreCoordinador = "";
        try {
            String consulta = "SELECT c.primerNombreCoordinador, c.segundoNombreCoordinador, "
                    + "c.primerApellidoCoordinador, c.segundoApellidoCoordinador "
                    + "FROM coordinador c, carrera car "
                    + "WHERE c.idCoordinador = car.idCoordinador "
                    + "AND car.abreviaturaCarrera = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, abreviatura);
            rs = pst.executeQuery();
            if (rs.next()) {
                nombreCoordinador = rs.getString(3) + " " + rs.getString(4) + ", " + rs.getString(1) + " " + rs.getString(2);
                return nombreCoordinador;
            } else {
                return nombreCoordinador;
            }
        } catch (Exception ex) {
            System.err.println("Error getNombreCoordinador: " + ex);
            return nombreCoordinador;
        }

    }

    public String getFotoCoordinador(String abreviatura) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT c.fotoCoordinador "
                    + "FROM coordinador c, carrera car "
                    + "WHERE c.idCoordinador = car.idCoordinador "
                    + "AND car.estadoCarrera = 1 "
                    + "AND car.abreviaturaCarrera = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, abreviatura);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return "";
            }
        } catch (Exception ex) {
            System.err.println("Error getFotoCoordinador: " + ex);
            return "";
        }

    }

    public boolean nuevaCarrera(Carrera carrera) {
        PreparedStatement pst;
        ResultSet rs;
        if (existeCarrera(carrera.getAbreviaturaCarrera())) { //como no existe entra en la funcion crear carrera...
            try {
                String consulta = "INSERT INTO carrera "
                        + "(idFacultad, idCoordinador, "
                        + "nombreCarrera, abreviaturaCarrera, "
                        + "descripcionCarrera, estadoCarrera) "
                        + "VALUES ( ? , ? , ? , ? , ? , ? )";
                pst = getConnection().prepareStatement(consulta);
                pst.setInt(1, carrera.getIdFacultad());
                pst.setInt(2, carrera.getIdCoordinador());
                pst.setString(3, carrera.getNombreCarrera());
                pst.setString(4, carrera.getAbreviaturaCarrera());
                pst.setString(5, carrera.getDescripcionCarrera());
                pst.setInt(6, carrera.getEstadoCarrera());
                return pst.executeUpdate() == 1;

            } catch (Exception ex) {
                System.err.println("Error nuevaCarrera: " + ex);
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean existeCarrera(String abreviatura) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT COUNT(idCarrera) "
                    + "FROM carrera "
                    + "WHERE abreviaturaCarrera = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, abreviatura);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1) == 0;//quiere decir que no existe el carrera...
        } catch (Exception ex) {
            System.err.println("Error existeCarrera: " + ex);
            return false;
        }
    }

    public boolean baja_carrera(String abreviatura, int estado) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE carrera "
                    + "SET estadoCarrera = ? "
                    + "WHERE abreviaturaCarrera = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            pst.setString(2, abreviatura);
            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error baja_carrera: " + ex);
            return false;
        }
    }

    public int getEstadoCarrera(String abreviatura) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT estadoCarrera "
                    + "FROM carrera "
                    + "WHERE abreviaturaCarrera = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, abreviatura);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);//quiere decir que no existe el carrera...
        } catch (Exception ex) {
            System.err.println("Error getEstadoCarrera: " + ex);
            return 0;
        }
    }

    public ResultSet getDatosCarrera(String carrera) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT c.idCoordinador, c.primerNombreCoordinador, "
                    + "c.segundoNombreCoordinador, c.primerApellidoCoordinador, "
                    + "c.segundoApellidoCoordinador, c.ciCoordinador, "
                    + "c.telefonoCoordinador, c.fotoCoordinador, ca.nombreCarrera, "
                    + "ca.abreviaturaCarrera, ca.descripcionCarrera, ca.idCarrera "
                    + "FROM coordinador c, carrera ca "
                    + "WHERE c.idCoordinador = ca.idCoordinador "
                    + "AND ca.abreviaturaCarrera = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, carrera);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            System.err.println("Error getDatosCarrera: " + ex);
            return null;
        }

    }

    public boolean updateCarrera(Carrera carrera) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "UPDATE carrera "
                    + "SET nombreCarrera = ? ,"
                    + "abreviaturaCarrera = ? ,"
                    + "descripcionCarrera = ? "
                    + "WHERE idCarrera = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, carrera.getNombreCarrera());
            pst.setString(2, carrera.getAbreviaturaCarrera());
            pst.setString(3, carrera.getDescripcionCarrera());
            pst.setInt(4, carrera.getIdCarrera());

            return pst.executeUpdate() == 1;

        } catch (Exception ex) {
            System.err.println("Error updateCarrera: " + ex);
            return false;
        }
    }

}
