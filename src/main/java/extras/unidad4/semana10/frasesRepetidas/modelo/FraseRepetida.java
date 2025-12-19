package extras.unidad4.semana10.frasesRepetidas.modelo;

public class FraseRepetida {
    String frase;
    int numeroDeRepeticiones;
    public void cambiarValores (String nuevoFrase, int nuevoNumeroDeRepeticiones) {
        frase = nuevoFrase;
        numeroDeRepeticiones = nuevoNumeroDeRepeticiones;
    }

    public String mostrarFraseRepetida () {
        String resultado = "";
        for ( int i=0; i<numeroDeRepeticiones; i++ )
            resultado += frase;
        return resultado;
    }

}