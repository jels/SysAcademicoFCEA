/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
        ControladorTutor conTut = new ControladorTutor();
        Tutor tut = new Tutor();
        ControladorUsuarios conUs = new ControladorUsuarios();
        Usuario us = new Usuario();

        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "crear":
                System.out.println("tutor..." + request.getParameter("primerNombreT"));
                int id;

                us.setIdRol(3);
                us.setNombreUsuario(minuscula(request.getParameter("nombreUsuarioT")));
                us.setPassUsuario(minuscula(request.getParameter("passUsuarioT")));
                us.setImagenUsuario("imagenT");
                us.setFondoUsuario("fondoT");

                if (conUs.newUser(us)) {
                    id = conUs.findID(us);

                    tut.setPrimerNombrePersona(ucFirst2(request.getParameter("primerNombreT")));
                    tut.setSegundoNombrePersona(ucFirst2(request.getParameter("segundoNombreT")));
                    tut.setPrimerApellidoPersona(ucFirst2(request.getParameter("primerApellidoT")));
                    tut.setSegundoApellidoPersona(ucFirst2(request.getParameter("segundoApellidoT")));
                    tut.setTelefonoPersona(request.getParameter("celularT"));
                    tut.setCiPersona(request.getParameter("ciT"));
                    tut.setCargoTutor(ucFirst2(request.getParameter("cargoT")));
                    tut.setEstadoPersona(1);
                    tut.setFotoTutor("imagenT");
                    tut.setFondoTutor("fondoT");
                    tut.setIdUsuario(id);
                    if (conTut.newTutor(tut)) {
                        out.print("true");
                    } else {
                        out.print("falseTutor");
                    }

                } else {
                    out.print("falseUser");
                }

                break;
            case "update":

                break;
            case "baja":

                System.out.println("CI_Tutor: " + CI_tutor);
                if (conTut.bajaTutor(CI_tutor)) {
                    out.print("true");

                } else {
                    out.print("false");
                }

                break;
            case "eliminar":
                System.out.println("CI_Estudiante: " + CI_tutor);
                if (conTut.eliminarTutor(CI_tutor)) {
                    out.print("true");

                } else {
                    out.print("false");
                }

                break;
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
