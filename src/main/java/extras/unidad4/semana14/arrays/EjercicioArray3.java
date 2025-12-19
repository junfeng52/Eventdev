package extras.unidad4.semana14.arrays;

import java.util.Random;

public class EjercicioArray3 {
    public static void main(String[] args) {
        int[] numeros = new int[1000];
        for (int i = 0; i < numeros.length; i++){
            numeros[i] = new Random().nextInt(10, 100);
            System.out.println("Posición " + i + " contiene el valor " + numeros[i]);
        }
    }
}
