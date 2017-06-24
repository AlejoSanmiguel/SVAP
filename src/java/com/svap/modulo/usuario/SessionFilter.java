/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svap.modulo.usuario;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author personal
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = {"/app/*"})
public class SessionFilter implements Filter {

    /**
     * Creates a new instance of SessionFilter
     */
    private static final boolean debug = true;
    
    private FilterConfig filterConfig = null;
    @Inject
    private UsuarioController uc;
    
    public SessionFilter() {
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException{
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        if (uc!= null) {
            if (uc.inicioSesion()) {
                String url = rq.getRequestURL().toString();
                if (uc.tienePermiso(url)) {
                    chain.doFilter(request, response);
                }else{
                    rs.sendRedirect(rq.getContextPath() + "/app/index.xhtml");
                }
            }else{
                rs.sendRedirect(rq.getContextPath()+ "/index.xhtml");
            }
        }else{
            rs.sendRedirect(rq.getContextPath() + "/index.xhtml");
        }
    }

    public FilterConfig getFilterConfig(){
        return (this.filterConfig);
    }
    
    public void setFilterConfig(){
        this.filterConfig = filterConfig;
    }
    
    public void destroy(){
    }
    
    public void init(FilterConfig filterConfig){
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                System.out.println("SessionFilter:Initializing filter");
            }
        }
    }
    @Override
    public String toString(){
        if (filterConfig == null) {
            return("SessionFilter()");
        }
            StringBuffer sb = new StringBuffer("SessionFilter (");
            sb.append(filterConfig);
            sb.append(")");
        return (sb.toString());
    }

    @Override
    public boolean isLoggable(LogRecord lr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
