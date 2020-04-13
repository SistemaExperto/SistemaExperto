<%-- 
    Document   : editar
    Created on : 15/02/2020, 03:16:06 PM
    Author     : marco
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.UsuarioDAO"%>
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
        
        <title>Editar Usuario</title>
        <script src="JS/Validaciones/Usuario.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            UsuarioDAO dao=new UsuarioDAO();
            int id=Integer.parseInt((String) request.getAttribute("idusu"));
            Usuario u=(Usuario) dao.ListarID(id);
        %>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-12">
                    <hr style="opacity: 0">
                    <h3 class="text-center" style="color: #10A800;">Editar Usuario</h3>
                    <hr style="opacity: 0">
                    <div class="card-body ">
                        <form class="text-black" id="editarForm" name="editarForm">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Nombre:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txtnombre" value="<%= u.getNombre()%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Apellido Paterno:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txtapaterno" value="<%= u.getApaterno()%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Apellido Materno:</label>
                                <div class="col-sm-4">        
                                    <input class="form-control" type="text" name="txtamaterno" value="<%= u.getAmaterno()%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Correo Electrónico:</label>
                                <div class="col-sm-4">  
                                    <input class="form-control" type="text" name="txtcorreo" value="<%= u.getCorreo()%>">
                                </div>
                            </div>
                            <!--<div class="form-group row">
                                <label class="col-sm-2 col-form-label">Contraseña:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" id="txtcontra" name="txtcontra" value="<%= u.getContra()%>">
                                </div>
                            </div> 
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Confirmar Contraseña:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txtcontra2" value="<%= u.getContra()%>">
                                </div>
                            </div>-->    
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Telefono:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txttelefono" value="<%= u.getTelefono()%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Fecha de Nacimiento:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="date" name="txtfechanac" value="<%=u.getFechaNac()%>"> 
                                </div>
                            </div>
                            <script>
                                $(document).ready(function(){
                                    $("#txttipo").val("<%=u.getTipo()%>");
                                    $("#txtestado").val("<%=u.getEstado()%>");
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
                            <input type="hidden" name="txtid" value="<%= u.getId()%>">
                            <input type="hidden" name="registros" value="false">
                            <input class="btn btn-success" type="submit" name="action" value="Actualizar"><br>
                        </form>    
                    </div>
                </div>
            </div>
        </div>
        <script src="../JS/jquery-3.4.1.slim.min.js" type="text/javascript"></script>
    </body>
</html>
<% if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }%>