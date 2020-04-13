/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author marco
 */
public class Historial {
    int id;
    String fechareg;
    String bayes;
    String arbol;
    int probabilidad_idprobabilidad;

    public Historial() {
    }

    public Historial(int id, String fechareg, String bayes, String arbol, int probabilidad_idprobabilidad) {
        this.id = id;
        this.fechareg = fechareg;
        this.bayes = bayes;
        this.arbol = arbol;
        this.probabilidad_idprobabilidad = probabilidad_idprobabilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechareg() {
        return fechareg;
    }

    public void setFechareg(String fechareg) {
        this.fechareg = fechareg;
    }

    public String getBayes() {
        return bayes;
    }

    public void setBayes(String bayes) {
        this.bayes = bayes;
    }

    public String getArbol() {
        return arbol;
    }

    public void setArbol(String arbol) {
        this.arbol = arbol;
    }

    public int getProbabilidad_idprobabilidad() {
        return probabilidad_idprobabilidad;
    }

    public void setProbabilidad_idprobabilidad(int probabilidad_idprobabilidad) {
        this.probabilidad_idprobabilidad = probabilidad_idprobabilidad;
    }
    
    
}
