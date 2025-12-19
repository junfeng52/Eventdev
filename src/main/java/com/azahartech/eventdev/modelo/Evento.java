package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Evento {
    private String nombre;
    private LocalDate fecha;
    private Recinto recinto;
    private double precioEntrada;

    public Evento(){}

    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada){
        this.nombre = nombre;
        this.fecha = fecha;
        this.recinto = recinto;
        this.precioEntrada = precioEntrada;
    }

    public void registrarVenta(){
        
    }

    public String consultarNombre(){
        return this.nombre;
    }

    public void cambiarNombre(String nombre){
        this.nombre = nombre;
    }

    public LocalDate consultarFecha(){
        return this.fecha;
    }

    public void cambiarFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public Recinto consultarRecinto(){
        return this.recinto;
    }

    public void cambiarRecinto(Recinto recinto){
        this.recinto = recinto;
    }

    public double consultarPrecioEntrada(){
        return this.precioEntrada;
    }

    public void cambiarPrecioEntrada(double precioEntrada){
        this.precioEntrada = precioEntrada;
    }

    public void mostrarInformacion(){
        System.out.printf("El nombre del evento es: %s, la fecha es: %s y el precio es: %.2f\n", this.nombre, this.fecha, this.precioEntrada);
        this.recinto.mostrarInformacion();
    }
}
