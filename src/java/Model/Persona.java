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
public class Persona {

    private int idPersona;
    private String primerNombrePersona;
    private String primerApellidoPersona;
    private String segundoNombrePersona;
    private String segundoApellidoPersona;
    private String ciPersona;
    private String telefonoPersona;
    private int estadoPersona;

    public Persona(int idPersona, String primerNombrePersona, String primerApellidoPersona, String segundoNombrePersona, String segundoApellidoPersona, String ciPersona, String telefonoPersona, int estadoPersona) {
        this.idPersona = idPersona;
        this.primerNombrePersona = primerNombrePersona;
        this.primerApellidoPersona = primerApellidoPersona;
        this.segundoNombrePersona = segundoNombrePersona;
        this.segundoApellidoPersona = segundoApellidoPersona;
        this.ciPersona = ciPersona;
        this.telefonoPersona = telefonoPersona;
        this.estadoPersona = estadoPersona;
    }

    public Persona() {
    }

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the primerNombrePersona
     */
    public String getPrimerNombrePersona() {
        return primerNombrePersona;
    }

    /**
     * @param primerNombrePersona the primerNombrePersona to set
     */
    public void setPrimerNombrePersona(String primerNombrePersona) {
        this.primerNombrePersona = primerNombrePersona;
    }

    /**
     * @return the primerApellidoPersona
     */
    public String getPrimerApellidoPersona() {
        return primerApellidoPersona;
    }

    /**
     * @param primerApellidoPersona the primerApellidoPersona to set
     */
    public void setPrimerApellidoPersona(String primerApellidoPersona) {
        this.primerApellidoPersona = primerApellidoPersona;
    }

    /**
     * @return the segundoNombrePersona
     */
    public String getSegundoNombrePersona() {
        return segundoNombrePersona;
    }

    /**
     * @param segundoNombrePersona the segundoNombrePersona to set
     */
    public void setSegundoNombrePersona(String segundoNombrePersona) {
        this.segundoNombrePersona = segundoNombrePersona;
    }

    /**
     * @return the segundoApellidoPersona
     */
    public String getSegundoApellidoPersona() {
        return segundoApellidoPersona;
    }

    /**
     * @param segundoApellidoPersona the segundoApellidoPersona to set
     */
    public void setSegundoApellidoPersona(String segundoApellidoPersona) {
        this.segundoApellidoPersona = segundoApellidoPersona;
    }

    /**
     * @return the ciPersona
     */
    public String getCiPersona() {
        return ciPersona;
    }

    /**
     * @param ciPersona the ciPersona to set
     */
    public void setCiPersona(String ciPersona) {
        this.ciPersona = ciPersona;
    }

    /**
     * @return the telefonoPersona
     */
    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    /**
     * @param telefonoPersona the telefonoPersona to set
     */
    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    /**
     * @return the estadoPersona
     */
    public int getEstadoPersona() {
        return estadoPersona;
    }

    /**
     * @param estadoPersona the estadoPersona to set
     */
    public void setEstadoPersona(int estadoPersona) {
        this.estadoPersona = estadoPersona;
    }

}
