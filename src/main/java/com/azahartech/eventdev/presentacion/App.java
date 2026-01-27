package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.servicio.ServicioUsuario;
import com.azahartech.eventdev.util.UtilidadValidacion;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.println("4. Registrar Evento");
            System.out.println("5. Generar informe");
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
                        registrarEvento();
                        break;

                    case 5:
                        if (listaEvento.isEmpty()){
                            System.out.println("No hay ningun evento registrado");
                        }else {
                            listaEvento.generarInformeFinanciero();
                        }
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

}
