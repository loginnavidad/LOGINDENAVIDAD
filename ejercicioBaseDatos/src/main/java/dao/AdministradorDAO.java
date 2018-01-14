/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.Constantes;

/**
 *
 * @author Sergio
 */
public class AdministradorDAO {

    public boolean asignarProfe(int id_profe, int id_asignatura) {
        Connection con = null;
        try {
            try {
                con = DBConnection.getInstance().getConnection();
            } catch (Exception ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            QueryRunner qr = new QueryRunner();

            BigInteger id = qr.insert(con,
                    Constantes.ASIGNAR_PROFESOR_ASIGNATURA,
                    new ScalarHandler<BigInteger>(), id_profe, id_asignatura);

        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return true;
    }
}
