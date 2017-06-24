/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.oferta;

import com.svap.entities.OfertaProducto;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author personal
 */
@Named(value = "verOferta")
@SessionScoped
public class VerOferta implements Serializable{
    
    private OfertaProducto oferta;
    /**
     * Creates a new instance of VerOferta
     */
    public VerOferta() {
    }
    @PostConstruct
    public void init(){
    
    }

    public OfertaProducto getOferta() {
        return oferta;
    }

    public void setOferta(OfertaProducto oferta) {
        this.oferta = oferta;
    }
    
    public String verOferta(OfertaProducto o){
        this.oferta=o;
        return "/app/oferta/ver.xhtml?faces-redirect=true";
    }
}
