/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Asignatura;
import model.Curso;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.Constantes;

/**
 *
 * @author Sergio
 */
public class CursosDAO {
    
    public boolean addCurso(Curso curso) {
        Connection con = null;
        try {
            try {
                con = DBConnection.getInstance().getConnection();
                con.setAutoCommit(false);
            } catch (Exception ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            QueryRunner qr = new QueryRunner();
            //QUERY PARA INSERTAR EL CURSO
            long id = qr.insert(con,
                    Constantes.ADD_CURSO,
                    new ScalarHandler<Long>(), curso.getDescripcion());
            //GUARDAMOS EL ID DEL CURSO
            curso.setId(id);
            //INSERTAMOS LA ASIGNATURA ASOCIANDOLA AL CURSO
            
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
           
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return true;
    }
    
    public List<Curso> listCursos(){
        List<Curso> listaCursos = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Curso>> h = new BeanListHandler<Curso>(Curso.class);
            listaCursos = qr.query(con, Constantes.LISTAR_CURSOS, h);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return listaCursos;
    }
}
