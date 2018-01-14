package servicios;

import dao.TareasDAO;
import java.util.List;
import model.Tarea;

/**
 *
 * @author miguel palomares
 */
public class TareaServicios {
    /**
     * Listamos las tareas del alumno y la asignatura correspondiente
     * @param id_alum id del alumno
     * @param id_asignatura id de la asignatura
     * @return listado con las tareas de la asignatura del alumno
     */
    public List<Tarea> listarTareas(int id_alum,int id_asignatura){
        TareasDAO tareasDao=new TareasDAO();
        return tareasDao.listarTareas(id_alum,id_asignatura);   
    } 

    public int crearTarea(Tarea t) {
        TareasDAO tareasDao=new TareasDAO();
        return tareasDao.crearTareaDAO(t);
    }
    
    /**
     * El alumno sube la tarea de la asignatura correspondiente
     * @param idTarea id de la tarea
     * @return devuelve 1 en el caso de que la tarea se haya subido en caso contrario el
     * valor devuleto sera 0
     */
    public int subTareaAlumn(int idTarea) {
        TareasDAO tareasDao = new TareasDAO();
        return tareasDao.subTareaAlumn(idTarea);
    }
}
