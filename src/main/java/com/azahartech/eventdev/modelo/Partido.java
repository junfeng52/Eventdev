package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Partido extends Evento{
    private String equipoLocal;
    private String equipoVisitante;

    private double costeSeguridad;
    private double costeArbitraje;


    public Partido(){}

    public Partido(String id,String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String equipoLocal, String equipoVisitante, double costeSeguridad, double costeArbitraje) {
        super(nombre, fecha, recinto, precioEntrada, id);
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.costeSeguridad = costeSeguridad;
        this.costeArbitraje = costeArbitraje;
    }

    @Override
    public double calcularCosteOperativo() {
        final double COSTES_FIJOS = 2000;

        return this.costeArbitraje + this.costeSeguridad + COSTES_FIJOS;
    }

    public String consultarEquipoLocal(){
        return this.equipoLocal;
    }

    public String consultarEquipoVisitante(){
        return this.equipoVisitante;
    }

    @Override
    public String aXML() {
        return super.aXML() +
                String.format("<equipoLocal>%s<equipoLocal>\n" +
                              "<equipoVisitante>%s<equipoVisitante>\n", this.equipoLocal, this.equipoVisitante);
    }

    @Override
    public String aCSV() {
        return super.aCSV() + String.format("%s,%s", this.equipoLocal, this.equipoVisitante);
    }
}
