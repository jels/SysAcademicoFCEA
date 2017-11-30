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

    public boolean eliminarDetallePractica(int idDetalle) {
        bandera = praMo.eliminarDetalle(idDetalle);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en eliminarDetallePractica.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean eliminarRegistroPractica(int idPractica) {

        bandera = praMo.eliminarPractica(idPractica);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en eliminarRegistroPractica.getCloseConexion: " + e);
        }
        return bandera;
    }

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
            bandera = praMo.actualizarParcial(idParcial, 1);
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
        System.out.println("Contador: " + contador);
        return contador;
    }

    public String verDetallePracticaXtutor(String CI_estudiante) {

        Estudiante_model estMo = new Estudiante_model();
        ResultSet nombreEstudiante = estMo.getNombreEstudiante(CI_estudiante);
        ResultSet practica;
        ResultSet detallePractica;
        int c = 1;
        htmlcode = "";
        try {
            nombreEstudiante.next();
            htmlcode += "               <div class=\"container yellow-text\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s12 center\">\n"
                    + "                                <h3 class=\"center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n" //hay que consultar para saber si la nota del primer parcial ya fue colocada 
                    + "                            </div>\n"
                    + "                        </div>\n";

            while (c <= 3) {
                switch (c) {
                    case 1:
                        System.out.println("llego");
                        if (praMo.activoParcial(1) || praMo.getExistenciadeRegistros(CI_estudiante) == 1) {
                            practica = praMo.getDatosPracticaEstudiante(CI_estudiante, 1);
                            practica.next();
                            htmlcode += "                   <div class=\"row\">\n"
                                    + "                            <div class=\"col s6 center\">\n"
                                    + "                                <h4>Primer Parcial</h4>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s12\">\n"
                                    + "                                        <h4 class=\"center yellow-text\">Periodo de Evaluacion</h4>\n"
                                    + "                                        <a href=\"#newPractica\" class=\"btn waves-effect waves-light yellow accent-2 blue-text center modal-trigger\" type=\"button\" id=\"\">\n"
                                    + "                                            Nuevo Detalle<i class=\"material-icons left\">save</i>\n"
                                    + "                                        </a>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s4\">\n"
                                    + "                                        <h6 class=\"center\">Fecha Inicio</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(2) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                    <div class=\"col s4\">\n"
                                    + "                                        <h6 class=\"center\">Fecha Fin</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(3) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                    <div class=\"col s4\">\n"
                                    + "                                        <h6 class=\"center\">Funcion</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(4) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s2\">\n"
                                    + "                                        <h6 class=\"center\">Horas</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(5) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                    <div class=\"col s8\">\n"
                                    + "                                        <h6 class=\"center\">Observacion</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(6) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                    <div class=\"col s2\">\n"
                                    + "                                        <br><br>\n"
                                    + "                                        <a id=\"eliminar_registro\" data-id=\"" + practica.getInt(1) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text \" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s12\">\n"
                                    + "                                        <h4 class=\"center yellow-text\">Detalle del Perdiodo de Evaluacion</h4>\n"
                                    + "                                        <a href=\"#newDetallePractica\" class=\"btn waves-effect waves-light yellow accent-2 blue-text center modal-trigger\" type=\"button\" id=\"\">\n"
                                    + "                                            Nuevo Detalle<i class=\"material-icons left\">save</i>\n"
                                    + "                                        </a>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s12\">\n"
                                    + "                                        <table class=\"bordered\">\n"
                                    + "                                            <thead>\n"
                                    + "                                                <tr>\n"
                                    + "                                                    <th>Tarea</th>\n"
                                    + "                                                    <th>Descripcion</th>\n"
                                    + "                                                    <th class=\"center-align\">Eliminar</th>\n"
                                    + "                                                </tr>\n"
                                    + "                                            </thead>\n"
                                    + "                                            <tbody>\n";
                            detallePractica = praMo.getDetallesPractica(CI_estudiante, 1);
                            while (detallePractica.next()) {
                                htmlcode += "                                                <tr>\n"
                                        + "                                                    <td>" + detallePractica.getString(2) + "</td>\n"
                                        + "                                                    <td>" + detallePractica.getString(3) + "</td>\n"
                                        + "                                                    <td><div class=\"center-align\"><a id=\"eliminar_detalle\" data-id=\"" + detallePractica.getString(1) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                                        + "                                                </tr>\n";
                            }

                            htmlcode += "                                            </tbody>\n"
                                    + "                                        </table>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n"
                                    + "                            </div>\n";

                        } else {
                            htmlcode += "                          <div class=\"col s6 center\">\n"
                                    + "                                <h3 class=\"center\">Primer Parcial</h3>\n"
                                    + "                                <h4 class=\"center\">Aun no esta habilitado el sistema para insertar su evaluacion</h4>\n"
                                    + "                                <h4 class=\"center\">Disculpe la molestia</h4>\n"
                                    + "                            </div>";

                        }

                        break;
                    case 2:
                        if (praMo.activoParcial(2) || praMo.getExistenciadeRegistros(CI_estudiante) == 1) {
                            practica = praMo.getDatosPracticaEstudiante(CI_estudiante, 2);

                            htmlcode += "\n"
                                    + "                            <div class=\"col s6 center\">\n"
                                    + "                                <h4>Primer Parcial</h4>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s12\">\n"
                                    + "                                        <h4 class=\"center yellow-text\">Periodo de Evaluacion</h4>\n"
                                    + "                                        <a href=\"#newPractica\" class=\"btn waves-effect waves-light yellow accent-2 blue-text center modal-trigger\" type=\"button\" id=\"\">\n"
                                    + "                                            Nuevo Detalle<i class=\"material-icons left\">save</i>\n"
                                    + "                                        </a>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s4\">\n"
                                    + "                                        <h6 class=\"center\">Fecha Inicio</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(2) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                    <div class=\"col s4\">\n"
                                    + "                                        <h6 class=\"center\">Fecha Fin</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(3) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                    <div class=\"col s4\">\n"
                                    + "                                        <h6 class=\"center\">Funcion</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(4) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s2\">\n"
                                    + "                                        <h6 class=\"center\">Horas</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(5) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                    <div class=\"col s8\">\n"
                                    + "                                        <h6 class=\"center\">Observacion</h6>\n"
                                    + "                                        <div class=\"divider\"></div>\n"
                                    + "                                        <h6 class=\"center\">" + practica.getString(6) + "</h6>\n"
                                    + "                                    </div>\n"
                                    + "                                    <div class=\"col s2\">\n"
                                    + "                                        <br><br>\n"
                                    + "                                        <a class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text \" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>";
                        } else {
                            htmlcode += "                          <div class=\"col s6 center\">\n"
                                    + "                                <h3 class=\"center\">Segundo Parcial</h3>\n"
                                    + "                                <h4 class=\"center\">Aun no esta habilitado el sistema para insertar su evaluacion</h4>\n"
                                    + "                                <h4 class=\"center\">Disculpe la molestia</h4>\n"
                                    + "                            </div>";
                        }
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }

                c++;

            }

            //cuando ya esta puesta recien se puede realizar la descripcion de las tareas
        } catch (Exception e) {
            System.out.println("Error en verDetallePracticaXtutor: " + e);
        }

        return htmlcode += "                </div>\n"
                + "                    </div>";
    }

    public String modalNewPractica(String CI_estudiante) {

        int registos = praMo.getExistenciadeRegistros(CI_estudiante);

        if (registos == 1) {
            htmlcode = "                 <div class=\"modal-content blue darken-3\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h3 class=\"center\">Ya Existe un registro guardado</h3>\n"
                    + "                            <h5 class=\"center\">Si quiere cambiar algun dato Elimine previamente el registro anterior</h5>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"modal-footer blue darken-3 yellow-text\">\n"
                    + "\n"
                    + "                        <button class=\"btn waves-effect modal-close waves-light yellow accent-2 blue-text left\" type=\"button\">\n"
                    + "                            Cerrar<i class=\"material-icons right\">save</i>\n"
                    + "                        </button>\n"
                    + "\n"
                    + "                    </div>";

        } else {
            htmlcode = "                 <div class=\"modal-content blue darken-3\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h5 class=\"center\">Ingresar los datos del periodo de practica a evaluar</h5>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <form method=\"post\" id=\"newPrac\" class=\"col s12 yellow-text\">\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                    + "                                        <label for=\"fechaInicio\" class=\"yellow-text\">Fecha Inicio</label>\n"
                    + "                                        <input id=\"fechaInicio\" type=\"date\" class=\"validate\">\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                    + "                                        <label for=\"fechaFin\" class=\"yellow-text\">Fecha Final</label>\n"
                    + "                                        <input id=\"fechaFin\" type=\"date\" class=\"validate\">\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment</i>\n"
                    + "                                        <input id=\"funcionPracticante\" type=\"text\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Funcion Practicante\">Funcion Practicante</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assessment</i>\n"
                    + "                                        <input id=\"horasDePractica\" type=\"number\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Final Practicas\">Cantidad de Horas</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s12\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">comment</i>\n"
                    + "                                        <input id=\"observacionEstudiante\" type=\"text\" class=\"validate\" placeholder=\"Sin Observaciones\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Observacion Estudiante\" >Observacion Estudiante</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </form>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"modal-footer blue darken-3 yellow-text\">\n"
                    + "                        <div class=\"col s6\">\n"
                    + "                            <a data-id=\"" + CI_estudiante + "\" class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"guardarPractica\">\n"
                    + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                    + "                            </a>\n"
                    + "                        </div>\n"
                    + "                        <div id=\"notificacionNewPractica\">\n"
                    + "                        </div>\n"
                    + "                    </div>";

        }

        return htmlcode;
    }

}
