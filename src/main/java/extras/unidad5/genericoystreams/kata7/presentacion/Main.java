package extras.unidad5.genericoystreams.kata7.presentacion;

import extras.unidad5.genericoystreams.kata4.datos.CajaSuministros;
import extras.unidad5.genericoystreams.kata7.modelo.Soldado;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CajaSuministros<Soldado> pelotonAlpha = new CajaSuministros<>();
        pelotonAlpha.agregar(new Soldado("Soldado1", 15,true));
        pelotonAlpha.agregar(new Soldado("Ghost", 30,false));
        pelotonAlpha.agregar(new Soldado("Soldado3", 0,false));
        pelotonAlpha.agregar(new Soldado("Soldado4", 11,true));
        pelotonAlpha.agregar(new Soldado("Soldado5", 3,false));

        if (pelotonAlpha.obtenerContenido().stream().filter(soldado -> soldado.getGamerTag().equals("Ghost")).findFirst().orElse(null) != null){
            System.out.println("Encotrado");
        }else {
            System.out.println("No Encontrado");
        }
    }
}
