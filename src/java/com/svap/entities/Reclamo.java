/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author personal
 */
@Entity
@Table(name = "reclamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reclamo.findAll", query = "SELECT r FROM Reclamo r"),
    @NamedQuery(name = "Reclamo.findByIdReclamo", query = "SELECT r FROM Reclamo r WHERE r.idReclamo = :idReclamo"),
    @NamedQuery(name = "Reclamo.findByDescripcionReclamo", query = "SELECT r FROM Reclamo r WHERE r.descripcionReclamo = :descripcionReclamo"),
    @NamedQuery(name = "Reclamo.findByNivelGravedadReclamo", query = "SELECT r FROM Reclamo r WHERE r.nivelGravedadReclamo = :nivelGravedadReclamo"),
    @NamedQuery(name = "Reclamo.findByFecha", query = "SELECT r FROM Reclamo r WHERE r.fecha = :fecha")})
public class Reclamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReclamo")
    private Integer idReclamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcionReclamo")
    private String descripcionReclamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nivelGravedadReclamo")
    private String nivelGravedadReclamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuariosIdusuarios;

    public Reclamo() {
    }

    public Reclamo(Integer idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Reclamo(Integer idReclamo, String descripcionReclamo, String nivelGravedadReclamo, Date fecha) {
        this.idReclamo = idReclamo;
        this.descripcionReclamo = descripcionReclamo;
        this.nivelGravedadReclamo = nivelGravedadReclamo;
        this.fecha = fecha;
    }

    public Integer getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Integer idReclamo) {
        this.idReclamo = idReclamo;
    }

    public String getDescripcionReclamo() {
        return descripcionReclamo;
    }

    public void setDescripcionReclamo(String descripcionReclamo) {
        this.descripcionReclamo = descripcionReclamo;
    }

    public String getNivelGravedadReclamo() {
        return nivelGravedadReclamo;
    }

    public void setNivelGravedadReclamo(String nivelGravedadReclamo) {
        this.nivelGravedadReclamo = nivelGravedadReclamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idReclamo != null ? idReclamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamo)) {
            return false;
        }
        Reclamo other = (Reclamo) object;
        if ((this.idReclamo == null && other.idReclamo != null) || (this.idReclamo != null && !this.idReclamo.equals(other.idReclamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.Reclamo[ idReclamo=" + idReclamo + " ]";
    }
    
}
