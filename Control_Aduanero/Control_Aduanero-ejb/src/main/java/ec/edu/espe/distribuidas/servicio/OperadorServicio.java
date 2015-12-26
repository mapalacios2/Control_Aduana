/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.Operador;
import ec.edu.espe.distribuidas.modelo.TipoOperador;
import ec.edu.espe.distribuidas.modelo.dao.OperadorDAO;
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
public class OperadorServicio {
   @EJB
   OperadorDAO OperadorDAO;
    
    public void crearOperador(Operador operador) {
        this.OperadorDAO.insert(operador);
    }
    
    public Operador obtenerOperadorPorCedula(String codigo) {
        return this.OperadorDAO.findById(codigo, false);
    }
    public List<Operador> obtenerOperador() {
        return this.OperadorDAO.findAll();
    }
    
    public void actualizarOperador(Operador operador) {
        this.OperadorDAO.update(operador);        
    }
    
    
    public void eliminarOperador(String codigo) {
        Operador operador = this.OperadorDAO.findById(codigo, false);
        this.OperadorDAO.remove(operador);
    }
}
