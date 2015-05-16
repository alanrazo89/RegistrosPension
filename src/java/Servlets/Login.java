/*
 Servlet de Evaluacion de Usuario
 */
package Servlets;

import DAOS.EsquemasDAO;
import DAOS.UsuarioDAO;
import DAOS.UsuariosDAO;
import DTOS.EsquemasPrincipal;
import DTOS.UsuarioDTO;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String funcion = request.getParameter("funcion");
        HttpSession session = request.getSession();
        Herramientas herramientas = new Herramientas();

        if (funcion.equals("usuario")) {
            this.usuarioLogin(request, response, session);
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
     * ALAN GONZALEZ MUESTRA LA LISTA DE ESQUEMAS ORGANIZACINALES
     *
     * @param request
     * @param response
     * @param session
     */
    public void usuarioLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        String usuario, contrasena;
        usuario = request.getParameter("usr");
        contrasena = request.getParameter("pass");

        Herramientas herramientas = new Herramientas();

        contrasena = herramientas.encriptaMD5(contrasena);

        ClienteDTO clDTO = new ClienteDTO();
        UsuariosDAO usrsDAO = new UsuariosDAO();
        clDTO = usrsDAO.clienteDTO(usuario, contrasena);

        if (clDTO != null) {

            session.setAttribute("usr", clDTO);

            if (session.getAttribute("error") != null) {
                session.removeAttribute("error");
            }
            RequestDispatcher redireccion = null;

            // CONTROL DE REDIRECCION AL USUARIO POR TIPO
            if (clDTO.getTipoCliente() == 0) {
                redireccion = request.getRequestDispatcher("./RegistrosPension?funcion=pensionesDashBoard");
            }

            try {
                redireccion.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            RequestDispatcher redireccion = request.getRequestDispatcher("./index.jsp");
            try {
                redireccion.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
