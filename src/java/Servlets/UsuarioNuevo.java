
/*
 *  ESPECIALISTA : MAURICIO ALAN GONZALEZ RAZO 
 */
package Servlets;

import DAOS.UsuariosDAO;
import Herramientas.Herramientas;
import Herramientas.MailMotor;
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
@WebServlet(name = "UsuarioNuevo", urlPatterns = {"/UsuarioNuevo"})
public class UsuarioNuevo extends HttpServlet {

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

        // ---
        PrintWriter out = response.getWriter();

        String funcion = request.getParameter("funcion");

        HttpSession session = request.getSession();
        Herramientas herramientas = new Herramientas();

        if (funcion.equals("nuevoUsuario")) {
            this.nuevoUsuario(request, response, session);
        } else if (funcion.equals("recuperaDatosNuevoUsuario")) {
            this.recuperaDatosNuevoUsuario(request, response, session);
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
     * alan gonzalez muestra el formulario de registro de nuevo usuario
     *
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    public void nuevoUsuario(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        if (session.getAttribute("banderaErroresUsuarioRegistro") != null) {
            session.removeAttribute("banderaErroresUsuarioRegistro");
        }
        if (session.getAttribute("vErroresUsuarioRegistro") != null) {
            session.removeAttribute("vErroresUsuarioRegistro");
        }

        RequestDispatcher redireccion = request.getRequestDispatcher("./pensiones/registroCliente.jsp");
        try {
            redireccion.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(UsuarioNuevo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * RECUPERACION DATOS NUEVO USUARIO
     *
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    public void recuperaDatosNuevoUsuario(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        ClienteDTO clienteDTO = new ClienteDTO();
        Vector vErrores = new Vector();

        String nombreCliente = request.getParameter("nombreCliente");
        //String fechaRegistro = request.getParameter("fechaRegistro"); // fecha de registro se la asigna el sistema
        String localEmpresa = request.getParameter("localEmpresa");
        String telOfna = request.getParameter("telOfna");
        String emailCliente = request.getParameter("emailCliente");
        String telParticular = request.getParameter("telParticular");

        // asigno el tipo de cliente del sistema 
        clienteDTO.setTipoCliente(0); // el tipo cero es de uso comercial cualquier cliente

        if (nombreCliente.length() > 0 && nombreCliente != null) {
            clienteDTO.setNombreCliente(nombreCliente);
        } else {
            vErrores.add("Nombre del Cliente Es un Campo Obligatorio");
        }

        clienteDTO.setFechaRegistro("0000-00-00");

        if (localEmpresa.length() > 0 && localEmpresa != null) {
            clienteDTO.setLocalEmpresa(localEmpresa);
        } else {
            vErrores.add(" Local/Empresa Es un Campo Obligatorio");
        }

        if (telOfna.length() > 0 && telOfna != null) {
            clienteDTO.setTelOfna(telOfna);
        } else {
            vErrores.add(" Telefono Oficina Es un Campo Obligatorio si no cuenta con un numero ingrese 0");
        }

        // -- doble validacion de email
        if (emailCliente.length() > 0 && emailCliente != null) {
            Herramientas h = new Herramientas();
            if (h.validarMail(emailCliente) == true) {
                clienteDTO.setEmailCliente(emailCliente);
            } else {
                vErrores.add("Ingrese Un Mail Valido");
            }

        } else {
            vErrores.add("Email Es un Campo Obligatorio ");
        }

        if (telParticular.length() > 0 && telParticular != null) {
            clienteDTO.setTelOfna(telParticular);
        } else {
            vErrores.add(" Telefono Particular Es un Campo Obligatorio si no cuenta con un numero ingrese 0");
        }

        if (vErrores.size() > 0) {
            session.setAttribute("banderaErroresUsuarioRegistro", vErrores.size());
            session.setAttribute("vErroresUsuarioRegistro", vErrores);
            session.setAttribute("clienteDTOSession", clienteDTO);

            RequestDispatcher redireccion = request.getRequestDispatcher("./pensiones/registroCliente.jsp");
            try {
                redireccion.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(UsuarioNuevo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (vErrores.size() == 0) {

            // se valida si el email ya se encuentra registrado
            // se genera una cadena alfanumerica de 6 caracteres como password
            // se encripta en md5 y todos estos datos se envian al correo registrado
            Herramientas tools = new Herramientas();
            String passOriginal = tools.cadenaAlfanumericaAleatoria(4);
            String passEncriptada = tools.encriptaMD5(passOriginal);
            clienteDTO.setPassword(passEncriptada);
            UsuariosDAO usrDAO = new UsuariosDAO();
            usrDAO.registroNuevoCliente(clienteDTO);
            // envio del mail con datos

            MailMotor mailMotor = new MailMotor();
            String cuerpoMensaje = " Estimado Cliente, Gracias por Registrarse\n";
            cuerpoMensaje += " su nombre de usuario es: " + clienteDTO.getEmailCliente() + " y su password: " + passOriginal + "\n";
            cuerpoMensaje += " desde este momento ya podra realizar registro de la pensiones que requiera\n";
            cuerpoMensaje += " El Equipo de PARE estacionamientos\n";
            cuerpoMensaje += " Agrade Su preferenciaa\n";

            mailMotor.mailRegistroCliente(clienteDTO.getEmailCliente(), "BIENVENIDO PENSIONES PARE ESTACIONAMIENTOS", cuerpoMensaje);

            RequestDispatcher redireccion = request.getRequestDispatcher("./pensiones/registroCliente.jsp");

            try {
                redireccion.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(UsuarioNuevo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
