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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "DECLARACION_02")
public class Declaracion implements Serializable{
    
    @Id    
    @Column(name = "COD_DECLARACION",nullable = false)       
    private Integer codigoDeclaracion;
    
    @Column(name = "COD_OPERADOR",nullable = false)       
    private String codigoOperador;
    
    @Column(name = "COD_ORIGEN",nullable = false)       
    private String codigoOrigen;
    
    @Column(name = "COD_PUERTO",nullable = false)       
    private String codigoPuerto;
    
    @Column(name = "COD_PRODUCTO",nullable = false)       
    private String codigoProducto;
    
    @Column(name = "COD_DETALLE",nullable = false)       
    private Integer codigoDetalle;
    
    @Column(name = "CAN_PRODUCTO",nullable = false) 
    private Integer cantidadProducto;
    
    @Column(name = "TOTAL_PRODUCTO",nullable = false) 
    private BigDecimal totalProducto;
    
    @Column(name = "TOTAL_ARANCEL",nullable = false) 
    private BigDecimal totalArancel;
    
    @JoinColumn(name = "COD_ORIGEN", referencedColumnName = "COD_ORIGEN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Origen origen;
    
    @JoinColumn(name = "COD_PUERTO", referencedColumnName = "COD_PUERTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PuertoIngreso puertoIngreso;
    
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    
    @JoinColumn(name = "COD_OPERADOR", referencedColumnName = "COD_OPERADOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Operador operador;

    public Integer getCodigoDeclaracion() {
        return codigoDeclaracion;
    }

    public String getCodigoOperador() {
        return codigoOperador;
    }

    public String getCodigoOrigen() {
        return codigoOrigen;
    }

    public String getCodigoPuerto() {
        return codigoPuerto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public Integer getCodigoDetalle() {
        return codigoDetalle;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public BigDecimal getTotalProducto() {
        return totalProducto;
    }

    public BigDecimal getTotalArancel() {
        return totalArancel;
    }

    public void setCodigoDeclaracion(Integer codigoDeclaracion) {
        this.codigoDeclaracion = codigoDeclaracion;
    }

    public void setCodigoOperador(String codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public void setCodigoOrigen(String codigoOrigen) {
        this.codigoOrigen = codigoOrigen;
    }

    public void setCodigoPuerto(String codigoPuerto) {
        this.codigoPuerto = codigoPuerto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setCodigoDetalle(Integer codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public void setTotalProducto(BigDecimal totalProducto) {
        this.totalProducto = totalProducto;
    }

    public void setTotalArancel(BigDecimal totalArancel) {
        this.totalArancel = totalArancel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.codigoDeclaracion);
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
        final Declaracion other = (Declaracion) obj;
        if (!Objects.equals(this.codigoDeclaracion, other.codigoDeclaracion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Declaracion{" + "codigoDeclaracion=" + codigoDeclaracion + ", codigoOperador=" + codigoOperador + ", codigoOrigen=" + codigoOrigen + ", codigoPuerto=" + codigoPuerto + ", codigoProducto=" + codigoProducto + ", codigoDetalle=" + codigoDetalle + ", cantidadProducto=" + cantidadProducto + ", totalProducto=" + totalProducto + ", totalArancel=" + totalArancel + '}';
    }
    
    
    
}