/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.ControladorCarrera;
import Controller.ControladorMateria;
import Model.Materia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WarMachine
 */
public class MateriaCRUD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("accion");
        System.out.println("Accion: " + accion);
        String htmlcode;

        ControladorMateria conMat = new ControladorMateria();
        ControladorCarrera conCar = new ControladorCarrera();
        Materia materia = new Materia();
        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "crear":
                int idCarrera = conCar.getIdCarrera(request.getParameter("carrera"));
                materia.setIdCarrera(idCarrera);
                materia.setNombreMateria(request.getParameter("nombreMateria"));
                materia.setDescripcionMateria(request.getParameter("descripcionMateria"));
                materia.setSemestreMateria(request.getParameter("semestreMateria"));
                materia.setHorasPracticas(Integer.parseInt(request.getParameter("horasPracticas")));
                materia.setEstadoMateria(1);
                if (conMat.nuevaMateria(materia)) {
                    out.print("true");
                } else {
                    out.print("true");
                }
                break;
            case "update":
                materia.setIdMateria(Integer.parseInt(request.getParameter("idMateria")));
                materia.setNombreMateria(request.getParameter("nombreMateria"));
                materia.setSemestreMateria(request.getParameter("semestreMateria"));
                materia.setDescripcionMateria(request.getParameter("descripcionMateria"));
                materia.setHorasPracticas(Integer.parseInt(request.getParameter("horasPracticas")));
                materia.setEstadoMateria(Integer.parseInt(request.getParameter("estadoMateria")));

                if (conMat.updateMateria(materia)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "baja":
                System.out.println("Llego a baja");
                int idMateria = Integer.parseInt(request.getParameter("idMateria"));
                if (conMat.bajaMateria(idMateria)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
//            case "actualizar":
//
//                break;
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
                out.print("false");
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
