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
     * Obtenemos las asignaturas del alumno
     * @param id_alumno id del alumno
     * @return listado contodas sus assignaturas
     */
    public List<Asignatura> getAsignaturaAlumno(int id_alumno){
    alumDao = new AlumnoDAO();
    return alumDao.getAsignaturaAlumno(id_alumno);
    }
}
