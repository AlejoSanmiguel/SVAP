/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.usuario;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author personal
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }
    
}
