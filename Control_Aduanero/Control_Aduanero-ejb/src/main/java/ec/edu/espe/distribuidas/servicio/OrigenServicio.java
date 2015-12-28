/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.Origen;
import ec.edu.espe.distribuidas.modelo.Usuario;
import ec.edu.espe.distribuidas.modelo.dao.OrigenDAO;
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
public class OrigenServicio {
   @EJB
   OrigenDAO OrigenDAO;
    
    public void crearOrigen(Origen origen) {
        this.OrigenDAO.insert(origen);
    }
    
    public Origen obtenerOrigenPorCodigo(String codigo) {
        return this.OrigenDAO.findById(codigo, false);
    }
    public List<Origen> obtenerOrigen() {
        return this.OrigenDAO.findAll();
    }
    
    public void actualizarOrigen(Origen origen) {
        this.OrigenDAO.update(origen);        
    }
   
    public void eliminarOrigen(String codigo) {
        Origen origen = this.OrigenDAO.findById(codigo, false);
        this.OrigenDAO.remove(origen);
    }
    
}
