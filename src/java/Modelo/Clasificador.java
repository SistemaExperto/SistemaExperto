/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DecimalFormat;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.SerializationHelper;
import weka.core.Instance;

/**
 *
 * @author marco
 */
public class Clasificador {

    DecimalFormat decimal = new DecimalFormat("#.00");
    String[] clasifica = {"No", "Sí"};
    String rutaBruta = this.getClass().getResource("").getPath();
    
    public String[] Bayes(Instance I) {
        String result[] = {"", "", ""};
        try {
            /*Se lee el archivo temporal que contiene el entrenamiento de bayes*/
            NaiveBayes pruebabayes = (NaiveBayes) SerializationHelper.read(rutaBruta+"bayes");
            
            /*Se clasifica la instancia obtenida por parametro*/
            double resultado = pruebabayes.classifyInstance(I);
            double[] porcentajes = pruebabayes.distributionForInstance(I);
            
            /*Se obtienen los resultados y se guradan en un arreglo*/
            double resultado1 = porcentajes[0] * 100;
            double resultado2 = porcentajes[1] * 100;
            
            /*Se imprimien los resultados*/
            String aux = clasifica[(int) resultado];
            System.out.println("Clasificación: " + aux);
            System.out.println("Resultado1: " + decimal.format(resultado1));
            System.out.println("Resultado2: " + decimal.format(resultado2));

            result[0] = decimal.format(resultado1);
            result[1] = decimal.format(resultado2);
            result[2] = aux;

        } catch (Exception e) {
            System.out.println("Error BAYES "+e.getMessage());
        }
        /*Se retorna el arreglo con los resultados*/
        return result;
    }

    public String[] Arbol(Instance I) {
        String result[] = {"", "", ""};
        try {
            /*Se lee el archivo temporal que contiene el entrenamiento del arbol*/
            J48 pruebabayes = (J48) SerializationHelper.read(rutaBruta+"arbol");
            
            /*Se clasifica la instancia obtenida por parametro*/
            double resultado = pruebabayes.classifyInstance(I);
            double[] porcentajes = pruebabayes.distributionForInstance(I);
            
            /*Se obtienen los resultados y se guradan en un arreglo*/
            double resultado1 = porcentajes[0] * 100;
            double resultado2 = porcentajes[1] * 100;
            
            /*Se imprimien los resultados*/
            String aux = clasifica[(int) resultado];
            System.out.println("Clasificación: " + aux);
            System.out.println("Resultado1: " + decimal.format(resultado1));
            System.out.println("Resultado2: " + decimal.format(resultado2));

            result[0] = decimal.format(resultado1);
            result[1] = decimal.format(resultado2);
            result[2] = aux;

        } catch (Exception e) {
            System.out.println("Error ARBOL "+e.getMessage());
        }
        /*Se retorna el arreglo con los resultados*/
        return result;
    }
}
