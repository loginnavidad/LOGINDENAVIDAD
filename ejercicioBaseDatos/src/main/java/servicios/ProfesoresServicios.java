/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnoDAO;
import dao.AsignaturasDAO;
import dao.CursosDAO;
import dao.NotasDAO;
import dao.ProfesoresDAO;
import dao.UsersDAO;
import java.util.List;
import model.Alumno;
import model.Asignatura;
import model.Curso;
import model.Nota;
import model.Profesor;
import model.User;

/**
 *
 * @author erasto
 */
public class ProfesoresServicios {
    public List<Asignatura> getAsignaturas(long id_prof) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAsignaturas(id_prof);
    }
     
    public User dameIdProf(String nombre_prof) {
        UsersDAO dao = new UsersDAO();
        return  dao.getUserByNombre(nombre_prof);       
    }

    public List<Alumno> getAlumnos(int id_asig) {
        AlumnoDAO dao = new AlumnoDAO();
        return  dao.getAlumnosAsignatura(id_asig);
    }
    
    public List<Profesor> getProfesores(){
        ProfesoresDAO dao = new ProfesoresDAO();
        return dao.getAllProfesores();
    }
/*
    public List<Nota> getNotas(List<Alumno> a) {
        NotasDAO dao = new NotasDAO();
        return dao.getNotasDAO(a);
    }*/
}
