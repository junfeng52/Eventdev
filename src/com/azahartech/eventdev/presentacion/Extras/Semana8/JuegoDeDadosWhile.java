package com.azahartech.eventdev.presentacion.Extras.Semana8;

import java.util.Random;

public class JuegoDeDadosWhile {
    public static void main(String[] args) {
        Random random = new Random();
        int dado1 = 0;
        int dado2 = 1;

        while ( dado1 != dado2){
            dado1 = random.nextInt(1,(6+1));
            dado2 = random.nextInt(1,(6+1));
            System.out.printf("El valor del Dado1: %d \n", dado1);
            System.out.printf("El valor del Dado2: %d \n", dado2);
            System.out.printf("La suma de Dado1 y Dado2 es: %d \n", dado1 + dado2);
        }
    }
}
