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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "PRODUCTO_02")
public class Producto implements Serializable{
    
    @Id 
    @SequenceGenerator(name = "PRODUCTO_02_SEQ", sequenceName = "PRODUCTO_02_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PRODUCTO_02_SEQ")     
    @Column(name = "COD_PRODUCTO",nullable = false)       
    private String codigoProducto;
    
    @Column(name = "COD_SUBPARTIDA",nullable = false)       
    private String codigoSubpartida ;
    
    @Column(name = "DESCRIPCION",nullable = false)       
    private String descripcion;
    
    @Column(name = "VALOR_PRODUCTO",nullable = false)       
    private BigDecimal valorProducto;
    
    @Column(name = "VALOR_ARANCEL",nullable = false)       
    private BigDecimal valorArancel;
    
    @Column(name = "PORCENTAJE_ARANCEL",nullable = false)       
    private BigDecimal porcentajeArancel;
    
    @JoinColumn(name = "COD_SUBPARTIDA", referencedColumnName = "COD_SUBPARTIDA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subpartida subpartida;

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getCodigoSubpartida() {
        return codigoSubpartida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getValorProducto() {
        return valorProducto;
    }

    public BigDecimal getValorArancel() {
        return valorArancel;
    }

    public BigDecimal getPorcentajeArancel() {
        return porcentajeArancel;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setCodigoSubpartida(String codigoSubpartida) {
        this.codigoSubpartida = codigoSubpartida;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValorProducto(BigDecimal valorProducto) {
        this.valorProducto = valorProducto;
    }

    public void setValorArancel(BigDecimal valorArancel) {
        this.valorArancel = valorArancel;
    }

    public void setPorcentajeArancel(BigDecimal porcentajeArancel) {
        this.porcentajeArancel = porcentajeArancel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codigoProducto);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigoProducto, other.codigoProducto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto + ", codigoSubpartida=" + codigoSubpartida + ", descripcion=" + descripcion + ", valorProducto=" + valorProducto + ", valorArancel=" + valorArancel + ", porcentajeArancel=" + porcentajeArancel + '}';
    }
    
    
}