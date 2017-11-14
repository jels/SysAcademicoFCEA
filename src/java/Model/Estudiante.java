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
public class Estudiante extends Persona {

    private String fotoEstudiante;

    public Estudiante(String fotoEstudiante, int idPersona, String primerNombrePersona, String primerApellidoPersona, String segundoNombrePersona, String segundoApellidoPersona, String ciPersona, String telefonoPersona, int estadoPersona) {
        super(idPersona, primerNombrePersona, primerApellidoPersona, segundoNombrePersona, segundoApellidoPersona, ciPersona, telefonoPersona, estadoPersona);
        this.fotoEstudiante = fotoEstudiante;
    }

    public Estudiante() {
    }

    public String getFotoEstudiante() {
        return fotoEstudiante;
    }

    public void setFotoEstudiante(String fotoEstudiante) {
        this.fotoEstudiante = fotoEstudiante;
    }

}
