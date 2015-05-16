package DTOS;

/**
 * @author alangonzalez
 */
public class Nodo {

    private int id;
    private int idEsquema;
    private String tiuloNodo;
    private String descripcionNodo;
    private int estado;

    private int tipoNodo;
    private int idPertenece;
    private int orientacionNodo;

    public int getTipoNodo() {
        return tipoNodo;
    }

    public void setTipoNodo(int tipoNodo) {
        this.tipoNodo = tipoNodo;
    }

    public int getIdPertenece() {
        return idPertenece;
    }

    public void setIdPertenece(int idPertenece) {
        this.idPertenece = idPertenece;
    }

    public int getOrientacionNodo() {
        return orientacionNodo;
    }

    public void setOrientacionNodo(int orientacionNodo) {
        this.orientacionNodo = orientacionNodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEsquema() {
        return idEsquema;
    }

    public void setIdEsquema(int idEsquema) {
        this.idEsquema = idEsquema;
    }

    public String getTiuloNodo() {
        return tiuloNodo;
    }

    public void setTiuloNodo(String tiuloNodo) {
        this.tiuloNodo = tiuloNodo;
    }

    public String getDescripcionNodo() {
        return descripcionNodo;
    }

    public void setDescripcionNodo(String descripcionNodo) {
        this.descripcionNodo = descripcionNodo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
