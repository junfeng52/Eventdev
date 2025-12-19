package com.azahartech.eventdev.modelo;

public class DetallePago {
    private String tipoTarjeta;
    private String numeroTarjeta;

    public DetallePago(String tipoTarjeta, String numeroTarjeta){
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
    }

    public void realizarPago(double costeTotal){
        System.out.println("Pago realizado");
    }

    public void realizarPago(double costeTotal, String tipoTarjeta){
        this.realizarPago(costeTotal);
    }

    public String consutarTipoTarjeta(){
        return this.tipoTarjeta;
    }

    public void cambiarTipoTarjeta(String tipoTarjeta){
        this.tipoTarjeta = tipoTarjeta;
    }

    public String consultarNumeroTarjeta(){
        return this.numeroTarjeta;
    }

    public void cambiarNumeroTarjeta(String numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta;
    }

    public void mostrarInformacion(){
        System.out.printf("El tipo de tarjeta es: %s, el numero de tarjeta es: %s\n", this.tipoTarjeta, this.numeroTarjeta);
    }

}
