package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tarea;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author miguel palomares
 */
public class TareasDAO {
    Connection con = null;
    List<Tarea> tareas = null;
    
    public List<Tarea> listarTareas(int id_alum,int id_asignatura){
   
         try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Tarea>> h = new BeanListHandler<>(Tarea.class);
            tareas = qr.query(con, "SELECT t.ID_TAREA, t.ID_ASIGNATURA,t.NOMBRE,t.FECHA_ENTREGA,ta.HECHO,ta.idAlumno\n" +
                    "from tareas t\n" +
                    "join tareas_alumnos ta \n" +
                    "on t.ID_TAREA=ta.idTarea\n" +
                    "where ta.idAlumno=? and t.ID_ASIGNATURA=?;", h, id_alum,id_asignatura);           
        } catch (Exception e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return tareas;
    }

    public int crearTareaDAO(Tarea t) {
        
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO TAREAS (ID_ASIGNATURA,NOMBRE,FECHA_ENTREGA) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, t.getId_asignatura());
            stmt.setString(2, t.getNombre());
            stmt.setDate(3, new java.sql.Date(t.getFecha_entrega().getTime()));  
            filas = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                t.setId_tarea(rs.getInt(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(TareasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas;
    }
}
