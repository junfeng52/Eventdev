package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Notificable;

public class Administrador implements Notificable {

    @Override
    public void enviarNotificacion(String mensaje) {
        System.err.println(mensaje);
    }
}