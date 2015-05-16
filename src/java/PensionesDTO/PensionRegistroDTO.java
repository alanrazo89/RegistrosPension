
package PensionesDTO;

/**
 *
 * @author malangr Pension Registrada
 */
public class PensionRegistroDTO {

    private int idRegistro = 0;
    
    private ClienteDTO cliente = new ClienteDTO(); 
    

    private int idCliente = 0;
    private int tipoPension = 0;
    private int requiereFactura = 0;

    private String nombreFacturacion = "";
    private String rfcFacturacion = "";
    private String razonSocialFacturacion = "";
    private String coloniaFacturacion = "";
    private String calleFacturacion = "";
    private String numeroInteriorExteriorFacturacion = "";
    private String delegacionFacturacion = "";
    private String cpFacturacion = "";
    private String entidadFacturacion = "";
    private String emailFacturacion = "";

    private String autoUnoMarca = "";
    private String autoUnoModelo = "";
    private String autoUnoColor = "";
    private String autoUnoPlacas = "";

    private String autoDosMarca = "";
    private String autoDosModelo = "";
    private String autoDosColor = "";
    private String autoDosPlacas = "";

    private String estacionamiento = "";
    private String nClienteAsigando = "";
    private String nombreEncargado = "";
    private String fechaInternaSistema = "";
    private String puesto = "";
    private String nTajetaTarjeton = "";
    private int tipoPensionAsignado = 0;
    private double importe = 0.0;
    private String fechaSistemaAlta = "";
    private String fechaSistemaBaja = "";
    private String obsrevaciones = "";

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

   

    public int getTipoPension() {
        return tipoPension;
    }

    public void setTipoPension(int tipoPension) {
        this.tipoPension = tipoPension;
    }

    public int getRequiereFactura() {
        return requiereFactura;
    }

    public void setRequiereFactura(int requiereFactura) {
        this.requiereFactura = requiereFactura;
    }

    public String getNombreFacturacion() {
        return nombreFacturacion;
    }

    public void setNombreFacturacion(String nombreFacturacion) {
        this.nombreFacturacion = nombreFacturacion;
    }

    public String getRfcFacturacion() {
        return rfcFacturacion;
    }

    public void setRfcFacturacion(String rfcFacturacion) {
        this.rfcFacturacion = rfcFacturacion;
    }

    public String getRazonSocialFacturacion() {
        return razonSocialFacturacion;
    }

    public void setRazonSocialFacturacion(String razonSocialFacturacion) {
        this.razonSocialFacturacion = razonSocialFacturacion;
    }

    public String getColoniaFacturacion() {
        return coloniaFacturacion;
    }

    public void setColoniaFacturacion(String coloniaFacturacion) {
        this.coloniaFacturacion = coloniaFacturacion;
    }

    public String getCalleFacturacion() {
        return calleFacturacion;
    }

    public void setCalleFacturacion(String calleFacturacion) {
        this.calleFacturacion = calleFacturacion;
    }

    public String getNumeroInteriorExteriorFacturacion() {
        return numeroInteriorExteriorFacturacion;
    }

    public void setNumeroInteriorExteriorFacturacion(String numeroInteriorExteriorFacturacion) {
        this.numeroInteriorExteriorFacturacion = numeroInteriorExteriorFacturacion;
    }

    public String getDelegacionFacturacion() {
        return delegacionFacturacion;
    }

    public void setDelegacionFacturacion(String delegacionFacturacion) {
        this.delegacionFacturacion = delegacionFacturacion;
    }

    public String getCpFacturacion() {
        return cpFacturacion;
    }

    public void setCpFacturacion(String cpFacturacion) {
        this.cpFacturacion = cpFacturacion;
    }

    public String getEntidadFacturacion() {
        return entidadFacturacion;
    }

    public void setEntidadFacturacion(String entidadFacturacion) {
        this.entidadFacturacion = entidadFacturacion;
    }

    public String getEmailFacturacion() {
        return emailFacturacion;
    }

    public void setEmailFacturacion(String emailFacturacion) {
        this.emailFacturacion = emailFacturacion;
    }

    public String getAutoUnoMarca() {
        return autoUnoMarca;
    }

    public void setAutoUnoMarca(String autoUnoMarca) {
        this.autoUnoMarca = autoUnoMarca;
    }

    public String getAutoUnoModelo() {
        return autoUnoModelo;
    }

    public void setAutoUnoModelo(String autoUnoModelo) {
        this.autoUnoModelo = autoUnoModelo;
    }

    public String getAutoUnoColor() {
        return autoUnoColor;
    }

    public void setAutoUnoColor(String autoUnoColor) {
        this.autoUnoColor = autoUnoColor;
    }

    public String getAutoUnoPlacas() {
        return autoUnoPlacas;
    }

    public void setAutoUnoPlacas(String autoUnoPlacas) {
        this.autoUnoPlacas = autoUnoPlacas;
    }

    public String getAutoDosMarca() {
        return autoDosMarca;
    }

    public void setAutoDosMarca(String autoDosMarca) {
        this.autoDosMarca = autoDosMarca;
    }

    public String getAutoDosModelo() {
        return autoDosModelo;
    }

    public void setAutoDosModelo(String autoDosModelo) {
        this.autoDosModelo = autoDosModelo;
    }

    public String getAutoDosColor() {
        return autoDosColor;
    }

    public void setAutoDosColor(String autoDosColor) {
        this.autoDosColor = autoDosColor;
    }

    public String getAutoDosPlacas() {
        return autoDosPlacas;
    }

    public void setAutoDosPlacas(String autoDosPlacas) {
        this.autoDosPlacas = autoDosPlacas;
    }

    public String getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(String estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    public String getnClienteAsigando() {
        return nClienteAsigando;
    }

    public void setnClienteAsigando(String nClienteAsigando) {
        this.nClienteAsigando = nClienteAsigando;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getFechaInternaSistema() {
        return fechaInternaSistema;
    }

    public void setFechaInternaSistema(String fechaInternaSistema) {
        this.fechaInternaSistema = fechaInternaSistema;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getnTajetaTarjeton() {
        return nTajetaTarjeton;
    }

    public void setnTajetaTarjeton(String nTajetaTarjeton) {
        this.nTajetaTarjeton = nTajetaTarjeton;
    }

    public int getTipoPensionAsignado() {
        return tipoPensionAsignado;
    }

    public void setTipoPensionAsignado(int tipoPensionAsignado) {
        this.tipoPensionAsignado = tipoPensionAsignado;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getFechaSistemaAlta() {
        return fechaSistemaAlta;
    }

    public void setFechaSistemaAlta(String fechaSistemaAlta) {
        this.fechaSistemaAlta = fechaSistemaAlta;
    }

    public String getFechaSistemaBaja() {
        return fechaSistemaBaja;
    }

    public void setFechaSistemaBaja(String fechaSistemaBaja) {
        this.fechaSistemaBaja = fechaSistemaBaja;
    }

    public String getObsrevaciones() {
        return obsrevaciones;
    }

    public void setObsrevaciones(String obsrevaciones) {
        this.obsrevaciones = obsrevaciones;
    }
    
    

}
