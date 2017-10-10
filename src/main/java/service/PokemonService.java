package service;

import data.Pokemon;
import repository.PokemonRepository;

public class PokemonService {

    private PokemonRepository pokemonRepository;

    /**
     * Interacts with a PokemonRepository to provide a wrapper for error handling as well as
     * a nicer interface for saving, updating, and retrieving Pokemon.
     * @param pokemonRepository
     *  A PokemonRepository with access to a database.
     */
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    /**
     * Gets a Pokemon from PokemonRepository by its id.
     * @param id
     *  The Pokemon's id we want to search by.
     * @return
     *  The Pokemon from the database with id matching the given id.
     */
    public Pokemon getPokemon(Long id) {
        return pokemonRepository.getPokemonById(id);
    }

    /**
     * Creates a Pokemon based off of the given Pokemon object on a database through PokemonRepository
     * @param pokemon
     *  The Pokemon object that will be persisted to a database.
     * @return
     *  The persisted Pokemon object.
     */
    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.savePokemon(pokemon);
    }
}
