/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author WarMachine
 */
public class ControladorReportes extends Conexion {

    Estudiante_model estMo = new Estudiante_model();
    Tutor_model tutMo = new Tutor_model();
    Carrera_model carMo = new Carrera_model();
    AsignacionPracticas_model aspMo = new AsignacionPracticas_model();
    Materia_model matMo = new Materia_model();
    Empresa_model empMo = new Empresa_model();
    Practicas_model praMo = new Practicas_model();
    Criterios_model criMo = new Criterios_model();
    Dimension_model dimMo = new Dimension_model();
    Docente_model docMo = new Docente_model();
    Usuario_model usMo = new Usuario_model();
    Notas_model notMo = new Notas_model();

    n2t ntot = new n2t();

    String htmlcode = "";
    int id;
    boolean bandera;

    public String getPeriodo(int parcial) {
        htmlcode = "";
        if (parcial == 1) {
            htmlcode = "Durante el Primer Parcial";
        } else {
            htmlcode = "Durante el Segundo Parcial";
        }
        return htmlcode;
    }

    public boolean getEvaluacionCompleta(String CI_estudiante, int parcial) {
        try {
            switch (parcial) {
                case 1:
                    bandera = notMo.llenoPrimerParcial(CI_estudiante);
                    break;
                case 2:
                    bandera = notMo.llenoSegundoParcial(CI_estudiante);
                    break;
                case 3:
                    bandera = notMo.evaluacionCompletaDocente(CI_estudiante);
                    break;
                default:
                    break;
            }
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getEvaluacionCompleta: " + e);
        }
        return bandera;
    }

    public String getNombreCarreraEstudiante(String CI_estudiante) {
        htmlcode = carMo.getNombreCar(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getNombreCarreraEstudiante: " + e);
        }
        return htmlcode;
    }

    public String getSemestreMateria(String CI_estudiante) {
        htmlcode = matMo.getSemestreMateria(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getSemestreMateria: " + e);
        }
        return htmlcode;
    }

    public String getIngresoEstudiante(String CI_estudiante) {
        htmlcode = aspMo.getIngresoEstudiante(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getIngresoEstudiante: " + e);
        }
        return htmlcode;
    }

    public String getGestionActual(String CI_estudiante) {
        htmlcode = aspMo.getGestionAC(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getGestionActual: " + e);
        }
        return htmlcode;
    }

    public String getCoordinadorAcademico(String CI_estudiante) {
        htmlcode = docMo.getNombreDocente(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getCoordinadorAcademico: " + e);
        }
        return htmlcode;
    }

    public String getMateriaCursando(String CI_estudiante) {
        htmlcode = matMo.getMateriaActual(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getMateriaCursando: " + e);
        }
        return htmlcode;
    }

    public String getNombreEstudiante(String CI_estudiante) {
        htmlcode = estMo.getNombreCompleto(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getNombreEstudiante: " + e);
        }
        return htmlcode;
    }

    public String getPeriodoEvaluacionInicio(String CI_estudiante, int parcial) {
        htmlcode = aspMo.getPeriodoInicio(CI_estudiante, parcial);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getPeriodoEvaluacionInicio: " + e);
        }
        return htmlcode;
    }

    public String getPeriodoEvaluacionFin(String CI_estudiante, int parcial) {
        htmlcode = aspMo.getPeriodoFin(CI_estudiante, parcial);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getPeriodoEvaluacionFin: " + e);
        }
        return htmlcode;
    }

    public String getTotalHoras(String CI_estudiante, int parcial) {
        htmlcode = praMo.getTotalHors(CI_estudiante, parcial);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getTotalHoras: " + e);
        }
        return htmlcode;
    }

    public String getNombreEmpresa(String CI_estudiante) {
        htmlcode = empMo.getNomEmpresa(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getNombreEmpresa: " + e);
        }
        return htmlcode;
    }

    public String getDireccionEmpresa(String CI_estudiante) {
        htmlcode = empMo.getDireccionEmpresa(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getDireccionEmpresa: " + e);
        }
        return htmlcode;
    }

    public String getTelefonoEmpresa(String CI_estudiante) {
        htmlcode = empMo.getTelefonoEmpresa(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getTelefonoEmpresa: " + e);
        }
        return htmlcode;
    }

    public String getNombreTutor(String CI_estudiante) {
        htmlcode = tutMo.getNombTutor(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getNombreTutor: " + e);
        }
        return htmlcode;
    }

    public String getCargoTutor(String CI_estudiante) {
        htmlcode = tutMo.getCargoTut(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getCargoTutor: " + e);
        }
        return htmlcode;
    }

    public String getAreaPractica(String CI_estudiante) {
        htmlcode = aspMo.getAreaPractic(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getAreaPractica: " + e);
        }
        return htmlcode;
    }

    public String getFuncionParcial(String CI_estudiante, int parcial) {
        htmlcode = aspMo.getFuncionPar(CI_estudiante, parcial);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getFuncionParcial: " + e);
        }
        return htmlcode;
    }

    public String getTareasAsignadas(String CI_estudiante, int parcial) {
        ResultSet tareas = aspMo.getTareasParcial(CI_estudiante, parcial);
        htmlcode = "";
        try {
            id = 0;
            while (tareas.next()) {
                if (id >= 5) {
                    htmlcode += "";
                } else {
                    htmlcode += "<span style=\"margin-right: 1cm;\"></span><span style=\"margin-right: 0.8cm;\"></span><tt><i><b><span style=\"margin-right: 0.5cm;\">-</span>" + tareas.getString(1) + "</b></i></tt><br/>\n";
                }
                id++;
            }
            switch (id) {
                case 0:
                    htmlcode += "<br/><br/><span style=\"margin-right: 1cm;\"></span><span style=\"margin-right: 0.8cm;\"></span><tt><i><b><span style=\"margin-right: 0.5cm;\">-</span>No se registraron tareas</b></i></tt><br/><br/><br/>";
                    break;
                case 1:
                    htmlcode += "<br/><br/><br/><br/>";
                    break;
                case 2:
                    htmlcode += "<br/><br/><br/>";
                    break;
                case 3:
                    htmlcode += "<br/><br/>";
                    break;
                case 4:
                    htmlcode += "<br/>";
                    break;
                default:
                    break;
            }
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getNombreTareasAsignadas: " + e);
        }
        return htmlcode;
    }

    public String getReporteParcialTutor(String CI_estudiante, int parcial) {

        htmlcode = "";
        int c = 1;
        int n = 0;
        ResultSet criterios;
        ResultSet dimensiones;
        try {
            dimensiones = dimMo.getDimensionesXMateria(CI_estudiante);
            while (c <= 4) {
                dimensiones.next();
                switch (c) {
                    case 1:
                        htmlcode += "              <div class=\"row\">\n "
                                + "                     <div class=\"col s6\">\n"
                                + "                            <table class=\"bordered\">\n"
                                + "                                <thead>\n"
                                + "                                    <tr>\n"
                                + "                                        <th>A. " + dimensiones.getString(2) + "</th>\n"
                                + "                                        <th>Puntaje</th>\n"
                                + "                                    </tr>\n"
                                + "                                </thead>\n"
                                + "                                <tbody>\n";
                        criterios = criMo.getCriterioXDimnensionYNota(dimensiones.getInt(1), parcial, CI_estudiante);
                        while (criterios.next()) {
                            n++;
                            htmlcode += "                                    <tr>\n"
                                    + "                                        <td>" + n + ". " + criterios.getString(1) + "</td>\n"
                                    + "                                        <td><div class=\"center\">" + criterios.getInt(2) + "</div></td>\n"
                                    + "                                    </tr>\n";
                        }

                        htmlcode += "                                </tbody>\n"
                                + "                            </table>\n"
                                + "                        </div>";
                        c++;
                        break;
                    case 2:
                        htmlcode += ""
                                + "                     <div class=\"col s6\">\n"
                                + "                            <table class=\"bordered\">\n"
                                + "                                <thead>\n"
                                + "                                    <tr>\n"
                                + "                                        <th>A. " + dimensiones.getString(2) + "</th>\n"
                                + "                                        <th>Puntaje</th>\n"
                                + "                                    </tr>\n"
                                + "                                </thead>\n"
                                + "                                <tbody>\n";
                        criterios = criMo.getCriterioXDimnensionYNota(dimensiones.getInt(1), parcial, CI_estudiante);
                        while (criterios.next()) {
                            n++;
                            htmlcode += "                                    <tr>\n"
                                    + "                                        <td>" + n + ". " + criterios.getString(1) + "</td>\n"
                                    + "                                        <td><div class=\"center\">" + criterios.getInt(2) + "</div></td>\n"
                                    + "                                    </tr>\n";
                        }

                        htmlcode += "                                </tbody>\n"
                                + "                            </table>\n"
                                + "                        </div>\n"
                                + "                   </div>\n";
                        c++;
                        break;
                    case 3:
                        htmlcode += "              <div class=\"row\">\n "
                                + "                     <div class=\"col s6\">\n"
                                + "                            <table class=\"bordered\">\n"
                                + "                                <thead>\n"
                                + "                                    <tr>\n"
                                + "                                        <th>A. " + dimensiones.getString(2) + "</th>\n"
                                + "                                        <th>Puntaje</th>\n"
                                + "                                    </tr>\n"
                                + "                                </thead>\n"
                                + "                                <tbody>\n";
                        criterios = criMo.getCriterioXDimnensionYNota(dimensiones.getInt(1), parcial, CI_estudiante);
                        while (criterios.next()) {
                            n++;
                            htmlcode += "                                    <tr>\n"
                                    + "                                        <td>" + n + ". " + criterios.getString(1) + "</td>\n"
                                    + "                                        <td><div class=\"center\">" + criterios.getInt(2) + "</div></td>\n"
                                    + "                                    </tr>\n";
                        }
                        htmlcode += "                                </tbody>\n"
                                + "                            </table>\n"
                                + "                        </div>";
                        c++;
                        break;
                    case 4:
                        htmlcode += ""
                                + "                     <div class=\"col s6\">\n"
                                + "                            <table class=\"bordered\">\n"
                                + "                                <thead>\n"
                                + "                                    <tr>\n"
                                + "                                        <th>A. " + dimensiones.getString(2) + "</th>\n"
                                + "                                        <th>Puntaje</th>\n"
                                + "                                    </tr>\n"
                                + "                                </thead>\n"
                                + "                                <tbody>\n";
                        criterios = criMo.getCriterioXDimnensionYNota(dimensiones.getInt(1), parcial, CI_estudiante);
                        while (criterios.next()) {
                            n++;
                            htmlcode += "                                    <tr>\n"
                                    + "                                        <td>" + n + ". " + criterios.getString(1) + "</td>\n"
                                    + "                                        <td><div class=\"center\">" + criterios.getInt(2) + "</div></td>\n"
                                    + "                                    </tr>\n";
                        }

                        htmlcode += "                                </tbody>\n"
                                + "                            </table>\n"
                                + "                        </div>\n"
                                + "                   </div>\n";
                        c++;
                        break;
                    default:
                        htmlcode = "";
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error en getReporteParcialTutor: " + e);
        }

        return htmlcode;
    }

    public String getFechaSistema() {

        Calendar fecha = new GregorianCalendar();
        htmlcode = "";
        htmlcode = fecha.get(Calendar.DAY_OF_MONTH) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR);
        return htmlcode;
    }

    public String getTotalNotaNumeral(String CI_estudiante, int parcial) {
        if (parcial == 1) {
            id = notMo.getNotaPrimerParcial(CI_estudiante) / 2;
        } else {
            id = notMo.getNotaSegundoParcial(CI_estudiante) / 2;
        }
        return " " + id + " ";
    }

    public String getTotalNotaLiteral(String CI_estudiante, int parcial) {
        htmlcode = "";
        if (parcial == 1) {
            htmlcode = ntot.convertirLetras(notMo.getNotaPrimerParcial(CI_estudiante) / 2);
        } else {
            htmlcode = ntot.convertirLetras(notMo.getNotaSegundoParcial(CI_estudiante) / 2);
        }
        return htmlcode;
    }

    public String getFechaInicioPracticas(String CI_estudiante) {
        htmlcode = aspMo.getPeriodoInicioASP(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getFechaInicioPracticas: " + e);
        }
        return htmlcode;
    }

    public String getFechaFinPracticas(String CI_estudiante) {
        htmlcode = aspMo.getPeriodoFinASP(CI_estudiante);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getFechaFinPracticas: " + e);
        }
        return htmlcode;
    }

    public String getCantidadTotalHoras(String CI_estudiante) {

        id = aspMo.getCantidadHorasParcial(CI_estudiante, 1) + aspMo.getCantidadHorasParcial(CI_estudiante, 2);
        htmlcode = "" + id;
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getCantidadTotalHoras: " + e);
        }
        return htmlcode;
    }

}
