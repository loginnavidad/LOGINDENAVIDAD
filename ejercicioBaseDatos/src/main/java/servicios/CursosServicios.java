/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.CursosDAO;
import java.util.List;
import model.Curso;

/**
 *
 * @author Sergio
 */
public class CursosServicios {
    public Curso recogerCurso(String descripcion){
     Curso curso = new Curso();
     if(!"".equals(descripcion)){
         curso.setDescripcion(descripcion);
     }
     return curso;
 }
    public boolean addCursos(Curso curso){
        CursosDAO dao = new CursosDAO();
       return dao.addCurso(curso);
    }
    
    public List<Curso> listarCursos(){
       CursosDAO dao = new CursosDAO();
       return dao.listCursos();
    }
}
