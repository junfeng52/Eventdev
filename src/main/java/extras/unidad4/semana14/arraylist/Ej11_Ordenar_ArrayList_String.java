package extras.unidad4.semana14.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ej11_Ordenar_ArrayList_String {
    public static void main(String[] args) {
        ArrayList<String> array1 = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();

        array1.addAll(List.of("la duda es la madre de la invención".split(" ")));

        array2 = (ArrayList<String>) array1.clone();
        Collections.sort(array2);

        System.out.println("El ArrayList original es: " + array1);
        System.out.println("El ArrayList ordenado es: " + array2);
    }

}
