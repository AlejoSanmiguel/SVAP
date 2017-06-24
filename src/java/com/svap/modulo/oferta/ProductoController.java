/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.oferta;

import com.svap.dao.ProductoFacade;
import com.svap.entities.Producto;
import com.svap.util.JsfUtil;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author personal
 */
@Named(value = "producto")
@RequestScoped
public class ProductoController {

    /**
     * Creates a new instance of ProductoController
     */
    private Integer idproducto;
    private String tipoProducto;
    private String claseProducto;
    private double valorProducto;
    
    private ArrayList<SelectItem> productos;
    
    @EJB
    private ProductoFacade productoFacade;
    
    public ProductoController() {
    }    
    
    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getClaseProducto() {
        return claseProducto;
    }

    public void setClaseProducto(String claseProducto) {
        this.claseProducto = claseProducto;
    }

    public double getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(double valorProducto) {
        this.valorProducto = valorProducto;
    }
    
    
    
    public void registrarProducto(){
        Producto p = new Producto(null,tipoProducto,claseProducto,valorProducto);
        productoFacade.create(p);
    }
    
    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(productoFacade.findAll(), true);
    }
    
    public ArrayList<SelectItem> getProductos(){
        productoFacade.getProductos();
        return (productos);
    }
    
}
