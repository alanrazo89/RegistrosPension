package PensionesDTO;

public class ClienteDTO {

    private int idRegistro = 0;
    
    private int tipoCliente = 0;
    private String nombreCliente = "";
    private String fechaRegistro = ""; // esta se genera por nueva pension
    private String localEmpresa = "";
    private String telOfna = "";
    private String emailCliente = "";
    private String telParticular = "";
    
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
   
    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getLocalEmpresa() {
        return localEmpresa;
    }

    public void setLocalEmpresa(String localEmpresa) {
        this.localEmpresa = localEmpresa;
    }

    public String getTelOfna() {
        return telOfna;
    }

    public void setTelOfna(String telOfna) {
        this.telOfna = telOfna;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelParticular() {
        return telParticular;
    }

    public void setTelParticular(String telParticular) {
        this.telParticular = telParticular;
    }

}
