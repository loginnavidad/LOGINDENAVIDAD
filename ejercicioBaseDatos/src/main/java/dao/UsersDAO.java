/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Profesor;
import model.User;
import model.Alumno;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.Constantes;

/**
 *
 * @author Miguel Angel Diaz
 */
public class UsersDAO {

    private final String queryRegistrar = "INSERT INTO USERS (NOMBRE,PASSWORD,CODIGO_ACTIVACION,ACTIVO,FECHA_ACTIVACION,EMAIL) VALUES(?,?,?,0,?,?)";
    private final String queryComprobarNombres = "SELECT NOMBRE FROM USERS WHERE NOMBRE = ?";
    private final String queryUserByCodigoActivacion = "SELECT * FROM USERS WHERE CODIGO_ACTIVACION = ?";
    private final String queryActivar = "UPDATE USERS SET ACTIVO = TRUE WHERE CODIGO_ACTIVACION = ?";
    private final String queryBorrar = "DELETE FROM USERS WHERE CODIGO_ACTIVACION = ?";
    private final String queryUserByNombre = "SELECT * FROM USERS WHERE NOMBRE = ?";

    public boolean addUser(User usuario) {
        Connection con = null;
        int id_permiso = 5;
        try {
            try {
                con = DBConnection.getInstance().getConnection();
                con.setAutoCommit(false);
            } catch (Exception ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            QueryRunner qr = new QueryRunner();
            //QUERY PARA INSERTAR EL USUARIO EN LA TABLA DE USUARIOS
            long id = qr.insert(con,
                    Constantes.INSERTAR_USERS,
                    new ScalarHandler<Long>(), usuario.getUser(), usuario.getPassword(), usuario.getCodigo_activacion(), usuario.getEmail(), usuario.getActivo());

            usuario.setId(id);
            //LE DAMOS INICIALMENTE UN PERMISO DE INVITADO CON EL QUE NO PODRA ACCEDER A NADA
 

            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);

            try {
                if (con != null) {
                    con.rollback();
                    return false;
                }
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex1);
                return false;
            }
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return true;
    }

    public boolean addProfe(User user, Profesor profe) {
        Connection con = null;
        int id_permiso = 2;
        try {
            try {
                con = DBConnection.getInstance().getConnection();
                con.setAutoCommit(false);
            } catch (Exception ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            QueryRunner qr = new QueryRunner();
            //QUERY PARA INSERTAR EL USUARIO EN LA TABLA DE USUARIOS
            BigInteger id = qr.insert(con,
                    Constantes.INSERTAR_USERS,
                    new ScalarHandler<BigInteger>(), user.getUser(), user.getPassword(), user.getCodigo_activacion(), user.getEmail(), true);

            user.setId(id.longValue()); 
            profe.setId_user(id.longValue());

            //INSERTAMOS EL PROFESOR EN LA TABLA DE PROFESORES
            BigInteger idProfesor = qr.insert(con,
                    Constantes.INSERTAR_EN_PROFESOR,
                    new ScalarHandler<BigInteger>(), user.getId(), profe.getNombre());
            
            
            //LE DAMOS EL PERMISO
            BigInteger idPermiso = qr.insert(con,
                    Constantes.DAR_PERMISO,
                    new ScalarHandler<BigInteger>(), id_permiso, user.getId());
           

            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);

            try {
                if (con != null) {
                    con.rollback();
                    return false;
                }
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex1);
                return false;
            }
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return true;
    }

    public boolean addAlum(User user, Alumno alumno) {
        Connection con = null;
        int id_permiso = 2;
        try {
            try {
                con = DBConnection.getInstance().getConnection();
                con.setAutoCommit(false);
            } catch (Exception ex) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            QueryRunner qr = new QueryRunner();
            //QUERY PARA INSERTAR EL USUARIO EN LA TABLA DE USUARIOS
            BigInteger id = qr.insert(con,
                    Constantes.INSERTAR_USERS,
                    new ScalarHandler<BigInteger>(), user.getUser(), user.getPassword(), user.getCodigo_activacion(), user.getEmail(), true);

            user.setId(id.longValue());
            //INSERTAMOS EL ALUMNO EN LA TABLA DE ALUMNOS
            BigInteger idAlumno = qr.insert(con,
                    Constantes.INSERTAR_EN_ALUMNOS,
                    new ScalarHandler<BigInteger>(), user.getId(), alumno.getNombre());
            
            alumno.setId(idAlumno.longValue());
            //LE DAMOS EL PERMISO DE USUARIO CON LA VARIABLE ID PERMISO
            BigInteger idPermiso = qr.insert(con,
                    Constantes.DAR_PERMISO,
                    new ScalarHandler<BigInteger>(), id_permiso, alumno.getId());

            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);

            try {
                if (con != null) {
                    con.rollback();
                    return false;
                }
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex1);
                return false;
            }
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return true;
    }
    

    public List<User> getUsers() {
        List<User> lista = null;
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<User>> h = new BeanListHandler<User>(User.class
            );
            lista = qr.query(con, Constantes.SELECT_USERS_PERMISOS, h);

        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public boolean comprobarNombres(String nombreUser) {
        boolean existe = false;
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            String nombres = jtm.queryForObject(queryComprobarNombres, String.class,
                    nombreUser);

            if (nombres != null) {
                existe = true;

            }
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }

    public int updateValido(User user) {
        int valido = -1;
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        if (jtm.update(queryActivar, user.getCodigo_activacion()) > 0) {
            valido = 1;
        }

        return valido;
    }

    public int borrarUserByCodigoActivacion(User user) {
        int valido = -1;
        JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        if (jtm.update(queryBorrar, user.getCodigo_activacion()) > 0) {
            valido = 1;
        }

        return valido;
    }

    public User getUserByCodigoActivacion(String codigoActivacion) {
        User u;
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            u  = (User) jtm.queryForObject(queryUserByCodigoActivacion, new Object[]{codigoActivacion}, new BeanPropertyRowMapper(User.class
                    ));

        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return u;
    }

    public User getUserByNombre(String nombre) {
        User u;
        try {
            JdbcTemplate jtm = new JdbcTemplate(DBConnection.getInstance().getDataSource());
            u
                    = (User) jtm.queryForObject(queryUserByNombre, new Object[]{nombre}, new BeanPropertyRowMapper(User.class
                    ));

        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            u = null;
        }
        return u;
    }

    public int desactivarPermisoDeAdmin(int id) {
        Connection con = null;
        int permisoUser = 5;
        int filas_actualizadas = 0;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            filas_actualizadas = qr.update(con,
                    Constantes.DESHACER_ADMIN, permisoUser, id);
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas_actualizadas;
    }

    public int activarPermisoAdmin(int id) {
        Connection con = null;
        int permisoUser = 1;
        int filas_actualizadas = 0;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            filas_actualizadas = qr.update(con,
                    Constantes.HACER_ADMIN, permisoUser, id);
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return filas_actualizadas;
    }

    public boolean activarManualmente(int id) {
        Connection con = null;
        int activo = 1;
        int filas_actualizadas = 0;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            filas_actualizadas = qr.update(con,
                    Constantes.ACTIVACION_MANUAL, activo, id);
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return true;
    }
    
    public int sacarPermiso(String nombre){
        Connection con = null;
        return 2;
    }
    public User getUserByEmail(String correo){
        Connection con = null;
        User user = null;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<User> h = new BeanHandler<>(User.class);
            user = qr.query(con, Constantes.SELECT_USERS_PERMISOS, h,correo);
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return user;
    }
    public boolean cambiarPassword(User user){
        Connection con = null;
        int actualizadas = 0;
        try {
            con = DBConnection.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            actualizadas = qr.update(con,
                    Constantes.UPDATE_NEW_PASSWORD,user.getPassword(),user.getEmail());
        } catch (Exception ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBConnection.getInstance().cerrarConexion(con);
        }
        return true;
    }
}
