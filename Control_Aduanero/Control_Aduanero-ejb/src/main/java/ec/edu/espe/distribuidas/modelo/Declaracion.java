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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "DECLARACION_02")
public class Declaracion implements Serializable{
    
    @Id 
    @SequenceGenerator(name = "DELCARACION_02_SEQ", sequenceName = "DELCARACION_02_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DELCARACION_02_SEQ")    
    @Column(name = "COD_DECLARACION",nullable = false)       
    private Integer codigoDeclaracion;
    
    @Column(name = "COD_IMPORTADOR",nullable = false)       
    private String codigoImportador;
    
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
    
    @Column(name = "FECHA_LLEGADA",nullable = false) 
     @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    
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
    
    @JoinColumn(name = "COD_IMPORTADOR", referencedColumnName = "COD_IMPORTADOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Importador importador;

    public Integer getCodigoDeclaracion() {
        return codigoDeclaracion;
    }

    public String getCodigoImportador() {
        return codigoImportador;
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

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public BigDecimal getTotalProducto() {
        return totalProducto;
    }

    public BigDecimal getTotalArancel() {
        return totalArancel;
    }

    public Origen getOrigen() {
        return origen;
    }

    public PuertoIngreso getPuertoIngreso() {
        return puertoIngreso;
    }

    public Producto getProducto() {
        return producto;
    }

    public Importador getImportador() {
        return importador;
    }

    public void setCodigoDeclaracion(Integer codigoDeclaracion) {
        this.codigoDeclaracion = codigoDeclaracion;
    }

    public void setCodigoImportador(String codigoImportador) {
        this.codigoImportador = codigoImportador;
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

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setTotalProducto(BigDecimal totalProducto) {
        this.totalProducto = totalProducto;
    }

    public void setTotalArancel(BigDecimal totalArancel) {
        this.totalArancel = totalArancel;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public void setPuertoIngreso(PuertoIngreso puertoIngreso) {
        this.puertoIngreso = puertoIngreso;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setImportador(Importador importador) {
        this.importador = importador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.codigoDeclaracion != null ? this.codigoDeclaracion.hashCode() : 0);
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
        if (this.codigoDeclaracion != other.codigoDeclaracion && (this.codigoDeclaracion == null || !this.codigoDeclaracion.equals(other.codigoDeclaracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Declaracion{" + "codigoDeclaracion=" + codigoDeclaracion + ", codigoImportador=" + codigoImportador + ", codigoOrigen=" + codigoOrigen + ", codigoPuerto=" + codigoPuerto + ", codigoProducto=" + codigoProducto + ", codigoDetalle=" + codigoDetalle + ", cantidadProducto=" + cantidadProducto + ", fechaLlegada=" + fechaLlegada + ", totalProducto=" + totalProducto + ", totalArancel=" + totalArancel + ", origen=" + origen + ", puertoIngreso=" + puertoIngreso + ", producto=" + producto + ", importador=" + importador + '}';
    }

    
    
    
    
}