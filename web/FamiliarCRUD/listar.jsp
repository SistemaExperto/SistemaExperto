<%-- 
    Document   : listar
    Created on : 14/03/2020, 11:07:45 AM
    Author     : marco
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Familiar"%>
<%@page import="Modelo.FamiliarDAO"%>
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
        
        <script src="JS/Validaciones/eliminarFamiliar.js" type="text/javascript"></script>
        
        <title>Familiares</title>
    </head>
    <body>
        <hr style="opacity: 0">
        <h3 class="text-center" style="color: #10A800;">Familiares</h3>
        <hr style="opacity: 0">
        
        <table class="table table-sm text-black bg-default h-100">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido Paterno</th>
                    <th scope="col">Apellido Materno</th>
                    <th scope="col">Correo</th>                    
                    <th scope="col">Fecha de Nacimiento</th>
                    <th scope="col">Municipio</th>
                    <th scope="col">Telefono</th>
                    <th><a href="ControladorFamiliar?action=agregar"><button type="button" class="btn btn-success">Nuevo</button></a></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <%
                FamiliarDAO daoo=new FamiliarDAO();
                List<Familiar>list=daoo.listar();
                Iterator<Familiar>iter=list.iterator();
                Familiar fami=null;
                while(iter.hasNext()){
                    fami=iter.next();
            %>
            <tbody>
                <tr scope="row">
                    <td><%= fami.getId()%></td>
                    <td><%= fami.getNombre()%></td>
                    <td><%= fami.getApaterno()%></td>
                    <td><%= fami.getAmaterno()%></td>
                    <td><%= fami.getCorreo()%></td>
                    <td><%= fami.getFechaNac()%></td>
                    <td><%= fami.getMunicipio()%></td>
                    <td><%= fami.getTelefono()%></td>
                    <td><a href="ControladorFamiliar?action=editar&id=<%= fami.getId()%>"><button type="button" class="btn btn-warning">Editar</button></a></td>
                    <td><button type="button" class="btn btn-danger" onclick="deleteRecord(<%=fami.getId()%>);">Eliminar</button></td>
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