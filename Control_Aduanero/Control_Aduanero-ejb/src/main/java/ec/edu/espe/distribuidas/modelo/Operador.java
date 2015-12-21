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
@Table(name = "OPERADOR_02")


public class Operador implements Serializable{
    @Id    
    @Column(name = "COD_OPERADOR",nullable = false)       
    private String codigoOperador;
    

    @Column(name = "COD_TIPO_OPERADOR",nullable = false)       
    private String codigoTipoOperador;
    
    @Column(name = "NOMBRE",nullable = false)       
    private String nombre;
    
    @Column(name = "IDENTIFICACION",nullable = false) 
    private String identificacion;
    
    @Column(name = "DIRECCION",nullable = false) 
    private String direccion;
    
    @Column(name = "TELEFONO",nullable = false) 
    private String telefono;
    
    @JoinColumn(name = "COD_TIPO_OPERADOR", referencedColumnName = "COD_TIPO_OPERADOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoOperador tipoOperador;

    public String getCodigoOperador() {
        return codigoOperador;
    }

    public String getCodigoTipoOperador() {
        return codigoTipoOperador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCodigoOperador(String codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public void setCodigoTipoOperador(String codigoTipoOperador) {
        this.codigoTipoOperador = codigoTipoOperador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.codigoOperador);
        hash = 73 * hash + Objects.hashCode(this.codigoTipoOperador);
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
        final Operador other = (Operador) obj;
        if (!Objects.equals(this.codigoOperador, other.codigoOperador)) {
            return false;
        }
        if (!Objects.equals(this.codigoTipoOperador, other.codigoTipoOperador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Operador{" + "codigoOperador=" + codigoOperador + ", codigoTipoOperador=" + codigoTipoOperador + ", nombre=" + nombre + ", identificacion=" + identificacion + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
    
}
