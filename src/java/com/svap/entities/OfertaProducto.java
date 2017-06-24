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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author personal
 */
@Entity
@Table(name = "ofertaproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfertaProducto.findAll", query = "SELECT o FROM OfertaProducto o"),
    @NamedQuery(name = "OfertaProducto.findByIdOferta", query = "SELECT o FROM OfertaProducto o WHERE o.idOferta = :idOferta"),
    @NamedQuery(name = "OfertaProducto.findByPrecioOferta", query = "SELECT o FROM OfertaProducto o WHERE o.precioOferta = :precioOferta"),
    @NamedQuery(name = "OfertaProducto.findByDetalles", query = "SELECT o FROM OfertaProducto o WHERE o.detalles = :detalles"),
    @NamedQuery(name = "OfertaProducto.findByCantidadProducto", query = "SELECT o FROM OfertaProducto o WHERE o.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "OfertaProducto.findByFoto", query = "SELECT o FROM OfertaProducto o WHERE o.foto = :foto"),
    @NamedQuery(name = "OfertaProducto.findByEstado", query = "SELECT o FROM OfertaProducto o WHERE o.estado = :estado"),
    @NamedQuery(name = "OfertaProducto.findByFechaLimite", query = "SELECT o FROM OfertaProducto o WHERE o.fechaLimite = :fechaLimite")})
public class OfertaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOferta")
    private Integer idOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioOferta")
    private double precioOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "detalles")
    private String detalles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_producto")
    private int cantidadProducto;
    @Size(max = 45)
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "fechaLimite")
    private Date fechaLimite;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto productoIdproducto;
    @JoinColumn(name = "productor_idProductor", referencedColumnName = "idProductor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Productor productoridProductor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofertaProductoidOferta", fetch = FetchType.EAGER)
    private List<EstadoOferta> estadoOfertaList;

    public OfertaProducto() {
    }

    public OfertaProducto(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public OfertaProducto(Integer idOferta, double precioOferta, String detalles, int cantidadProducto,String foto, String estado, Date fechaLimite) {
        this.idOferta = idOferta;
        this.precioOferta = precioOferta;
        this.detalles = detalles;
        this.cantidadProducto = cantidadProducto;
        this.foto= foto;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    public Productor getProductoridProductor() {
        return productoridProductor;
    }

    public void setProductoridProductor(Productor productoridProductor) {
        this.productoridProductor = productoridProductor;
    }

    @XmlTransient
    public List<EstadoOferta> getEstadoOfertaList() {
        return estadoOfertaList;
    }

    public void setEstadoOfertaList(List<EstadoOferta> estadoOfertaList) {
        this.estadoOfertaList = estadoOfertaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaProducto)) {
            return false;
        }
        OfertaProducto other = (OfertaProducto) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.OfertaProducto[ idOferta=" + idOferta + " ]";
    }
    
}
