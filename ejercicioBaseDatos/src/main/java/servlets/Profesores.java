/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.AsignaturasServicios;
import servicios.ProfesoresServicios;

/**
 *
 * @author erasto
 */
@WebServlet(name = "Profesores", urlPatterns = {"/profesores"})
public class Profesores extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AsignaturasServicios as = new AsignaturasServicios();
        
        String nombre = request.getParameter("nombre");
        String id_asig = request.getParameter("id_asig");
        String asignatura = request.getParameter("asignatura");
        
        //la primera vista del profesor es una lista de todas las asignaturas que imparte.
        //Segun la que escoja se mostrara otra vista con un listado de los alumnos que hay en esa asignatura,
        //y las notas de cada uno, si las tuviera, ademas de un menu con las opciones insertar nota, borrar nota etc
        //y poner tareas.
        
        if (asignatura != null) {
      
            String op = request.getParameter("op");
            
            if(op != null){
                switch (op) {
                case "insertar_nota":
                    
                    break;
                case "modificar_nota":
                    
                    break;
                case "borrar_nota":
                    
                    break;
                }
            }
             //request.setAttribute("alumnos", as.getAsignaturas(nombre)); queri que muestra los alumnos que hay en esa asignatura
            //request.getRequestDispatcher("alumnos.jsp").forward(request, response);
        }
        
        
        request.setAttribute("profesores", as.getAsignaturas(nombre));
        request.getRequestDispatcher("profesores.jsp").forward(request, response);
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
