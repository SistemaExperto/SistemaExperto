<%-- 
    Document   : editar
    Created on : 14/03/2020, 11:07:34 AM
    Author     : marco
--%>

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
        
        <title>Editar Familiar</title>
        <script src="JS/Validaciones/Familiar.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            FamiliarDAO dao=new FamiliarDAO();
            int id=Integer.parseInt((String) request.getAttribute("idfam"));
            Familiar f=(Familiar) dao.ListarID(id);
        %>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-12">
                    <hr style="opacity: 0">
                    <h3 class="text-center" style="color: #10A800;">Editar Familiar</h3>
                    <hr style="opacity: 0">
                    <div class="card-body ">
                        <form class="text-black" id="editarForm">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Nombre:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txtnombre" value="<%= f.getNombre()%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Apellido Paterno:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txtapaterno" value="<%= f.getApaterno()%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Apellido Materno:</label>
                                <div class="col-sm-4">        
                                    <input class="form-control" type="text" name="txtamaterno" value="<%= f.getAmaterno()%>">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Correo Electrónico:</label>
                                <div class="col-sm-4">  
                                    <input class="form-control" type="text" name="txtcorreo" value="<%= f.getCorreo()%>">
                                </div>
                            </div>   
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Fecha de Nacimiento:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="date" name="txtfechanac" value="<%=f.getFechaNac()%>"> 
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Municipio:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txtmunicipio" name="txtmunicipio">
                                        <option value="1">Amacuzac</option>
                                        <option value="2">Atlatlahucan</option>
                                        <option value="3">Axochiapan</option>
                                        <option value="4">Ayala</option>
                                        <option value="5">Coatlán del Río</option>
                                        <option value="6">Cuautla</option>
                                        <option value="7">Cuernavaca</option>
                                        <option value="8">Emiliano Zapata</option>
                                        <option value="9">Huitzilac</option>
                                        <option value="10">Jantetelco</option>
                                        <option value="11">Jiutepec</option>
                                        <option value="12">Jojutla</option>
                                        <option value="13">Jonacatepec de Leandro Valle</option>
                                        <option value="14">Mazatepec</option>
                                        <option value="15">Miacatlán</option>
                                        <option value="16">Ocuituco</option>
                                        <option value="17">Puente de Ixtla</option>
                                        <option value="18">Temixco</option>
                                        <option value="19">Temoac</option>
                                        <option value="20">Tepalcingo</option>
                                        <option value="21">Tepoztlán</option>
                                        <option value="22">Tetecala</option>
                                        <option value="23">Tetela del Volcán</option>
                                        <option value="24">Tlalnepantla</option>
                                        <option value="25">Tlaltizapán de Zapata</option>
                                        <option value="26">Tlaquiltenango</option>
                                        <option value="27">Tlayacapan</option>
                                        <option value="28">Totolapan</option>
                                        <option value="29">Xochitepec</option>
                                        <option value="30">Yautepec</option>
                                        <option value="31">Yecapixtla</option>
                                        <option value="32">Zacatepec</option>
                                        <option value="33">Zacualpan de Amilpas</option>
                                        <option value="34">Coatetelco</option>
                                        <option value="35">Xoxocotla</option>
                                        <option value="36">Hueyapan</option>
                                    </select>
                                </div>
                            </div>
                            <script>
                                $(document).ready(function () {
                                    $("#txtmunicipio option:contains(<%= f.getMunicipio()%>)").attr('selected', true);
                                });
                            </script>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Telefono:</label>
                                <div class="col-sm-4">
                                    <input class="form-control" type="text" name="txttelefono" value="<%= f.getTelefono()%>">
                                </div>
                            </div>
                            <input type="hidden" name="txtid" value="<%= f.getId()%>">
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
