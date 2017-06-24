/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.usuario;

import com.svap.dao.RolFacade;
import com.svap.dao.UsuarioFacade;
import com.svap.entities.Rol;
import com.svap.entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

/**
 *
 * @author personal
 */
@Named(value = "rolController")
@ConversationScoped
public class RolController implements Serializable {

    /**
     * Creates a new instance of RolConverter
     */
    private List<Rol> roles;
    
    @EJB
    private RolFacade rolFacade;
    
    public RolController() {
    }
   
    @PostConstruct
    public void init(){
        roles= rolFacade.findAll();
    }

    public List<Rol> getRoles() {
        return roles;
    }
    
}
