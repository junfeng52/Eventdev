package extras.unidad5.arraylist;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ej13_Ordenar_ArrayList_Registros {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.print("Dime el nombre del archivo donde guarde la informacion: ");
        filename = scanner.nextLine();

        ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(String.format("%s.txt", filename)));

        Ej13_Pokemons pokemon1 = new Ej13_Pokemons("nombre1", "tipo1", 1, 1);
        Ej13_Pokemons pokemon2 = new Ej13_Pokemons("nombre3", "tipo2", 3, 2);
        Ej13_Pokemons pokemon3 = new Ej13_Pokemons("nombre2", "tipo3", 2, 3);
        Ej13_Pokemons pokemon4 = new Ej13_Pokemons("nombre4", "tipo4", 4, 4);

        oss.writeObject(pokemon1);
        oss.writeObject(pokemon2);
        oss.writeObject(pokemon3);
        oss.writeObject(pokemon4);
        oss.close();

    }
}
