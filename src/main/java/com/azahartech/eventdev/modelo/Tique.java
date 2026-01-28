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
    public String aXML() {
        return String.format("<id>%s<id>\n" +
                "<evento>%s</evento>\n" +
                "<usuario>%s</usuario>\n" +
                "<fecha>%s</fecha>", this.id, this.evento.aXML(), this.comprador.aXML(), this.id);
    }

    @Override
    public String aCSV() {
        return String.format("%s,%s,%s,%s", this.id, this.evento.aCSV(), this.comprador.aCSV(), this.id);
    }
}
