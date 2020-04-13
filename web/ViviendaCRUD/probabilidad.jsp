<%-- 
    Document   : probabilidad
    Created on : 24/03/2020, 04:59:03 PM
    Author     : marco
--%>

<%@page import="Modelo.RecomendacionDAO"%>
<%@page import="Modelo.Recomendacion"%>
<%@page import="Modelo.Historial"%>
<%@page import="Modelo.HistorialDAO"%>
<%@page import="Modelo.Probabilidad"%>
<%@page import="Modelo.ProbabilidadDAO"%>
<%@page import="Modelo.Vivienda"%>
<%@page import="Modelo.ViviendaDAO"%>
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
        <link href="CSS/all.css" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="JS/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="JS/jquery.validate.js"></script>
        <script type="text/javascript" src="JS/sweetalert2.min.js"></script>
        <script src="JS/all.js" type="text/javascript"></script>

        <title>Probabilida Vivienda</title>

        <%
            ViviendaDAO dao = new ViviendaDAO();
            int id = Integer.parseInt(request.getAttribute("idviv").toString());
            Vivienda v = dao.ListarID(id);
        %>

        <script>
            $(document).ready(function () {
                $('.viviendac').show("swing");
                $('.probabilidadc').hide("linear");
                $('.historialc').hide("linear");
                $('.recomendacionc').hide("linear");
                $("#vivienda").click(function () {
                    $('.viviendac').show("swing");
                    $('.probabilidadc').hide("linear");
                    $('.historialc').hide("linear");
                    $('.recomendacionc').hide("linear");
                });
                $("#probabilidad").click(function () {
                    $('.viviendac').hide("linear");
                    $('.probabilidadc').show("swing");
                    $('.historialc').hide("linear");
                    $('.recomendacionc').hide("linear");
                });
                $("#historial").click(function () {
                    $('.viviendac').hide("linear");
                    $('.probabilidadc').hide("linear");
                    $('.historialc').show("swing");
                    $('.recomendacionc').hide("linear");
                });
                $("#recomendacion").click(function () {
                    $('.viviendac').hide("linear");
                    $('.probabilidadc').hide("linear");
                    $('.historialc').hide("linear");
                    $('.recomendacionc').show("swing");
                });
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-12">
                    <hr style="opacity: 0">
                    <h3 class="text-center" style="color: #10A800;">Vivienda</h3><br>
                    <center>
                        <div class="btn-group btn-group-toggle" data-toggle="buttons">
                            <label class="btn btn-success active">
                                <input type="radio" id="vivienda" name="vivienda" autocomplete="off" checked>Vivienda
                            </label>
                            <label class="btn btn-info">
                                <input type="radio" id="probabilidad" name="probabilidad" autocomplete="off">Probabilidad
                            </label>
                            <label class="btn btn-warning">
                                <input type="radio" id="historial" name="historial" autocomplete="off">Historial
                            </label>
                            <label class="btn btn-secondary">
                                <input type="radio" id="recomendacion" name="recomendacion" autocomplete="off">Recomendación
                            </label>
                        </div>
                    </center>
                    <div class="jumbotron" style="background:transparent !important">
                        <div class="viviendac"> 
                            <h4 class="card-title">Vivienda: </h4>
                            <hr class="my-4">
                            <p class="lead"><strong>ID:</strong> <%=v.getId()%></p>
                            <p class="lead"><strong>Material Piso:</strong> <%=v.getMaterial_piso()%>.</p>
                            <p class="lead"><strong>Material Pared:</strong> <%=v.getMaterial_pared()%>.</p>
                            <p class="lead"><strong>Acabado Pared:</strong> <%=v.getAcabado_pared()%>.</p>
                            <p class="lead"><strong>Material Techo:</strong> <%=v.getMaterial_techo()%>.</p>
                            <p class="lead"><strong>Tipo Sanitario:</strong> <%=v.getTipo_sanitario()%>.</p>
                            <p class="lead"><strong>Drenaje:</strong> <%=v.getDrenaje()%>.</p>
                            <p class="lead"><strong>Familiar ID:</strong> <%=v.getFamiliar_idfamiliar()%>.</p>
                            <hr class="my-4">
                        </div>
                        <div class="probabilidadc">
                            <h4 class="card-title">Probabilidad: </h4>
                            <hr class="my-4">
                            <%
                                ProbabilidadDAO daop = new ProbabilidadDAO();
                                HistorialDAO daoh = new HistorialDAO();
                                RecomendacionDAO daor = new RecomendacionDAO();
                                List<Probabilidad> list = daop.listar(v.getId());
                                Iterator<Probabilidad> iter = list.iterator();
                                Probabilidad prob = new Probabilidad();
                                Historial histo = new Historial();
                                Recomendacion recomen = new Recomendacion();
                                if (iter.hasNext()) {
                                    prob = iter.next();
                                    histo = daoh.listar(prob.getId());
                                    recomen = daor.listar(prob.getId());
                            %>
                            <p><strong>Probabilidad del primer algoritmo(Bayes):</strong> <%=prob.getBayessi()%> %</p>
                            <p><strong>Resultado:</strong> <%=histo.getBayes()%> </p>
                            <p><strong>Probabilidad el segundo algoritmo(Arbol):</strong> <%=prob.getArbolsi()%></p>
                            <p><strong>Resultado:</strong> <%=histo.getArbol()%> </p>
                            <p><strong>Fecha de generación:</strong> <%=prob.getFechareg()%></p>
                            <%}%>
                            <a class="btn btn-primary" href="ControladorVivienda?action=generar&id=<%=v.getId()%>" role="button"><i class="far fa-sun fa-lg"></i> Generar Probabilidad</a>
                            <!--<a class="btn btn-secondary" href="#" role="button"><i class="far fa-envelope fa-lg"></i> Enviar por correo electrónico</a>-->
                            <a class="btn btn-danger" href="ControladorReporte?action=probabilidad&idvivienda=<%=v.getId()%>" target="_blank" role="button"><i class="far fa-file-pdf fa-lg"></i> Generar PDF de Probabilidad</a>
                            <hr class="my-4">
                        </div>
                        <div class="historialc">
                            <h4 class="card-title">Historial: </h4>
                            <table class="table table-sm text-black bg-default h-100">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Bayes Si</th>
                                        <th scope="col">Bayes No</th>
                                        <th scope="col">Arbol Si</th>
                                        <th scope="col">Arbol No</th>
                                        <th scope="col">Fecha de Registro</th>
                                        <th scope="col">Resultado Bayes</th>
                                        <th scope="col">Resultado Arbol</th>
                                    </tr>
                                </thead>
                                <%
                                    Iterator<Probabilidad> iter2 = list.iterator();
                                    while (iter2.hasNext()) {
                                        prob = iter2.next();
                                        histo = daoh.listar(prob.getId());
                                %>
                                <tbody>
                                    <tr scope="row">
                                        <td><%= prob.getId()%></td>
                                        <td><%= prob.getBayessi()%></td>
                                        <td><%= prob.getBayesno()%></td>
                                        <td><%= prob.getArbolsi()%></td>
                                        <td><%= prob.getArbolno()%></td>
                                        <td><%= prob.getFechareg()%></td>
                                        <td><%=histo.getBayes()%></td>
                                        <td><%=histo.getArbol()%></td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                            <a class="btn btn-danger" href="ControladorReporte?action=probabilidad&idvivienda=<%=v.getId()%>" target="_blank" role="button"><i class="far fa-file-pdf fa-lg"></i> Generar PDF de Historial</a>
                            <hr class="my-4">
                        </div>
                        <div class="recomendacionc">
                            <h4 class="card-title">Recomendación: </h4>
                            <hr class="my-4">
                            <p><strong>Descripción: </strong></p>
                            <p><%if(recomen.getRecomendacion()!=null){%>
                               <%=recomen.getRecomendacion()%>
                               <%}%>
                            </p>
                            <a class="btn btn-danger" href="ControladorReporte?action=probabilidad&idvivienda=<%=v.getId()%>" target="_blank" role="button"><i class="far fa-file-pdf fa-lg"></i> Generar PDF de Recomendación</a>
                            <hr class="my-4">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<% if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }%>