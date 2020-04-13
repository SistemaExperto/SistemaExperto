/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author marco
 */
public class Conexion {
    Connection con;
    /*node53219-sistemaexperto.jl.serv.net.mx
    xxPvnAlQaH*/
    String url="jdbc:mysql://localhost:3306/sistemaexperto";
    String user="root";
    String pass="";
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
        } catch (Exception e){
            System.out.println("ERROR" + e);
        }
        System.out.println(con);
        return con;
    }
    
}
