package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;

import javax.crypto.spec.IvParameterSpec;

public class Recinto implements Exportable {
    private String nombre;
    private String direccion;
    private int aforoMaximo;
    Boolean[] asientosVip;

    public Recinto(String nombre, String direccion, int aforoMaximo){
        this.nombre = nombre;
        this.direccion = direccion;
        this.aforoMaximo = aforoMaximo;
        this.asientosVip = new Boolean[10];
        for (int i = 0; i < this.asientosVip.length; i++) {
            this.asientosVip[i] = false;
        }
    }

    public Recinto(){};

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

    //Metodos
    public void mostrarInformacion(){
        System.out.printf("El nombre del recinto es: %s, la direccion del recinto es: %s, el aforo maximo es: %s y quedan %d asientos libres.\n", this.consultarNombre(), this.consultarDireccion(), this.aforoMaximo, this.contarAsientosVIPLibre());
    }

    public void reservarAsientoVIP(int numeroAsiento){
        if (numeroAsiento < 1 || numeroAsiento > 10){
            System.out.println("Asiento no valida.");
            return;
        }

        if(this.asientosVip[numeroAsiento-1]){
            System.out.println("Asiento ya ocupado.");
            return;
        }

        System.out.printf("Has ocupado el %d.\n", numeroAsiento);
        this.asientosVip[numeroAsiento-1] = true;
    }

    public int contarAsientosVIPLibre(){
        int asientoLibre = 0;
        for (int i = 0; i < this.asientosVip.length; i++) {
            if (!this.asientosVip[i]){
                asientoLibre++;
            }
        }
        return asientoLibre;
    }

    @Override
    public String aXML(int indent, String name) {
        String tabs = "\t".repeat(indent);
        name = (name == null) ? "recinto" : name;
        return  tabs + "<" + name + ">\n" +
                tabs + "\t<nombre>" + this.nombre + "</nombre>\n" +
                tabs + "\t<direccion>" + this.direccion + "</direccion>\n" +
                tabs + "\t<aforoMaximo>" + this.aforoMaximo + "</aforoMaximo>\n" +
                tabs + "\t<asientosVipLibres>" + this.contarAsientosVIPLibre() + "<asientosVipLibres>\n" +
                tabs + "\t<asientosVipOcupados>" + (this.asientosVip.length - this.contarAsientosVIPLibre()) + "<asientosVipOcupados>\n" +
                tabs + "\t<asientosVip>" + this.asientosVip.length + "<asientosVip>\n" +
                tabs + "</" + name + ">\n";
    }

    @Override
    public String aCSV() {
        return String.format("%s,%s,%s", this.nombre, this.direccion, this.aforoMaximo);
    }
}
