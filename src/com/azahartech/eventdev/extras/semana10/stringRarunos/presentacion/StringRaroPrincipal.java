package com.azahartech.eventdev.extras.semana10.stringRarunos.presentacion;

import com.azahartech.eventdev.extras.semana10.stringRarunos.modelo.StringRaro;

import java.util.Scanner;

public class StringRaroPrincipal {
    public static void main( String[] args ) {
        Scanner teclado = new Scanner(System.in);
// permite que el usuario escriba un mensaje
        System.out.print("Escribe un mensaje: ");
        String mensaje = teclado.nextLine();
        StringRaro sr = new StringRaro();
        sr.cambiarMensaje(mensaje);
        sr.invertir();
        sr.camelCase();
// muestra el resultado del mensaje invertido y con formato camelCase
        System.out.println(sr.consultarMensaje() );
    }
}