/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.PuertoIngreso;
import ec.edu.espe.distribuidas.modelo.dao.PuertoIngresoDAO;
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
public class PuertoIngresoServicio {
   @EJB
   PuertoIngresoDAO PuertoIngresoDAO;
    
    public void crearPuertoIngreso(PuertoIngreso pingreso) {
        this.PuertoIngresoDAO.insert(pingreso);
    }
    
    public PuertoIngreso obtenerPuertoIngresoPorCodigo(String codigo) {
        return this.PuertoIngresoDAO.findById(codigo, false);
    }
    public List<PuertoIngreso> obtenerPuertoIngreso() {
        return this.PuertoIngresoDAO.findAll();
    }
    
    public void actualizarPuertoIngreso(PuertoIngreso pingreso) {
        this.PuertoIngresoDAO.update(pingreso);        
    }
   
    public void eliminarPuertoIngreso(String codigo) {
        PuertoIngreso pingreso = this.PuertoIngresoDAO.findById(codigo, false);
        this.PuertoIngresoDAO.remove(pingreso);
    }
    
}
