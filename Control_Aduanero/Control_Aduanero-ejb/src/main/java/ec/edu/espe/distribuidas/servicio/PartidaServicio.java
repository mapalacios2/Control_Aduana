/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.Partida;
import ec.edu.espe.distribuidas.modelo.dao.PartidaDAO;
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
public class PartidaServicio {
    
    @EJB
    PartidaDAO partidaDAO;
    
    public void crearPartida(Partida partida){
        this.partidaDAO.insert(partida);
    }
    
    public Partida obtenerPartidaPorCodigo(String codigo){
        return this.partidaDAO.findById(codigo, false);
    }
    
    public List<Partida> obtenerPartida(){
        return this.partidaDAO.findAll();
    }
    
    public void actualizarPartida(Partida partida){
        this.partidaDAO.update(partida);
    }
    
    public void eliminarPartida(String codigo){
        Partida partida = this.partidaDAO.findById(codigo, false);
        this.partidaDAO.remove(partida);
    }
}
