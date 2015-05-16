package DAOS;

import Herramientas.CargadorDatos;
import Herramientas.EnlaceDB;
import PensionesDTO.ClienteDTO;
import PensionesDTO.PensionRegistroDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author malangr
 */
public class PensionesDAO {

    EnlaceDB enlace;
    CargadorDatos cargador;

    public PensionesDAO() {

        enlace = new EnlaceDB();
        cargador = new CargadorDatos();
    }

    /**
     * ALAN GONZALEZ PENSIONES X CLIENTE
     *
     * @param clienteDTO
     * @return
     */
    public Vector pensionesXCliente(ClienteDTO clienteDTO) {
        Vector vPensiones = new Vector();
        String sql = "select * from general_pensiones where general_pensiones.id_cliente = " + clienteDTO.getIdRegistro();
        enlace.openDatabase();
        ResultSet rst = enlace.executeQuery(sql);
        try {
            while (rst.next()) {
                PensionRegistroDTO p = new PensionRegistroDTO();
                p = cargador.pensionRegistroDTO(rst, clienteDTO);
                vPensiones.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PensionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(PensionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        enlace.closeDatabase();
        return vPensiones;
    }
    
    

}
