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
@Table(name = "estadooferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoOferta.findAll", query = "SELECT e FROM EstadoOferta e"),
    @NamedQuery(name = "EstadoOferta.findByIdestadoOferta", query = "SELECT e FROM EstadoOferta e WHERE e.idestadoOferta = :idestadoOferta"),
    @NamedQuery(name = "EstadoOferta.findByDescripcion", query = "SELECT e FROM EstadoOferta e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoOferta.findByEstado", query = "SELECT e FROM EstadoOferta e WHERE e.estado = :estado"),
    @NamedQuery(name = "EstadoOferta.findByFecha", query = "SELECT e FROM EstadoOferta e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EstadoOferta.findByCalificacion", query = "SELECT e FROM EstadoOferta e WHERE e.calificacion = :calificacion"),
    @NamedQuery(name = "EstadoOferta.findByComentario", query = "SELECT e FROM EstadoOferta e WHERE e.comentario = :comentario")})
public class EstadoOferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestadoOferta")
    private Integer idestadoOferta;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calificacion")
    private String calificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comentario")
    private String comentario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoOfertaidestadoOferta", fetch = FetchType.EAGER)
    private List<Factura> facturaList;
    @JoinColumn(name = "ofertaProducto_idOferta", referencedColumnName = "idOferta")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OfertaProducto ofertaProductoidOferta;

    public EstadoOferta() {
    }

    public EstadoOferta(Integer idestadoOferta) {
        this.idestadoOferta = idestadoOferta;
    }

    public EstadoOferta(Integer idestadoOferta, String descripcion, String estado, Date fecha, String calificacion, String comentario) {
        this.idestadoOferta = idestadoOferta;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Integer getIdestadoOferta() {
        return idestadoOferta;
    }

    public void setIdestadoOferta(Integer idestadoOferta) {
        this.idestadoOferta = idestadoOferta;
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

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public OfertaProducto getOfertaProductoidOferta() {
        return ofertaProductoidOferta;
    }

    public void setOfertaProductoidOferta(OfertaProducto ofertaProductoidOferta) {
        this.ofertaProductoidOferta = ofertaProductoidOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoOferta != null ? idestadoOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOferta)) {
            return false;
        }
        EstadoOferta other = (EstadoOferta) object;
        if ((this.idestadoOferta == null && other.idestadoOferta != null) || (this.idestadoOferta != null && !this.idestadoOferta.equals(other.idestadoOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.EstadoOferta[ idestadoOferta=" + idestadoOferta + " ]";
    }
    
}
