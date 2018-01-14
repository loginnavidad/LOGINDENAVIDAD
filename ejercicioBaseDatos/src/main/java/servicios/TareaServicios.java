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
     * @param siguientesTareas las 10 siguientes tareas
     * @return listado con las tareas de la asignatura del alumno
     */
    public List<Tarea> listarTareas(int id_alum,int id_asignatura,int siguientesTareas){
        TareasDAO tareasDao=new TareasDAO();
        return tareasDao.listarTareas(id_alum,id_asignatura,siguientesTareas);   
    } 

    /**
     * Creamos la tarea a los alumnos
     * @param t objeto de tipo tarea
     * @return 1 si la tarea se ha creado y 0 en caso contrario
     */
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
