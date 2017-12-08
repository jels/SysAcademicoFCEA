/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.ControladorEmpresa;
import Controller.ControladorRepresentante;
import Controller.ControladorTutor;
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
public class EmpresaCRUD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("accion");
        System.out.println("Accion: " + accion);
        Empresa empresa = new Empresa();
        ControladorEmpresa conEmp = new ControladorEmpresa();
        Representante rep = new Representante();
        ControladorRepresentante conRep = new ControladorRepresentante();
        ControladorTutor conTut = new ControladorTutor();
        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "crear":
                System.out.println("llegoooo....sSSSsaldhkasjdh");
                rep.setPrimerNombrePersona(ucFirst2(request.getParameter("primerNombreRepresentante")));
                rep.setSegundoNombrePersona(ucFirst2(request.getParameter("segundoNombreRepresentante")));
                rep.setPrimerApellidoPersona(ucFirst2(request.getParameter("primerApellidoRepresentante")));
                rep.setSegundoApellidoPersona(ucFirst2(request.getParameter("segundoApellidoRepresentante")));
                rep.setCiPersona(request.getParameter("ciRepresentante"));
                rep.setTelefonoPersona(request.getParameter("celularRepresentante"));
                rep.setCargoRepresentante(ucFirst2(request.getParameter("cargoRepresentante")));
                rep.setEstadoPersona(Integer.parseInt(request.getParameter("estadoRepresentante")));
                if (conRep.newRepresentante(rep)) {
                    empresa.setNombreEmpresa(ucFirst2(request.getParameter("nombreEmpresa")));
                    empresa.setDireccionEmpresa(ucFirst2(request.getParameter("direccionEmpresa")));
                    empresa.setRubroEmpresa(ucFirst2(request.getParameter("rubroEmpresa")));
                    empresa.setTelefonoEmpresa(request.getParameter("telefonoEmpresa"));
                    empresa.setEstadoEmpresa(Integer.parseInt(request.getParameter("estadoEmpresa")));
                    empresa.setIdRepresentante(conRep.getIdRepresentante(request.getParameter("ciRepresentante")));

                    if (conEmp.newEmpresa(empresa)) {
                        out.print("true");
                    } else {
                        conRep.borrarRepresentante(request.getParameter("ciRepresentante"));
                        out.print("false");
                    }
                } else {
                    out.print("false");
                }
                System.out.println("NombreEmpresa...: " + request.getParameter("nombreEmpresa"));
                break;
            case "update":
                empresa.setNombreEmpresa(ucFirst2(request.getParameter("nombreEmpresa")));
                empresa.setDireccionEmpresa(ucFirst2(request.getParameter("direccionEmpresa")));
                empresa.setTelefonoEmpresa(request.getParameter("telefonoEmpresa"));
                empresa.setRubroEmpresa(ucFirst2(request.getParameter("rubroEmpresa")));
                empresa.setIdEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));

                if (conEmp.updateEmpresa(empresa)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "baja":
                System.out.println("llegoooo....sSSSsaldhkasjdh");
                if (conEmp.bajaEmpresa(Integer.parseInt(request.getParameter("idEmpresa")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "update_representante":
                rep.setPrimerNombrePersona(ucFirst2(request.getParameter("primerNombreRepresentante")));
                rep.setSegundoNombrePersona(ucFirst2(request.getParameter("segundoNombreRepresentante")));
                rep.setPrimerApellidoPersona(ucFirst2(request.getParameter("primerApellidoRepresentante")));
                rep.setSegundoApellidoPersona(ucFirst2(request.getParameter("segundoApellidoRepresentante")));
                rep.setCiPersona(request.getParameter("ciRepresentante"));
                rep.setTelefonoPersona(request.getParameter("celularRepresentante"));
                rep.setCargoRepresentante(ucFirst2(request.getParameter("cargoRepresentante")));
                rep.setIdPersona(Integer.parseInt(request.getParameter("idRepresentante")));

                if (conRep.updateRepresentante(rep)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "baja_tutor":
                if (conTut.darBajaTutor(Integer.parseInt(request.getParameter("idTutor")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
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
