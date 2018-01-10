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
import utils.PasswordHash;

/**
 *
 * @author Sergio
 */
public class CambioPasswordServicio {
    public User recogerDatos(String correo, String password){
        User user = null;
    
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
    public boolean comprobarPassword(User user,User user2){
        try {
            if(PasswordHash.getInstance().validatePassword(user2.getPassword(), user.getPassword())){
                return true;
            } else {
                return false;
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(CambioPasswordServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean cambioPassword(User user){
        UsersDAO dao = new UsersDAO();
        
        return dao.cambiarPassword(user);
    }
}
