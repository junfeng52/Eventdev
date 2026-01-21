package extras.unidad5.arraysforeach;

import java.util.Random;

public class ArrayForEachSortBubble {
    public static void ordenacionBurbuja(int[] a) {
        for (int i = a.length; i > 0; i-- ) {
            int anterior = 0;
            for (int pos = 0; pos < i ; pos++) {
                if (a[pos] < a[anterior]) {
                    intercambiaValores(a, pos, anterior);
                }
                anterior = pos;
            }
        }
    }

    public static void intercambiaValores(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        int i;
// Rellena el array con números random
        for (i = 0; i < array.length; i++)
            array[i] = 1 + random.nextInt(100);
// Muestra el array
        System.out.print("Antes : ");
        for (i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
// Ordena el array

        ordenacionBurbuja(array);


// Muestra el array ordenado
        System.out.print("Después: ");
        for (i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
