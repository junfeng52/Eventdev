package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Partido extends Evento{
    private String equipoLocal;
    private String equipoVisitante;

    private double costeSeguridad;
    private double costeArbitraje;

    private String resultadoMarcador;


    public Partido(){}

    public Partido(String id, String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String equipoLocal, String equipoVisitante, double costeSeguridad, double costeArbitraje){
        this(id, nombre, fecha, recinto, precioEntrada, false, TipoEvento.DEPORTE, equipoLocal, equipoVisitante, costeSeguridad, costeArbitraje);
    }

    public Partido(String id,String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, boolean benefico, TipoEvento tipo, String equipoLocal, String equipoVisitante, double costeSeguridad, double costeArbitraje) {
        super(nombre, fecha, recinto, precioEntrada, benefico, id, tipo);
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

    public void setResultadoMarcador(String resultadoMarcador) {
        this.resultadoMarcador = resultadoMarcador;
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
                tabs + "\t<equipoLocal>" + this.equipoLocal + "</equipoLocal>\n" +
                tabs + "\t<equipoVisitante>" + this.equipoVisitante + "</equipoVisitante>\n" +
                tabs + "\t<costeSeguridad>" + this.costeSeguridad + "</costeSeguridad>\n" +
                tabs + "\t<costeArbitraje>" + this.costeArbitraje + "</costeArbitraje>\n" +
                ((this.resultadoMarcador != null) ? tabs + "\t<resultadoMarcador>" + this.resultadoMarcador + "</resultadoMarcador>\n": "") +
                tabs + "</" + name + ">\n";
    }

    @Override
    public String aCSV() {
        return super.aCSV() + String.format(",%s,%s,%.2f,%.2f,%s", this.equipoLocal, this.equipoVisitante, this.costeSeguridad, this.costeArbitraje, (this.resultadoMarcador != null) ? this.resultadoMarcador : "N/A");
    }
}
