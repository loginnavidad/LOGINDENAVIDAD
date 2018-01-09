/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDAO;
import dao.UsersDAO;
import java.util.List;
import model.Asignatura;
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

    public User getAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
