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
public class ControladorCarrera extends Conexion {

    int numero;
    String htmlcode = "";
    boolean bandera;
    Carrera_model carMo = new Carrera_model();
    Materia_model matMo = new Materia_model();
    Coordinador_model coMo = new Coordinador_model();

    public int cantidadCarreras(String usuario) {
        numero = carMo.contar_carrera(2);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en cantidadCarreras.getCloseConexion: " + e);
        }
        return numero;
    }

    public String verCarrera(String abreviatura) {
        htmlcode = "";
        try {
            String nombreCarrera = carMo.getNombreCarrera(abreviatura);
            getCloseConexion();
            String nombreCoordinador = carMo.getNombreCoordinador(abreviatura);
            getCloseConexion();
            String fotoCoordinador = carMo.getFotoCoordinador(abreviatura);
            getCloseConexion();
            numero = matMo.getMateriasXCarrera(abreviatura);
            getCloseConexion();
            htmlcode = "<div class=\"container\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s12 center\">\n"
                    + "                                <h4>Carrera</h4>\n"
                    + "                                <h3>" + nombreCarrera + "</h3> \n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s12 center\">\n"
                    + "                                <h5>Coordinador</h5>\n"
                    + "                                <h4>" + nombreCoordinador + "</h4>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s5\"></div>\n"
                    + "                            <div class=\"col s2\">\n"
                    + "                                <img class=\"center responsive-img materialboxed circle\" src=\"../../img/fcea/coordinadores/" + fotoCoordinador + "\" width=\"200\" alt=\"imagen\" >    \n"
                    + "                            </div>\n"
                    + "                            <div class=\"col s5\"></div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <div class=\"col s12 center\">\n"
                    + "                                <h4>Materias Activas</h4>\n"
                    + "                                <h2>" + numero + "</h2> \n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </div>\n";
        } catch (Exception e) {
            System.out.println("Error en cantidadCarreras.getCloseConexion: " + e);
        }
        return htmlcode;
    }

    public String verCarreras(String user) {
        ResultSet carreras;
        carreras = carMo.getCarreras(2);
        int i = 1;
        htmlcode = "";
        htmlcode = "          <div class=\"container\">\n"
                + "                        <div class=\"row\">\n"
                + "                            <div class=\"col s12\">\n"
                + "                                <h3 class=\"center yellow-text\">Carreras de la</h3>\n"
                + "                                <h4 class=\"center yellow-text\">Facultad de Ciencias Economicas y Administrativas</h4>\n"
                + "                                <a href=\"#new\" class=\"waves-effect waves-light yellow accent-2 blue-text text-darken-3 btn-large right modal-trigger\"><i class=\"material-icons left\">person_add</i>Nueva</a>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>"
                + "                 <div class=\"container\">\n"
                + "                        <table class=\"highlight responsive-table blue darken-3 yellow-text\">\n"
                + "                            <thead>\n"
                + "                                <tr class=\"\">\n"
                + "                                    <th>#</th>\n"
                + "                                    <th>Nombre</th>\n"
                + "                                    <th>Abreviatura</th>\n"
                + "                                    <th>Descripcion</th>\n"
                + "                                    <th>Estado</th>\n"
                + "                                    <th class=\"center-align\">Ver</th>\n"
                + "                                    <th class=\"center-align\">Dar de Baja</th>\n"
                + "                                </tr>\n"
                + "                            </thead>\n"
                + "                            <tbody>\n";

        if (carreras == null) {

        } else {
            try {
                while (carreras.next()) {
                    htmlcode += "                <tr>\n"
                            + "                    <td>" + i + "</td>\n"
                            + "                    <td>" + carreras.getString(2) + "</td>\n"
                            + "                    <td id=\"abreviatura_carrera\">" + carreras.getString(3) + "</td>\n"
                            + "                    <td>" + carreras.getString(4) + "</td>\n";
                    if (carreras.getInt(5) == 1) {
                        htmlcode += "                    <td>Activo</td>\n";
                    } else {
                        htmlcode += "                    <td>Inactivo</td>\n";

                    }
                    htmlcode += "                  <td><div class=\"center-align\">  <a href=\"carrera_ver.jsp?carrera=" + carreras.getString(3) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Ver - Actualizar\"><i class=\"material-icons yellow-text\">visibility</i></a></div></td>\n"
                            + "                    <td><div class=\"center-align\">  <a id=\"baja_carrera\" data-id=\"" + carreras.getString(3) + "\" class=\"btn-floating btn tooltipped waves-effect waves-light blue yellow-text\" data-position=\"button\" data-tooltip=\"Dar de Baja\"><i class=\"material-icons yellow-text\">redo</i></a></div></td>\n"
                            + "                  </tr>"
                            + "";
                    i++;

                }
            } catch (SQLException ex) {
                System.out.println("Error en verEstudiantes: " + ex);
            }

        }
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en verEstudiantes.getCloseConexion: " + e);
        }
        return htmlcode += "                        </tbody>\n"
                + "                        </table>\n"
                + "                    </div>";
    }

    public boolean newCoordinador(Coordinador coordinador) {
        bandera = coMo.crear_coordinador(coordinador);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en newCoordinador.getCloseConexion: " + e);
        }
        return bandera;
    }

    public int getIdCoordinador(String ciCoordinador) {
        numero = coMo.findIDCoordinador(ciCoordinador);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getIdCoordinador.getCloseConexion: " + e);
        }
        return numero;
    }

    public boolean boorarCoordinador(String ciCoordinador) {
        bandera = coMo.borrar_coordinador(ciCoordinador);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en boorarCoordinador.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean newCarrera(Carrera carrera) {
        bandera = carMo.nuevaCarrera(carrera);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en newCarrera.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean bajaCarrera(String abreviatura) {
        if (carMo.getEstadoCarrera(abreviatura) == 1) {
            bandera = carMo.baja_carrera(abreviatura, 0);
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en bajaCarrera.getCloseConexion: " + e);
            }
        } else {
            bandera = carMo.baja_carrera(abreviatura, 1);
            try {
                getCloseConexion();
            } catch (Exception e) {
                System.out.println("Error en bajaCarrera.getCloseConexion: " + e);
            }
        }
        return bandera;
    }

    public String editarCarrera(String carrera) {
        ResultSet car = carMo.getDatosCarrera(carrera);
        htmlcode = "";
        try {
            car.next();
            htmlcode = "                <div class=\"container\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h1 class=\"center yellow-text\">Actualizacion de la Carrera</h1>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <form method=\"POST\" action=\"../../carrera.do\" enctype=\"multipart/form-data\" id=\"upadateCarrera\" class=\"col s12 yellow-text\">\n"
                    + "                                <!--Datos de la carrera -->\n"
                    + "                                <h4>Datos de la Carrera</h4>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"nombreCarreraAC\" type=\"text\" value=\"" + car.getString(9) + "\" >\n"
                    + "                                        <label class=\"yellow-text\" for=\"nombreCarreraAC\">Nombre Carrera</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"abreviaturaCarreraAC\" type=\"text\" value=\"" + car.getString(10) + "\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"AbreviaturaAC\">Abreviatura</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s12\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"descripcionCarreraAC\" type=\"text\" value=\"" + car.getString(11) + "\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"descripcionCarreraAC\">Descripcion</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </form>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"col s6\">\n"
                    + "                            <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left tooltipped\" type=\"button\" id=\"actualizarCarrera\" data-id=\"" + car.getInt(12) + "\" data-position=\"button\" data-tooltip=\"Guardar y Validar\">\n"
                    + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                    + "                            </button>\n"
                    + "                            <br><br><br><br>\n"
                    + "                        </div>\n"
                    + "                        <div id=\"notificacionUpdateCarrera\">\n"
                    + "                        </div>\n"
                    + "                    </div>";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en editarCarrera: " + e);
        }
        return htmlcode;
    }

    public String editarCoordinador(String carrera) {
        ResultSet car = carMo.getDatosCarrera(carrera);
        htmlcode = "";
        try {
            car.next();
            htmlcode = "                <div class=\"container\">\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <h1 class=\"center yellow-text\">Actualizacion del Coordinador</h1>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"row\">\n"
                    + "                            <form method=\"POST\" action=\"../../carrera.do\" enctype=\"multipart/form-data\" id=\"upadateCoordinador\" class=\"col s12 yellow-text\">\n"
                    + "                                <h4>Datos del Coordinador</h4>\n"
                    + "                                <!--Datos del Coordinador -->\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"primerNombreCoordinadorAC\" type=\"text\" value=\"" + car.getString(2) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Nombre\">Primer Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">assignment_ind</i>\n"
                    + "                                        <input id=\"segundoNombreCoordinadorAC\" type=\"text\" value=\"" + car.getString(3) + "\" >\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Nombre\">Segundo Nombre</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"primerApellidoCoordinadorAC\" type=\"text\" value=\"" + car.getString(4) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"Primer Apellido\">Primer Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">wc</i>\n"
                    + "                                        <input id=\"segundoApellidoCoordinadorAC\" type=\"text\" value=\"" + car.getString(5) + "\" >\n"
                    + "                                        <label class=\"yellow-text\" for=\"Segundo Apellido\">Segundo Apellido</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">fingerprint</i>\n"
                    + "                                        <input id=\"ciCoordinadorAC\" type=\"text\" value=\"" + car.getString(6) + "\" class=\"validate\">\n"
                    + "                                        <label class=\"yellow-text\" for=\"# de Carnet\"># de Carnet</label>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"input-field col s6\">\n"
                    + "                                        <i class=\"material-icons prefix yellow-text\">contact_phone</i>\n"
                    + "                                        <input id=\"telefonoCoordinadorAC\" type=\"text\" value=\"" + car.getString(7) + "\" >\n"
                    + "                                        <label class=\"yellow-text\" for=\"Telefono\">Telefono</label>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"row\">\n"
                    + "                                    <div class=\"file-field input-field col s6\">\n"
                    + "                                        <div class=\"btn blue yellow-text\">\n"
                    + "                                            <span>Foto</span>\n"
                    + "                                            <input type=\"file\" id=\"fotoCoordinadorAC\">\n"
                    + "                                        </div>\n"
                    + "                                        <div class=\"file-path-wrapper\">\n"
                    + "                                            <input class=\"file-path validate\" type=\"text\" value=\"" + car.getString(8) + "\" placeholder=\"Seleccione una Foto\">\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </form>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"col s6\">\n"
                    + "                            <button class=\"btn waves-effect waves-light yellow accent-2 blue-text left tooltipped\" type=\"button\" id=\"actualizarCoordinador\" data-id=\"" + car.getInt(1) + "\" data-position=\"button\" data-tooltip=\"Guardar y Validar\">\n"
                    + "                                Validar y Guardar<i class=\"material-icons right\">save</i>\n"
                    + "                            </button>\n"
                    + "                            <br><br><br><br>\n"
                    + "                        </div>\n"
                    + "                        <div id=\"notificacionUpdateCoordinador\">\n"
                    + "                        </div>\n"
                    + "                    </div>";
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en editarCarrera: " + e);
        }
        return htmlcode;
    }

    public boolean actualizarCarrera(Carrera carrera) {
        bandera = carMo.updateCarrera(carrera);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en actualizarCarrera.getCloseConexion: " + e);
        }
        return bandera;
    }

    public boolean actualizarCoordinador(Coordinador coordinador) {
        bandera = coMo.updateCoordinador(coordinador);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en actualizarCoordinador.getCloseConexion: " + e);
        }
        return bandera;
    }

    public int getIdCarrera(String abreviatura) {
        numero = carMo.findIdCarrera(abreviatura);
        try {
            getCloseConexion();
        } catch (Exception e) {
            System.out.println("Error en getIdCarrera.getCloseConexion: " + e);
        }
        return numero;
    }

}
