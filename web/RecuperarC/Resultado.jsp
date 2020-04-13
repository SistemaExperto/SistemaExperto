<%-- 
    Document   : Resultado
    Created on : 9/03/2020, 11:33:25 AM
    Author     : marco
--%>

<%@page import="Modelo.Email"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Resultado Recuperación</title>
        <link href="../CSS/sweetalert2.css" rel="stylesheet" type="text/css"/>
        <script src="../JS/sweetalert2.min.js" type="text/javascript"></script>
    </head>
    
    <body>
        <%
            Email email = new Email();
  
            String para = request.getParameter("txtcorreo");
            
            boolean resultado = email.enviarCorreo(para);
            if(resultado){
        %>
        <script type="text/javascript">
            Swal.fire({
                icon: 'success',
                color: '#FFFFFF',
                title: 'Se envio el correo correctamente!',
                text: 'Verifica tu correo electrónico.',
                width: 600,
                padding: '3em',
                background: '#0F0000',
                backdrop: `
                    rgba(15, 0, 0, 0.6)
                    url("../img/giphysuccess.gif")
                    left top
                    no-repeat
                    `
            });
            setTimeout(function(){location.href='http://localhost:8080/SistemaExperto/'},3000,'JavaScript');
        </script>
        <%
            }else{
                out.print("Correo no enviado, verifica el correo");
            }
        
        %>
    </body>
</html>
