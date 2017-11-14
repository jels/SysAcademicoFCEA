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
public class Dimension {

    private int idDimension;
    private String nombreDimension;
    private int estadoDimension;
    private int idMateria;

    public Dimension(int idDimension, String nombreDimension, int estadoDimension, int idMateria) {
        this.idDimension = idDimension;
        this.nombreDimension = nombreDimension;
        this.estadoDimension = estadoDimension;
        this.idMateria = idMateria;
    }

    public Dimension() {
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

    /**
     * @return the nombreDimension
     */
    public String getNombreDimension() {
        return nombreDimension;
    }

    /**
     * @param nombreDimension the nombreDimension to set
     */
    public void setNombreDimension(String nombreDimension) {
        this.nombreDimension = nombreDimension;
    }

    /**
     * @return the estadoDimension
     */
    public int getEstadoDimension() {
        return estadoDimension;
    }

    /**
     * @param estadoDimension the estadoDimension to set
     */
    public void setEstadoDimension(int estadoDimension) {
        this.estadoDimension = estadoDimension;
    }

    /**
     * @return the idMateria
     */
    public int getIdMateria() {
        return idMateria;
    }

    /**
     * @param idMateria the idMateria to set
     */
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

}
