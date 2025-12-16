package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Iterator;

public class ServicioEvento {
    private Evento eventoDePrueba;
    private Usuario usuarioDePrueba;
//    private Evento[] carteleraDestacados = new Evento[5];
    private ArrayList<Evento> listaEventos;

    public ServicioEvento(){
        this.eventoDePrueba = new Evento("Evento", LocalDate.now(), new Recinto("recinto1", "direccion1", 90), 12);
        this.usuarioDePrueba = new Usuario("Usuario", "a@a");
        this.usuarioDePrueba.cambiarDetallePago(new DetallePago("visa", "1234"));
        this.listaEventos = new ArrayList<>();
    }

    public Tique realizarCompra(int cantidad){
        this.usuarioDePrueba.consultarDetallePago().realizarPago(this.eventoDePrueba.consultarPrecioEntrada() * cantidad);
        this.eventoDePrueba.registrarVenta();
        return new Tique(this.eventoDePrueba, this.usuarioDePrueba);
    }

    public void registrarEvento(Evento evento) {
        this.listaEventos.add(evento);
    }

    public void mostrarTodoElCatalogo(){
        for(Evento evento:this.listaEventos){
            evento.mostrarInformacion();
        }

    }

    public void eliminarEventosPasados(){
        Iterator<Evento> it = this.listaEventos.iterator();
        while (it.hasNext()){
            Evento eventoActual = it.next();
            if (eventoActual.consultarFecha().isBefore(LocalDate.now())){
                it.remove();
                System.out.println("Eliminado evento caducado: " + eventoActual.consultarNombre());
            }
        }
    }

    //    public boolean añadirDestacado(Evento evento, int posicion){
//        if (posicion < 0 || posicion > 4){
//            return false;
//        }
//        if(this.carteleraDestacados[posicion] != null){
//            System.out.println("Esta posicion esta ocupada.");
//            return false;
//        }
//        System.out.println("Se ha ocupado la posicion.");
//        this.carteleraDestacados[posicion] = evento;
//        return true;
//    }
//
//    public void mostrarCartelera(){
//        for (int i = 0; i < this.carteleraDestacados.length; i++) {
//            if(this.carteleraDestacados[i] != null){
//                this.carteleraDestacados[i].mostrarInformacion();
//            }else {
//                System.out.println("Espacio Libre");
//            }
//        }
//    }
//
//    public Evento buscarDestacadoMasCaro(){
//        Evento eventoMasCaro = null;
//        double precioEventoMasCaro = 0;
//        for (int i = 0; i < this.carteleraDestacados.length; i++) {
//            if(this.carteleraDestacados[i] != null){
//                if (this.carteleraDestacados[i].consultarPrecioEntrada() > precioEventoMasCaro){
//                    eventoMasCaro = this.carteleraDestacados[i];
//                    precioEventoMasCaro = this.carteleraDestacados[i].consultarPrecioEntrada();
//                }
//            }
//        }
//        return eventoMasCaro;
//    }
}
