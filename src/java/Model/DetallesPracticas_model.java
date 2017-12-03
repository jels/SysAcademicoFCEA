/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;

/**
 *
 * @author WarMachine
 */
public class DetallesPracticas_model extends Conexion {

    public boolean nuevoDetalle(DetallesPracticas detalle) {

        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO detallepracticas "
                    + "(idPracticas, tareaAsignada, observacionTarea) "
                    + "VALUES ( ? , ? , ? )";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, detalle.getIdPracticas());
            pst.setString(2, detalle.getTareaAsignada());
            pst.setString(3, detalle.getObservacionesTareas());
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error nuevoDetalle: " + ex);
            return false;
        }
    }

}
