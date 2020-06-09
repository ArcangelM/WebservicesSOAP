/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlets;

import com.udea.ws.Empleado;
import com.udea.ws.WSGestionUsuario_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author arcangelmarinp
 */
@WebServlet(name = "SAutenticacion", urlPatterns = {"/SAutenticacion"})
public class SAutenticacion extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/WSUsuario/WSGestionUsuario?WSDL")/*Poner la direccion directamente generade desde el tst webservice*/
    private WSGestionUsuario_Service service;

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
        
        String dni = request.getParameter("txtDni");
        String pass = request.getParameter("txtPass");
        String privilegio = request.getParameter("cboPrivilegio");
        System.out.println("este es el dni"+dni);
        Empleado empleado = validar(dni,pass,privilegio);
        
        if(empleado != null){
            HttpSession session = request.getSession();
            session.setAttribute("validUsuario", empleado);
            response.sendRedirect("ventanaUsuario.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
    }
    public SAutenticacion (){}
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

    private Empleado validar(java.lang.String dni, java.lang.String pass, java.lang.String privilegio) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.udea.ws.WSGestionUsuario port = service.getWSGestionUsuarioPort();
        return port.validar(dni, pass, privilegio);
    }

}
