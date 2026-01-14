package com.azahartech.eventdev.modelo;

import java.rmi.server.UID;
import java.time.LocalDate;
import java.util.UUID;

public class Evento {
    private String id;
    private String nombre;
    private LocalDate fecha;
    private Recinto recinto;
    private double precioEntrada;
    private boolean benefico = false;

    public Evento(){}

    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada){
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.fecha = fecha;
        this.recinto = recinto;
        this.precioEntrada = precioEntrada;
    }
    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, boolean benefico){
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.fecha = fecha;
        this.recinto = recinto;
        this.precioEntrada = precioEntrada;
        this.benefico = benefico;
    }

    public void registrarVenta(){
        
    }

    public String consultarId(){
        return this.id;
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

    public boolean esBenefico(){
        return this.benefico;
    }

    public void cambiarBenefico(boolean benefico){
        this.benefico = benefico;
    }

    public void mostrarInformacion(){
        System.out.printf("El nombre del evento es: %s, la fecha es: %s y el precio es: %.2f\n", this.nombre, this.fecha, this.precioEntrada);
        this.recinto.mostrarInformacion();
    }
}
