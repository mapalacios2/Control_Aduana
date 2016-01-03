/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.Partida;
import ec.edu.espe.distribuidas.modelo.Subpartida;
import ec.edu.espe.distribuidas.modelo.dao.PartidaDAO;
import ec.edu.espe.distribuidas.modelo.dao.SubpartidaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author LuisAlberto
 */

@LocalBean
@Stateless
public class SubpartidaServicio {
    
    @EJB
    SubpartidaDAO subpartidaDAO;
    @EJB
    PartidaDAO partidaDAO;
    
    public void crearSubpartida(Subpartida subpartida){
        this.subpartidaDAO.insert(subpartida);
    }
    
    public Subpartida obtenerSubpartidaPorCodigo(String codigo){
        return this.subpartidaDAO.findById(codigo, false);
    }
    
    public List<Subpartida> obtenerSubpartida(){
        return this.subpartidaDAO.findAll();
    }
    
    public List<Partida> obtenerPartidas(){
        return this.partidaDAO.findAll();
    }
    
    public void actualizarSubpartida(Subpartida subpartida){
        this.subpartidaDAO.update(subpartida);
    }
    
    public void eliminarSubpartida(String codigo){
        Subpartida subpartida = this.subpartidaDAO.findById(codigo, false);
        this.subpartidaDAO.remove(subpartida);
    }
}
