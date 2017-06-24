/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author personal
 */
@Entity
@Table(name = "estadooftrans")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoOftrans.findAll", query = "SELECT e FROM EstadoOftrans e"),
    @NamedQuery(name = "EstadoOftrans.findByIdestado", query = "SELECT e FROM EstadoOftrans e WHERE e.idestado = :idestado"),
    @NamedQuery(name = "EstadoOftrans.findByDescripcion", query = "SELECT e FROM EstadoOftrans e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoOftrans.findByEstado", query = "SELECT e FROM EstadoOftrans e WHERE e.estado = :estado"),
    @NamedQuery(name = "EstadoOftrans.findByFecha", query = "SELECT e FROM EstadoOftrans e WHERE e.fecha = :fecha")})
public class EstadoOftrans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestado")
    private Integer idestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "ofertaTransporte_idtransporte", referencedColumnName = "idtransporte")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OfertaTransporte ofertaTransporteidtransporte;
    @JoinColumn(name = "transportador_idTransportador", referencedColumnName = "idTransportador")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Transportador transportadoridTransportador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoOfTransidestado", fetch = FetchType.EAGER)
    private List<Transportar> transportarList;

    public EstadoOftrans() {
    }

    public EstadoOftrans(Integer idestado) {
        this.idestado = idestado;
    }

    public EstadoOftrans(Integer idestado, String descripcion, String estado, Date fecha) {
        this.idestado = idestado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public OfertaTransporte getOfertaTransporteidtransporte() {
        return ofertaTransporteidtransporte;
    }

    public void setOfertaTransporteidtransporte(OfertaTransporte ofertaTransporteidtransporte) {
        this.ofertaTransporteidtransporte = ofertaTransporteidtransporte;
    }

    public Transportador getTransportadoridTransportador() {
        return transportadoridTransportador;
    }

    public void setTransportadoridTransportador(Transportador transportadoridTransportador) {
        this.transportadoridTransportador = transportadoridTransportador;
    }

    @XmlTransient
    public List<Transportar> getTransportarList() {
        return transportarList;
    }

    public void setTransportarList(List<Transportar> transportarList) {
        this.transportarList = transportarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestado != null ? idestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOftrans)) {
            return false;
        }
        EstadoOftrans other = (EstadoOftrans) object;
        if ((this.idestado == null && other.idestado != null) || (this.idestado != null && !this.idestado.equals(other.idestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.EstadoOftrans[ idestado=" + idestado + " ]";
    }
    
}
