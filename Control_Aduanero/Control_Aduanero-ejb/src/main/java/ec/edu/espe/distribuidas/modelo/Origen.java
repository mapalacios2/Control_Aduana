/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "ORIGEN_02")
public class Origen implements Serializable {
    
    @Id 
    @SequenceGenerator(name = "ORIGEN_02_SEQ", sequenceName = "ORIGEN_02_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORIGEN_02_SEQ")      
    @Column(name = "COD_ORIGEN",nullable = false)       
    private String codigoOrigen;
    
    @Column(name = "PAIS",nullable = false)       
    private String pais;
    
    @Column(name = "PUERTO",nullable = false)       
    private String puerto;
    
    @Column(name = "FECHA_EMBARQUE",nullable = false)       
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmbarque;

    public String getCodigoOrigen() {
        return codigoOrigen;
    }

    public String getPais() {
        return pais;
    }

    public String getPuerto() {
        return puerto;
    }

    public Date getFechaEmbarque() {
        return fechaEmbarque;
    }

    public void setCodigoOrigen(String codigoOrigen) {
        this.codigoOrigen = codigoOrigen;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public void setFechaEmbarque(Date fechaEmbarque) {
        this.fechaEmbarque = fechaEmbarque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoOrigen);
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
        final Origen other = (Origen) obj;
        if (!Objects.equals(this.codigoOrigen, other.codigoOrigen)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Origen{" + "codigoOrigen=" + codigoOrigen + ", pais=" + pais + ", puerto=" + puerto + ", fechaEmbarque=" + fechaEmbarque + '}';
    }
    
    
    
}
