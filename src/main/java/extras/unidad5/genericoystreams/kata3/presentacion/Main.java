package extras.unidad5.genericoystreams.kata3.presentacion;

import extras.unidad5.genericoystreams.kata3.datos.CajaSuministros;
import extras.unidad5.genericoystreams.kata3.modelo.Arma;
import extras.unidad5.genericoystreams.kata3.modelo.Soldado;

public class Main {
    public static void main(String[] args) {
        CajaSuministros<Soldado> pelotonAlpha = new CajaSuministros<>();
        pelotonAlpha.agregar(new Soldado("Soldado1", 15,true));
        pelotonAlpha.agregar(new Soldado("Soldado2", 30,false));
        pelotonAlpha.agregar(new Soldado("Soldado3", 0,false));
        pelotonAlpha.agregar(new Soldado("Soldado4", 11,true));
        pelotonAlpha.agregar(new Soldado("Soldado5", 3,false));

        pelotonAlpha.obtenerContenido().stream().filter(soldado -> soldado.getBajas() > 10).forEach(soldado -> System.out.println(soldado.getGamerTag()));
    }
}
