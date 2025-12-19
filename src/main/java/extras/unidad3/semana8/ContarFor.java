package extras.unidad3.semana8;

import java.util.Scanner;
public class ContarFor
{
    public static void main( String[] args ) {
        Scanner teclado = new Scanner(System.in);
        System.out.println( "Escribe un mensaje, y yo lo mostraré diez veces." );
        System.out.print( "Mensaje: " );
        String mensaje = teclado.nextLine();
        for ( int n = 1 ; n <= 10 ; n = n+1 ) {
            System.out.println( n + ". " + mensaje );
        }
    }
}