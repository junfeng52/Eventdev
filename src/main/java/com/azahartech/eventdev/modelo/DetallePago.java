package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;

public class DetallePago implements Exportable {
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

    @Override
    public String aXML(int indent, String name) {
        String tabs = "\t".repeat(indent);
        name = (name == null) ? "detallePago" : name;
        return  tabs + "<" + name + ">\n" +
               tabs + "\t<tipoTarjeta>" + this.tipoTarjeta + "</tipoTarjeta>\n" +
               tabs + "\t<numeroTarjeta>" + this.numeroTarjeta + "</numeroTarjeta>\n" +
               tabs + "</" + name + ">\n";
    }

    @Override
    public String aCSV() {
        return String.format("%s, %s", this.tipoTarjeta, this.numeroTarjeta);
    }
}
