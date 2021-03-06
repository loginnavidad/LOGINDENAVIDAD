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
import servicios.UsersServicios;
import utils.Constantes;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "CambioPassword", urlPatterns = {"/cambiopassword"})
public class CambioPassword extends HttpServlet {

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
        CambioPasswordServicio cps = new CambioPasswordServicio();
        String accion = request.getParameter("accion");
        boolean actualizadas;
        if (accion != null) {

            switch (accion) {
                case "cambiopassword":
                    UserChangePass usuario = cps.recogerDatos(request.getParameter("correo"), request.getParameter("passLogin"));
                    User usuario2 = cps.listarUsuarios(usuario.getEmail());
                    if (cps.comprobarPassword(usuario2, usuario)) {
                        actualizadas = cps.cambioPassword(usuario2);
                        if (actualizadas) {
                            root.put(Constantes.VARIABLE_MENSAJE, "Su contraseña se actualizó correctamente");
                        } else {
                            root.put(Constantes.VARIABLE_MENSAJE, "Ha ocurrido un error al cambiar su contraseña");
                        }

                    } else {
                        root.put(Constantes.VARIABLE_MENSAJE, "Correo o contraseña equivocado");
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
                Template temp = Configuration.getInstance().getFreeMarker().getTemplate("cambiopassword.ftl");
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
