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
public class Criterios {

    private int idCriterio;
    private String nombreCriterio;
    private int estadoCriterio;
    private int idDimension;

    public Criterios(int idCriterio, String nombreCriterio, int estadoCriterio, int idDimension) {
        this.idCriterio = idCriterio;
        this.nombreCriterio = nombreCriterio;
        this.estadoCriterio = estadoCriterio;
        this.idDimension = idDimension;
    }

    public Criterios() {
    }

    /**
     * @return the idCriterio
     */
    public int getIdCriterio() {
        return idCriterio;
    }

    /**
     * @param idCriterio the idCriterio to set
     */
    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    /**
     * @return the nombreCriterio
     */
    public String getNombreCriterio() {
        return nombreCriterio;
    }

    /**
     * @param nombreCriterio the nombreCriterio to set
     */
    public void setNombreCriterio(String nombreCriterio) {
        this.nombreCriterio = nombreCriterio;
    }

    /**
     * @return the estadoCriterio
     */
    public int getEstadoCriterio() {
        return estadoCriterio;
    }

    /**
     * @param estadoCriterio the estadoCriterio to set
     */
    public void setEstadoCriterio(int estadoCriterio) {
        this.estadoCriterio = estadoCriterio;
    }

    /**
     * @return the idDimension
     */
    public int getIdDimension() {
        return idDimension;
    }

    /**
     * @param idDimension the idDimension to set
     */
    public void setIdDimension(int idDimension) {
        this.idDimension = idDimension;
    }

}
