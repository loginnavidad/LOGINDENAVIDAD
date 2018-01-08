/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDAO;
import model.Asignatura;
import java.util.List;
import model.Curso;

/**
 *
 * @author Miguel Angel Diaz
 */
public class AsignaturasServicios {
 public Asignatura recogerAsignatura(String nombre){
        Asignatura asignatura = new Asignatura();
        if (!"".equals(nombre)) {
                asignatura.setNombre(nombre);
            }
        return asignatura;
    }
 public Curso recogerCurso(String descripcion){
     Curso curso = new Curso();
     if(!"".equals(descripcion)){
         curso.setDescripcion(descripcion);
     }
     return curso;
 }
    public List<Asignatura> getAllAsignaturas() {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAllAsignaturas();
    }

    public boolean addAsignatura(Asignatura asignatura,Curso curso){
        AsignaturasDAO dao = new AsignaturasDAO();
       return dao.addAsig(asignatura,curso);
    }
    
    public List<Asignatura> getAsignaturas(String nombreProf) {//Devuelve todas las asignaturas de un profesor
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAsignaturas(nombreProf);
    }
/*
    public int updateAsignatura(Asignatura a) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.updateAsignatura(a);
    }

    public int delAsignatura(Asignatura a) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.delAsignatura(a);
    }
    
    public int delAsignatura2(Asignatura a){
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.delAsignatura2(a);
    }
    */
}
