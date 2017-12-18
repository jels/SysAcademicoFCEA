/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author WarMachine
 */
public class AsignacionPracticas_model extends Conexion {

    String texto = "";
    int numero;

    public int getParcialEstudiante(String CI_estudiante) {

        int count = 1;
        int parcial1 = 0;
        int parcial2 = 0;
        int parcial3 = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String consulta = "";
        try {
            while (count <= 3) {
                switch (count) {
                    case 1:
                        consulta = "SELECT COUNT(n.parcial) "
                                + "FROM asignacionpracticas asp, "
                                + "estudiante e, notas n "
                                + "WHERE e.idEstudiante = asp.idEstudiante "
                                + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                                + "AND asp.estadoPractica = 1 "
                                + "AND n.parcial = 1 "
                                + "AND e.ciEstudiante = ? ";
                        pst = getConnection().prepareStatement(consulta);
                        pst.setString(1, CI_estudiante);
                        rs = pst.executeQuery();
                        rs.next();
                        parcial1 = rs.getInt(1);
                        break;
                    case 2:
                        consulta = "SELECT COUNT(n.parcial) "
                                + "FROM asignacionpracticas asp, "
                                + "estudiante e, notas n "
                                + "WHERE e.idEstudiante = asp.idEstudiante "
                                + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                                + "AND asp.estadoPractica = 1 "
                                + "AND n.parcial = 2 "
                                + "AND e.ciEstudiante = ? ";
                        pst = getConnection().prepareStatement(consulta);
                        pst.setString(1, CI_estudiante);
                        rs = pst.executeQuery();
                        rs.next();
                        parcial1 = rs.getInt(1);
                        break;
                    case 3:
                        consulta = "SELECT COUNT(n.parcial) "
                                + "FROM asignacionpracticas asp, "
                                + "estudiante e, notas n "
                                + "WHERE e.idEstudiante = asp.idEstudiante "
                                + "AND asp.idAsignacionPractica = n.idAsignacionPractica "
                                + "AND asp.estadoPractica = 1 "
                                + "AND n.parcial = 3 "
                                + "AND e.ciEstudiante = ? ";
                        pst = getConnection().prepareStatement(consulta);
                        pst.setString(1, CI_estudiante);
                        rs = pst.executeQuery();
                        rs.next();
                        parcial1 = rs.getInt(1);
                        break;
                    default:
                        break;
                }
                count++;
            }
            if (parcial1 == 0) {
                return 1;
            } else if (parcial2 == 0) {
                return 2;
            } else if (parcial3 == 0) {
                return 3;
            } else {
                return 0;
            }

        } catch (Exception ex) {
            System.err.println("Error getParcialEstudiante: " + ex);
            return 0;
        }
    }

    public int getIdAsignacionPractica(String CI_Estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.idAsignacionPractica "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND e.ciEstudiante = ? "
                    + "AND asp.estadoPractica = 1 ";
            pst = getConnection().prepareStatement(consulta);
            System.out.println("CI: " + CI_Estudiante);
            pst.setString(1, CI_Estudiante);
            rs = pst.executeQuery();
            rs.next();
            System.out.println("getIdAsignacionPractica: " + rs.getInt(1));
            return rs.getInt(1);

        } catch (Exception ex) {
            System.err.println("Error getIdAsignacionPractica: " + ex);
            return 0;
        }

    }

    public boolean getRealizaPractica(String CI_estudiante) {

        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "SELECT e.idEstudiante "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            System.err.println("Error getRealizaPractica: " + ex);
            return false;
        }

    }

    public ResultSet getDatosEstudiantePractica(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT e.primerNombreEstudiante, e.segundoNombreEstudiante, "
                    + "e.primerApellidoEstudiante, e.segundoApellidoEstudiante, "
                    + "m.nombreMateria, c.nombreCarrera, "
                    + "emp.nombreEmpresa, t.primerNombreTutor, "
                    + "t.segundoNombreTutor, t.primerApellidoTutor, "
                    + "t.segundoApellidoTutor, asp.areaPractica "
                    + "FROM estudiante e, asignacionpracticas asp, "
                    + "materia m, tutor t, empresa emp, carrera c "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND emp.idEmpresa = t.idEmpresa "
                    + "AND c.idCarrera = m.idCarrera "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            System.err.println("Error getDatosEstudiantePractica: " + ex);
            return rs;
        }
    }

    public ResultSet getDatosEstudiante(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT primerNombreEstudiante, segundoNombreEstudiante, "
                    + "primerApellidoEstudiante, segundoApellidoEstudiante "
                    + "FROM estudiante "
                    + "WHERE ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            System.err.println("Error getDatosEstudiantePractica: " + ex);
            return rs;
        }
    }

    public ResultSet getAllPracticasEstudiante(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.nombreMateria, asp.idAsignacionPractica "
                    + "FROM estudiante e, materia m, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getAllPracticasEstudiante: " + ex);
            return rs;
        }

    }

    public ResultSet getPracticasEstudiante(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.nombreMateria, asp.idAsignacionPractica "
                    + "FROM estudiante e, materia m, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getPracticasEstudiante: " + ex);
            return rs;
        }

    }

    public boolean getRealizoPracticas(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT m.nombreMateria, asp.idAsignacionPractica "
                    + "FROM estudiante e, materia m, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            System.err.println("Error getRealizoPracticas: " + ex);
            return false;
        }
    }

    public String getIngresoEstudiante(String CI_estudiante) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.ingresoEstudiante "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getIngresoEstudiante: " + ex);
            return texto;
        }

    }

    public boolean nuevaAsignacionPractica(AsignacionPracticas asp) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String consulta = "INSERT INTO asignacionpracticas "
                    + "(idEstudiante, idDocente, idMateria, "
                    + "idTutor, ingresoEstudiante, gestionAcademica, "
                    + "fechaInicioPractica, fechaFinPractica, areaPractica, "
                    + "aprobadoMateria, estadoPractica) "
                    + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, asp.getIdEstudiante());
            pst.setInt(2, asp.getIdDocente());
            pst.setInt(3, asp.getIdMateria());
            pst.setInt(4, asp.getIdTutor());
            pst.setString(5, asp.getIngresoEstudiante());
            pst.setString(6, asp.getGestionAcademica());
            pst.setString(7, asp.getFechaInicioPractica());
            pst.setString(8, asp.getFechaFinPractica());
            pst.setString(9, asp.getAreaPactica());
            pst.setInt(10, asp.getAproboPractica());
            pst.setInt(11, asp.getEstadoPractica());
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error nuevaAsignacionPractica: " + ex);
            return false;
        }
    }

    public boolean eliminarAsignacion(int idAsignacion) {
        PreparedStatement pst = null;
        try {
            String consulta = "DELETE FROM asignacionpracticas WHERE idAsignacionPractica = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idAsignacion);
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error eliminarAsignacion: " + ex);
            return false;
        }
    }

    public int getCantidadPracticasEstado(int estado) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT COUNT(idAsignacionPractica) "
                    + "FROM asignacionpracticas "
                    + "WHERE estadoPractica = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception ex) {
            System.err.println("Error getCantidadPracticasEstado: " + ex);
            return 0;
        }
    }

    public ResultSet getDatosPracticas(int estado) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT e.ciEstudiante, e.primerNombreEstudiante, "
                    + "e.segundoNombreEstudiante, e.primerApellidoEstudiante, "
                    + "e.segundoApellidoEstudiante, m.nombreMateria, "
                    + "c.nombreCarrera, t.primerNombreTutor, "
                    + "t.segundoNombreTutor, t.primerApellidoTutor, "
                    + "t.segundoApellidoTutor, asp.idAsignacionPractica "
                    + "FROM asignacionpracticas asp, materia m, estudiante e, tutor t, carrera c "
                    + "WHERE c.idCarrera = m.idCarrera "
                    + "AND e.idEstudiante = asp.idEstudiante "
                    + "AND m.idMateria = asp.idMateria "
                    + "AND t.idTutor = asp.idTutor "
                    + "AND asp.estadoPractica = ? "
                    + "ORDER BY e.primerApellidoEstudiante ASC";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, estado);
            rs = pst.executeQuery();
            return rs;

        } catch (Exception ex) {
            System.err.println("Error getDatosPracticas: " + ex);
            return rs;
        }
    }

    public String getGestionAC(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.gestionAcademica "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getGestionAC: " + ex);
            return texto;
        }
    }

    public String getPeriodoInicio(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.fechaInicioPractica "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE  e.idEstudiante = asp.idEstudiante "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getPeriodoInicio: " + ex);
            return texto;
        }
    }

    public String getPeriodoFin(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.fechaFinPractica "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE  e.idEstudiante = asp.idEstudiante "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getPeriodoFin: " + ex);
            return texto;
        }
    }

    public String getAreaPractic(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.areaPractica "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getPeriodoFin: " + ex);
            return texto;
        }
    }

    public String getFuncionPar(String CI_estudiante, int parcial) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT p.funcionPractica "
                    + "FROM estudiante e, asignacionpracticas asp, practicas p "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND p.idParcial = ? "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, parcial);
            pst.setString(2, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getPeriodoFin: " + ex);
            return texto;
        }
    }

    public ResultSet getTareasParcial(String CI_estudiante, int parcial) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT det.tareaAsignada "
                    + "FROM estudiante e, asignacionpracticas asp, "
                    + "practicas p, detallepracticas det "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND p.idPracticas = det.idPracticas "
                    + "AND p.idParcial = ? "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, parcial);
            pst.setString(2, CI_estudiante);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            System.err.println("Error getTareasParcial: " + ex);
            return null;
        }
    }

    public String getPeriodoInicioASP(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.fechaInicioPractica "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getPeriodoInicioASP: " + ex);
            return texto;
        }
    }

    public String getPeriodoFinASP(String CI_estudiante) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT asp.fechaFinPractica "
                    + "FROM estudiante e, asignacionpracticas asp "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            texto = rs.getString(1);
            return texto;
        } catch (Exception ex) {
            System.err.println("Error getPeriodoFinASP: " + ex);
            return texto;
        }
    }

    public int getCantidadHorasParcial(String CI_estudiante, int parcial) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT p.cantidadHoras "
                    + "FROM estudiante e, asignacionpracticas asp, practicas p "
                    + "WHERE e.idEstudiante = asp.idEstudiante "
                    + "AND asp.idAsignacionPractica = p.idAsignacionPractica "
                    + "AND p.idParcial = ? "
                    + "AND asp.estadoPractica = 1 "
                    + "AND e.ciEstudiante = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, parcial);
            pst.setString(2, CI_estudiante);
            rs = pst.executeQuery();
            rs.next();
            numero = rs.getInt(1);
            return numero;
        } catch (Exception ex) {
            System.err.println("Error getCantidadHorasParcial: " + ex);
            return numero;
        }
    }

    public boolean aprobar(String CI_estudiante) {
        int idAsignacion = getIdAsignacionPractica(CI_estudiante);
        PreparedStatement pst = null;
        try {
            String consulta = "UPDATE asignacionpracticas "
                    + "SET aprobadoMateria = 1 "
                    + "WHERE idAsignacionPractica = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idAsignacion);
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error aprobar: " + ex);
            return false;
        }
    }

    public boolean reprobo(String CI_estudiante) {
        int idAsignacion = getIdAsignacionPractica(CI_estudiante);
        PreparedStatement pst = null;
        try {
            String consulta = "UPDATE asignacionpracticas "
                    + "SET aprobadoMateria = 0 "
                    + "WHERE idAsignacionPractica = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idAsignacion);
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error reprobo: " + ex);
            return false;
        }
    }

    public boolean finalizar(String CI_estudiante) {
        int idAsignacion = getIdAsignacionPractica(CI_estudiante);
        PreparedStatement pst = null;
        try {
            String consulta = "UPDATE asignacionpracticas "
                    + "SET estadoPractica = 0 "
                    + "WHERE idAsignacionPractica = ? ";
            pst = getConnection().prepareStatement(consulta);
            pst.setInt(1, idAsignacion);
            return pst.executeUpdate() == 1;
        } catch (Exception ex) {
            System.err.println("Error finalizar: " + ex);
            return false;
        }
    }

}
