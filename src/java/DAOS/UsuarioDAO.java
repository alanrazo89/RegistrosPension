package DAOS;

import DTOS.UsuarioDTO;
import Herramientas.CargadorDatos;
import Herramientas.EnlaceDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author malangr
 */
public class UsuarioDAO {

    EnlaceDB enlace;
    CargadorDatos cargador;

    public UsuarioDAO() {
        enlace = new EnlaceDB();
        cargador = new CargadorDatos();
    }

    /**
     * alan gonzalez verificador de usuarios
     * si existe lo devuelve con sus datos
     *
     * @param usr
     * @param passMD5
     * @return
     */
    public UsuarioDTO usuario(String usr, String passMD5) {

        
        UsuarioDTO usrDTO = new UsuarioDTO();
        //int bandera = 0;

        String sql = "";

        
        sql+=" SELECT * FROM usuarios WHERE ";
        sql+=" usuarios.nombre_usuario = '"+usr+"' ";
        sql+=" AND ";
        sql+=" usuarios.contrasena_usuario = '"+passMD5+"';";
        
        
        enlace.openDatabase();
        ResultSet rst = enlace.executeQuery(sql);
        
        
        try {
            if(rst.next()){
                usrDTO = cargador.usuarioDTO(rst);
            }else{
             usrDTO = null;
            }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usrDTO;
    }

}
