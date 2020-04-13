/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.BaseDatosDAO;
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
public class ControladorBD extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    BaseDatosDAO base = new BaseDatosDAO();
    
    String exportar="RespaldoBD/exportar.jsp";
    String importar="RespaldoBD/importar.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String acceso="";
        String action=request.getParameter("action");
        String nombrebd=request.getParameter("txtnombre");
        String direccionbd=request.getParameter("txtdireccion");
        
        if(action.equalsIgnoreCase("Exportar")){
            if(base.Exportar(nombrebd)){
                response.getWriter().print('1');
            }else{
                response.getWriter().print('0');
            }
        }else if(action.equalsIgnoreCase("exportarbd")){
            acceso=exportar;
        }else if(action.equalsIgnoreCase("importarbd")){
            acceso=importar;
        }else if(action.equalsIgnoreCase("Importar")){
            if(base.Importar(direccionbd)){
                response.getWriter().print('1');
            }else{
                response.getWriter().print('0');
            }
        }
        if(action.equalsIgnoreCase("Exportar")||action.equalsIgnoreCase("Importar")){
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
