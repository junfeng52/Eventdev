package extras.unidad5.genericoystreams.kata2.presentacion;

import extras.unidad5.genericoystreams.kata2.datos.CajaSuministros;
import extras.unidad5.genericoystreams.kata2.modelo.Arma;
import extras.unidad5.genericoystreams.kata2.modelo.Soldado;

public class Main {
    public static void main(String[] args) {
        CajaSuministros<Soldado> pelotonAlpha = new CajaSuministros<>();
        pelotonAlpha.agregar(new Soldado("Soldado1", 15,true));
        pelotonAlpha.agregar(new Soldado("Soldado2", 30,false));

        CajaSuministros<Arma> arsenalBravo = new CajaSuministros<>();
        arsenalBravo.agregar(new Arma("AK-47", "Rifle",80));
        arsenalBravo.agregar(new Arma("M4A4", "Rifle",50));

        // arsenalBravo.agregar(new Soldado("Soldado2", 30,false));
    }
}
