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
public class Coordinador extends Persona {

    private String fotoCoordinador;

    public Coordinador(String fotoCoordinador, int idPersona, String primerNombrePersona, String primerApellidoPersona, String segundoNombrePersona, String segundoApellidoPersona, String ciPersona, String telefonoPersona, int estadoPersona) {
        super(idPersona, primerNombrePersona, primerApellidoPersona, segundoNombrePersona, segundoApellidoPersona, ciPersona, telefonoPersona, estadoPersona);
        this.fotoCoordinador = fotoCoordinador;
    }

    public Coordinador() {
    }

    /**
     * @return the fotoCoordinador
     */
    public String getFotoCoordinador() {
        return fotoCoordinador;
    }

    /**
     * @param fotoCoordinador the fotoCoordinador to set
     */
    public void setFotoCoordinador(String fotoCoordinador) {
        this.fotoCoordinador = fotoCoordinador;
    }

}
