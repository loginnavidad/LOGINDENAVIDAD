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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Asignatura;
import model.Curso;
import servicios.AsignaturasServicios;
import utils.Constantes;

/**
 *
 * @author Miguel Angel Diaz
 */
@WebServlet(name = "Asignaturas", urlPatterns = {"/asignaturas"})
public class Asignaturas extends HttpServlet {

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

        AsignaturasServicios as = new AsignaturasServicios();
        
        String op = request.getParameter("accion");
        HashMap root = new HashMap();
        boolean insertadas = false;
        if (op != null) {
            

            switch (op) {
                
                case "addAsignatura":
                    Asignatura asignatura = as.recogerAsignatura(request.getParameter("nombreAsignatura"));
                    insertadas = as.addAsignatura(asignatura,request.getParameter("id_curso"));
                    if (!insertadas) {
                        try {
                            root.put("insertado", 0);
                            root.put("mensaje", Constantes.MENSAJE_ASIGNATURA_CREADA_MAL);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            root.put("insertado", 1);
                            root.put("mensaje", Constantes.MENSAJE_ASIGNATURA_CREADA_BIEN);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
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
