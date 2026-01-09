package com.azahartech.eventdev.datos;

import java.util.ArrayList;

public class RepositorioGenerico <T> {
    private ArrayList<T> elementos = new ArrayList<>();

    public void guardar(T objeto) {
        elementos.add(objeto);
    }

    public ArrayList<T> listar() {
        return elementos;
    }

    public void eliminar(T objeto){
        elementos.remove(objeto);
    }

    public T obtener(int indice){
        return elementos.get(indice);
    }

    public int tamaño(){
        return elementos.size();
    }
}
