/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import ec.edu.espe.distribuidas.modelo.PuertoIngreso;
import ec.edu.espe.distribuidas.servicio.PuertoIngresoServicio;
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
public class PuertoIngresoBean implements Serializable {
    private List<PuertoIngreso> puertos;
    
    private PuertoIngreso puerto;
    
    private PuertoIngreso puertoSeleccionado;
    
    private String tituloFormulario;
    
    private boolean nuevo;
    
    private boolean enNueva;
    private boolean enModificar;
    private boolean enDetalles;
    
    @EJB
    private PuertoIngresoServicio puertoServicio;
    
    @PostConstruct
    public void postConstructor() {
        this.puertos = this.puertoServicio.obtenerPuertoIngreso();
    }

    public void nuevoPuertoIngreso() {
        this.puerto = new PuertoIngreso();
        this.enNueva =true;
        this.tituloFormulario = "Creación de Puerto";
    }
    
    public void modificarPuertoIngreso() {
        if (this.puertoSeleccionado!=null) {
            this.tituloFormulario = "Modificación de Puerto";
            this.copiarPuertoSeleccionado();
            this.enModificar = true;
        }
    }
    
    
    public void detallesPuertoIngreso() {
        if (this.puertoSeleccionado!=null) {
            this.tituloFormulario = "Detalles de Puerto";
            this.copiarPuertoSeleccionado();
            this.enDetalles = true;
        }
    }
    
    public void guardarPuertoIngreso() {
        if (this.enNueva) {
            try {
                this.puertoServicio.crearPuertoIngreso(this.puerto);
                this.enNueva = false;
                this.puertos = this.puertoServicio.obtenerPuertoIngreso();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Puerto Creado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear Puerto.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            try {
                this.puertoServicio.actualizarPuertoIngreso(this.puerto);
                this.enModificar = false;
                this.puertos = this.puertoServicio.obtenerPuertoIngreso();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Puerto Actualizado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar Puerto.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
    
    public void eliminarPuertoIngreso() {
        if (this.puertoSeleccionado!= null) {
            try {
                this.copiarPuertoSeleccionado();
                this.puertoServicio.eliminarPuertoIngreso(this.puerto.getCodigoPuerto());
                this.puertos = this.puertoServicio.obtenerPuertoIngreso();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Puerto Eliminado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Puerto. ", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }
    
     private void copiarPuertoSeleccionado() {
        this.puerto= new PuertoIngreso();
        this.puerto.setCodigoPuerto(this.puertoSeleccionado.getCodigoPuerto());
        this.puerto.setNombre(this.puertoSeleccionado.getNombre());        
        this.puerto.setDireccion(this.puertoSeleccionado.getDireccion());
        this.puerto.setTelefono(this.puertoSeleccionado.getTelefono());
     
        
    }
     
    public void cancelar() {
        this.enNueva=false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public void selectPuertoIngresoFromDialog(PuertoIngreso pingreso) {
        RequestContext.getCurrentInstance().closeDialog(pingreso);
    }

    public List<PuertoIngreso> getPuertos() {
        return puertos;
    }

    public PuertoIngreso getPuerto() {
        return puerto;
    }

    public PuertoIngreso getPuertoSeleccionado() {
        return puertoSeleccionado;
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

    public PuertoIngresoServicio getPuertoServicio() {
        return puertoServicio;
    }

    public void setPuertos(List<PuertoIngreso> puertos) {
        this.puertos = puertos;
    }

    public void setPuerto(PuertoIngreso puerto) {
        this.puerto = puerto;
    }

    public void setPuertoSeleccionado(PuertoIngreso puertoSeleccionado) {
        this.puertoSeleccionado = puertoSeleccionado;
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

    public void setPuertoServicio(PuertoIngresoServicio puertoServicio) {
        this.puertoServicio = puertoServicio;
    }

    
    
}
