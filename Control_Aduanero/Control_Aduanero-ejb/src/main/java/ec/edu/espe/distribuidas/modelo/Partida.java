/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "PARTIDA_02")
public class Partida implements Serializable {
    
    @Id    
    @Column(name = "COD_PARTIDA",nullable = false)       
    private String codigoPartida;
    
    @Column(name = "DES_PARTIDA",nullable = false)       
    private String desPartida;

    public String getCodigoPartida() {
        return codigoPartida;
    }

    public String getDesPartida() {
        return desPartida;
    }

    public void setCodigoPartida(String codigoPartida) {
        this.codigoPartida = codigoPartida;
    }

    public void setDesPartida(String desPartida) {
        this.desPartida = desPartida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigoPartida);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partida other = (Partida) obj;
        if (!Objects.equals(this.codigoPartida, other.codigoPartida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Partida{" + "codigoPartida=" + codigoPartida + ", desPartida=" + desPartida + '}';
    }
    
    
    
}
