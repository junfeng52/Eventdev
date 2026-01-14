package extras.unidad5.genericoystreams.kata10.presentacion;

import extras.unidad5.genericoystreams.kata10.modelo.Soldado;
import extras.unidad5.genericoystreams.kata4.datos.CajaSuministros;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CajaSuministros<Soldado> pelotonAlpha = new CajaSuministros<>();
        pelotonAlpha.agregar(new Soldado("Soldado1", 15,true));
        pelotonAlpha.agregar(new Soldado("Ghost", 30,false));
        pelotonAlpha.agregar(new Soldado("Soldado3", 0,false));
        pelotonAlpha.agregar(new Soldado("Soldado4", 11,true));
        pelotonAlpha.agregar(new Soldado("Soldado5", 3,false));

        pelotonAlpha.obtenerContenido().stream().filter(soldado -> soldado.getBajas() > 5).map(soldado -> soldado.getGamerTag().toUpperCase()).forEach(nombre -> System.out.printf("MVP: %s", nombre));
    }
}
