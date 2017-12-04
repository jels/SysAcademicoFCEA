/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.ControladorEmpresa;
import Controller.ControladorTutor;
import Controller.ControladorUsuarios;
import Model.Tutor;
import Model.Usuario;
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
public class TutorCRUD extends HttpServlet {
    
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
        String CI_tutor = request.getParameter("CI_tutor");
        ControladorEmpresa conEmp = new ControladorEmpresa();
        ControladorTutor conTu = new ControladorTutor();
        Tutor tut = new Tutor();
        ControladorUsuarios conUs = new ControladorUsuarios();
        Usuario us = new Usuario();
        int idUsuario;
        int idRol;
        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "crear_tutor":
                us.setImagenUsuario(request.getParameter("imagenT"));
                us.setFondoUsuario(request.getParameter("imagenT"));
                us.setNombreUsuario(request.getParameter("imagenT"));
                us.setPassUsuario(request.getParameter("imagenT"));
                idRol = conUs.findRol("Tutor");
                System.out.println("Rol: " + idRol);
                us.setIdRol(idRol);
                
                if (conUs.newUser(us)) {
                    idUsuario = conUs.findID(us);
                    tut.setIdUsuario(idUsuario);
                    tut.setIdEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));
                    tut.setPrimerNombrePersona(ucFirst2(request.getParameter("primerNombreT")));
                    tut.setSegundoNombrePersona(ucFirst2(request.getParameter("segundoNombreT")));
                    tut.setPrimerApellidoPersona(ucFirst2(request.getParameter("primerApellidoT")));
                    tut.setSegundoApellidoPersona(ucFirst2(request.getParameter("segundoApellidoT")));
                    tut.setCiPersona(request.getParameter("ciT"));
                    tut.setTelefonoPersona(request.getParameter("celularT"));
                    tut.setCargoTutor(ucFirst2(request.getParameter("cargoT")));
                    tut.setEstadoPersona(Integer.parseInt(request.getParameter("estado")));
                    tut.setFotoTutor(request.getParameter("imagenT"));
                    tut.setFondoTutor(request.getParameter("fondoT"));
                    System.out.println("klasdjlaksjdl");
                    if (conTu.nuevoTutor(tut)) {
                        out.print("true");
                    } else {
                        conUs.borrarUsuario(us);
                        System.out.println("añlksjdlajdlkasjd");
                        out.print("false");
                    }
                    
                } else {
                    out.print("false");
                }
                
                break;
            case "update":
                
                out.print("false");
                
                break;
            case "baja_tutor":
                if (conTu.darBajaTutor(Integer.parseInt(request.getParameter("idTutor")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
//            case "eliminar":
//                System.out.println("CI_Estudiante: " + CI_tutor);
//                if (conTut.eliminarTutor(CI_tutor)) {
//                    out.print("true");
//
//                } else {
//                    out.print("false");
//                }
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
