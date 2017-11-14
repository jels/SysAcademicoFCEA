<%-- 
    Document   : menu
    Created on : 23/08/2017, 05:04:45 PM
    Author     : WarMachine
--%>

<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String) objsession.getAttribute("usuario");
    String rol = (String) objsession.getAttribute("rol");
    if (usuario.equals("root")) {
        response.sendRedirect("../root/menu.jsp");
    } else if (objsession.equals(false)) {//esta linea es la que ayuda a que no salga el error de null...
        response.sendRedirect("../index.jsp");
    } else if (usuario == null) {
        session.invalidate();
        response.sendRedirect("../index.jsp");
    } else if (rol.equals("Tutor")) {
        response.sendRedirect("tutor/menu.jsp");
    } else if (rol.equals("Docente")) {
        response.sendRedirect("docente/menu.jsp");
    }
%>
