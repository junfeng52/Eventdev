package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento{
    String bandaPrincipal;

    public Concierto(String id,String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String bandaPrincipal) {
        super(nombre, fecha, recinto, precioEntrada, id);
        this.bandaPrincipal = bandaPrincipal;
    }

    public String consultarBandaPrincipal(){
        return this.bandaPrincipal;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.printf("La banda principal se llama %s\n", this.bandaPrincipal);
    }
}
