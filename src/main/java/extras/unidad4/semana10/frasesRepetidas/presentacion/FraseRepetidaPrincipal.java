package extras.unidad4.semana10.frasesRepetidas.presentacion;

import extras.unidad4.semana10.frasesRepetidas.modelo.FraseRepetida;

import java.util.Scanner;
public class FraseRepetidaPrincipal {
    public static void main( String[] args ) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escribe un mensaje: ");
        String mensaje = teclado.nextLine();
        System.out.print("Número de veces: ");
        int numero = teclado.nextInt();
        FraseRepetida fr = new FraseRepetida();
        fr.cambiarValores(mensaje, numero);
        System.out.println(fr.mostrarFraseRepetida() );
    }
}