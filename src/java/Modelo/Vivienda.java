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
public class Vivienda {
    int id;
    String material_piso;
    String material_pared;
    String acabado_pared;
    String material_techo;
    String tipo_sanitario;
    String drenaje;
    int familiar_idfamiliar;

    public Vivienda() {
    }

    public Vivienda(int id, String material_piso, String material_pared, String acabado_pared, String material_techo, String tipo_sanitario, String drenaje, int familiar_idfamiliar) {
        this.id = id;
        this.material_piso = material_piso;
        this.material_pared = material_pared;
        this.acabado_pared = acabado_pared;
        this.material_techo = material_techo;
        this.tipo_sanitario = tipo_sanitario;
        this.drenaje = drenaje;
        this.familiar_idfamiliar = familiar_idfamiliar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial_piso() {
        return material_piso;
    }

    public void setMaterial_piso(String material_piso) {
        this.material_piso = material_piso;
    }

    public String getMaterial_pared() {
        return material_pared;
    }

    public void setMaterial_pared(String material_pared) {
        this.material_pared = material_pared;
    }

    public String getAcabado_pared() {
        return acabado_pared;
    }

    public void setAcabado_pared(String acabado_pared) {
        this.acabado_pared = acabado_pared;
    }

    public String getMaterial_techo() {
        return material_techo;
    }

    public void setMaterial_techo(String material_techo) {
        this.material_techo = material_techo;
    }

    public String getTipo_sanitario() {
        return tipo_sanitario;
    }

    public void setTipo_sanitario(String tipo_sanitario) {
        this.tipo_sanitario = tipo_sanitario;
    }

    public String getDrenaje() {
        return drenaje;
    }

    public void setDrenaje(String drenaje) {
        this.drenaje = drenaje;
    }

    public int getFamiliar_idfamiliar() {
        return familiar_idfamiliar;
    }

    public void setFamiliar_idfamiliar(int familiar_idfamiliar) {
        this.familiar_idfamiliar = familiar_idfamiliar;
    }
    
    
    

}
