/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDAO;
import java.util.List;
import model.Asignatura;

/**
 *
 * @author erasto
 */
public class ProfesoresServicios {
     public List<Asignatura> getAsignaturas(String nombre) {
        AsignaturasDAO dao = new AsignaturasDAO();
        return dao.getAsignaturas(nombre);
    }
}
