<%-- 
    Document   : agregar
    Created on : 22/03/2020, 01:10:59 PM
    Author     : marco
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Familiar"%>
<%@page import="java.util.ArrayList"%>
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

        <title>Agregar Vivienda</title>
        <script src="JS/Validaciones/Vivienda.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                $("#txtfamiliar_idfamiliar").val("");
                $("#txtmaterial_piso").val("");
                $("#txtmaterial_pared").val("");
                $("#txtacabado_pared").val("");
                $("#txtmaterial_techo").val("");
                $("#txttipo_sanitario").val("");
                $("#txtdrenaje").val("");
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-12">
                    <hr style="opacity: 0">
                    <h3 class="text-center" style="color: #10A800;">Agregar Vivienda</h3>
                    <hr style="opacity: 0">
                    <div class="card-body ">
                        <form class="text-black" id="agregarForm">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Familiar:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txtfamiliar_idfamiliar" name="txtfamiliar_idfamiliar">
                                        <%
                                            FamiliarDAO fdao = new FamiliarDAO();
                                            List<Familiar> list = fdao.listar();
                                            Iterator<Familiar> iter = list.iterator();
                                            Familiar fami = null;
                                            while (iter.hasNext()) {
                                                fami = iter.next();
                                                String aux=fami.getNombre()+" "+fami.getApaterno()+" "+fami.getAmaterno();
                                        %>
                                        <option value="<%=fami.getId()%>"><%=aux%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Material Piso:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txtmaterial_piso" name="txtmaterial_piso">
                                        <option value="Cemento o firme">Cemento o firme</option>
                                        <option value="Madera, mosaico, loseta u otro recubrimiento">Madera, mosaico, loseta u otro recubrimiento</option>
                                        <option value="Tierra">Tierra</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Material Pared:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txtmaterial_pared" name="txtmaterial_pared">
                                        <option value="1">Tabique, ladrillo, tabicón, block concreto monolítico, piedra o cemento (incluye cantera)</option>
                                        <option value="2">Madera o adobe</option>
                                        <option value="3">Panel de concreto o tabla roca</option>
                                        <option value="4">Lámina metálica, fibra de vidrio, plástico, mica o asbesto</option>
                                        <option value="5">Cartón, hule, tela, llantas, lámina de cartón, carrizo, bambú, palma o tejamaní, embarro o bajareque</option>
                                        <option value="6">Otro</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Acabado Pared:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txtacabado_pared" name="txtacabado_pared">
                                        <option value="Cemento">Cemento</option>
                                        <option value="Recubrimiento (pasta, yeso) sin pintura">Recubrimiento (pasta, yeso) sin pintura</option>
                                        <option value="Ninguno">Ninguno</option>
                                        <option value="Recubrimiento con pintura o tapiz">Recubrimiento con pintura o tapiz</option>
                                        <option value="Otro">Otro</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Material Techo:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txtmaterial_techo" name="txtmaterial_techo">
                                        <option value="1">Tabique, ladrillo, tabicón, block, concreto monolítico, piedra o cemento (incluye cantera)</option>
                                        <option value="2">Madera o adobe</option>
                                        <option value="3">Panel de concreto o tabla roca</option>
                                        <option value="4">Lámina metálica, fibra de vidrio, plástico, mica o asbesto</option>
                                        <option value="5">Cartón, hule, tela, llantas, lámina de cartón, carrizo, bambú, palma o tejamaní, embarro o bajareque</option>
                                        <option value="6">Otro</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Tipo Sanitario:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txttipo_sanitario" name="txttipo_sanitario">
                                        <option value="Excusado o sanitario sin conex">Excusado o sanitario sin conex</option>
                                        <option value="Excusado o sanitario con conex">Excusado o sanitario con conex</option>
                                        <option value="Hoyo negro, pozo ciego o letri">Hoyo negro, pozo ciego o letri</option>
                                        <option value="No tiene servicio sanitario">No tiene servicio sanitario</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Drenaje:</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="txtdrenaje" name="txtdrenaje">
                                        <option value="1">Sí</option>
                                        <option value="2">No</option>
                                    </select>
                                </div>
                            </div>
                            <input class="btn btn-success" type="submit" name="action" value="Agregarlo"><br>
                        </form>    
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<% if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }%>