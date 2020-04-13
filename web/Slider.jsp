<%-- 
    Document   : Slider
    Created on : 13/03/2020, 06:59:46 PM
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
        
        <title>Sistema Experto</title>
    </head>
    <body>
        <hr style="opacity: 0">
        <h3 class="text-center" style="color: #10A800;">Sistema Experto</h3>
        <hr style="opacity: 0">
        
        <div class="container">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="img/slider1.png" alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="img/slider2.jpg" alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="img/slider3.jpg" alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        </div>

    </body>
</html>
