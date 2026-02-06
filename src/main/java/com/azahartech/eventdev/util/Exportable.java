package com.azahartech.eventdev.util;

public interface Exportable {
    String aCSV();
    String aXML(int indent, String name);
    default String aXML(int indent){
        return aXML(indent, null);
    }
    default String aXML(String name) {
        return aXML(0, name);
    }
    // Si no pones ningun parametro en aXML te pone un indent de 0
    default String aXML() {
        return aXML(0,null);
    }
}
