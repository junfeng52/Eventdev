package extras.unidad4.semana14.arrays;

import java.util.Random;

public class EncontrarValorArray {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++){
            numeros[i] = new Random().nextInt(10, 51);
        }

        String[] textnum = new String[10];
        for (int i = 0; i < numeros.length; i++){
            textnum[i] = Integer.toString(numeros[i]);
        }

        System.out.println("Array1: "+ String.join(" ", textnum));

        int numeroABuscar= 20;
        System.out.println("Valor que quieres buscar: " + numeroABuscar);
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] == numeroABuscar){
                System.out.println(numeroABuscar + " esta en el array");
            }
        }

    }
}
