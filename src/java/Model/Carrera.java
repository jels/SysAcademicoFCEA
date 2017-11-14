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
public class Carrera {

    private int idCarrera;
    private String nombreCarrera;
    private String abreviaturaCarrera;
    private String descripcionCarrera;
    private int estadoCarrera;
    private int idFacultad;
    private int idCoordinador;

    public Carrera(int idCarrera, String nombreCarrera, String abreviaturaCarrera, String descripcionCarrera, int estadoCarrera, int idFacultad, int idCoordinador) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.abreviaturaCarrera = abreviaturaCarrera;
        this.descripcionCarrera = descripcionCarrera;
        this.estadoCarrera = estadoCarrera;
        this.idFacultad = idFacultad;
        this.idCoordinador = idCoordinador;
    }

    public Carrera() {
    }

    /**
     * @return the idCarrera
     */
    public int getIdCarrera() {
        return idCarrera;
    }

    /**
     * @param idCarrera the idCarrera to set
     */
    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    /**
     * @return the nombreCarrera
     */
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    /**
     * @param nombreCarrera the nombreCarrera to set
     */
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    /**
     * @return the abreviaturaCarrera
     */
    public String getAbreviaturaCarrera() {
        return abreviaturaCarrera;
    }

    /**
     * @param abreviaturaCarrera the abreviaturaCarrera to set
     */
    public void setAbreviaturaCarrera(String abreviaturaCarrera) {
        this.abreviaturaCarrera = abreviaturaCarrera;
    }

    /**
     * @return the descripcionCarrera
     */
    public String getDescripcionCarrera() {
        return descripcionCarrera;
    }

    /**
     * @param descripcionCarrera the descripcionCarrera to set
     */
    public void setDescripcionCarrera(String descripcionCarrera) {
        this.descripcionCarrera = descripcionCarrera;
    }

    /**
     * @return the estadoCarrera
     */
    public int getEstadoCarrera() {
        return estadoCarrera;
    }

    /**
     * @param estadoCarrera the estadoCarrera to set
     */
    public void setEstadoCarrera(int estadoCarrera) {
        this.estadoCarrera = estadoCarrera;
    }

    /**
     * @return the idFacultad
     */
    public int getIdFacultad() {
        return idFacultad;
    }

    /**
     * @param idFacultad the idFacultad to set
     */
    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    /**
     * @return the idCoordinador
     */
    public int getIdCoordinador() {
        return idCoordinador;
    }

    /**
     * @param idCoordinador the idCoordinador to set
     */
    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

}
