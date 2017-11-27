/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.*;
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WarMachine
 */
public class CarreraCRUD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("accion");
        System.out.println("Accion: " + accion);
        String htmlcode;

        String nombreCarrera = request.getParameter("nombreCarrera");
        String idCarrera = request.getParameter("abreviatura");
        String idCoordinador = request.getParameter("idCoordinador");

        ControladorCarrera conCar = new ControladorCarrera();
        Coordinador coordinador = new Coordinador();
        Carrera carrera = new Carrera();

        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "crear":
                System.out.println("Llego la carrera:  " + nombreCarrera);
                coordinador.setPrimerNombrePersona(request.getParameter("primerNombreCoordinador"));
                coordinador.setSegundoNombrePersona(request.getParameter("segundoNombreCoordinador"));
                coordinador.setPrimerApellidoPersona(request.getParameter("primerApellidoCoordinador"));
                coordinador.setSegundoApellidoPersona(request.getParameter("segundoApellidoCoordinador"));
                coordinador.setCiPersona(request.getParameter("ciCoordinador"));
                coordinador.setTelefonoPersona(request.getParameter("telefonoCoordinador"));
                coordinador.setEstadoPersona(1);
                coordinador.setFotoCoordinador("");//request.getParameter("fotoCoordinador")
                if (conCar.newCoordinador(coordinador)) {
                    carrera.setIdCoordinador(conCar.getIdCoordinador(request.getParameter("ciCoordinador")));
                    carrera.setIdFacultad(2);
                    carrera.setEstadoCarrera(1);
                    carrera.setNombreCarrera(request.getParameter("nombreCarrera"));
                    carrera.setAbreviaturaCarrera(request.getParameter("abreviaturaCarrera"));
                    carrera.setDescripcionCarrera(request.getParameter("descripcionCarrera"));
                    if (conCar.newCarrera(carrera)) {
                        System.out.println("llego aki...");
                        out.print("true");
                    } else {
                        conCar.boorarCoordinador(coordinador.getCiPersona());
                        System.out.println("borro al coordinador");
                        out.print("false");
                    }
                } else {
                    System.out.println("no creo el cordinador...");
                    out.print("false");
                }

                break;
            case "update":

                System.out.println("Actualiza: " + request.getParameter("idCarrera"));
                carrera.setNombreCarrera(request.getParameter("nombreCarrera"));
                carrera.setAbreviaturaCarrera(request.getParameter("abreviaturaCarrera"));
                carrera.setDescripcionCarrera(request.getParameter("descripcionCarrera"));
                carrera.setIdCarrera(Integer.parseInt(request.getParameter("idCarrera")));
                if (conCar.actualizarCarrera(carrera)) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "baja":
                System.out.println("Carrera: " + idCarrera);
                if (conCar.bajaCarrera(idCarrera)) {
                    out.print("true");

                } else {
                    out.print("false");
                }
                break;
            case "updateCoordinador":

                System.out.println("idCoordinador: " + idCoordinador);
                coordinador.setIdPersona(Integer.parseInt(request.getParameter("idCoordinador")));
                coordinador.setPrimerNombrePersona(request.getParameter("primerNombreCoordinador"));
                coordinador.setSegundoNombrePersona(request.getParameter("segundoNombreCoordinador"));
                coordinador.setPrimerApellidoPersona(request.getParameter("primerApellidoCoordinador"));
                coordinador.setSegundoApellidoPersona(request.getParameter("segundoApellidoCoordinador"));
                coordinador.setCiPersona(request.getParameter("ciCoordinador"));
                coordinador.setTelefonoPersona(request.getParameter("telefonoCoordinador"));
                coordinador.setFotoCoordinador(request.getParameter("fotoCoordinador"));

                if (conCar.actualizarCoordinador(coordinador)) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
//            case "buscar_estudiante":
//
//                break;
//            case "cargar_nota":
//
//                break;
//            case "verNotaAsignada":
//
//                break;
            default:

                break;
        }

    }

    private String ucFirst2(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        } else {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1, str.length()).toLowerCase();
        }

    }

    private String minuscula(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        } else {
            return str.toLowerCase();
        }

    }
}
