package com.azahartech.eventdev.pagos;

public class PagoTarjeta implements ProcesadorPago {
    private String numeroTarjeta;
    private String fechaCaducidad;

    public PagoTarjeta(String numeroTarjeta, String fechaCaducidad) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public boolean procesarPago(double cantidad) {
        System.out.printf("Procesando pago de %.2f con Tarjeta %s\n", cantidad, this.numeroTarjeta);
        return this.numeroTarjeta.length() == 12;
    }
}
