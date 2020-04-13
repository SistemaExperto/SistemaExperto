<%-- 
    Document   : listar
    Created on : 15/02/2020, 03:16:16 PM
    Author     : marco
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.UsuarioDAO"%>
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
        
        <script src="JS/Validaciones/eliminarUsuario.js" type="text/javascript"></script>
        
        <title>Usuarios</title>
    </head>
    <body>
        <hr style="opacity: 0">
        <h3 class="text-center" style="color: #10A800;">Usuarios</h3>
        <hr style="opacity: 0">

        <table class="table table-sm text-black bg-default h-100">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido Paterno</th>
                    <th scope="col">Apellido Materno</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Contraseña</th>
                    <th scope="col">Telefono</th>
                    <th scope="col">Fecha de Nacimiento</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Estado</th>
                    <th><a href="ControladorUsuario?action=agregar&registros=false"><button type="button" class="btn btn-success">Nuevo</button></a></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <%
                UsuarioDAO daoo = new UsuarioDAO();
                List<Usuario> list = daoo.listar();
                Iterator<Usuario> iter = list.iterator();
                Usuario usua = null;
                while (iter.hasNext()) {
                    usua = iter.next();
                    if (usua.getTipo().equalsIgnoreCase("Administrador")) {
                        usua.setId(0);
                    }

            %>
            <tbody>
                <tr scope="row">
                    <td><%= usua.getId()%></td>
                    <td><%= usua.getNombre()%></td>
                    <td><%= usua.getApaterno()%></td>
                    <td><%= usua.getAmaterno()%></td>
                    <td><%= usua.getCorreo()%></td>
                    <td><%= usua.getContra()%></td>
                    <td><%= usua.getTelefono()%></td>
                    <td><%= usua.getFechaNac()%></td>
                    <td><%= usua.getTipo()%></td>
                    <td><%= usua.getEstado()%></td>
                    <% if (usua.getTipo().equalsIgnoreCase("Administrador")) {%>
                    <%} else {%>
                    <td><a href="ControladorUsuario?action=editar&id=<%= usua.getId()%>&registros=false"><button type="button" class="btn btn-warning">Editar</button></a></td>
                    <td><button type="button" class="btn btn-danger" onclick="deleteRecord(<%=usua.getId()%>);">Eliminar</button></td>
                    <%}%>
                </tr>
                <%}%>
            </tbody>
        </table>
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
    </body>
</html>
<% if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }%>