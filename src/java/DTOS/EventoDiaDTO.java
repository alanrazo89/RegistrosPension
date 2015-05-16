
package DTOS;

/**
 *
 * @author malangr
 */
public class EventoDiaDTO {
    
    private int id;
    private String titulo;
    private  String descripcion;
    private String fechaSQL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaSQL() {
        return fechaSQL;
    }

    public void setFechaSQL(String fechaSQL) {
        this.fechaSQL = fechaSQL;
    }

}
