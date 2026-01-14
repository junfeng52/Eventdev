package extras.unidad5.arraylist;

import java.util.Random;
import java.util.Scanner;

public class Ej7_DondeEsta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        int numeroABuscar;
        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = new Random().nextInt(1, 51);

        }

        String[] textnum = new String[10];
        for (int i = 0; i < numeros.length; i++){
            textnum[i] = Integer.toString(numeros[i]);
        }

        System.out.println("Array1: "+ String.join(" ", textnum));

        System.out.print("Valor que quieres buscar: ");
        numeroABuscar = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] == numeroABuscar){
                System.out.println(numeroABuscar + " está en la posicion "+ i);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println(numeroABuscar + " no esta en el array");
        }

    }
}
