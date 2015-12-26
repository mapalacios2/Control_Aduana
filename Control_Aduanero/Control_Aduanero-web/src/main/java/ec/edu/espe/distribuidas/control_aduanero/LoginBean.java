/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.control_aduanero;

import ec.edu.espe.distribuidas.servicio.UsuarioServicio;
import java.awt.event.ActionEvent;
import java.io.Serializable;
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
public class LoginBean implements Serializable{
    
    private String usuario;
    private String password;
    private boolean logeado = false;
    @EJB
    private UsuarioServicio usuarioServicio;
    
     public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean valid = usuarioServicio.validar(usuario, password);
            if (valid) {
                logeado = true;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto de: ", usuario);
            } else {
                logeado = false;
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                        "Credenciales no validas");
                context.addCallbackParam("view", "/faces/index.xhtml");
            }
            FacesContext.getCurrentInstance().addMessage(null, msg);
            context.addCallbackParam("estaLogeado", logeado);
            if (logeado) {
                context.addCallbackParam("view", "faces/principal.xhtml");
            }
        
            
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
