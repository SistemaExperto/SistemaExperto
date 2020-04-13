<%-- 
    Document   : Basedatos
    Created on : 24/03/2020, 12:43:43 PM
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="icon" type="image/png" href="img/giphysuccess.gif"/>

        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sticky-footer.css" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="JS/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="JS/jquery-3.4.1.slim.min.js"></script>
        <script type="text/javascript" src="JS/bootstrap.min.js"></script>
        <script type="text/javascript" src="JS/popper.min.js"></script>

        <title>Respaldo BD</title>
    </head>
    <body>
        <hr style="opacity: 0">
        <h3 class="text-center" style="color: #10A800;">Respaldo de la Base de Datos</h3>
        <hr style="opacity: 0">

        <div class="container">
            <div class="card-deck mb-3 text-center">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Exportar Base de Datos</h4>
                    </div>
                    <div class="card-body">
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>Requiere de dirección para guardar archivo .sql</li>
                        </ul>
                        <a style="text-decoration:none;" href="ControladorBD?action=exportarbd"><button type="button" class="btn btn-lg btn-block btn-outline-info">Exportar Base de datos</button></a>
                    </div>
                </div>
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Consultar Base de datos</h4>
                    </div>
                    <div class="card-body">
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>Realiza consulta de todas las tablas y genera PDF</li>
                        </ul>
                        <a style="text-decoration:none;" href="ControladorBD?action=importarbd"><button type="button" class="btn btn-lg btn-block btn-outline-warning">Generar PDF</button></a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

