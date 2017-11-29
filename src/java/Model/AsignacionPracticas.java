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
public class AsignacionPracticas {

    private int idAsignacionPractica;
    private String ingresoEstudiante;
    private String gestionAcademica;
    private String fechaInicioPractica;
    private String fechaFinPractica;
    private String areaPactica;
    private int totalHoras;
    private int idDocente;
    private int idEstudiante;
    private int idTutor;
    private int idMateria;

    public AsignacionPracticas(int idAsignacionPractica, String ingresoEstudiante, String gestionAcademica, String fechaInicioPractica, String fechaFinPractica, String areaPactica, int totalHoras, int idDocente, int idEstudiante, int idTutor, int idMateria) {
        this.idAsignacionPractica = idAsignacionPractica;
        this.ingresoEstudiante = ingresoEstudiante;
        this.gestionAcademica = gestionAcademica;
        this.fechaInicioPractica = fechaInicioPractica;
        this.fechaFinPractica = fechaFinPractica;
        this.areaPactica = areaPactica;
        this.totalHoras = totalHoras;
        this.idDocente = idDocente;
        this.idEstudiante = idEstudiante;
        this.idTutor = idTutor;
        this.idMateria = idMateria;
    }

    public AsignacionPracticas() {
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
     * @return the ingresoEstudiante
     */
    public String getIngresoEstudiante() {
        return ingresoEstudiante;
    }

    /**
     * @param ingresoEstudiante the ingresoEstudiante to set
     */
    public void setIngresoEstudiante(String ingresoEstudiante) {
        this.ingresoEstudiante = ingresoEstudiante;
    }

    /**
     * @return the gestionAcademica
     */
    public String getGestionAcademica() {
        return gestionAcademica;
    }

    /**
     * @param gestionAcademica the gestionAcademica to set
     */
    public void setGestionAcademica(String gestionAcademica) {
        this.gestionAcademica = gestionAcademica;
    }

    /**
     * @return the fechaInicioPractica
     */
    public String getFechaInicioPractica() {
        return fechaInicioPractica;
    }

    /**
     * @param fechaInicioPractica the fechaInicioPractica to set
     */
    public void setFechaInicioPractica(String fechaInicioPractica) {
        this.fechaInicioPractica = fechaInicioPractica;
    }

    /**
     * @return the fechaFinPractica
     */
    public String getFechaFinPractica() {
        return fechaFinPractica;
    }

    /**
     * @param fechaFinPractica the fechaFinPractica to set
     */
    public void setFechaFinPractica(String fechaFinPractica) {
        this.fechaFinPractica = fechaFinPractica;
    }

    /**
     * @return the areaPactica
     */
    public String getAreaPactica() {
        return areaPactica;
    }

    /**
     * @param areaPactica the areaPactica to set
     */
    public void setAreaPactica(String areaPactica) {
        this.areaPactica = areaPactica;
    }

    /**
     * @return the totalHoras
     */
    public int getTotalHoras() {
        return totalHoras;
    }

    /**
     * @param totalHoras the totalHoras to set
     */
    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    /**
     * @return the idDocente
     */
    public int getIdDocente() {
        return idDocente;
    }

    /**
     * @param idDocente the idDocente to set
     */
    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
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
     * @return the idTutor
     */
    public int getIdTutor() {
        return idTutor;
    }

    /**
     * @param idTutor the idTutor to set
     */
    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
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
