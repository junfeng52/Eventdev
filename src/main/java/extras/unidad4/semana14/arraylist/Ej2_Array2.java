package extras.unidad4.semana14.arraylist;

import java.util.Random;

public class Ej2_Array2 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++){
            numeros[i] = new Random().nextInt(1, 101);
            System.out.println("Posición " + i + " contiene el valor " + numeros[i]);
        }
    }
}
