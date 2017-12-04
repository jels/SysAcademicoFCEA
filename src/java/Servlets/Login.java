/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.ControladorUsuarios;
import Model.Usuario;
import Model.Usuario_model;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WarMachine
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        Usuario us = new Usuario();
        Usuario_model usm = new Usuario_model();

        us.setNombreUsuario(request.getParameter("username"));
        us.setPassUsuario(request.getParameter("password"));
        System.out.println("nombre: " + us.getNombreUsuario());
        System.out.println("pass..: " + us.getPassUsuario());
        ControladorUsuarios cuser = new ControladorUsuarios();
        System.out.println("C:\\Users\\WarMachine\\Documents\\NetBeansProjects\\academicopracticas\\web\\");

        if (cuser.loginUser(us)) {
            String rol = usm.getRol(us);
            HttpSession objsession = request.getSession(true);
            objsession.setAttribute("usuario", us.getNombreUsuario());
            objsession.setAttribute("rol", rol);
            System.out.println("rol servlet: " + rol);
            objsession.setAttribute("httplocal", "C:\\Users\\WarMachine\\Documents\\NetBeansProjects\\academicopracticas\\web\\");
            usm.max_connections();
            out.print("true");
        } else {
            out.print("false");
        }
    }

}
