/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.dao;

import com.svap.entities.Productor;
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
public class ProductorFacade extends AbstractFacade<Productor> {

    @PersistenceContext(unitName = "SVAPManualPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductorFacade() {
        super(Productor.class);
    }

    public Productor buscarProductor(Object id) {
        try {
            Query qNative = getEntityManager().createNativeQuery("select idproductor from productor where usuarios_idusuarios= :id;", Productor.class);
            qNative.setParameter("id", id);
            return (Productor) qNative.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
