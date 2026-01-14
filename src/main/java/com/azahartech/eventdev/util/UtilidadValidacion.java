package com.azahartech.eventdev.util;

import java.time.LocalDate;
import java.util.Locale;

public class UtilidadValidacion {
    public static boolean esEmailValido(String email){
        //return email != null && email != "" && email.indexOf("@") >= 1 && email.indexOf(".") > email.indexOf("@");
        return email != null && email != "" && email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,4}");
    }

    public static boolean esPuntuacionValida(int puntuacion){
        return puntuacion >= 1 && puntuacion <= 5;
    }

    public static boolean esFechaFutura(LocalDate fecha){
        return LocalDate.now().isBefore(fecha);
    }

    public static boolean esCodigoEventoValido(String codigo){
        return codigo.matches("EVT-\\d{4}-[A-Z]{3}");
    }
}
