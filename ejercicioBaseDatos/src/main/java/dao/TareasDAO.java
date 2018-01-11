package dao;

import java.sql.Connection;
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
    
    public List<Tarea> listarTareas(int id_alum){
   
         try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Tarea>> h = new BeanListHandler<>(Tarea.class);
            tareas = qr.query(con, "SELECT t.ID_TAREA, t.ID_ASIGNATURA,t.NOMBRE,t.FECHA_ENTREGA,ta.HECHO,ta.idAlumno\n" +
                    "from tareas t\n" +
                    "join tareas_alumnos ta \n" +
                    "on t.ID_TAREA=ta.idTarea\n" +
                    "where ta.idAlumno=?", h, id_alum);           
        } catch (Exception e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return tareas;
    }
}
