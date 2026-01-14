package extras.unidad5.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ej12_Ordenar_frase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> array1 = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();

        String input;

        System.out.print("Dime una frase: ");
        input = scanner.nextLine();


        array1.addAll(List.of(input.split(" ")));

        array2 = (ArrayList<String>) array1.clone();
        Collections.sort(array2);

        System.out.println("Frase ordenada: " + array2);
    }
}
