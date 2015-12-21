/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import ec.edu.espe.distribuidas.modelo.Operador;

/**
 *
 * @author Marco Antonio
 */
public class OperadorDAO extends DefaultGenericDAOImple<Operador, String>{
    
      public OperadorDAO() {
        super(Operador.class);
    }
    

}
