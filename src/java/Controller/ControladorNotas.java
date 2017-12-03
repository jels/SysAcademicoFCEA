/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author WarMachine
 */
public class ControladorNotas extends Conexion {

    Notas_model notMo = new Notas_model();
    Estudiante_model estMo = new Estudiante_model();

    String htmlcode;
    boolean bandera;
    int numero;

    public String getModalVerNota(String CI_estudiante) {
        ResultSet primerParcial;
        ResultSet segundoParcial;
        ResultSet nombreEstudiante = estMo.getNombreEstudiante(CI_estudiante);
        try {
            primerParcial = notMo.getTotalNotasPrimerParcial(CI_estudiante);
            primerParcial.next();
            nombreEstudiante.next();
            if (primerParcial.getInt(1) != 0 || primerParcial.getInt(2) == 20) {
                htmlcode += "<div class=\"modal-content blue darken-3\">\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <h3 class=\"yellow-text accent-2 center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s12\">\n"
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
                } else {
                    htmlcode += "                                            <tr>\n"
                            + "                                                <td>Segundo Parcial</td>\n"
                            + "                                                <td class=\"yellow red-text\">Debe Evaluar al Estudiante</td>\n"
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
                        + "                <div class=\"col s12 center-align\">\n"
                        + "                     <table class=\"bordered\">\n"
                        + "                         <thead>\n"
                        + "                              <tr>\n"
                        + "                                   <th>Evaluacion</th>\n"
                        + "                                   <th>Nota</th>\n"
                        + "                              </tr>\n"
                        + "                         </thead>\n"
                        + "                         <tbody>\n"
                        + "                              <tr>\n"
                        + "                                    <td>Primer Parcial</td>\n"
                        + "                                    <td class=\"yellow red-text\">Debe Evaluar al Estudiante</td>\n"
                        + "                              </tr>\n"
                        + "                              <tr>\n"
                        + "                                    <td>Segundo Parcial</td>\n"
                        + "                                    <td class=\"yellow red-text\">Debe Evaluar al Estudiante</td>\n"
                        + "                              </tr>\n"
                        + "                         </tbody>\n"
                        + "                     </table>\n"
                        + "                </div>\n"
                        + "        </div>\n"
                        + "    </div>\n"
                        + "    <div class=\"modal-footer blue darken-3\">\n"
                        + "        <div class=\"col s12 right-align\">\n"
                        + "             <a class=\"modal-action modal-close waves-effect waves-light waves-teal red yellow-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Cerrar\"><i class=\"material-icons left\">clear_all</i>Cerrar</a>\n"
                        + "        </div>\n"
                        + "    </div>";
            }
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getModalVerNota: " + e);
        }
        return htmlcode;
    }

    public String getModalVerNotaDocente(String CI_estudiante) {
        ResultSet primerParcial = null;
        ResultSet segundoParcial = null;
        ResultSet notaFinal = null;
        double calculo = 0;
        ResultSet nombreEstudiante = estMo.getNombreEstudiante(CI_estudiante);
        try {
            primerParcial = notMo.getTotalNotasPrimerParcial(CI_estudiante);
            primerParcial.next();
            nombreEstudiante.next();
            if (primerParcial.getInt(1) != 0 || primerParcial.getInt(2) == 20) {
                calculo = (primerParcial.getInt(2) / 2) * 0.35;
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
                        + "                                                <td>" + calculo + "</td>\n"
                        + "                                            </tr>\n";
                segundoParcial = notMo.getTotalNotasSegundoParcial(CI_estudiante);
                segundoParcial.next();
                if (segundoParcial.getInt(1) != 0 || segundoParcial.getInt(2) == 20) {
                    calculo = (segundoParcial.getInt(2) / 2) * 0.35;
                    htmlcode += "                                            <tr>\n"
                            + "                                                <td>Segundo Parcial</td>\n"
                            + "                                                <td>" + calculo + "</td>\n"
                            + "                                            </tr>\n";
                    notaFinal = notMo.getTotalNotasFinal(CI_estudiante);
                    notaFinal.next();
                    if (notaFinal.getInt(1) != 0 || notaFinal.getInt(2) == 20) {
                        calculo = (notaFinal.getInt(2) / 2) * 0.35;
                        htmlcode += "                                            <tr>\n"
                                + "                                                <td>Examen Final</td>\n"
                                + "                                                <td>" + calculo + "</td>\n"
                                + "                                            </tr>\n";
                    } else {
                        htmlcode += "                                            <tr>\n"
                                + "                                                <td>Examen Final</td>\n"
                                + "                                                <td class=\"yellow green-text\">Puede Evaluar</td>\n"
                                + "                                            </tr>\n";
                    }
                } else {
                    htmlcode += "                                            <tr>\n"
                            + "                                                <td>Segundo Parcial</td>\n"
                            + "                                                <td class=\"yellow red-text\">Sin Evaluacion</td>\n"
                            + "                                            </tr>\n";
                    htmlcode += "                                            <tr>\n"
                            + "                                                <td>Examen Final</td>\n"
                            + "                                                <td class=\"yellow red-text\">No se puede Evaluar</td>\n"
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
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getModalVerNota: " + e);
        }
        return htmlcode;
    }

    public boolean insertNewNota(int idAsignacionPractica, int idCriterio, int nota, int parcial) {

        try {
            if (notMo.newNota(idAsignacionPractica, idCriterio, nota, parcial)) {
                bandera = true;
                getCloseConexion();
            } else {
                getCloseConexion();
                bandera = false;
            }
        } catch (Exception e) {
            System.out.println("Error en insertNewNota: " + e);
            bandera = false;
        }
        return bandera;
    }

}
