package extras.unidad4.semana10.pokemon;

public class GeneradorPokemon {
    public static Pokemon Generar(){
        double rng = Math.random();

        String genero = ((int)(rng*3) == 0) ? "Masculino" : ((int)(rng*3) == 1) ? "Femenino" : "Sin Genero";
        boolean shiny = (rng > 0.999) ? true : false;
        return new Pokemon("Pikachu", "Electrico", genero, shiny, 1, 1,1);
    }
}
