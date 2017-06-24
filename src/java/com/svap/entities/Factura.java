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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author personal
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdCompra", query = "SELECT f FROM Factura f WHERE f.idCompra = :idCompra")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompra")
    private Integer idCompra;
    @JoinColumn(name = "estadoOferta_idestadoOferta", referencedColumnName = "idestadoOferta")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoOferta estadoOfertaidestadoOferta;
    @JoinColumn(name = "transportar_idTransportar", referencedColumnName = "idTransportar")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Transportar transportaridTransportar;
    @JoinColumn(name = "comprador_idcomprador", referencedColumnName = "idcomprador")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Comprador compradorIdcomprador;

    public Factura() {
    }

    public Factura(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public EstadoOferta getEstadoOfertaidestadoOferta() {
        return estadoOfertaidestadoOferta;
    }

    public void setEstadoOfertaidestadoOferta(EstadoOferta estadoOfertaidestadoOferta) {
        this.estadoOfertaidestadoOferta = estadoOfertaidestadoOferta;
    }

    public Transportar getTransportaridTransportar() {
        return transportaridTransportar;
    }

    public void setTransportaridTransportar(Transportar transportaridTransportar) {
        this.transportaridTransportar = transportaridTransportar;
    }

    public Comprador getCompradorIdcomprador() {
        return compradorIdcomprador;
    }

    public void setCompradorIdcomprador(Comprador compradorIdcomprador) {
        this.compradorIdcomprador = compradorIdcomprador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.Factura[ idCompra=" + idCompra + " ]";
    }
    
}
