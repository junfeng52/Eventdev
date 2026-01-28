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
import java.util.Scanner;

public class App {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final Scanner scanner = new Scanner(System.in);
    private static final ServicioUsuario listaUsuarios = new ServicioUsuario();
    private static final ServicioEvento listaEvento = new ServicioEvento();

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
            System.out.println("0. Exit");
            System.out.print("Dime la opcion: ");
            try {
                input = scanner.nextInt();
                scanner.nextLine();
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
                        if (listaEvento.isEmpty()){
                            System.out.println("No hay ningun evento registrado");
                        }else {
                            listaEvento.generarInformeFinanciero();
                        }
                        break;

                    case 6:
                        if (listaEvento.isEmpty()){
                            System.out.println("No hay ningun evento registrado");
                        }else {
                            exportarALista();
                        }
                        break;

                    case 7:
                        if (listaEvento.isEmpty()){
                            System.out.println("No hay ningun evento registrado");
                        }else {
                            enviarNotificacionesATodos();
                        }
                        break;

                    case 8:
                        compra();
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Opcion no valida.");
                scanner.nextLine();
            }


        } while (input != 0);
        scanner.close();
    }

    private static void pedirDatos(String tipoEvento){
        Evento eventoFinal;
        Recinto recintoDelEvento = new Recinto();

        String id;
        String nombre;
        LocalDate fechaEvento;
        double precioEntrada;

        System.out.println("Dime el id del evento.");
        id = scanner.nextLine();

        System.out.println("Dime el nombre del evento.");
        nombre = scanner.nextLine();

        System.out.println("Dime la fecha del evento (Formato YYYY-MM-DD)");
        fechaEvento = LocalDate.parse(scanner.nextLine());
        if(UtilidadValidacion.esFechaFutura(fechaEvento)){
            System.out.println("La fecha es futura");
        }else {
            System.out.println("La fecha es pasado");
        }

        System.out.println("Dime el nombre del recinto");
        recintoDelEvento.cambiarNombre(scanner.nextLine());

        System.out.println("Dime la direccion del recinto");
        recintoDelEvento.cambiarDireccion(scanner.nextLine());

        System.out.println("Dime el aforo maximo del recinto");
        recintoDelEvento.cambiarAforoMaximo(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Dime el precio del evento");
        precioEntrada = scanner.nextDouble();
        scanner.nextLine();

        switch (tipoEvento){
            case "Concierto":
                String nombreBanda;
                double costeMontage;

                System.out.println("Dime el nombre de la banda principal");
                nombreBanda = scanner.nextLine();

                System.out.println("Dime el coste del montaje");
                costeMontage = scanner.nextDouble();
                scanner.nextLine();

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
                equipoLocal = scanner.nextLine();

                System.out.println("Dime el nombre del equipo visitante");
                equipoVisitante = scanner.nextLine();

                System.out.println("Dime el coste de la seguridad");
                costeSeguridad = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Dime el coste del arbitraje");
                costeArbitraje = scanner.nextDouble();
                scanner.nextLine();

                eventoFinal = new Partido(id, nombre, fechaEvento, recintoDelEvento, precioEntrada, equipoLocal, equipoVisitante, costeSeguridad, costeArbitraje);
                System.out.println(eventoFinal.obtenerCodigoReferencia());
                eventoFinal.mostrarInformacion();
                break;
        }

    }

    private static void registarUsuario(){
        String nombre;
        String email;
        boolean vip;

        System.out.println("Dime el nombre de usuario");
        nombre = scanner.nextLine();

        System.out.println("Dime el email del usuario");
        email = scanner.nextLine();
        while (!UtilidadValidacion.esEmailValido(email)){
            System.out.println("Email no valido.");
            System.out.println("Dime el email del usuario.");
            email = scanner.nextLine();
        }

        System.out.println("Dime si el usuario es Vip (Si/No) Defecto: No");
        vip = scanner.nextLine().toLowerCase() == "si";

        listaUsuarios.registrarUsuario(new Usuario(nombre, email, vip));
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

        System.out.println("Dime el id del evento");
        id = scanner.nextLine();
        while (!UtilidadValidacion.esCodigoEventoValido(id)){
            System.out.println("Codigo invalido. El codigo tiene que seguir este patron EVT-AAAA-XXX");
            System.out.println("Dime el id del evento");
            id = scanner.nextLine();
        }

        System.out.println("Dime el nombre del evento");
        nombre = scanner.nextLine();

        System.out.println("Dime el dia del evento");
        dia = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Dime el mes del evento");
        mes = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Dime el año del evento");
        año = scanner.nextInt();
        scanner.nextLine();

        fecha = LocalDate.of(año,mes, dia);

        System.out.println("Dime el nombre del recinto");
        nombreRecinto = scanner.nextLine();

        System.out.println("Dime la direccion del recinto");
        direccionRecinto = scanner.nextLine();

        System.out.println("Dime el aforo maximo del recinto");
        aforoMaximo = scanner.nextInt();
        scanner.nextLine();

        recinto = new Recinto(nombreRecinto, direccionRecinto, aforoMaximo);

        System.out.println("Dime el precio del evento");
        precioEntrada = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Dime el evento es benefico (si/no defecto: no)");
        benefico = scanner.nextLine().toLowerCase() == "si";

        //listaEvento.registrarEvento(new Evento(nombre, fecha, recinto, precioEntrada, benefico, id));
    }

    private static void generarDemo(){
        listaEvento.registrarEvento(new Concierto("EVT-2025-MAD" ,"evento", LocalDate.now(), new Recinto("recinto", "direccion", 100), 100, "banda", 1000));
        listaEvento.registrarEvento(new Concierto("EVT-2027-MAD" ,"evento1", LocalDate.now(), new Recinto("recinto", "direccion", 100), 112, "banda", 1640));
        listaEvento.registrarEvento(new Concierto("EVT-2059-MAD" ,"evento2", LocalDate.now(), new Recinto("recinto", "direccion", 100), 120, "banda", 18120));
        listaEvento.registrarEvento(new Concierto("EVT-2023-MAD" ,"evento3", LocalDate.now(), new Recinto("recinto", "direccion", 100), 1340, "banda", 1100));
        listaEvento.registrarEvento(new Concierto("EVT-2021-MAD" ,"evento4", LocalDate.now(), new Recinto("recinto", "direccion", 100), 10, "banda", 100));
        listaEvento.registrarEvento(new Partido("EVT-2024-MAD", "evento5", LocalDate.now(), new Recinto("recinto", "direccion", 100), 101, "local", "visitante", 20000, 4000));
        listaEvento.registrarEvento(new Partido("EVT-2034-MAD", "evento7", LocalDate.now(), new Recinto("recinto", "direccion", 100), 55, "local", "visitante", 3000, 40000));
        listaEvento.registrarEvento(new Partido("EVT-2014-MAD", "evento34", LocalDate.now(), new Recinto("recinto", "direccion", 100), 50, "local", "visitante", 4000, 401));
        listaEvento.registrarEvento(new Partido("EVT-2034-MAD", "evento251", LocalDate.now(), new Recinto("recinto", "direccion", 100), 210, "local", "visitante", 8000, 400));
        listaEvento.registrarEvento(new Partido("EVT-2074-MAD", "evento14", LocalDate.now(), new Recinto("recinto", "direccion", 100), 410, "local", "visitante", 1000, 40010));

        listaUsuarios.registrarUsuario(new Usuario("nombrea","a@a.com", true));
        listaUsuarios.registrarUsuario(new Usuario("nombreb","b@b.com", true));
        listaUsuarios.registrarUsuario(new Usuario("nombrec","c@c.com", true));
        listaUsuarios.registrarUsuario(new Usuario("nombred","d@d.com", true));
        listaUsuarios.registrarUsuario(new Usuario("nombref","f@f.com", true));

    }

    private static void exportarALista(){
        ArrayList<Exportable> listaMezclada = new ArrayList<>();
        listaMezclada.add(new Usuario("nombre","a@a.com", true));
        listaMezclada.add(new Concierto("EVT-2025-MAD" ,"evento", LocalDate.now(), new Recinto("recinto", "direccion", 100), 100, "banda", 1000));
        listaMezclada.add(new Partido("EVT-2024-MAD", "evento", LocalDate.now(), new Recinto("recinto", "direccion", 100), 10, "local", "visitante", 2000, 4000));
        listaMezclada.add(new Tique(new Concierto("EVT-2026-MAD", "evento", LocalDate.now(), new Recinto("recinto", "direccion", 100), 100, "banda", 3000), new Usuario("nombre","a@a.com", true)));
        UtilidadExportacion.exportarLista(listaMezclada);
    }

    private static void enviarNotificacionesATodos(){
        ArrayList<Notificable> listaNotificable = new ArrayList<>();
        listaNotificable.add(new Usuario("nombre","a@a.com", true));
        listaNotificable.add(new Administrador());

        for (Notificable notificable : listaNotificable) {
            notificable.enviarNotificacion("Hola");
        }
    }

    private static void ordenarLista(){
        Collections.sort(listaUsuarios.listar());
    }

    private static void compra(){
        ProcesadorPago miTarjeta = new PagoTarjeta("123456789012", "2025-12-31");
        ProcesadorPago miPaypal = new PagoPaypal("alba@azahar.tech");
        ProcesadorPago miBizum = new PagoBizum("097889123", 1234);

        Evento evento = new Concierto("EVT-2025-MAD", "Concierto", LocalDate.now(), new Recinto("recinto", "direccion", 100), 100, "banda", 1000);
        Usuario usuario = new Usuario("nombre","a@a.com", true);

        listaEvento.realizarCompra(usuario, evento, 1, miTarjeta);
        listaEvento.realizarCompra(usuario, evento, 1, miPaypal);
        listaEvento.realizarCompra(usuario, evento, 1, miBizum);
    }
}
