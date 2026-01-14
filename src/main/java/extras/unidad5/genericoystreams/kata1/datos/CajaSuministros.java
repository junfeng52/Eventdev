package extras.unidad5.genericoystreams.kata1.datos;

import java.util.ArrayList;

public class CajaSuministros <T>{
    ArrayList<T> arrayList = new ArrayList<>();

    public void agregar(T objeto){
        this.arrayList.add(objeto);
    }

    public ArrayList<T> obtenerContenido(){
        return this.arrayList;
    }
}
