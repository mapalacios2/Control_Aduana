/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;


import ec.edu.espe.distribuidas.modelo.Producto;
import ec.edu.espe.distribuidas.modelo.Subpartida;
import ec.edu.espe.distribuidas.servicio.ProductoServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author LuisAlberto
 */

@ManagedBean
@ViewScoped
public class ProductoBean implements Serializable{
    
    private List<Producto> Productos;
    
    private List<Subpartida> subpartidas;
    
    private Producto producto;
    
    private Producto productoSeleccionado;
    
    private String tituloFormulario;
    
    private boolean nuevo;
    
    private boolean enNueva;
    private boolean enModificar;
    private boolean enDetalles;
    
    @EJB
    private ProductoServicio productoServicio;
    
    @PostConstruct
    public void postConstructor() {
        this.Productos = this.productoServicio.obtenerProducto();
        this.subpartidas = this.productoServicio.obtenerSubPartida();
    }

    public void nuevoProducto() {
        this.producto = new Producto();
        this.enNueva =true;
        this.tituloFormulario = "Creación de Producto";
    }
    
    public void modificarProducto() {
        if (this.productoSeleccionado!=null) {
            this.tituloFormulario = "Modificación de Producto";
            this.copiarProductoSeleccionado();
            this.enModificar = true;
        }
    }
    
    
    public void detallesProducto() {
        if (this.productoSeleccionado!=null) {
            this.tituloFormulario = "Detalles de Producto";
            this.copiarProductoSeleccionado();
            this.enDetalles = true;
        }
    }
    
    public void guardarProducto() {
        if (this.enNueva) {
            try {
                this.productoServicio.crearProducto(this.producto);
                this.enNueva = false;
                this.Productos = this.productoServicio.obtenerProducto();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Creado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear Producto.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            try {
                this.productoServicio.actualizarProducto(this.producto);
                this.enModificar = false;
                this.Productos = this.productoServicio.obtenerProducto();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Actualizado.","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar el Producto.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
    
    public void eliminarProducto() {
        if (this.productoSeleccionado!= null) {
            try {
                this.copiarProductoSeleccionado();
                this.productoServicio.eliminarProducto(this.producto.getCodigoProducto());
                this.Productos = this.productoServicio.obtenerProducto();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Eliminado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Producto. ", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }
    
     private void copiarProductoSeleccionado() {
        this.producto = new Producto();
        this.producto.setCodigoProducto(this.productoSeleccionado.getCodigoProducto());
        this.producto.setCodigoSubpartida(this.productoSeleccionado.getCodigoSubpartida());
        this.producto.setDescripcion(this.productoSeleccionado.getDescripcion());
        this.producto.setValorProducto(this.productoSeleccionado.getValorProducto());
        this.producto.setValorArancel(this.productoSeleccionado.getValorArancel());
        this.producto.setPorcentajeArancel(this.productoSeleccionado.getPorcentajeArancel());
        
    }
     
    public void cancelar() {
        this.enNueva=false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public void selectProductoFromDialog(Producto producto) {
        RequestContext.getCurrentInstance().closeDialog(producto);
    }

    public List<Subpartida> getSubpartidas() {
        return subpartidas;
    }

    public void setSubpartidas(List<Subpartida> subpartidas) {
        this.subpartidas = subpartidas;
    }
    

    public List<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(List<Producto> Productos) {
        this.Productos = Productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public String getTituloFormulario() {
        return tituloFormulario;
    }

    public void setTituloFormulario(String tituloFormulario) {
        this.tituloFormulario = tituloFormulario;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public boolean isEnNueva() {
        return enNueva;
    }

    public void setEnNueva(boolean enNueva) {
        this.enNueva = enNueva;
    }

    public boolean isEnModificar() {
        return enModificar;
    }

    public void setEnModificar(boolean enModificar) {
        this.enModificar = enModificar;
    }

    public boolean isEnDetalles() {
        return enDetalles;
    }

    public void setEnDetalles(boolean enDetalles) {
        this.enDetalles = enDetalles;
    }

    public ProductoServicio getProductoServicio() {
        return productoServicio;
    }

    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    
}
