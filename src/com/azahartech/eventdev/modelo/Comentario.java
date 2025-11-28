package com.azahartech.eventdev.modelo;

public class Comentario {
    private Evento evento;
    private Usuario autor;
    private int puntacion;
    private String comentario;

    public Comentario(Evento evento, Usuario autor, int puntacion, String comentario){
        this.evento = evento;
        this.autor = autor;
        this.puntacion = (puntacion <= 1) ? 1 : (puntacion >= 5) ? 5 : puntacion;
        this.comentario = comentario;
    }

    public Evento consultarEvento() {
        return this.evento;
    }

    public void cambiarEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario consultarAutor() {
        return this.autor;
    }

    public void cambiarAutor(Usuario autor) {
        this.autor = autor;
    }

    public int consultarPuntacion() {
        return this.puntacion;
    }

    public void cambiarPuntacion(int puntacion) {
        this.puntacion = puntacion;
    }

    public String consultarComentario() {
        return this.comentario;
    }

    public void cambiarComentario(String comentario) {
        this.comentario = comentario;
    }

    public void mostarInformacion(){
        System.out.printf("El usuario %s ha cometado en el evento %s, con una puntacion de %d y a publicado el siguiente comentario:%s\n",
                this.autor.consultarNombre(), this.evento.consultarNombre(), this.consultarPuntacion(), this.consultarComentario());
    }
}
