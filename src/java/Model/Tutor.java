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
    private int idUsuario;
    private int idEmpresa;

    public Tutor(String cargoTutor, String fotoTutor, int idUsuario, int idEmpresa, int idPersona, String primerNombrePersona, String primerApellidoPersona, String segundoNombrePersona, String segundoApellidoPersona, String ciPersona, String telefonoPersona, int estadoPersona) {
        super(idPersona, primerNombrePersona, primerApellidoPersona, segundoNombrePersona, segundoApellidoPersona, ciPersona, telefonoPersona, estadoPersona);
        this.cargoTutor = cargoTutor;
        this.fotoTutor = fotoTutor;
        this.idUsuario = idUsuario;
        this.idEmpresa = idEmpresa;
    }

    public Tutor() {
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

    /**
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

}
