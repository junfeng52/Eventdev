package com.azahartech.eventdev.presentacion.Extras.Semana8;


import java.util.Scanner;

public class BloqueoDePin {
    public static void main( String[] args ) {
        Scanner teclado = new Scanner(System.in);
        int pin = 1234;
        int intentos = 4;
        System.out.println("BIENVENIDO AL BANCO DE JUNFENG");
        System.out.print("INTRODUCE TU PIN: ");
        int entrada = teclado.nextInt();

        intentos++;
        while ( entrada != pin && intentos < intentos ) {
            System.out.println("\nPIN INCORRECTO. INTÉNTALO DE NUEVO.");
            System.out.print("INTRODUCE TU PIN: ");
            entrada = teclado.nextInt();
            intentos++;
        }
        if ( entrada == pin )
            System.out.println("\nPIN ACEPTADO. AHORA TIENES ACCESO A TU CUENTA.");
        else if ( intentos >= 3 )
            System.out.println("\nAGOTADO EL NÚMERO DE INTENTOS. CUENTA BLOQUEADA.");
    }
}
