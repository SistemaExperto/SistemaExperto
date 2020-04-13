<%-- 
    Document   : registro
    Created on : 11/03/2020, 03:53:51 PM
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Last-Modified" content="0">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Pragma" content="no-cache">

        <link rel="icon" type="image/png" href="img/giphysuccess.gif"/>

        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sticky-footer.css" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="JS/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="JS/jquery.validate.js"></script>
        <script type="text/javascript" src="JS/sweetalert2.min.js"></script>

        <title>Registro de Usuario</title>
        <style type="text/css">
            .login-form {
                width: 540px;
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
        <script src="JS/Validaciones/Usuario.js" type="text/javascript"></script>
    </head>
    <body style="background-color: #ffffff;">
        <div class="">
        </div>
        <br>
        <h3 class="text-center">Sistema experto que permite identificar la potencialidad de presentar enfermedades transmitidas</br> por vector considerando la información de la infraestructura de la vivienda.</h3>
        <div class="login-form">
            <center><img style=" height: 100px;" src="img/giphyinicio.gif" alt="salud"></center>
            <form id="registroForm">
                <input type="text" style="visibility:hidden" name="registros" value="true">
                <h2 class="text-center text-white">Registro de Usuario</h2>
                <div>
                    <div>
                        <select id="txttipo" name="txttipo" style="visibility:hidden">
                            <option value="Capturista">Capturista</option>
                            <option value="General" selected>General</option>
                        </select>
                    </div>
                </div>
                <div class="form-group text-white">
                    <label for="txtnombre">Nombre:</label>
                    <input type="text" id="txtnombre" name="txtnombre" class="form-control" >
                </div>
                <div class="form-group text-white">
                    <label for="txtapaterno">Apellido Paterno:</label>
                    <input type="text" id="txtapaterno" name="txtapaterno" class="form-control" >
                </div>
                <div class="form-group text-white">
                    <label for="txtamaterno">Apellido Materno:</label>
                    <input type="text" id="txtamaterno" name="txtamaterno" class="form-control" >
                </div>
                <div class="form-group text-white">
                    <label for="txtcorreo">Correo Electrónico:</label>
                    <input type="email" id="txtcorreo" name="txtcorreo" class="form-control" >
                </div>
                <div class="form-group text-white">
                    <label for="txtcontra">Contraseña:</label>
                    <input type="password" id="txtcontra" name="txtcontra" class="form-control" >
                </div>
                <div class="form-group text-white">
                    <label for="txtcontra2">Confirmar Contraseña:</label>
                    <input type="password" id="txtcontra2" name="txtcontra2" class="form-control" >
                </div>
                <div class="form-group text-white">
                    <label for="txttelefono">Telefono:</label>
                    <input type="text" id="txttelefono" name="txttelefono" class="form-control" >
                </div>
                <div class="form-group text-white">
                    <label for="txtfechanac">Fecha de Nacimiento:</label>
                    <input type="date" name="txtfechanac" class="form-control" >
                </div>
                <div >
                    <div>
                        <select id="txtestado" name="txtestado" style="visibility:hidden">
                            <option value="Activo" selected>Activo</option>
                            <option value="Inactivo">Inactivo</option>
                        </select>
                    </div>
                </div>
                <div class="form-group text-white">
                    <button type="submit" id="btningresar" name="action" value="Agregarlo" class="btn btn-primary btn-block">Registrar</button>
                </div>
                <div class="clearfix text-white">
                    <a href="../SistemaExperto" class="pull-right">Regresar</a>
                </div>

            </form>
        </div>
        <br>
        <br>
    </body>
</html>
<% if (session.getAttribute("usuario") != null) {
        response.sendRedirect("Principal.jsp");
    }%>