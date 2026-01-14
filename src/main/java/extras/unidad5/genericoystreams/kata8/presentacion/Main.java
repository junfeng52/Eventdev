package extras.unidad5.genericoystreams.kata8.presentacion;

import extras.unidad5.genericoystreams.kata4.datos.CajaSuministros;
import extras.unidad5.genericoystreams.kata8.modelo.Arma;
import extras.unidad5.genericoystreams.kata8.modelo.Soldado;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CajaSuministros<Arma> armasMezcladas = new CajaSuministros<>();
        armasMezcladas.agregar(new Arma("AK-47", "Rifle",80));
        armasMezcladas.agregar(new Arma("M4A4", "Rifle",51));
        armasMezcladas.agregar(new Arma("M4A1-S", "Rifle",45));
        armasMezcladas.agregar(new Arma("P90", "Rifle",10));
        armasMezcladas.agregar(new Arma("AWP", "Francotirador",159));
        armasMezcladas.agregar(new Arma("SSg-8", "Francotirador",101));
        
        ArrayList<String> armasLetales = new ArrayList<>();

        armasMezcladas.obtenerContenido().stream().filter(arma -> arma.getDaño() > 50).map(arma -> arma.getNombre()).forEach(nombre -> armasLetales.add(nombre));

    }
}
