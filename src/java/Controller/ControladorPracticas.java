/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;

/**
 *
 * @author WarMachine
 */
public class ControladorPracticas extends Conexion {

    boolean bandera;
    Practicas_model praMo = new Practicas_model();

    public boolean realizaPractica(String CI_estudiante) {
        bandera = praMo.getRealizaPractica(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en realizaPractica: " + e);
        }
        return bandera;
    }

}
