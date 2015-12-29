/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import ec.edu.espe.distribuidas.modelo.Partida;
import ec.edu.espe.distribuidas.servicio.PartidaServicio;
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
public class PartidaBean implements Serializable{
    
    private List<Partida> Partidas;
    
    private Partida partida;
    
    private Partida partidaSeleccionada;
    
    private String tituloFormulario;
    
    private boolean nuevo;
    
    private boolean enNueva;
    private boolean enModificar;
    private boolean enDetalles;
    
    @EJB
    private PartidaServicio partidaServicio;
    
    @PostConstruct
    public void postConstructor() {
        this.Partidas = this.partidaServicio.obtenerPartida();
    }

    public void nuevaPartida() {
        this.partida = new Partida();
        this.enNueva =true;
        this.tituloFormulario = "Creación de Partida";
    }
    
    public void modificarPartida() {
        if (this.partidaSeleccionada!=null) {
            this.tituloFormulario = "Modificación de Partida";
            this.copiarPartidaSeleccionada();
            this.enModificar = true;
        }
    }
    
    
    public void detallesPartida() {
        if (this.partidaSeleccionada!=null) {
            this.tituloFormulario = "Detalles de Partida";
            this.copiarPartidaSeleccionada();
            this.enDetalles = true;
        }
    }
    
    public void guardarPartida() {
        if (this.enNueva) {
            try {
                this.partidaServicio.crearPartida(this.partida);
                this.enNueva = false;
                this.Partidas = this.partidaServicio.obtenerPartida();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Partida Creada","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear Partida.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            try {
                this.partidaServicio.crearPartida(this.partida);
                this.enModificar = false;
                this.Partidas = this.partidaServicio.obtenerPartida();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Partida Actualizada","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar la Partida.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
    
    public void eliminarPartida() {
        if (this.partidaSeleccionada!= null) {
            try {
                this.copiarPartidaSeleccionada();
                this.partidaServicio.eliminarPartida(this.partida.getCodigoPartida());
                this.Partidas = this.partidaServicio.obtenerPartida();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Partida Eliminada","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Partida. ", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }
    
     private void copiarPartidaSeleccionada() {
        this.partida = new Partida();
        this.partida.setCodigoPartida(this.partidaSeleccionada.getCodigoPartida());
        this.partida.setDesPartida(this.partidaSeleccionada.getDesPartida());
        
    }
     
    public void cancelar() {
        this.enNueva=false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public void selectPartidaFromDialog(Partida partida) {
        RequestContext.getCurrentInstance().closeDialog(partida);
    }

    public List<Partida> getPartidas() {
        return Partidas;
    }

    public void setPartidas(List<Partida> Partidas) {
        this.Partidas = Partidas;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Partida getPartidaSeleccionada() {
        return partidaSeleccionada;
    }

    public void setPartidaSeleccionada(Partida partidaSeleccionada) {
        this.partidaSeleccionada = partidaSeleccionada;
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

    public PartidaServicio getPartidaServicio() {
        return partidaServicio;
    }

    public void setPartidaServicio(PartidaServicio partidaServicio) {
        this.partidaServicio = partidaServicio;
    }

    
}
