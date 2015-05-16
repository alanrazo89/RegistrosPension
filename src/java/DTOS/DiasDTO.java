
package DTOS;

/**
 *
 * @author alangonzalez
 */
public class DiasDTO {
    
    private int dia; // numeroDia
    private String fechaSQL;
    private String fechaEspanol;
    

    public String getFechaEspanol() {
        return fechaEspanol;
    }

    public void setFechaEspanol(String fechaEspanol) {
        this.fechaEspanol = fechaEspanol;
    }
    
    public String getFechaSQL() {
        return fechaSQL;
    }

    public void setFechaSQL(String fechaSQL) {
        this.fechaSQL = fechaSQL;
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
}
