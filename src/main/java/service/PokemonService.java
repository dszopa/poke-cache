package service;

import data.Pokemon;
import repository.PokemonRepository;

public class PokemonService {

    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon getPokemon(Long id) {
//        return pokemonRepository.getPokemonById(id);
        return new Pokemon("Squirtle", "Squirt", "Choice Band", "Hydration", 99,
                "Water", null, 100, 101, 102, 103, 104,
                105, "Bubble", "Water Gun", "Hydro Pump", "Cut");
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.savePokemon(pokemon);
    }
}
