/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DTOS.ConfigLoginDTO;
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
public class ConfiguracionSistemaDAO {

    EnlaceDB enlace;
    CargadorDatos cargador;

    public ConfiguracionSistemaDAO() {
        enlace = new EnlaceDB();
        cargador = new CargadorDatos();
    }

    /**
     * CARGA LA CONFIGURACION DE LA PANTALLA DE INICIO
     *
     * @return
     */
    public ConfigLoginDTO configuracionLogin() {

        ConfigLoginDTO config = new ConfigLoginDTO();
        try {

            String sql = "SELECT * FROM configuraciones_sistema where configuraciones_sistema.id =1;";

            enlace.openDatabase();
            ResultSet rst = enlace.executeQuery(sql);

            if (rst.next()) {
                config = cargador.configLoginDTO(rst);
            } else {
                config = null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionSistemaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        enlace.closeDatabase();
        return config;
    }

}
