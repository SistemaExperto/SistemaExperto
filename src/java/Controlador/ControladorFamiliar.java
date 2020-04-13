/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Familiar;
import Modelo.FamiliarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class ControladorFamiliar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    SimpleDateFormat formatter = new SimpleDateFormat("aaaa-mm-dd");
    
    String listar="FamiliarCRUD/listar.jsp";
    String agregar="FamiliarCRUD/agregar.jsp";
    String editar="FamiliarCRUD/editar.jsp";
    
    Familiar fam=new Familiar();
    FamiliarDAO dao=new FamiliarDAO();
    
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
        
        String[] municipios = {"Amacuzac","Atlatlahucan","Axochiapan",
            "Ayala","Coatlán del Río","Cuautla",
            "Cuernavaca","Emiliano Zapata","Huitzilac",
            "Jantetelco","Jiutepec","Jojutla",
            "Jonacatepec de Leandro Valle","Mazatepec","Miacatlán",
            "Ocuituco","Puente de Ixtla","Temixco",
            "Temoac","Tepalcingo","Tepoztlán",
            "Tetecala","Tetela del Volcán","Tlalnepantla",
            "Tlaltizapán de Zapata","Tlaquiltenango","Tlayacapan",
            "Totolapan","Xochitepec","Yautepec",
            "Yecapixtla","Zacatepec","Zacualpan de Amilpas",
            "Coatetelco","Xoxocotla","Hueyapan"};

        
        String acceso="";
        String action=request.getParameter("action");
        
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
        }else if(action.equalsIgnoreCase("agregar")){
            acceso=agregar;
        }else if(action.equalsIgnoreCase("Agregarlo")){
            String nombre=request.getParameter("txtnombre");
            String apaterno=request.getParameter("txtapaterno");
            String amaterno=request.getParameter("txtamaterno");
            String correo=request.getParameter("txtcorreo");
            String fechanac=request.getParameter("txtfechanac");
            String municipio=municipios[Integer.parseInt(request.getParameter("txtmunicipio"))-1];
            String telefono=request.getParameter("txttelefono");
            fam.setNombre(nombre);
            fam.setApaterno(apaterno);
            fam.setAmaterno(amaterno);
            fam.setCorreo(correo);
            fam.setFechaNac(fechanac);
            fam.setMunicipio(municipio);
            fam.setTelefono(telefono);
            if( dao.agregar(fam)){
                response.getWriter().print('1');
            }else{
                response.getWriter().print('0');
            }
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idfam",request.getParameter("id"));
            acceso=editar;
        }else if(action.equalsIgnoreCase("Actualizar")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String nombre=request.getParameter("txtnombre");
            String apaterno=request.getParameter("txtapaterno");
            String amaterno=request.getParameter("txtamaterno");
            String correo=request.getParameter("txtcorreo");
            String fechanac=request.getParameter("txtfechanac");
            String municipio=municipios[Integer.parseInt(request.getParameter("txtmunicipio"))-1];
            String telefono=request.getParameter("txttelefono");
            fam.setId(id);
            fam.setNombre(nombre);
            fam.setAmaterno(amaterno);
            fam.setApaterno(apaterno);
            fam.setCorreo(correo);
            fam.setFechaNac(fechanac);
            fam.setMunicipio(municipio);
            fam.setTelefono(telefono);
            if(dao.editar(fam)){
                response.getWriter().print('1');
            }else{
                response.getWriter().print('0');
            }
        }else if(action.equalsIgnoreCase("eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            fam.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        
        if(action.equalsIgnoreCase("Agregarlo")||action.equalsIgnoreCase("Actualizar")){
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
