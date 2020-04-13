/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author marco
 */
public class HistorialDAO {
     /*Variables para la conexión con la base de datos*/
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*Declaracion de varible tipo historial para relizar las operaciones*/
    Historial histo = new Historial();
    
    public Historial listar(int idproba) {
        /*Sentencia para realizar consulta de la tabla historial*/
        String sql = "SELECT * FROM historial WHERE probabilidad_idprobabilidad="+idproba;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Bucle while que permite recorrer el resultado de la consulta
            guardando los registros obtenidos en la lista*/
            if (rs.next()) {
                histo.setId(rs.getInt("id"));
                histo.setFechareg(rs.getString("fechareg"));
                histo.setBayes(rs.getString("bayes"));
                histo.setArbol(rs.getString("arbol"));
                histo.setProbabilidad_idprobabilidad(rs.getInt("probabilidad_idprobabilidad"));
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }
        return histo;
    }
}
