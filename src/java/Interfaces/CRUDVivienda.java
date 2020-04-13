/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Vivienda;
import java.util.List;

/**
 *
 * @author marco
 */
public interface CRUDVivienda {
    public List listar();
    public Vivienda ListarID(int id);
    public boolean agregar(Vivienda vivienda);
    public boolean editar(Vivienda vivienda);
    public boolean eliminar(int id);
}
