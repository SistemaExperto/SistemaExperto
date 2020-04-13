/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class ControladorReporte extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String menu="Reportes.jsp";
    String reporte1="Reportes/Reporte1JSP.jsp";
    String reporte2="Reportes/Reporte2JSP.jsp";
    String reporte3="Reportes/Reporte3JSP.jsp";
    String reporte4="Reportes/Reporte4JSP.jsp";
    String reporte5="Reportes/Reporte5JSP.jsp";
    String probabilidad="Reportes/ProbabilidadJSP.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String acceso="";
        String action=request.getParameter("action");
        
        if(action.equalsIgnoreCase("menu")){
            acceso=menu;
        }else if(action.equalsIgnoreCase("reporte1")){
            acceso=reporte1;
        }else if(action.equalsIgnoreCase("reporte2")){
            acceso=reporte2;
        }else if(action.equalsIgnoreCase("reporte3")){
            acceso=reporte3;
        }else if(action.equalsIgnoreCase("reporte4")){
            acceso=reporte4;
        }else if(action.equalsIgnoreCase("reporte5")){
            acceso=reporte5;
        }else if(action.equalsIgnoreCase("probabilidad")){
            String idvivienda=request.getParameter("idvivienda");
            response.sendRedirect(probabilidad+"?idvivienda="+idvivienda);
        }
        
        if(action.equalsIgnoreCase("reporte")||action.equalsIgnoreCase("Actualizar")||action.equalsIgnoreCase("probabilidad")){
            ///////////////////////////////
        }else{
            RequestDispatcher vista=request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
