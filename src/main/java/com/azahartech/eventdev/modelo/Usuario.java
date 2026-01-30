package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;
import com.azahartech.eventdev.util.Notificable;

import java.util.UUID;

public class Usuario implements Exportable, Notificable, Comparable<Usuario> {
    private String id;
    private String nombreUsuario;
    private String email;
    private DetallePago detallePago;
    private boolean vip;


    public Usuario(){}

    public Usuario(String nombre, String email, boolean vip){
        this(nombre, email, vip, null);
    }

    public Usuario(String nombre, String email, boolean vip, DetallePago detallePago){
        this.id = UUID.randomUUID().toString();
        this.nombreUsuario = nombre;
        this.email = email;
        this.vip = vip;
        this.detallePago = detallePago;
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
    public String aXML(int indent) {
        String tabs = "\t".repeat(indent);
        return tabs + "<usuario>\n" +
               tabs + "\t<id>" + this.id + "</id>\n"+
               tabs + "\t<nombre>" + this.nombreUsuario + "<nombre>\n" +
               tabs + "\t<email>" + this.email + "</email>\n" +
               ((this.detallePago != null) ? this.detallePago.aXML(indent + 1) : "") +
               tabs + "</usuario>\n";
    }

    @Override
    public String aCSV() {
        return String.format("%s,%s,%s", this.nombreUsuario, this.email, this.id);
    }


    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando email a " + email + ": " + mensaje);
    }

    @Override
    public int compareTo(Usuario o) {
        return this.nombreUsuario.compareTo(o.nombreUsuario);
    }
}
