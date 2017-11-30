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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WarMachine
 */
public class PracticasCRUD extends HttpServlet {

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

        ControladorAsignacionPractica conAsp = new ControladorAsignacionPractica();

        Practicas practica = new Practicas();

        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "practicas":
                practica.setFechaFinEvaluacion(request.getParameter("fechaFin"));
                practica.setFechaInicioEvaluacion(request.getParameter("fechaInicio"));
                practica.setCantidadHoras(Integer.parseInt(request.getParameter("cantidadHoras")));
                practica.setFuncionPractica(request.getParameter("funcionPracticante"));
                practica.setObservacionEstudiante(request.getParameter("observacionEstudiante"));
                practica.setIdAsignacionPractica(conAsp.getIdPracitca(request.getParameter("CI_estudiante")));
                if (conAsp.newPractica(practica)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "detallePractica":
                break;
            case "crear":
                out.print("false");
                break;
            case "update":
                out.print("false");
                break;
            case "baja":
                out.print("false");
                break;
            case "parcial":
                if (conAsp.cambiarEstadoParcial(Integer.parseInt(request.getParameter("idParcial")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "eliminar_registro":
                if (conAsp.eliminarRegistroPractica(Integer.parseInt(request.getParameter("idRegistro")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "eliminar_detalle":
                if (conAsp.eliminarDetallePractica(Integer.parseInt(request.getParameter("idDetalle")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                
                break;
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
