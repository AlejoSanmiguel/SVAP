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
@Table(name = "productor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productor.findAll", query = "SELECT p FROM Productor p"),
    @NamedQuery(name = "Productor.findByIdProductor", query = "SELECT p FROM Productor p WHERE p.idProductor = :idProductor"),
    @NamedQuery(name = "Productor.findByDomicilioEmpresa", query = "SELECT p FROM Productor p WHERE p.domicilioEmpresa = :domicilioEmpresa")})
public class Productor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProductor")
    private Integer idProductor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "domicilioEmpresa")
    private String domicilioEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoridProductor", fetch = FetchType.EAGER)
    private List<OfertaTransporte> ofertaTransporteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoridProductor", fetch = FetchType.EAGER)
    private List<OfertaProducto> ofertaProductoList;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuariosIdusuarios;

    public Productor() {
    }

    public Productor(Integer idProductor) {
        this.idProductor = idProductor;
    }

    public Productor(Integer idProductor, String domicilioEmpresa) {
        this.idProductor = idProductor;
        this.domicilioEmpresa = domicilioEmpresa;
    }

    public Integer getIdProductor() {
        return idProductor;
    }

    public void setIdProductor(Integer idProductor) {
        this.idProductor = idProductor;
    }

    public String getDomicilioEmpresa() {
        return domicilioEmpresa;
    }

    public void setDomicilioEmpresa(String domicilioEmpresa) {
        this.domicilioEmpresa = domicilioEmpresa;
    }

    @XmlTransient
    public List<OfertaTransporte> getOfertaTransporteList() {
        return ofertaTransporteList;
    }

    public void setOfertaTransporteList(List<OfertaTransporte> ofertaTransporteList) {
        this.ofertaTransporteList = ofertaTransporteList;
    }

    @XmlTransient
    public List<OfertaProducto> getOfertaProductoList() {
        return ofertaProductoList;
    }

    public void setOfertaProductoList(List<OfertaProducto> ofertaProductoList) {
        this.ofertaProductoList = ofertaProductoList;
    }

    public Usuario getUsuariosIdusuarios() {
        return usuariosIdusuarios;
    }

    public void setUsuariosIdusuarios(Usuario usuariosIdusuarios) {
        this.usuariosIdusuarios = usuariosIdusuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductor != null ? idProductor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productor)) {
            return false;
        }
        Productor other = (Productor) object;
        if ((this.idProductor == null && other.idProductor != null) || (this.idProductor != null && !this.idProductor.equals(other.idProductor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.Productor[ idProductor=" + idProductor + " ]";
    }
    
}
