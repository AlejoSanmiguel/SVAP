/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.oferta;

import com.svap.dao.OfertaProductoFacade;
import com.svap.dao.ProductoFacade;
import com.svap.dao.ProductorFacade;
import com.svap.entities.OfertaProducto;
import com.svap.entities.Producto;
import com.svap.entities.Productor;
import com.svap.entities.Usuario;
import com.svap.util.JsfUtil;
import com.svap.util.PaginationHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author personal
 */
@Named(value = "ofertaController")
@SessionScoped
public class OfertaController implements Serializable{

    /**
     * Creates a new instance of OfertaController
     */
    private Integer idOferta;
    private double precioOferta;
    private String detalles;
    private int cantidadProducto;
    private String foto;
    private Date fechaLimite;
    private Integer productoIdproducto;
    private String estado;

    private List<OfertaProducto> ofertas;
    private OfertaProducto ofertaSeleccionada;
    private fileUploadController fileUploadController1;
    
    @EJB
    private OfertaProductoFacade ofertaFacade;
    @EJB
    private ProductorFacade productorFacade;
    @EJB
    private ProductoFacade productoFacade;

    public OfertaController() {
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Integer getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Integer productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public OfertaProducto getOfertaSeleccionada() {
        return ofertaSeleccionada;
    }

    public void setOfertaSeleccionada(OfertaProducto ofertaSeleccionada) {
        this.ofertaSeleccionada = ofertaSeleccionada;
    }
    
    public void actualizarDatos(){
        try{
//            getOfertaSeleccionada().setCantidadProducto(cantidadProducto);
//            getOfertaSeleccionada().setDetalles(detalles);
//            getOfertaSeleccionada().setEstado(estado);
//            getOfertaSeleccionada().setFechaLimite(fechaLimite);
//            getOfertaSeleccionada().setFoto(foto);
//            getOfertaSeleccionada().setPrecioOferta(precioOferta);            
            
        ofertaFacade.edit(ofertaSeleccionada);
//            MessageUtil.enviarMensajeInformacion("form-editar", "Actualización", "Los datos del usuarios se han actualizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String prepareEdit(OfertaProducto o){
        setOfertaSeleccionada(o);
        return "editar";
    }

    public String registrarOferta() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        FacesMessage msj = new FacesMessage();
        
        try{
//            fileUploadController1.uploadFile();
//            foto = fileUploadController1.getFilePart().getName();
        OfertaProducto Of = new OfertaProducto(null, precioOferta, detalles, cantidadProducto, "link","Activa", fechaLimite);
        buscarProducto(Of);
        buscarProductor(Of);
        ofertaFacade.create(Of);
        msj = new FacesMessage(FacesMessage.SEVERITY_INFO,"Oferta registrada exitosamente",", ya es visible para compradores");
        } catch(Exception ex){
            msj = new FacesMessage(FacesMessage.SEVERITY_WARN,"No se ha podido registrar las oferta",", por favor intentelo de nuevo");
            return "";
        }
        fc.addMessage(null, msj);
        return "misofertas";
    }

    public void buscarProducto(OfertaProducto o) {
        Producto p;
        p = productoFacade.find(productoIdproducto);
        System.out.println(p);
        o.setProductoIdproducto(p);
//        if (p != null) {
//            o.setProductoIdproducto(p);
//        }else{
//            System.out.println("no encontrado :(");
//        }
    }

    public Usuario getUsuarioSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        return (Usuario) ec.getSessionMap().get("user");
    }

    public void buscarProductor(OfertaProducto o) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        FacesMessage msj = new FacesMessage();
        Productor po=null;
        
        po.setUsuariosIdusuarios(getUsuarioSesion());
        o.setProductoridProductor(po);
        System.out.println(o);
        fc.addMessage(null, msj);
    }

    public List<OfertaProducto> getOfertas() {
        ofertas = new ArrayList<>();
        ofertas = ofertaFacade.findAll();
        return ofertas;
    }
    public void eliminarOferta(){
        ofertaFacade.remove(ofertaSeleccionada);
    }    

    public String prepareView(OfertaProducto o) {
        setOfertaSeleccionada(o);
        return "/app/oferta/ver.xhtml?faces-redirect=true";
    }

    public String destroy(OfertaProducto o) {
        ofertaFacade.remove(o);
        return "misofertas";
    }
    public String update(OfertaProducto o) {
        ofertaFacade.edit(o);
        return "misofertas";
    }
    
    @PostConstruct
    public void init(){
        
    }
    
}