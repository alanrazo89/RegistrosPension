<%-- 
    Document   : capturaPension
    Created on : 14-may-2015, 14:40:40
    Author     : malangr
--%>
<jsp:include page = "../metadatos_importaciones.jsp" flush = "True" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CAPTURA DE PENSION | P A R E ESTACIONAMIENTOS</title>
    </head>
    <body>
        <div class="panel">
            <div align="center">
                <div class="th">
                    <img src="./imgs/logoPareTrans.png" width="300" height="400"/>
                </div>
            </div>

            </br>
            <div class="row">

                <h3>Registro Nueva Pension</h3>
            </div>
            <div class="row">                
                <div class="large-12 columns">

                    
                    
                    <form method="post" action="#">
                        <fieldset>
                            <h3>Datos Del Cliente</h3>
<!--                        <div>
                            <input type="submit" value="Guardar" class="button success"/>
                        </div>-->

                        <div class="large-8 columns">
                            <label for="nombreCliente">Nombre del Cliente</label>
                            <input type="text" placeholder="Nombre Cliente" name="nombreCliente"/>
                        </div>
                        <div class="large-4 columns">
                            <label for="fechaRegistro">Fecha de Registro</label>
                            <input type="text"  name="fechaRegistro"/>
                        </div>

                        <div class="large-8 columns">
                            <label for="localEmpresa">Local / Empresa</label>
                            <input type="text" placeholder="Local y/o empresa" name="localEmpresa"/>
                        </div>
                        <div class="large-4 columns">
                            <label for="telOfna">Tel Oficina</label>
                            <input type="text" placeholder="Tel Oficina" name="telOfna"/>
                        </div>

                        <div class="large-8 columns">
                            <label for="emailCliente">Email Cliente</label>
                            <input type="text" placeholder="Email" name="emailCliente"/>
                        </div>
                        <div class="large-4 columns">
                            <label for="telParticular">Telefono Particular</label>
                            <input type="text" placeholder="Tel Particular" name="telParticular"/>
                        </div>

                        <!-- tipo de pension -->
                        <div class="large-12 columns">
                            <h3> Tipo Pension</h3>
                            <div class="large-6 columns">
                                <input type="radio" name="tipoPension" value="1"> Pension
                            </div>
                            <div class="large-6 columns">
                                <input type="radio" name="tipoPension" value="0"> Cortesia
                            </div>
                        </div>

                        <!-- requiere factura -->
                        <!-- este grupo segun su cambio envia el form y lo recarga con interfaz modificada o no-->
                        <div class="large-12 columns">
                            <h3> ¿Va a Requerir Facturacion?</h3>
                            <div class="large-6 columns">
                                <input type="radio" name="requiereFactura" value="1"> SI, Requiero Mi Factura
                            </div>
                            <div class="large-6 columns">
                                <input type="radio" name="requiereFactura" value="0"> No, Gracias
                            </div>
                        </div>

                        </fieldset>
                        

                        <!-- visibles segun si requiere factura -->

                        <fieldset>
                        <h3>Datos Facturacion</h3>
                        <div class="large-12 columns">

                            <div class="large-8 columns">
                                <label for="nombreFacturacion">Nombre Factura</label>
                                <input type="text" placeholder="Nombre Factura" name="nombreFacturacion"/>
                            </div>

                            <div class="large-4 columns">
                                <label for="rfc">R.F.C.</label>
                                <input type="text" placeholder="R.F.C." name="rfcFacturacion"/>
                            </div>

                            <div class="large-8 columns">
                                <label for="rfc">Razon Social</label>
                                <input type="text" placeholder="Razon Social" name="razonSocialFacturacion"/>
                            </div>

                            <div class="large-4 columns">
                                <label for="rfc">Colonia</label>
                                <input type="text" placeholder="Colonia" name="coloniaFacturacion"/>
                            </div>

                            <div class="large-8 columns">
                                <label for="calleFacturacion">Calle</label>
                                <input type="text" placeholder="Calle" name="calleFacturacion"/>
                            </div>

                            <div class="large-4 columns">
                                <label for="numeroInteriorExteriorFacturacion">Numero Interior Exterior</label>
                                <input type="text" placeholder="Nº Interior-Exterior" name="numeroInteriorExteriorFacturacion"/>
                            </div>

                            <div class="large-8 columns">
                                <label for="delegacion">Numero Interior Exterior</label>
                                <input type="text" placeholder="Delegacion"name="delegacionFacturacion"/>
                            </div>

                            <div class="large-4 columns">
                                <label for="cpFacturacion">Codigo Postal</label>
                                <input type="text" placeholder="CP" name="cpFacturacion"/>
                            </div>
                            <div class="large-8 columns">
                                <label for="entidadFacturacion">Entidad</label>
                                <input type="text" placeholder="Entidad" name="entidadFacturacion"/>
                            </div>

                            <div class="large-4 columns">
                                <label for="emailFacturacion">Email Facturacion</label>
                                <input type="text" placeholder="Email" name="emailFacturacion"/>
                            </div>

                        </div>
                        </fieldset>

                        <!-- visibles segun si requiere factura -->

                        <!-- datos de los vehiculos -->
                        <fieldset>
                        <h3>Vehiculos</h3>
                        <div class="large-12 columns">
                            <div class="large-6 columns">
                                <b>Automovil 1</b>
                                <label for="autoUnoMarca">Marca</label>
                                <div class="large-12 columns">
                                    <input type="text" placeholder="Marca1" name="autoUnoMarca"/>
                                </div>
                                <div class="large-12 columns">
                                    <label for="autoUnoModelo">Modelo</label>
                                    <input type="text" placeholder="Modelo1" name="autoUnoModelo"/>
                                </div>
                                <div class="large-12 columns">
                                    <label for="autoUnoColor">Modelo</label>
                                    <input type="text" placeholder="Color1" name="autoUnoColor"/>
                                </div>
                                <div class="large-12 columns">
                                    <label for="autoUnoPlacas">Modelo</label>
                                    <input type="text" placeholder="Placas1" name="autoUnoPlacas"/>
                                </div>

                            </div>
                            <div class="large-6 columns">
                                <b>Automovil 2</b>
                                <label for="autoDosMarca">Marca</label>
                                <div class="large-12 columns">
                                    <input type="text" placeholder="Marca2" name="autoDosMarca"/>
                                </div>
                                <div class="large-12 columns">
                                    <label for="autoDosModelo">Modelo</label>
                                    <input type="text" placeholder="Modelo2" name="autoDosModelo"/>
                                </div>
                                <div class="large-12 columns">
                                    <label for="autoDosColor">Modelo</label>
                                    <input type="text" placeholder="Color2" name="autoDosColor"/>
                                </div>
                                <div class="large-12 columns">
                                    <label for="autoDosPlacas">Modelo</label>
                                    <input type="text" placeholder="Placas2" name="autoDosPlacas"/>
                                </div>
                            </div>
                        </div>
                        </fieldset>

                        <!-- fin de datos vehiculares -->
                        <fieldset>

                        <div class="large-12 columns">

                            <h3>Para Uso Exclusivo del Estacionamiento</h3>
                            <div class="large-8 columns">
                                <label for="estacionamiento">Estacionamiento</label>
                                <input type="text" placeholder="Estacionamiento" name="estacionamiento"/>
                            </div>
                            <div class="large-4 columns">
                                <label for="nClienteAsigando">No Cliente Aisgnado</label>
                                <input type="text" placeholder="No Cliente" name="nClienteAsigando"/>
                            </div>

                            <div class="large-8 columns">
                                <label for="nombreEncargado">Nombre del Encargado</label>
                                <input type="text" placeholder="Nombre Encargado" name="nombreEncargado"/>
                            </div>
                            <div class="large-4 columns">
                                <label for="fechaInternaSistema">Fecha de Registro Sistema</label> 
                                <input type="date" placeholder="Fecha" name="fechaInternaSistema"/>
                            </div>

                            <div class="large-8 columns">
                                <label for="puesto">Puesto</label> 
                                <input type="text" placeholder="Puesto" name="puesto"/>
                            </div>
                            <div class="large-4 columns">
                                <label for="nTajetaTarjeton">No Tarjeta o Tarjeton</label> 
                                <input type="text" placeholder="No Tarjeta / No Tarjeton" name="nTajetaTarjeton"/>
                            </div>
                            <div class="large-8 columns">
                                <div class="large-4 columns">

                                    <input type="radio" name="tipoPensionAsignado" value="1"> Pension
                                </div>
                                <div class="large-4 columns">
                                    <input type="radio" name="tipoPensionAsignado" value="0"> Cortesia
                                </div>
                            </div>
                            <div class="large-4 columns">
                                <label for="importe">Importe</label> 
                                <input type="text" placeholder="Importe" name="importe"/>
                            </div>                      
                        </div>
                        <div class="large-12 columns">
                            <div class="large-6 columns">
                                <label for="fechaSistemaAlta">Fecha Alta Sistema</label>
                                <input type="date"  name="fechaSistemaAlta"/>
                            </div>  
                            <div class="large-6 columns">
                                <label for="fechaSistemaBaja">Fecha Baja Sistema</label>
                                <input type="date" name="fechaSistemaBaja"/>
                            </div>                          
                        </div>
                        <div class="large-12 columns">
                            <label for="observaciones">Observaciones</label>
                            <textarea name="obsrevaciones" placeholder="Observaciones"></textarea>
                        </div>
                        </fieldset>
                        <div>
                            <input type="submit" value="Guardar" class="button success"/>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
