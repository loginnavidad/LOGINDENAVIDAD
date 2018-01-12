/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.UsersDAO;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Profesor;
import model.User;
import utils.Constantes;
import utils.PasswordHash;
import utils.Utils;
import model.Alumno;

/**
 *
 * @author Miguel Angel Diaz
 */
public class UsersServicios {

    public Profesor recogidaProfesor(String nombreProfe) {
        Profesor profe = new Profesor();
        if (!"".equals(profe)) {
            profe.setNombre(nombreProfe);
        }
        return profe;
    }

    public Alumno recogidaAlumno(String nombreAlumno) {
        Alumno alum = new Alumno();
        if (!"".equals(nombreAlumno)) {
            alum.setNombre(nombreAlumno);
        }
        return alum;
    }

    public User mailProfesor(String nombreP, String pass) {
        User user = new User();

        if (!"".equals(nombreP)) {

            user.setUser(nombreP);
        }
        if (!"".equals(pass)) {

            user.setPassword(pass);
        }
        return user;
    }

    public User recogidaParametros(String nombre, String password, String correo) {
        User user = new User();

        if (!"".equals(nombre)) {

            user.setUser(nombre);
        }
        if (!"".equals(password)) {
            String hash = "";

            try {

                hash = PasswordHash.getInstance().createHash(password);

            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {

                Logger.getLogger(UsersServicios.class.getName()).log(Level.SEVERE, null, ex);
            }

            user.setPassword(hash);

            if (!"".equals(correo)) {
                user.setEmail(correo);
            }
            String codigo = Utils.randomAlphaNumeric(10);
            user.setCodigo_activacion(codigo);
            user.setActivo(Boolean.FALSE);

        }
        return user;
    }

    public List<User> getAllUsers() {
        UsersDAO dao = new UsersDAO();
        return dao.getUsers();
    }

    public boolean addUsuario(User user) {
        UsersDAO dao = new UsersDAO();
        MailServicios mail = new MailServicios();
        mail.mandarMail(user.getEmail(), Constantes.LINK_EMAIL + user.getCodigo_activacion(), Constantes.ASUNTO_EMAIL);
        return dao.addUser(user);
    }

    //Es posible que se deba mover
    public boolean addProfesor(User user, Profesor profe, User user2) {
        UsersDAO dao = new UsersDAO();
        MailServicios mail = new MailServicios();
        mail.mandarMail(user.getEmail(), Constantes.USUARIO + profe.getNombre() + "</br>" + Constantes.PASSWORD + user2.getPassword(), Constantes.ASUNTO_EMAIL);
        return dao.addProfe(user, profe);
    }

    //Es posible que se deba mover
    public boolean addAlumno(User user, Alumno alumno, User user2) {
        UsersDAO dao = new UsersDAO();
        MailServicios mail = new MailServicios();
        mail.mandarMail(user.getEmail(), Constantes.USUARIO + user2.getUser() + "</br>" + Constantes.PASSWORD + user2.getPassword(), Constantes.ASUNTO_EMAIL);
        return dao.addAlum(user, alumno);
    }

    public boolean comprobarNombres(String nombreUser) {
        UsersDAO dao = new UsersDAO();
        return dao.comprobarNombres(nombreUser);
    }

    public boolean login(User user) {
        CambioPasswordServicio cps = new CambioPasswordServicio();
        boolean valido = false;
        try {

            User userDB = cps.listarUsuarios(user.getEmail());
            boolean passCorrecta = PasswordHash.getInstance().validatePassword(user.getPassword(), userDB.getPassword());
            if (passCorrecta == true && userDB.getActivo()) {
                valido = true;
            }

        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(UsersServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }

    public User cogerPermiso(String correo) {
        UsersDAO dao = new UsersDAO();
        return dao.sacarPermiso(correo);
    }

    public int activar(String codigo) {
        UsersDAO dao = new UsersDAO();
        int activar;
        User userDB = dao.getUserByCodigoActivacion(codigo);

        if (!userDB.getActivo()) {
            if (true) {
                activar = dao.updateValido(userDB);
            } else {
                dao.borrarUserByCodigoActivacion(userDB);
                activar = 0;
            }
        } else {
            activar = 2;
        }
        return activar;
    }

    public boolean desactivarPermisoAdmin(String id) {
        UsersDAO dao = new UsersDAO();
        if (dao.desactivarPermisoDeAdmin(this.parseoId(id)) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean activaPermisoConSuper(String id) {
        UsersDAO dao = new UsersDAO();
        if (dao.activarPermisoAdmin(this.parseoId(id)) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean activarUserManualmente(String id) {
        UsersDAO dao = new UsersDAO();
        return dao.activarManualmente(this.parseoId(id));
    }

    public int parseoId(String id) {
        int idParseado = 0;
        idParseado = Integer.parseInt(id);
        return idParseado;
    }

    public long parseoIdLong(String id) {
        long idParseado = 0;
        idParseado = Long.parseLong(id);
        return idParseado;
    }

    public int parseoAdministrador(String admin) {
        if (admin != null) {
            return 1;
        } else {
            return 0;
        }
    }
}
