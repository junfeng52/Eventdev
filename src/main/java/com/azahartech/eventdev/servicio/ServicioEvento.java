package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.*;

import java.util.*;
import java.time.LocalDate;

public class ServicioEvento {
    private Evento eventoDePrueba;
    private Usuario usuarioDePrueba;
//    private Evento[] carteleraDestacados = new Evento[5];
//    private ArrayList<Evento> listaEventos;
    private RepositorioGenerico<Evento> repositorio = new RepositorioGenerico();
    private Map<String, Evento> mapaEventos = new HashMap<>();

    public ServicioEvento(){
        this.eventoDePrueba = new Evento("Evento", LocalDate.now(), new Recinto("recinto1", "direccion1", 90), 12);
        this.usuarioDePrueba = new Usuario("Usuario", "a@a", false);
        this.usuarioDePrueba.cambiarDetallePago(new DetallePago("visa", "1234"));
//        this.listaEventos = new ArrayList<>();
    }

    public Tique realizarCompra(int cantidad){
        this.usuarioDePrueba.consultarDetallePago().realizarPago(this.eventoDePrueba.consultarPrecioEntrada() * cantidad);
        this.eventoDePrueba.registrarVenta();
        return new Tique(this.eventoDePrueba, this.usuarioDePrueba);
    }

    public void registrarEvento(Evento evento) {
        //this.listaEventos.add(evento);
        //this.repositorio.guardar(evento);
        this.mapaEventos.put(evento.consultarId(), evento);
    }

    public Evento buscarEventoPorId(String id){
        return this.mapaEventos.get(id);
    }

    public void eliminarEvento(String id){
        this.mapaEventos.remove(id);
    }

    public void mostrarTodoElCatalogo(){
//        for(Evento evento:this.repositorio.listar()){
//            evento.mostrarInformacion();
//        }
        for (Evento evento : this.mapaEventos.values()) {
            evento.mostrarInformacion();
        }
    }

    public Evento buscarEventoPorNombre(String nombre){
        return repositorio.listar().stream().filter(evento -> nombre.toLowerCase().equals(evento.consultarNombre().toLowerCase())).findFirst().orElse(null);
    }

    public ArrayList<Evento> obtenerEventosConAforoMayorA(int capacidad){
        ArrayList<Evento> resultado = new ArrayList<>();
        this.repositorio.listar().stream().filter(evento -> evento.consultarRecinto().consultarAforoMaximo() > capacidad).forEach(evento -> resultado.add(evento));
        return resultado;
    }

    public long contarEventosBeneficos(){
        return this.repositorio.listar().stream().filter(evento -> evento.esBenefico()).count();
    }

//    public void eliminarEventosPasados(){
//        Iterator<Evento> it = this.listaEventos.iterator();
//        while (it.hasNext()){
//            Evento eventoActual = it.next();
//            if (eventoActual.consultarFecha().isBefore(LocalDate.now())){
//                it.remove();
//                System.out.println("Eliminado evento caducado: " + eventoActual.consultarNombre());
//            }
//        }
//    }

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
