/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.dao;

import com.svap.entities.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author personal
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "SVAPManualPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    public List<Producto> productos(){
        Query qNative = getEntityManager().createNativeQuery("select p.idproducto from producto p;", Producto.class);
        List<Producto> p = qNative.getResultList();
        return p ;
    }
    
    public ArrayList<SelectItem> getProductos(){
        ArrayList<SelectItem> productos = new ArrayList<SelectItem>(0);
        Query q=em.createNativeQuery("select idproducto from producto;");
        
        for (Producto p :(List<Producto>)q.getResultList()) {
            productos.add(new SelectItem(p.getIdproducto(),p.getTipoProducto()));
        }
        return (productos);
    }
    
}
