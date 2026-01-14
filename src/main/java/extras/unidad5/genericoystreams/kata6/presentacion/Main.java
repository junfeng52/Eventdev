package extras.unidad5.genericoystreams.kata6.presentacion;

import extras.unidad5.genericoystreams.kata4.datos.CajaSuministros;
import extras.unidad5.genericoystreams.kata6.modelo.Soldado;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CajaSuministros<Soldado> pelotonAlpha = new CajaSuministros<>();
        pelotonAlpha.agregar(new Soldado("Soldado1", 15,true));
        pelotonAlpha.agregar(new Soldado("Soldado2", 30,false));
        pelotonAlpha.agregar(new Soldado("Soldado3", 0,false));
        pelotonAlpha.agregar(new Soldado("Soldado4", 11,true));
        pelotonAlpha.agregar(new Soldado("Soldado5", 3,false));

        ArrayList<String> nombrePantalla = new ArrayList<>();
        pelotonAlpha.obtenerContenido().stream().map(soldado -> soldado.getGamerTag()).forEach(soldado -> nombrePantalla.add(soldado));
        System.out.println(nombrePantalla);
    }
}
