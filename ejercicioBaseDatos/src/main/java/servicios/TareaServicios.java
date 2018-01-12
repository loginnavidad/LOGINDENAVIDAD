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
}
