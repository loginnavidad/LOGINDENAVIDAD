/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
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
 * @author Miguel Angel Diaz
 */
public class AsignaturasDAO {

    public List<Asignatura> getAllAsignaturas() {
        List<Asignatura> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Asignatura>> h = new BeanListHandler<Asignatura>(Asignatura.class);
            lista = qr.query(con, "select * FROM ASIGNATURAS", h);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public boolean addAsig(Asignatura asig, long id_curso) {
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
            asig.setId_curso(id_curso);
            long id = qr.insert(con,
                    Constantes.ADD_ASIGNATURA,
                    new ScalarHandler<Long>(), asig.getNombre(), asig.getId_curso());
            //GUARDAMOS EL ID DEL CURSO
            asig.setId(id);
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
    
    public List<Asignatura> getAsignaturas(long id_prof) {
        List<Asignatura> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Asignatura>> h = new BeanListHandler<Asignatura>(Asignatura.class);
            lista = qr.query(con, "select * FROM ASIGNATURAS as"
                    + "join PROFE_ASIGNATURA pa"
                    + "on pa.ID_ASIGNATURA = as.ID"
                    + "where pa.ID_PROFE = ?", h, id_prof);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
    
/*
    public int updateAsignatura(Asignatura a) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            filas = qr.update(con, "UPDATE ASIGNATURAS SET NOMBRE = ?, CICLO = ?, CURSO = ? WHERE ID = ?", a.getNombre(), a.getCiclo(), a.getCurso(), a.getId());

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas;
    }

    public int delAsignatura(Asignatura a) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            filas = qr.update(con, "DELETE FROM ASIGNATURAS WHERE ID = ?", a.getId());

        } catch (Exception ex) {
            if (ex.getMessage().contains("foreign")){
                filas = -1;
            }
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas;
    }
    
    public int delAsignatura2(Asignatura a) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            filas += qr.update(con, "DELETE FROM NOTAS WHERE ID_ASIGNATURA = ?", a.getId());
            filas += qr.update(con, "DELETE FROM ASIGNATURAS WHERE ID = ?", a.getId());
            
            con.commit();

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                if (con!=null)
                    con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas;
    }*/
}
