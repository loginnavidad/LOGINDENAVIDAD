/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import model.User;

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
    public boolean cambioPassword(User user){
        return true;
    }
}
