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
import servicios.ProfesoresServicios;

/**
 *
 * @author erasto
 */
@WebServlet(name = "Profesores", urlPatterns = {"/profesores"})
public class Profesores extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProfesoresServicios ps = new ProfesoresServicios();
        
        String id_asig = request.getParameter("id_asig");
        String asignatura = request.getParameter("asignatura");
        String op = request.getParameter("op");
        
        HashMap root = new HashMap();
        Template temp = null;
        
        if (asignatura != null) {
            
            User u = ps.getAlumnos();//le paso la asignatura y me devuelve los alumnos que pertenecen a ella
                                     //tambien debera mostrar las notas de los alumnos, si los tuviera
            
            
            
            
        }else if(op != null){
                switch (op) {
                case "insertar_nota":
                    
                    break;
                case "añadir_tarea":
                    
                    break;
                }     
        }else{
            User u = ps.dameIdProf(request.getParameter("nombre_prof"));//extrae la id del profesor
            root.put("asignaturas",  ps.getAsignaturas(u.getId()));//devuelve lista de asignaturas de ese profesor

            temp = Configuration.getInstance().getFreeMarker().getTemplate("profesores.ftl");

            try {
                temp.process(root, response.getWriter());
            } catch (TemplateException ex) {
                Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
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
