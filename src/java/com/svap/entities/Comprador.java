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
@Table(name = "comprador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprador.findAll", query = "SELECT c FROM Comprador c"),
    @NamedQuery(name = "Comprador.findByIdcomprador", query = "SELECT c FROM Comprador c WHERE c.idcomprador = :idcomprador"),
    @NamedQuery(name = "Comprador.findByDomicilioEmpresa", query = "SELECT c FROM Comprador c WHERE c.domicilioEmpresa = :domicilioEmpresa"),
    @NamedQuery(name = "Comprador.findByTelefonoEmpresa", query = "SELECT c FROM Comprador c WHERE c.telefonoEmpresa = :telefonoEmpresa"),
    @NamedQuery(name = "Comprador.findByNitEmpresa", query = "SELECT c FROM Comprador c WHERE c.nitEmpresa = :nitEmpresa")})
public class Comprador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomprador")
    private Integer idcomprador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "domicilio_empresa")
    private String domicilioEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "telefonoEmpresa")
    private String telefonoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nit_empresa")
    private String nitEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compradorIdcomprador", fetch = FetchType.EAGER)
    private List<Factura> facturaList;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuariosIdusuarios;

    public Comprador() {
    }

    public Comprador(Integer idcomprador) {
        this.idcomprador = idcomprador;
    }

    public Comprador(Integer idcomprador, String domicilioEmpresa, String telefonoEmpresa, String nitEmpresa) {
        this.idcomprador = idcomprador;
        this.domicilioEmpresa = domicilioEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.nitEmpresa = nitEmpresa;
    }

    public Integer getIdcomprador() {
        return idcomprador;
    }

    public void setIdcomprador(Integer idcomprador) {
        this.idcomprador = idcomprador;
    }

    public String getDomicilioEmpresa() {
        return domicilioEmpresa;
    }

    public void setDomicilioEmpresa(String domicilioEmpresa) {
        this.domicilioEmpresa = domicilioEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
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
        hash += (idcomprador != null ? idcomprador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprador)) {
            return false;
        }
        Comprador other = (Comprador) object;
        if ((this.idcomprador == null && other.idcomprador != null) || (this.idcomprador != null && !this.idcomprador.equals(other.idcomprador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.Comprador[ idcomprador=" + idcomprador + " ]";
    }
    
}
