/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.Operador;
import ec.edu.espe.distribuidas.modelo.Usuario;
import ec.edu.espe.distribuidas.modelo.dao.UsuarioDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Marco Antonio
 */
@LocalBean
@Stateless
public class Usuario2Servicio {
    @EJB
   UsuarioDAO UsuarioDAO;
    
    public void crearUsuario(Usuario usuario) {
        this.UsuarioDAO.insert(usuario);
    }
    
    public Usuario obtenerUsuarioPorCedula(String codigo) {
        return this.UsuarioDAO.findById(codigo, false);
    }
    public List<Usuario> obtenerUsuario() {
        return this.UsuarioDAO.findAll();
    }
    
    public void actualizarUsuario(Usuario usuario) {
        this.UsuarioDAO.update(usuario);        
    }
   
    public void eliminarUsuario(String codigo) {
        Usuario usuario = this.UsuarioDAO.findById(codigo, false);
        this.UsuarioDAO.remove(usuario);
    }
}
