package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento{
    String bandaPrincipal;

    public Concierto(Evento evento, String bandaPrincipal){
        this(evento.consultarNombre(), evento.consultarFecha(), evento.consultarRecinto(), evento.consultarPrecioEntrada(), bandaPrincipal);
    }

    public Concierto(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String bandaPrincipal) {
        super(nombre, fecha, recinto, precioEntrada);
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
