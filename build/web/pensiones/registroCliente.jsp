<%-- 
    Document   : capturaPension
    Created on : 14-may-2015, 14:40:40
    Author     : malangr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            </div>
            </br>
            <div class="row">
                <h3>Registro Nuevo Cliente</h3>
                <c:if test="${banderaErroresUsuarioRegistro > 0}">
                    <div class="callout panel radius">
                        <h3>Atencion Hay Errores</h3>
                        <ul>
                            <c:forEach items="${vErroresUsuarioRegistro}" var="errorUsuario">
                                <li> ${errorUsuario} </li>
                                </c:forEach>
                        </ul>
                    </div>
                </c:if>
            </div>
            <div class="row">                
                <div class="large-12 columns">
                    <form method="post" action="./UsuarioNuevo?funcion=recuperaDatosNuevoUsuario">
                        <fieldset>
                            <h3>Datos Del Cliente</h3>
                            <div class="large-12 columns">
                                <label for="nombreCliente">Nombre del Cliente</label>
                                <input type="text" placeholder="Nombre Cliente" name="nombreCliente"/>
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
                            <div class="large-12 columns">
                                <input type="submit" value="Guardar" class="button success"/>
                                <input type="button" value="Regresar" class="button success" onclick="window.location = './'"/>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
