/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.modelo;

import java.io.Serializable;
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
@Table(name = "USUARIO_02")


public class Usuario implements Serializable {
  
    @Id 
    @SequenceGenerator(name = "USUARIO_02_SEQ", sequenceName = "USUARIO_02_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USUARIO_02_SEQ")
    @Column(name = "COD_USUARIO",nullable = false)       
    private String codigoUsuario;
     
    @Column(name = "COD_IMPORTADOR",nullable = false)       
    private String codigoImportador;
    
    @Column(name = "TIPO_USUARIO",nullable = false)       
    private String tipoUsuario;
    
    @Column(name = "NOMBRE",nullable = false)       
    private String nombre;
    
    @Column(name = "CLAVE",nullable = false) 
    private String clave;
    
    @Column(name = "FECHA_REGISTRO",nullable = false)       
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @JoinColumn(name = "COD_IMPORTADOR", referencedColumnName = "COD_IMPORTADOR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Importador importador;
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getCodigoImportador() {
        return codigoImportador;
    }


    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public Importador getImportador() {
        return importador;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public void setCodigoImportador(String codigoImportador) {
        this.codigoImportador = codigoImportador;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setImportador(Importador importador) {
        this.importador = importador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.codigoUsuario != null ? this.codigoUsuario.hashCode() : 0);
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
        if ((this.codigoUsuario == null) ? (other.codigoUsuario != null) : !this.codigoUsuario.equals(other.codigoUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigoUsuario=" + codigoUsuario + ", codigoImportador=" + codigoImportador + ", TipoUsuario=" + tipoUsuario + ", nombre=" + nombre + ", clave=" + clave + ", fechaRegistro=" + fechaRegistro + ", importador=" + importador + '}';
    }

  
    
}
