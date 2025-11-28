package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Tique {
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
}
