/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import ec.edu.espe.distribuidas.modelo.TipoOperador;

/**
 *
 * @author Marco Antonio
 */
public class TipoOperadorDAO extends DefaultGenericDAOImple<TipoOperador, String>{
    
      public TipoOperadorDAO() {
        super(TipoOperador.class);
    }
    

}
