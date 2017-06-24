/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author personal
 */
@Entity
@Table(name = "ofertatransporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfertaTransporte.findAll", query = "SELECT o FROM OfertaTransporte o"),
    @NamedQuery(name = "OfertaTransporte.findByIdtransporte", query = "SELECT o FROM OfertaTransporte o WHERE o.idtransporte = :idtransporte"),
    @NamedQuery(name = "OfertaTransporte.findByDetinoTransporte", query = "SELECT o FROM OfertaTransporte o WHERE o.detinoTransporte = :detinoTransporte"),
    @NamedQuery(name = "OfertaTransporte.findByDetallesTransporte", query = "SELECT o FROM OfertaTransporte o WHERE o.detallesTransporte = :detallesTransporte"),
    @NamedQuery(name = "OfertaTransporte.findByCalificacion", query = "SELECT o FROM OfertaTransporte o WHERE o.calificacion = :calificacion")})
public class OfertaTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransporte")
    private Integer idtransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "detinoTransporte")
    private String detinoTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "detallesTransporte")
    private String detallesTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calificacion")
    private String calificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofertaTransporteidtransporte", fetch = FetchType.EAGER)
    private List<EstadoOftrans> estadoOftransList;
    @JoinColumn(name = "productor_idProductor", referencedColumnName = "idProductor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Productor productoridProductor;

    public OfertaTransporte() {
    }

    public OfertaTransporte(Integer idtransporte) {
        this.idtransporte = idtransporte;
    }

    public OfertaTransporte(Integer idtransporte, String detinoTransporte, String detallesTransporte, String calificacion) {
        this.idtransporte = idtransporte;
        this.detinoTransporte = detinoTransporte;
        this.detallesTransporte = detallesTransporte;
        this.calificacion = calificacion;
    }

    public Integer getIdtransporte() {
        return idtransporte;
    }

    public void setIdtransporte(Integer idtransporte) {
        this.idtransporte = idtransporte;
    }

    public String getDetinoTransporte() {
        return detinoTransporte;
    }

    public void setDetinoTransporte(String detinoTransporte) {
        this.detinoTransporte = detinoTransporte;
    }

    public String getDetallesTransporte() {
        return detallesTransporte;
    }

    public void setDetallesTransporte(String detallesTransporte) {
        this.detallesTransporte = detallesTransporte;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    @XmlTransient
    public List<EstadoOftrans> getEstadoOftransList() {
        return estadoOftransList;
    }

    public void setEstadoOftransList(List<EstadoOftrans> estadoOftransList) {
        this.estadoOftransList = estadoOftransList;
    }

    public Productor getProductoridProductor() {
        return productoridProductor;
    }

    public void setProductoridProductor(Productor productoridProductor) {
        this.productoridProductor = productoridProductor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransporte != null ? idtransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaTransporte)) {
            return false;
        }
        OfertaTransporte other = (OfertaTransporte) object;
        if ((this.idtransporte == null && other.idtransporte != null) || (this.idtransporte != null && !this.idtransporte.equals(other.idtransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.OfertaTransporte[ idtransporte=" + idtransporte + " ]";
    }
    
}
