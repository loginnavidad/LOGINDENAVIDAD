/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.UsersDAO;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.Constantes;
import utils.PasswordHash;
import utils.Utils;

/**
 *
 * @author Sergio
 */
public class RecuperarPasswordServicios {
public String hacerPassword(){
            String password = Utils.randomAlphaNumeric(10);
            return password;
        }
        public String hashPassword(String password){
            String hash = "";

        try {
            hash = PasswordHash.getInstance().createHash(password);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(UsersServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }
        public static void mandarCorreo(User user, String password){
            MailServicios mail = new MailServicios();
            mail.mandarMailRecuperar(user.getEmail(),  Constantes.PASSWORD + password, Constantes.ASUNTO_EMAIL);
        }
        public boolean updatePassword(User usuario){
            UsersDAO dao = new UsersDAO();
            return dao.cambiarPassword(usuario);
        }
}
