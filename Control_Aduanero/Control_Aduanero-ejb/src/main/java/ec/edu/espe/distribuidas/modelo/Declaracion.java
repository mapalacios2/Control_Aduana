/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo;



import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "DECLARACION_02")
public class Declaracion implements Serializable{
    
    @Id
    @SequenceGenerator(name = "DECLARACION_02_SEQ", sequenceName = "DECLARACION_02_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DECLARACION_02_SEQ") 
    @Column(name = "COD_DECLARACION",nullable = false)       
    private String codigoDeclaracion;
    
    @Column(name = "COD_ORIGEN",nullable = false)       
    private String codigoOrigen;
    
    @Column(name = "COD_PUERTO",nullable = false)       
    private String codigoPuerto;
    
    @Column(name = "COD_PRODUCTO",nullable = false)       
    private String codigoProducto;
    
    @Column(name = "COD_CABECERA",nullable = false)       
    private String codigoCabecera;
    
    @Column(name = "CAN_PRODUCTO",nullable = false) 
    private Integer cantidadProducto;
    
    @Column(name = "PRECIO_UNITARIO",nullable = false) 
    private BigDecimal precioUnitario;
    
    @Column(name = "VALOR_ARANCEL",nullable = false) 
    private BigDecimal valorArancel;
    
    @Column(name = "VALOR_TOTAL",nullable = false) 
    private BigDecimal valorTotal;
    
    
    @JoinColumn(name = "COD_ORIGEN", referencedColumnName = "COD_ORIGEN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Origen origen;
    
    @JoinColumn(name = "COD_PUERTO", referencedColumnName = "COD_PUERTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PuertoIngreso puertoIngreso;
    
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    
    @JoinColumn(name = "COD_CABECERA", referencedColumnName = "COD_CABECERA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CabeceraDeclaracion cabeceraDeclaracion;

    public String getCodigoCabecera() {
        return codigoCabecera;
    }

    public void setCodigoCabecera(String codigoCabecera) {
        this.codigoCabecera = codigoCabecera;
    }
    

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public BigDecimal getValorArancel() {
        return valorArancel;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setValorArancel(BigDecimal valorArancel) {
        this.valorArancel = valorArancel;
    }
    
    

    public String getCodigoDeclaracion() {
        return codigoDeclaracion;
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


    public Integer getCantidadProducto() {
        return cantidadProducto;
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


    public void setCodigoDeclaracion(String codigoDeclaracion) {
        this.codigoDeclaracion = codigoDeclaracion;
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


    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
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

    public CabeceraDeclaracion getCabeceraDeclaracion() {
        return cabeceraDeclaracion;
    }

    public void setCabeceraDeclaracion(CabeceraDeclaracion cabeceraDeclaracion) {
        this.cabeceraDeclaracion = cabeceraDeclaracion;
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
        return "Declaracion{" + "codigoDeclaracion=" + codigoDeclaracion + ", codigoOrigen=" + codigoOrigen + ", codigoPuerto=" + codigoPuerto + ", codigoProducto=" + codigoProducto + ", codigoCabecera=" + codigoCabecera + ", cantidadProducto=" + cantidadProducto + ", precioUnitario=" + precioUnitario + ", valorArancel=" + valorArancel + ", valorTotal=" + valorTotal + ", origen=" + origen + ", puertoIngreso=" + puertoIngreso + ", producto=" + producto + ", cabeceraDeclaracion=" + cabeceraDeclaracion + '}';
    }  
    
    
}