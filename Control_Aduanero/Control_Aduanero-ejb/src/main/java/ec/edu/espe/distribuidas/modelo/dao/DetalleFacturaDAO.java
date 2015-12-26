/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import ec.edu.espe.distribuidas.modelo.DetalleFactura;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Marco Antonio
 */
@LocalBean
@Stateless
public class DetalleFacturaDAO extends DefaultGenericDAOImple<DetalleFactura, Integer>{
    
      public DetalleFacturaDAO() {
        super(DetalleFactura.class);
    }
    

}
