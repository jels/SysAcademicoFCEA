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
public class ControladorVarios extends Conexion{

    public int cantidadEstudiantes() {
        Estudiante_model estMo = new Estudiante_model();
        return estMo.contar_estudiantes();
    }

    public int cantidadDocentes() {
        Docente_model doc = new Docente_model();
        return doc.contar_docente();
    }

    public int cantidadTutores() {
        Tutor_model tut = new Tutor_model();
        return tut.contar_tutor();
    }

    public int cantidadCarreras() {
        Carrera_model carr = new Carrera_model();
        return carr.contar_carrera();
    }

    public int cantidadMaterias() {
        Materia_model mamo = new Materia_model();
        return mamo.countMaterias();
    }

    public int cantidadEmpresas() {
        Empresa_model empr = new Empresa_model();
        return empr.contar_empresa();
    }

    public String getBienvenida(String user) {
        String htmlcode = "Bienvenid@ Sr/a ";
        Tutor_model tutmo = new Tutor_model();
        htmlcode += tutmo.getNombreTutor(user);
        return htmlcode;
    }

    public String getNombreEmpresa(String user) {
        String htmlcode;
        Empresa_model emp = new Empresa_model();
        String nombreEmpresa = emp.nombre_empresa(user);
        if (nombreEmpresa.equals("")) {
            return "no existe";
        } else {
            htmlcode = nombreEmpresa;
            return htmlcode;
        }

    }

//    public String getHeaderEstudiante(String rol, String user) {
//        String htmlcode = "";
//        System.out.println("Rol:getHeaderEstudiante -" + rol);
//
//        switch (rol) {
//            case "Coordinador":
//                htmlcode += "";
//                break;
//            case "Tutor":
//                htmlcode += "";
//                break;
//            default:
//                htmlcode += "";
//                break;
//        }
//
//        return htmlcode;
//    }
    public String verMenuInicio(String rol, String user) {
        String htmlcode = "";
        ControladorVarios conV = new ControladorVarios();
        Tutor_model tutmo = new Tutor_model();

        switch (rol) {
            case "Coordinador":
                htmlcode += "<!-- aki empieza el menu -->"
                        + "<div class=\"container\">\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col s4\">\n"
                        + "                        <div class=\"card blue darken-3 yellow-text hoverable\">\n"
                        + "                            <div class=\"card-content\">\n"
                        + "                                <span class=\"card-title center\"><i class=\"medium material-icons\">face</i></span>\n"
                        + "                                <h5 class=\"center\">Estudiantes</h5>\n"
                        + "                                <p class=\"truncate\">Una descripcion de los la tabla estudiantes</p>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"card-action center\">\n"
                        + "                                <h5><a href=\"estudiante.jsp\" class=\"yellow-text\">" + conV.cantidadEstudiantes() + "</a></h5>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col s4\">\n"
                        + "                        <div class=\"card blue darken-3 yellow-text hoverable\">\n"
                        + "                            <div class=\"card-content\">\n"
                        + "                                <span class=\"card-title center\"><i class=\"medium material-icons\">card_travel</i></span>\n"
                        + "                                <h5 class=\"center\">Docentes</h5>\n"
                        + "                                <p class=\"truncate\">Una descripcion de los la tabla Docentes</p>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"card-action center\">\n"
                        + "                                <h5><a href=\"docente.jsp\" class=\"yellow-text\">" + conV.cantidadDocentes() + "</a></h5>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col s4\">\n"
                        + "                        <div class=\"card blue darken-3 yellow-text hoverable\">\n"
                        + "                            <div class=\"card-content\">\n"
                        + "                                <span class=\"card-title center\"><i class=\"medium material-icons\">contacts</i></span>\n"
                        + "                                <h5 class=\"center\">Tutores</h5>\n"
                        + "                                <p class=\"truncate\">Una descripcion de los la tabla Tutores</p>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"card-action center\">\n"
                        + "                                <h5><a href=\"tutor.jsp\" class=\"yellow-text\">" + conV.cantidadTutores() + "</a></h5>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col s4\">\n"
                        + "                        <div class=\"card blue darken-3 yellow-text hoverable\">\n"
                        + "                            <div class=\"card-content\">\n"
                        + "                                <span class=\"card-title center\"><i class=\"medium material-icons\">format_list_bulleted</i></span>\n"
                        + "                                <h5 class=\"center\">Carreras</h5>\n"
                        + "                                <p class=\"truncate\">Una descripcion de los la tabla Carreras</p>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"card-action center\">\n"
                        + "                                <h5><a href=\"carrera.jsp\" class=\"yellow-text\">" + conV.cantidadCarreras() + "</a></h5>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col s4\">\n"
                        + "                        <div class=\"card blue darken-3 yellow-text hoverable\">\n"
                        + "                            <div class=\"card-content\">\n"
                        + "                                <span class=\"card-title center\"><i class=\"medium material-icons\">storage</i></span>\n"
                        + "                                <h5 class=\"center\">Materias</h5>\n"
                        + "                                <p class=\"truncate\">Una descripcion de los la tabla Materias</p>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"card-action center\">\n"
                        + "                                <h5><a href=\"materia.jsp\" class=\"yellow-text\">" + conV.cantidadMaterias() + "</a></h5>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col s4\">\n"
                        + "                        <div class=\"card blue darken-3 yellow-text hoverable\">\n"
                        + "                            <div class=\"card-content\">\n"
                        + "                                <span class=\"card-title center\"><i class=\"medium material-icons\">store</i></span>\n"
                        + "                                <h5 class=\"center\">Empresas</h5>\n"
                        + "                                <p class=\"truncate\">Una descripcion de los la tabla Empresas</p>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"card-action center\">\n"
                        + "                                <h5><a href=\"empresa.jsp\" class=\"yellow-text\">" + conV.cantidadEmpresas() + "</a></h5>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>";
                break;
            case "Tutor":
                htmlcode += "";
                break;
            default:
                htmlcode += " ";
                break;
        }

        return htmlcode;
    }

    public String getUserViewDocente(String user) {
        String htmlcode = "";
        Usuario_model usm = new Usuario_model();
        ResultSet usuario = null;
        usuario = usm.getDatosDocente(user);
        System.out.println("user: " + user);
        try {
            usuario.next();
            htmlcode += "<div class=\"background\">\n"
                    + "     <img src = \"../../img/" + usuario.getString(2) + "\">\n"
                    + "</div>\n"
                    + "<a href =\"#!user\"><img class=\"circle\" src=\"../../img/" + usuario.getString(1) + "\"> </a>\n"
                    + "<a href =\"#!name\"><span class=\"yellow-text name\">" + usuario.getString(4) + " " + usuario.getString(5) + " " + usuario.getString(6) + " " + usuario.getString(7) + "</span></a>\n"
                    + "<a href =\"#!email\"><span class=\"yellow-text email\">" + usuario.getString(3) + "\"</span></a>\n";

        } catch (Exception e) {
            System.out.println("Error en getUserViewDocente: " + e);

        }
        System.out.println("htmlcode:------");
        return htmlcode;

    }

    public String getUserViewTutor(String user) {
        String htmlcode = "";
        Usuario_model usm = new Usuario_model();
        ResultSet usuario = null;
        usuario = usm.getDatosTutor(user);
        System.out.println("user: " + user);
        try {
            usuario.next();
            htmlcode += "<div class=\"background\">\n"
                    + "     <img src = \"../../img/" + usuario.getString(2) + "\">\n"
                    + "</div>\n"
                    + "<a href =\"#!user\"><img class=\"circle\" src=\"../../img/" + usuario.getString(1) + "\"> </a>\n"
                    + "<a href =\"#!name\"><span class=\"yellow-text name\">" + usuario.getString(4) + " " + usuario.getString(5) + " " + usuario.getString(6) + " " + usuario.getString(7) + "</span></a>\n"
                    + "<a href =\"#!email\"><span class=\"yellow-text email\">" + usuario.getString(3) + "\"</span></a>\n";

        } catch (Exception e) {
            System.out.println("Error en getUserViewTutor: " + e);

        }
        System.out.println("htmlcode:------");
        return htmlcode;

    }

    public String getEvaluacionActivo(int band) {

        String htmlcode = "";
        boolean bandera = true;
        if (band == 1) {
            htmlcode += "<li class=\"tab col s3\"><a class=\"yellow-text active\" href=\"#primer_parcial\">Primer Parcial</a></li>\n"
                    + "<li class=\"tab col s3 disabled\"><a class=\"yellow-text\" href=\"#segundo_parcial\">Segundo Parcial</a></li>";
        } else {
            htmlcode += "<li class=\"tab col s3 disabled\"><a class=\"yellow-text\" href=\"#primer_parcial\">Primer Parcial</a></li>\n"
                    + "<li class=\"tab col s3\"><a class=\"yellow-text active\" href=\"#segundo_parcial\">Segundo Parcial</a></li>";

        }

        return htmlcode;
    }

}

//      switch (rol) {
//            case "Coordinador":
//                
//                break;
//            case "Tutor":
//                
//                break;
//            default:
//                htmlcode += "";
//                break;
//        }
