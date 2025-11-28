package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Partido extends Evento{
    String equipoLocal;
    String equipoVisitante;

    public Partido(){}

    public Partido(Evento evento, String equipoLocal, String equipoVisitante){
        this(evento.consultarNombre(), evento.consultarFecha(), evento.consultarRecinto(), evento.consultarPrecioEntrada(), equipoLocal, equipoVisitante);
    }

    public Partido(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String equipoLocal, String equipoVisitante) {
        super(nombre, fecha, recinto, precioEntrada);
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }


    public String consultarEquipoLocal(){
        return this.equipoLocal;
    }

    public String consultarEquipoVisitante(){
        return this.equipoVisitante;
    }
}
