/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "CABECERA_DECLARACION_02")
public class CabeceraDeclaracion implements Serializable {
    
    @Id 
    @SequenceGenerator(name = "CABECERA_DECLARACION_02_SEQ", sequenceName = "CABECERA_DECLARACION_02_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CABECERA_DECLARACION_02_SEQ")      
    @Column(name = "COD_CABECERA",nullable = false)       
    private String codigoCabecera;
    
    @Column(name = "CEDULA",nullable = false)       
    private String cedula;
    
    @Column(name = "FECHA_LLEGADA",nullable = false)       
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    
    @Column(name = "TOTAL_PRODUCTO",nullable = false)       
    private BigDecimal totalProducto;
    
    @Column(name = "TOTAL_ARANCEL",nullable = false) 
    private BigDecimal totalArancel;
    
    @Column(name = "TOTAL",nullable = false) 
    private BigDecimal total;
    
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Importador importador;

    public Importador getImportador() {
        return importador;
    }

    public void setImportador(Importador importador) {
        this.importador = importador;
    }
    
    

    public String getCodigoCabecera() {
        return codigoCabecera;
    }

    public String getCedula() {
        return cedula;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setCodigoCabecera(String codigoCabecera) {
        this.codigoCabecera = codigoCabecera;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.codigoCabecera != null ? this.codigoCabecera.hashCode() : 0);
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
        final CabeceraDeclaracion other = (CabeceraDeclaracion) obj;
        if ((this.codigoCabecera == null) ? (other.codigoCabecera != null) : !this.codigoCabecera.equals(other.codigoCabecera)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CabeceraDeclaracion{" + "codigoCabecera=" + codigoCabecera + ", cedula=" + cedula + ", fechaLlegada=" + fechaLlegada + ", totalProducto=" + totalProducto + ", totalArancel=" + totalArancel + ", total=" + total + '}';
    }
    
   
    
}
