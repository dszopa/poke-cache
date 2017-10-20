package service;

import data.Pokemon;
import dto.PokemonDTO;
import factory.PokemonDtoFactory;
import factory.PokemonFactory;
import repository.PokemonRepository;

public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonFactory pokemonFactory;
    private final PokemonDtoFactory pokemonDtoFactory;

    /**
     * Interacts with a PokemonRepository to provide a wrapper for error handling as well as
     * a nicer interface for saving, updating, and retrieving Pokemon.
     * @param pokemonRepository
     *  A PokemonRepository with access to a database.
     * @param pokemonDtoFactory
     *  Reusable factory used to create PokemonDTO objects.
     * @param pokemonFactory
     *  Reusable factory used to create Pokemon objects.
     */
    public PokemonService(PokemonRepository pokemonRepository, PokemonFactory pokemonFactory,
                          PokemonDtoFactory pokemonDtoFactory) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonFactory = pokemonFactory;
        this.pokemonDtoFactory = pokemonDtoFactory;
    }

    /**
     * Gets a PokemonDTO from PokemonRepository by its id.
     * @param id
     *  The Pokemon's id.
     * @return
     *  A PokemonDTO with values filled from the database.
     */
    public PokemonDTO getPokemon(Long id) {
        Pokemon pokemon = pokemonRepository.getPokemonById(id);
        return pokemonDtoFactory.createPokemonDTO(pokemon);
    }

    /**
     * Persists a Pokemon based off of the given PokemonDTO object.
     * @param pokemonDTO
     *  The PokemonDTO object that will be persisted.
     * @return
     *  The persisted PokemonDTO.
     */
    public PokemonDTO createPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = pokemonFactory.createPokemon(pokemonDTO);
        pokemon = pokemonRepository.savePokemon(pokemon);
        pokemonDTO.setId(pokemon.getId());
        return pokemonDTO;
    }
}
