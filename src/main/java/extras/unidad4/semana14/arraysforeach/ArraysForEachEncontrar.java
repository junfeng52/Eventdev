package extras.unidad4.semana14.arraysforeach;

import java.util.Scanner;

public class ArraysForEachEncontrar {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numeros = {78, 111, 32, 116, 101, 110, 103, 111, 32, 110, 105, 32, 105, 100,
                101, 97, 32, 100, 101, 32, 108, 111, 32, 113, 117, 101, 32, 101, 115, 116, 111,
                121, 32, 104, 97, 99, 105, 101, 110, 100, 111};
        int input = 0;
        boolean encontrado = false;

        System.out.printf("Hay %s números en el array.\n", numeros.length);
        System.out.print("Números: ");
        for (int numero : numeros) {
            System.out.printf("%d ", numero);
        }
        System.out.print("\n¿Qué número quieres buscar? : ");
        input = scanner.nextInt();

        for (int numero : numeros) {
            if (numero == input && !encontrado){
                System.out.printf("número %d encontrado.\n", numero);
                encontrado = true;
            }
        }
        scanner.close();
    }
}
