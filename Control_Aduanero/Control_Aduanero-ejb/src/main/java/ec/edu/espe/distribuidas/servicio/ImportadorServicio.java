/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.Importador;
import ec.edu.espe.distribuidas.modelo.dao.ImportadorDAO;
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
public class ImportadorServicio {
   @EJB
   ImportadorDAO OperadorDAO;
    
    public void crearOperador(Importador operador) {
        this.OperadorDAO.insert(operador);
    }
    
    public Importador obtenerOperadorPorCedula(String codigo) {
        return this.OperadorDAO.findById(codigo, false);
    }
    public List<Importador> obtenerOperador() {
        return this.OperadorDAO.findAll();
    }
    
    public void actualizarOperador(Importador operador) {
        this.OperadorDAO.update(operador);        
    }
    
    
    public void eliminarOperador(String codigo) {
        Importador operador = this.OperadorDAO.findById(codigo, false);
        this.OperadorDAO.remove(operador);
    }
}
