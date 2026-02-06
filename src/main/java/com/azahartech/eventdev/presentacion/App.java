package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.pagos.PagoBizum;
import com.azahartech.eventdev.pagos.PagoPaypal;
import com.azahartech.eventdev.pagos.PagoTarjeta;
import com.azahartech.eventdev.pagos.ProcesadorPago;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.servicio.ServicioUsuario;
import com.azahartech.eventdev.util.Exportable;
import com.azahartech.eventdev.util.Notificable;
import com.azahartech.eventdev.util.UtilidadExportacion;
import com.azahartech.eventdev.util.UtilidadValidacion;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ServicioUsuario LISTA_USUARIOS = new ServicioUsuario();
    private static final ServicioEvento LISTA_EVENTO = new ServicioEvento();

    public static void main(String[] args) {

        int input = -1;

        do{
            System.out.println("Que tipo de clase quieres crear:");
            System.out.println("1. Concierto");
            System.out.println("2. Partido");
            System.out.println("3. Registrar Usuario");
            System.out.println("4. Generar Demo");
            System.out.println("5. Generar informe");
            System.out.println("6. Exportar a lista");
            System.out.println("7. Enviar mensaje");
            System.out.println("8. Simulacion de pagos");
            System.out.println("9. Prueba evento");
            System.out.println("10. Prueba estados");
            System.out.println("0. Exit");
            System.out.print("Dime la opcion: ");
            try {
                input = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (input){
                    case 0:
                        System.out.println("Salinedo del programa.");
                        break;

                    case 1:
                        pedirDatos("Concierto");
                        break;

                    case 2:
                        pedirDatos("Partido");
                        break;

                    case 3:
                        registarUsuario();
                        break;

                    case 4:
                        generarDemo();
                        break;

                    case 5:
                        generarInforme();
                        break;

                    case 6:
                        exportarALista();
                        break;

                    case 7:
                        enviarNotificacionesATodos();
                        break;

                    case 8:
                        compra();
                        break;

                    case 9:
                        pruebaRegistrarEvento();
                        break;

                    case 10:
                        pruebaEstados();
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Opcion no valida. ERROR: " + e);
                SCANNER.nextLine();
            }


        } while (input != 0);
        SCANNER.close();
    }

    // Opcion 1, 2
    private static void pedirDatos(String tipoEvento){
        Evento eventoFinal;
        Recinto recintoDelEvento = new Recinto();

        String id;
        String nombre;
        LocalDate fechaEvento;
        double precioEntrada;

        System.out.println("Dime el id del evento.");
        id = SCANNER.nextLine();

        System.out.println("Dime el nombre del evento.");
        nombre = SCANNER.nextLine();

        System.out.println("Dime la fecha del evento (Formato YYYY-MM-DD)");
        fechaEvento = LocalDate.parse(SCANNER.nextLine());
        if(UtilidadValidacion.esFechaFutura(fechaEvento)){
            System.out.println("La fecha es futura");
        }else {
            System.out.println("La fecha es pasado");
        }

        System.out.println("Dime el nombre del recinto");
        recintoDelEvento.cambiarNombre(SCANNER.nextLine());

        System.out.println("Dime la direccion del recinto");
        recintoDelEvento.cambiarDireccion(SCANNER.nextLine());

        System.out.println("Dime el aforo maximo del recinto");
        recintoDelEvento.cambiarAforoMaximo(SCANNER.nextInt());
        SCANNER.nextLine();

        System.out.println("Dime el precio del evento");
        precioEntrada = SCANNER.nextDouble();
        SCANNER.nextLine();

        switch (tipoEvento){
            case "Concierto":
                String nombreBanda;
                double costeMontage;

                System.out.println("Dime el nombre de la banda principal");
                nombreBanda = SCANNER.nextLine();

                System.out.println("Dime el coste del montaje");
                costeMontage = SCANNER.nextDouble();
                SCANNER.nextLine();

                eventoFinal = new Concierto(id, nombre, fechaEvento, recintoDelEvento, precioEntrada, nombreBanda, costeMontage);
                System.out.println(eventoFinal.obtenerCodigoReferencia());
                eventoFinal.mostrarInformacion();
                break;

            case "Partido":
                String equipoLocal;
                String equipoVisitante;

                double costeSeguridad;
                double costeArbitraje;

                System.out.println("Dime el nombre del equipo local");
                equipoLocal = SCANNER.nextLine();

                System.out.println("Dime el nombre del equipo visitante");
                equipoVisitante = SCANNER.nextLine();

                System.out.println("Dime el coste de la seguridad");
                costeSeguridad = SCANNER.nextDouble();
                SCANNER.nextLine();

                System.out.println("Dime el coste del arbitraje");
                costeArbitraje = SCANNER.nextDouble();
                SCANNER.nextLine();

                eventoFinal = new Partido(id, nombre, fechaEvento, recintoDelEvento, precioEntrada, equipoLocal, equipoVisitante, costeSeguridad, costeArbitraje);
                System.out.println(eventoFinal.obtenerCodigoReferencia());
                eventoFinal.mostrarInformacion();
                break;
        }

    }

    // Opcion 3
    private static void registarUsuario(){
        String nombre;
        String email;
        boolean vip;

        System.out.println("Dime el nombre de usuario");
        nombre = SCANNER.nextLine();

        do {
            System.out.println("Dime el email del usuario");
            email = SCANNER.nextLine();
            if(!UtilidadValidacion.esEmailValido(email)){
                System.out.println("Email no valido.");
            }
        } while (!UtilidadValidacion.esEmailValido(email));

        System.out.println("Dime si el usuario es Vip (Si/No) Defecto: No");
        vip = SCANNER.nextLine().equalsIgnoreCase("si");

        LISTA_USUARIOS.registrarUsuario(new Usuario(nombre, email, vip));
    }

    private static void registrarEvento(){
        String id;
        String nombre;
        LocalDate fecha;
        int dia, mes, año;

        Recinto recinto;
        String nombreRecinto;
        String direccionRecinto;
        int aforoMaximo;

        double precioEntrada;
        boolean benefico;

        do {
            System.out.println("Dime el id del evento");
            id = SCANNER.nextLine();
            if(!UtilidadValidacion.esCodigoEventoValido(id)){
                System.out.println("Codigo invalido. El codigo tiene que seguir este patron EVT-AAAA-XXX");
            }
        } while (!UtilidadValidacion.esCodigoEventoValido(id));

        System.out.println("Dime el nombre del evento");
        nombre = SCANNER.nextLine();

        System.out.println("Dime el dia del evento");
        dia = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.println("Dime el mes del evento");
        mes = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.println("Dime el año del evento");
        año = SCANNER.nextInt();
        SCANNER.nextLine();

        fecha = LocalDate.of(año,mes, dia);

        System.out.println("Dime el nombre del recinto");
        nombreRecinto = SCANNER.nextLine();

        System.out.println("Dime la direccion del recinto");
        direccionRecinto = SCANNER.nextLine();

        System.out.println("Dime el aforo maximo del recinto");
        aforoMaximo = SCANNER.nextInt();
        SCANNER.nextLine();

        recinto = new Recinto(nombreRecinto, direccionRecinto, aforoMaximo);

        System.out.println("Dime el precio del evento");
        precioEntrada = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.println("Dime el evento es benefico (si/no defecto: no)");
        benefico = SCANNER.nextLine().equalsIgnoreCase("si");

        //listaEvento.registrarEvento(new Evento(nombre, fecha, recinto, precioEntrada, benefico, id));
    }

    // Opcion 4
    private static void generarDemo(){
        LISTA_EVENTO.registrarEvento(new Concierto("EVT-2025-MAD" ,"evento", LocalDate.now(), new Recinto("recinto", "direccion", 100), 100, "banda", 1000));
        LISTA_EVENTO.registrarEvento(new Concierto("EVT-2027-MAD" ,"evento1", LocalDate.now(), new Recinto("recinto", "direccion", 100), 112, "banda", 1640));
        LISTA_EVENTO.registrarEvento(new Concierto("EVT-2059-MAD" ,"evento2", LocalDate.now(), new Recinto("recinto", "direccion", 100), 120, "banda", 18120));
        LISTA_EVENTO.registrarEvento(new Concierto("EVT-2023-MAD" ,"evento3", LocalDate.now(), new Recinto("recinto", "direccion", 100), 1340, "banda", 1100));
        LISTA_EVENTO.registrarEvento(new Concierto("EVT-2021-MAD" ,"evento4", LocalDate.now(), new Recinto("recinto", "direccion", 100), 10, "banda", 100));
        LISTA_EVENTO.registrarEvento(new Partido("EVT-2024-MAD", "evento5", LocalDate.now(), new Recinto("recinto", "direccion", 100), 101, "local", "visitante", 20000, 4000));
        LISTA_EVENTO.registrarEvento(new Partido("EVT-2034-MAD", "evento7", LocalDate.now(), new Recinto("recinto", "direccion", 100), 55, "local", "visitante", 3000, 40000));
        LISTA_EVENTO.registrarEvento(new Partido("EVT-2014-MAD", "evento34", LocalDate.now(), new Recinto("recinto", "direccion", 100), 50, "local", "visitante", 4000, 401));
        LISTA_EVENTO.registrarEvento(new Partido("EVT-2034-MAD", "evento251", LocalDate.now(), new Recinto("recinto", "direccion", 100), 210, "local", "visitante", 8000, 400));
        LISTA_EVENTO.registrarEvento(new Partido("EVT-2074-MAD", "evento14", LocalDate.now(), new Recinto("recinto", "direccion", 100), 410, "local", "visitante", 1000, 40010));

        LISTA_USUARIOS.registrarUsuario(new Usuario("nombrea","a@a.com", true));
        LISTA_USUARIOS.registrarUsuario(new Usuario("nombreb","b@b.com", true));
        LISTA_USUARIOS.registrarUsuario(new Usuario("nombrec","c@c.com", true));
        LISTA_USUARIOS.registrarUsuario(new Usuario("nombred","d@d.com", true));
        LISTA_USUARIOS.registrarUsuario(new Usuario("nombref","f@f.com", true));

    }
    // Opcion 5
    private static void generarInforme(){
        if (!LISTA_EVENTO.isEmpty()){
            enviarNotificacionesATodos();
        }
    }

    // Opcion 6
    private static void exportarALista(){
        if (!LISTA_EVENTO.isEmpty()) {
            ArrayList<Exportable> listaMezclada = new ArrayList<>();
            listaMezclada.add(new Usuario("nombre", "a@a.com", true));
            listaMezclada.add(new Usuario("nombre2", "b@b.com", true, new DetallePago("Mastercard", "20012312312543")));

            listaMezclada.add(new Concierto("EVT-2025-MAD", "evento", LocalDate.now(), new Recinto("recinto", "direccion", 100), 100, "banda", 1000));
            listaMezclada.add(new Partido("EVT-2024-MAD", "evento", LocalDate.now(), new Recinto("recinto", "direccion", 100), 10, "local", "visitante", 2000, 4000));
            listaMezclada.add(new Tique(new Concierto("EVT-2026-MAD", "evento", LocalDate.now(), new Recinto("recinto", "direccion", 100), 100, "banda", 3000), new Usuario("nombre", "a@a.com", true)));
            //listaMezclada.addAll(LISTA_EVENTO.listar().values());
            UtilidadExportacion.exportarLista(listaMezclada);
        }
    }

    // Opcion 7
    private static void enviarNotificacionesATodos(){
        if (!LISTA_EVENTO.isEmpty()){
            ArrayList<Notificable> listaNotificable = new ArrayList<>();
            listaNotificable.add(new Usuario("nombre","a@a.com", true));
            listaNotificable.add(new Administrador());

            for (Notificable notificable : listaNotificable) {
                notificable.enviarNotificacion("Hola");
            }
        }
    }

    private static void ordenarLista(){
        Collections.sort(LISTA_USUARIOS.listar());
    }

    // Opcion 8
    private static void compra(){
        ProcesadorPago miTarjeta = new PagoTarjeta("123456789012", "2025-12-31");
        ProcesadorPago miPaypal = new PagoPaypal("alba@azahar.tech");
        ProcesadorPago miBizum = new PagoBizum("097889123", 1234);

        Evento evento = new Concierto("EVT-2025-MAD", "Concierto", LocalDate.now(), new Recinto("recinto", "direccion", 100), 100, "banda", 1000);
        Usuario usuario = new Usuario("nombre","a@a.com", true);

        LISTA_EVENTO.realizarCompra(usuario, evento, 1, miTarjeta);
        LISTA_EVENTO.realizarCompra(usuario, evento, 1, miPaypal);
        LISTA_EVENTO.realizarCompra(usuario, evento, 1, miBizum);
    }

    // Opcion 9
    private static void pruebaRegistrarEvento(){
        Evento eventoPrueba = new Partido("EVT-2024-MAD", "evento", LocalDate.now(), new Recinto("recinto", "direccion", 100), 10, "local", "visitante", 2000, 4000);
        eventoPrueba.registrarVenta();
        eventoPrueba.activarVenta();
        eventoPrueba.registrarVenta();
        eventoPrueba.cancelarEvento();
        eventoPrueba.registrarVenta();
        eventoPrueba.mostrarInformacion();
    }

    // Opcion 10
    private static void pruebaEstados(){
        generarDemo();
        LISTA_EVENTO.listar().get("EVT-2024-MAD").activarVenta();
        LISTA_EVENTO.listar().get("EVT-2025-MAD").activarVenta();
        LISTA_EVENTO.listar().get("EVT-2027-MAD").cancelarEvento();
        LISTA_EVENTO.procesarCierreEventos();
    }
}
