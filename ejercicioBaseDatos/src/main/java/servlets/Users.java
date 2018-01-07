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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Asignatura;
import model.User;
import servicios.AsignaturasServicios;

import servicios.UsersServicios;
import utils.Constantes;

/**
 *
 * @author Miguel Angel Diaz
 */
@WebServlet(name = "Users", urlPatterns = {"/users"})
public class Users extends HttpServlet {

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
        String accion = "";
        boolean insertadas = false;
        UsersServicios us = new UsersServicios();
        AsignaturasServicios as = new AsignaturasServicios();
        HashMap root = new HashMap();
        if (request.getParameter("accion") != null) {
            accion = request.getParameter("accion");

            switch (accion) {
                case "addUser":
                    User usuario = us.recogidaParametros(request.getParameter("nombreUser"), request.getParameter("passUser"), request.getParameter("emailUser"));
                    insertadas = us.addUsuario(usuario);
                    if (!insertadas) {
                        try {
                            root.put("insertado", 0);
                            root.put("mensaje", Constantes.ERROR_REGISTRO);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            root.put("insertado", 1);
                            root.put("mensaje", Constantes.REGISTRO_CORRECTO_ADMINISTRADOR);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "addProfesor":
                    User usuarioProfe = us.mailProfesor(request.getParameter("nombreProfesor"), request.getParameter("passUser"));
                    User usuarioProfesor = us.recogidaParametros(request.getParameter("nombreUser"), request.getParameter("passUser"), request.getParameter("emailUser"));
                    insertadas = us.addProfesor(usuarioProfesor, usuarioProfe);
                    if (!insertadas) {
                        try {
                            root.put("insertado", 0);
                            root.put("mensaje", Constantes.MENSAJE_PROFESOR_CREADO_MAL);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            root.put("insertado", 1);
                            root.put("mensaje", Constantes.MENSAJE_PROFESOR_CREADO_BIEN);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "login":
                    String nombreLogin = request.getParameter("nombreLogin");
                    String passLogin = request.getParameter("passLogin");
                    User u = new User();
                    u.setUser(nombreLogin);
                    u.setPassword(passLogin);

                    boolean error = false;
                    if (us.login(u)) {
                        request.getSession().setAttribute("nombreUsuario", nombreLogin);
                    } else {
                        request.setAttribute("errorLogin", Constantes.ERROR_LOGIN);
                    }
                    break;

                case "logout": {
                    request.getSession().invalidate();
                }
                case "addAlumno":
                    User usuarioAlum = us.mailProfesor(request.getParameter("nombreProfesor"), request.getParameter("passUser"));
                    User usuarioAlumno = us.recogidaParametros(request.getParameter("nombreUser"), request.getParameter("passUser"), request.getParameter("emailUser"));
                    insertadas = us.addProfesor(usuarioAlumno, usuarioAlum);
                    if (!insertadas) {
                        try {
                            root.put("insertado", 0);
                            root.put("mensaje", Constantes.MENSAJE_ALUMNO_CREADO_MAL);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            root.put("insertado", 1);
                            root.put("mensaje", Constantes.MENSAJE_ALUMNO_CREADO_BIEN);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                
                case "DesactivarAdmin":
                    if (us.activaPermisoConSuper(request.getParameter("id"))) {
                        request.setAttribute("mensaje", Constantes.ADMIN_CAMBIADO_OK);
                    } else {
                        request.setAttribute("mensaje", Constantes.ADMIN_CAMBIADO_ERROR);
                    }
                case "activarConSuper":
                    if (us.activaPermisoConSuper(request.getParameter("id"))) {
                        request.setAttribute("mensaje", Constantes.ADMIN_CAMBIADO_OK);
                    } else {
                        request.setAttribute("mensaje", Constantes.ADMIN_CAMBIADO_ERROR);
                    }
                case "validarUsuario":
                    String codigo = request.getParameter("codigo");
                    int valido = us.activar(codigo);
                    switch (valido) {
                        case 0:
                            request.setAttribute("mensaje", Constantes.ERROR_TIEMPO);
                            request.setAttribute("mensaje2", Constantes.ERROR_TIEMPO_2);
                            break;
                        case 1:
                            request.setAttribute("mensaje", Constantes.CUENTA_ACTIVADA);
                            request.setAttribute("mensaje2", Constantes.CUENTA_ACTIVADA_2);
                            break;
                        case 2:
                            request.setAttribute("mensaje", Constantes.YA_ACTIVADA);
                            request.setAttribute("mensaje2", Constantes.CUENTA_ACTIVADA_2);
                            break;
                        case -1:
                            request.setAttribute("mensaje", Constantes.ERROR_ACTIVAR);
                            request.setAttribute("mensaje2", Constantes.ERROR_ACTIVAR_2);
                            break;
                    }
                    break;
                case "activacionManual":
                    boolean actualizada = us.activarUserManualmente(request.getParameter("id")); 
                    if (actualizada){
                        try {
                            root.put("insertado", 1);
                            root.put("mensaje", Constantes.MENSAJE_USUARIO_ACTIVADO);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            root.put("insertado", 0);
                            root.put("mensaje", Constantes.MENSAJE_USUARIO_NO_ACTIVADO);
                            Template temp = Configuration.getInstance().getFreeMarker().getTemplate("insertado.ftl");
                            temp.process(root, response.getWriter());
                        } catch (TemplateException ex) {
                            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
            }
        } else {
            try {
                root.put("contenido", "1");
                Template temp = Configuration.getInstance().getFreeMarker().getTemplate("registro.ftl");
                temp.process(root, response.getWriter());
            } catch (TemplateException ex) {
                Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
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
