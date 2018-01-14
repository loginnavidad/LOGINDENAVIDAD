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
import model.Profesor;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.Constantes;

/**
 *
 * @author erasto
 */
public class ProfesoresDAO {
    public List<Profesor> getAllProfesores(){
        List<Profesor> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Profesor>> h = new BeanListHandler<Profesor>(Profesor.class
            );
            lista = qr.query(con, Constantes.COGER_TODOS_PROFESORES, h);

        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }
}
