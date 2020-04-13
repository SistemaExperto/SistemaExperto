/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Usuario;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author marco
 */
public interface CRUDUsuario {
    public List listar();
    public Usuario ListarID(int id);
    public boolean agregar(Usuario usuario);
    public boolean editar(Usuario usuario);
    public boolean eliminar(int id);
    
    
}
