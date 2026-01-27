package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;

import java.util.UUID;

public class Usuario implements Exportable {
    private String id;
    private String nombreUsuario;
    private String email;
    private DetallePago detallePago;
    private boolean vip;


    public Usuario(){}

    public Usuario(String nombre, String email, boolean vip){
        this.id = UUID.randomUUID().toString();
        this.nombreUsuario = nombre;
        this.email = email;
        this.vip = vip;
    }

    public String consultarNombre(){
        return this.nombreUsuario;
    }

    public void cambiarNombre(String name){
        this.nombreUsuario = name;
    }

    public String consultarEmail(){
        return this.email;
    }

    public void cambiarEmail(String name){
        this.email = name;
    }

    public DetallePago consultarDetallePago(){
        return this.detallePago;
    }

    public void cambiarDetallePago(DetallePago detallePago){
        this.detallePago = detallePago;
    }


    public boolean esVip() {
        return this.vip;
    }

    public void cambiarVip(boolean vip) {
        this.vip = vip;
    }

    public void mostrarInformacion(){
        System.out.printf("El nombre de usuario es: %s, el email es: %s\n", this.nombreUsuario, this.email);
        if (!(detallePago == null)){
            this.detallePago.mostrarInformacion();
        }
    }

    @Override
    public String aXML() {
        return String.format("<nombre>%s<nombre>\n" +
                "<email>%s</email>\n" +
                "<id>%s</id>", this.nombreUsuario, this.email, this.id);
    }

    @Override
    public String aCSV() {
        return String.format("nombre,email,id\n" +
                "%s,%s,%s", this.nombreUsuario, this.email, this.id);
    }
}
