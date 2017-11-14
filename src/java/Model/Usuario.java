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
public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String passUsuario;
    private int idRol;
    private String imagenUsuario;
    private String fondoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String passUsuario, int idRol, String imagenUsuario, String fondoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passUsuario = passUsuario;
        this.idRol = idRol;
        this.imagenUsuario = imagenUsuario;
        this.fondoUsuario = fondoUsuario;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the passUsuario
     */
    public String getPassUsuario() {
        return passUsuario;
    }

    /**
     * @param passUsuario the passUsuario to set
     */
    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    /**
     * @return the idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the imagenUsuario
     */
    public String getImagenUsuario() {
        return imagenUsuario;
    }

    /**
     * @param imagenUsuario the imagenUsuario to set
     */
    public void setImagenUsuario(String imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    /**
     * @return the fondoUsuario
     */
    public String getFondoUsuario() {
        return fondoUsuario;
    }

    /**
     * @param fondoUsuario the fondoUsuario to set
     */
    public void setFondoUsuario(String fondoUsuario) {
        this.fondoUsuario = fondoUsuario;
    }

}
