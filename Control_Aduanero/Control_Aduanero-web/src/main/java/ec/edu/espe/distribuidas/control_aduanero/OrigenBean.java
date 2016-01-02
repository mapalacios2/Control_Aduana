/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import ec.edu.espe.distribuidas.modelo.Importador;
import ec.edu.espe.distribuidas.modelo.Origen;
import ec.edu.espe.distribuidas.servicio.OrigenServicio;
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
 * @author Marco Antonio
 */
@ManagedBean
@ViewScoped
public class OrigenBean implements Serializable{
    private List<Origen> Origenes;
    
    private Origen origen;
    
    private Origen OrigenSeleccionado;
    
    private String tituloFormulario;
    
    private boolean nuevo;
    
    private boolean enNueva;
    private boolean enModificar;
    private boolean enDetalles;
    
    @EJB
    private OrigenServicio OrigenServicio;
    
    @PostConstruct
    public void postConstructor() {
        this.Origenes = this.OrigenServicio.obtenerOrigen();
    }

    public void nuevoOrigen() {
        this.origen = new Origen();
        this.enNueva =true;
        this.tituloFormulario = "Creación de Origen";
    }
    
    public void modificarOrigen() {
        if (this.OrigenSeleccionado!=null) {
            this.tituloFormulario = "Modificación de Origen";
            this.copiarOrigenSeleccionado();
            this.enModificar = true;
        }
    }
    
    
    public void detallesOrigen() {
        if (this.OrigenSeleccionado!=null) {
            this.tituloFormulario = "Detalles de Origen";
            this.copiarOrigenSeleccionado();
            this.enDetalles = true;
        }
    }
    
    public void guardarOrigen() {
        if (this.enNueva) {
            try {
                this.OrigenServicio.crearOrigen(this.origen);
                this.enNueva = false;
                this.Origenes = this.OrigenServicio.obtenerOrigen();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Origen Creado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear Origen.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            try {
                this.OrigenServicio.actualizarOrigen(this.origen);
                this.enModificar = false;
                this.Origenes = this.OrigenServicio.obtenerOrigen();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Origen Actualizado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar Origen.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
    
    public void eliminarOrigen() {
        if (this.OrigenSeleccionado!= null) {
            try {
                this.copiarOrigenSeleccionado();
                this.OrigenServicio.eliminarOrigen(this.origen.getCodigoOrigen());
                this.Origenes = this.OrigenServicio.obtenerOrigen();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Origen Eliminado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Origen. ", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }
    
     private void copiarOrigenSeleccionado() {
        this.origen= new Origen();
        this.origen.setCodigoOrigen(this.OrigenSeleccionado.getCodigoOrigen());
        this.origen.setPais(this.OrigenSeleccionado.getPais());        
        this.origen.setPuerto(this.OrigenSeleccionado.getPuerto());
        this.origen.setFechaEmbarque(this.OrigenSeleccionado.getFechaEmbarque());
     
        
    }
     
    public void cancelar() {
        this.enNueva=false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public void selectOrigenFromDialog(Origen origen) {
        RequestContext.getCurrentInstance().closeDialog(origen);
    }

    public List<Origen> getOrigenes() {
        return Origenes;
    }

    public Origen getOrigen() {
        return origen;
    }

    public Origen getOrigenSeleccionado() {
        return OrigenSeleccionado;
    }

    public String getTituloFormulario() {
        return tituloFormulario;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public boolean isEnNueva() {
        return enNueva;
    }

    public boolean isEnModificar() {
        return enModificar;
    }

    public boolean isEnDetalles() {
        return enDetalles;
    }

    public OrigenServicio getOrigenServicio() {
        return OrigenServicio;
    }

    public void setOrigenes(List<Origen> Origenes) {
        this.Origenes = Origenes;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public void setOrigenSeleccionado(Origen OrigenSeleccionado) {
        this.OrigenSeleccionado = OrigenSeleccionado;
    }

    public void setTituloFormulario(String tituloFormulario) {
        this.tituloFormulario = tituloFormulario;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public void setEnNueva(boolean enNueva) {
        this.enNueva = enNueva;
    }

    public void setEnModificar(boolean enModificar) {
        this.enModificar = enModificar;
    }

    public void setEnDetalles(boolean enDetalles) {
        this.enDetalles = enDetalles;
    }

    public void setOrigenServicio(OrigenServicio OrigenServicio) {
        this.OrigenServicio = OrigenServicio;
    }
   
    

    
}
