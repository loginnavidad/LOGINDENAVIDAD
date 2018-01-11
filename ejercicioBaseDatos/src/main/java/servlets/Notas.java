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
import model.Nota;
import servicios.NotasServicios;

/**
 *
 * @author erasto
 */
@WebServlet(name = "Notas", urlPatterns = {"/sesion/notas"})
public class Notas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NotasServicios ns = new NotasServicios();
        
        String op = request.getParameter("accion");
        
        String id_alumno = request.getParameter("id_alumno");
        String id_asignatura = request.getParameter("id_asignatura");
        String nota = request.getParameter("nota");
       
        HashMap root = new HashMap();
        Template temp = null;

        if (op != null) {
            int filas;
            Nota n = new Nota();
            n.setIdAlumno(Long.parseLong(id_alumno));
            n.setIdAsignatura(Long.parseLong(id_asignatura));
            n.setNota(Integer.parseInt(nota));
            
            n = ns.guardarNota(n);
            
            if (n != null) {
                filas = 1;
                root.put("mensaje", filas+" nota modificada correctamente"); 
            }else{
                root.put("mensaje", "no se han hecho modificaciones"); 
            }
            root.put("nota", n);
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
