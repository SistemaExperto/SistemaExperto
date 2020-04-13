 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Email;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class ControladorUsuario extends HttpServlet {

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
    
    String listar="UsuarioCRUD/listar.jsp";
    String agregar="UsuarioCRUD/agregar.jsp";
    String registro="UsuarioCRUD/registro.jsp";
    String editar="UsuarioCRUD/editar.jsp";
    
    Usuario usu=new Usuario();
    UsuarioDAO dao=new UsuarioDAO();
    
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
        String registros=request.getParameter("registros");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
        }else if(action.equalsIgnoreCase("agregar")){
            acceso=agregar;
        }else if(action.equalsIgnoreCase("registro")){
            acceso=registro;
        }else if(action.equalsIgnoreCase("Agregarlo")){
            String nombre=request.getParameter("txtnombre");
            String apaterno=request.getParameter("txtapaterno");
            String amaterno=request.getParameter("txtamaterno");
            String correo=request.getParameter("txtcorreo");
            String contra=request.getParameter("txtcontra");
            String telefono=request.getParameter("txttelefono");
            String fechanac=request.getParameter("txtfechanac");
            String tipo=request.getParameter("txttipo");
            String estado=request.getParameter("txtestado");
            usu.setNombre(nombre);
            usu.setAmaterno(amaterno);
            usu.setApaterno(apaterno);
            usu.setCorreo(correo);
            usu.setContra(contra);
            usu.setFechaNac(fechanac);
            usu.setTelefono(telefono);
            usu.setTipo(tipo);
            usu.setEstado(estado);
            boolean aux=dao.agregar(usu);
            if(aux){
                response.getWriter().print('1');
            }else{
                response.getWriter().print('0');
            }
            //acceso=listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idusu",request.getParameter("id"));
            acceso=editar;
        }else if(action.equalsIgnoreCase("Actualizar")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String nombre=request.getParameter("txtnombre");
            String apaterno=request.getParameter("txtapaterno");
            String amaterno=request.getParameter("txtamaterno");
            String correo=request.getParameter("txtcorreo");
            String contra=request.getParameter("txtcontra");
            String telefono=request.getParameter("txttelefono");
            String fechanac=request.getParameter("txtfechanac");
            String tipo=request.getParameter("txttipo");
            String estado=request.getParameter("txtestado");
            usu.setId(id);
            usu.setNombre(nombre);
            usu.setAmaterno(amaterno);
            usu.setApaterno(apaterno);
            usu.setCorreo(correo);
            usu.setContra(contra);
            usu.setFechaNac(fechanac);
            usu.setTelefono(telefono);
            usu.setTipo(tipo);
            usu.setEstado(estado);
            if(dao.editar(usu)){
                response.getWriter().print('1');
            }else{
                response.getWriter().print('0');
            }
        }else if(action.equalsIgnoreCase("eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            usu.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }else if(action.equalsIgnoreCase("existe")){
            String correo=request.getParameter("txtcorreo");
            usu.setCorreo(correo);
            System.out.println("existe1 "+correo);
            boolean exis = dao.Existe(correo);
            if(exis){
                Email email = new Email();
                boolean resultado = email.enviarCorreo(correo);
                System.out.println("existe "+correo);
                if(resultado){
                    response.getWriter().print('1');
                }else{
                    response.getWriter().print('2');
                }
            }else{
                response.getWriter().print('0');
            }
        }else if(action.equalsIgnoreCase("restablecer")){
            String correo=request.getParameter("txtemail");
            String contra=request.getParameter("txtcontran");
            System.out.println("controlador correo:" + correo);
            System.out.println("controlador contra:" + contra);
            Usuario usua=new Usuario();
            UsuarioDAO daou=new UsuarioDAO();
            usua.setCorreo(correo);
            usua.setContra(contra);
            if(daou.Restablecer(usua)){
                response.getWriter().print('1');
            }else{
                response.getWriter().print('0');
            }
        }
        if(action.equalsIgnoreCase("existe")||action.equalsIgnoreCase("Actualizar")||action.equalsIgnoreCase("restablecer")||registros.equalsIgnoreCase("true")||action.equalsIgnoreCase("Agregarlo")){
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
