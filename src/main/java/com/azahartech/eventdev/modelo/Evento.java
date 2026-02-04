package com.azahartech.eventdev.modelo;

import com.azahartech.eventdev.util.Exportable;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class Evento implements Exportable {
    protected String id;
    protected String nombre;
    protected LocalDate fecha;
    protected Recinto recinto;
    protected double precioEntrada;
    protected boolean benefico = false;
    private EstadoEvento estado;
    private TipoEvento tipo = TipoEvento.CONCIERTO;

    public Evento(){}

    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada){
        this(nombre, fecha, recinto, precioEntrada, false, "EVT-2025-MAD");
    }

    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String id){
        this(nombre, fecha, recinto, precioEntrada, false, "EVT-2025-MAD");
    }

    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, boolean benefico, String id){
        this(nombre, fecha, recinto, precioEntrada, benefico, id, TipoEvento.DEPORTE);
    }


    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, boolean benefico, String id, TipoEvento tipo){
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.recinto = recinto;
        this.precioEntrada = precioEntrada;
        this.benefico = benefico;
        this.estado = EstadoEvento.PLANIFICADO;
    }

    public final String obtenerCodigoReferencia(){
        return "REF-[" + this.id + "]-NOM-[" + this.nombre + "]";
    }

    public abstract double calcularCosteOperativo();

    public final double calcularPrecioVentaRecomendado(){
        final double MARGEN = 0.20;
        return ((double) calcularCosteOperativo() / this.recinto.consultarAforoMaximo()) * (1 + MARGEN);
    }

    @SuppressWarnings("PMD.EmptyMethodInAbstractClassShouldBeAbstract")
    public boolean registrarVenta(){
        if(this.estado == EstadoEvento.ACTIVO){
            System.out.println("Evento registrado");
        }else {
            System.out.println("No se pueden vendes entradas. El evento está " + this.estado);
        }
        return this.estado == EstadoEvento.ACTIVO;
    }

    public String consultarId(){
        return this.id;
    }

    public String consultarNombre(){
        return this.nombre;
    }

    public void cambiarNombre(String nombre){
        this.nombre = nombre;
    }

    public LocalDate consultarFecha(){
        return this.fecha;
    }

    public void cambiarFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public Recinto consultarRecinto(){
        return this.recinto;
    }

    public void cambiarRecinto(Recinto recinto){
        this.recinto = recinto;
    }

    public double consultarPrecioEntrada(){
        return this.precioEntrada;
    }

    public void cambiarPrecioEntrada(double precioEntrada){
        this.precioEntrada = precioEntrada;
    }

    public boolean esBenefico(){
        return this.benefico;
    }

    public void cambiarBenefico(boolean benefico){
        this.benefico = benefico;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public void activarVenta(){
        this.estado = EstadoEvento.ACTIVO;
    }

    public void cancelarEvento(){
        this.estado = EstadoEvento.CANCELADO;
    }

    public void finalizarEvento(){
        this.estado = EstadoEvento.FINALIZADO;
    }


    public void mostrarInformacion(){
        System.out.printf("El nombre del evento es: %s, la fecha es: %s y el precio es: %.2f€ y su estado actual es %s, es de tipo: %s\n", this.nombre, this.fecha, this.precioEntrada, this.estado, this.tipo.getDescripcion());
        this.recinto.mostrarInformacion();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(id, evento.id);
    }

    @Override
    public String aCSV() {
        return String.format("%s,%s,%s,%s,%s,%s", this.id, this.nombre, this.fecha, this.recinto.consultarNombre(), this.precioEntrada, this.benefico);
    }
}
