package extras.unidad4.semana10.personajesIconicos.presentacion;

import extras.unidad4.semana10.personajesIconicos.modelo.Pato;
import extras.unidad4.semana10.personajesIconicos.modelo.Leon;
import extras.unidad4.semana10.personajesIconicos.modelo.Vaca;

public class PersonajesIconicos2 {
    public static void main(String[] args) {
        Pato donald = new Pato();
        Pato lucas = new Pato();
        donald.graznar();
        lucas.graznar();
        Leon simba = new Leon();
        simba.rugir();
        simba.rugir();
        Vaca milka = new Vaca();
        milka.mugir();
    }
}