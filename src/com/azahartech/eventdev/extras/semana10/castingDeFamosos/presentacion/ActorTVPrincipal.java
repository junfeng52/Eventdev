package com.azahartech.eventdev.extras.semana10.castingDeFamosos.presentacion;

import com.azahartech.eventdev.extras.semana10.castingDeFamosos.modelo.ActorTV;

public class ActorTVPrincipal {
    public static void main(String[] args) {
        ActorTV a = new ActorTV();
        a.nombre = "Úrsula Corberó";
        a.personaje = "Tokio";
        a.año = 1890;

        ActorTV b = new ActorTV();
        b.nombre = "Álvaro Morte";
        b.personaje = "El Profesor";
        a.año = 1990;

        ActorTV c = new ActorTV();
        c.nombre = "Itziar Ituño";
        c.personaje = "Raquel Murillo";
        a.año = 2009;

        System.out.println(a.nombre + " interpretó a " + a.personaje + " en el año" + a.año);
        System.out.println(b.nombre + " interpretó a " + b.personaje + " en el año" + a.año);
        System.out.println(c.nombre + " interpretó a " + c.personaje + " en el año" + a.año);
    }
}