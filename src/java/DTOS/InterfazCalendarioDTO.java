
package DTOS;

import java.util.Vector;

public class InterfazCalendarioDTO {
    
    private int anioNumero;
    private Vector mesesAnio; 

    public int getAnioNumero() {
        return anioNumero;
    }

    public void setAnioNumero(int anioNumero) {
        this.anioNumero = anioNumero;
    }

    public Vector getMesesAnio() {
        return mesesAnio;
    }

    public void setMesesAnio(Vector mesesAnio) {
        this.mesesAnio = mesesAnio;
    }

}
