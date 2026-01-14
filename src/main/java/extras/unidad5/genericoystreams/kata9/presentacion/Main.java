package extras.unidad5.genericoystreams.kata9.presentacion;

import extras.unidad5.genericoystreams.kata4.datos.CajaSuministros;
import extras.unidad5.genericoystreams.kata9.modelo.Arma;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CajaSuministros<Arma> arsenal = new CajaSuministros<>();
        arsenal.agregar(new Arma("AK-47", "Rifle",80));
        arsenal.agregar(new Arma("M4A4", "Rifle",51));
        arsenal.agregar(new Arma("M4A1-S", "Rifle",45));
        arsenal.agregar(new Arma("P90", "Rifle",10));
        arsenal.agregar(new Arma("AWP", "Francotirador",159));
        arsenal.agregar(new Arma("SSg-8", "Francotirador",101));

        ArrayList<Arma> potentes = new ArrayList<>();
//        for (Arma a : arsenal.obtenerContenido()) {
//            if(a.getDaño() > 40){
//                potentes.add(a);
//            }
//        }
        arsenal.obtenerContenido().stream().filter(arma -> arma.getDaño() > 40).forEach(arma -> potentes.add(arma));

    }
}
