
<%@page import="Controller.ControladorEstudiante"%>
<% ControladorEstudiante conEst= new ControladorEstudiante(); %>

<%=conEst.modalUpdateEstudiante(request.getParameter("CI_estudiante"))%>

<div id="test1"></div>