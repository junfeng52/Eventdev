package com.azahartech.eventdev.extras.semana10.pokemon;

public class PokemonInfo {
    public static void main(String[] args) {
        Pokemon pikachu = GeneradorPokemon.Generar();
        System.out.println(pikachu.obtenerApodo());
        System.out.println(pikachu.obtenerGenero());
    }
}
