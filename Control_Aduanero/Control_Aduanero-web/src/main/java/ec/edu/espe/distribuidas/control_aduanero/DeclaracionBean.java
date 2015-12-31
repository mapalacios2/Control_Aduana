/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import ec.edu.espe.distribuidas.modelo.Declaracion;
import ec.edu.espe.distribuidas.modelo.Importador;
import ec.edu.espe.distribuidas.modelo.Origen;
import ec.edu.espe.distribuidas.modelo.Producto;
import ec.edu.espe.distribuidas.modelo.PuertoIngreso;
import ec.edu.espe.distribuidas.servicio.DeclaracionServicio;
import ec.edu.espe.distribuidas.servicio.ImportadorServicio;
import ec.edu.espe.distribuidas.servicio.OrigenServicio;
import ec.edu.espe.distribuidas.servicio.ProductoServicio;
import ec.edu.espe.distribuidas.servicio.PuertoIngresoServicio;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Marco Antonio
 */
@ManagedBean
@ViewScoped
public class DeclaracionBean implements Serializable {
    @EJB
    private ImportadorServicio importadorServicio;
    @EJB
    private PuertoIngresoServicio puertoServicio;
    @EJB
    private ProductoServicio productoServicio;
    @EJB
    private OrigenServicio origenServicio;
    @EJB
    private DeclaracionServicio declaracionServicio;

    private Importador importador;
    private String cedula;
    private List<Producto> productos;
    private Producto productoSeleccionado;
    private List<PuertoIngreso> puertos;
    private PuertoIngreso puertoSeleccionado;
    private List<Origen> origenes;  
    private Origen origenSeleccionado;
    private List<Declaracion> declaraciones;
    private Integer cantidad;
    private Declaracion declaracion;

    @PostConstruct
    public void init() {
        this.productos = this.productoServicio.obtenerProducto();
        this.puertos = this.puertoServicio.obtenerPuertoIngreso();
        this.origenes = this.origenServicio.obtenerOrigen();
        this.declaraciones = this.declaracionServicio.obtenerDeclaracion();
        //this.clasificar();
    }
    
    public void buscarImportador() {
        this.importador = this.importadorServicio.obtenerOperadorPorCedula(this.cedula);
        if (this.importador != null) {
            //this.guardarDeclaracion();            
        } else {
            this.mostrarMensaje(FacesMessage.SEVERITY_WARN, "Importador no registrado.");
        }
    }
    
    public void clasificar() {
        this.productos.remove(0);
        this.puertos.remove(0);
        this.origenes.remove(0);
    }
    
//    public void guardarDeclaracion() {
//        this.declaracion = new Declaracion();
//        //this.declaracion.setCedula(this.cedula);
//        this.declaracion.setImportador(this.importador);
//        this.declaracion.setFechaLlegada(new Date());
//        this.declaracion.setTotalProducto(this.productoSeleccionado.getValorProducto());
//        this.declaracion.setTotalArancel(this.productoSeleccionado.getValorArancel());
//        this.declaracionServicio.crearDeclaracion(this.declaracion);
//        this.declaraciones = this.declaracionServicio.obtenerDetallesPorCodigoDeclaracion(this.declaracion);
//    }
    
    public void guardarDetalleDeclaracion() {   
        try {
        this.declaracionServicio.insertarDeclaracion(this.declaracion, this.productoSeleccionado, this.puertoSeleccionado,this.origenSeleccionado,this.importador);
        //this.declaraciones = this.declaracionServicio.obtenerDetallesPorCodigoDeclaracion(this.declaracion);
        this.declaraciones = this.declaracionServicio.obtenerDeclaracion();
        this.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Declaracion Generada");
         } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al generar Declaracion. ", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
    
    }   

    public void direccionarAdminUsuario() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + "/" + "principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(DeclaracionBean.class.getName()).log(Level.SEVERE, "Error al direccionar ", ex);
        }
    }

    public void mostrarMensaje(FacesMessage.Severity severityMessage, String mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severityMessage, "Mensaje:", mensaje));
    }

    public ImportadorServicio getImportadorServicio() {
        return importadorServicio;
    }

    public PuertoIngresoServicio getPuertoServicio() {
        return puertoServicio;
    }

    public ProductoServicio getProductoServicio() {
        return productoServicio;
    }

    public OrigenServicio getOrigenServicio() {
        return origenServicio;
    }

    public DeclaracionServicio getDeclaracionServicio() {
        return declaracionServicio;
    }

    public Importador getImportador() {
        return importador;
    }

    public String getCedula() {
        return cedula;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public List<PuertoIngreso> getPuertos() {
        return puertos;
    }

    public PuertoIngreso getPuertoSeleccionado() {
        return puertoSeleccionado;
    }

    public List<Origen> getOrigenes() {
        return origenes;
    }

    public Origen getOrigenSeleccionado() {
        return origenSeleccionado;
    }

    public List<Declaracion> getDeclaraciones() {
        return declaraciones;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Declaracion getDeclaracion() {
        return declaracion;
    }

    public void setImportadorServicio(ImportadorServicio importadorServicio) {
        this.importadorServicio = importadorServicio;
    }

    public void setPuertoServicio(PuertoIngresoServicio puertoServicio) {
        this.puertoServicio = puertoServicio;
    }

    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public void setOrigenServicio(OrigenServicio origenServicio) {
        this.origenServicio = origenServicio;
    }

    public void setDeclaracionServicio(DeclaracionServicio declaracionServicio) {
        this.declaracionServicio = declaracionServicio;
    }

    public void setImportador(Importador importador) {
        this.importador = importador;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public void setPuertos(List<PuertoIngreso> puertos) {
        this.puertos = puertos;
    }

    public void setPuertoSeleccionado(PuertoIngreso puertoSeleccionado) {
        this.puertoSeleccionado = puertoSeleccionado;
    }

    public void setOrigenes(List<Origen> origenes) {
        this.origenes = origenes;
    }

    public void setOrigenSeleccionado(Origen origenSeleccionado) {
        this.origenSeleccionado = origenSeleccionado;
    }

    public void setDeclaraciones(List<Declaracion> declaraciones) {
        this.declaraciones = declaraciones;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setDeclaracion(Declaracion declaracion) {
        this.declaracion = declaracion;
    }
    
}
