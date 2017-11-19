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
import java.lang.invoke.MethodHandles;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WarMachine
 */
public class EstudianteCRUD extends HttpServlet {

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
        String CI_estudiante = request.getParameter("CI_estudiante");
        String apellido_estudiante = request.getParameter("apellido_estudiante");
        String tutor = request.getParameter("tutor");
        ControladorEstudiante conEst = new ControladorEstudiante();
        Estudiante est = new Estudiante();
        ControladorNotas conNot = new ControladorNotas();

        Notas nota = new Notas();

        String htmlcode;
        ControladorMateria conMat = new ControladorMateria();

        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "crear":

                est.setPrimerNombrePersona(ucFirst2(request.getParameter("primerNombreEstudiante").trim()));
                est.setPrimerApellidoPersona(ucFirst2(request.getParameter("primerApellidoEstudiante").trim()));
                est.setSegundoNombrePersona(ucFirst2(request.getParameter("segundoNombreEstudiante").trim()));
                est.setSegundoApellidoPersona(ucFirst2(request.getParameter("segundoApellidoEstudiante").trim()));
                est.setTelefonoPersona(request.getParameter("celularEstudiante").trim());
                est.setCiPersona(request.getParameter("ciEstudiante").trim());
                est.setEstadoPersona(1);

//        if (request.getParameter("foto").equals("")) {
//            out.print("false");
//        }
//        else{
//            out.print("true");
//        }
//        String archivourl = "D:\\fcea\\practicas\\web\\fcea\\estudiantes";
//        String archivourl2 = "D:\\fcea\\practicas\\web\\fcea\\estudiantes";
//        String nombre = "elsas.jpg";
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        factory.setSizeThreshold(1024);
//        factory.setRepository(new File(archivourl));
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        System.out.println("llego..1");
//        try {
//            System.out.println("llego..try");
//            List<FileItem> partes = upload.parseRequest(request);
//            System.out.println("llegoooooo");
//            for (FileItem items : partes) {
//                System.out.println("llego..for");
//                File file = new File(archivourl, items.getName());
//                File filenew = new File(archivourl2, nombre);
//                items.write(file);
//                System.out.println("llego..for2");
//                if (file.renameTo(filenew)) {
//                    out.print("true");
//                    System.out.println("llego..true");
//                } else {
//                    out.print("false");
//                    System.out.println("llego..false");
//                }
//            }
//        } catch (Exception e) {
//            out.print("Exception: " + e + "");
//        }
//
//        String archivourl = "C:\\Users\\WarMachine\\Documents\\NetBeansProjects\\academicopracticas\\web\\img\\fcea\\estudiante";
//        String nombre = (est.getNombrePersona() + "-" + est.getApellidoPersona() + ".jpg").trim();
//        System.out.println("llegoooo...." + nombre);
//
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        factory.setSizeThreshold(1024);
//        factory.setRepository(new File(archivourl));
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        try {
//            System.out.println("llegoooo....");
//
//            List<FileItem> partes = upload.parseRequest(request);
//            for (FileItem items : partes) {
//                System.out.println("llegoooo....");
//                File file = new File(archivourl, items.getName());
//                File filenew = new File(archivourl, nombre);
//                items.write(file);
//                file.renameTo(filenew);
//
//            }
//        } catch (Exception e) {
//            out.print("Exception: " + e.getMessage() + "");
//        }
//        est.setFotoEstudiante("img/fcea/estudiante/" + nombre);
//
                est.setFotoEstudiante(" ");
                if (conEst.newEstudiante(est)) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "update":

                est.setPrimerNombrePersona(ucFirst2(request.getParameter("primerNombreEstudianteAc").trim()));
                est.setPrimerApellidoPersona(ucFirst2(request.getParameter("primerApellidoEstudianteAc").trim()));
                est.setSegundoNombrePersona(ucFirst2(request.getParameter("segundoNombreEstudianteAc").trim()));
                est.setSegundoApellidoPersona(ucFirst2(request.getParameter("segundoApellidoEstudianteAc").trim()));
                est.setTelefonoPersona(request.getParameter("celularEstudianteAc").trim());
                est.setCiPersona(request.getParameter("ciEstudianteAc").trim());

                est.setFotoEstudiante("imagen4.jpg");
                if (conEst.updateEstudiante(est)) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "baja":

                System.out.println("CI_Estudiante: " + CI_estudiante);
                if (conEst.bajaEstudiante(CI_estudiante)) {
                    out.print("true");

                } else {
                    out.print("false");
                }

                break;
            case "eliminar":
                System.out.println("CI_Estudiante: " + CI_estudiante);
                if (conEst.eliminarEstudiante(CI_estudiante)) {
                    out.print("true");

                } else {
                    out.print("false");
                }
                break;
//            case "asignar_nota":
//                System.out.println("aki esta el asignar nota..." + CI_estudiante);
//                htmlcode = conMat.getEvaluacion(CI_estudiante);
//                out.print(htmlcode);
//                break;

            case "actualizar":
                System.out.println("CI_Estudiante ACtualizar: " + CI_estudiante);
                htmlcode = "";
//                htmlcode = conEst.modalUpdateEstudiante(CI_estudiante);
//                out.print(htmlcode);
                break;
            case "buscar_estudiante":
                System.out.println("llego hasta aki...buscar_estudiante: " + apellido_estudiante + " " + CI_estudiante);
                htmlcode = conEst.modalBuscarEstudiante(apellido_estudiante, CI_estudiante, tutor);
                out.print(htmlcode);
                break;
            case "cargar_nota":
                int contnotas = 0;
                int count = 1;
                System.out.println("llega a la nota...");
                int idAsignacionPractica = conEst.getIdAsignacionPractica(CI_estudiante);
                ResultSet idCriterio = conMat.getListaIDCriterioXEst(CI_estudiante);
                int parcial = conEst.getPractica(CI_estudiante);
                try {
                    while (count <= 20) {
                        idCriterio.next();
                        int notas = Integer.parseInt(request.getParameter("nota" + count));
                        System.out.println("la nota" + count + ": " + notas);
                        System.out.println("CI_estudiante...!: " + CI_estudiante);
                        System.out.println("IDcriterio: " + idCriterio.getInt(1));
                        if (conNot.insertNewNota(idAsignacionPractica, idCriterio.getInt(1), notas, parcial)) {
                            contnotas++;
                        }
                        count++;
                    }
                } catch (Exception e) {
                    System.out.println("Error cargar_nota: " + e);
                }

                if (contnotas == 20) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "verNotaAsignada":
                System.out.println("CI_estudiante: " + CI_estudiante);
                htmlcode = conNot.getModalVerNota(CI_estudiante);
                System.out.println("llega al verNotaAsignada");
                out.print(htmlcode);

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
