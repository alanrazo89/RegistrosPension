// clase pare

package DAOS;

import Herramientas.CargadorDatos;
import Herramientas.EnlaceDB;
import PensionesDTO.ClienteDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosDAO {

    private EnlaceDB enlace;
    private CargadorDatos cargador;

    public UsuariosDAO() {
        enlace = new EnlaceDB();
        cargador = new CargadorDatos();
    }

    /**
     * alan gonzalez registro de nuevo cliente
     *
     * @param c
     */
    public void registroNuevoCliente(ClienteDTO c) {
        String sql = "";
        sql += "  insert into cliente set";
        sql += "   cliente.nombre_cliente = '" + c.getNombreCliente() + "'";
        sql += " , cliente.fecha = current_date()";
        sql += " , cliente.local_empresa = '" + c.getLocalEmpresa() + "'";
        sql += " , cliente.tel_oficina = '" + c.getTelOfna() + "'";
        sql += " , cliente.email = '" + c.getEmailCliente() + "'";
        sql += " , cliente.tel_particular = '" + c.getTelParticular() + "'";
        sql += " , cliente.tipo_cliente =" + c.getTipoCliente();
        sql += " , cliente.password ='" + c.getPassword()+"'";
        enlace.openDatabase();
        enlace.execute(sql);
        enlace.closeDatabase();
    }
    
    
    /**
     * ALAN GONZALEZ DEVUELVE UN CLIENTE REGISTRADO  POR EMAIL
     * @param email
     * @param pass
     * @return 
     */
    public ClienteDTO clienteDTO(String email, String pass) {
        
        String sql ="SELECT * FROM cliente WHERE cliente.email = '"+email+"' AND cliente.password ='"+pass+"';";
        enlace.openDatabase();
        
        ResultSet rst = enlace.executeQuery(sql);
        ClienteDTO cliente = new ClienteDTO();
        try {
            if(rst.next()){
                cliente = cargador.clienteDTO(rst);
            }else{
                cliente = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        enlace.closeDatabase();
        
        return cliente;

    }

 

}
