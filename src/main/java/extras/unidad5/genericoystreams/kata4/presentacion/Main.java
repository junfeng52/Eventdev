package extras.unidad5.genericoystreams.kata4.presentacion;

import extras.unidad5.genericoystreams.kata4.datos.CajaSuministros;
import extras.unidad5.genericoystreams.kata4.modelo.Arma;
import extras.unidad5.genericoystreams.kata4.modelo.Soldado;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Arma> armasMezcladas = new ArrayList<>();
        armasMezcladas.add(new Arma("AK-47", "Rifle",80));
        armasMezcladas.add(new Arma("M4A4", "Rifle",50));
        armasMezcladas.add(new Arma("M4A1-S", "Rifle",45));
        armasMezcladas.add(new Arma("P90", "Rifle",10));
        armasMezcladas.add(new Arma("AWP", "Francotirador",159));
        armasMezcladas.add(new Arma("SSg-8", "Francotirador",101));


        ArrayList<Arma> francotiradores = new ArrayList<>();
        armasMezcladas.stream().filter(arma -> arma.getTipo().equals("Francotirador")).forEach(arma -> francotiradores.add(arma));

        ArrayList<Arma> francotiradores2 = armasMezcladas.stream().filter(arma -> arma.getTipo().equals("Francotirador")).collect(Collectors.toCollection(ArrayList::new));



    }
}
