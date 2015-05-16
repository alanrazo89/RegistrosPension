package DAOS;

import DTOS.EsquemasDTO;
import DTOS.Nodo;
import Herramientas.CargadorDatos;
import Herramientas.EnlaceDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alangonzalez
 */
public class EsquemasDAO {

    EnlaceDB enlace;
    CargadorDatos cargador;

    public EsquemasDAO() {
        enlace = new EnlaceDB();
        cargador = new CargadorDatos();
    }

    /**
     * ALAN GONZALEZ TODOS LOS ESQUEMAS ACTIVOS
     *
     * @return
     */
    public Vector todoEsquemaActivo() {
        Vector vEsquemas = new Vector();
        String sql = "SELECT * FROM `esquemas` WHERE `esquemas`.`estado` > 0";
        enlace.openDatabase();
        ResultSet rst = enlace.executeQuery(sql);
        try {
            while (rst.next()) {
                EsquemasDTO esquemasDTO = cargador.esquemasDTO(rst);
                vEsquemas.add(esquemasDTO);
            }
        } catch (SQLException ex) {
            System.out.println("ALAN ERROR AQUI " + ex);
            Logger.getLogger(EsquemasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(EsquemasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        enlace.closeDatabase();
        return vEsquemas;
    }

    /**
     * ALAN GONZALEZ REGISTRO DE NUEVO ESQUEMA
     *
     * @param titulo
     * @param descripcion
     */
    public void nuevoEsquema(String titulo, String descripcion) {
        String sql = "INSERT INTO  `esquemas` SET esquemas.`titulo` = '" + titulo + "', esquemas.`descripcion` ='" + descripcion + "'; ";
        enlace.openDatabase();
        enlace.execute(sql);
        enlace.closeDatabase();
    }

    /**
     * ALAN GONZALEZ ESQUEMAS DTO
     *
     * @param id
     * @return
     */
    public EsquemasDTO esquemaXID(int id) {
        String sql = " SELECT * FROM `esquemas` WHERE esquemas.`id` = " + id + " AND esquemas.`estado` > 0";
        EsquemasDTO esquemaDTO = new EsquemasDTO();
        enlace.openDatabase();
        ResultSet rst = enlace.executeQuery(sql);

        try {
            if (rst.next()) {
                esquemaDTO = cargador.esquemasDTO(rst);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EsquemasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(EsquemasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        enlace.closeDatabase();
        return esquemaDTO;
    }

    /**
     * ALAN GONZALEZ NUMERO DE NODOS DE UN ESQUEMA DETERMINADO
     *
     * @param idEsquema
     * @return
     */
    public int numeroNodosEsquema(int idEsquema) {
        int nNodosEsquema = 0;
        String sql = "SELECT count(*) AS totoalNodos FROM `nodos_esquema`  WHERE "
                + "`nodos_esquema`.`id_esquema` = " + idEsquema + " AND `nodos_esquema`.`estado` > 0 ";

        enlace.openDatabase();
        ResultSet rst = enlace.executeQuery(sql);

        try {
            if (rst.next()) {
                nNodosEsquema = rst.getInt("totoalNodos");
            } else {
                nNodosEsquema = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EsquemasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(EsquemasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        enlace.closeDatabase();
        return nNodosEsquema;
    }

    /**
     * ALAN G ALAN GONZALEZ ESTE NODO DEFAULT SE GENERA AL MOMENTO DE ACCEDE A
     * LA VISTA DE UN ESQUEMA Y ESTE NO TIENE PREVIAMENTE REGISTRADO AL MENOS UN
     * NODO
     *
     * @param idEsquema
     */
    public void registroNodoDefault(int idEsquema) {
        String sql = "INSERT INTO `nodos_esquema` SET `id_esquema` =" + idEsquema
                + " , `titulo` = 'default', "
                + "`tipo_nodo` = '1', "
                + "`descripcion` = 'descripcion',`estado` = 1;";

        enlace.openDatabase();
        enlace.execute(sql);
        enlace.closeDatabase();
    }

    /**
     * ALAN GONZALEZ METODO PRINCIPAL QUE ENSAMBLA TODAS A LAS PARTES DE UN
     * ORGANIGRAMA SIMPLE
     *
     * @param idEsquema
     * @return
     */
    public String ensambaldorEsquema(int idEsquema) {
        String enter = "\n";

        String script = "";

        script += "//<![CDATA[" + enter;
        script += "$(window).load(function() {" + enter;
        script += "var options = new primitives.orgdiagram.Config();" + enter;
        script += "var items = [" + enter;

        Vector nodos = this.nodos(idEsquema);
        for (int i = 0; i < nodos.size(); i++) {
            script += this.ensambladorNodo((Nodo) nodos.elementAt(i));
        }

        script += "];" + enter;
        script += "var buttons = [];" + enter;
        script += "buttons.push(new primitives.orgdiagram.ButtonConfig(\"add\", \"ui-icon-person\", \"Agregar\"));" + enter;
        script += "buttons.push(new primitives.orgdiagram.ButtonConfig(\"edit\", \"ui-icon-gear\", \"Editar\"));" + enter;
        script += "buttons.push(new primitives.orgdiagram.ButtonConfig(\"del\", \"ui-icon-close\", \"Borrar\"));" + enter;

        script += "options.items = items;" + enter;
        script += "options.cursorItem = 0;" + enter;
        script += "options.buttons = buttons;" + enter;
        script += "options.hasButtons = primitives.common.Enabled.True;" + enter;
        script += "options.hasSelectorCheckbox = primitives.common.Enabled.False;" + enter;
        script += "options.onButtonClick = function(e, data) {" + enter;

        script += "if (data.name == 'add') {" + enter;

        script += "var myWindow = window.open(\"./Demo?funcion=nuevoNodo&idNodo=\"+data.context.id , \"alan\", \"width=500, height=500\");";

        //script +="var message = \"agregar desde '\" + data.context.title + \"'.\";" + enter;
        //script +="alert(message);" + enter;
        script += "}" + enter;

        script += "if (data.name == 'edit') {" + enter;
        // script +="var message = " editar ";" + enter;
        script += "alert(message);" + enter;
        script += "}" + enter;

        script += "if (data.name == 'del') {" + enter;
        //script +="alert("message");" + enter;
        script += "}" + enter;

        script += "};" + enter;
        script += "jQuery(\"#basicdiagram\").orgDiagram(options);" + enter;
        script += "});//]]>  " + enter;

        //System.out.println(script);
        return script;
    }

    /**
     * VECTOR DE NODOS DE UN ESQUEMA objetos dto
     *
     * @param idEsquema
     * @return
     */
    public Vector nodos(int idEsquema) {
        Vector vNodo = new Vector();
        String sql = "SELECT * FROM `nodos_esquema`  WHERE `nodos_esquema`.`id_esquema` = "
                + idEsquema + " AND `nodos_esquema`.`estado` > 0";

        enlace.openDatabase();
        ResultSet rst = enlace.executeQuery(sql);

        try {
            while (rst.next()) {
                Nodo nodo = cargador.nodoDTO(rst);
                vNodo.add(nodo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EsquemasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(EsquemasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        enlace.closeDatabase();
        return vNodo;
    }

    /**
     * ALAN GONZALEZ NODOS
     *
     * @param nodos
     * @return
     */
    public String ensambladorNodo(Nodo nodo) {

        String nodosScript = "";
        String prefijoEnter = "\n";

        nodosScript += " new primitives.orgdiagram.ItemConfig({" + prefijoEnter;
        nodosScript += "  id: " + nodo.getId() + "," + prefijoEnter;

        if (nodo.getTipoNodo() == 1) {
            nodosScript += "  parent: null," + prefijoEnter;
        } else {
            nodosScript += "  parent: " + nodo.getIdPertenece() + "," + prefijoEnter;
        }

        nodosScript += "  title: \"" + nodo.getTiuloNodo() + "\"," + prefijoEnter;
        nodosScript += "  description: \"" + nodo.getDescripcionNodo() + "\"," + prefijoEnter;
        nodosScript += "  image: \"bp/images/photos/a.png\"" + prefijoEnter;
        nodosScript += "  })," + prefijoEnter;

        return nodosScript;
    }

    /**
     * ALAN GONZALEZ REGISTRO DE UN NODO
     *
     * @param idEsquema
     * @param titulo
     * @param descripcion
     */
    public void registroNodo(
            int idEsquema,
            int idNodo,
            String titulo,
            String descripcion) {
        String sql = "INSERT INTO `nodos_esquema` SET `"
                + "id_esquema` =" + idEsquema + ","
                + "id_pertenece =" + idNodo + ","
                + "`titulo` = '" + titulo + "', "
                + "`descripcion` = '" + descripcion + "',"
                + "`estado` = 1;";

       
        enlace.openDatabase();
        enlace.execute(sql);
        enlace.closeDatabase();
    }
    
    
    /**
     * ALAN GONZALEZ BORRAR NODO DE MANERA LOGICA 
     * @param idNodo 
     */
    public void borrarNodo(int idNodo){
        String sql = " UPDATE `esquemas` SET esquemas.`estado` = 0 WHERE esquemas.`id` = " + idNodo;
        enlace.openDatabase();
        enlace.execute(sql);
        enlace.closeDatabase();
    }
    
}
