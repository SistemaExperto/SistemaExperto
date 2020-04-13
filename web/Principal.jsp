<%-- 
    Document   : Principal
    Created on : 9/02/2020, 11:05:41 AM
    Author     : marco
--%>
<% if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="icon" type="image/png" href="img/giphysuccess.gif"/>

        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sticky-footer.css" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="JS/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="JS/jquery.validate.js"></script>
        <script src="JS/sweetalert2.min.js" type="text/javascript"></script>

        <title>Sistema Experto</title>
    </head>
    <body style="background-color: #ffffff;">

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            
            <a class="navbar-brand text-white" href="Controlador?accion=Principal">Sistema Experto</a>
            
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse text-white" id="navbarText">
                <ul class="navbar-nav mr-auto">

                    <c:if test="${usuario.getTipo() == 'Administrador'}">
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-success text-white" href="Controlador?accion=Familiares" target="myFrame">Familiares</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-success text-white" href="Controlador?accion=Viviendas" target="myFrame">Viviendas</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-success text-white" href="Controlador?accion=Usuarios&registros=false" target="myFrame">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-success text-white" href="Controlador?accion=Reportes" target="myFrame">Reportes</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-success text-white" href="Controlador?accion=BaseDatos" target="myFrame">Respaldo BD</a>
                        </li>
                    </c:if>

                    <c:if test="${usuario.getTipo() == 'Capturista'}">
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-success text-white" href="Controlador?accion=Familiares" target="myFrame">Familiares</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-success text-white" href="Controlador?accion=Viviendas" target="myFrame">Viviendas</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-success text-white" href="Controlador?accion=Reportes" target="myFrame">Reportes</a>
                        </li>
                    </c:if>

                    <c:if test="${usuario.getTipo() == 'General'}">
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none;" class="btn btn-success text-white" href="ControladorGeneral?action=probabilidad" target="myFrame">Probabilidad</a>
                        </li>
                    </c:if>

                </ul>

                <div class="dropdown">
                    <button  class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${usuario.getCorreo()}</button>
                    <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                        <img src="img/perfildeusuario.jpg" alt="60" width="60"/>
                        <a class="dropdown-item" href="#">${usuario.getTipo()}</a>
                        <a class="dropdown-item" href="#">${usuario.getNombre()} ${usuario.getApaterno()}</a>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <button name="accion" value="salir" class="dropdown-item" href="#">Salir</button>
                        </form>
                    </div>
                </div> 
                        
            </div>
        </nav>

        <script language="JavaScript">
            if (history.forward(1)) {
                location.replace(history.forward(1));
            }
            function resizeIframe(obj) {
                obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
            }
        </script>

        <div class="m-md-4">
            <iframe id="myFrame" src="Slider.jsp" width="100%" name="myFrame" frameborder="0" scrolling="no" onload="resizeIframe(this)" ></iframe>
        </div>
        <br>
        
        <footer class="footer">
            <div class="container">
                <div class="row">
                    
                </div>
            </div>
            <div class="copyright text-center">
                Copyright &copy; 2020 <span>Sistema Experto</span>
            </div>
        </footer>

        <script src="JS/bootstrapcdn.js" type="text/javascript"></script>
        <script src="JS/popper.min.js" type="text/javascript"></script>
        <script src="JS/jquery-3.4.1.slim.min.js" type="text/javascript"></script>
    </body>
</html>
