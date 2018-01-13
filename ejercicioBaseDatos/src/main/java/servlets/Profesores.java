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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Alumno;
import model.Asignatura;
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
        
        String id_asignatura = request.getParameter("id_asignatura");
        
        HashMap root = new HashMap();
        Template temp = null;
        String page = null;

        if (id_asignatura != null) {  
            page = "profesoresAlumnos.ftl";
            List<Alumno> a = ps.getAlumnos(Integer.parseInt(id_asignatura));//le paso la asignatura y me devuelve los alumnos que pertenecen a ella y sus notas.
            root.put("alumnos", a);                          
        }else{
            page = "profesores.ftl";  
            List<Asignatura> asig = ps.getAsignaturas(17/*(long) request.getSession().getAttribute("idUser")*/);//devuelve lista de asignaturas de ese profesor y el curso de las mismas.
            root.put("asignaturas", asig);        
        }
        temp = Configuration.getInstance().getFreeMarker().getTemplate(page);
            try {
                temp.process(root, response.getWriter());
            } catch (TemplateException ex) {
                Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
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
