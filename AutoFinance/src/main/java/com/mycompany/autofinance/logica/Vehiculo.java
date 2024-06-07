
package com.mycompany.autofinance.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehiculo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_vehiculo;
    private String marcaymodelo;
    private String kilometraje;
    private String precio;
    @OneToOne
    private Arrendatario unArrendatario; 

    public Vehiculo() {
    }

    public Vehiculo(int num_vehiculo, String marcaymodelo, String kilometraje, String precio, Arrendatario unArrendatario) {
        this.num_vehiculo = num_vehiculo;
        this.marcaymodelo = marcaymodelo;
        this.kilometraje = kilometraje;
        this.precio = precio;
        this.unArrendatario = unArrendatario;
    }

    public int getNum_vehiculo() {
        return num_vehiculo;
    }

    public void setNum_vehiculo(int num_vehiculo) {
        this.num_vehiculo = num_vehiculo;
    }

    public String getMarcaymodelo() {
        return marcaymodelo;
    }

    public void setMarcaymodelo(String marcaymodelo) {
        this.marcaymodelo = marcaymodelo;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Arrendatario getUnArrendatario() {
        return unArrendatario;
    }

    public void setUnArrendatario(Arrendatario unArrendatario) {
        this.unArrendatario = unArrendatario;
    }
    
    
}
