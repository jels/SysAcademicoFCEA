/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;
import javax.ws.rs.client.Entity;

/**
 *
 * @author WarMachine
 */
public class ControladorAsignacionPractica extends Conexion {

    int id;
    int contador;
    AsignacionPracticas_model aspMo = new AsignacionPracticas_model();
    Practicas_model praMo = new Practicas_model();
    boolean bandera;
    String htmlcode;

    public boolean cambiarEstadoParcial(int idParcial) {

        int estadoParcial = praMo.getEstadoParcial(idParcial);
        if (estadoParcial == 1) {
            bandera = praMo.actualizarParcial(idParcial, 0);
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en cambiarEstadoParcial.getCloseConexion: " + e);
            }
        } else {
            bandera = praMo.actualizarParcial(idParcial, 0);
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en cambiarEstadoParcial.getCloseConexion: " + e);
            }
        }
        return bandera;
    }

    public int getIdPracitca(String CI_estudiante) {
        id = aspMo.getIdAsignacionPractica(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getIdPracitca.getCloseConexion: " + e);
        }
        return id;
    }

    public boolean newPractica(Practicas practica) {
        bandera = praMo.new_Practica(practica);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en newPractica.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean newAsignacionPracticas() {

        return bandera;
    }

    public int getExistePractica(String CI_estudiante) {

        contador = praMo.getExistenciadeRegistros(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getExistePractica.getCloseConexion: " + e);
        }
        return contador;
    }

    public String verDetallePracticaXtutor(String CI_estudiante) {

        Estudiante_model estMo = new Estudiante_model();
        ResultSet nombreEstudiante = estMo.getNombreEstudiante(CI_estudiante);
        htmlcode = "";
        try {
            nombreEstudiante.next();
            htmlcode += "               <div class=\"container yellow-text\">\n"
                    + "                        <h3 class=\"center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                    + "                        <div class=\"row\">\n";

            int parcial = 0;

            switch (parcial) {
                case 1:

                    htmlcode += "                            <div class=\"col s6 center\">\n"
                            + "                                <h4>Primer Parcial</h4>\n"
                            + "                                <div class=\"row\">\n"
                            + "                                    <h3 class=\"center yellow-text\">Periodo de Evaluacion</h3>\n"
                            + "                                    <a href=\"#newPractica\" class=\"btn waves-effect waves-light yellow accent-2 blue-text center modal-trigger\" type=\"button\" id=\"\">\n"
                            + "                                        Nuevo Detalle<i class=\"material-icons left\">save</i>\n"
                            + "                                    </a>\n"
                            + "                                </div>\n"
                            + "                                <div class=\"row\">\n"
                            + "                                    <table class=\"bordered\">\n"
                            + "                                        <thead>\n"
                            + "                                            <tr>\n"
                            + "                                                <th>Fecha Inicio</th>\n"
                            + "                                                <th>Fecha Final</th>\n"
                            + "                                                <th>Funcion</th>\n"
                            + "                                                <th>Cantidad de Horas</th>\n"
                            + "                                                <th>Observacion</th>\n"
                            + "                                                <th class=\"center-align\">Eliminar</th>\n"
                            + "                                            </tr>\n"
                            + "                                        </thead>\n"
                            + "\n"
                            + "                                        <tbody>\n"
                            + "                                            <tr>\n"
                            + "                                                <td>18-08-2015</td>\n"
                            + "                                                <td>10-09-2015</td>\n"
                            + "                                                <td>Asistente Contable</td>\n"
                            + "                                                <td>60</td>\n"
                            + "                                                <td>El estudiante desempeño su trabajo de una manera muy inadecuada por lo cual no tuvo una buena apresiacion de su nivel academico</td>\n"
                            + "                                                <td><div class=\"center-align\"><a class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                            + "                                            </tr>\n"
                            + "                                        </tbody>\n"
                            + "                                    </table>\n"
                            + "                                </div>\n"
                            + "\n"
                            + "                                <div class=\"row\">\n"
                            + "                                    <h3 class=\"center yellow-text\">Detalle del Perdiodo de Evaluacion</h3>\n"
                            + "                                    <a href=\"#newDetallePractica\" class=\"btn waves-effect waves-light yellow accent-2 blue-text center modal-trigger\" type=\"button\" id=\"\">\n"
                            + "                                        Nuevo Detalle<i class=\"material-icons left\">save</i>\n"
                            + "                                    </a>\n"
                            + "                                </div>\n"
                            + "\n"
                            + "                                <div class=\"row\">\n"
                            + "                                    <table class=\"bordered\">\n"
                            + "                                        <thead>\n"
                            + "                                            <tr>\n"
                            + "                                                <th>Tarea</th>\n"
                            + "                                                <th>Descripcion</th>\n"
                            + "                                                <th class=\"center-align\">Eliminar</th>\n"
                            + "                                            </tr>\n"
                            + "                                        </thead>\n"
                            + "\n"
                            + "                                        <tbody>\n"
                            + "                                            <tr>\n"
                            + "                                                <td>Elaboracion de Balance de Apertura</td>\n"
                            + "                                                <td>Sin Observacion</td>\n"
                            + "                                                <td><div class=\"center-align\"><a class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                            + "\n"
                            + "                                            </tr>\n"
                            + "                                            <tr>\n"
                            + "                                                <td>Llenado de Libros de Compras y Ventas</td>\n"
                            + "                                                <td>Sin Observacion</td>\n"
                            + "                                                <td><div class=\"center-align\"><a class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                            + "                                            </tr>\n"
                            + "                                            <tr>\n"
                            + "                                                <td>Envio de Formularios 200 - 400 y 608</td>\n"
                            + "                                                <td>Sin Observacion</td>\n"
                            + "                                                <td><div class=\"center-align\"><a class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                            + "                                            </tr>\n"
                            + "                                            <tr>\n"
                            + "                                                <td>Revision de Llenado de LCV - Gestion 2015</td>\n"
                            + "                                                <td>Sin Observacion</td>\n"
                            + "                                                <td><div class=\"center-align\"><a class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                            + "                                            </tr>\n"
                            + "                                            <tr>\n"
                            + "                                                <td>Pago de Formularios 200 - 400</td>\n"
                            + "                                                <td>Sin Observacion</td>\n"
                            + "                                                <td><div class=\"center-align\"><a class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                            + "                                            </tr>\n"
                            + "                                        </tbody>\n"
                            + "                                    </table>\n"
                            + "                                </div>\n"
                            + "\n"
                            + "                            </div>\n"
                            + "                            <div class=\"col s6 center\">\n"
                            + "                                <h4>Segundo Parcial</h4>\n"
                            + "                            </div>\n"
                            + "                        </div>\n"
                            + "                    </div>";
                    //hay que consultar para saber si la nota del primer parcial ya fue colocada 
                    //cuando ya esta puesta recien se puede realizar la descripcion de las tareas
                    break;
                case 2:
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error en verDetallePracticaXtutor: " + e);
        }
        return htmlcode;
    }

}
