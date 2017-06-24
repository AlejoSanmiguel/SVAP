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
@Table(name = "transportador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportador.findAll", query = "SELECT t FROM Transportador t"),
    @NamedQuery(name = "Transportador.findByIdTransportador", query = "SELECT t FROM Transportador t WHERE t.idTransportador = :idTransportador"),
    @NamedQuery(name = "Transportador.findByDocumentacionVehiculo", query = "SELECT t FROM Transportador t WHERE t.documentacionVehiculo = :documentacionVehiculo"),
    @NamedQuery(name = "Transportador.findByPlacaVehiculo", query = "SELECT t FROM Transportador t WHERE t.placaVehiculo = :placaVehiculo")})
public class Transportador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransportador")
    private Integer idTransportador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "documentacionVehiculo")
    private String documentacionVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "placaVehiculo")
    private String placaVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportadoridTransportador", fetch = FetchType.EAGER)
    private List<EstadoOftrans> estadoOftransList;
    @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuariosIdusuarios;

    public Transportador() {
    }

    public Transportador(Integer idTransportador) {
        this.idTransportador = idTransportador;
    }

    public Transportador(Integer idTransportador, String documentacionVehiculo, String placaVehiculo) {
        this.idTransportador = idTransportador;
        this.documentacionVehiculo = documentacionVehiculo;
        this.placaVehiculo = placaVehiculo;
    }

    public Integer getIdTransportador() {
        return idTransportador;
    }

    public void setIdTransportador(Integer idTransportador) {
        this.idTransportador = idTransportador;
    }

    public String getDocumentacionVehiculo() {
        return documentacionVehiculo;
    }

    public void setDocumentacionVehiculo(String documentacionVehiculo) {
        this.documentacionVehiculo = documentacionVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    @XmlTransient
    public List<EstadoOftrans> getEstadoOftransList() {
        return estadoOftransList;
    }

    public void setEstadoOftransList(List<EstadoOftrans> estadoOftransList) {
        this.estadoOftransList = estadoOftransList;
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
        hash += (idTransportador != null ? idTransportador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportador)) {
            return false;
        }
        Transportador other = (Transportador) object;
        if ((this.idTransportador == null && other.idTransportador != null) || (this.idTransportador != null && !this.idTransportador.equals(other.idTransportador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.Transportador[ idTransportador=" + idTransportador + " ]";
    }
    
}
