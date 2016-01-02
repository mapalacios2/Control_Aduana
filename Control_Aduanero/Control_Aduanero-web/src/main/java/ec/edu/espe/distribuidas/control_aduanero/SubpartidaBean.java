/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import ec.edu.espe.distribuidas.modelo.Subpartida;
import ec.edu.espe.distribuidas.servicio.SubpartidaServicio;
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
public class SubpartidaBean implements Serializable{
    
    private List<Subpartida> Subpartidas;
    
    private Subpartida subpartida;
    
    private Subpartida subpartidaSeleccionada;
    
    private String tituloFormulario;
    
    private boolean nuevo;
    
    private boolean enNueva;
    private boolean enModificar;
    private boolean enDetalles;
    
    @EJB
    private SubpartidaServicio subpartidaServicio;
    
    @PostConstruct
    public void postConstructor() {
        this.Subpartidas = this.subpartidaServicio.obtenerSubpartida();
    }

    public void nuevaSubpartida() {
        this.subpartida = new Subpartida();
        this.enNueva =true;
        this.tituloFormulario = "Creación de Subpartida";
    }
    
    public void modificarSubpartida() {
        if (this.subpartidaSeleccionada!=null) {
            this.tituloFormulario = "Modificación de Subpartida";
            this.copiarSubpartidaSeleccionada();
            this.enModificar = true;
        }
    }
    
    
    public void detallesSubpartida() {
        if (this.subpartidaSeleccionada!=null) {
            this.tituloFormulario = "Detalles de Subpartida";
            this.copiarSubpartidaSeleccionada();
            this.enDetalles = true;
        }
    }
    
    public void guardarSubpartida() {
        if (this.enNueva) {
            try {
                this.subpartidaServicio.crearSubpartida(this.subpartida);
                this.enNueva = false;
                this.Subpartidas = this.subpartidaServicio.obtenerSubpartida();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Subpartida Creada","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear Subpartida.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            try {
                this.subpartidaServicio.actualizarSubpartida(this.subpartida);
                this.enModificar = false;
                this.Subpartidas = this.subpartidaServicio.obtenerSubpartida();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Subpartida Actualizada","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar la Subpartida.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
    
    public void eliminarSubpartida() {
        if (this.subpartidaSeleccionada!= null) {
            try {
                this.copiarSubpartidaSeleccionada();
                this.subpartidaServicio.eliminarSubpartida(this.subpartida.getCodigoSubpartida());
                this.Subpartidas = this.subpartidaServicio.obtenerSubpartida();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Subpartida Eliminado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Subpartida. ", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }
    
     private void copiarSubpartidaSeleccionada() {
        this.subpartida = new Subpartida();
        this.subpartida.setCodigoSubpartida(this.subpartidaSeleccionada.getCodigoSubpartida());
        this.subpartida.setCodigoPartida(this.subpartidaSeleccionada.getCodigoPartida());
        this.subpartida.setDesSubpartida(this.subpartidaSeleccionada.getDesSubpartida());
        
    }
     
    public void cancelar() {
        this.enNueva=false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public void selectSubpartidaFromDialog(Subpartida subpartida) {
        RequestContext.getCurrentInstance().closeDialog(subpartida);
    }

    public List<Subpartida> getSubpartidas() {
        return Subpartidas;
    }

    public void setSubpartidas(List<Subpartida> Subpartidas) {
        this.Subpartidas = Subpartidas;
    }

    public Subpartida getSubpartida() {
        return subpartida;
    }

    public void setSubpartida(Subpartida subpartida) {
        this.subpartida = subpartida;
    }

    public Subpartida getSubpartidaSeleccionada() {
        return subpartidaSeleccionada;
    }

    public void setSubpartidaSeleccionada(Subpartida subpartidaSeleccionada) {
        this.subpartidaSeleccionada = subpartidaSeleccionada;
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

    public SubpartidaServicio getSubpartidaServicio() {
        return subpartidaServicio;
    }

    public void setSubpartidaServicio(SubpartidaServicio subpartidaServicio) {
        this.subpartidaServicio = subpartidaServicio;
    }

    
}
