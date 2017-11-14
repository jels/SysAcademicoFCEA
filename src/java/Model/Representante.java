/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author WarMachine
 */
public class Representante {

    private Persona representante;
    private String cargoRepresentante;

    public Representante() {
    }

    public Representante(Persona representante, String cargoRepresentante) {
        this.representante = representante;
        this.cargoRepresentante = cargoRepresentante;
    }

    /**
     * @return the representante
     */
    public Persona getRepresentante() {
        return representante;
    }

    /**
     * @param representante the representante to set
     */
    public void setRepresentante(Persona representante) {
        this.representante = representante;
    }

    /**
     * @return the cargoRepresentante
     */
    public String getCargoRepresentante() {
        return cargoRepresentante;
    }

    /**
     * @param cargoRepresentante the cargoRepresentante to set
     */
    public void setCargoRepresentante(String cargoRepresentante) {
        this.cargoRepresentante = cargoRepresentante;
    }

}
