package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Partido extends Evento{
    String equipoLocal;
    String equipoVisitante;

    public Partido(){}

    public Partido(String id,String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String equipoLocal, String equipoVisitante) {
        super(nombre, fecha, recinto, precioEntrada, id);
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
