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
import servicios.AsignaturasServicios;
import servicios.CursosServicios;
import servicios.ProfesoresServicios;
import servicios.UsersServicios;
import servicios.AdministradorServicios;
import utils.Constantes;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "Administrador", urlPatterns = {"/administrador"})
public class Administrador extends HttpServlet {

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
        ProfesoresServicios ps = new ProfesoresServicios();
        CursosServicios cs = new CursosServicios();
        AsignaturasServicios as = new AsignaturasServicios();
        AdministradorServicios adms = new AdministradorServicios();

        HashMap root = new HashMap();

        String accion = request.getParameter("accion");
        if (null != accion) {
            switch (accion) {
                case "asignarProfesor":
                    if (adms.asignarProfeAsignatura(request.getParameter("id_profesor"), request.getParameter("id_asignatura"))) {
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.MENSAJE_ASIGNAR_PROFE);
                    } else {
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.MENSAJE_ASIGNAR_PROFE_ERROR);
                    }
                    try {
                        Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.ASIGNAR_PROFESOR);
                        temp.process(root, response.getWriter());
                    } catch (TemplateException ex) {
                        Logger.getLogger(Superadministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }

        root.put("asignaturas", as.getAllAsignaturas());
        root.put("profesores", ps.getProfesores());
        root.put("cursos", cs.listarCursos());
        try {
            Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.PANTALLA_ADMIN);
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Superadministrador.class.getName()).log(Level.SEVERE, null, ex);
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
