
package DTOS;

import java.util.Vector;

/**
 *
 * @author alangonzalez
 */
public class MesDTO {
    private String nombreMes;
    private int numeroMes;
    private Vector dias; //  Dias DTOs
    private int  numeroDiaInicio; // domingo = 0  \\  lunes = 1 \\  martes = 2 \\  miercoles = 3   \\  jueves = 4  \\  viernes = 5 \\ sabado = 6

    public int getNumeroDiaInicio() {
        return numeroDiaInicio;
    }

    public void setNumeroDiaInicio(int numeroDiaInicio) {
        this.numeroDiaInicio = numeroDiaInicio;
    }
    
    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public int getNumeroMes() {
        return numeroMes;
    }

    public void setNumeroMes(int numeroMes) {
        this.numeroMes = numeroMes;
    }

    public Vector getDias() {
        return dias;
    }

    public void setDias(Vector dias) {
        this.dias = dias;
    }

}

