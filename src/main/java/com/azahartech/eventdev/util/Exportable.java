package com.azahartech.eventdev.util;

public interface Exportable {
    String aCSV();
    String aXML(int indent);
    // Si no pones ningun parametro en aXML te pone un indent de 0
    default String aXML() {
        return aXML(0);
    }
}
