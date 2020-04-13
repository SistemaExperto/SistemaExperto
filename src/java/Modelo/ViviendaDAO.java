/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import Interfaces.CRUDVivienda;
import static com.lowagie.text.Annotation.URL;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import config.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletContext;
import static javax.servlet.SessionTrackingMode.URL;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import static weka.core.TechnicalInformation.Field.URL;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author marco
 */
public class ViviendaDAO implements CRUDVivienda {

    /*Variables para la conexión con la base de datos*/
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*Declaracion de varible tipo vivienda para relizar las operaciones*/
    Vivienda v = new Vivienda();

    public boolean generar(int id) {
        try {
        /*Nos permite agregar el archivo de entrenamiendo ingresando su direccion
            ConverterUtils.DataSource data = new ConverterUtils.DataSource("..\\src\\Weka\\enfermedad.arff");
            Instances instancia = data.getDataSet();*/
            BufferedReader inputReader = null;
        String rutaBruta = this.getClass().getResource("").getPath();
        System.out.println("OTRA "+rutaBruta);
        String file = rutaBruta+"enfermedad.arff";
        try {
            inputReader = new BufferedReader(new FileReader(file));
            System.out.println("SI SE ENCONTRO   " + inputReader);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro archivo 5" + file + ",ERROR " + ex.getMessage());
        }
    
    Instances instancia = new Instances(inputReader);
            /*Se asigna el numero de atributos que contiene el entrenamiento
            dado que las posiciones empiezan de 0 se obtenien los atributos y se resta 1*/
            instancia.setClassIndex(instancia.numAttributes() - 1);

            /*Clasificador Naive Bayes*/
            NaiveBayes bayes = new NaiveBayes();
            bayes.buildClassifier(instancia);
            SerializationHelper.write(rutaBruta+"bayes", bayes);
            /*Clasificador Arbol de Decisión*/
            J48 arbol = new J48();
            arbol.buildClassifier(instancia);
            SerializationHelper.write(rutaBruta+"arbol", arbol);

            Instance instance = new DenseInstance(7);
            instance.setDataset(instancia);

            Vivienda vivienda = ListarID(id);
            instance.setValue(0, "" + vivienda.getMaterial_piso().toString() + "");
            instance.setValue(1, "" + vivienda.getMaterial_pared().toString() + "");
            instance.setValue(2, "" + vivienda.getAcabado_pared().toString() + "");
            instance.setValue(3, "" + vivienda.getMaterial_techo().toString() + "");
            instance.setValue(4, "" + vivienda.getTipo_sanitario().toString() + "");
            instance.setValue(5, "" + vivienda.getDrenaje().toString() + "");
            instance.setClassMissing();

            Clasificador prueba = new Clasificador();
            String bayesr[] = prueba.Bayes(instance);
            String arbolr[] = prueba.Arbol(instance);

            ProbabilidadDAO prob = new ProbabilidadDAO();
            Probabilidad p = new Probabilidad();
            p.setBayesno(Double.parseDouble(bayesr[0]));
            p.setBayessi(Double.parseDouble(bayesr[1]));
            p.setArbolno(Double.parseDouble(arbolr[0]));
            p.setArbolsi(Double.parseDouble(arbolr[1]));

            String timeStamp = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());

            p.setFechareg(timeStamp);
            p.setVivienda_idvivienda(id);
            prob.agregar(p);
            return true;
    } catch (Exception e) {
            System.out.println("NO SE ENCUENTRA ARCHIVO " + e.getMessage());
        }
return false;
    }
    
    public Vivienda ListarIDFamiliar(int familiar_idfamiliar) {
        /*Sentencia que permite la consulta de un registro especifico*/
        String sql = "select * from vivienda where familiar_idfamiliar="+familiar_idfamiliar;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Se obtiene el registro encontrado y se guarda en una 
            varible tipo vivienda y se retorna al controlador*/
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setMaterial_piso(rs.getString("material_piso"));
                v.setMaterial_pared(rs.getString("material_pared"));
                v.setAcabado_pared(rs.getString("acabado_pared"));
                v.setMaterial_techo(rs.getString("material_techo"));
                v.setTipo_sanitario(rs.getString("tipo_sanitario"));
                v.setDrenaje(rs.getString("drenaje"));
                v.setFamiliar_idfamiliar(rs.getInt("familiar_idfamiliar"));
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }
        return v;
    }

    @Override
        public List listar() {
        /*Lista para ir guardando los registros que se encuentran en la tabla*/
        ArrayList<Vivienda> list = new ArrayList<>();
        /*Sentencia para realizar consulta de la tabla vivienda*/
        String sql = "select * from vivienda";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Bucle while que permite recorrer el resultado de la consulta
            guardando los registros obtenidos en la lista*/
            while (rs.next()) {
                Vivienda viv = new Vivienda();
                viv.setId(rs.getInt("id"));
                viv.setMaterial_piso(rs.getString("material_piso"));
                viv.setMaterial_pared(rs.getString("material_pared"));
                viv.setAcabado_pared(rs.getString("acabado_pared"));
                viv.setMaterial_techo(rs.getString("material_techo"));
                viv.setTipo_sanitario(rs.getString("tipo_sanitario"));
                viv.setDrenaje(rs.getString("drenaje"));
                viv.setFamiliar_idfamiliar(rs.getInt("familiar_idfamiliar"));
                list.add(viv);
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }

        System.out.println(list);
        return list;
    }

    @Override
        public Vivienda ListarID(int id) {
        /*Sentencia que permite la consulta de un registro especifico*/
        String sql = "select * from vivienda where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Se obtiene el registro encontrado y se guarda en una 
            varible tipo vivienda y se retorna al controlador*/
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setMaterial_piso(rs.getString("material_piso"));
                v.setMaterial_pared(rs.getString("material_pared"));
                v.setAcabado_pared(rs.getString("acabado_pared"));
                v.setMaterial_techo(rs.getString("material_techo"));
                v.setTipo_sanitario(rs.getString("tipo_sanitario"));
                v.setDrenaje(rs.getString("drenaje"));
                v.setFamiliar_idfamiliar(rs.getInt("familiar_idfamiliar"));
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }
        return v;
    }

    @Override
        public boolean agregar(Vivienda vivienda) {

        String sql = "insert into vivienda(material_piso, material_pared, acabado_pared, "
                + "material_techo, tipo_sanitario, drenaje, familiar_idfamiliar)values('"
                + vivienda.getMaterial_piso() + "','" + vivienda.getMaterial_pared()
                + "','" + vivienda.getAcabado_pared() + "','" + vivienda.getMaterial_techo()
                + "','" + vivienda.getTipo_sanitario() + "','" + vivienda.getDrenaje()
                + "','" + vivienda.getFamiliar_idfamiliar() + "')";
        System.out.println("Lámina metálica, fibra de vidrio, plástico, mica o asbesto eeeeeeeeeeeeeeeeeeeeeeee");
        System.out.println(vivienda.getMaterial_pared());
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE PUDO AGREGAR VIVIENDA " + e);
        }
        return false;
    }

    @Override
        public boolean editar(Vivienda vivienda) {
        /*Sentencia que permite editar los elementos de la tabla familiar*/
        String sql = "update vivienda set material_piso='" + vivienda.getMaterial_piso()
                + "', material_pared='" + vivienda.getMaterial_pared()
                + "', acabado_pared='" + vivienda.getAcabado_pared()
                + "', material_techo='" + vivienda.getMaterial_techo()
                + "', tipo_sanitario='" + vivienda.getTipo_sanitario()
                + "', drenaje='" + vivienda.getDrenaje()
                + "', familiar_idfamiliar='" + vivienda.getFamiliar_idfamiliar()
                + "' where id=" + vivienda.getId();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE PUDO EDITAR VIVIENDA " + e);
        }
        return false;
    }

    @Override
        public boolean eliminar(int id) {
        /*Sentencia que permite eliminar un registro de la tabla vivienda
        de acuerdo a su id*/
        String sql = "delete from vivienda where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("NO SE PUDO ELIMINAR VIVIENDA " + e);
        }
        return false;
    }

}
