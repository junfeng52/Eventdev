package com.azahartech.eventdev.util;

import java.time.LocalDate;
import java.util.Locale;

public class UtilidadValidacion {
    public static boolean esEmailValido(String email){
        return email.indexOf("@") >= 1 && email.indexOf(".") > email.indexOf("@");
    }

    public static boolean esPuntuacionValida(int puntuacion){
        return puntuacion >= 1 && puntuacion <= 5;
    }

    public static boolean esFechaFutura(LocalDate fecha){
        return LocalDate.now().isBefore(fecha);
    }


}
