///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.svap.modulo.correo;
////import com.empresa.entities.Mensaje;
//import com.em.entities.Usuario;
//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
//
///**
// *
// * @author personal
// */
//@Named(value = "mensajeController")
//@SessionScoped
//public class mensajeController implements Serializable {
//
//    /**
//     * Creates a new instance of mensajeController
//     */
//    private String correo, contrasena,destinatario, mensaje, asunto;
//    
//    private List<Mensaje> mensajes;
//    @EJB
//    private MensajeFacade msFacade;
//    public mensajeController() {
//    }
//
//    public String getCorreo() {
//        return correo;
//    }
//
//    public void setCorreo(String correo) {
//        this.correo = correo;
//    }
//
//    public String getContrasena() {
//        return contrasena;
//    }
//
//    public void setContrasena(String contrasena) {
//        this.contrasena = contrasena;
//    }
//
//    public String getDestinatario() {
//        return destinatario;
//    }
//
//    public void setDestinatario(String destinatario) {
//        this.destinatario = destinatario;
//    }
//
//    public String getAsunto() {
//        return asunto;
//    }
//
//    public void setAsunto(String asunto) {
//        this.asunto = asunto;
//    }
//
//    public String getMensaje() {
//        return mensaje;
//    }
//
//    public void setMensaje(String mensaje) {
//        this.mensaje = mensaje;
//    }
//    
//    
//    public void enviarMensaje(){
//        Email email = new Email(correo,contrasena,destinatario);
//        email.enviarBasic(asunto, mensaje);
//        Mensaje ms = new Mensaje(null,destinatario,asunto,mensaje);
//        Usuario us = getUsuarioSesion();
//        ms.setTblUsuariosId(us);
//        msFacade.create(ms);
//        
//    }
//    
//    public Usuario getUsuarioSesion() {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        ExternalContext ec = fc.getExternalContext();
//        return (Usuario) ec.getSessionMap().get("user");
//    }
//    
//    
////    public static void main(String[] args) {
////       
////        Email email = new Email("Soporte.svap@gmail.com", "SvapSystem" , "fogomez22@misena.edu.co");
////        email.enviarBasic("Hola mundo", "Vea que si funciona");
////        
////    }
//
//    public List<Mensaje> getMensajes() {
//        mensajes= new ArrayList<>();
//        mensajes= msFacade.findAll();
//        return mensajes;
//    }
//    
//}
