
<%@page import="DAOS.CalendarioDAO"%>
<%@page import="DAOS.ConfiguracionSistemaDAO"%>
<%@page import="DTOS.ConfigLoginDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<link href="./scripting/estiloLogin.css" rel="stylesheet" type="text/css"/>


<%
    ConfigLoginDTO configuracion = new ConfigLoginDTO();
    ConfiguracionSistemaDAO configSysDAO = new ConfiguracionSistemaDAO();
    configuracion = configSysDAO.configuracionLogin();
    session.setAttribute("configLogin", configuracion); 
%>

<section class="lgncnt">
    <form method="post" action="./Login?funcion=usuario" name="logingSys">
        <div class="login">
            <div><i></i>
                <span> ${configLogin.mensajeSuperiorUno} </span>
                <p> ${configLogin.mensajeSuperiorDos} </p>
            </div>
            <div>
                <input type="text" placeholder="Usuario" name="usr"/>
                <input type="password" placeholder="Contraseña" name="pass"/>
            </div>
            <div>

            </div>
            <div>
                <input type="submit" value="Iniciar Sesion"/>
                <input type="button" value="Nuevo Cliente" onclick="window.location='./UsuarioNuevo?funcion=nuevoUsuario'   "/>
            </div>
            <div>
                <p>${configLogin.mensajeInferiorUno} </p>
                <p>${configLogin.mensajeInferiorDos} </p>
            </div>
        </div>
    </form>
</section>