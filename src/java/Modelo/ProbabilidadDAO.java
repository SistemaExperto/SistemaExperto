/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class ProbabilidadDAO {

    /*Variables para la conexión con la base de datos*/
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*Declaracion de varible tipo probabilidad para relizar las operaciones*/
    Probabilidad proba = new Probabilidad();

    public List listar(int idvivienda) {
        /*Lista para ir guardando los registros que se encuentran en la tabla*/
        ArrayList<Probabilidad> list = new ArrayList<>();
        /*Sentencia para realizar consulta de la tabla probabilidad*/
        String sql = "SELECT * FROM `probabilidad` WHERE vivienda_idvivienda = "+idvivienda+" ORDER by id DESC";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Bucle while que permite recorrer el resultado de la consulta
            guardando los registros obtenidos en la lista*/
            while (rs.next()) {
                Probabilidad prob = new Probabilidad();
                prob.setId(rs.getInt("id"));
                prob.setBayessi(rs.getDouble("bayessi"));
                prob.setBayesno(rs.getDouble("bayesno"));
                prob.setArbolsi(rs.getDouble("arbolsi"));
                prob.setArbolno(rs.getDouble("arbolno"));
                prob.setFechareg(rs.getString("fecha_reg"));
                prob.setVivienda_idvivienda(rs.getInt("vivienda_idvivienda"));
                list.add(prob);
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }

        System.out.println(list);
        return list;
    }

    public boolean agregar(Probabilidad probabilidad) {

        String sql = "insert into probabilidad(bayessi, bayesno, arbolsi, "
                + "arbolno, fecha_reg, vivienda_idvivienda)values('"
                + probabilidad.getBayessi() + "','" + probabilidad.getBayesno()
                + "','" + probabilidad.getArbolsi() + "','" + probabilidad.getArbolno()
                + "','" + probabilidad.getFechareg() + "','" + probabilidad.getVivienda_idvivienda() + "')";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            historial(probabilidad.getFechareg(), probabilidad.getBayessi(), probabilidad.arbolsi);
            return true;
        } catch (Exception e) {
            System.out.println("NO SE PUDO AGREGAR PROBABILIDAD " + e);
        }
        return false;
    }

    public boolean historial(String fecha, double bayes, double arbol) {
        String bayesh = "Nada bayes";
        String arbolh = "Nada arbol";
        String recomen= "Nada recomendacion";

        if (bayes > 50.00) {
            bayesh = "Resultado positivo de contraer una enfermedad transmitida"
                    + " por vector con una probabilidad de " + bayes;
            recomen = "Es importante acudir al médico, si llega a presentar los siguientes síntomas: \n" +
"Fiebre alta, Náuseas, Vómitos, Sangren en las encías y nariz, Debilidad general, Dolor muscular y articular, "
                    + "Tos o dolor de garganta.\n" + "Para prevenir contagios: Desmaleza patios y jardines, "
                    + "Da vuelta a baldes y otros recipientes, Tapa tanques y recipientes que junten agua, "
                    + "Limpia bebederos de animales, Destapa canaletas y desagües. Elimina objetos que no uses,"
                    + " Cambia el agua de floreros.";
        } else {
            bayesh = "Resultado negativo de contraer una enfermedad transmitida"
                    + " por vector con una probabilidad de " + bayes;
            recomen = "Se recomienda: Mantener el orden, la higiene de los patios, "
                    + "terrenos y baldíos, Mantener el pasto corto, Evitar juntar agua de lluvia o, "
                    + "en caso que esto resulte indispensable no almacenarla por más de tres días cepillando "
                    + "todo el recipiente antes de recoger agua nuevamente, Cambiar el agua de los bebederos "
                    + "de animales diariamente, No dejar recipientes sin tapar en el patio, No juntar chatarra "
                    + "y Elementos en desuso.";
        }

        if (arbol > 0.00) {
            arbolh = "Resultado positivo de contraer una enfermedad transmitida"
                    + " por vector con una clasificación de Sí";
        } else {
            arbolh = "Resultado negativo de contraer una enfermedad transmitida"
                    + " por vector con una clasificación de No";
        }
        try {
            String sql5 = "SELECT COUNT(*) as total FROM probabilidad";
            con = cn.Conexion();
            ps = con.prepareStatement(sql5);
            rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt(1);
                try {
                    String sql = "insert into historial(fechareg, bayes, arbol, "
                            + "probabilidad_idprobabilidad)values('"
                            + fecha + "','" + bayesh + "','" + arbolh + "','" + num + "')";
                    ps = con.prepareStatement(sql);
                    ps.executeUpdate();
                    recomendacion(recomen);
                    return true;
                } catch (Exception e) {
                    System.out.println("NO SE PUDO AGREGAR HISTORIAL " + e);
                }
            }
        } catch (SQLException e) {
            System.out.println("NO SE PUDO AGREGAR HISTORIAL 2 " + e);
        }

        return false;
    }
    
    public boolean recomendacion(String recomen){
        try {
            String sql5 = "SELECT COUNT(*) as total FROM probabilidad";
            con = cn.Conexion();
            ps = con.prepareStatement(sql5);
            rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt(1);
                try {
                    String sql = "insert into recomendacion(descripcion,probabilidad_idprobabilidad)values('"
                            + recomen + "','" + num + "')";
                    ps = con.prepareStatement(sql);
                    ps.executeUpdate();
                    return true;
                } catch (Exception e) {
                    System.out.println("NO SE PUDO AGREGAR RECOMENDACIÓN " + e);
                }
            }
        } catch (SQLException e) {
            System.out.println("NO SE PUDO AGREGAR RECOMENDACIÓN 2 " + e);
        }
        return false;
    }
    
    public List buscarp(int idvivienda) {
        /*Lista para ir guardando los registros que se encuentran en la tabla*/
        ArrayList<Probabilidad> list = new ArrayList<>();
        /*Sentencia para realizar consulta de la tabla probabilidad*/
        String sql = "select * from probabilidad where vivienda_idvivienda=";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Bucle while que permite recorrer el resultado de la consulta
            guardando los registros obtenidos en la lista*/
            while (rs.next()) {
                Probabilidad prob = new Probabilidad();
                prob.setId(rs.getInt("id"));
                prob.setBayessi(rs.getDouble("bayessi"));
                prob.setBayesno(rs.getDouble("bayesno"));
                prob.setArbolsi(rs.getDouble("arbolsi"));
                prob.setArbolno(rs.getDouble("arbolno"));
                prob.setVivienda_idvivienda(rs.getInt("vivienda_idvivienda"));
                list.add(prob);
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }

        System.out.println(list);
        return list;
    }
}
