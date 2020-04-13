/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.CRUDUsuario;
import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author marco
 */
public class UsuarioDAO implements CRUDUsuario {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    Conexion cn2 = new Conexion();
    Connection con2;
    PreparedStatement ps2;
    ResultSet rs2;
    Usuario u = new Usuario();

    public Usuario validar(String correo, String contra) {
        Usuario user = new Usuario();
        System.out.println(correo + contra);
        String contraen = DigestUtils.shaHex(contra);
        String sql = "select * from usuario where correo=? and contra=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contraen);
            rs = ps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setCorreo(rs.getString("correo"));
                user.setContra(rs.getString("contra"));
                user.setNombre(rs.getString("nombre"));
                user.setApaterno(rs.getString("apaterno"));
                user.setAmaterno(rs.getString("amaterno"));
                user.setEstado(rs.getString("estado"));
                user.setFechaNac(rs.getString("fechanac"));
                user.setTelefono(rs.getString("telefono"));
                user.setTipo(rs.getString("tipo"));
            }
        } catch (Exception e) {
            System.out.println(" Error, No se encuentra usuario");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {

            }
        }
        return user;
    }

    public boolean Existe(String correo) {
        String sql = "Select * from usuario where correo='" + correo + "'";
        System.out.println(correo);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error en el existe " + e);
        }
        return false;
    }

    public boolean Restablecer(Usuario usu) {
        String contraen = DigestUtils.shaHex(usu.getContra());
        System.out.println("Restablecer correo:" + usu.getCorreo());
        System.out.println("Restablecer contra:" + usu.getContra());
        System.out.println("Restablecer contraen:" + contraen);

        String sql =("update usuario set contra='" + contraen + "' where correo='"+usu.getCorreo().toString()+"'");
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE PUEDO RESTABLECER CONTRASEÑA DE USUARIO " + e);
        }
        return false;
    }

    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "select * from usuario";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApaterno(rs.getString("apaterno"));
                usu.setAmaterno(rs.getString("amaterno"));
                usu.setCorreo(rs.getString("correo"));
                usu.setContra(rs.getString("contra"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setFechaNac(rs.getString("fechanac"));
                usu.setTipo(rs.getString("tipo"));
                usu.setEstado(rs.getString("estado"));
                list.add(usu);
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }

        System.out.println(list);
        return list;
    }

    @Override
    public Usuario ListarID(int id) {
        String sql = "select * from usuario where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApaterno(rs.getString("apaterno"));
                u.setAmaterno(rs.getString("amaterno"));
                u.setCorreo(rs.getString("correo"));
                u.setContra(rs.getString("contra"));
                u.setTelefono(rs.getString("telefono"));
                u.setFechaNac(rs.getString("fechanac"));
                u.setTipo(rs.getString("tipo"));
                u.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }
        return u;
    }

    @Override
    public boolean agregar(Usuario usu) {
        String contraen = DigestUtils.shaHex(usu.getContra());

        String sql1 = "SELECT COUNT(*) as total FROM usuario WHERE "
                + "correo = '" + usu.getCorreo() + "';";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            if (rs.next()) {
                int n = rs.getInt(1);
                if (n == 0) {
                    String sql = "insert into usuario(nombre, apaterno, amaterno, correo, contra, telefono, fechanac, tipo, estado)values('" + usu.getNombre() + "','" + usu.getApaterno() + "','" + usu.getAmaterno() + "','" + usu.getCorreo() + "','" + contraen + "','" + usu.getTelefono() + "','" + usu.getFechaNac() + "','" + usu.getTipo() + "','" + usu.getEstado() + "')";
                    try {
                        ps = con.prepareStatement(sql);
                        ps.executeUpdate();
                        return true;
                    } catch (Exception e) {
                        System.out.println("NO SE PUEDO AGREGAR USUARIO " + e);
                    }
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("NO SE PUEDO AGREGAR YA EXISTE USUARIO " + e);
        }
        return false;
    }

    @Override
    public boolean editar(Usuario usu) {
        //String contraen = DigestUtils.shaHex(usu.getContra());

        String sql1 = "SELECT * FROM usuario WHERE "
                + "correo='" + usu.getCorreo() + "';";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            int n = 0;
            if (rs.next()) {
                n = 1;
            }
            if (n == 0 || (n == 1 && rs.getString(5).equalsIgnoreCase(usu.getCorreo()) && rs.getInt(1)==usu.getId())) {
                try {
                    String sql = "update usuario set nombre='" + usu.getNombre() + "', apaterno='" + usu.getApaterno() + "', amaterno='" + usu.getAmaterno() + "', correo='" + usu.getCorreo() + "', telefono='" + usu.getTelefono() + "', fechanac='" + usu.getFechaNac() + "', tipo='" + usu.getTipo() + "', estado='" + usu.getEstado() + "' where id=" + usu.getId();
                    ps = con.prepareStatement(sql);
                    ps.executeUpdate();
                    return true;
                } catch (Exception e) {
                    System.out.println("NO SE PUDO EDITAR USUARIO " + e);
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("NO SE PUDO EDITAR YA EXISTE USUARIO " + e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from usuario where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("NO SE PUEDO ELIMINAR USUARIO " + e);
        }
        return false;
    }

}
