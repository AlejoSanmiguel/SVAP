/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.modulo.mensaje;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author personal
 */
public class Email {
    private final static String HOST_EMAIL_GMAIL = "smtp.gmail.com";

    private String emailRemitente;
    private String passRemitente;
    private String emailDestinatario;
    private Session session;
    private MimeMessage mimeMessage;

    public Email() {

    }

    public Email(String emailRemitente, String passRemitente, String emailDestinatario) {
        this.emailRemitente = emailRemitente;
        this.passRemitente = passRemitente;
        this.emailDestinatario = emailDestinatario;
    }

//    private void init() {
//        try {
//            Properties propiedades = new Properties();
//            propiedades.setProperty("mail.smtp.host", HOST_EMAIL_GMAIL);
//            propiedades.setProperty("mail.smtp.starttls.enable", "true");
//            propiedades.setProperty("mail.smtp.port", "25");//587 - 25 
//            propiedades.setProperty("mail.smtp.user", this.emailRemitente);
//            propiedades.setProperty("mail.smtp.auth", "true");
//            session = Session.getDefaultInstance(propiedades);
//            mimeMessage = new MimeMessage(session);
//            mimeMessage.setFrom(new InternetAddress(emailRemitente));
//            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinatario));
//        } catch (Exception ex) {
//            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    private void init2() {
        try {
            Properties propiedades = new Properties();
            propiedades.setProperty("mail.smtp.host", HOST_EMAIL_GMAIL);
            propiedades.setProperty("mail.smtp.starttls.enable", "true");
            propiedades.setProperty("mail.smtp.port", "25");//587 - 25 
            propiedades.setProperty("mail.smtp.user", this.emailRemitente);
            propiedades.setProperty("mail.smtp.auth", "true");
            
            session = Session.getDefaultInstance(propiedades);
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(emailRemitente));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinatario));
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean enviarBasic(String asunto, String contenido) {
        try {
            init2();
            mimeMessage.setSubject(asunto);
            mimeMessage.setContent(contenido, "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(emailRemitente, passRemitente);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
        }catch(MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
