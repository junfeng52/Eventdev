package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;

import java.time.LocalDate;

public class Tique implements Exportable {
    private static int contadorTiquetCreados = 0;
    private String id;
    private Evento evento;
    private Usuario comprador;
    private LocalDate fechaCompra;

     public Tique(Evento evento, Usuario usuario){
         contadorTiquetCreados++;
         this.id = ""+contadorTiquetCreados;
         this.evento = evento;
         this.comprador = usuario;
         this.fechaCompra = LocalDate.now();
     }

    public static int obtenerTotalTiquets() {
        return contadorTiquetCreados;
    }

    public String consultarId() {
        return this.id;
    }

    public Evento consultarEvento() {
        return this.evento;
    }

    public void cambiarEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario consultarComprador() {
        return this.comprador;
    }

    public void cambiarComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public LocalDate consultarFechaCompra() {
        return this.fechaCompra;
    }
    

    public void mostrarInfomacion(){
         System.out.printf("El tiquet con id %s que se compro el dia %s\n", this.id, this.fechaCompra);
         this.comprador.mostrarInformacion();
         this.evento.mostrarInformacion();
     }

    @Override
    public String aXML(int indent, String name) {
        String tabs = "\t".repeat(indent);
        name = (name == null) ? "tique" : name;
        return  tabs + "<" + name + ">\n" +
                tabs + "\t<id>" + this.id + "<id>\n" +
                this.evento.aXML(indent + 1) +
                this.comprador.aXML(indent + 1, "comprador") +
                tabs + "\t<fecha>" + this.fechaCompra +"</fecha>\n" +
                tabs + "<" + name + ">\n";
    }

    @Override
    public String aCSV() {
        return String.format("%s,%s,%s,%s", this.id, this.evento.aCSV(), this.comprador.aCSV(), this.id);
    }
}
