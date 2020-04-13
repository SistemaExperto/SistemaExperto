<%-- 
    Document   : RecuperarC
    Created on : 9/03/2020, 11:05:24 AM
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="icon" type="image/png" href="../img/icono.jpg" />
        
        <link href="../CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/sticky-footer.css" rel="stylesheet" type="text/css"/>
        
        <script type="text/javascript" src="../JS/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="../JS/jquery.validate.js"></script>
        <script type="text/javascript" src="../JS/sweetalert2.min.js"></script>
        
        <title>Recuperar Contraseña</title>
        <style type="text/css">
            .login-form {
                width: 440px;
                margin: 50px auto;
            }
            .login-form form {
                margin-bottom: 15px;
                background-color: rgba(15, 0, 0, 0.6);
                background: rgba(15, 0, 0, 0.6);
                color: rgba(15, 0, 0, 0.6);
                /*box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);*/
                padding: 30px;
                border-radius: 3px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }
        </style>
        <script src="../JS/Validaciones/RecuperarC.js" type="text/javascript"></script>
    </head>
    <body style="background-color: #ffffff;">
        <div class="">
        </div>
        <div class="login-form">
            <center><img style=" height: 100px;" src="../img/giphyinicio.gif" alt="salud"></center>
            <form id="recuperarForm">
                <h2 class="text-center text-white">Recuperar Contraseña</h2>       
                <div class="form-group text-white">
                    <label for="txtcorreo">Correo Electrónico:</label>
                    <input type="email" id="txtcorreo" name="txtcorreo" class="form-control" placeholder="nombre@ejemplo.com">
                </div>
                <div class="form-group text-white">
                    <button type="submit" id="btningresar" name="action" value="existe" class="btn btn-primary btn-block">Enviar</button>
                </div>
                <div class="clearfix text-white">
                    <a href="../SistemaExperto" class="pull-right">Regresar</a>
                </div>        
            </form>
        </div>
        <h3 class="text-center">Sistema experto que permite identificar la potencialidad de presentar enfermedades transmitidas</br> por vector considerando la información de la infraestructura de la vivienda.</h3>
    </body>
</html>
<% if (session.getAttribute("usuario") != null) {
        response.sendRedirect("Principal.jsp");
    }%>
