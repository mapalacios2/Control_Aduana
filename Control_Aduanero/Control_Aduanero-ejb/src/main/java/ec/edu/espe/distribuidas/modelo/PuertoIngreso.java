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
import javax.persistence.Table;

/**
 *
 * @author Marco Antonio
 */
@Entity
@Table(name = "PUERTO_INGRESO_02")
public class PuertoIngreso implements Serializable{
    
     
    @Id    
    @Column(name = "COD_PUERTO",nullable = false)       
    private String codigoPuerto;
    
    @Column(name = "NOMBRE",nullable = false)       
    private String nombre;
    
    @Column(name = "DIRECCION",nullable = false)       
    private String direccion;
    
    @Column(name = "TELEFONO",nullable = false)       
    private String telefono;

    public String getCodigoPuerto() {
        return codigoPuerto;
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

    public void setCodigoPuerto(String codigoPuerto) {
        this.codigoPuerto = codigoPuerto;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.codigoPuerto);
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
        final PuertoIngreso other = (PuertoIngreso) obj;
        if (!Objects.equals(this.codigoPuerto, other.codigoPuerto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PuertoIngreso{" + "codigoPuerto=" + codigoPuerto + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
    
}

