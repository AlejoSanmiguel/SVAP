/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.usuario;

import com.svap.dao.UsuarioFacade;
import com.svap.entities.Rol;
import com.svap.entities.Usuario;
import com.svap.util.JsfUtil;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author personal
 */
@Stateless
public class SessionRule {

    /**
     * Creates a new instance of SessionRule
     */
    @EJB
    private UsuarioFacade usFacade;
    
    public Usuario iniciar(Long documento, String clave){
        Usuario u = null;
        if (documento != null && documento >0 && clave != null && clave.length()>0) {
            u = usFacade.iniciarSesion(documento, clave);
            if (u != null) {
                if (u.getEstado() ==2) {
                    u = null;
                    JsfUtil.addErrorMessage("Usuario bloqueado, contacte con el administrador.");
                }
            }else{
                JsfUtil.addErrorMessage("Datos incorrectos, documento y/o clave invalidos.");
            }
        }else{
            JsfUtil.addErrorMessage("Datos obligatorio.");
        }
        return u;
    }
    
    public Rol validarRol(Usuario u){
        System.out.println(u.getRoles().get(0).getNombre());
        Rol r= null;
        if (u.getRoles() != null && u.getRoles().size()>0) {
            r= u.getRoles().get(0);
        }else{
            JsfUtil.addErrorMessage("Rol no asignado dirijase a perfil e ingrese los datos solicitados.");
        }
        return r;
    }
    
}
