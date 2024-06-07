
package com.mycompany.autofinance.logica;

import com.mycompany.autofinance.persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String marcaymodelo, String kilometraje, String precio,
            String nombre, String apellidos, String dni, String direccion,
            String telefono, String trabajoactual, String antecedentes, String observaciones) {
      
     Arrendatario arrendatario = new Arrendatario();
     arrendatario.setNombre(nombre);
     arrendatario.setApellido(apellidos);
     arrendatario.setDNI(dni);
     arrendatario.setDireccion(direccion);
     arrendatario.setTelefono(telefono);
     
     Vehiculo vehiculo = new Vehiculo();
     vehiculo.setMarcaymodelo(marcaymodelo);
     vehiculo.setKilometraje(kilometraje);
     vehiculo.setPrecio(precio);
     vehiculo.setUnArrendatario(arrendatario);
     
     
     controlPersis.guardar(arrendatario,vehiculo);
    }
    
}
