<%-- 
    Document   : Reportes
    Created on : 25/03/2020, 09:33:10 PM
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <link rel="icon" type="image/png" href="img/giphysuccess.gif" />

        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/sticky-footer.css" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="JS/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="JS/jquery.validate.js"></script>
        <script type="text/javascript" src="JS/sweetalert2.min.js"></script>
        <script src="JS/all.js" type="text/javascript"></script>

        <title>Reportes</title>
    </head>
    <body>
        <hr style="opacity: 0">
        <h3 class="text-center" style="color: #10A800;">Reportes</h3>
        <hr style="opacity: 0">

        <div class="card">
            <div class="card-header">
                Menú de reportes
            </div>
            <div class="card-body">
                <h5 class="card-title">Da clic sobre el botón para generar el reporte</h5>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item list-group-item-dark">Reporte que muestra la probabilidad de tener alguna enfermedad que esta divido por regiones del Estado de Morelos.    <a class="btn btn-danger" href="ControladorReporte?action=reporte1" target="_blank" role="button"><i class="far fa-file-pdf fa-lg"></i> Generar PDF</a></li>
                    <li class="list-group-item list-group-item-success">Reporte que muestra las personas registradas en el sistema, además por ordenarlas por las regiones del Estado de Morelos.    <a class="btn btn-danger" href="ControladorReporte?action=reporte2" target="_blank" role="button"><i class="far fa-file-pdf fa-lg"></i> Generar PDF</a></li>
                    <li class="list-group-item list-group-item-dark">Reporte que muestra por familiar la probabilidad de contraer alguna enfermedad.    <a class="btn btn-danger" href="ControladorReporte?action=reporte3" target="_blank" role="button"><i class="far fa-file-pdf fa-lg"></i> Generar PDF</a></li>
                    <li class="list-group-item list-group-item-success">Reporte que muestra todas las personas que tienen mayor probabilidad de tener enfermedad causada por vector en el Estado de Morelos.    <a class="btn btn-danger" href="ControladorReporte?action=reporte4" target="_blank" role="button"><i class="far fa-file-pdf fa-lg"></i> Generar PDF</a></li>
                    <li class="list-group-item list-group-item-dark">Reporte que muestra el historial de los usuarios con la probabilidad de obtener enfermedad transmitida por vector.    <a class="btn btn-danger" href="ControladorReporte?action=reporte5" target="_blank" role="button"><i class="far fa-file-pdf fa-lg"></i> Generar PDF</a></li>
                </ul>
            </div>
            <div class="card-footer text-muted">
                Sistema Experto
            </div>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
    </body>
</html>
