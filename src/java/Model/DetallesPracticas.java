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
public class DetallesPracticas {

    private int idDetallePracticas;
    private int idPracticas;
    private String tareaAsignada;
    private String observacionesTareas;

    public DetallesPracticas(int idDetallePracticas, int idPracticas, String tareaAsignada, String observacionesTareas) {
        this.idDetallePracticas = idDetallePracticas;
        this.idPracticas = idPracticas;
        this.tareaAsignada = tareaAsignada;
        this.observacionesTareas = observacionesTareas;
    }

    public DetallesPracticas() {
    }

    /**
     * @return the idDetallePracticas
     */
    public int getIdDetallePracticas() {
        return idDetallePracticas;
    }

    /**
     * @param idDetallePracticas the idDetallePracticas to set
     */
    public void setIdDetallePracticas(int idDetallePracticas) {
        this.idDetallePracticas = idDetallePracticas;
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
     * @return the tareaAsignada
     */
    public String getTareaAsignada() {
        return tareaAsignada;
    }

    /**
     * @param tareaAsignada the tareaAsignada to set
     */
    public void setTareaAsignada(String tareaAsignada) {
        this.tareaAsignada = tareaAsignada;
    }

    /**
     * @return the observacionesTareas
     */
    public String getObservacionesTareas() {
        return observacionesTareas;
    }

    /**
     * @param observacionesTareas the observacionesTareas to set
     */
    public void setObservacionesTareas(String observacionesTareas) {
        this.observacionesTareas = observacionesTareas;
    }

}
