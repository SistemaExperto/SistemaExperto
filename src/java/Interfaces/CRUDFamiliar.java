/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Familiar;
import java.util.List;

/**
 *
 * @author marco
 */
public interface CRUDFamiliar {
    public List listar();
    public Familiar ListarID(int id);
    public boolean agregar(Familiar familiar);
    public boolean editar(Familiar familiar);
    public boolean eliminar(int id);
}
