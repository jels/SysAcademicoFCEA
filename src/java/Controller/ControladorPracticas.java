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
    Notas_model notMo = new Notas_model();
    AsignacionPracticas_model aspMo = new AsignacionPracticas_model();

    public boolean realizaPractica(String CI_estudiante) {
        bandera = praMo.getRealizaPractica(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en realizaPractica: " + e);
        }
        return bandera;
    }

    public boolean activoParcial(int parcial) {
        bandera = praMo.activoParcial(parcial);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en activoParcial: " + e);
        }
        return bandera;
    }

    public boolean activoConstancia(String CI_estudiante) {
        try {
            if (praMo.activoParcial(3) && notMo.llenoPrimerParcial(CI_estudiante) && notMo.llenoSegundoParcial(CI_estudiante)) {
                bandera = true;
            } else {
                bandera = false;
            }
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en activoConstancia: " + e);
        }
        return bandera;
    }

    public boolean aprobarEstudiante(String CI_estudiante) {
        bandera = aspMo.aprobar(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en aprobarEstudiante: " + e);
        }
        return bandera;
    }
    
    public boolean reprobarEstudiante(String CI_estudiante) {
        bandera = aspMo.reprobo(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en reprobarEstudiante: " + e);
        }
        return bandera;
    }
    
    public boolean cambiarEstadoPracticas(String CI_estudiante) {
        bandera = aspMo.finalizar(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cambiarEstadoPracticas: " + e);
        }
        return bandera;
    }

}
