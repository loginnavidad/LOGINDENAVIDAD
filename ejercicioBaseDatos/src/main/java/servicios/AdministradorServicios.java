/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AdministradorDAO;

/**
 *
 * @author Sergio
 */
public class AdministradorServicios {
    public boolean asignarProfeAsignatura(String id_profe,String id_asignatura){
        AdministradorDAO dao = new AdministradorDAO();
        return dao.asignarProfe(this.parseoId(id_profe), this.parseoId(id_asignatura));
    }
    
    public int parseoId(String id){
        int idParseado = 0;
        idParseado = Integer.parseInt(id);
        return idParseado;
    }
}
