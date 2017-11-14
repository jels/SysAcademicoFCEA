/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author WarMachine
 */
public class Practicas {

    private int idPracticas;
    private Date fechaInicioEvaluacion;
    private Date fechaFinEvaluacion;
    private String funcionPractica;
    private int cantidadHoras;
    private int idAsignacionPractica;

    public Practicas() {
    }

    public Practicas(int idPracticas, Date fechaInicioEvaluacion, Date fechaFinEvaluacion, String funcionPractica, int cantidadHoras, int idAsignacionPractica) {
        this.idPracticas = idPracticas;
        this.fechaInicioEvaluacion = fechaInicioEvaluacion;
        this.fechaFinEvaluacion = fechaFinEvaluacion;
        this.funcionPractica = funcionPractica;
        this.cantidadHoras = cantidadHoras;
        this.idAsignacionPractica = idAsignacionPractica;
    }

    /**
     * @return the idPracticas
     */
    public int getIdPracticas() {
        return idPracticas;
    }

    /**
     * @param idPracticas the idPracticas to set
     */
    public void setIdPracticas(int idPracticas) {
        this.idPracticas = idPracticas;
    }

    /**
     * @return the fechaInicioEvaluacion
     */
    public Date getFechaInicioEvaluacion() {
        return fechaInicioEvaluacion;
    }

    /**
     * @param fechaInicioEvaluacion the fechaInicioEvaluacion to set
     */
    public void setFechaInicioEvaluacion(Date fechaInicioEvaluacion) {
        this.fechaInicioEvaluacion = fechaInicioEvaluacion;
    }

    /**
     * @return the fechaFinEvaluacion
     */
    public Date getFechaFinEvaluacion() {
        return fechaFinEvaluacion;
    }

    /**
     * @param fechaFinEvaluacion the fechaFinEvaluacion to set
     */
    public void setFechaFinEvaluacion(Date fechaFinEvaluacion) {
        this.fechaFinEvaluacion = fechaFinEvaluacion;
    }

    /**
     * @return the funcionPractica
     */
    public String getFuncionPractica() {
        return funcionPractica;
    }

    /**
     * @param funcionPractica the funcionPractica to set
     */
    public void setFuncionPractica(String funcionPractica) {
        this.funcionPractica = funcionPractica;
    }

    /**
     * @return the cantidadHoras
     */
    public int getCantidadHoras() {
        return cantidadHoras;
    }

    /**
     * @param cantidadHoras the cantidadHoras to set
     */
    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
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

}
