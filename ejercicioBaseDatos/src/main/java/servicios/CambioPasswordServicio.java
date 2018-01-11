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
import model.User;
import model.UserChangePass;
import utils.PasswordHash;

/**
 *
 * @author Sergio
 */
public class CambioPasswordServicio {
    public UserChangePass recogerDatos(String correo, String password){
        UserChangePass user = new UserChangePass();
    
        if (!"".equals(correo)) {
            user.setEmail(correo);
        }
        if (!"".equals(password)) {
            user.setPassword(password);
        }
        return user;
    }
    public User listarUsuarios(String correo){
        UsersDAO dao = new UsersDAO();
        return dao.getUserByEmail(correo);
    }
    public boolean comprobarPassword(User user,UserChangePass user2){
        try {
            return PasswordHash.getInstance().validatePassword(user2.getPassword(), user.getPassword());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(CambioPasswordServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean cambioPassword(User user){
        UsersDAO dao = new UsersDAO();
        String hash = "";
        try {

                hash = PasswordHash.getInstance().createHash(user.getPassword());

            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {

                Logger.getLogger(UsersServicios.class.getName()).log(Level.SEVERE, null, ex);
            }

            user.setPassword(hash);
        return dao.cambiarPassword(user);
    }
}
