/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CABECERA_FACTURA_02")
public class CabeceraFactura implements Serializable {
    
    @Id 
    @SequenceGenerator(name = "CABECERA_FACTURA_02_SEQ", sequenceName = "CABECERA_FACTURA_02_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CABECERA_FACTURA_02_SEQ")      
    @Column(name = "COD_FACTURA",nullable = false)       
    private String codigoFactura;
    
    @Column(name = "COD_DETALLE",nullable = false)       
    private Integer codigoDetalle;
    
    @Column(name = "IDENTIFICACION",nullable = false)       
    private String identificacion;
    
    @Column(name = "FECHA_EMISION",nullable = false)       
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    
    @Column(name = "TOTAL_FACTURA",nullable = false) 
    private BigDecimal totalFactura;

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public Integer getCodigoDetalle() {
        return codigoDetalle;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public BigDecimal getTotalFactura() {
        return totalFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public void setCodigoDetalle(Integer codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }


    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setTotalFactura(BigDecimal totalFactura) {
        this.totalFactura = totalFactura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigoFactura);
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
        final CabeceraFactura other = (CabeceraFactura) obj;
        if (!Objects.equals(this.codigoFactura, other.codigoFactura)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CabeceraFactura{" + "codigoFactura=" + codigoFactura + ", codigoDetalle=" + codigoDetalle + ", identificacion=" + identificacion + ", fechaEmision=" + fechaEmision + ", totalFactura=" + totalFactura + '}';
    }
   
    
    
}
