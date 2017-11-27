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
public class Materia {

    private int idMateria;
    private String nombreMateria;
    private String semestreMateria;
    private String descripcionMateria;
    private int horasPracticas;
    private int estadoMateria;
    private int idCarrera;

    public Materia(int idMateria, String nombreMateria, String semestreMateria, String descripcionMateria, int horasPracticas, int estadoMateria, int idCarrera) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.semestreMateria = semestreMateria;
        this.descripcionMateria = descripcionMateria;
        this.horasPracticas = horasPracticas;
        this.estadoMateria = estadoMateria;
        this.idCarrera = idCarrera;
    }

    public Materia() {
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

    /**
     * @return the nombreMateria
     */
    public String getNombreMateria() {
        return nombreMateria;
    }

    /**
     * @param nombreMateria the nombreMateria to set
     */
    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    /**
     * @return the semestreMateria
     */
    public String getSemestreMateria() {
        return semestreMateria;
    }

    /**
     * @param semestreMateria the semestreMateria to set
     */
    public void setSemestreMateria(String semestreMateria) {
        this.semestreMateria = semestreMateria;
    }

    /**
     * @return the descripcionMateria
     */
    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    /**
     * @param descripcionMateria the descripcionMateria to set
     */
    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    /**
     * @return the horasPracticas
     */
    public int getHorasPracticas() {
        return horasPracticas;
    }

    /**
     * @param horasPracticas the horasPracticas to set
     */
    public void setHorasPracticas(int horasPracticas) {
        this.horasPracticas = horasPracticas;
    }

    /**
     * @return the estadoMateria
     */
    public int getEstadoMateria() {
        return estadoMateria;
    }

    /**
     * @param estadoMateria the estadoMateria to set
     */
    public void setEstadoMateria(int estadoMateria) {
        this.estadoMateria = estadoMateria;
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

}
