package com.azahartech.eventdev.pagos;

public class PagoBizum implements ProcesadorPago{
    private String telefono;
    private int pin;

    public PagoBizum(String telefono, int pin) {
        this.telefono = telefono;
        this.pin = pin;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    @Override
    public boolean procesarPago(double cantidad) {
        System.out.printf("El telefono %s esta pagando %.2f\n",this.telefono, cantidad);
        return telefono.matches("\\d{9}") && telefono.length() == 9;
    }
}
