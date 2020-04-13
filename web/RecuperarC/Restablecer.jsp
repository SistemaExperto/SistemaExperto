<%-- 
    Document   : Restablecer
    Created on : 9/03/2020, 06:59:38 PM
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="icon" type="image/png" href="../img/giphysuccess.gif"/>

        <link href="../CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/sticky-footer.css" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="../JS/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="../JS/jquery.validate.js"></script>
        <script type="text/javascript" src="../JS/sweetalert2.min.js"></script>

        <title>Restablecer Contraseña</title>
        
        <link href="../CSS/Restablecer.css" rel="stylesheet" type="text/css"/>
        
        <script src="../JS/Validaciones/RecuperarC.js" type="text/javascript"></script>
        
        <script type="text/javascript">
            function getParameterByName(name) {
            name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
            var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                    results = regex.exec(location.search);
            return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
            }

            var corre = getParameterByName('email');
            document.getElementById("txtemail").value = corre;
            });
        </script>    
    </head>
    <body style="background-color: #ffffff;">
        <div class="">
        </div>
        <div class="login-form">
            <center><img style=" height: 100px;" src="../img/giphyinicio.gif" alt="salud"></center>
            <form id="restablecerForm">
                <h2 class="text-center text-white">Restablecer Contraseña</h2>       
                <div class="form-group text-white">
                    <label for="txtcontran">Contraseña Nueva:</label>
                    <input type="password" id="txtcontran" name="txtcontran" class="form-control" >
                </div>
                <div class="form-group text-white">
                    <label for="txtcontra2">Confirmar Contraseña:</label>
                    <input type="password" id="txtcontra2" name="txtcontra2" class="form-control" >
                </div>
                <input type="hidden" name="txtemail" id="txtemail" value="<%=request.getParameter("email")%>">
                <div class="form-group text-white">
                    <button type="submit" id="btningresar" name="action" value="restablecer" class="btn btn-primary btn-block">Restablecer</button>
                </div>
                <div class="clearfix text-white">
                    <a href="../SistemaExperto" class="pull-right">Cancelar</a>
                </div>        
            </form>
        </div>
        <h3 class="text-center">Sistema experto que permite identificar la potencialidad de presentar enfermedades transmitidas</br> por vector considerando la información de la infraestructura de la vivienda.</h3>
    </body>
</html>
<% if (session.getAttribute("usuario") != null) {
        response.sendRedirect("Principal.jsp");
    }%>

