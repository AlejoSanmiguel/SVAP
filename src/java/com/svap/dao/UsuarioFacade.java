/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.dao;

import com.svap.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author personal
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "SVAPManualPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario iniciarSesion(Long documento, String clave) {
        Usuario u;

        TypedQuery<Usuario> q = getEntityManager().createNamedQuery("Usuario.findLogin", Usuario.class);
        q.setParameter("doc", documento);
        q.setParameter("clv", clave);

        try {
            u = q.getSingleResult();
        } catch (Exception ex) {
            ex.getStackTrace();
            ex.getLocalizedMessage();
            u = null;
        }
        return u;
    }
    
    public String iniciarSesion2(Long documento, String clave){
        try { Query Q = getEntityManager().createNativeQuery("select primerNombre from usuarios where contraseña ='clave' and noCedula='1030690342'", Usuario.class);
        Q.setParameter(1, clave);
        Q.setParameter(2, documento);
         String u=(String) Q.getSingleResult();
        return u;
             
        } catch (Exception e) {
            e.printStackTrace();
           
        }
         return null;
    }   
}
