<%-- 
    Document   : Reporte2JSP
    Created on : 30/03/2020, 05:13:39 PM
    Author     : marco
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.Connection"%>
<%@page import="config.Conexion"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Conexion cn = new Conexion();
            Connection con;
            con = cn.Conexion();
            File reporte = new File (application.getRealPath("Reportes/Reporte5.jasper"));
            
            Map<String, Object> parameter = new HashMap<String, Object>();
            //parameter.put("id", 1);
            byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(), parameter, con);
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outr = response.getOutputStream();
            outr.write(bytes,0,bytes.length);
            outr.flush();
            outr.close();
        %>
    </body>
</html>