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
public class RecomendacionDAO {
     /*Variables para la conexión con la base de datos*/
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*Declaracion de varible tipo historial para relizar las operaciones*/
    Recomendacion recomen = new Recomendacion();
    
    public Recomendacion listar(int idproba) {
        /*Sentencia para realizar consulta de la tabla recomendacion*/
        String sql = "SELECT * FROM recomendacion WHERE probabilidad_idprobabilidad="+idproba;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Bucle while que permite recorrer el resultado de la consulta
            guardando los registros obtenidos en la lista*/
            if (rs.next()) {
                recomen.setId(rs.getInt("id"));
                recomen.setRecomendacion(rs.getString("descripcion"));
                recomen.setProbabilidad_idprobabilidad(rs.getInt("probabilidad_idprobabilidad"));
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }
        return recomen;
    }
}
