<%-- 
    Document   : exportar
    Created on : 23/03/2020, 08:11:32 PM
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

        <title>Exportar Base de Datos</title>
        <script src="JS/Validaciones/BD.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-12">
                    <hr style="opacity: 0">
                    <h3 class="text-center" style="color: #10A800;">Exportar Base de Datos</h3>
                    <hr style="opacity: 0">
                    <div class="card-body">
                        <form class="text-black" id="exportarForm">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Dirección:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" id="txtdireccion" name="txtdireccion" value="Downloads" type="text" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Nombre:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" id="txtnombre" name="txtnombre" type="text">
                                </div>
                            </div>
                            <input class="btn btn-info" type="submit" name="action" value="Exportar"><br>
                        </form>    
                    </div>
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
    </body>
</html>
