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
public class Tutor extends Persona {

    private String cargoTutor;
    private String fotoTutor;
    private String fondoTutor;
    private int idUsuario;

    public Tutor() {
    }

    public Tutor(String cargoTutor, String fotoTutor, String fondoTutor, int idUsuario, int idPersona, String primerNombrePersona, String primerApellidoPersona, String segundoNombrePersona, String segundoApellidoPersona, String ciPersona, String telefonoPersona, int estadoPersona) {
        super(idPersona, primerNombrePersona, primerApellidoPersona, segundoNombrePersona, segundoApellidoPersona, ciPersona, telefonoPersona, estadoPersona);
        this.cargoTutor = cargoTutor;
        this.fotoTutor = fotoTutor;
        this.fondoTutor = fondoTutor;
        this.idUsuario = idUsuario;
    }

    /**
     * @return the cargoTutor
     */
    public String getCargoTutor() {
        return cargoTutor;
    }

    /**
     * @param cargoTutor the cargoTutor to set
     */
    public void setCargoTutor(String cargoTutor) {
        this.cargoTutor = cargoTutor;
    }

    /**
     * @return the fotoTutor
     */
    public String getFotoTutor() {
        return fotoTutor;
    }

    /**
     * @param fotoTutor the fotoTutor to set
     */
    public void setFotoTutor(String fotoTutor) {
        this.fotoTutor = fotoTutor;
    }

    /**
     * @return the fondoTutor
     */
    public String getFondoTutor() {
        return fondoTutor;
    }

    /**
     * @param fondoTutor the fondoTutor to set
     */
    public void setFondoTutor(String fondoTutor) {
        this.fondoTutor = fondoTutor;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
