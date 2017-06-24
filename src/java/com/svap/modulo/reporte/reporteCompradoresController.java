/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.reporte;

import com.svap.entities.Comprador;
import com.svap.dao.CompradorFacade;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Alejo Sanmiguel M
 */
@Named(value = "reporteCompradoresController")
@RequestScoped
public class reporteCompradoresController {

    @EJB
    private CompradorFacade cf;
    private List<Comprador> Compradores;
    private JasperPrint jp;

    public reporteCompradoresController() {
    }

    @PostConstruct
    public void init() {
        Compradores = cf.findAll();
    }

    public List<Comprador> getOfertaProductoFacade() {
        return Compradores;
    }

    private void prepararExport() throws JRException {
        Map<String, Object> params = new HashMap<>();
        params.put("UsuarioDelReporte", "Administrador");
        JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(Compradores);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/") + "/WEB-INF/reportes/ReportesCompradoresSVAP.jasper";
        jp = JasperFillManager.fillReport(reportPath, params, bcds);
    }

    public void ExportarPDF() throws IOException, JRException {
        prepararExport();
        ServletOutputStream out = null;
        String contentType = "application/pdf";
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletResponse res = (HttpServletResponse) ec.getResponse();
        res.setContentType(contentType);
        res.addHeader("Content-disposition", "attachment; filename=\"ReporteCompradores.pdf\"");
        out = res.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jp, out);
        fc.responseComplete();
    }
}
