package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.modelo.*;

import java.time.LocalDate;

public class ServicioEvento {
    private Evento eventoDePrueba;
    private Usuario usuarioDePrueba;

    public ServicioEvento(){
        this.eventoDePrueba = new Evento("Evento", LocalDate.now(), new Recinto("recinto1", "direccion1", 90), 12);
        this.usuarioDePrueba = new Usuario("Usuario", "a@a");
        this.usuarioDePrueba.cambiarDetallePago(new DetallePago("visa", "1234"));
    }

    public Tique realizarCompra(int cantidad){
        this.usuarioDePrueba.consultarDetallePago().realizarPago(this.eventoDePrueba.consultarPrecioEntrada() * cantidad);
        this.eventoDePrueba.registrarVenta();
        return new Tique(this.eventoDePrueba, this.usuarioDePrueba);
    }
}
