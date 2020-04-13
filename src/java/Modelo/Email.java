/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author marco
 */
public class Email {
    
    
    public boolean enviarCorreo(String para){
        boolean enviado= false;
        
        String de = "sistemaexpertoseguridad@gmail.com";
        String clave = "sistema15";
    
        try{
           String host = "smtp.gmail.com";
           Properties prop = System.getProperties();
           prop.put("mail.smtp.starttls.enable", "true");
           prop.put("mail.smtp.host", host);
           prop.put("mail.smtp.user", de);
           prop.put("mail.smtp.password", clave);
           prop.put("mail.smtp.port", 587);
           prop.put("mail.smtp.auth", "true");
           
           Session sesion = Session.getDefaultInstance(prop, null);
           
           MimeMessage message = new MimeMessage(sesion);
           
           message.setFrom(new InternetAddress(de));
           
           /**/
           
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
           
           message.setSubject("Recuperar Contraseña - Sistema Experto");
           message.setText("<strong>Hola, </strong><br>"
                    +"Estás recibiendo este correo porque hiciste una solicitud de recuperación de contraseña para tu cuenta.<br><br>"
                    +"<a style=\'text-decoration: none; color: #ffffff; padding: 10px; font-size: 20px; font-weight: 600; background-color: #1883ba; border-radius: 6px;\' href=\'http://localhost:8080/SistemaExperto/RecuperarC/Restablecer.jsp?email="+para+"\'>Recuperar Contraseña</a><br><br>"
                    +"Si no realizaste esta solicitud, no se requiere realizar ninguna otra acción.<br><br>"
                    +"Saludos, Sistema Experto.<br><br>"                                          
                    +"<i>Si no puedes acceder por medio del botÃ³n da clic al siguiente enlace.  <i> http://localhost:8080/SistemaExperto/RecuperarC/Restablecer.jsp?email="+para,"ISO-8859-1","html");
           
           Transport transport = sesion.getTransport("smtp");
           transport.connect(host,de,clave);
           transport.sendMessage(message, message.getAllRecipients());
           transport.close();
           
           enviado = true;
           
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return enviado;
    }
}
