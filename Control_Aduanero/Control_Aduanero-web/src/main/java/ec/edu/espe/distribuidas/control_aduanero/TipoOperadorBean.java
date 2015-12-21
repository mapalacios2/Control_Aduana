/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import ec.edu.espe.distribuidas.modelo.TipoOperador;
import ec.edu.espe.distribuidas.servicio.TipoOperadorServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class TipoOperadorBean implements Serializable{
    
    private List<TipoOperador> tipoOperadores;
    
    private TipoOperador tipoOperador;
    
    private TipoOperador toperadorSeleccionado;
    
    private String tituloFormulario;
    
    private boolean nuevo;
    
    private boolean enNueva;
    private boolean enModificar;
    private boolean enDetalles;
    
    @EJB
    private TipoOperadorServicio tOperadorServicio;
    
    @PostConstruct
    public void postConstructor() {
        this.tipoOperadores = this.tOperadorServicio.obtenerToperador();
    }

    public void nuevoToperador() {
        this.tipoOperador = new TipoOperador();
        this.enNueva =true;
        this.tituloFormulario = "Creación de TipoOperador";
    }
    
    public void modificarToperador() {
        if (this.toperadorSeleccionado!=null) {
            this.tituloFormulario = "Modificación de TipoOperador";
            this.copiarToperadorSeleccionado();
            this.enModificar = true;
        }
    }
    
    
    public void detallesToperador() {
        if (this.toperadorSeleccionado!=null) {
            this.tituloFormulario = "Detalles de TipoOperador";
            this.copiarToperadorSeleccionado();
            this.enDetalles = true;
        }
    }
    
    public void guardarToperador() {
        if (this.enNueva) {
            try {
                this.tOperadorServicio.crearToperador(this.tipoOperador);
                this.enNueva = false;
                this.tipoOperadores = this.tOperadorServicio.obtenerToperador();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo Operador Creado.", "Se ha creado el "+this.tipoOperador);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear Tipo Operador.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            try {
                this.tOperadorServicio.crearToperador(this.tipoOperador);
                this.enModificar = false;
                this.tipoOperadores = this.tOperadorServicio.obtenerToperador();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo Operador Actualizado.", "Se ha actualizado el "+this.tipoOperador);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar Tipo Operador.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
    
    public void eliminarToperador() {
        if (this.toperadorSeleccionado!= null) {
            try {
                this.copiarToperadorSeleccionado();
                this.tOperadorServicio.eliminarToperador(this.tipoOperador.getCodigoTipoOperador());
                this.tipoOperadores = this.tOperadorServicio.obtenerToperador();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo Operador Eliminado.", "Se ha eliminado el Tipo Operador " + this.tipoOperador);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Tipo Operador. ", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }
    
     private void copiarToperadorSeleccionado() {
        this.tipoOperador = new TipoOperador();
        this.tipoOperador.setCodigoTipoOperador(this.toperadorSeleccionado.getCodigoTipoOperador());
        this.tipoOperador.setDescripcion(this.toperadorSeleccionado.getDescripcion());
        
    }
     
    public void cancelar() {
        this.enNueva=false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public void selectToperadorFromDialog(TipoOperador toperador) {
        RequestContext.getCurrentInstance().closeDialog(toperador);
    }

     public List<TipoOperador> getTipoOperadores() {
        return tipoOperadores;
    }
    

    public TipoOperador getTipoOperador() {
        return tipoOperador;
    }

    public void setTipoOperador(TipoOperador tioOperador) {
        this.tipoOperador = tipoOperador;
    }
    

    public boolean isEnNueva() {
        return enNueva;
    }

    public TipoOperador getToperadorSeleccionado() {
        return toperadorSeleccionado;
    }

    public void setToperadorSeleccionado(TipoOperador toperadorSeleccionado) {
        this.toperadorSeleccionado = toperadorSeleccionado;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }
            
    public String getTituloFormulario() {
        return tituloFormulario;
    }

    public boolean isEnModificar() {
        return enModificar;
    }

    public boolean isEnDetalles() {
        return enDetalles;
    }
}
