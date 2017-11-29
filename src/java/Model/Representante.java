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
public class Representante extends Persona {

    private String cargoRepresentante;

    public Representante(String cargoRepresentante, int idPersona, String primerNombrePersona, String primerApellidoPersona, String segundoNombrePersona, String segundoApellidoPersona, String ciPersona, String telefonoPersona, int estadoPersona) {
        super(idPersona, primerNombrePersona, primerApellidoPersona, segundoNombrePersona, segundoApellidoPersona, ciPersona, telefonoPersona, estadoPersona);
        this.cargoRepresentante = cargoRepresentante;
    }

    public Representante() {
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
