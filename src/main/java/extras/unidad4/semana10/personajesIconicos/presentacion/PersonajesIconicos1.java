package extras.unidad4.semana10.personajesIconicos.presentacion;

class Leon {
    public void rugir() {
        System.out.println("Un león ruge");
    }
}
class Pato {
    public void graznar() {
        System.out.println("Un pato grazna");
    }
}
class Vaca {
    public void mugir() {
        System.out.println("Una vaca muge");
    }
}
public class PersonajesIconicos1 {
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