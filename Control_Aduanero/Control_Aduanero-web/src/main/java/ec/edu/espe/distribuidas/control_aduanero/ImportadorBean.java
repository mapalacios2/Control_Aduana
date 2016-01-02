/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import ec.edu.espe.distribuidas.modelo.Importador;
import ec.edu.espe.distribuidas.servicio.ImportadorServicio;
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
public class ImportadorBean implements Serializable {
    private List<Importador> Operadores;
    
    private Importador operador;
    
    private Importador OperadorSeleccionado;
    
    private String tituloFormulario;
    
    private boolean nuevo;
    
    private boolean enNueva;
    private boolean enModificar;
    private boolean enDetalles;
    
    @EJB
    private ImportadorServicio OperadorServicio;
    
    @PostConstruct
    public void postConstructor() {
        this.Operadores = this.OperadorServicio.obtenerOperador();
    }

    public void nuevoOperador() {
        this.operador = new Importador();
        this.enNueva =true;
        this.tituloFormulario = "Creación de Importador";
    }
    
    public void modificarOperador() {
        if (this.OperadorSeleccionado!=null) {
            this.tituloFormulario = "Modificación de Importador";
            this.copiarOperadorSeleccionado();
            this.enModificar = true;
        }
    }
    
    
    public void detallesOperador() {
        if (this.OperadorSeleccionado!=null) {
            this.tituloFormulario = "Detalles de Importador";
            this.copiarOperadorSeleccionado();
            this.enDetalles = true;
        }
    }
    
    public void guardarOperador() {
        if (this.enNueva) {
            try {
                this.OperadorServicio.crearOperador(this.operador);
                this.enNueva = false;
                this.Operadores = this.OperadorServicio.obtenerOperador();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Importador Creado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear Importador.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            try {
                this.OperadorServicio.crearOperador(this.operador);
                this.enModificar = false;
                this.Operadores = this.OperadorServicio.obtenerOperador();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Importador Actualizado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar Importador.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
    
    public void eliminarOperador() {
        if (this.OperadorSeleccionado!= null) {
            try {
                this.copiarOperadorSeleccionado();
                this.OperadorServicio.eliminarOperador(this.operador.getCodigoImportador());
                this.Operadores = this.OperadorServicio.obtenerOperador();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Importador Eliminado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Importador. ", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }
    
     private void copiarOperadorSeleccionado() {
        this.operador = new Importador();
        this.operador.setCodigoImportador(this.OperadorSeleccionado.getCodigoImportador());      
        this.operador.setNombre(this.OperadorSeleccionado.getNombre());
        this.operador.setDireccion(this.OperadorSeleccionado.getDireccion());
        this.operador.setTelefono(this.OperadorSeleccionado.getTelefono());
        this.operador.setCorreoElectronico(this.OperadorSeleccionado.getCorreoElectronico());
        
    }
     
    public void cancelar() {
        this.enNueva=false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public void selectOperadorFromDialog(Importador operador) {
        RequestContext.getCurrentInstance().closeDialog(operador);
    }
   
     public List<Importador> getOperadores() {
        return Operadores;
    }

    public Importador getOperador() {
        return operador;
    }

    public Importador getOperadorSeleccionado() {
        return OperadorSeleccionado;
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

    public ImportadorServicio getOperadorServicio() {
        return OperadorServicio;
    }

    public void setOperadores(List<Importador> Operadores) {
        this.Operadores = Operadores;
    }

    public void setOperador(Importador operador) {
        this.operador = operador;
    }

    public void setOperadorSeleccionado(Importador OperadorSeleccionado) {
        this.OperadorSeleccionado = OperadorSeleccionado;
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

    public void setOperadorServicio(ImportadorServicio OperadorServicio) {
        this.OperadorServicio = OperadorServicio;
    }

    
}
