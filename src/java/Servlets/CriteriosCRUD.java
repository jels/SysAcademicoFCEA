/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.ControladorMateria;
import Model.Criterios;
import Model.Criterios_model;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.constructorParameterOrderType;
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
public class CriteriosCRUD extends HttpServlet {

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
        Criterios criterio = new Criterios();
        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "crear_criterio":
                criterio.setIdDimension(Integer.parseInt(request.getParameter("idDimension")));
                criterio.setNombreCriterio(request.getParameter("nombreCriterio"));
                criterio.setEstadoCriterio(Integer.parseInt(request.getParameter("estadoCriterio")));
                if (conMat.newCriterio(criterio)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "update":
                criterio.setIdCriterio(Integer.parseInt(request.getParameter("idCriterio")));
                criterio.setNombreCriterio(request.getParameter("nombreCriterio"));

                if (conMat.updateCriterio(criterio)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "baja_criterio":

                if (conMat.bajaCriterio(Integer.parseInt(request.getParameter("idCriterio")))) {
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
