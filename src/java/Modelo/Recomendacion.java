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
public class Recomendacion {
    int id;
    String recomendacion;
    int probabilidad_idprobabilidad;

    public Recomendacion() {
    }

    public Recomendacion(int id, String recomendacion, int probabilidad_idprobabilidad) {
        this.id = id;
        this.recomendacion = recomendacion;
        this.probabilidad_idprobabilidad = probabilidad_idprobabilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public int getProbabilidad_idprobabilidad() {
        return probabilidad_idprobabilidad;
    }

    public void setProbabilidad_idprobabilidad(int probabilidad_idprobabilidad) {
        this.probabilidad_idprobabilidad = probabilidad_idprobabilidad;
    }
    
    
}
