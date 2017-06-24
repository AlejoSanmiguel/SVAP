/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.transporte;

import com.svap.dao.OfertaTransporteFacade;
import com.svap.dao.ProductorFacade;
import com.svap.entities.OfertaProducto;
import com.svap.entities.OfertaTransporte;
import com.svap.entities.Productor;
import com.svap.entities.Usuario;
import com.svap.util.JsfUtil;
import com.svap.util.PaginationHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author personal
 */
@Named(value = "ofertaTransporteController")
@RequestScoped
public class OfertaTransporteController {

    /**
     * Creates a new instance of OfertaTransporteController
     */
    private Integer idTransporte;
    private String destino;
    private String detalles;
    private String calificacion;
    private List<OfertaTransporte> solicitudes;

    @EJB
    private OfertaTransporteFacade transporteFacade;
    @EJB
    private ProductorFacade productorFacade;

    public OfertaTransporteController() {
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String registrarSolicitud() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        FacesMessage msj = new FacesMessage();

        try {
            OfertaTransporte Of = new OfertaTransporte(null, destino, detalles, calificacion);
            buscarProductor(Of);
            transporteFacade.create(Of);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta de transporte registrada exitosamente", ", ya es visible para los transportadores.");
        } catch (Exception ex) {
            msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "No se ha podido registrar las oferta", ", por favor intentelo de nuevo" + ex.getLocalizedMessage());
            return "";
        }
        fc.addMessage(null, msj);
        return "misofertas";
    }

    public void buscarProductor(OfertaTransporte o) {
        Productor po = (Productor) getUsuarioSesion().getProductor();
        po.setUsuariosIdusuarios(getUsuarioSesion());
        o.setProductoridProductor(po);
        System.out.println(po);
    }

    public Usuario getUsuarioSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        return (Usuario) ec.getSessionMap().get("user");
    }

    public List<OfertaTransporte> getOfertas() {
        solicitudes = new ArrayList<>();
        solicitudes = transporteFacade.findAll();
        return solicitudes;
    }

    private OfertaTransporte current;
    private int selectedItemIndex;
    private DataModel items = null;
    private PaginationHelper pagination;

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return transporteFacade.count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(transporteFacade.findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    public String prepareView() {
        current = (OfertaTransporte) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String destroy(OfertaTransporte tr) {
        try {
            transporteFacade.remove(tr);
            JsfUtil.addSuccessMessage("La solicitud se ha eliminado correctamente.");
            return "missolicitudes";
        } catch (Exception e) {
            JsfUtil.addErrorMessage("No se ha podido eliminar la solicitud.");
            JsfUtil.addErrorMessage(e.getMessage());
            return null;
        }
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String prepareEdit() {
        current = (OfertaTransporte) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "editarsolicitud";
    }

    public OfertaTransporte getSelected() {
        if (current == null) {
            current = new OfertaTransporte();
            selectedItemIndex = -1;
        }
        return current;
    }

    public String update() {
        try {
            transporteFacade.edit(current);
//            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("com/svap/Language").getString("OfertatransporteUpdated"));
            return "View";
        } catch (Exception e) {
//            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("com/svap/Language").getString("PersistenceErrorOccured"));
            JsfUtil.addErrorMessage(e.getMessage());
            return null;
        }
    }
}
