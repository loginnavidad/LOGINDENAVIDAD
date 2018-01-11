package servicios;

import dao.AlumnoDAO;
import java.util.List;
import model.Alumno;
import model.Asignatura;

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
        alumDao = new AlumnoDAO();
        return alumDao.listarAlumnos();
    }

    /**
     * Buscar un alumno
     *
     * @param nombre buscamos el alumno por su identificador
     * @return un objeto de tipo alumno
     */
    public Alumno buscarAlumno(String nombre) {
        alumDao = new AlumnoDAO();
        return alumDao.buscarAlumno(nombre);
    }
    
    public List<Asignatura> getAsignaturaAlumno(int id_alumno){
    alumDao = new AlumnoDAO();
    return alumDao.getAsignaturaAlumno(id_alumno);
    }
}
