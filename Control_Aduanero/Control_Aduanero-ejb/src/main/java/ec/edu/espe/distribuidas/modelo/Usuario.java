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
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "USUARIO_02")


public class Usuario implements Serializable {
    
    @Id    
    @Column(name = "COD_USUARIO",nullable = false)       
    private String codigoUsuario;
     
    @Column(name = "COD_OPERADOR",nullable = false)       
    private String codigoOperador;
    
    @Column(name = "COD_TIPO_OPERADOR",nullable = false)       
    private String codigoTipoOperador;
    
    @Column(name = "NOMBRE",nullable = false)       
    private String nombre;
    
    @Column(name = "CLAVE",nullable = false) 
    private String clave;
    
    @Column(name = "CORREO_ELECTRONICO",nullable = false) 
    private String correoElectronico;
    
    @Column(name = "FECHA_REGISTRO",nullable = false)       
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @JoinColumn(name = "COD_OPERADOR", referencedColumnName = "COD_OPERADOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Operador operador;
    

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getCodigoOperador() {
        return codigoOperador;
    }

    public String getCodigoTipoOperador() {
        return codigoTipoOperador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
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

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigoUsuario);
        hash = 59 * hash + Objects.hashCode(this.codigoOperador);
        hash = 59 * hash + Objects.hashCode(this.codigoTipoOperador);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.codigoUsuario, other.codigoUsuario)) {
            return false;
        }
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
        return "Usuario{" + "codigoUsuario=" + codigoUsuario + ", codigoOperador=" + codigoOperador + ", codigoTipoOperador=" + codigoTipoOperador + ", nombre=" + nombre + ", clave=" + clave + ", correoElectronico=" + correoElectronico + ", fechaRegistro=" + fechaRegistro + '}';
    }   
    
    
}
