package extras.unidad5.arraysforeach;

public class ArrayForEachSort {
    public static void main(String[] args) {
        int[] array = {45, 87, 39, 32, 93, 86, 12, 44, 75, 50};
// Muestra el array original (con valores desordenados)
        System.out.print("Antes : ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
// Intercambia los valores contiguos para ordenarlos ascendentemente

        for (int i = array.length; i > 0; i-- ) {
            int anterior = 0;
            for (int pos = 0; pos < i ; pos++) {
                if (array[pos] < array[anterior]) {
                    int temp = array[anterior];
                    array[anterior] = array[pos];
                    array[pos] = temp;
                }
                anterior = pos;
            }
        }

// Muestra el array de nuevo, ahora (esperemos) ordenado.
        System.out.print("Después: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
