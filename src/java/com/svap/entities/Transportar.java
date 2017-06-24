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
@Table(name = "transportar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportar.findAll", query = "SELECT t FROM Transportar t"),
    @NamedQuery(name = "Transportar.findByIdTransportar", query = "SELECT t FROM Transportar t WHERE t.idTransportar = :idTransportar"),
    @NamedQuery(name = "Transportar.findByCalificacion", query = "SELECT t FROM Transportar t WHERE t.calificacion = :calificacion")})
public class Transportar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransportar")
    private Integer idTransportar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calificacion")
    private String calificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportaridTransportar", fetch = FetchType.EAGER)
    private List<Factura> facturaList;
    @JoinColumn(name = "estadoOfTrans_idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoOftrans estadoOfTransidestado;

    public Transportar() {
    }

    public Transportar(Integer idTransportar) {
        this.idTransportar = idTransportar;
    }

    public Transportar(Integer idTransportar, String calificacion) {
        this.idTransportar = idTransportar;
        this.calificacion = calificacion;
    }

    public Integer getIdTransportar() {
        return idTransportar;
    }

    public void setIdTransportar(Integer idTransportar) {
        this.idTransportar = idTransportar;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public EstadoOftrans getEstadoOfTransidestado() {
        return estadoOfTransidestado;
    }

    public void setEstadoOfTransidestado(EstadoOftrans estadoOfTransidestado) {
        this.estadoOfTransidestado = estadoOfTransidestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransportar != null ? idTransportar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportar)) {
            return false;
        }
        Transportar other = (Transportar) object;
        if ((this.idTransportar == null && other.idTransportar != null) || (this.idTransportar != null && !this.idTransportar.equals(other.idTransportar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.Transportar[ idTransportar=" + idTransportar + " ]";
    }
    
}
