package servlets;

import config.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tarea;
import servicios.TareaServicios;
import utils.Constantes;

/**
 *
 * @author miguel palomares
 */
@WebServlet(name = "Tareas", urlPatterns = {"/tareas"})
public class Tareas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        TareaServicios ts = new TareaServicios();
        Tarea t = new Tarea();
        Template temp = null;
        HashMap root = new HashMap();
        String op = request.getParameter("op");
        int id_asig = Integer.parseInt(request.getParameter("id"));
        String page = null;
        
        switch ((String) request.getSession().getAttribute("permisoUser")) {
            case "ALUMNO":
                int id_alumno = (Integer) request.getSession().getAttribute("idAlumno");

                page = Constantes.LISTA_TAREAS;
                if (op.equals("UPD_TAREA")) {
                    int idTarea = Integer.parseInt(request.getParameter("id_tarea"));
                    int ok = ts.subTareaAlumn(idTarea);
                    root.put("ok", ok);
                }

                String siguientePaginas = request.getParameter("paginacion");
                int siguientesTareas = 0;
                if (null != siguientePaginas) {
                    siguientesTareas = Integer.parseInt(siguientePaginas);
                }
                //obtenemos las tareas de la asignatura por medio de la id de alumno y la id de asignatura                
                root.put("tareas", ts.listarTareas(id_alumno, id_asig, siguientesTareas));
                root.put("id_asig", id_asig);
                root.put("numAsig", siguientesTareas);
                break;

            case "PROFESOR":
                
                page = Constantes.AÑADIR_TAREA;
                if(op.equals("CREAR_TAREA")){
                    String nombreTarea = request.getParameter("nombreTarea");
                    String fechaEntrega = request.getParameter("fechaEntrega");
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate local = LocalDate.parse(fechaEntrega,dtf);
                    t.setId_asignatura(id_asig);
                    t.setNombre(nombreTarea);
                    t.setFecha_entrega(Date.from(local.atStartOfDay().toInstant(ZoneOffset.UTC)));
                    
                    root.put("ok", ts.crearTarea(t));
                }
                break;
        }

        temp = Configuration.getInstance().getFreeMarker().getTemplate(page);

        try {
            temp.process(root, response.getWriter());
        } catch (TemplateException ex) {
            Logger.getLogger(Tareas.class.getName()).log(Level.SEVERE, null, ex);
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
