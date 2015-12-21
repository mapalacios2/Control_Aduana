/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "DETALLE_FACTURA_02")
public class DetalleFactura implements Serializable{
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_DETALLE",nullable = false)       
    private Integer codigoDetalle;
    
    @Column(name = "COD_DECLARACION",nullable = false)       
    private Integer codigoDeclaracion;
    
    @Column(name = "COD_FACTURA",nullable = false)       
    private String codigoFactura;
    
    @Column(name = "TOTAL",nullable = false)       
    private BigDecimal total;
    
    @JoinColumn(name = "COD_DECLARACION", referencedColumnName = "COD_DECLARACION", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Declaracion declaracion;
    
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CabeceraFactura cabeceraFactura;

    public Integer getCodigoDetalle() {
        return codigoDetalle;
    }

    public Integer getCodigoDeclaracion() {
        return codigoDeclaracion;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setCodigoDetalle(Integer codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public void setCodigoDeclaracion(Integer codigoDeclaracion) {
        this.codigoDeclaracion = codigoDeclaracion;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.codigoDetalle);
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
        final DetalleFactura other = (DetalleFactura) obj;
        if (!Objects.equals(this.codigoDetalle, other.codigoDetalle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "codigoDetalle=" + codigoDetalle + ", codigoDeclaracion=" + codigoDeclaracion + ", codigoFactura=" + codigoFactura + ", total=" + total + '}';
    }
    
    
    
}
