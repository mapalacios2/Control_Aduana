/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.servicio;

import ec.edu.espe.distribuidas.modelo.Producto;
import ec.edu.espe.distribuidas.modelo.dao.ProductoDAO;
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
public class ProductoServicio {
    @EJB
    ProductoDAO productoDAO;
    
    public void crearProducto(Producto producto){
        this.productoDAO.insert(producto);
    }
    
    public Producto obtenerProductoPorCodigo(String codigo){
        return this.productoDAO.findById(codigo, false);
    }
    
    public List<Producto> obtenerProducto(){
        return this.productoDAO.findAll();
    }
    
    public void actualizarProducto(Producto producto){
        this.productoDAO.update(producto);
    }
    
    public void eliminarProducto(String codigo){
        Producto producto = this.productoDAO.findById(codigo, false);
        this.productoDAO.remove(producto);
    }
    
}
