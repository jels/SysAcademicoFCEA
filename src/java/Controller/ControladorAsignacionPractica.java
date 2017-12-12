/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WarMachine
 */
public class ControladorAsignacionPractica extends Conexion {

    int id;
    int contador;
    AsignacionPracticas_model aspMo = new AsignacionPracticas_model();
    Practicas_model praMo = new Practicas_model();
    DetallesPracticas_model detMo = new DetallesPracticas_model();
    Estudiante_model estMo = new Estudiante_model();
    Docente_model docMo = new Docente_model();
    Materia_model matMo = new Materia_model();
    Empresa_model empMo = new Empresa_model();
    Carrera_model carMo = new Carrera_model();
    boolean bandera;
    String htmlcode = " ";
    ResultSet tem;

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

    public boolean newDetallePractica(DetallesPracticas detalle) {
        bandera = detMo.nuevoDetalle(detalle);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en newDetallePractica.getCloseConexion: " + e);
        }
        return bandera;
    }

    public int getExistePractica(String CI_estudiante) {
        contador = praMo.getExistenciadeRegistros(CI_estudiante, 1);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getExistePractica.getCloseConexion: " + e);
        }
        return contador;
    }

    public String verDetallePracticaXtutor(String CI_estudiante) {
        ResultSet nombreEstudiante = estMo.getNombreEstudiante(CI_estudiante);
        ResultSet practica;
        ResultSet detallePractica;
        int c = 1;
        htmlcode = "";
        try {
            nombreEstudiante.next();
            htmlcode = "               <div class=\"container yellow-text\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s12 center\">\n"
                    + "                                <h3 class=\"center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n" //hay que consultar para saber si la nota del primer parcial ya fue colocada 
                    + "                            </div>\n"
                    + "                        </div>\n";

            while (c <= 3) {
                switch (c) {
                    case 1:
                        if (praMo.activoParcial(1) || praMo.getExistenciadeRegistros(CI_estudiante, 1) == 1) {
                            practica = praMo.getDatosPracticaEstudiante(CI_estudiante, 1);

                            htmlcode += "                   <div class=\"row\">\n"
                                    + "                            <div class=\"col s6 center\">\n"
                                    + "                                <h4>Primer Parcial</h4>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s12\">\n"
                                    + "                                        <h4 class=\"center yellow-text\">Periodo de Evaluacion</h4>\n"
                                    + "                                        <a href=\"#newPracticaPrimer\" class=\"btn waves-effect waves-light yellow accent-2 blue-text center modal-trigger\" type=\"button\" id=\"\">\n"
                                    + "                                            Nuevo Detalle<i class=\"material-icons left\">save</i>\n"
                                    + "                                        </a>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n";
                            if (practica.next()) {
                                htmlcode += "                                <div class=\"row\">\n"
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
                                        + "                                        <div class=\"divider\"></div>\n";
                                if (practica.getString(4).length() > 15) {
                                    htmlcode += "                                        <h6 class=\"center\">" + practica.getString(4).substring(0, 15) + "</h6>\n";
                                } else {
                                    htmlcode += "                                        <h6 class=\"center\">" + practica.getString(4) + "</h6>\n";
                                }
                                htmlcode += "                                    </div>\n"
                                        + "                                </div>\n"
                                        + "                                <div class=\"row\">\n"
                                        + "                                    <div class=\"col s2\">\n"
                                        + "                                        <h6 class=\"center\">Horas</h6>\n"
                                        + "                                        <div class=\"divider\"></div>\n"
                                        + "                                        <h6 class=\"center\">" + practica.getString(5) + "</h6>\n"
                                        + "                                    </div>\n"
                                        + "                                    <div class=\"col s8\">\n"
                                        + "                                        <h6 class=\"center\">Observacion</h6>\n"
                                        + "                                        <div class=\"divider\"></div>\n";
                                if (practica.getString(6).length() > 15) {
                                    htmlcode += "                                        <h6 class=\"center\">" + practica.getString(6).substring(0, 15) + "</h6>\n";
                                } else {
                                    htmlcode += "                                        <h6 class=\"center\">" + practica.getString(6) + "</h6>\n";
                                }
                                htmlcode += "                                    </div>\n"
                                        + "                                    <div class=\"col s2\">\n"
                                        + "                                        <br><br>\n"
                                        + "                                        <a id=\"eliminar_registroPrimer\" data-id=\"" + practica.getInt(1) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text \" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a>\n"
                                        + "                                    </div>\n"
                                        + "                                </div>\n"
                                        + "                                <div class=\"row\">\n"
                                        + "                                    <div class=\"col s12\">\n"
                                        + "                                        <h4 class=\"center yellow-text\">Detalle del Perdiodo de Evaluacion</h4>\n"
                                        + "                                        <a href=\"#newDetallePracticaPrimer\" class=\"btn waves-effect waves-light yellow accent-2 blue-text center modal-trigger\" type=\"button\" id=\"\">\n"
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
                                    htmlcode += "                                                <tr>\n";
                                    if (detallePractica.getString(2).length() > 15) {
                                        htmlcode += "                                                    <td>" + detallePractica.getString(2).substring(0, 15) + "</td>\n";
                                    } else {
                                        htmlcode += "                                                    <td>" + detallePractica.getString(2) + "</td>\n";
                                    }
                                    if (detallePractica.getString(3).length() > 15) {
                                        htmlcode += "                                                    <td>" + detallePractica.getString(3).substring(0, 15) + "</td>\n";
                                    } else {
                                        htmlcode += "                                                    <td>" + detallePractica.getString(3) + "</td>\n";
                                    }
                                    htmlcode += "                                                    <td><div class=\"center-align\"><a id=\"eliminar_detalle\" data-id=\"" + detallePractica.getString(1) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                                            + "                                                </tr>\n";
                                }

                                htmlcode += "                                            </tbody>\n"
                                        + "                                        </table>\n"
                                        + "                                    </div>\n"
                                        + "                                </div>\n"
                                        + "                            </div>\n";
                            } else {
                                htmlcode += "                                <div class=\"row\">\n"
                                        + "                                    <div class=\"col s12\">\n"
                                        + "                                        <h5 class=\"center\">No Existen registros aun</h5>\n"
                                        + "                                    </div>\n"
                                        + "                                 </div>\n"
                                        + "                             \n";
                            }

                        } else {
                            htmlcode += "                          <div class=\"col s6 center\">\n"
                                    + "                                <h4 class=\"center\">Primer Parcial</h4>\n"
                                    + "                                <h5 class=\"center\">Aun no esta habilitado el sistema para insertar su evaluacion</h5>\n"
                                    + "                                <h5 class=\"center\">Disculpe la molestia</h5>\n"
                                    + "                            </div>";

                        }

                        break;
                    case 2:
                        if (praMo.activoParcial(2) || praMo.getExistenciadeRegistros(CI_estudiante, 2) == 1) {
                            practica = praMo.getDatosPracticaEstudiante(CI_estudiante, 2);
                            htmlcode += "                   \n"
                                    + "                            <div class=\"col s6 center\">\n"
                                    + "                                <h4>Segundo Parcial</h4>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                    <div class=\"col s12\">\n"
                                    + "                                        <h4 class=\"center yellow-text\">Periodo de Evaluacion</h4>\n"
                                    + "                                        <a href=\"#newPracticaSegundo\" class=\"btn waves-effect waves-light yellow accent-2 blue-text center modal-trigger\" type=\"button\" id=\"\">\n"
                                    + "                                            Nuevo Detalle<i class=\"material-icons left\">save</i>\n"
                                    + "                                        </a>\n"
                                    + "                                    </div>\n"
                                    + "                                </div>\n";
                            if (practica.next()) {
                                htmlcode += "                                <div class=\"row\">\n"
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
                                        + "                                        <div class=\"divider\"></div>\n";
                                if (practica.getString(4).length() > 15) {
                                    htmlcode += "                                        <h6 class=\"center\">" + practica.getString(4).substring(0, 15) + "</h6>\n";
                                } else {
                                    htmlcode += "                                        <h6 class=\"center\">" + practica.getString(4) + "</h6>\n";
                                }
                                htmlcode += "                                    </div>\n"
                                        + "                                </div>\n"
                                        + "                                <div class=\"row\">\n"
                                        + "                                    <div class=\"col s2\">\n"
                                        + "                                        <h6 class=\"center\">Horas</h6>\n"
                                        + "                                        <div class=\"divider\"></div>\n"
                                        + "                                        <h6 class=\"center\">" + practica.getString(5) + "</h6>\n"
                                        + "                                    </div>\n"
                                        + "                                    <div class=\"col s8\">\n"
                                        + "                                        <h6 class=\"center\">Observacion</h6>\n"
                                        + "                                        <div class=\"divider\"></div>\n";
                                if (practica.getString(6).length() > 15) {
                                    htmlcode += "                                        <h6 class=\"center\">" + practica.getString(6).substring(0, 15) + "</h6>\n";
                                } else {
                                    htmlcode += "                                        <h6 class=\"center\">" + practica.getString(6) + "</h6>\n";
                                }
                                htmlcode += "                                    </div>\n"
                                        + "                                    <div class=\"col s2\">\n"
                                        + "                                        <br><br>\n"
                                        + "                                        <a id=\"eliminar_registroSegundo\" data-id=\"" + practica.getInt(1) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text \" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a>\n"
                                        + "                                    </div>\n"
                                        + "                                </div>\n"
                                        + "                                <div class=\"row\">\n"
                                        + "                                    <div class=\"col s12\">\n"
                                        + "                                        <h4 class=\"center yellow-text\">Detalle del Perdiodo de Evaluacion</h4>\n"
                                        + "                                        <a href=\"#newDetallePracticaSegundo\" class=\"btn waves-effect waves-light yellow accent-2 blue-text center modal-trigger\" type=\"button\" id=\"\">\n"
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
                                detallePractica = praMo.getDetallesPractica(CI_estudiante, 2);
                                while (detallePractica.next()) {
                                    htmlcode += "                                                <tr>\n";
                                    if (detallePractica.getString(2).length() > 15) {
                                        htmlcode += "                                                    <td>" + detallePractica.getString(2).substring(0, 15) + "</td>\n";
                                    } else {
                                        htmlcode += "                                                    <td>" + detallePractica.getString(2) + "</td>\n";
                                    }
                                    if (detallePractica.getString(3).length() > 15) {
                                        htmlcode += "                                                    <td>" + detallePractica.getString(3).substring(0, 15) + "</td>\n";
                                    } else {
                                        htmlcode += "                                                    <td>" + detallePractica.getString(3) + "</td>\n";
                                    }
                                    htmlcode += "                                                    <td><div class=\"center-align\"><a id=\"eliminar_detalle\" data-id=\"" + detallePractica.getString(1) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Elimiar Registro\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                                            + "                                                </tr>\n";
                                }

                                htmlcode += "                                            </tbody>\n"
                                        + "                                        </table>\n"
                                        + "                                    </div>\n"
                                        + "                                </div>\n"
                                        + "                            </div>\n";
                            } else {
                                htmlcode += "                                <div class=\"row\">\n"
                                        + "                                    <div class=\"col s12\">\n"
                                        + "                                        <h5 class=\"center\">No Existen registros aun</h5>\n"
                                        + "                                    </div>\n"
                                        + "                                 </div>\n"
                                        + "                             </div>\n";
                            }

                        } else {
                            htmlcode += "                          <div class=\"col s6 center\">\n"
                                    + "                                <h4 class=\"center\">Segundo Parcial</h4>\n"
                                    + "                                <div class=\"row\">\n"
                                    + "                                     <h5 class=\"center\">Aun no esta habilitado el sistema para insertar su evaluacion</h5>\n"
                                    + "                                     <h5 class=\"center\">Disculpe la molestia</h5>\n"
                                    + "                                 </div>\n"
                                    + "                            </div>";
                        }
                        break;
                    default:
                        break;
                }
                c++;
            }
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verDetallePracticaXtutor: " + e);
        }
        htmlcode += "                </div>\n"
                + "                    ";
        return htmlcode;
    }

    public String modalNewPractica(String CI_estudiante, int parcial) {
        int registos = praMo.getExistenciadeRegistros(CI_estudiante, parcial);
        htmlcode = "";
        try {
            getCloseConexion();
        } catch (SQLException ex) {
            System.out.println("Error cerrando conexion modalNewPractica: " + ex);
        }
        if (registos == 1) {
            htmlcode = "                 <div class=\"modal-content blue darken-3\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h3 class=\"center\">Ya Existe un registro guardado</h3>\n"
                    + "                            <h5 class=\"center\">Si quiere cambiar algun dato Elimine previamente el registro anterior</h5>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"modal-footer blue darken-3 yellow-text\">\n"
                    + "                        <button class=\"btn waves-effect modal-close waves-light yellow accent-2 blue-text left\" type=\"button\">\n"
                    + "                            Cerrar<i class=\"material-icons right\">save</i>\n"
                    + "                        </button>\n"
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
                    + "                                        <label for=\"fechaInicio" + parcial + "\" class=\"yellow-text\">Fecha Inicio</label>\n"
                    + "                                        <input id=\"fechaInicio" + parcial + "\" type=\"date\" class=\"validate\">\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                    + "                                        <label for=\"fechaFin" + parcial + "\" class=\"yellow-text\">Fecha Final</label>\n"
                    + "                                        <input id=\"fechaFin" + parcial + "\" type=\"date\" class=\"validate\">\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment</i>\n"
                    + "                                        <input id=\"funcionPracticante" + parcial + "\" type=\"text\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Funcion Practicante\">Funcion Practicante</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assessment</i>\n"
                    + "                                        <input id=\"horasDePractica" + parcial + "\" type=\"number\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Final Practicas\">Cantidad de Horas</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s12\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">comment</i>\n"
                    + "                                        <input id=\"observacionEstudiante" + parcial + "\" type=\"text\" class=\"validate\" placeholder=\"Sin Observaciones\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Observacion Estudiante\" >Observacion Estudiante</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </form>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"modal-footer blue darken-3 yellow-text\">\n"
                    + "                        <div class=\"col s6\">\n"
                    + "                            <a id=\"guardarPractica" + parcial + "\" data-id=\"" + CI_estudiante + "\" class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\">\n"
                    + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                    + "                            </a>\n"
                    + "                        </div>\n"
                    + "                        <div id=\"notificacionNewPractica" + parcial + "\">\n"
                    + "                        </div>\n"
                    + "                    </div>";
        }
        return htmlcode;
    }

    public String modalDetallePractica(String CI_estudiante, int parcial) {
        int idPractica = praMo.getIdPractica(CI_estudiante, parcial);
        htmlcode = "";
        try {
            getCloseConexion();
        } catch (SQLException ex) {
            System.out.println("Error cerrando conexion modalDetallePractica: " + ex);
        }
        htmlcode = "            <div class=\"modal-content blue darken-3\">\n"
                + "                        <div class=\"row\">\n"
                + "                            <h5 class=\"center\">Ingresar los detalles de este periodo</h5>\n"
                + "                        </div>\n"
                + "                        <div class=\"row\">\n"
                + "                            <form method=\"post\" id=\"newDetallePract\" class=\"col s12 yellow-text\">\n"
                + "                                <div class=\"row\">\n"
                + "                                    <div class=\"input-field col s6\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">assignment</i>\n"
                + "                                        <input id=\"tareaAsignada" + parcial + "\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"Tarea Asignada\">Tarea Asignada</label>\n"
                + "                                    </div>\n"
                + "                                    <div class=\"input-field col s6\">\n"
                + "                                        <i class=\"material-icons prefix yellow-text\">comment</i>\n"
                + "                                        <input id=\"observacionTarea" + parcial + "\" type=\"text\" class=\"validate\">\n"
                + "                                        <label class=\"yellow-text\" for=\"Observacion Tarea\">Observacion Tarea</label>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                            </form>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                    <div class=\"modal-footer blue darken-3 yellow-text\">\n"
                + "                        <div class=\"col s6\">\n"
                + "                            <a  id=\"guardarPracticaDetalle" + parcial + "\" data-id=\"" + idPractica + "\" class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\">\n"
                + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                + "                            </a>\n"
                + "                        </div>\n"
                + "                        <div id=\"notificacionNewDetallePractica" + parcial + "\">\n"
                + "                        </div>\n"
                + "                    </div>";
        return htmlcode;
    }

    public boolean newAsignacionPractica(AsignacionPracticas asp) {
        bandera = aspMo.nuevaAsignacionPractica(asp);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en newAsignacionPractica.getCloseConexion: " + e);
        }
        return bandera;
    }

    public String getAsignacionPractica(String CI_estudiante, String usuario) {
        htmlcode = "";
        ResultSet estudiante;
        htmlcode = "";
        id = docMo.getIdDocente(usuario);
        ResultSet empresa;
        ResultSet tutores;

        try {
            bandera = aspMo.getRealizaPractica(CI_estudiante);
            getCloseConexion();
            getCloseConexion();
            if (bandera) {
                estudiante = aspMo.getDatosEstudiantePractica(CI_estudiante);
                estudiante.next();
                htmlcode += "               <div class=\"container\">\n"
                        + "                        <form>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <h3 class=\"center\">El estudiante ya realiza Practicas</h3>\n"
                        + "                                <h4 class=\"center\">" + estudiante.getString(3) + " " + estudiante.getString(4) + ", " + estudiante.getString(1) + " " + estudiante.getString(2) + "</h4>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <h5 class=\"center\">Carrera: " + estudiante.getString(6) + "</h5>\n"
                        + "                                <h5 class=\"center\">Materia: " + estudiante.getString(5) + "</h5>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <h5 class=\"center\">Empresa: " + estudiante.getString(7) + "</h5>\n"
                        + "                                <h5 class=\"center\">Tutor: " + estudiante.getString(10) + " " + estudiante.getString(11) + ", " + estudiante.getString(8) + " " + estudiante.getString(9) + "</h5>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <h5 class=\"center\">Area de Practica: " + estudiante.getString(12) + "</h5>\n"
                        + "                            </div>\n"
                        + "                        </form>\n"
                        + "                    </div>";
            } else if (aspMo.getRealizoPracticas(CI_estudiante)) {
                estudiante = aspMo.getDatosEstudiante(CI_estudiante);
                estudiante.next();
                String ingresoEstudiante = aspMo.getIngresoEstudiante(CI_estudiante);
                ResultSet materias = matMo.getMateriasEstudiante(CI_estudiante);
                empresa = empMo.getAllEmpresas();
                String nombreCarrera = matMo.getNombreCarrera(CI_estudiante);
                htmlcode += "               <div class=\"container\">\n"
                        + "                        <form method=\"post\" id=\"asignaPractica\" name=\"asignaPractica\" class=\"col s12 yellow-text\" >\n"
                        + "                            <h3 class=\"center\">" + estudiante.getString(3) + " " + estudiante.getString(4) + ", " + estudiante.getString(1) + " " + estudiante.getString(2) + "</h3>\n"
                        + "                            <input type=\"hidden\" name=\"docente\" id=\"docente\" value=\"" + id + "\" />\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s12\">\n"
                        + "                                    <div class=\"input-field\">\n"
                        + "                                        <i class=\"material-icons prefix yellow-text\">account_circle</i>\n"
                        + "                                        <select class=\"icons\" name=\"tutor\" id=\"tutor\">\n";
                while (empresa.next()) {
                    htmlcode += "                                            <optgroup label=\"" + empresa.getString(2) + "\">\n";
                    tutores = empMo.getTutorXEmpresa(empresa.getInt(1));
                    while (tutores.next()) {
                        htmlcode += "                                              <option value=\"" + tutores.getString(1) + "\" data-icon=\"../../img/fcea/tutores/" + tutores.getString(7) + "\" class=\"left circle\">" + tutores.getString(4) + " " + tutores.getString(5) + ", " + tutores.getString(2) + " " + tutores.getString(3) + " - " + tutores.getString(6) + "</option>\n";
                    }
                    htmlcode += "                                            </optgroup>\n";
                }
                htmlcode += "                                        </select>\n"
                        + "                                        <label class=\"yellow-text\">Seleccione un Tutor</label>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <div class=\"input-field\">\n"
                        + "                                        <i class=\"material-icons prefix yellow-text\">assignment</i>\n"
                        + "                                        <select class=\"icons\" name=\"materia\" id=\"materia\">\n"
                        + "                                            <optgroup label=\"" + nombreCarrera + "\">\n";
                int cantidad = 0;
                while (materias.next()) {
                    if (matMo.aproboMateria(CI_estudiante, materias.getInt(2))) {
                        htmlcode += "                                                <option value=\"" + materias.getInt(2) + "\" disabled>" + materias.getString(1) + "</option>\n";
                    } else if (cantidad == 0) {
                        htmlcode += "                                                <option value=\"" + materias.getInt(2) + "\" selected>" + materias.getString(1) + "</option>\n";
                        cantidad++;
                    } else {
                        htmlcode += "                                                <option value=\"" + materias.getInt(2) + "\" disabled>" + materias.getString(1) + "</option>\n";
                    }
                }
                htmlcode += "                                            </optgroup>\n"
                        + "                                        </select>\n"
                        + "                                        <label class=\"yellow-text\">Seleccione Una Materia</label>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <div class=\"input-field\">\n"
                        + "                                        <i class=\"material-icons prefix yellow-text\">business</i>\n"
                        + "                                        <input id=\"areaPractica\" name=\"areaPractica\" type=\"text\" class=\"validate\">\n"
                        + "                                        <label class=\"yellow-text\" for=\"Area de Practica\">Area de Practica</label>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"input-field col s6\">\n"
                        + "                                    <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                        + "                                    <input id=\"ingresoEs\" name=\"ingresoEs\" type=\"text\" value=\"" + ingresoEstudiante + "\" disabled class=\"validate\">\n"
                        + "                                    <label class=\"yellow-text\" for=\"Ingreso\">Año de Ingreso</label>\n"
                        + "                                </div>\n"
                        + "                                <div class=\"input-field col s6\">\n"
                        + "                                    <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                        + "                                    <input id=\"gestionActual\" name=\"gestionActual\" type=\"text\" class=\"validate\">\n"
                        + "                                    <label class=\"yellow-text\" for=\"Gestion Actual\">Gestion Actual</label>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                        + "                                    <label for=\"fechaInicioPra\" name=\"fechaInicioPra\" class=\"yellow-text\">Fecha Inicio Practica</label>\n"
                        + "                                    <input id=\"fechaInicioPra\" type=\"date\" class=\"validate\">\n"
                        + "                                </div>\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                        + "                                    <label for=\"fechaFinPra\" name=\"fechaFinPra\" class=\"yellow-text\">Fecha Fin Practica</label>\n"
                        + "                                    <input id=\"fechaFinPra\" type=\"date\" class=\"validate\">\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"asignacionPractica\" name=\"asignacionPractica\" data-id=\"" + CI_estudiante + "\">\n"
                        + "                                        Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                        + "                                    </button>\n"
                        + "                                </div>\n"
                        + "                                <div id=\"notificacionAsignacionPractica\">\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </form>\n"
                        + "                    </div>";
            } else {
                estudiante = estMo.getDatosEst(CI_estudiante);
                estudiante.next();
                empresa = empMo.getAllEmpresas();
                ResultSet carreras = carMo.getCarreras(2);
                ResultSet materiasXCarrera;
                htmlcode += "               <div class=\"container\">\n"
                        + "                        <form method=\"post\" id=\"asignacionPra\" name=\"asignacionPra\" class=\"col s12 yellow-text\" >\n"
                        + "                            <h3 class=\"center\">" + estudiante.getString(3) + " " + estudiante.getString(4) + ", " + estudiante.getString(1) + " " + estudiante.getString(2) + "</h3>\n"
                        + "                            <input type=\"hidden\" name=\"docente\" id=\"docente\" value=\"" + id + "\" />\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s12\">\n"
                        + "                                    <div class=\"input-field\">\n"
                        + "                                        <i class=\"material-icons prefix yellow-text\">account_circle</i>\n"
                        + "                                        <select class=\"icons\" name=\"tutor\" id=\"tutor\">\n";
                while (empresa.next()) {
                    htmlcode += "                                            <optgroup label=\"" + empresa.getString(2) + "\">\n";
                    tutores = empMo.getTutorXEmpresa(empresa.getInt(1));
                    while (tutores.next()) {
                        htmlcode += "                                              <option value=\"" + tutores.getString(1) + "\" data-icon=\"../../img/fcea/tutores/" + tutores.getString(7) + "\" class=\"left circle\">" + tutores.getString(4) + " " + tutores.getString(5) + ", " + tutores.getString(2) + " " + tutores.getString(3) + " - " + tutores.getString(6) + "</option>\n";
                    }
                    htmlcode += "                                            </optgroup>\n";
                }
                htmlcode += "                                       </select>\n"
                        + "                                        <label class=\"yellow-text\">Seleccione un Tutor</label>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <div class=\"input-field\">\n"
                        + "                                        <i class=\"material-icons prefix yellow-text\">assignment</i>\n"
                        + "                                        <select class=\"icons\" name=\"materia\" id=\"materia\">\n";
                int cant = 0;
                while (carreras.next()) {
                    htmlcode += "                                            <optgroup label=\"" + carreras.getString(2) + "\">\n";
                    materiasXCarrera = carMo.getMateriasCarrera(carreras.getInt(1));
                    while (materiasXCarrera.next()) {
                        if (cant == 0) {
                            htmlcode += "                                                <option value=\"" + materiasXCarrera.getInt(1) + "\" selected>" + materiasXCarrera.getString(2) + "</option>\n";
                            cant++;
                        } else {
                            htmlcode += "                                                <option value=\"" + materiasXCarrera.getInt(1) + "\" disabled>" + materiasXCarrera.getString(2) + "</option>\n";
                        }
                    }
                    cant = 0;
                    htmlcode += "                                            </optgroup>\n";
                }
                htmlcode += "                                        </select>\n"
                        + "                                        <label class=\"yellow-text\">Seleccione Una Materia</label>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <div class=\"input-field\">\n"
                        + "                                        <i class=\"material-icons prefix yellow-text\">business</i>\n"
                        + "                                        <input id=\"areaPractica\" name=\"areaPractica\" type=\"text\" class=\"validate\">\n"
                        + "                                        <label class=\"yellow-text\" for=\"areaPractica\">Area de Practica</label>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"input-field col s6\">\n"
                        + "                                    <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                        + "                                    <input id=\"ingresoEs\" name=\"ingresoEs\" type=\"text\" class=\"validate\">\n"
                        + "                                    <label class=\"yellow-text\" for=\"ingresoEs\">Año de Ingreso</label>\n"
                        + "                                </div>\n"
                        + "                                <div class=\"input-field col s6\">\n"
                        + "                                    <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                        + "                                    <input id=\"gestionActual\" name=\"gestionActual\" type=\"text\" class=\"validate\">\n"
                        + "                                    <label class=\"yellow-text\" for=\"gestionActual\">Gestion Actual</label>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                        + "                                    <label for=\"fechaInicioPra\" name=\"fechaInicioPra\" class=\"yellow-text\">Fecha Inicio Practica</label>\n"
                        + "                                    <input id=\"fechaInicioPra\" type=\"date\" class=\"validate\">\n"
                        + "                                </div>\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <i class=\"material-icons prefix yellow-text\">date_range</i>\n"
                        + "                                    <label for=\"fechaFinPra\" name=\"fechaFinPra\" class=\"yellow-text\">Fecha Fin Practica</label>\n"
                        + "                                    <input id=\"fechaFinPra\" type=\"date\" class=\"validate\">\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"row\">\n"
                        + "                                <div class=\"col s6\">\n"
                        + "                                    <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left\" type=\"button\" id=\"asignacionPractica\" name=\"asignacionPractica\" data-id=\"" + CI_estudiante + "\">\n"
                        + "                                        Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                        + "                                    </button>\n"
                        + "                                </div>\n"
                        + "                                <div id=\"notificacionAsignacionPractica\">\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </form>\n"
                        + "                    </div>";
            }
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getAsignacionPractica: " + e);
        }

        return htmlcode;
    }

    public boolean eliminarAsignacionPractica(int idAsignacionPractica) {
        bandera = aspMo.eliminarAsignacion(idAsignacionPractica);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en eliminarAsignacionPractica.getCloseConexion: " + e);
        }
        return bandera;
    }

    public String verPracticasActivas() {
        htmlcode = "";
        ResultSet practicas = aspMo.getDatosPracticas(1);
        contador = 0;
        try {
            htmlcode += "               <div class=\"container\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h3 class=\"center\">Practicas Activas De esta Gestion</h3>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <table class=\"bordered responsive-table\">\n"
                    + "                                <thead>\n"
                    + "                                    <tr>\n"
                    + "                                        <th>#</th>\n"
                    + "                                        <th>Estudiante</th>\n"
                    + "                                        <th>Materia</th>\n"
                    + "                                        <th>Carrera</th>\n"
                    + "                                        <th>Tutor</th>\n"
                    + "                                        <th class=\"center\">Ver - Reportes</th>\n"
                    + "                                        <th class=\"center\">Eliminar</th>\n"
                    + "                                    </tr>\n"
                    + "                                </thead>\n"
                    + "                                <tbody>\n";
            while (practicas.next()) {
                contador++;
                htmlcode += "                                    <tr>\n"
                        + "                                        <td>" + contador + "</td>\n"
                        + "                                        <td>" + practicas.getString(4) + " " + practicas.getString(5) + ", " + practicas.getString(2) + " " + practicas.getString(3) + "</td>\n"
                        + "                                        <td>" + practicas.getString(6) + "</td>\n"
                        + "                                        <td>" + practicas.getString(7) + "</td>\n"
                        + "                                        <td>" + practicas.getString(10) + " " + practicas.getString(11) + ", " + practicas.getString(8) + " " + practicas.getString(9) + "</td>\n"
                        + "                                        <td><div class=\"center-align\"><a href=\"ver_practicas.jsp?ci=" + practicas.getString(1) + "\"  class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Ver - Reportes\"><i class=\"material-icons yellow-text\">event_note</i></a></div></td>\n"
                        + "                                        <td><div class=\"center-align\"><a data-id=\"" + practicas.getString(12) + "\" id=\"eliminar_asignacionPractica\" name=\"eliminar_asignacionPractica\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Eliminar\"><i class=\"material-icons yellow-text\">delete</i></a></div></td>\n"
                        + "                                    </tr>\n";
            }
            htmlcode += "                               </tbody>\n"
                    + "                            </table>\n"
                    + "                        </div>\n"
                    + "                    </div>";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verPracticasActivas: " + e);
        }
        return htmlcode;
    }

    public int contarPracticasEstado(int estado) {
        contador = aspMo.getCantidadPracticasEstado(estado);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en contarPracticasEstado.getCloseConexion: " + e);
        }
        return contador;
    }

    public String verPracticasArchivadas() {
        htmlcode = "";
        ResultSet practicas = aspMo.getDatosPracticas(0);
        contador = 0;
        try {
            htmlcode += "               <div class=\"container\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h3 class=\"center\">Practicas Archivadas</h3>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <table class=\"bordered responsive-table\">\n"
                    + "                                <thead>\n"
                    + "                                    <tr>\n"
                    + "                                        <th>#</th>\n"
                    + "                                        <th>Estudiante</th>\n"
                    + "                                        <th>Materia</th>\n"
                    + "                                        <th>Carrera</th>\n"
                    + "                                        <th>Tutor</th>\n"
                    + "                                        <th class=\"center\">Ver - Reportes</th>\n"
                    + "                                    </tr>\n"
                    + "                                </thead>\n"
                    + "                                <tbody>\n";
            while (practicas.next()) {
                contador++;
                htmlcode += "                                    <tr>\n"
                        + "                                        <td>" + contador + "</td>\n"
                        + "                                        <td>" + practicas.getString(4) + " " + practicas.getString(5) + ", " + practicas.getString(2) + " " + practicas.getString(3) + "</td>\n"
                        + "                                        <td>" + practicas.getString(6) + "</td>\n"
                        + "                                        <td>" + practicas.getString(7) + "</td>\n"
                        + "                                        <td>" + practicas.getString(10) + " " + practicas.getString(11) + ", " + practicas.getString(8) + " " + practicas.getString(9) + "</td>\n"
                        + "                                        <td><div class=\"center-align\"><a href=\"ver_practicas.jsp?ci=" + practicas.getString(1) + "\"  class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Ver - Reportes\"><i class=\"material-icons yellow-text\">event_note</i></a></div></td>\n"
                        + "                                    </tr>\n";
            }
            htmlcode += "                               </tbody>\n"
                    + "                            </table>\n"
                    + "                        </div>\n"
                    + "                    </div>";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verPracticasActivas: " + e);
        }
        return htmlcode;
    }

}
