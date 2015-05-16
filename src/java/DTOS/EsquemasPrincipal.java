package DTOS;

import java.util.Vector;

/**
 *
 * @author alangonzalez
 */
public class EsquemasPrincipal {

    private Vector esquemas;
    private EsquemasDTO esquemaDTO; // Titulo y Descripcion del Esquema en Vista Actual
    private String scriptEsquema;   // todo el codigo javascript del esquema ya procesado
    private int idEsquemaApuntador; // apuntador del esquema que se esta visualizando
    private int idNodoApuntador;

    public int getIdNodoApuntador() {
        return idNodoApuntador;
    }

    public void setIdNodoApuntador(int idNodoApuntador) {
        this.idNodoApuntador = idNodoApuntador;
    }
    
    public int getIdEsquemaApuntador() {
        return idEsquemaApuntador;
    }

    public void setIdEsquemaApuntador(int idEsquemaApuntador) {
        this.idEsquemaApuntador = idEsquemaApuntador;
    }

    public String getScriptEsquema() {
        return scriptEsquema;
    }

    public void setScriptEsquema(String scriptEsquema) {
        this.scriptEsquema = scriptEsquema;
    }

    public EsquemasDTO getEsquemaDTO() {
        return esquemaDTO;
    }

    public void setEsquemaDTO(EsquemasDTO esquemaDTO) {
        this.esquemaDTO = esquemaDTO;
    }

    public Vector getEsquemas() {
        return esquemas;
    }

    public void setEsquemas(Vector esquemas) {
        this.esquemas = esquemas;
    }

}
