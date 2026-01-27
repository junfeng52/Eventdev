package com.azahartech.eventdev.util;

import java.util.List;

public class UtilidadExportacion {
    public static void exportarLista(List<Exportable> listaObjetos){
        for (Exportable listaObjeto : listaObjetos) {
            System.out.println(listaObjeto.aCSV());
            System.out.println(listaObjeto.aXML());
        }
    }
}