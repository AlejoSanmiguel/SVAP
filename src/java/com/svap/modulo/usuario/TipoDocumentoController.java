/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.usuario;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author personal
 */
@Named(value = "tipoDocumentoController")
@RequestScoped
public class TipoDocumentoController {

    /**
     * Creates a new instance of TipoDocumentoController
     */
    
    private Integer id;
    private String tipo,sigla;
    
    public TipoDocumentoController() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
}
