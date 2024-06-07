
package com.mycompany.autofinance.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Arrendatario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_arrendatario;
    private String nombre;
    private String apellido;
    private String DNI;
    private String direccion;
    private String telefono;

    public Arrendatario() {
    }

    public Arrendatario(int id_arrendatario, String nombre, String apellido, String DNI, String direccion, String telefono) {
        this.id_arrendatario = id_arrendatario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId_arrendatario() {
        return id_arrendatario;
    }

    public void setId_arrendatario(int id_arrendatario) {
        this.id_arrendatario = id_arrendatario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
