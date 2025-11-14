package com.azahartech.eventdev.extras.semana8;

import java.util.Random;
import java.util.Scanner;

public class CaraOCruz {
    public static void main( String[] args ) {
        Scanner teclado = new Scanner(System.in);
        Random numeroAleatorio = new Random();
        String otraVez;
        do{
            int lanza = numeroAleatorio.nextInt(2);
            String moneda;
            if ( lanza == 1 )
                moneda = "CARA";
            else
                moneda = "CRUZ";
            System.out.println( "Has lanzado una moneda y ha salido... " + moneda );
            System.out.print( "¿Quieres lanzarla de nuevo(s/n)? " );
            otraVez = teclado.next();
        }while ( otraVez.equals("s") );
    }
}
