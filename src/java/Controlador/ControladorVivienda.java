/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Vivienda;
import Modelo.ViviendaDAO;
import java.io.IOException;
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
public class ControladorVivienda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String listar = "ViviendaCRUD/listar.jsp";
    String agregar = "ViviendaCRUD/agregar.jsp";
    String editar = "ViviendaCRUD/editar.jsp";
    String probabilidad = "ViviendaCRUD/probabilidad.jsp";

    Vivienda viv = new Vivienda();
    ViviendaDAO dao = new ViviendaDAO();

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

        String[] material = new String[6];
        material[0] = "Tabique, ladrillo, tabicón, block, concreto monolítico, piedra o cemento (incluye cantera)";
        material[1] = "Madera o adobe";
        material[2] = "Panel de concreto o tabla roca";
        material[3] = "Lámina metálica, fibra de vidrio, plástico, mica o asbesto";
        material[4] = "Cartón, hule, tela, llantas, lámina de cartón, carrizo, bambú, palma o tejamaní, embarro o bajareque";
        material[5] = "Otro";
        String acceso = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("agregar")) {
            acceso = agregar;
        } else if (action.equalsIgnoreCase("Agregarlo")) {

            String material_pared = "";
            String material_techo = "";
            String drenaje = "";

            switch (Integer.parseInt(request.getParameter("txtmaterial_pared"))) {
                case 1:
                    material_pared = material[0];
                    break;
                case 2:
                    material_pared = material[1];
                    break;
                case 3:
                    material_pared = material[2];
                    break;
                case 4:
                    material_pared = material[3];
                    break;
                case 5:
                    material_pared = material[4];
                    break;
                case 6:
                    material_pared = material[5];
                    break;
                default:
                    break;
            }

            switch (Integer.parseInt(request.getParameter("txtmaterial_techo"))) {
                case 1:
                    material_techo = material[0];
                    break;
                case 2:
                    material_techo = material[1];
                    break;
                case 3:
                    material_techo = material[2];
                    break;
                case 4:
                    material_techo = material[3];
                    break;
                case 5:
                    material_techo = material[4];
                    break;
                case 6:
                    material_techo = material[5];
                    break;
                default:
                    break;
            }

            if (Integer.parseInt(request.getParameter("txtdrenaje")) == 1) {
                drenaje = "Sí";
            } else {
                drenaje = "No";
            }

            String material_piso = request.getParameter("txtmaterial_piso");
            String acabado_pared = request.getParameter("txtacabado_pared");
            String tipo_sanitario = request.getParameter("txttipo_sanitario");
            String familiar_idfamiliar = request.getParameter("txtfamiliar_idfamiliar");
            viv.setMaterial_piso(material_piso);
            viv.setMaterial_pared(material_pared);
            viv.setAcabado_pared(acabado_pared);
            viv.setMaterial_techo(material_techo);
            viv.setTipo_sanitario(tipo_sanitario);
            viv.setDrenaje(drenaje);
            viv.setFamiliar_idfamiliar(Integer.parseInt(familiar_idfamiliar));
            if (dao.agregar(viv)) {
                response.getWriter().print('1');
            } else {
                response.getWriter().print('0');
            }
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idviv", request.getParameter("id"));
            acceso = editar;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            String material_pared = "";
            String material_techo = "";
            String drenaje = "";

            switch (Integer.parseInt(request.getParameter("txtmaterial_pared"))) {
                case 1:
                    material_pared = material[0];
                    break;
                case 2:
                    material_pared = material[1];
                    break;
                case 3:
                    material_pared = material[2];
                    break;
                case 4:
                    material_pared = material[3];
                    break;
                case 5:
                    material_pared = material[4];
                    break;
                case 6:
                    material_pared = material[5];
                    break;
                default:
                    break;
            }

            switch (Integer.parseInt(request.getParameter("txtmaterial_techo"))) {
                case 1:
                    material_techo = material[0];
                    break;
                case 2:
                    material_techo = material[1];
                    break;
                case 3:
                    material_techo = material[2];
                    break;
                case 4:
                    material_techo = material[3];
                    break;
                case 5:
                    material_techo = material[4];
                    break;
                case 6:
                    material_techo = material[5];
                    break;
                default:
                    break;
            }

            if (Integer.parseInt(request.getParameter("txtdrenaje")) == 1) {
                drenaje = "Sí";
            } else {
                drenaje = "No";
            }

            int id = Integer.parseInt(request.getParameter("txtid"));
            String material_piso = request.getParameter("txtmaterial_piso");
            String acabado_pared = request.getParameter("txtacabado_pared");
            String tipo_sanitario = request.getParameter("txttipo_sanitario");
            String familiar_idfamiliar = request.getParameter("txtfamiliar_idfamiliar");
            viv.setId(id);
            viv.setMaterial_piso(material_piso);
            viv.setMaterial_pared(material_pared);
            viv.setAcabado_pared(acabado_pared);
            viv.setMaterial_techo(material_techo);
            viv.setTipo_sanitario(tipo_sanitario);
            viv.setDrenaje(drenaje);
            viv.setFamiliar_idfamiliar(Integer.parseInt(familiar_idfamiliar));
            if (dao.editar(viv)) {
                response.getWriter().print('1');
            } else {
                response.getWriter().print('0');
            }
        } else if (action.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            viv.setId(id);
            dao.eliminar(id);
            acceso = listar;
        } else if (action.equalsIgnoreCase("probabilidad")) {
            request.setAttribute("idviv", request.getParameter("id"));
            acceso = probabilidad;
        } else if (action.equalsIgnoreCase("generar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            viv.setId(id);
            if (dao.generar(id)) {
                System.out.println("Se genero");
            } else {
                System.out.println("No se genero");
            }

            request.setAttribute("idviv", request.getParameter("id"));
            acceso = probabilidad;
        }

        if (action.equalsIgnoreCase("Agregarlo") || action.equalsIgnoreCase("Actualizar")) {
            ///////////////////////////////
        } else {
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
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
