/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;

/**
 *
 * @author WarMachine
 */
public class ControladorNotas extends Conexion {

    public boolean nuevaNota(String CI_estudiante, int puntaje) {

        Notas nota = new Notas();
        Estudiante_model estMo = new Estudiante_model();
        int idEstudiante = estMo.getIDEstudiante(CI_estudiante);
        AsignacionPracticas_model aspMo = new AsignacionPracticas_model();
        int idMateria = aspMo.getIDMateria(CI_estudiante);
        Notas_model notMo = new Notas_model();
        int parcial = notMo.getParcial(CI_estudiante);
        ResultSet criterios;
        Criterios_model criMo = new Criterios_model();
        int indice = 1;
        nota.setIdEstudiante(idEstudiante);
        nota.setIdMateria(idMateria);
        nota.setParcial(parcial);

        try {
            criterios = criMo.getListaCriterio(idMateria);
            while (criterios.next()) {
                nota.setIdCriterios(criterios.getInt(1));
                nota.setNota(puntaje);
                notMo.newNota(nota);
            }

        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en nuevaNota.getCloseConexion: " + e);
        }

        return false;
    }

    public String getModalVerNota(String CI_estudiante) {
        String htmlcode = "";

        Notas_model notMo = new Notas_model();

        ResultSet primerParcial = null;
        ResultSet segundoParcial = null;
        ResultSet notaFinal = null;

        Estudiante_model estMo = new Estudiante_model();

        ResultSet nombreEstudiante = estMo.getNombreEstudiante(CI_estudiante);

        try {
            primerParcial = notMo.getTotalNotasPrimerParcial(CI_estudiante);
            primerParcial.next();
            nombreEstudiante.next();
            if (primerParcial.getInt(1) != 0 || primerParcial.getInt(2) == 20) {
                System.out.println("nota: " + primerParcial.getString(1));

                htmlcode += "<div class=\"modal-content blue darken-3\">\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <h3 class=\"yellow-text accent-2 center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s8\">\n"
                        + "                                    <table class=\"bordered\">\n"
                        + "                                        <thead>\n"
                        + "                                            <tr>\n"
                        + "                                                <th>Evaluacion</th>\n"
                        + "                                                <th>Nota</th>\n"
                        + "                                            </tr>\n"
                        + "                                        </thead>\n"
                        + "\n"
                        + "                                        <tbody>\n"
                        + "                                            <tr>\n"
                        + "                                                <td>Primer Parcial</td>\n"
                        + "                                                <td>" + primerParcial.getInt(2) + "</td>\n"
                        + "                                            </tr>\n";
                segundoParcial = notMo.getTotalNotasSegundoParcial(CI_estudiante);
                segundoParcial.next();
                if (segundoParcial.getInt(1) != 0 || segundoParcial.getInt(2) == 20) {
                    htmlcode += "                                            <tr>\n"
                            + "                                                <td>Segundo Parcial</td>\n"
                            + "                                                <td>" + segundoParcial.getInt(2) + "</td>\n"
                            + "                                            </tr>\n";
                }
                htmlcode += "                                        </tbody>\n"
                        + "                                    </table>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"modal-footer blue darken-3\">\n"
                        + "                            <div class=\"col s12 right-align\">\n"
                        + "                                <a class=\"modal-action modal-close waves-effect waves-light waves-teal red yellow-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Cerrar\"><i class=\"material-icons left\">clear_all</i>Cerrar</a>\n"
                        + "                            </div>\n"
                        + "                        </div>";
            } else {

                htmlcode += "  <div class=\"modal-content blue darken-3\">\n"
                        + "        <div class=\"row\">\n"
                        + "            <h3 class=\"yellow-text accent-2 center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                        + "                <div class=\"col s3 center-align\">\n"
                        + "                </div>\n"
                        + "                <div class=\"col s6 center-align\">\n"
                        + "                       <div class=\"card-panel yellow accent-2 red-text\">\n"
                        + "                        Error: Estudiante no tiene asignada aun la nota\n"
                        + "                       </div>\n"
                        + "                </div>\n"
                        + "                <div class=\"col s3 center-align\"></div>\n"
                        + "        </div>\n"
                        + "    </div>\n"
                        + "    <div class=\"modal-footer blue darken-3\">\n"
                        + "        <div class=\"col s12 right-align\">\n"
                        + "             <a class=\"modal-action modal-close waves-effect waves-light waves-teal red yellow-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Cerrar\"><i class=\"material-icons left\">clear_all</i>Cerrar</a>\n"
                        + "        </div>\n"
                        + "    </div>";
            }

        } catch (Exception e) {
            System.out.println("Error en getModalVerNota: " + e);
        }
        System.out.println("htmlcode: " + htmlcode);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getModalVerNota.getCloseConexion: " + e);
        }
        return htmlcode;
    }

}
