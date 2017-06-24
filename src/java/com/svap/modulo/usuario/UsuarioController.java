/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.usuario;

import com.svap.dao.CompradorFacade;
import com.svap.dao.ProductorFacade;
import com.svap.dao.RolFacade;
import com.svap.dao.TipoDocumentoFacade;
import com.svap.dao.TransportadorFacade;
import com.svap.dao.UsuarioFacade;
import com.svap.entities.Comprador;
import com.svap.entities.Permiso;
import com.svap.entities.Productor;
import com.svap.entities.Rol;
import com.svap.entities.TipoDocumento;
import com.svap.entities.Transportador;
import com.svap.entities.Usuario;
import com.svap.util.JsfUtil;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author personal
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    private Integer id;
    private Long noCedula;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correoElectronico;
    private String numeroTel;
    private String contraseña;
    private String estado;
    private String sigla;

    private Integer idProductor;
    private String domicilioEmpresa;
    private List<Productor> domicilios;
    private List<Comprador> compradores;
    private Usuario usuarioSelect;
    private Rol rolSeleccionado;

    private String telefonoEmpresa;
    private String nitEmpresa;
    private Locale languageSelected;

    //Transportador
    private String documentacionVehiculo;
    private String placaVehiculo;
    @EJB
    private CompradorFacade compradorFacade;
    @EJB
    private SessionRule sr;

    @EJB
    private UsuarioFacade usFacade;

    @EJB
    private TipoDocumentoFacade tdFacade;

    @EJB
    private ProductorFacade productorFacade;
    @EJB
    private TransportadorFacade transportadorFacade;
    @EJB
    private RolFacade rolFacade;

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

    public UsuarioController() {
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNoCedula() {
        return noCedula;
    }

    public void setNoCedula(Long noCedula) {
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

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Usuario getUsuarioSelect() {
        return usuarioSelect;
    }

    public void setUsuarioSelect(Usuario usuarioSelect) {
        this.usuarioSelect = usuarioSelect;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
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

    public String registrarTransportador() {
        Transportador t = new Transportador(null, documentacionVehiculo, placaVehiculo);
        Usuario us = getUsuarioSesion();
        t.setUsuariosIdusuarios(us);
        transportadorFacade.create(t);
        return "/svap/app/usuario/indexusuario.xhtml?faces-redict=true";

    }

    public String registrarComprador() {
        List<Rol> roles = new ArrayList<>();
        rolSeleccionado = rolFacade.find(3);
        roles = (List<Rol>) rolSeleccionado;
        System.out.println(roles);
        try {
            Comprador c = new Comprador(null, domicilioEmpresa, telefonoEmpresa, nitEmpresa);
            Usuario us = getUsuarioSesion();
            us.setRoles(roles);
            c.setUsuariosIdusuarios(us);
            compradorFacade.create(c);
            return "";
//            return "/svap/app/usuario/indexusuario.xhtml?faces-redict=true";
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }

    public void registrarProductor() {
        List<Rol> roles = new ArrayList<>();
        roles.add(rolSeleccionado);

        Productor p = new Productor(null, domicilioEmpresa);
        Usuario us = getUsuarioSesion();
        us.setRoles(roles);
        p.setUsuariosIdusuarios(us);
        productorFacade.create(p);
    }

    public String registrarUsuario() {
        FacesMessage msj = new FacesMessage();
        List<Rol> roles = new ArrayList<>();
        rolSeleccionado = rolFacade.find(3);
        roles.add(rolSeleccionado);
        try {
            Usuario us = new Usuario(null, noCedula, primerNombre, primerApellido, correoElectronico, numeroTel, contraseña, 1);
            validarTipo(us);
            us.setRoles(roles);
            usFacade.create(us);
            JsfUtil.addSuccessMessage("Usuario registrado correctamente");
            return "";
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
            System.out.println(ex.getCause());
            JsfUtil.addSuccessMessage("Lo sentimos no se ha podido registrar, existe un usuario con este documento, contacte con soporte.");
            return "";
        }
    }

    public void validarTipo(Usuario u) {
        TipoDocumento td;
        if (getSigla().equals("C.C")) {
            td = tdFacade.find(1);
            u.setTipodocumentosidDoc(td);
        } else {
            td = tdFacade.find(2);
            u.setTipodocumentosidDoc(td);
        }
    }

    public String cerrarSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.invalidateSession();
//        ec.getSessionMap().remove("user");
        noCedula = null;
        contraseña = "";
        return "/svap/index.xhtml?faces-redict=true";
    }

    public TipoDocumentoController obtenerContextoDocumentoC() {
        FacesContext fc = FacesContext.getCurrentInstance();
        TipoDocumentoController td = fc.getApplication().evaluateExpressionGet(fc, "#{tipoDocumentoController}", TipoDocumentoController.class);
        return td;
    }

//    public String ingresar(){
//        
//    }
    public String action() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        FacesMessage msj = new FacesMessage();
        String url = "";

        if (noCedula != null && noCedula != 0 && contraseña != null && !contraseña.equals(" ")) {
//            try{
            Usuario u = usFacade.iniciarSesion(noCedula, contraseña);
//            System.out.println(u);}
//            catch(Exception e){
//            e.printStackTrace();
//            }
            if (u != null) {
//                System.out.println(u.getNumeroTelefono()+u.getPrimerNombre()+u.getRoles().get(0)); 
                ec.getSessionMap().put("user", u);
                rolSeleccionado = validarRol(u);
                if (rolSeleccionado != null) {
                    this.primerNombre = getUsuarioSesion().getPrimerNombre();
                    this.segundoNombre = getUsuarioSesion().getSegundoNombre();
                    this.primerApellido = getUsuarioSesion().getPrimerApellido();
                    this.segundoApellido = getUsuarioSesion().getSegundoApellido();
                    this.correoElectronico = getUsuarioSesion().getCorreoElectronico();
                    this.numeroTel = getUsuarioSesion().getNumeroTelefono();

                    url = "app/oferta/nuevaoferta.xhtml?faces-redirect=true";
                } else {
                    url = "registrarrol.xhtml?faces-redirect=true";
                    JsfUtil.addErrorMessage("Rol no asignado dirijase a perfil e ingrese los datos solicitados.");
                }

            } else {
                JsfUtil.addErrorMessage("Datos incorrectos, compruebe datos e intentelo de nuevo.");
//                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos incorrectos,", " compruebe datos.");
            }
        } else {
            JsfUtil.addErrorMessage("Datos incompletos, debe diligenciar todos los campos.");
//            msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos incompletos, ", "debe diligencia todos los campos");
        }
        fc.addMessage(null, msj);
        return url;
    }
//    public Usuario validarEstado(Long documento, String clave){
//        Usuario u = null;
//        if (documento != null && documento >0 && clave != null && clave.length()>0) {
//            
//        }
//    }

    public Rol validarRol(Usuario u) {
//        System.out.println(u.getRoles().get(0).getNombre());
        Rol r = null;
        if (u.getRoles() != null && u.getRoles().size() > 0) {
            r = u.getRoles().get(0);
        } else {
            JsfUtil.addErrorMessage("Rol no asignado dirijase a perfil e ingrese los datos solicitados.");
        }
        return r;
    }

    public Usuario getUsuarioSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        return (Usuario) ec.getSessionMap().get("user");
    }

    public Boolean inicioSesion() {
        return (usuarioSelect != null);
    }

    public void validarSesion() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            if (getUsuarioSesion() == null) {
                ec.redirect(ec.getRequestContextPath() + "/svap/index.xhtml?faces-redict=true");
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String actualizarUsuario() {
//        getUsuarioSesion().setPrimerNombre(primerNombre);
//        getUsuarioSesion().setSegundoNombre(segundoNombre);
//        getUsuarioSesion().setPrimerApellido(primerApellido);
//        getUsuarioSesion().setSegundoApellido(segundoApellido);
//        getUsuarioSesion().setCorreoElectronico(correoElectronico);
//        getUsuarioSesion().setNumeroTelefono(numeroTel);
//        getUsuarioSesion().setContrasena(contraseña);
        usFacade.edit(getUsuarioSesion());
        JsfUtil.addSuccessMessage("Sus datos han sido actualizados");
        return "";
    }

    public List<Productor> getProductores() {
        domicilios = new ArrayList<>();
        domicilios = productorFacade.findAll();
        return domicilios;
    }

    public List<Comprador> getCompradores() {
        compradores = new ArrayList<>();
        compradores = compradorFacade.findAll();
        return compradores;
    }

    public Boolean tienePermiso(String urlRecurso) {
        if (urlRecurso.endsWith("app/index.xhtml")) {
            return true;
        }
        for (Permiso p : rolSeleccionado.getPermisos()) {
            if (p.getUrl() != null && urlRecurso.endsWith(p.getUrl())) {
                return true;
            }
        }
        return false;
    }

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        Locale idiomaUsuario = ec.getRequestLocale();
        boolean support = false;
        for (Locale l : getSupportLanguages()) {
            if (l.getLanguage().equals(idiomaUsuario.getLanguage())) {
                support = true;
                break;
            }
        }
        languageSelected = (support) ? idiomaUsuario : new Locale("es");
    }

    public Locale getLanguageSelected() {
        return languageSelected;
    }

    public void setLanguageSelected(Locale languageSelected) {
        this.languageSelected = languageSelected;
    }

    public List<Locale> getSupportLanguages() {
        List<Locale> idiomas = new ArrayList<>();
        Iterator<Locale> it = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
        while (it.hasNext()) {
            idiomas.add(it.next());
        }
        return idiomas;
    }

    public String cambiarIdioma(Locale idioma) {
        if (idioma != null) {
            this.languageSelected = idioma;
            FacesContext.getCurrentInstance().getViewRoot().setLocale(languageSelected);
        }
        return "";
    }

//    if (u != null) {
//                if (u.getEstado().equals("Activo")) {
//                    if (u.getRoles() !=null && u.getRoles().size()>0) {
//                        
//                    }
//                    ec.getSessionMap().put("user", u);
//                }else{
//                    u= null;
////                    mensaje
//                }
//                    
//                
//                url = "app/oferta/nuevaoferta.xhtml?faces-redirect=true";
//            } else {
//                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos incorrectos,", " compruebe datos.");
//            }
}
