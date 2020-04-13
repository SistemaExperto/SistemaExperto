/*
 * Titulo: Modulo para la gestión de los familiares
 *
 * Datos de Entrada: varible tipo familiar (
    id, 
    nombre, 
    apaterno,
    amaterno,
    correo,
    fechanac,
    municipio,
    telefono )

 * Datos de Salida: varible tipo booleano (
    true,
    false )
 */
package Modelo;

/*Librerias necesarios para realizar la gestión de los familiares*/
import Interfaces.CRUDFamiliar;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 *
 */
public class FamiliarDAO implements CRUDFamiliar {
    
    /*Variables para la conexión con la base de datos*/
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*Declaracion de varible tipo familiar para relizar las operaciones*/
    Familiar f = new Familiar();
    
    
    /*El siguiente medotodo sirve para hacer una consulta a la
    base de datos y asi poder obtener todos los familiares 
    registrado, con ello se enviar al controlador para ser
    mostrados en la vista*/
    
    public Familiar ListarCorreo(String correo) {
        /*Sentencia que permite la consulta de un registro especifico*/
        String sql = "select * from familiar where correo='"+correo+"'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Se obtiene el registro encontrado y se guarda en una 
            varible tipo familiar y se retorna al controlador*/
            while (rs.next()) {
                f.setId(rs.getInt("id"));
                f.setNombre(rs.getString("nombre"));
                f.setApaterno(rs.getString("apaterno"));
                f.setAmaterno(rs.getString("amaterno"));
                f.setCorreo(rs.getString("correo"));
                f.setFechaNac(rs.getString("fechanac"));
                f.setMunicipio(rs.getString("municipio"));
                f.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }
        return f;
    }

    @Override
    public List listar() {
        /*Lista para ir guardando los registros que se encuentran en la tabla*/
        ArrayList<Familiar> list = new ArrayList<>();
        /*Sentencia para realizar consulta de la tabla familiar*/
        String sql = "select * from familiar";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Bucle while que permite recorrer el resultado de la consulta
            guardando los regirtros obtenidos en la lista*/
            while (rs.next()) {
                Familiar fam = new Familiar();
                fam.setId(rs.getInt("id"));
                fam.setNombre(rs.getString("nombre"));
                fam.setApaterno(rs.getString("apaterno"));
                fam.setAmaterno(rs.getString("amaterno"));
                fam.setCorreo(rs.getString("correo"));
                fam.setFechaNac(rs.getString("fechanac"));
                fam.setMunicipio(rs.getString("municipio"));
                fam.setTelefono(rs.getString("telefono"));
                list.add(fam);
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }

        System.out.println(list);
        return list;
    }

    @Override
    public Familiar ListarID(int id) {
        /*Sentencia que permite la consulta de un registro especifico*/
        String sql = "select * from familiar where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /*Se obtiene el registro encontrado y se guarda en una 
            varible tipo familiar y se retorna al controlador*/
            while (rs.next()) {
                f.setId(rs.getInt("id"));
                f.setNombre(rs.getString("nombre"));
                f.setApaterno(rs.getString("apaterno"));
                f.setAmaterno(rs.getString("amaterno"));
                f.setCorreo(rs.getString("correo"));
                f.setFechaNac(rs.getString("fechanac"));
                f.setMunicipio(rs.getString("municipio"));
                f.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            System.out.println("Error  " + e);
        }
        return f;
    }

    @Override
    public boolean agregar(Familiar fami) {
        /*Sentencia que permite contar los registros que se encuentran
        en la tabla familiar con un correo especifico*/
        String sql1 = "SELECT COUNT(*) as total FROM familiar WHERE "
                + "correo = '" + fami.getCorreo() + "';";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            if (rs.next()) {
                /*Se guarda el resultado en una variable tipo int*/
                int n = rs.getInt(1);
                /*Si el resultado es igual a cero se podra guardar otro
                familiar de otro modo se notifica al controlador*/
                if (n == 0) {
                    /*Sentecia para insertar un registro a la tabla familiar*/
                    String sql = "insert into familiar(nombre, apaterno, amaterno, "
                            +"correo, fechanac, municipio, telefono)values('" 
                            + fami.getNombre() + "','" + fami.getApaterno() 
                            + "','" + fami.getAmaterno() + "','" + fami.getCorreo() 
                            + "','" + fami.getFechaNac() + "','" + fami.getMunicipio() 
                            + "','" + fami.getTelefono() + "')";
                    try {
                        ps = con.prepareStatement(sql);
                        ps.executeUpdate();
                        return true;
                    } catch (Exception e) {
                        System.out.println("NO SE PUDO AGREGAR FAMILIAR " + e);
                    }
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("NO SE PUEDO AGREGAR YA EXISTE FAMILIAR " + e);
        }
        return false;
    }

    @Override
    public boolean editar(Familiar fami) {
        /*Sentecia para seleccionar el usuario con un correo especifico*/
        String sql1 = "SELECT * FROM familiar WHERE "
                + "correo='" + fami.getCorreo() + "';";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            int n = 0;
            /*Si el resulado tiene un registro la varible n cambia a 1*/
            if (rs.next()) {
                n = 1;
            }
            /*Condicional que permite editar al familiar siempre y cuando el correo se el mismo o bien
            no se encuntre un correo registrado en la tabla familiar*/
            if (n == 0 || (n == 1 && rs.getString(5).equalsIgnoreCase(fami.getCorreo()) 
                    && rs.getInt(1) == fami.getId())) {
                try {
                    /*Sentencia que permite editar los elementos de la tabla familiar*/
                    String sql = "update familiar set nombre='" + fami.getNombre() 
                            + "', apaterno='" + fami.getApaterno() 
                            + "', amaterno='" + fami.getAmaterno() 
                            + "', correo='" + fami.getCorreo() 
                            + "', fechanac='" + fami.getFechaNac() 
                            + "', municipio='" + fami.getMunicipio() 
                            + "', telefono='" + fami.getTelefono() 
                            + "' where id=" + fami.getId();
                    ps = con.prepareStatement(sql);
                    ps.executeUpdate();
                    return true;
                } catch (Exception e) {
                    System.out.println("NO SE PUDO EDITAR FAMILIAR " + e);
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
        /*Sentencia que permite eliminar un registro de la tabla familiar
        de acuerdo a su id*/
        String sql = "delete from familiar where id=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("NO SE PUDO ELIMINAR FAMILIAR " + e);
        }
        return false;
    }

}





