/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAOS.PensionesDAO;
import Herramientas.Herramientas;
import PensionesDTO.ClienteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author malangr
 */
@WebServlet(name = "RegistrosPension", urlPatterns = {"/RegistrosPension"})
public class RegistrosPension extends HttpServlet {

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

        PrintWriter out = response.getWriter();

        String funcion = request.getParameter("funcion");

        HttpSession session = request.getSession();
        Herramientas herramientas = new Herramientas();

        if (funcion.equals("registroPension")) {
            this.registroPension(request, response, session);
        } else if (funcion.equals("pensionesDashBoard")) {
            this.pensionesDashBoard(request, response, session);
        } else {
            String salidsa = " ERROR : FUNCION NO IMPLEMENTADA FAVOR DE REPORTAR AL ADMIN/DESARROLLADOR";
            out.print(out);
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

    /**
     * alan gonzalez funcion servlet que muestra la interfaz de captura para una
     * nueva pension
     *
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    public void registroPension(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        RequestDispatcher redireccion = request.getRequestDispatcher("./pensiones/capturaPension.jsp");
        try {
            redireccion.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(RegistrosPension.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**
     * ALAN GONZALEZ  CARGA EL PANEL DE CONTROL PRINCIPAL DEL CLIENTE 
     * @param request
     * @param response
     * @param session
     * @throws IOException 
     */
    public void pensionesDashBoard
        (HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        
        ClienteDTO cliente = (ClienteDTO) session.getAttribute("usr");
        PensionesDAO pensiones = new PensionesDAO();
        Vector vPensiones = pensiones.pensionesXCliente(cliente);
        
        session.setAttribute("vPensionesCliente", vPensiones);
        
        RequestDispatcher redireccion = request.getRequestDispatcher("./pensiones/pensionesCliente.jsp");
        try {
            redireccion.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(RegistrosPension.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
