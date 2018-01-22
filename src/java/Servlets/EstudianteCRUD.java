/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.*;
import Model.*;
import com.sun.media.sound.EmergencySoundbank;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

        response.setContentType("text/html; charset=ISO-8859-1");
        request.setCharacterEncoding("ISO-8859-1");
        PrintWriter out = response.getWriter();

        FileItemFactory file_factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(file_factory);

        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> img = new ArrayList<>();

        String archivourl = "..\\img\\fcea\\estudiantes\\";
        int c = 0;
        int a = 0;
        try {
            List items = sfu.parseRequest(request);

            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                if (!item.isFormField()) {
                    File archivo = new File(archivourl + item.getName());
                    item.write(archivo);
                    img.add(item.getName());
                    a++;
                } else {
                    c++;
                    campos.add(item.getString());
                }
            }
        } catch (Exception ex) {

        }
        String accion = campos.get(0);
        System.out.println("Accion: " + accion + " c" + c + " a" + a);

        ControladorEstudiante conEst = new ControladorEstudiante();
        Estudiante est = new Estudiante();

        est.setPrimerNombrePersona(ucFirst2(campos.get(1)));
        est.setSegundoNombrePersona(ucFirst2(campos.get(2)));
        est.setPrimerApellidoPersona(ucFirst2(campos.get(3)));
        est.setSegundoApellidoPersona(ucFirst2(campos.get(4)));
        est.setTelefonoPersona(campos.get(6));
        System.out.println("tel " + campos.get(6));
        est.setCiPersona(campos.get(5));
        est.setFotoEstudiante(img.get(0));
        est.setEstadoPersona(1);
        String ciPersona = campos.get(5);
        System.out.println(ciPersona);
        switch (accion) {
            case "crear_estudiante":
                if (conEst.newEstudiante(est)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "update_estudiante":
                if (conEst.updateEstudiante(est, ciPersona)) {
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
}
