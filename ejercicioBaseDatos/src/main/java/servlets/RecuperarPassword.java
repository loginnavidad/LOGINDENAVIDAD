/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import config.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserChangePass;
import servicios.CambioPasswordServicio;
import servicios.MailServicios;
import servicios.RecuperarPasswordServicios;
import servicios.UsersServicios;
import utils.Constantes;
import utils.PasswordHash;
import utils.Utils;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "RecuperarPassword", urlPatterns = {"/recuperarpassword"})
public class RecuperarPassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HashMap root = new HashMap();
        RecuperarPasswordServicios rps = new RecuperarPasswordServicios();
        CambioPasswordServicio cps = new CambioPasswordServicio();
        String accion = request.getParameter("accion");
        boolean actualizadas;
        if (accion != null) {

            switch (accion) {
                case "recuperarpassword":
                    UserChangePass usuario = cps.recogerDatos(request.getParameter("correo"),"");
                    User usuario2 = cps.listarUsuarios(usuario.getEmail());
                    if (usuario2 == null) {
                        root.put("mensaje", "No tenemos este registro en la base de datos");
                    } else {
                        usuario2.setPassword(rps.hashPassword());
                        boolean actualizar = rps.updatePassword(usuario2);
                        if(actualizar){
                            rps.mandarCorreo(usuario2);
                        root.put("mensaje", "Su contraseña nueva se ha enviado al correo, consultelo.");
                        }else{
                            root.put("mensaje", "Hubo problema al cambiar su contraseña");
                        }
                    }
                    try {
                        Template temp = Configuration.getInstance().getFreeMarker().getTemplate("cambiohecho.ftl");
                        temp.process(root, response.getWriter());
                    } catch (TemplateException ex) {
                        Logger.getLogger(CambioPassword.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } else {

            try {
                Template temp = Configuration.getInstance().getFreeMarker().getTemplate("recuperarpassword.ftl");
                temp.process(root, response.getWriter());
            } catch (TemplateException ex) {
                Logger.getLogger(Superadministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
