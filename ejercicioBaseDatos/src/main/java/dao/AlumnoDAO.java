package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
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
    Alumno a = null;
    public List<Alumno> listarAlumnos() {
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Alumno>> h = new BeanListHandler<>(Alumno.class);
            alumnos = qr.query(con, "SELECT * FROM Person", h);
            return alumnos = new ArrayList<>();
        } catch (Exception e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return alumnos;
    }

    public Alumno buscarAlumno(int id) {
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<Alumno> h = new BeanHandler<>(Alumno.class);
            a = qr.query(con, "SELECT * FROM ALUMNOS WHERE ID = ?", h, id);
        } catch (Exception e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return a;
    }
}
