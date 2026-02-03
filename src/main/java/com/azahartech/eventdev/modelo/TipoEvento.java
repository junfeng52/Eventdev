package com.azahartech.eventdev.modelo;

public enum TipoEvento {
    CONCIERTO('C', "Música en vivo"),
    TEATRO('T', "Teatro en vivo"),
    DEPORTE('D', "Deporte en vivo"),
    FESTIVAL('F', "Festival en vivo");
    final char codigo;
    final String descripcion;

    TipoEvento(char codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public char getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
