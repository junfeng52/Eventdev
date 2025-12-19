package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.Concierto;
import com.azahartech.eventdev.modelo.Evento;
import com.azahartech.eventdev.modelo.Recinto;
import com.azahartech.eventdev.servicio.ServicioEvento;

import java.time.LocalDate;

public class test {
    public static void main(String[] args) {
        Recinto recinto = new Recinto("recinto", "direccioin", 10);
        recinto.reservarAsientoVIP(1);
        recinto.reservarAsientoVIP(5);
        recinto.reservarAsientoVIP(10);
        recinto.reservarAsientoVIP(11);
        recinto.mostrarInformacion();

        ServicioEvento servicioEvento = new ServicioEvento();
        Evento evento1 = new Evento("eventDev1", LocalDate.now().plusDays(1), recinto, 10);
        Evento evento2 = new Evento("eventDev2", LocalDate.now().minusDays(1), recinto, 11);
        Evento evento3 = new Evento("eventDev3", LocalDate.now(), recinto, 16);
        Evento evento4 = new Evento("eventDev4", LocalDate.now(), recinto, 13);
        Evento evento5 = new Evento("eventDev5", LocalDate.now(), recinto, 14);

//        servicioEvento.añadirDestacado(evento1,0);
//        servicioEvento.añadirDestacado(evento2,2);
//        servicioEvento.añadirDestacado(evento3,4);
//
//        servicioEvento.mostrarCartelera();
        servicioEvento.registrarEvento(evento1);
        servicioEvento.registrarEvento(evento2);
        servicioEvento.registrarEvento(evento3);
        servicioEvento.registrarEvento(evento4);
        servicioEvento.registrarEvento(evento5);

        servicioEvento.mostrarTodoElCatalogo();
        servicioEvento.eliminarEventosPasados();
        servicioEvento.mostrarTodoElCatalogo();

        System.out.println(new Concierto(evento1,"").getClass());
        Evento a = new Concierto(evento1, "");
    }
}
