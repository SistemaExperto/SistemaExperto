/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

/**
 *
 * @author marco
 */
public class BaseDatosDAO {

    public boolean Exportar(String nombrebd) {
        
        Calendar fecha = Calendar.getInstance();
        int mes = Calendar.MONTH;
        mes = mes+1;
        String fechaHoy = fecha.get(Calendar.DATE) + "-" + mes + "-" + fecha.get(Calendar.YEAR);
        String nombre = nombrebd + fechaHoy + ".sql";
        int copia_seguridad = 0;

        /*Obtener direccion de proyecto*/
        String nombreFichero = "configbd";
        // Ruta del tipo /home/usuario/fichero
        String rutaAbsoluta = new File(nombreFichero).getAbsolutePath();
        System.out.println(rutaAbsoluta);

        /*Cambiar el simbolo \ por / para poder recorrer direccion*/
        String aux = "";
        char l = (char) 92; //92 codigo ascii del simbolo \
        for (int n = 0; n < rutaAbsoluta.length(); n++) {
            char c = rutaAbsoluta.charAt(n);
            if (c == l) {
                c = '/';
            }
            aux = aux + c;
        }
        String[] partesRuta = aux.split("/");
        /*Obtenermos el disco y usuario ademas de la carpeta descargas*/

        aux =partesRuta[0] + File.separator+partesRuta[1] + File.separator+partesRuta[2] + File.separator+"Downloads"+ File.separator;
        
        System.out.println(aux);
        
        /*partesRuta[0]+"/xampp/mysql/bin/mysqldump.exe*/
        /*aux+nombre*/

        try {
            Process runtimeProcess = Runtime.getRuntime().exec("/bin/mysqldump.exe --opt  --password=xxPvnAlQaH --user=root --databases sistemaexperto -r C:\\Users\\marco\\Downloads"+nombre);
            copia_seguridad = runtimeProcess.waitFor();
        } catch (Exception e) {
            System.out.println("ERROR EXPORTAR BD  " + e);
        }

        if (copia_seguridad == 0) {
            System.out.println("Se exporto BD");
            return true;
        } else {
            System.out.println("No se exporto BD");
        }
        
        return false;
    }
    
    public boolean Importar(String direccionbd) {
        
        /*int copia_seguridad = 0;
        
        try {
            Process runtimeProcess = Runtime.getRuntime().exec("C:/xampp/mysql/bin/mysql.exe -u root -p  < "+direccionbd);
            copia_seguridad = runtimeProcess.waitFor();
        } catch (Exception e) {
            System.out.println("ERROR IMPORTAR BD  " + e);
        }

        if (copia_seguridad == 0) {
            System.out.println("Se importo BD");
            return true;
        } else {
            System.out.println("No se importo BD");
        }*/
        
        return false;
    }
}
