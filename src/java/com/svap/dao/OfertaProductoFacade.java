/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.dao;

import com.svap.entities.OfertaProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author personal
 */
@Stateless
public class OfertaProductoFacade extends AbstractFacade<OfertaProducto> {

    @PersistenceContext(unitName = "SVAPManualPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OfertaProductoFacade() {
        super(OfertaProducto.class);
    }
    
}
