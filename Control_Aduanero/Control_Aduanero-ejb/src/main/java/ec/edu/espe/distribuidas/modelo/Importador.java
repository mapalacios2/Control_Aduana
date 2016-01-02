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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "IMPORTADOR_02")


public class Importador implements Serializable{
    
    @Id 
    @Column(name = "CEDULA",nullable = false)       
    private String codigoImportador;
    
    @Column(name = "NOMBRE",nullable = false)       
    private String nombre;
    
    @Column(name = "DIRECCION",nullable = false) 
    private String direccion;
    
    @Column(name = "TELEFONO",nullable = false) 
    private String telefono;
    
    @Column(name = "CORREO_ELECTRONICO",nullable = false) 
    private String correoElectronico;

    public String getCodigoImportador() {
        return codigoImportador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCodigoImportador(String codigoImportador) {
        this.codigoImportador = codigoImportador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.codigoImportador != null ? this.codigoImportador.hashCode() : 0);
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
        final Importador other = (Importador) obj;
        if ((this.codigoImportador == null) ? (other.codigoImportador != null) : !this.codigoImportador.equals(other.codigoImportador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Importador{" + "codigoImportador=" + codigoImportador + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico + '}';
    }
    
   
    
    
}
