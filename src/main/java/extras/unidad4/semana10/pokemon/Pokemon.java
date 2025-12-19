package extras.unidad4.semana10.pokemon;

public class Pokemon {
    private int nivel;
    private String nombre;
    private String apodo;
    private String tipo;
    private String genero;
    private boolean shiny;
    private int atk;
    private int def;
    private int hp;

    public Pokemon(String nombre, String tipo, String genero, boolean shiny, int atk, int def, int hp){
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
        this.shiny = shiny;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
    }


    public String obtenerNombre() {
        return this.nombre;
    }

    public void cambiarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerGenero() {
        return this.genero;
    }

    public void cambiarGenero(String genero) {
        this.genero = genero;
    }

    public String obtenerApodo() {
        return this.apodo;
    }

    public void cambiarApodo(String apodo) {
        this.apodo = apodo;
    }

    public String obtenerTipo() {
        return this.tipo;
    }

    public void cambiarTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean obtenerShiny() {
        return this.shiny;
    }

    public void cambiarShiny(boolean shiny) {
        this.shiny = shiny;
    }

    public int obtenerAtk() {
        return this.atk;
    }

    public void cambiarAtk(int atk) {
        this.atk = atk;
    }

    public int obtenerDef() {
        return this.def;
    }

    public void cambiarDef(int def) {
        this.def = def;
    }

    public int obtenerHp() {
        return this.hp;
    }

    public void cambiarHp(int hp) {
        this.hp = hp;
    }

}
