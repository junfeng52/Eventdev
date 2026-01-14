package extras.unidad5.arraylist;

import java.lang.reflect.Array;
import java.util.*;

public class Ej10_Ordenar_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2;
        for (int i = 0; i < 10; i++) {
            array1.add(new Random().nextInt(1, 100+1));
        }
        array2 = (ArrayList<Integer>) array1.clone();
        Collections.sort(array2, Collections.reverseOrder());

        System.out.println("El contenido del ArrayList original es: " + array1);
        System.out.println("El contenido del ArrayList original es: " + array2);
    }

}
