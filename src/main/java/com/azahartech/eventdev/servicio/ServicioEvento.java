package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.pagos.ProcesadorPago;

import java.util.*;
import java.time.LocalDate;

public class ServicioEvento {
    private Scanner scanner = new Scanner(System.in);

    private Evento eventoDePrueba;
    private Usuario usuarioDePrueba;
//    private Evento[] carteleraDestacados = new Evento[5];
//    private ArrayList<Evento> listaEventos;
    private RepositorioGenerico<Evento> repositorio = new RepositorioGenerico();
    private HashMap<String, Evento> mapaEventos = new HashMap<>();

    public ServicioEvento(){
        //this.eventoDePrueba = new Evento("Evento", LocalDate.now(), new Recinto("recinto1", "direccion1", 90), 12);
        this.usuarioDePrueba = new Usuario("Usuario", "a@a", false);
        this.usuarioDePrueba.cambiarDetallePago(new DetallePago("visa", "1234"));
//        this.listaEventos = new ArrayList<>();
    }

    public boolean isEmpty(){
        return mapaEventos.isEmpty();
    }

    public HashMap<String, Evento> listar(){
        return mapaEventos;
    }

    public Tique realizarCompra(Usuario usuario, Evento evento, int cantidad, ProcesadorPago pasarela){
        Tique resultado;
        double costaTotal = evento.consultarPrecioEntrada() * cantidad;
        boolean pagoExitoso = pasarela.procesarPago(costaTotal);
        if (pagoExitoso){
            resultado = new Tique(evento, usuario);
        } else {
            System.err.println("El pago ha sido rechazado.");
            resultado = null;
        }
        return resultado;
    }

//    public Tique realizarCompra(int cantidad){
//        this.usuarioDePrueba.consultarDetallePago().realizarPago(this.eventoDePrueba.consultarPrecioEntrada() * cantidad);
//        this.eventoDePrueba.registrarVenta();
//        return new Tique(this.eventoDePrueba, this.usuarioDePrueba);
//    }

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

    public long contarEventosPorAforo(int aforoMinimo){
        return this.mapaEventos.values().stream().filter(evento -> evento.consultarRecinto().consultarAforoMaximo() > aforoMinimo).count();
    }

    public Evento buscarEventosPorPatron(String texto){
        return mapaEventos.values().stream().filter(evento -> evento.consultarNombre().matches("(?i).*" + texto + ".*")).findFirst().orElse(null);
    }

    public void generarInformeFinanciero(){
        for (Evento evento : mapaEventos.values()) {
            System.out.printf("Evento:\t %s\n", evento.consultarNombre());
            System.out.printf("\tCoste operativo: %d EUR\n", evento.calcularCosteOperativo());
            System.out.printf("\tPrecio sugerido: %d EUR\n", evento.calcularPrecioVentaRecomendado());
        }
    }

    public void procesarCierreEventos(){
        for (Evento evento : this.mapaEventos.values()) {
            if (evento.getEstado() == EstadoEvento.ACTIVO){
                if (evento instanceof Partido){
                    System.out.println("Cerrando partido: " + evento.consultarNombre());
                    System.out.println("Dime el resultado del partido (X-X): ");
                    ((Partido) evento).setResultadoMarcador(scanner.nextLine());
                } else if (evento instanceof Concierto) {
                    System.out.println("Cerrando concierto: " + evento.consultarNombre());
                    System.out.println("Dime las canciones que has tocado: ");
                    ((Concierto) evento).setListaCanciones(scanner.nextLine());
                } else {
                    System.out.println("Cerrando evento genérico");
                }
                evento.setEstado(EstadoEvento.FINALIZADO);
            }
        }
        this.mapaEventos.values().stream().filter(evento -> evento.getEstado() == EstadoEvento.FINALIZADO).forEach(evento -> System.out.println(evento.aCSV()));
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
