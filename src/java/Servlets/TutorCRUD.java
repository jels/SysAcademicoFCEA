/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.*;
import Model.Tutor;
import Model.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author WarMachine
 */
@MultipartConfig
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

        FileItemFactory file_factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(file_factory);

        ArrayList<String> campos = new ArrayList<>();
        ArrayList<String> imgs = new ArrayList<>();

        try {
            List items = sfu.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                if (!item.isFormField()) {
                    File archivo = new File("D:\\fcea\\practicas\\web\\img\\fcea\\tutores\\" + item.getName());
                    item.write(archivo);
                    imgs.add(item.getName());
                } else {
                    campos.add(item.getString());
                }
            }
        } catch (Exception ex) {

        }
        String accion = campos.get(10);
        System.out.println("Accion: " + accion);
        ControladorTutor conTut = new ControladorTutor();
        ControladorUsuarios conUs = new ControladorUsuarios();
        Tutor tutor = new Tutor();
        Usuario us = new Usuario();
        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "crear_tutor":
                us.setIdRol(conUs.findRol("Tutor"));
                us.setNombreUsuario(campos.get(7));
                us.setPassUsuario(campos.get(8));
                us.setImagenUsuario(imgs.get(0));
                if (conUs.newUser(us)) {
                    System.out.println("llega");
                    tutor.setIdUsuario(conUs.findID(us));
                    tutor.setIdEmpresa(Integer.parseInt(campos.get(9)));
                    tutor.setPrimerNombrePersona(ucFirst2(campos.get(0)));
                    tutor.setSegundoNombrePersona(ucFirst2(campos.get(1)));
                    tutor.setPrimerApellidoPersona(ucFirst2(campos.get(2)));
                    tutor.setSegundoApellidoPersona(ucFirst2(campos.get(3)));
                    tutor.setTelefonoPersona(campos.get(4));
                    tutor.setCiPersona(campos.get(5));
                    tutor.setCargoTutor(ucFirst2(campos.get(6)));
                    tutor.setFotoTutor(imgs.get(0));
                    tutor.setEstadoPersona(1);
                    if (conTut.nuevoTutor(tutor)) {
                        out.print("true");
                    } else {
                        conUs.borrarUsuario(us);
                        out.print("false");
                    }
                } else {
                    out.print("false");
                }
                break;
            case "update_tutor":
                us.setNombreUsuario(campos.get(7));
                us.setPassUsuario(campos.get(8));
                if (conUs.updateUser(us)) {
                    tutor.setPrimerNombrePersona(ucFirst2(campos.get(0)));
                    tutor.setSegundoNombrePersona(ucFirst2(campos.get(1)));
                    tutor.setPrimerApellidoPersona(ucFirst2(campos.get(2)));
                    tutor.setSegundoApellidoPersona(ucFirst2(campos.get(3)));
                    tutor.setTelefonoPersona(campos.get(5));
                    tutor.setCiPersona(campos.get(4));
                    tutor.setCargoTutor(ucFirst2(campos.get(6)));
                    if (conTut.updateTutor(tutor)) {
                        out.print("true");
                    } else {
                        conUs.borrarUsuario(us);
                        out.print("false");
                    }
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
