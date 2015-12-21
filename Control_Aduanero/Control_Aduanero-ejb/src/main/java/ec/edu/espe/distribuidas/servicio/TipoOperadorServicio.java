/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.TipoOperador;
import ec.edu.espe.distribuidas.modelo.dao.TipoOperadorDAO;
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
public class TipoOperadorServicio {

    @EJB
   TipoOperadorDAO tipoOperadorDAO;
    
    public void crearToperador(TipoOperador toperador) {
        this.tipoOperadorDAO.insert(toperador);
    }
    
    public TipoOperador obtenerToperadorPorCedula(String codigo) {
        return this.tipoOperadorDAO.findById(codigo, false);
    }
    public List<TipoOperador> obtenerToperador() {
        return this.tipoOperadorDAO.findAll();
    }
    
    public void actualizarToperador(TipoOperador toperador) {
        this.tipoOperadorDAO.update(toperador);        
    }
    
    
    public void eliminarToperador(String codigo) {
        TipoOperador toperador = this.tipoOperadorDAO.findById(codigo, false);
        this.tipoOperadorDAO.remove(toperador);
    }
}

