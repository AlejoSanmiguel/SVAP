/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.usuario;

import com.svap.dao.RolFacade;
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
@FacesConverter(forClass=Rol.class, value = "rolConverter")
public class RolConverter implements Converter{
    @EJB
    private RolFacade rolFacade;
    
    public RolConverter() {
        rolFacade= CDI.current().select(RolFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length()>0) {
            return rolFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Rol) {
            Rol td= (Rol) value;
            return td.getIdroles().toString();
        }
        return null;
    }
    
}
