package com.azahartech.eventdev.modelo;

public class Recinto {
    private String nombre;
    private String direccion;
    private int aforoMaximo;

    public Recinto(){};

    public Recinto(String nombre, String direccion, int aforoMaximo){
        this.nombre = nombre;
        this.direccion = direccion;
        this.aforoMaximo = aforoMaximo;
    }

    //Getters y Setter
    public String consultarNombre(){
        return this.nombre;
    }

    public void cambiarNombre(String name){
        this.nombre = name;
    }

    public String consultarDireccion(){
        return this.direccion;
    }

    public void cambiarDireccion(String direccion){
        this.direccion = direccion;
    }

    public int consultarAforoMaximo(){
        return this.aforoMaximo;
    }

    public void cambiarAforoMaximo(int aforoMaximo){
        this.aforoMaximo = aforoMaximo;
    }

    public void mostrarInformacion(){
        System.out.printf("El nombre del recinto es: %s, la direccion del recinto es: %s, el aforo maximo es: %s\n", this.consultarNombre(), this.consultarDireccion(), this.aforoMaximo);
    }
}
