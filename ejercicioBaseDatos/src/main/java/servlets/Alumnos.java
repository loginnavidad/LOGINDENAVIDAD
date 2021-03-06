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
import servicios.AlumnosServicios;
import utils.Constantes;

/**
 *
 * @author miguel palomares
 */
@WebServlet(name = "Alumnos", urlPatterns = {"/alumnos"})
public class Alumnos extends HttpServlet {

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
        
        int id_usuario=(Integer)request.getSession().getAttribute("idUser");
        AlumnosServicios as = new AlumnosServicios();
        String siguientePaginas = request.getParameter("paginacion");
        int siguientesAsig = 0;
        if(null != siguientePaginas){
            siguientesAsig = Integer.parseInt(siguientePaginas);
        }
 
        HashMap root = new HashMap();
        Template temp = null;
        //obtenemos las asignaturas y sus notas mediante el id del alumno
        root.put("asignaturas",  as.getAsignaturaAlumno(id_usuario, siguientesAsig));
        root.put("numAsig", siguientesAsig);

        temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.LISTA_ASIGNATURA_ALUMNO);
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
