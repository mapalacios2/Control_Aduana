/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.Usuario;
import ec.edu.espe.distribuidas.modelo.dao.UsuarioDAO;
import ec.edu.espe.distribuidas.util.EncripcionUtil;
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
public class UsuarioServicio {
    
    @EJB
    private UsuarioDAO usuarioDAO;
    
    public boolean validar(String nombre, String clave) {
        Usuario usuTmp = new Usuario();
        usuTmp.setNombre(nombre);
        usuTmp.setClave(clave);
        if(usuarioDAO.find(usuTmp, false).isEmpty()){
            return false;
        }else return true;
            }
        }
