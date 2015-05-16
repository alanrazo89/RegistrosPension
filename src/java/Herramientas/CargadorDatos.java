package Herramientas;

import DTOS.ConfigLoginDTO;
import DTOS.EsquemasDTO;
import DTOS.EventoDiaDTO;
import DTOS.Nodo;
import DTOS.UsuarioDTO;
import PensionesDTO.ClienteDTO;
import PensionesDTO.PensionRegistroDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargadorDatos {

    /**
     * cargador esquemas
     *
     * @param rst
     * @return
     * @throws SQLException
     */
    public EsquemasDTO esquemasDTO(ResultSet rst) throws SQLException {
        EsquemasDTO x = new EsquemasDTO();
        x.setId(rst.getInt("id"));
        x.setTitulo(rst.getString("titulo"));
        x.setDescripcion(rst.getString("descripcion"));
        x.setEstado(rst.getInt("estado"));
        return x;
    }

    /**
     * cargador nodo
     *
     * @param rst
     * @return
     * @throws SQLException
     */
    public Nodo nodoDTO(ResultSet rst) throws SQLException {
        Nodo x = new Nodo();
        x.setId(rst.getInt("id"));
        x.setIdEsquema(rst.getInt("id_esquema"));
        x.setTiuloNodo(rst.getString("titulo"));
        x.setDescripcionNodo(rst.getString("descripcion"));
        x.setEstado(rst.getInt("estado"));
        x.setIdPertenece(rst.getInt("id_pertenece"));
        x.setTipoNodo(rst.getInt("tipo_nodo"));
        x.setOrientacionNodo(rst.getInt("orientacion_nodo"));
        return x;
    }

    /**
     * devuelve el obejto config del inicio de sesion
     *
     * @param rst
     * @return
     * @throws SQLException
     */
    public ConfigLoginDTO configLoginDTO(ResultSet rst) throws SQLException {
        ConfigLoginDTO c = new ConfigLoginDTO();

        c.setMensajeSuperiorUno(rst.getString("s1"));
        c.setMensajeSuperiorDos(rst.getString("s2"));
        c.setMensajeInferiorUno(rst.getString("i1"));
        c.setMensajeInferiorDos(rst.getString("i2"));

        return c;
    }

    /**
     * ALAN GONZALEZ CARGA UN USUARIO
     *
     * @param rst
     * @return
     * @throws SQLException
     */
    public UsuarioDTO usuarioDTO(ResultSet rst) throws SQLException {
        UsuarioDTO u = new UsuarioDTO();

        u.setNombres(rst.getString("nombres"));
        u.setApellidos(rst.getString("apellidos"));
        u.setUsr(rst.getString("nombre_usuario"));
        u.setPassMD5(rst.getString("contrasena_usuario"));
        u.setModuloInicio(rst.getString("modulo_inicio"));

        return u;
    }

    /**
     * CARGA UN EVENTO DE DIA
     *
     * @param rst
     * @return
     * @throws SQLException
     */
    public EventoDiaDTO eventoDiaDTO(ResultSet rst) throws SQLException {

        EventoDiaDTO e = new EventoDiaDTO();

        e.setTitulo(rst.getString("titulo"));
        e.setDescripcion(rst.getString("descripcion"));
        e.setFechaSQL(rst.getString("fecha"));
        e.setId(rst.getInt("id"));

        return e;
    }

    /**
     * ALAN GONZALEZ CARGA AL CLIENTE
     *
     * @param rst
     * @return
     * @throws SQLException
     */
    public ClienteDTO clienteDTO(ResultSet rst) throws SQLException {
        ClienteDTO e = new ClienteDTO();

        e.setIdRegistro(rst.getInt("id"));
        e.setNombreCliente(rst.getString("nombre_cliente"));
        e.setFechaRegistro(rst.getString("fecha"));
        e.setLocalEmpresa(rst.getString("local_empresa"));
        e.setTelOfna(rst.getString("tel_oficina"));
        e.setEmailCliente(rst.getString("tel_particular"));
        e.setTelParticular(rst.getString("tel_particular"));
        e.setTipoCliente(rst.getInt("tipo_cliente"));
        e.setPassword(rst.getString("password"));

        return e;
    }

    /**
     * ALAN GONZALEZ CARGA UNA PENSION CON SUS DATOS COMPLETOS
     *
     * @param rst
     * @param cliente
     * @return
     * @throws SQLException
     */
    public PensionRegistroDTO pensionRegistroDTO(ResultSet rst, ClienteDTO cliente) throws SQLException {
        
        PensionRegistroDTO p = new PensionRegistroDTO();
        p.setCliente(cliente);

        p.setIdRegistro(rst.getInt("id"));
        p.setIdCliente(rst.getInt("id_cliente"));
        p.setTipoPension(rst.getInt("tipo_pension"));
        p.setRequiereFactura(rst.getInt("requiere_factura"));
        // datos de facturacion
        p.setNombreFacturacion(rst.getString("nombre_factura"));
        p.setRfcFacturacion(rst.getString("rfc"));
        p.setRazonSocialFacturacion(rst.getString("razon_social"));
        p.setColoniaFacturacion(rst.getString("colonia"));
        p.setCalleFacturacion(rst.getString("calle"));
        p.setNumeroInteriorExteriorFacturacion(rst.getString("n_exterior"));
        p.setDelegacionFacturacion(rst.getString("delegacion"));
        p.setCpFacturacion(rst.getString("cp"));
        p.setEntidadFacturacion(rst.getString("entidad"));
        // datos de los vehiculos 
        p.setAutoUnoMarca(rst.getString("auto1_marca"));
        p.setAutoUnoModelo(rst.getString("auto1_model"));
        p.setAutoUnoColor(rst.getString("auto1_color"));
        p.setAutoUnoPlacas(rst.getString("auto1_placas"));
        //--
        p.setAutoDosMarca(rst.getString("auto2_marca"));
        p.setAutoDosModelo(rst.getString("auto2_model"));
        p.setAutoDosColor(rst.getString("auto2_color"));
        p.setAutoDosPlacas(rst.getString("auto2_placas"));

        // datos de asignacion interna
        p.setEstacionamiento(rst.getString("estacionamiento"));
        p.setnClienteAsigando(rst.getString("n_cliente"));
        p.setNombreEncargado(rst.getString("nombre_encargado"));
        
        p.setPuesto(rst.getString("puesto"));
        p.setnTajetaTarjeton(rst.getString("n_tarjeta_tarjeton"));
        p.setTipoPensionAsignado(rst.getInt("tipo_pension_est"));
        p.setImporte(rst.getDouble("importe"));
        p.setFechaSistemaAlta(rst.getString("regsis_fecha_alta"));
        p.setFechaSistemaBaja(rst.getString("regsis_fecha_baja"));
        // observaciones finales
        p.setObsrevaciones(rst.getString("observaiones"));
        
        
        return p;
    }

}
