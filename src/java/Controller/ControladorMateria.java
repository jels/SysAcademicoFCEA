/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WarMachine
 */
public class ControladorMateria extends Conexion {

    public int contarMateria() {
        Materia_model mamo = new Materia_model();
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en contarMateria.getCloseConexion: " + e);
        }
        return mamo.countMaterias();
    }

    public ResultSet getListaIDCriterioXEst(String CI_estudiante) {

        Criterios_model criMo = new Criterios_model();

        return criMo.getListaCriterioXEst(CI_estudiante);
    }

    public String verMaterias() {
        String htmlcode = "          <div class=\"container\">\n"
                + "                        <div class=\"row\">\n"
                + "                            <div class=\"col s12\">\n"
                + "                                <h1 class=\"center yellow-text\">Materias</h1>\n"
                + "                                <a href=\"#search\" class=\"waves-effect waves-light yellow accent-2 blue-text text-darken-3 btn-large modal-trigger\"><i class=\"material-icons right\">search</i>Buscar</a>\n"
                + "                                <a href=\"#new\" class=\"waves-effect waves-light yellow accent-2 blue-text text-darken-3 btn-large right modal-trigger\"><i class=\"material-icons left\">person_add</i>Nuevo</a>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>"
                + "                 <div class=\"container\">\n"
                + "                        <table class=\"highlight responsive-table blue darken-3 yellow-text\">\n"
                + "                            <thead>\n"
                + "                                <tr>\n"
                + "                                    <th>#</th>\n"
                + "                                    <th>Carrera</th>\n"
                + "                                    <th>Nombre</th>\n"
                + "                                    <th>Descripcion</th>\n"
                + "                                    <th>Semestre</th>\n"
                + "                                    <th>Horas</th>\n"
                + "                                    <th>Estado</th>\n"
                + "                                    <th class=\"center-align\">Ver</th>\n"
                + "                                    <th class=\"center-align\">Actualizar</th>\n"
                + "                                    <th class=\"center-align\">Dar de Baja</th>\n"
                + "                                    <th class=\"center-align\">Eliminar</th>\n"
                + "                                </tr>\n"
                + "                            </thead>\n"
                + "                            <tbody>\n";
        ResultSet rs;
        Materia_model matm = new Materia_model();
        rs = matm.ver_materias();
        int i = 1;
        if (rs != null) {
            try {
                while (rs.next()) {
                    System.out.println(rs.getString(7));
                    htmlcode += "                <tr>\n"
                            + "                    <td>" + i + "</td>\n"
                            + "                    <td>" + rs.getString(7) + "</td>\n"
                            + "                    <td>" + rs.getString(2) + "</td>\n";
                    if (rs.getString(3).length() > 20) {
                        htmlcode += "                    <td><p>" + rs.getString(3).substring(0, 20) + "</p></td>\n";
                    } else {
                        htmlcode += "                    <td><p>" + rs.getString(3) + "</p></td>\n";
                    }
                    htmlcode += "                    <td>" + rs.getString(4) + "</td>\n"
                            + "                    <td>" + rs.getString(5) + "</td>\n";
                    if (rs.getInt(6) == 1) {
                        htmlcode += "                    <td>Activo</td>\n";
                    } else {
                        htmlcode += "                    <td>Inactivo</td>\n";

                    }
                    htmlcode += "    <td><div class=\"center-align\"><a href=\"#show_mat\" data-id=\"" + rs.getInt(1) + "\" id=\"ver_materia\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text modal-trigger\" data-position=\"button\" data-tooltip=\"Ver\"><i class=\"material-icons yellow-text\">description</i></a></div></td>\n"
                            + "     <td><div class=\"center-align\"><a data-id=\"" + rs.getInt(1) + "\" id=\"actualizar_materia\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text modal-trigger\" data-position=\"button\" data-tooltip=\"Actualizar\"><i class=\"material-icons yellow-text\">border_color</i></a></div></td>\n"
                            + "     <td><div class=\"center-align\"><a id=\"baja_materia\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Dar de Baja\"><i class=\"material-icons yellow-text\">redo</i></a></div></td>\n"
                            + "     <td><div class=\"center-align\"><a id=\"eliminar_materia\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Eliminar\"><i class=\"material-icons yellow-text\">delete_forever</i></a></div></td>\n"
                            + "  </tr>"
                            + "";
                    i++;

                }
            } catch (SQLException ex) {
                System.out.println("Error en verMaterias: " + ex);
            }
        } else {
            htmlcode += "";

        }
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verMaterias.getCloseConexion: " + e);
        }
        return htmlcode += "                        </tbody>\n"
                + "                        </table>\n"
                + "                    </div>";
    }

    public String modalNewMateria() {
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modalNewMateria.getCloseConexion: " + e);
        }
        return "";
    }

    public String modal_show_materia() {
        System.out.println("ID: ");
        String htmlcode = "";
        Materia_model matMo = new Materia_model();
        ResultSet mat = null;
        Dimension_model dimMo = new Dimension_model();
        mat = matMo.getMateria(1);
        ResultSet dimen = null;
        if (mat != null) {

            try {
                mat.next();
                System.out.println("nombre: " + mat.getString(3));
                htmlcode += "<div class=\"modal-content\">"
                        + "     <h2>" + mat.getString(3) + "</h2>\n"
                        + "       <p>" + mat.getString(4) + "</p>\n"
                        + "     <h4>Las Dimensiones...</h4>"
                        + "       <ul class=\"collapsible popout blue darken-3 yellow-text\" data-collapsible=\"accordion\">";
                dimen = dimMo.getDimensiones(1);
                while (dimen.next()) {
                    System.out.println("id: " + dimen.getInt(1));
                    htmlcode += "       <li>\n"
                            + "             <div class=\"collapsible-header blue darken-3\">\n"
                            + "                 <i class=\"material-icons rigth\">details</i>"
                            + "                 " + dimen.getString(2) + ""
                            + "                 <span class=\"badge yellow-text\">5</span>\n"
                            + "             </div>\n"
                            + "             <div class=\"collapsible-body\">\n";
                    htmlcode += verCriterios(dimen.getInt(1));

                    htmlcode += "         </div>\n"
                            + "       </li>";
                }
                htmlcode += "  </ul>\n";

            } catch (Exception e) {
                System.out.println("Error en modal_show_materia: " + e);
            }

        } else {
            htmlcode += "";
        }
        htmlcode += "    </div>\n"
                + "    <div class=\"modal-footer blue darken-3\">\n"
                + "      <a href=\"#!\" class=\"modal-action modal-close waves-effect waves-yellow yellow accent-2  btn-flat\">OK</a>\n"
                + "    </div>\n"
                + "          ";
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modal_show_materia.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    private String verCriterios(int dimen) {
        String htmlcode = "";
        ResultSet crit = null;
        Criterios_model criMo = new Criterios_model();
        crit = criMo.getCriterios(dimen);
        System.out.println("id: " + dimen);
        int i = 0;

        htmlcode += "      <table class=\"highlight responsive-table blue darken-3 yellow-text\">\n"
                + "        <thead>\n"
                + "          <tr>\n"
                + "              <th>#</th>\n"
                + "              <th>Nombre</th>\n"
                + "              <th>Ver</th>\n"
                + "              <th>Actualizar</th>\n"
                + "              <th>Dar de Baja</th>\n"
                + "          </tr>\n"
                + "        </thead>\n";

        try {
            while (crit.next()) {
                i++;
                htmlcode += "<tr>\n"
                        + "    <td>" + i + "</td>\n"
                        + "    <td>" + crit.getString(1) + "</td>\n"
                        + "    <td><div class=\"center-align\"><a href=\"#show_criterio\" data-id=\"" + crit.getInt(2) + "\" id=\"ver_materia\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text modal-trigger\" data-position=\"button\" data-tooltip=\"Ver\"><i class=\"material-icons yellow-text\">description</i></a></div></td>\n"
                        + "     <td><div class=\"center-align\"><a data-id=\"" + crit.getInt(2) + "\" id=\"actualizar_materia\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text modal-trigger\" data-position=\"button\" data-tooltip=\"Actualizar\"><i class=\"material-icons yellow-text\">border_color</i></a></div></td>\n"
                        + "     <td><div class=\"center-align\"><a id=\"baja_materia\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Dar de Baja\"><i class=\"material-icons yellow-text\">redo</i></a></div></td>\n"
                        + "</tr>";

                System.out.println("criterio..." + crit.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Error getCriterios: " + e);
        }
        htmlcode += "\n"
                + "        <tbody>\n"
                + "        </tbody>\n"
                + "      </table>\n"
                + "            \n"
                + "";
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verCriterios.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String modal_show_criterio() {
        System.out.println("ID: ");
        String htmlcode = "";
        Criterios_model criMo = new Criterios_model();
        ResultSet cri = null;
        cri = criMo.getViewCriterio(1);
        if (cri != null) {

            try {
                cri.next();
                System.out.println("nombre: " + cri.getString(3));
                htmlcode += "<div class=\"modal-content\">"
                        + "     <h3>" + cri.getString(2) + "</h3>\n"
                        + "    </div>\n";
            } catch (Exception e) {
                System.out.println("Error en modal_show_criterio: " + e);
            }

        } else {
            htmlcode += " ";
        }
        htmlcode += "    <div class=\"modal-footer blue darken-3\">\n"
                + "      <a href=\"#\" class=\"modal-action modal-close waves-effect waves-yellow yellow accent-2  btn-flat\">OK</a>\n"
                + "    </div>\n"
                + "          ";
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en modal_show_criterio.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String getEvaluacion(String CI_Estudiante) {
        String htmlcode = "";

        System.out.println("Estudiante _getEvaluacion: " + CI_Estudiante);

        Estudiante_model estMo = new Estudiante_model();
        Notas_model notMo = new Notas_model();
        Materia_model matMo = new Materia_model();
        Dimension_model dimMo = new Dimension_model();
        int idMateria = matMo.getIdMateria(CI_Estudiante);
        ResultSet nombreEstudiante = null;
        ResultSet dimensiones = null;
        nombreEstudiante = estMo.getNombreEstudiante(CI_Estudiante);
        boolean aproboPrimerParcial = notMo.llenoPrimerParcial(CI_Estudiante);
        boolean aproboSegundoParcial = notMo.llenoSegundoParcial(CI_Estudiante);
        boolean evaluacionCompleta = notMo.evaluacionCompletaDocente(CI_Estudiante);
        System.out.println("EvaluacionCompleta: " + evaluacionCompleta);
        ResultSet criterios;
        Criterios_model criMo = new Criterios_model();
        System.out.println("IDMAteria: " + idMateria);

        int i = 1;
        int c = 1;
        double nota = 0;
        try {
            nombreEstudiante.next();
            if (evaluacionCompleta) {
                nota = (notMo.getNotaPrimerParcial(CI_Estudiante) / 2) * 0.35;
                htmlcode += "<div class=\"container\">\n"
                        + "     <div class=\"row\">\n"
                        + "       <h3 class=\"center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                        + "       <div class=\"col s6\">\n"
                        + "              <h4 class=\"center\">Primer Parcial</h4>\n"
                        + "              <h3 class=\"center\">" + nota + "</h3>\n"
                        + "       </div>\n";
                nota = (notMo.getNotaSegundoParcial(CI_Estudiante) / 2) * 0.35;
                htmlcode += "       <div class=\"col s6\">\n"
                        + "              <h4 class=\"center\">Segundo Parcial</h4>\n"
                        + "              <h3 class=\"center\">" + nota + "</h3>\n"
                        + "       </div>\n"
                        + " </div>\n";
            } else if (aproboPrimerParcial) {
                nota = notMo.getNotaPrimerParcial(CI_Estudiante);
                htmlcode += ""
                        + "<div class=\"row\">\n"
                        + "       <h3 class=\"center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                        + "       <div class=\"col s6\">\n"
                        + "              <h4 class=\"center\">Primer Parcial</h4>\n"
                        + "              <h3 class=\"center\">" + nota + "</h3>\n"
                        + "       </div>\n";
                if (aproboSegundoParcial) {
                    nota = notMo.getNotaSegundoParcial(CI_Estudiante);
                    htmlcode += "       <div class=\"col s6\">\n"
                            + "              <h4 class=\"center\">Segundo Parcial</h4>\n"
                            + "              <h3 class=\"center\">" + nota + "</h3>\n"
                            + "       </div>\n";
                } else {
                    htmlcode += "      <div class=\"col s6\">\n"
                            + " <div class=\"row\">\n"
                            + "    <form>"
                            + "       \n";
                    htmlcode += "<h5 class=\"center\">Segundo Parcial</h5>\n";
                    dimensiones = dimMo.getDimensiones(idMateria);
                    while (dimensiones.next()) {

                        switch (i) {
                            case 1:
                                htmlcode += "<div class=\"col s6\">\n"
                                        + "    <table class=\"bordered\">\n"
                                        + "         <thead>\n"
                                        + "             <tr>\n"
                                        + "                   <th>A - " + dimensiones.getString(2) + "</th>\n"
                                        + "                   <th>Puntaje</th>\n"
                                        + "             </tr>\n"
                                        + "         </thead>\n"
                                        + "         <tbody>\n";
                                criterios = criMo.getCriterios(dimensiones.getInt(1));
                                while (criterios.next()) {
                                    System.out.println("Criterio: " + criterios.getString(1));
                                    htmlcode += "             <tr>\n"
                                            + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                            + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                            + "             </tr>\n";
                                    c++;
                                }
                                htmlcode += "         </tbody>\n"
                                        + "    </table>\n";
                                break;
                            case 2:
                                htmlcode += "    <table class=\"bordered\">\n"
                                        + "         <thead>\n"
                                        + "             <tr>\n"
                                        + "                    <th>B - " + dimensiones.getString(2) + "</th>\n"
                                        + "                    <th>Puntaje</th>\n"
                                        + "             </tr>\n"
                                        + "         </thead>\n"
                                        + "         <tbody>\n";
                                criterios = criMo.getCriterios(dimensiones.getInt(1));
                                while (criterios.next()) {
                                    System.out.println("Criterio: " + criterios.getString(1));
                                    htmlcode += "             <tr>\n"
                                            + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                            + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                            + "             </tr>\n";
                                    c++;
                                }
                                htmlcode += "         </tbody>\n"
                                        + "    </table>\n"
                                        + "</div>";
                                break;
                            case 3:
                                htmlcode += "<div class=\"col s6\">\n"
                                        + "    <table class=\"bordered\">\n"
                                        + "         <thead>\n"
                                        + "             <tr>\n"
                                        + "                   <th>C - " + dimensiones.getString(2) + "</th>\n"
                                        + "                   <th>Puntaje</th>\n"
                                        + "             </tr>\n"
                                        + "         </thead>\n"
                                        + "         <tbody>\n";
                                criterios = criMo.getCriterios(dimensiones.getInt(1));
                                while (criterios.next()) {
                                    System.out.println("Criterio: " + criterios.getString(1));
                                    htmlcode += "             <tr>\n"
                                            + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                            + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                            + "             </tr>\n";
                                    c++;
                                }
                                htmlcode += "         </tbody>\n"
                                        + "    </table>\n";
                                break;
                            case 4:
                                htmlcode += "    <table class=\"bordered\">\n"
                                        + "         <thead>\n"
                                        + "             <tr>\n"
                                        + "                   <th>D - " + dimensiones.getString(2) + "</th>\n"
                                        + "                   <th>Puntaje</th>\n"
                                        + "             </tr>\n"
                                        + "         </thead>\n"
                                        + "         <tbody>\n";
                                criterios = criMo.getCriterios(dimensiones.getInt(1));
                                while (criterios.next()) {
                                    System.out.println("Criterio: " + criterios.getString(1));
                                    htmlcode += "             <tr>\n"
                                            + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                            + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                            + "             </tr>\n";
                                    c++;
                                }
                                htmlcode += "         </tbody>\n"
                                        + "    </table>\n"
                                        + "</div>\n";
                                break;
                            default:
                                break;
                        }
                        i++;
                    }
                    htmlcode += "        </form>\n"
                            + "     </div>\n"
                            + "     <div class=\"col s6 center-aling\">\n"
                            + "         <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left tooltipped\" data-position=\"button\" data-tooltip=\"Guardar\" type=\"button\" data-id=\"" + CI_Estudiante + "\" id=\"guardarNuevaNota\">\n"
                            + "             Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                            + "         </button>\n"
                            + "     <br><br><br><br>\n"
                            + "     </div>\n"
                            + "     <div id=\"notaGuardada\" class\"col s6 center-aling\">\n"
                            + "     </div>\n"
                            + "</div>\n"
                            + "\n";
                }
            } else {
                htmlcode += "      <div class=\"col s6\">\n"
                        + " <div class=\"row\">\n"
                        + "    <form>"
                        + "       \n";
                htmlcode += "<h4 class=\"center\">Primer Parcial</h4>\n";
                dimensiones = dimMo.getDimensiones(idMateria);
                while (dimensiones.next()) {

                    switch (i) {
                        case 1:
                            htmlcode += "<div class=\"col s6\">\n"
                                    + "    <table class=\"bordered\">\n"
                                    + "         <thead>\n"
                                    + "             <tr>\n"
                                    + "                   <th>A - " + dimensiones.getString(2) + "</th>\n"
                                    + "                   <th>Puntaje</th>\n"
                                    + "             </tr>\n"
                                    + "         </thead>\n"
                                    + "         <tbody>\n";
                            criterios = criMo.getCriterios(dimensiones.getInt(1));
                            while (criterios.next()) {
                                System.out.println("Criterio: " + criterios.getString(1));
                                htmlcode += "             <tr>\n"
                                        + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                        + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                        + "             </tr>\n";
                                c++;
                            }
                            htmlcode += "         </tbody>\n"
                                    + "    </table>\n";
                            break;
                        case 2:
                            htmlcode += "    <table class=\"bordered\">\n"
                                    + "         <thead>\n"
                                    + "             <tr>\n"
                                    + "                    <th>B - " + dimensiones.getString(2) + "</th>\n"
                                    + "                    <th>Puntaje</th>\n"
                                    + "             </tr>\n"
                                    + "         </thead>\n"
                                    + "         <tbody>\n";
                            criterios = criMo.getCriterios(dimensiones.getInt(1));
                            while (criterios.next()) {
                                System.out.println("Criterio: " + criterios.getString(1));
                                htmlcode += "             <tr>\n"
                                        + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                        + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                        + "             </tr>\n";
                                c++;
                            }
                            htmlcode += "         </tbody>\n"
                                    + "    </table>\n"
                                    + "</div>";
                            break;
                        case 3:
                            htmlcode += "<div class=\"col s6\">\n"
                                    + "    <table class=\"bordered\">\n"
                                    + "         <thead>\n"
                                    + "             <tr>\n"
                                    + "                   <th>C - " + dimensiones.getString(2) + "</th>\n"
                                    + "                   <th>Puntaje</th>\n"
                                    + "             </tr>\n"
                                    + "         </thead>\n"
                                    + "         <tbody>\n";
                            criterios = criMo.getCriterios(dimensiones.getInt(1));
                            while (criterios.next()) {
                                System.out.println("Criterio: " + criterios.getString(1));
                                htmlcode += "             <tr>\n"
                                        + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                        + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                        + "             </tr>\n";
                                c++;
                            }
                            htmlcode += "         </tbody>\n"
                                    + "    </table>\n";
                            break;
                        case 4:
                            htmlcode += "    <table class=\"bordered\">\n"
                                    + "         <thead>\n"
                                    + "             <tr>\n"
                                    + "                   <th>D - " + dimensiones.getString(2) + "</th>\n"
                                    + "                   <th>Puntaje</th>\n"
                                    + "             </tr>\n"
                                    + "         </thead>\n"
                                    + "         <tbody>\n";
                            criterios = criMo.getCriterios(dimensiones.getInt(1));
                            while (criterios.next()) {
                                System.out.println("Criterio: " + criterios.getString(1));
                                htmlcode += "             <tr>\n"
                                        + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                        + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                        + "             </tr>\n";
                                c++;
                            }
                            htmlcode += "         </tbody>\n"
                                    + "    </table>\n"
                                    + "</div>\n";
                            break;
                        default:
                            break;
                    }
                    i++;
                }
                htmlcode += "        </form>\n"
                        + "     </div>\n"
                        + "     <div class=\"col s6 center-aling\">\n"
                        + "         <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left tooltipped\" data-position=\"button\" data-tooltip=\"Guardar\" type=\"button\" data-id=\"" + CI_Estudiante + "\" id=\"guardarNuevaNota\">\n"
                        + "             Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                        + "         </button>\n"
                        + "     <br><br><br><br>\n"
                        + "     </div>\n"
                        + "     <div id=\"notaGuardada\" class=\"col s6 center-aling\">\n"
                        + "     </div>\n"
                        + "</div>\n"
                        + "\n"
                        + ""
                        + "         <div class=\"col s6\">\n"
                        + "             <h4 class=\"center\">Segundo Parcial</h4>\n"
                        + "             <h4 class=\"yellow accent-2 red-text center\">Aun sin Asignar Nota</h4>\n"
                        + "         </div>\n"
                        + "     \n"
                        + "\n";
            }

        } catch (Exception e) {
            System.out.println("Error getEvaluacion: " + e);
        }

        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getEvaluacion.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String getEvaluacionDocente(String CI_Estudiante) {
        String htmlcode = "";

        System.out.println("Estudiante _getEvaluacion: " + CI_Estudiante);

        Estudiante_model estMo = new Estudiante_model();
        Notas_model notMo = new Notas_model();
        Materia_model matMo = new Materia_model();
        Dimension_model dimMo = new Dimension_model();
        int idMateria = matMo.getIdMateria(CI_Estudiante);
        ResultSet nombreEstudiante = null;
        ResultSet dimensiones = null;
        nombreEstudiante = estMo.getNombreEstudiante(CI_Estudiante);
        boolean aproboPrimerParcial = notMo.llenoPrimerParcial(CI_Estudiante);
        boolean aproboSegundoParcial = notMo.llenoSegundoParcial(CI_Estudiante);
        boolean evaluacionCompleta = notMo.evaluacionCompletaDocente(CI_Estudiante);
        System.out.println("EvaluacionCompleta: " + evaluacionCompleta);
        ResultSet criterios;
        Criterios_model criMo = new Criterios_model();
        System.out.println("IDMAteria: " + idMateria);
        AsignacionPracticas_model aspMo = new AsignacionPracticas_model();

        int i = 1;
        int c = 1;
        double nota = 0;
        try {
            nombreEstudiante.next();
            if (aspMo.getRealizaPractica(CI_Estudiante)) {
                if (evaluacionCompleta) {
                    nota = (notMo.getNotaPrimerParcial(CI_Estudiante) / 2) * 0.35;
                    htmlcode += "<div class=\"row\">\n"
                            + "       <h3 class=\"center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                            + "       <div class=\"col s4\">\n"
                            + "              <h4 class=\"center\">Primer Parcial</h4>\n"
                            + "              <h3 class=\"center\">" + nota + "</h3>\n"
                            + "       </div>\n";
                    nota = (notMo.getNotaSegundoParcial(CI_Estudiante) / 2) * 0.35;
                    htmlcode += "       <div class=\"col s4\">\n"
                            + "              <h4 class=\"center\">Segundo Parcial</h4>\n"
                            + "              <h3 class=\"center\">" + nota + "</h3>\n"
                            + "       </div>\n";
                    nota = (notMo.getNotaExamenFinal(CI_Estudiante) / 2) * 0.30;
                    htmlcode += "       <div class=\"col s4\">\n"
                            + "             <h4 class=\"center\">Examen Final</h4>\n"
                            + "             <h3 class=\"center\">" + nota + "</h3>\n"
                            + "       </div>\n"
                            + "</div>";
                } else if (aproboPrimerParcial) {
                    nota = (notMo.getNotaPrimerParcial(CI_Estudiante) / 2) * 0.35;
                    htmlcode += "<div class=\"row\">\n"
                            + "       <h3 class=\"center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                            + "       <div class=\"col s3\">\n"
                            + "              <h4 class=\"center\">Primer Parcial</h4>\n"
                            + "              <h3 class=\"center\">" + nota + "</h3>\n"
                            + "       </div>\n";
                    if (aproboSegundoParcial) {
                        nota = (notMo.getNotaSegundoParcial(CI_Estudiante) / 2) * 0.35;
                        htmlcode += "       <div class=\"col s3\">\n"
                                + "              <h4 class=\"center\">Segundo Parcial</h4>\n"
                                + "              <h3 class=\"center\">" + nota + "</h3>\n"
                                + "       </div>\n";
                        if (evaluacionCompleta) {

                        } else {
                            htmlcode += "      <div class=\"col s6\">\n"
                                    + " <div class=\"row\">\n"
                                    + "    <form>"
                                    + "       \n";
                            htmlcode += "<h5 class=\"center\">Evaluacion Examen Final</h5>\n";
                            dimensiones = dimMo.getDimensiones(idMateria);
                            while (dimensiones.next()) {

                                switch (i) {
                                    case 1:
                                        htmlcode += "<div class=\"col s6\">\n"
                                                + "    <table class=\"bordered\">\n"
                                                + "         <thead>\n"
                                                + "             <tr>\n"
                                                + "                   <th>A - " + dimensiones.getString(2) + "</th>\n"
                                                + "                   <th>Puntaje</th>\n"
                                                + "             </tr>\n"
                                                + "         </thead>\n"
                                                + "         <tbody>\n";
                                        criterios = criMo.getCriterios(dimensiones.getInt(1));
                                        while (criterios.next()) {
                                            System.out.println("Criterio: " + criterios.getString(1));
                                            htmlcode += "             <tr>\n"
                                                    + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                                    + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                                    + "             </tr>\n";
                                            c++;
                                        }
                                        htmlcode += "         </tbody>\n"
                                                + "    </table>\n";
                                        break;
                                    case 2:
                                        htmlcode += "    <table class=\"bordered\">\n"
                                                + "         <thead>\n"
                                                + "             <tr>\n"
                                                + "                    <th>B - " + dimensiones.getString(2) + "</th>\n"
                                                + "                    <th>Puntaje</th>\n"
                                                + "             </tr>\n"
                                                + "         </thead>\n"
                                                + "         <tbody>\n";
                                        criterios = criMo.getCriterios(dimensiones.getInt(1));
                                        while (criterios.next()) {
                                            System.out.println("Criterio: " + criterios.getString(1));
                                            htmlcode += "             <tr>\n"
                                                    + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                                    + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                                    + "             </tr>\n";
                                            c++;
                                        }
                                        htmlcode += "         </tbody>\n"
                                                + "    </table>\n"
                                                + "</div>";
                                        break;
                                    case 3:
                                        htmlcode += "<div class=\"col s6\">\n"
                                                + "    <table class=\"bordered\">\n"
                                                + "         <thead>\n"
                                                + "             <tr>\n"
                                                + "                   <th>C - " + dimensiones.getString(2) + "</th>\n"
                                                + "                   <th>Puntaje</th>\n"
                                                + "             </tr>\n"
                                                + "         </thead>\n"
                                                + "         <tbody>\n";
                                        criterios = criMo.getCriterios(dimensiones.getInt(1));
                                        while (criterios.next()) {
                                            System.out.println("Criterio: " + criterios.getString(1));
                                            htmlcode += "             <tr>\n"
                                                    + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                                    + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                                    + "             </tr>\n";
                                            c++;
                                        }
                                        htmlcode += "         </tbody>\n"
                                                + "    </table>\n";
                                        break;
                                    case 4:
                                        htmlcode += "    <table class=\"bordered\">\n"
                                                + "         <thead>\n"
                                                + "             <tr>\n"
                                                + "                   <th>D - " + dimensiones.getString(2) + "</th>\n"
                                                + "                   <th>Puntaje</th>\n"
                                                + "             </tr>\n"
                                                + "         </thead>\n"
                                                + "         <tbody>\n";
                                        criterios = criMo.getCriterios(dimensiones.getInt(1));
                                        while (criterios.next()) {
                                            System.out.println("Criterio: " + criterios.getString(1));
                                            htmlcode += "             <tr>\n"
                                                    + "                   <td value=\"" + criterios.getInt(2) + "\" id=\"criterio" + c + "\">" + c + " - " + criterios.getString(1) + "</td>\n"
                                                    + "                   <td><input id=\"nota" + c + "\" type=\"number\" min=\"1\" max=\"10\" class=\"validate bold\" style=\"width: 60px; font-size: 30px\"></td>\n"
                                                    + "             </tr>\n";
                                            c++;
                                        }
                                        htmlcode += "         </tbody>\n"
                                                + "    </table>\n"
                                                + "</div>\n";
                                        break;
                                    default:
                                        break;
                                }
                                i++;
                            }
                            htmlcode += "        </form>\n"
                                    + "     </div>\n"
                                    + "     <div class=\"col s6 center-aling\">\n"
                                    + "         <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left tooltipped\" data-position=\"button\" data-tooltip=\"Guardar\" type=\"button\" data-id=\"" + CI_Estudiante + "\" id=\"guardarNuevaNota\">\n"
                                    + "             Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                                    + "         </button>\n"
                                    + "     <br><br><br><br>\n"
                                    + "     </div>\n"
                                    + "     <div id=\"notaGuardada\" class=\"col s6 center-aling\">\n"
                                    + "     </div>\n"
                                    + "</div>\n"
                                    + "\n";

                        }
                    } else {
                        htmlcode += "       <div class=\"col s4\">\n"
                                + "              <h4 class=\"center\">Segundo Parcial</h4>\n"
                                + "              <h4 class=\"yellow accent-2 red-text center\">Aun sin Asignar Nota</h4>\n"
                                + "         </div>\n"
                                + "         <div class=\"col s4\">\n"
                                + "              <h4 class=\"center\">Examen Final</h4>\n"
                                + "              <h4 class=\"yellow accent-2 red-text center\">Asignacion no Disponible Aun</h4>\n"
                                + "          </div>\n"
                                + "</div>";
                    }
                } else {
                    htmlcode += "<div class=\"container\">\n"
                            + "     <div class=\"row\">\n"
                            + "             <h3 class=\"center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                            + "         <div class=\"col s4\">\n"
                            + "             <h4 class=\"center\">Primer Parcial</h4>\n"
                            + "             <h4 class=\"yellow accent-2 red-text center\">Aun sin Asignar Nota</h4>\n"
                            + "         </div>\n"
                            + "         <div class=\"col s4\">\n"
                            + "             <h4 class=\"center\">Segundo Parcial</h4>\n"
                            + "             <h4 class=\"yellow accent-2 red-text center\">Aun sin Asignar Nota</h4>\n"
                            + "         </div>\n"
                            + "         <div class=\"col s4\">\n"
                            + "             <h4 class=\"center\">Examen Final</h4>\n"
                            + "             <h4 class=\"yellow accent-2 red-text center\">Asignacion no Disponible Aun</h4>\n"
                            + "         </div>\n"
                            + "     </div>\n"
                            + "</div>\n";
                }

            } else {
                htmlcode += "\n"
                        + "    <div class=\"row\">\n"
                        + "        <h3 class=\"center\">" + nombreEstudiante.getString(3) + " " + nombreEstudiante.getString(4) + ", " + nombreEstudiante.getString(1) + " " + nombreEstudiante.getString(2) + "</h3>\n"
                        + "    </div>\n"
                        + "    <div class=\"col s12 center-align\">\n"
                        + "        <a href=\"asignar_practica.jsp?ci=" + nombreEstudiante.getString(5) + "\" id=\"asignar_practica\" class=\"waves-effect waves-light waves-teal yellow accent-2 blue-text btn tooltipped\" data-position=\"button\" data-tooltip=\"Asignar Practica\"><i class=\"material-icons left\">clear_all</i>Asignar Practica</a>\n"
                        + "         <br>\n"
                        + "         <br>\n"
                        + "         <br>\n"
                        + "         <br>\n"
                        + "    </div>\n"
                        + "";
            }
        } catch (Exception e) {
            System.out.println("Error getEvaluacion: " + e);
        }

        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getEvaluacion.getCloseConexion: " + e);
        }
        System.out.println("htmlcode getEvaluacionDocente: ");
        System.out.println(htmlcode);
        return htmlcode;
    }

}
