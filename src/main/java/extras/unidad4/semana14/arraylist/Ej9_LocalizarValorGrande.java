package extras.unidad4.semana14.arraylist;

import java.util.Random;
import java.util.Scanner;

public class Ej9_LocalizarValorGrande {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        int valorMaximo = 0;
        int posValorMaximo = 0;

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = new Random().nextInt(1, 51);

        }

        String[] textnum = new String[10];
        for (int i = 0; i < numeros.length; i++){
            textnum[i] = Integer.toString(numeros[i]);
        }

        System.out.println("Array1: "+ String.join(" ", textnum));


        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] > valorMaximo){
                valorMaximo = numeros[i];
                posValorMaximo = i;

            }
        }

        System.out.println("El valor más grande es " + valorMaximo + " y esta en la posicion " + posValorMaximo);

    }
}
