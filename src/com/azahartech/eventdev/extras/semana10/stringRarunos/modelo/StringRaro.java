package com.azahartech.eventdev.extras.semana10.stringRarunos.modelo;

public class StringRaro {
    String mensaje;
    public void cambiarMensaje(String nuevoMensaje) {
        mensaje = nuevoMensaje;
    }
    public String consultarMensaje() {
        return mensaje;
    }
    public void invertir() {
        String mensajeInvertido = "";
        for ( int i=mensaje.length()-1; i>=0; i-- )
            mensajeInvertido += mensaje.substring(i,i+1);
        mensaje = mensajeInvertido;
    }
    public void camelCase() {
        String[] palabras = mensaje.toLowerCase().split(" ");
        String resultado = "";
        for (String palabra : palabras)
            resultado += palabra.substring(0,1).toUpperCase() + palabra.substring(1);
        mensaje = resultado;
    }
}
