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
import model.Alumno;
import model.Profesor;
import model.User;
import servicios.AsignaturasServicios;
import servicios.CambioPasswordServicio;

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
        CambioPasswordServicio cps = new CambioPasswordServicio();
        HashMap root = new HashMap();
        if (request.getParameter("accion") != null) {
            accion = request.getParameter("accion");

            switch (accion) {
                case "addUser":
                    User usuario = us.recogidaParametros(request.getParameter("nombreUser"), request.getParameter("passUser"), request.getParameter("emailUser"));

                    
                        insertadas = us.addUsuario(usuario);
                    

                    if (!insertadas) {
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.ERROR_REGISTRO);
                    } else {
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.REGISTRO_CORRECTO_ADMINISTRADOR);
                    }

                    try {
                        Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.NUEVO_USER_REGISTRADO);
                        temp.process(root, response.getWriter());
                    } catch (TemplateException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "addProfesor":
                    Profesor profesor = us.recogidaProfesor(request.getParameter("nombreProfesor"));
                    User usuarioProfe = us.mailProfesor(request.getParameter("nombreProfesor"), request.getParameter("passUser"));
                    User usuarioProfesor = us.recogidaParametros(request.getParameter("nombreUser"), request.getParameter("passUser"), request.getParameter("emailUser"));

                        insertadas = us.addProfesor(usuarioProfesor, profesor, usuarioProfe);
                    

                    if (!insertadas) {
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.MENSAJE_PROFESOR_CREADO_MAL);

                    } else {
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.MENSAJE_PROFESOR_CREADO_BIEN);
                    }

                    try {
                        Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.PAGINA_INSERTADO_OK);
                        temp.process(root, response.getWriter());
                    } catch (TemplateException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case "login":
                    String correoLogin = request.getParameter("correoLogin");
                    String passLogin = request.getParameter("passLogin");
                    User user = new User();
                    user.setEmail(correoLogin);
                    user.setPassword(passLogin);

                    boolean error = false;
                    if (us.login(user)) {
                        User userLogeado = us.cogerPermiso(correoLogin);
                        request.getSession().setAttribute("nombreUsuario", userLogeado.getUser());
                        request.getSession().setAttribute("idUser", userLogeado.getId());
                        request.getSession().setAttribute("permisoUser", userLogeado.getId_permiso());
                        request.getSession().setAttribute("login", "login");
                        
                        
                        if(userLogeado.getId_permiso()== 4){
                            request.getRequestDispatcher("superadministrador").forward(request, response);
                        } else if(userLogeado.getId_permiso()== 3){
                            request.getRequestDispatcher("alumnos").forward(request, response);
                        } else if(userLogeado.getId_permiso()== 2){
                            request.getRequestDispatcher("profesores").forward(request, response);
                        } else if(userLogeado.getId_permiso()== 1){
                            request.getRequestDispatcher("administrador").forward(request, response);
                        } else if(userLogeado.getId_permiso()== 6){
                            request.getRequestDispatcher("invitado").forward(request, response);
                        }
                        
                    } else {
                        request.setAttribute(Constantes.VARIABLE_MENSAJE, Constantes.MENSAJE_LOGIN_FAIL);
                        request.getRequestDispatcher("login").forward(request, response);
                    }
                    break;

                case "logout": {
                    request.getSession().invalidate(); break;
                }
                case "addAlumno":
                    Alumno alumno = us.recogidaAlumno(request.getParameter("nombreAlumno"));
                    User usuarioAlum = us.mailProfesor(request.getParameter("nombreAlumno"), request.getParameter("passUser"));
                    User usuarioAlumno = us.recogidaParametros(request.getParameter("nombreUser"), request.getParameter("passUser"), request.getParameter("emailUser"));
                    insertadas = us.addAlumno(usuarioAlumno, alumno, usuarioAlum);
                    if (!insertadas) {
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.MENSAJE_ALUMNO_CREADO_MAL);
                    } else {
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.MENSAJE_ALUMNO_CREADO_BIEN);
                    }

                    try {
                        Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.PAGINA_INSERTADO_OK);
                        temp.process(root, response.getWriter());
                    } catch (TemplateException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "DesactivarAdmin":
                    if (us.desactivarPermisoAdmin(request.getParameter("id"))) {
                        request.setAttribute(Constantes.VARIABLE_MENSAJE, Constantes.ADMIN_CAMBIADO_OK);
                        break;
                    } else {
                        request.setAttribute(Constantes.VARIABLE_MENSAJE, Constantes.ADMIN_CAMBIADO_ERROR);
                        break;
                    }
                case "ActivarAdmin":
                    if (us.activaPermisoConSuper(request.getParameter("id"))) {
                        request.setAttribute(Constantes.VARIABLE_MENSAJE, Constantes.ADMIN_CAMBIADO_OK);
                        break;
                    } else {
                        request.setAttribute(Constantes.VARIABLE_MENSAJE, Constantes.ADMIN_CAMBIADO_ERROR);
                        break;
                    }
                case "validarUsuario":
                    String codigo = request.getParameter("codigo");
                    int valido = us.activar(codigo);
                    switch (valido) {
                        case 0:
                            root.put(Constantes.VARIABLE_MENSAJE, Constantes.ERROR_TIEMPO);
                            root.put(Constantes.VARIABLE_MENSAJE2, Constantes.ERROR_TIEMPO_2);
                            break;
                        case 1:
                            root.put(Constantes.VARIABLE_MENSAJE, Constantes.CUENTA_ACTIVADA);
                            root.put(Constantes.VARIABLE_MENSAJE2, Constantes.CUENTA_ACTIVADA_2);
                            break;
                        case 2:
                            root.put(Constantes.VARIABLE_MENSAJE, Constantes.YA_ACTIVADA);
                            root.put(Constantes.VARIABLE_MENSAJE2, Constantes.CUENTA_ACTIVADA_2);
                            break;
                        case -1:
                            root.put(Constantes.VARIABLE_MENSAJE, Constantes.ERROR_ACTIVAR);
                            root.put(Constantes.VARIABLE_MENSAJE2, Constantes.ERROR_ACTIVAR_2);
                            break;
                    }
                    try {
                        Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.ACTIVADO_PANTALLA);
                        temp.process(root, response.getWriter());
                    } catch (TemplateException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "activacionManual":
                    boolean actualizada = us.activarUserManualmente(request.getParameter("id"));
                    if (actualizada) {
                        root.put("activado", 1);
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.MENSAJE_USUARIO_ACTIVADO);
                        root.put("numUsers", 0);
                    } else {
                        root.put("activado", 0);
                        root.put(Constantes.VARIABLE_MENSAJE, Constantes.MENSAJE_USUARIO_NO_ACTIVADO);
                        root.put("numUsers", 0);
                    }
                    try {
                        int numeroUsers = 0;
                        root.put("usuarios", us.getAllUsers(numeroUsers));
                        Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.PANTALLASUPERADMIN);
                        temp.process(root, response.getWriter());
                    } catch (TemplateException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

            }
        } else {
            try {
                root.put("contenido", "1");
                Template temp = Configuration.getInstance().getFreeMarker().getTemplate(Constantes.REGISTRO_PANTALLA);
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
