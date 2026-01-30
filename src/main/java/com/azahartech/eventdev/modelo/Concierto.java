package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento{
    private String bandaPrincipal;
    private double costeMontaje;

    public Concierto(String id,String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String bandaPrincipal, double costeMontaje) {
        super(nombre, fecha, recinto, precioEntrada, id);
        this.bandaPrincipal = bandaPrincipal;
        this.costeMontaje = costeMontaje;
    }

    public String consultarBandaPrincipal(){
        return this.bandaPrincipal;
    }

    @Override
    public double calcularCosteOperativo() {
        final double COSTES_FIJOS = 5000;

        return costeMontaje + COSTES_FIJOS;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.printf("La banda principal se llama %s\n", this.bandaPrincipal);
    }

    @Override
    public String aXML(int indent) {
        String tabs = "\t".repeat(indent);
        return tabs + "<evento>\n" +
                tabs + "\t<id>" + this.id + "<id>\n" +
                tabs + "\t<nombre>" + this.nombre + "</nombre>\n" +
                tabs + "\t<fecha>" + this.fecha + "</fecha>\n" +
                this.recinto.aXML(indent+1) +
                tabs + "\t<precio>" + this.precioEntrada + "</precio>\n" +
                tabs + "\t<benefico>" + this.benefico + "</benefico>\n" +
                tabs + "\t<bandaPrincipal>" + this.bandaPrincipal + "<bandaPrincipal>\n" +
                tabs + "</evento>\n";
    }

    @Override
    public String aCSV() {
        return super.aCSV() + String.format("%s", this.bandaPrincipal);
    }
}
