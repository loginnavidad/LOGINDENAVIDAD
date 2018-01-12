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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tarea;
import servicios.TareaServicios;

/**
 *
 * @author miguel palomares
 */
@WebServlet(name = "Tareas", urlPatterns = {"/tareas"})
public class Tareas extends HttpServlet {

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
        
        String op = request.getParameter("op");
        TareaServicios ts = new TareaServicios();
        Tarea t = new Tarea();
        Template temp = null;
        HashMap root = new HashMap();
        int id_asig = Integer.parseInt(request.getParameter("id"));
        
        switch ("ALUMNO"/*(String) request.getSession().getAttribute("permisoUser")*/) {
            case "ALUMNO":
                //listamos las tareas de la asignatura del alumno
                
                if(op.equals("LISTAR")){
                
                //alerta!! cambiar el id de usuario por el id guardado en session por el fijo(8 solo es de prueba)
                root.put("tareas", ts.listarTareas(8,id_asig));
                }
                if(op.equals("UPD_TAREA")){
                    
                }
                root.put("tareas", ts.listarTareas(8,id_asig));
                break;
            case "PROFESOR":

                String nombreTarea = (request.getParameter("nombreTarea"));
                String fechaEntrega = request.getParameter("fechaEntrega");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate local = LocalDate.parse(fechaEntrega,dtf);
                 
                t.setId_asignatura(id_asig);
                t.setNombre(nombreTarea); 
                t.setFecha_entrega(Date.from(local.atStartOfDay().toInstant(ZoneOffset.UTC)));
                    
                int fila = ts.crearTarea(t);
                    
                if(fila != 0){
                    root.put("mensajeTarea", "tarea modificada correctamente");
                } else {
                    root.put("tareas", "no se ha podido crear la tarea");
                }
                break;

        }
        
        if(op.equals("ALUMNO")){
            temp = Configuration.getInstance().getFreeMarker().getTemplate("listaTareas.ftl");
        }else if(op.equals("PROFESOR")){
            temp = Configuration.getInstance().getFreeMarker().getTemplate("profesores.ftl");//puede que sea otra vista distinta tareasPorfesores.ftl por ejemplo
        }

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
