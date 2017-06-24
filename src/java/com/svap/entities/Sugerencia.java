/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author personal
 */
@Entity
@Table(name = "sugerencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sugerencia.findAll", query = "SELECT s FROM Sugerencia s"),
    @NamedQuery(name = "Sugerencia.findByIdSugerencia", query = "SELECT s FROM Sugerencia s WHERE s.idSugerencia = :idSugerencia"),
    @NamedQuery(name = "Sugerencia.findByAsuntoSugerencia", query = "SELECT s FROM Sugerencia s WHERE s.asuntoSugerencia = :asuntoSugerencia"),
    @NamedQuery(name = "Sugerencia.findByDescripcionSugerencia", query = "SELECT s FROM Sugerencia s WHERE s.descripcionSugerencia = :descripcionSugerencia")})
public class Sugerencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSugerencia")
    private Integer idSugerencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "asuntoSugerencia")
    private String asuntoSugerencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "descripcionSugerencia")
    private String descripcionSugerencia;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuariosIdusuarios;

    public Sugerencia() {
    }

    public Sugerencia(Integer idSugerencia) {
        this.idSugerencia = idSugerencia;
    }

    public Sugerencia(Integer idSugerencia, String asuntoSugerencia, String descripcionSugerencia) {
        this.idSugerencia = idSugerencia;
        this.asuntoSugerencia = asuntoSugerencia;
        this.descripcionSugerencia = descripcionSugerencia;
    }

    public Integer getIdSugerencia() {
        return idSugerencia;
    }

    public void setIdSugerencia(Integer idSugerencia) {
        this.idSugerencia = idSugerencia;
    }

    public String getAsuntoSugerencia() {
        return asuntoSugerencia;
    }

    public void setAsuntoSugerencia(String asuntoSugerencia) {
        this.asuntoSugerencia = asuntoSugerencia;
    }

    public String getDescripcionSugerencia() {
        return descripcionSugerencia;
    }

    public void setDescripcionSugerencia(String descripcionSugerencia) {
        this.descripcionSugerencia = descripcionSugerencia;
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
        hash += (idSugerencia != null ? idSugerencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sugerencia)) {
            return false;
        }
        Sugerencia other = (Sugerencia) object;
        if ((this.idSugerencia == null && other.idSugerencia != null) || (this.idSugerencia != null && !this.idSugerencia.equals(other.idSugerencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.Sugerencia[ idSugerencia=" + idSugerencia + " ]";
    }
    
}
