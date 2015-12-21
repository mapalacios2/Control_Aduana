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
@Table(name = "TIPO_OPERADOR_02")
public class TipoOperador implements Serializable {
    
    @Id    
    @Column(name = "COD_TIPO_OPERADOR",nullable = false)       
    private String codigoTipoOperador;
    
    @Column(name = "DESCRIPCION",nullable = false)       
    private String descripcion;

    public String getCodigoTipoOperador() {
        return codigoTipoOperador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigoTipoOperador(String codigoTipoOperador) {
        this.codigoTipoOperador = codigoTipoOperador;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.codigoTipoOperador);
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
        final TipoOperador other = (TipoOperador) obj;
        if (!Objects.equals(this.codigoTipoOperador, other.codigoTipoOperador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoOperador{" + "codigoTipoOperador=" + codigoTipoOperador + ", descripcion=" + descripcion + '}';
    }
    
    
}

