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
public class AsignacionPracticas_model extends Conexion {

    public boolean newPractica(AsignacionPracticas as) {
        
        
        return false;
    }

    public int getIDMateria(String CI_estudiante) {
        return 0;
    }

    public int getIdAsignacionPractica(String CI_Estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.idMateria "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ?";
            pst = getConnection().prepareStatement(consulta);
            System.out.println("CI: " + CI_Estudiante);
            pst.setString(1, CI_Estudiante);
            rs = pst.executeQuery();
            rs.next();
            System.out.println("idMateria: " + rs.getInt(1));
            return rs.getInt(1);

        } catch (Exception ex) {
            System.err.println("Error getIdAsignacionPractica: " + ex);
            return 0;
        }

    }

}
