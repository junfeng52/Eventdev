package extras.unidad5.arraylist;

import java.io.Serializable;

public class Ej13_Pokemons implements Serializable {
    private String nombre;
    private String tipo;
    private int generacion;
    private int velocidad;

    public Ej13_Pokemons(String nombre, String tipo, int generacion, int velocidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.generacion = generacion;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Ej13_Pokemons{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", generacion=" + generacion +
                ", velocidad=" + velocidad +
                '}';
    }
}
