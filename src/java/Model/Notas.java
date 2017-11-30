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
    private int idAsignacionPractica;
    private int idCriterios;
    private int nota;
    private int idParcial;

    public Notas(int idNotas, int idAsignacionPractica, int idCriterios, int nota, int idParcial) {
        this.idNotas = idNotas;
        this.idAsignacionPractica = idAsignacionPractica;
        this.idCriterios = idCriterios;
        this.nota = nota;
        this.idParcial = idParcial;
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
     * @return the idAsignacionPractica
     */
    public int getIdAsignacionPractica() {
        return idAsignacionPractica;
    }

    /**
     * @param idAsignacionPractica the idAsignacionPractica to set
     */
    public void setIdAsignacionPractica(int idAsignacionPractica) {
        this.idAsignacionPractica = idAsignacionPractica;
    }

    /**
     * @return the idCriterio
     */
    public int getIdCriterios() {
        return idCriterios;
    }

    /**
     * @param idCriterios the idCriterio to set
     */
    public void setIdCriterios(int idCriterios) {
        this.idCriterios = idCriterios;
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
     * @return the idParcial
     */
    public int getIdParcial() {
        return idParcial;
    }

    /**
     * @param idParcial the parcial to set
     */
    public void setIdParcial(int idParcial) {
        this.idParcial = idParcial;
    }

}
