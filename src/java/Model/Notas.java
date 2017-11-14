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
public class Notas {

    private int idNotas;
    private int idEstudiante;
    private int idCriterios;
    private int idMateria;
    private int nota;
    private int parcial;

    public Notas(int idNotas, int idEstudiante, int idCriterios, int idMateria, int nota, int parcial) {
        this.idNotas = idNotas;
        this.idEstudiante = idEstudiante;
        this.idCriterios = idCriterios;
        this.idMateria = idMateria;
        this.nota = nota;
        this.parcial = parcial;
    }

    public Notas() {
    }

    /**
     * @return the idNotas
     */
    public int getIdNotas() {
        return idNotas;
    }

    /**
     * @param idNotas the idNotas to set
     */
    public void setIdNotas(int idNotas) {
        this.idNotas = idNotas;
    }

    /**
     * @return the idEstudiante
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * @return the idCriterios
     */
    public int getIdCriterios() {
        return idCriterios;
    }

    /**
     * @param idCriterios the idCriterios to set
     */
    public void setIdCriterios(int idCriterios) {
        this.idCriterios = idCriterios;
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
     * @return the nota
     */
    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * @return the parcial
     */
    public int getParcial() {
        return parcial;
    }

    /**
     * @param parcial the parcial to set
     */
    public void setParcial(int parcial) {
        this.parcial = parcial;
    }

}
