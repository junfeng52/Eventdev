package com.azahartech.eventdev.extras.semana8;

import java.util.Scanner;
public class IntroducirElPIN {
    public static void main( String[] args ) {
        Scanner teclado = new Scanner(System.in);
        int pin = 1234;
        System.out.println ("BIENVENIDO AL BANCO DE JUNFENG");
        System.out.print ("INTRODUCE TU PIN: ");
        int entrada = teclado.nextInt();
        while ( entrada != pin ) {
            System.out.println ("\nPIN INCORRECTO. INTENTALO DE NUEVO.");
            System.out.print ("INTRODUCE TU PIN: ");
            entrada = teclado.nextInt();
        }
        System.out.println ("\nPIN CORRECTO. AHORA TIENES ACCESO A TU CUENTA.");
    }
}
