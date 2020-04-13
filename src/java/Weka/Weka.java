/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weka;

import Modelo.Vivienda;
import Modelo.ViviendaDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author marco
 */
public class Weka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        /*try {
            Nos permite agregar el archivo de entrenamiendo ingresando su direccion
            ConverterUtils.DataSource data = new ConverterUtils.DataSource("C:\\Users\\marco\\OneDrive\\Documentos\\SistemaExperto\\src\\java\\Weka\\enfermedad.arff");
            Instances instancia = data.getDataSet();
            /*Se asigna el numero de atributos que contiene el entrenamiento
            dado que las posiciones empiezan de 0 se obtenien los atributos y se resta 1
            instancia.setClassIndex(instancia.numAttributes() - 1);


            /*Clasificador Naive Bayes
            NaiveBayes bayes = new NaiveBayes();
            bayes.buildClassifier(instancia);
            SerializationHelper.write(new FileOutputStream("bayes"), bayes);

            /*Clasificador Arbol de Decisión
            J48 arbol = new J48();
            arbol.buildClassifier(instancia);
            SerializationHelper.write(new FileOutputStream("arbol"), arbol);

            System.out.println("ARCHIVO BAYES    " + bayes);
            System.out.println("ARCHIVO ARBOL    " + arbol);
            return true;
        } catch (Exception e) {
            System.out.println("NO SE ENCUENTRA ARCHIVO MENU" + e.getMessage());
        }*/
        
        /*Prueba de Bayes con vivienda*/
        /*ViviendaDAO vdao = new ViviendaDAO();
        Vivienda vivienda = new Vivienda(); 
        vivienda=vdao.ListarID(1);*/
        
        /*
        Instance instance = new DenseInstance(7);
        instance.setDataset(data);
        
        String c1="Tierra";
        String c2="Madera o adobe";
        String c3="Recubrimiento (pasta, yeso) sin pintura";
        String c4="Tabique, ladrillo, tabicón, block, concreto monolítico, piedra o cemento (incluye cantera)";
        String c5="Excusado o sanitario con conex";
        String c6="No";
        
        instance.setValue(0,c1);
        instance.setValue(1,c2);
        instance.setValue(2,c3);
        instance.setValue(3,c4);
        instance.setValue(4,c5);
        instance.setValue(5,c6);
        instance.setClassMissing();
        
        System.out.println(instance);
        Clasificador prueba = new Clasificador();
        prueba.Bayes(instance);*/
        
        /*
        System.out.println("Clasificador Naive Bayes: \n"+bayes);
        System.out.println("Clasificador Arbol de Decisión: \n"+arbol);*/
        
        /*Probar Bayes*/
        /*
        NaiveBayes pruebabayes = (NaiveBayes)SerializationHelper.read("bayes");
        J48 pruebaarbol = (J48)SerializationHelper.read("arbol");
        System.out.println(pruebabayes);
        System.out.println(pruebaarbol);*/
        
        //REPOSITORIO GIT
        System.out.println("Repositorio Sistema Experto");
    }
    
}
