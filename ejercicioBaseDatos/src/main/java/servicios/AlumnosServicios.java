package servicios;

import dao.AlumnoDAO;
import java.util.List;
import model.Alumno;

/**
 *
 * @author miguel palomares
 */
public class AlumnosServicios {

    AlumnoDAO alumDao = null;
    
    /**
     * listamos todos los alumnos existentes
     *
     * @return listado de todos los alumnos
     */
    public List<Alumno> listarAlumnos() {
        return alumDao.listarAlumnos();
    }

    /**
     * Buscar un alumno
     *
     * @param id buscamos el alumno por su identificador
     * @return un objeto de tipo alumno
     */
    public Alumno buscarAlumno(int id) {
        return alumDao.buscarAlumno(id);
    }
}
