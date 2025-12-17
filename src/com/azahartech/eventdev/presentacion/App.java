package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.util.UtilidadValidacion;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int input = -1;

        do{
            System.out.println("Que tipo de clase quieres crear:");
            System.out.println("1. Concierto");
            System.out.println("2. Partido");
            System.out.println("0. Exit");
            System.out.printf("Dime la opcion: ");
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
        Evento evento = new Evento();
        Recinto recintoDelEvento = new Recinto();

        LocalDate fechaEvento;

        System.out.println("Dime el nombre del evento.");
        evento.cambiarNombre(scanner.nextLine());

        System.out.println("Dime la fecha del evento (Formato YYYY-MM-DD)");
        fechaEvento = LocalDate.parse(scanner.nextLine());
        if(UtilidadValidacion.esFechaFutura(fechaEvento)){
            System.out.println("La fecha es futura");
        }else {
            System.out.println("La fecha es pasado");
        }
        evento.cambiarFecha(fechaEvento);

        System.out.println("Dime el nombre del recinto");
        recintoDelEvento.cambiarNombre(scanner.nextLine());

        System.out.println("Dime la direccion del recinto");
        recintoDelEvento.cambiarDireccion(scanner.nextLine());

        System.out.println("Dime el aforo maximo del recinto");
        recintoDelEvento.cambiarAforoMaximo(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Dime el precio del evento");
        evento.cambiarPrecioEntrada(scanner.nextDouble());
        scanner.nextLine();

        evento.cambiarRecinto(recintoDelEvento);

        switch (tipoEvento){
            case "Concierto":
                System.out.println("Dime el nombre de la banda principal");
                evento = new Concierto(evento,scanner.nextLine());
                evento.mostrarInformacion();
                break;

            case "Partido":
                String equipoLocal;
                String equipoVisitante;

                System.out.println("Dime el nombre del equipo local");
                equipoLocal = scanner.nextLine();

                System.out.println("Dime el nombre del equipo visitante");
                equipoVisitante = scanner.nextLine();

                evento = new Partido(evento, equipoLocal, equipoVisitante);
                evento.mostrarInformacion();
                break;
        }



    }

}
