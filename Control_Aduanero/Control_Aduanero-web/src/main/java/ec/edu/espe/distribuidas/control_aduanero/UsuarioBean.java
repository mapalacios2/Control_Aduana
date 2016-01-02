/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import ec.edu.espe.distribuidas.modelo.Usuario;
import ec.edu.espe.distribuidas.servicio.Usuario2Servicio;
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
public class UsuarioBean implements Serializable {
    private List<Usuario> Usuarios;
    
    private Usuario usuario;

    private Usuario UsuarioSeleccionado;
    
    private String tituloFormulario;
    
    private boolean nuevo;
    
    private boolean enNueva;
    private boolean enModificar;
    private boolean enDetalles;
    
    @EJB
    private Usuario2Servicio Usuario2Servicio;
    
    @PostConstruct
    public void postConstructor() {
        this.Usuarios = this.Usuario2Servicio.obtenerUsuario();
    }

    public void nuevoUsuario() {
        this.usuario = new Usuario();
        this.enNueva =true;
        this.tituloFormulario = "Creación de Usuario";
    }
    
    public void modificarUsuario() {
        if (this.UsuarioSeleccionado!=null) {
            this.tituloFormulario = "Modificación de Usuario";
            this.copiarUsuarioSeleccionado();
            this.enModificar = true;
        }
    }
    
    
    public void detallesUsuario() {
        if (this.UsuarioSeleccionado!=null) {
            this.tituloFormulario = "Detalles de Usuario";
            this.copiarUsuarioSeleccionado();
            this.enDetalles = true;
        }
    }
    
    public void guardarUsuario() {
        if (this.enNueva) {
            try {
                this.Usuario2Servicio.crearUsuario(this.usuario);
                this.enNueva = false;
                this.Usuarios = this.Usuario2Servicio.obtenerUsuario();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Creado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear Usuario.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } else {
            try {
                this.Usuario2Servicio.crearUsuario(this.usuario);
                this.enModificar = false;
                this.Usuarios = this.Usuario2Servicio.obtenerUsuario();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Actualizado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar Usuario.", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
    
    public void eliminarUsuario() {
        if (this.UsuarioSeleccionado!= null) {
            try {
                this.copiarUsuarioSeleccionado();
                this.Usuario2Servicio.eliminarUsuario(this.usuario.getCodigoUsuario());
                this.Usuarios = this.Usuario2Servicio.obtenerUsuario();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Eliminado","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Usuario. ", e.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }
    
     private void copiarUsuarioSeleccionado() {
        this.usuario= new Usuario();
        this.usuario.setCodigoUsuario(this.UsuarioSeleccionado.getCodigoUsuario());
        this.usuario.setCodigoImportador(this.UsuarioSeleccionado.getCodigoImportador());
//        this.usuario.setTipoUsuario(this.UsuarioSeleccionado.getTipoUsuario());        
        this.usuario.setNombre(this.UsuarioSeleccionado.getNombre());
        this.usuario.setClave(this.UsuarioSeleccionado.getClave());
        this.usuario.setFechaRegistro(this.UsuarioSeleccionado.getFechaRegistro());
        
    }
     
    public void cancelar() {
        this.enNueva=false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public void selectUsuarioFromDialog(Usuario usuario) {
        RequestContext.getCurrentInstance().closeDialog(usuario);
    }

    public List<Usuario> getUsuarios() {
        return Usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Usuario getUsuarioSeleccionado() {
        return UsuarioSeleccionado;
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

    public Usuario2Servicio getUsuario2Servicio() {
        return Usuario2Servicio;
    }

    public void setUsuarios(List<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setUsuarioSeleccionado(Usuario UsuarioSeleccionado) {
        this.UsuarioSeleccionado = UsuarioSeleccionado;
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

    public void setUsuario2Servicio(Usuario2Servicio Usuario2Servicio) {
        this.Usuario2Servicio = Usuario2Servicio;
    }
   
   
}
