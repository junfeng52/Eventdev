package extras.unidad5.genericoystreams.kata5.presentacion;

import extras.unidad5.genericoystreams.kata4.datos.CajaSuministros;
import extras.unidad5.genericoystreams.kata5.modelo.Soldado;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CajaSuministros<Soldado> pelotonAlpha = new CajaSuministros<>();
        pelotonAlpha.agregar(new Soldado("Soldado1", 15,true));
        pelotonAlpha.agregar(new Soldado("Soldado2", 30,false));
        pelotonAlpha.agregar(new Soldado("Soldado3", 0,false));
        pelotonAlpha.agregar(new Soldado("Soldado4", 11,true));
        pelotonAlpha.agregar(new Soldado("Soldado5", 3,false));

        long resultado = pelotonAlpha.obtenerContenido().stream().filter(soldado -> soldado.isEsVip()).count();
        System.out.println(resultado);
    }
}
