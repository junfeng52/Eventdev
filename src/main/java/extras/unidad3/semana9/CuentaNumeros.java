package extras.unidad3.semana9;

import java.util.Scanner;

public class CuentaNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroUsuario;

        System.out.print("Cuenta hasta: ");
        numeroUsuario = scanner.nextInt();
        scanner.nextLine();
        for (int num = 1; num <= numeroUsuario; num++) {
            System.out.printf("%d ", num);
        }
    }

}
