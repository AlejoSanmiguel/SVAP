/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.oferta;

import com.svap.dao.OfertaProductoFacade;
import com.svap.entities.OfertaProducto;
import com.svap.entities.Rol;
import javax.ejb.EJB;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author personal
 */
@FacesConverter(forClass=Rol.class, value="ofertaConverter")
public class OfertaConverter implements Converter{
    
    @EJB
    private OfertaProductoFacade ofertaFacade;
    
    /**
     * Creates a new instance of OfertaConverter
     */
    public OfertaConverter() {
        ofertaFacade= CDI.current().select(OfertaProductoFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value!=null && value.length()>0) {
            return ofertaFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value!=null && value instanceof OfertaProducto) {
            OfertaProducto of = (OfertaProducto) value;
            return of.getIdOferta().toString();
        }
        return null;
    }
    
}
