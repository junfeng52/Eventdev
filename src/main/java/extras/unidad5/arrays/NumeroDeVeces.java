package extras.unidad5.arrays;

import java.util.Random;
import java.util.Scanner;

public class NumeroDeVeces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        int numeroAContar;
        int contar = 0;

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = new Random().nextInt(1, 51);

        }

        String[] textnum = new String[10];
        for (int i = 0; i < numeros.length; i++){
            textnum[i] = Integer.toString(numeros[i]);
        }

        System.out.println("Array1: "+ String.join(" ", textnum));

        System.out.print("Valor que quieres buscar: ");
        numeroAContar = scanner.nextInt();



        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] == numeroAContar){
                contar++;
            }
        }
        System.out.println(numeroAContar + " está "+ contar +" veces");
    }
}
