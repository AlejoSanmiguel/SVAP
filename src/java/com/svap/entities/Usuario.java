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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuarios", query = "SELECT u FROM Usuario u WHERE u.idusuarios = :idusuarios"),
    @NamedQuery(name = "Usuario.findByNoCedula", query = "SELECT u FROM Usuario u WHERE u.noCedula = :noCedula"),
    @NamedQuery(name = "Usuario.findByPrimerNombre", query = "SELECT u FROM Usuario u WHERE u.primerNombre = :primerNombre"),
    @NamedQuery(name = "Usuario.findBySegundoNombre", query = "SELECT u FROM Usuario u WHERE u.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Usuario.findByPrimerApellido", query = "SELECT u FROM Usuario u WHERE u.primerApellido = :primerApellido"),
    @NamedQuery(name = "Usuario.findBySegundoApellido", query = "SELECT u FROM Usuario u WHERE u.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Usuario.findByCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Usuario.findByNumeroTelefono", query = "SELECT u FROM Usuario u WHERE u.numeroTelefono = :numeroTelefono"),
    @NamedQuery(name = "Usuario.findByContraseña", query = "SELECT u FROM Usuario u WHERE u.contraseña = :contraseña"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
@NamedQuery(name = "Usuario.findLogin", query = "SELECT u FROM Usuario u WHERE u.noCedula= :doc AND u.contraseña = :clv")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuarios")
    private Integer idusuarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noCedula")
    private long noCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "primerNombre")
    private String primerNombre;
    @Size(max = 45)
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Size(max = 45)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numeroTelefono")
    private String numeroTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contraseña")
    private String contraseña;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinTable(name = "usuarios_has_roles", joinColumns = {
        @JoinColumn(name = "usuarios_idusuarios", referencedColumnName = "idusuarios")}, inverseJoinColumns = {
        @JoinColumn(name = "roles_idroles", referencedColumnName = "idroles")})
    @ManyToMany(fetch = FetchType.EAGER)    
    private List<Rol> roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosIdusuarios", fetch = FetchType.EAGER)
    private List<Reclamo> reclamoList;
    @JoinColumn(name = "tipodocumentos_idDoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoDocumento tipodocumentosidDoc;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuariosIdusuarios", fetch = FetchType.EAGER)
    private List<Transportador> transportador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuariosIdusuarios", fetch = FetchType.EAGER)
    private List<Comprador> comprador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuariosIdusuarios", fetch = FetchType.EAGER)
    private List<Productor> productor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosIdusuarios", fetch = FetchType.EAGER)
    private List<Sugerencia> sugerenciaList;

    public Usuario() {
    }

    public Usuario(Integer idusuarios) {
        this.idusuarios = idusuarios;
    }

    public Usuario(Integer idusuarios, long noCedula, String primerNombre, String primerApellido, String correoElectronico, String numeroTelefono, String contraseña, int estado) {
        this.idusuarios = idusuarios;
        this.noCedula = noCedula;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Integer getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(Integer idusuarios) {
        this.idusuarios = idusuarios;
    }

    public long getNoCedula() {
        return noCedula;
    }

    public void setNoCedula(long noCedula) {
        this.noCedula = noCedula;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @XmlTransient
    public List<Reclamo> getReclamoList() {
        return reclamoList;
    }

    public void setReclamoList(List<Reclamo> reclamoList) {
        this.reclamoList = reclamoList;
    }

    public TipoDocumento getTipodocumentosidDoc() {
        return tipodocumentosidDoc;
    }

    public void setTipodocumentosidDoc(TipoDocumento tipodocumentosidDoc) {
        this.tipodocumentosidDoc = tipodocumentosidDoc;
    }

    @XmlTransient
    public List<Transportador> getTransportadorList() {
        return transportador;
    }

    public void setTransportadorList(List<Transportador> transportadorList) {
        this.transportador = transportadorList;
    }

    @XmlTransient
    public List<Comprador> getCompradorList() {
        return comprador;
    }

    public void setCompradorList(List<Comprador> compradorList) {
        this.comprador = compradorList;
    }

    @XmlTransient
    public List<Productor> getProductor() {
        return productor;
    }

    public void setProductor(List<Productor> productor) {
        this.productor = productor;
    }

    @XmlTransient
    public List<Sugerencia> getSugerenciaList() {
        return sugerenciaList;
    }

    public void setSugerenciaList(List<Sugerencia> sugerenciaList) {
        this.sugerenciaList = sugerenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuarios != null ? idusuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuarios == null && other.idusuarios != null) || (this.idusuarios != null && !this.idusuarios.equals(other.idusuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.svap.entities.Usuario[ idusuarios=" + idusuarios + " ]";
    }
    
}
