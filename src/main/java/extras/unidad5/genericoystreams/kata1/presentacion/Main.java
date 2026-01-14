package extras.unidad5.genericoystreams.kata1.presentacion;

import extras.unidad5.genericoystreams.kata1.datos.CajaSuministros;
import extras.unidad5.genericoystreams.kata1.modelo.Arma;

public class Main {
    public static void main(String[] args) {
        CajaSuministros<Arma> cajaSuministros = new CajaSuministros<>();
        cajaSuministros.agregar(new Arma("AK-47", "Rifle",80));
        cajaSuministros.agregar(new Arma("M4A4", "Rifle",50));
        cajaSuministros.agregar(new Arma("M4A1-S", "Rifle",45));
        cajaSuministros.agregar(new Arma("P90", "Rifle",10));

        System.out.println(cajaSuministros.obtenerContenido());
    }
}
