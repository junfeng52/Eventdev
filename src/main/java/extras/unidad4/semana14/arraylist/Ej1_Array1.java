package extras.unidad4.semana14.arraylist;

public class Ej1_Array1 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++){
            numeros[i] = 211;
            System.out.println("Posición " + i + " contiene el valor " + numeros[i]);
        }
    }
}
