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
    public String aXML(int indent) {
        String tabs = "\t".repeat(indent);
        return  tabs + "<evento>\n" +
                tabs + "\t<id>" + this.id + "<id>\n" +
                tabs + "\t<nombre>" + this.nombre + "</nombre>\n" +
                tabs + "\t<fecha>" + this.fecha + "</fecha>\n" +
                this.recinto.aXML(indent+1) +
                tabs + "\t<precio>" + this.precioEntrada + "</precio>\n" +
                tabs + "\t<benefico>" + this.benefico + "</benefico>\n" +
                tabs + "\t<equipoLocal>" + this.equipoLocal + "<equipoLocal>\n" +
                tabs + "\t<equipoVisitante>" + this.equipoVisitante + "<equipoVisitante>\n" +
                tabs + "</evento>\n";
    }

    @Override
    public String aCSV() {
        return super.aCSV() + String.format("%s,%s", this.equipoLocal, this.equipoVisitante);
    }
}
