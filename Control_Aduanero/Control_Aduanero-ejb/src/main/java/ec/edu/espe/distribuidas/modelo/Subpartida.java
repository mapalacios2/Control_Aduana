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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "SUBPARTIDA_02")

public class Subpartida implements Serializable {
    
    @Id   
    @Column(name = "COD_SUBPARTIDA",nullable = false)       
    private String codigoSubpartida;
    
    @Column(name = "COD_PARTIDA",nullable = false)       
    private String codigoPartida;
    
    @Column(name = "DES_SUBPARTIDA",nullable = false)       
    private String desSubpartida;
    
    @JoinColumn(name = "COD_PARTIDA", referencedColumnName = "COD_PARTIDA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Partida partida;

    public String getCodigoSubpartida() {
        return codigoSubpartida;
    }

    public String getCodigoPartida() {
        return codigoPartida;
    }

    public String getDesSubpartida() {
        return desSubpartida;
    }

    public void setCodigoSubpartida(String codigoSubpartida) {
        this.codigoSubpartida = codigoSubpartida;
    }

    public void setCodigoPartida(String codigoPartida) {
        this.codigoPartida = codigoPartida;
    }

    public void setDesSubpartida(String desSubpartida) {
        this.desSubpartida = desSubpartida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigoSubpartida);
        hash = 89 * hash + Objects.hashCode(this.codigoPartida);
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
        final Subpartida other = (Subpartida) obj;
        if (!Objects.equals(this.codigoSubpartida, other.codigoSubpartida)) {
            return false;
        }
        if (!Objects.equals(this.codigoPartida, other.codigoPartida)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "Subpartida{" + "codigoSubpartida=" + codigoSubpartida + ", codigoPartida=" + codigoPartida + ", desSubpartida=" + desSubpartida + '}';
    }
    
    
    
}
