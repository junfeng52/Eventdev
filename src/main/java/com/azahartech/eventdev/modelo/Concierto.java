package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento{
    private String bandaPrincipal;
    private double costeMontaje;
    private String listaCanciones;

    public Concierto(String id, String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String bandaPrincipal, double costeMontaje){
        this(id, nombre, fecha, recinto, precioEntrada, false, bandaPrincipal, costeMontaje, TipoEvento.CONCIERTO);
    }

    public Concierto(String id,String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, boolean benefico, String bandaPrincipal, double costeMontaje, TipoEvento tipo) {
        super(nombre, fecha, recinto, precioEntrada, benefico, id, tipo);
        this.bandaPrincipal = bandaPrincipal;
        this.costeMontaje = costeMontaje;
    }

    public String consultarBandaPrincipal(){
        return this.bandaPrincipal;
    }

    public void setListaCanciones(String listaCanciones) {
        this.listaCanciones = listaCanciones;
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
    public String aXML(int indent, String name) {
        String tabs = "\t".repeat(indent);
        name = (name == null) ? "evento" : name;
        return  tabs + "<" + name + ">\n" +
                tabs + "\t<id>" + this.id + "<id>\n" +
                tabs + "\t<nombre>" + this.nombre + "</nombre>\n" +
                tabs + "\t<fecha>" + this.fecha + "</fecha>\n" +
                this.recinto.aXML(indent+1) +
                tabs + "\t<precio>" + this.precioEntrada + "</precio>\n" +
                tabs + "\t<benefico>" + this.benefico + "</benefico>\n" +
                tabs + "\t<bandaPrincipal>" + this.bandaPrincipal + "</bandaPrincipal>\n" +
                tabs + "\t<costeMontaje>" + this.costeMontaje + "</costeMontaje>\n" +
                ((this.listaCanciones != null) ? tabs + "\t<listaCanciones>" + this.listaCanciones + "</listaCanciones>\n" : "") +
                tabs + "</" + name + ">\n";
    }

    @Override
    public String aCSV() {
        return super.aCSV() + String.format(",%s,%.2f, %s", this.bandaPrincipal, this.costeMontaje, (this.listaCanciones != null) ? this.listaCanciones : "N/A");
    }
}
