package dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignatura;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author miguel palomares
 */
public class AlumnoDAO {

    
    Connection con = null;
    List<Alumno> alumnos = null;
    List<Asignatura> asignatura = null;
    Alumno a = null;
    public List<Alumno> listarAlumnos() {
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Alumno>> h = new BeanListHandler<>(Alumno.class);
            alumnos = qr.query(con, "SELECT * FROM ALUMNOS", h);
        } catch (Exception e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return alumnos;
    }

    public Alumno buscarAlumno(String nombre) {
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<Alumno> h = new BeanHandler<>(Alumno.class);
            a = qr.query(con, "SELECT * FROM ALUMNOS WHERE NOMBRE = ?", h, nombre);
        } catch (Exception e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return a;
    }

    public List<Alumno> getAlumnosAsignatura(int id_asig) {
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Alumno>> h = new BeanListHandler<>(Alumno.class);
            alumnos = qr.query(con, "SELECT al.*, aa.NOTA "
                    + "FROM ALUMNOS al"
                    + "join ALUMNO_ASIGNATURA aa"
                    + "on al.ID = aa.ID_ALUMNO"
                    + " WHERE aa.ID_ASIGNATURA = ?", h, id_asig);
        } catch (Exception e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return alumnos;
    }
    
    public List<Asignatura> getAsignaturaAlumno(int id_alumno) {
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Asignatura>> h = new BeanListHandler<>(Asignatura.class);
            asignatura = qr.query(con, "select asi.* , aa.nota\n" +
                    "from alumno_asignatura aa\n" +
                    "join asignaturas asi\n" +
                    "on aa.id_asignatura=asi.id\n" +
                    "where aa.id_alumno=?;", h, id_alumno);
        } catch (Exception e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return asignatura;
    }
    
}
