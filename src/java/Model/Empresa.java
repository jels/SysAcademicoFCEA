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
public class Empresa {

    private int idEmpresa;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    private String rubroEmpresa;
    private int idRepresentante;
    private int estadoEmpresa;

    public Empresa(int idEmpresa, String nombreEmpresa, String direccionEmpresa, String telefonoEmpresa, String rubroEmpresa, int idRepresentante, int estadoEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.rubroEmpresa = rubroEmpresa;
        this.idRepresentante = idRepresentante;
        this.estadoEmpresa = estadoEmpresa;
    }

    public Empresa() {
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

    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * @return the direccionEmpresa
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     * @param direccionEmpresa the direccionEmpresa to set
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     * @return the telefonoEmpresa
     */
    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    /**
     * @param telefonoEmpresa the telefonoEmpresa to set
     */
    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    /**
     * @return the rubroEmpresa
     */
    public String getRubroEmpresa() {
        return rubroEmpresa;
    }

    /**
     * @param rubroEmpresa the rubroEmpresa to set
     */
    public void setRubroEmpresa(String rubroEmpresa) {
        this.rubroEmpresa = rubroEmpresa;
    }

    /**
     * @return the idRepresentante
     */
    public int getIdRepresentante() {
        return idRepresentante;
    }

    /**
     * @param idRepresentante the idRepresentante to set
     */
    public void setIdRepresentante(int idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    /**
     * @return the estadoEmpresa
     */
    public int getEstadoEmpresa() {
        return estadoEmpresa;
    }

    /**
     * @param estadoEmpresa the estadoEmpresa to set
     */
    public void setEstadoEmpresa(int estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

}
