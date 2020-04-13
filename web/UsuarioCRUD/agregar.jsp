<%-- 
    Document   : agregar
    Created on : 15/02/2020, 03:15:56 PM
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
        
        <link rel="icon" type="image/png" href="img/giphysuccess.gif" />

        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sticky-footer.css" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="JS/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="JS/jquery.validate.js"></script>
        <script type="text/javascript" src="JS/sweetalert2.min.js"></script>

        <title>Agregar Usuario</title>
        <script src="JS/Validaciones/Usuario.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-12">
                    <hr style="opacity: 0">
                    <h3 class="text-center" style="color: #10A800;">Agregar Usuario</h3>
                    <hr style="opacity: 0">
                    <div class="card-body ">
                        <form class="text-black" id="agregarForm">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Nombre:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txtnombre">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Apellido Paterno:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txtapaterno">
                                </div>
                            </div>   
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Apellido Materno:</label>
                                <div class="col-sm-4">        
                                    <input class="form-control" type="text" name="txtamaterno">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Correo Electrónico:</label>
                                <div class="col-sm-4">  
                                    <input class="form-control" id="txtcorreo" type="email" name="txtcorreo">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Contraseña:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" id="txtcontra" type="password" name="txtcontra">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Confirmar Contraseña:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" id="txtcontra2" type="password" name="txtcontra2">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Telefono:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txttelefono">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Fecha de Nacimiento:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" id="txtfechanac" type="date" name="txtfechanac"> 
                                </div>
                            </div>
                            <script>
                                $(document).ready(function () {
                                    $("#txttipo").val("");
                                    $("#txtestado").val("");
                                });
                            </script>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Tipo:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txttipo" name="txttipo">
                                        <option value="Capturista">Capturista</option>
                                        <option value="General">General</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Estado:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txtestado" name="txtestado">
                                        <option value="Activo">Activo</option>
                                        <option value="Inactivo">Inactivo</option>
                                    </select>
                                </div>
                            </div>
                            <input type="hidden" name="registros" value="false">
                            <input class="btn btn-success" type="submit" name="action" value="Agregarlo"><br>
                        </form>    
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<% if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }%>