/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autofinance.persistencia;

import com.mycompany.autofinance.logica.Arrendatario;
import com.mycompany.autofinance.logica.Vehiculo;

public class ControladoraPersistencia {
    ArrendatarioJpaController arrendatarioJpa = new ArrendatarioJpaController();
    VehiculoJpaController vehiculoJpa = new VehiculoJpaController();

    public void guardar(Arrendatario arrendatario, Vehiculo vehiculo) {
       
        arrendatarioJpa.create(arrendatario);
        
        vehiculoJpa.create(vehiculo);
   
    }
    
    
    
}
