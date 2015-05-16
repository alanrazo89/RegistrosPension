

package DTOS;


public class UsuarioDTO {
    
    private String nombres;
    private String apellidos;
    private String usr;
    private String passMD5;
    private String moduloInicio;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPassMD5() {
        return passMD5;
    }

    public void setPassMD5(String passMD5) {
        this.passMD5 = passMD5;
    }

    public String getModuloInicio() {
        return moduloInicio;
    }

    public void setModuloInicio(String moduloInicio) {
        this.moduloInicio = moduloInicio;
    }
    
    

}