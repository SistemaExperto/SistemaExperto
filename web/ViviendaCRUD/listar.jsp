<%-- 
    Document   : listar
    Created on : 22/03/2020, 01:11:22 PM
    Author     : marco
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Vivienda"%>
<%@page import="Modelo.ViviendaDAO"%>
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
        
        <script src="JS/Validaciones/eliminarVivienda.js" type="text/javascript"></script>
        
        <title>Viviendas</title>
    </head>
    <body>
        <hr style="opacity: 0">
        <h3 class="text-center" style="color: #10A800;">Viviendas</h3>
        <hr style="opacity: 0">
        
        <table class="table table-sm text-black bg-default h-100">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Material Piso</th>
                    <th scope="col">Material Pared</th>
                    <th scope="col">Acabado Pared</th>
                    <th scope="col">Material Techo</th>                    
                    <th scope="col">Tipo Sanitario</th>
                    <th scope="col">Drenaje</th>
                    <th scope="col">Familiar</th>
                    <th scope="col">Probabilidad</th>
                    <th><a href="ControladorVivienda?action=agregar"><button type="button" class="btn btn-success">Nueva</button></a></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <%
                ViviendaDAO daoo=new ViviendaDAO();
                List<Vivienda>list=daoo.listar();
                Iterator<Vivienda>iter=list.iterator();
                Vivienda vivi=null;
                while(iter.hasNext()){
                    vivi=iter.next();
            %>
            <tbody>
                <tr scope="row">
                    <td><%= vivi.getId()%></td>
                    <td><%= vivi.getMaterial_piso()%></td>
                    <td><%= vivi.getMaterial_pared()%></td>
                    <td><%= vivi.getAcabado_pared()%></td>
                    <td><%= vivi.getMaterial_techo()%></td>
                    <td><%= vivi.getTipo_sanitario()%></td>
                    <td><%= vivi.getDrenaje()%></td>
                    <td><%= vivi.getFamiliar_idfamiliar()%></td>
                    <td><a href="ControladorVivienda?action=probabilidad&id=<%= vivi.getId()%>"><button type="button" class="btn btn-info">Consultar</button></a></td>
                    <td><a href="ControladorVivienda?action=editar&id=<%= vivi.getId()%>"><button type="button" class="btn btn-warning">Editar</button></a></td>
                    <td><button type="button" class="btn btn-danger" onclick="deleteRecord(<%=vivi.getId()%>);">Eliminar</button></td>
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
