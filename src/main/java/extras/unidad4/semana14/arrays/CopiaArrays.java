package extras.unidad4.semana14.arrays;

import java.util.Random;

public class CopiaArrays {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = new Random().nextInt(1, 101);
            // System.out.println("Posición " + i + " contiene el valor " + numeros[i]);
        }

        int[] numeros2 = new int[10];
        for (int i = 0; i < numeros.length; i++){
            numeros2[i] = numeros[i];

        }

        numeros[numeros.length-1] = -1;

        String[] textnum = new String[10];
        String[] textnum2 = new String[10];
        for (int i = 0; i < numeros.length; i++){
            textnum[i] = Integer.toString(numeros[i]);
            textnum2[i] = Integer.toString(numeros2[i]);
        }

        System.out.println("Array1: "+ String.join(" ", textnum));
        System.out.println("Array2: "+ String.join(" ", textnum2));

    }
}
