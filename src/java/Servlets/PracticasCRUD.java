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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WarMachine
 */
public class PracticasCRUD extends HttpServlet {

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

        ControladorAsignacionPractica conAsp = new ControladorAsignacionPractica();
        ControladorNotas conNot = new ControladorNotas();
        ControladorEstudiante conEst = new ControladorEstudiante();
        ControladorMateria conMat = new ControladorMateria();
        ControladorPracticas conPra = new ControladorPracticas();
        Practicas practica = new Practicas();
        DetallesPracticas detalle = new DetallesPracticas();
        AsignacionPracticas asp = new AsignacionPracticas();

        String CI_estudiante = request.getParameter("CI_estudiante");
        String apellido_estudiante = request.getParameter("");
        String tutor = request.getParameter("");

        //Metodo creado para evitar el uso de muchos servlets 
        // aqui llegan todas las peticiones del usuario para realizar las funciones de:
        // -Crear -Editar -Dar de Baja -Eliminar
        switch (accion) {
            case "practicas":
                practica.setFechaFinEvaluacion(request.getParameter("fechaFin"));
                practica.setFechaInicioEvaluacion(request.getParameter("fechaInicio"));
                practica.setCantidadHoras(Integer.parseInt(request.getParameter("cantidadHoras")));
                practica.setFuncionPractica(request.getParameter("funcionPracticante"));
                practica.setObservacionEstudiante(request.getParameter("observacionEstudiante"));
                practica.setIdAsignacionPractica(conAsp.getIdPracitca(request.getParameter("CI_estudiante")));
                int idParcial = Integer.parseInt(request.getParameter("parcial"));
                System.out.println("numero= " + idParcial);
                practica.setIdParcial(idParcial);
                if (conAsp.newPractica(practica)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "detalle_practica":

                detalle.setIdPracticas(Integer.parseInt(request.getParameter("idPractica")));
                System.out.println("IDPractica: " + request.getParameter("idPractica"));
                detalle.setTareaAsignada(request.getParameter("tareaAsignada"));
                detalle.setObservacionesTareas(request.getParameter("observacionTarea"));

                if (conAsp.newDetallePractica(detalle)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "crear_asignacionPractica":

                int idEstudiante = conEst.getIdEstudiante(CI_estudiante);

                asp.setIdEstudiante(idEstudiante);
                asp.setIdDocente(Integer.parseInt(request.getParameter("docente")));
                asp.setIdMateria(Integer.parseInt(request.getParameter("materia")));
                asp.setIdTutor(Integer.parseInt(request.getParameter("tutor")));
                asp.setAreaPactica(request.getParameter("areaPractica"));
                asp.setIngresoEstudiante(request.getParameter("ingresoEs"));
                asp.setGestionAcademica(request.getParameter("gestionActual"));
                asp.setFechaInicioPractica(request.getParameter("fechaInicioPra"));
                asp.setFechaFinPractica(request.getParameter("fechaFinPra"));
                asp.setAproboPractica(0);
                asp.setEstadoPractica(1);
                if (conAsp.newAsignacionPractica(asp)) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "eliminar_asignacionPractica":

                if (conAsp.eliminarAsignacionPractica(Integer.parseInt(request.getParameter("idAsignacion")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "baja":
                out.print("false");
                break;
            case "parcial":
                if (conAsp.cambiarEstadoParcial(Integer.parseInt(request.getParameter("idParcial")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "eliminar_registro":
                if (conAsp.eliminarRegistroPractica(Integer.parseInt(request.getParameter("idRegistro")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "eliminar_detalle":
                if (conAsp.eliminarDetallePractica(Integer.parseInt(request.getParameter("idDetalle")))) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "baja_estudiante":
                System.out.println("CI_Estudiante: " + CI_estudiante);
                if (conEst.bajaEstudiante(CI_estudiante)) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "eliminar_estudiante":
                System.out.println("CI_Estudiante: " + CI_estudiante);
                if (conEst.eliminarEstudiante(CI_estudiante)) {
                    out.print("true");

                } else {
                    out.print("false");
                }
                break;
            case "buscar_estudiante":
                System.out.println("llego hasta aki...buscar_estudiante: " + apellido_estudiante + " " + CI_estudiante);
                htmlcode = conEst.modalBuscarEstudiante(apellido_estudiante, CI_estudiante, tutor);
                out.print(htmlcode);
                break;
            case "cargar_nota_estudiante":
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
                } catch (SQLException | NumberFormatException e) {
                    System.out.println("Error cargar_nota: " + e);
                }

                if (contnotas == 20) {
                    out.print("true");
                } else {
                    out.print("false");
                }

                break;
            case "verNotaAsignada_estudiante":
                System.out.println("CI_estudiante: " + CI_estudiante);
                htmlcode = conNot.getModalVerNota(CI_estudiante);
                System.out.println("llega al verNotaAsignada");
                out.print(htmlcode);

                break;
            case "aprobar_estudiante":
                if (conPra.aprobarEstudiante(CI_estudiante)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "reprobar_estudiante":
                if (conPra.reprobarEstudiante(CI_estudiante)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
                break;
            case "baja_practica_estudiante":
                if (conPra.cambiarEstadoPracticas(CI_estudiante)) {
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
