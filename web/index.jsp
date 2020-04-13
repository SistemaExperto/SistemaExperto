<%-- 
    Document   : index
    Created on : 9/02/2020, 11:04:10 AM
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
        <script type="text/javascript" src="JS/jquery.validate.js"></script>
        <script type="text/javascript" src="JS/sweetalert2.min.js"></script>

        <title>Inicio de Sesión</title>
        <style type="text/css">
            .login-form {
                width: 400px;
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
        <script type="text/javascript">
            if (history.forward(1)) {
                location.replace(history.forward(1));
            }
            $.validator.setDefaults({
                submitHandler: function () {
                    alertify.error("Error.");
                }
            });
            $(document).ready(function () {
                $("#signupForm").validate({
                    rules: {
                        txtcontra: {
                            required: true,
                            minlength: 5
                        },
                        txtcorreo: {
                            required: true,
                            email: true
                        },
                    },
                    messages: {
                        txtcontra: {
                            required: "Debes ingresar tu contraseña",
                            minlength: "Ingresa una contraseña correcta"
                        },
                        txtcorreo: {
                            required: "Debes ingresar tu correo electronico",
                            email: "Ingresa un correo electronico valido"
                        },
                    },
                    errorElement: "em",
                    errorPlacement: function (error, element) {
                        // Add the `invalid-feedback` class to the error element
                        error.addClass("invalid-feedback");

                        if (element.prop("type") === "checkbox") {
                            error.insertAfter(element.next("label"));
                        } else {
                            error.insertAfter(element);
                        }
                    },
                    highlight: function (element, errorClass, validClass) {
                        $(element).addClass("is-invalid").removeClass("is-valid");
                    },
                    unhighlight: function (element, errorClass, validClass) {
                        $(element).addClass("is-valid").removeClass("is-invalid");
                    },
                    submitHandler: function (form) {
                        var data = $("#signupForm").serialize();
                        $.post("Validar", data, function (respuesta, est, jqXHR) {
                            if (respuesta == '1') {
                                Swal.fire({
                                    icon: 'success',
                                    color: '#ffffff',
                                    title: 'Sesion iniciada con éxito!',
                                    width: 600,
                                    timer: 3000,
                                    padding: '3em',
                                    background: '#0F0000',
                                    backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("img/giphysuccess.gif")
                                        left top
                                        no-repeat
                                    `
                                });
                                setTimeout(function () {
                                    window.location = "Controlador?accion=Principal";
                                }, 3000);
                            } else {
                                Swal.fire({
                                    icon: 'error',
                                    color: '#ffffff',
                                    title: 'No se pudo iniciar sesion!',
                                    text: 'Verifica los datos ingresados.',
                                    width: 600,
                                    padding: '3em',
                                    background: '#0F0000',
                                    backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("img/giphyerror.gif")
                                        left top
                                        no-repeat
                                    `
                                });
                                $("#txtcontra").val("");
                            }
                        });
                    }
                });
            });
        </script>    
    </head>
    <body style="background-color: #ffffff;">
        <div class="">
            <br>
            <h3 class="text-center">Sistema experto que permite identificar la potencialidad de presentar enfermedades transmitidas</br> por vector considerando la información de la infraestructura de la vivienda.</h3>
        </div>
        <div class="login-form">
            <center><img style=" height: 100px;" src="img/giphyinicio.gif" alt="salud"></center>
            <form id="signupForm">
                <h2 class="text-center text-white">Inicio de Sesión</h2>       
                <div class="form-group text-white">
                    <label for="txtcorreo">Correo Electrónico:</label>
                    <input type="email" id="txtcorreo" name="txtcorreo" class="form-control" placeholder="nombre@ejemplo.com">
                </div>
                <div class="form-group text-white">
                    <label for="txtcontra">Contraseña:</label>
                    <input type="password" id="txtcontra" name="txtcontra" class="form-control">
                </div>
                <div class="form-group text-white">
                    <button type="submit" id="btningresar" name="accion" value="ingresar" class="btn btn-primary btn-block">Ingresar</button>
                </div>
                <div class="clearfix text-white">
                    <label class="pull-left checkbox-inline"><input type="checkbox"> Recordarme</label>
                    <br>
                    <a href="RecuperarC/RecuperarC.jsp" class="pull-right">¿Olvidaste tu contraseña?</a>
                </div>
                <input type="hidden" name="login" value="false">
            </form>
            <p class="text-center" ><a href="ControladorUsuario?action=registro&registros=false">Crear una cuenta</a></p>
        </div>
    </body>
</html>
<% if (session.getAttribute("usuario") != null) {
        response.sendRedirect("Principal.jsp");
    }%>