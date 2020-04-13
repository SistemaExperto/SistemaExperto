/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author marco
 */
public class Probabilidad {
    int id;
    double bayessi;
    double bayesno;
    double arbolsi;
    double arbolno;
    String fechareg;
    int vivienda_idvivienda;

    public Probabilidad() {
    }

    public Probabilidad(int id, double bayessi, double bayesno, double arbolsi, double arbolno, String fechareg, int vivienda_idvivienda) {
        this.id = id;
        this.bayessi = bayessi;
        this.bayesno = bayesno;
        this.arbolsi = arbolsi;
        this.arbolno = arbolno;
        this.fechareg = fechareg;
        this.vivienda_idvivienda = vivienda_idvivienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBayessi() {
        return bayessi;
    }

    public void setBayessi(double bayessi) {
        this.bayessi = bayessi;
    }

    public double getBayesno() {
        return bayesno;
    }

    public void setBayesno(double bayesno) {
        this.bayesno = bayesno;
    }

    public double getArbolsi() {
        return arbolsi;
    }

    public void setArbolsi(double arbolsi) {
        this.arbolsi = arbolsi;
    }

    public double getArbolno() {
        return arbolno;
    }

    public void setArbolno(double arbolno) {
        this.arbolno = arbolno;
    }

    public String getFechareg() {
        return fechareg;
    }

    public void setFechareg(String fechareg) {
        this.fechareg = fechareg;
    }

    public int getVivienda_idvivienda() {
        return vivienda_idvivienda;
    }

    public void setVivienda_idvivienda(int vivienda_idvivienda) {
        this.vivienda_idvivienda = vivienda_idvivienda;
    }

    
    
    
}
