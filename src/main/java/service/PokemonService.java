package service;

import data.Pokemon;
import dto.PokemonDTO;
import factory.PokemonDtoFactory;
import factory.PokemonFactory;
import repository.PokemonRepository;

public class PokemonService {

    private PokemonRepository pokemonRepository;
    private PokemonFactory pokemonFactory;
    private PokemonDtoFactory pokemonDtoFactory;

    /**
     * Interacts with a PokemonRepository to provide a wrapper for error handling as well as
     * a nicer interface for saving, updating, and retrieving Pokemon.
     * @param pokemonRepository
     *  A PokemonRepository with access to a database.
     * @param pokemonDtoFactory
     *  Factory used to create PokemonDTO Objects.
     * @param pokemonFactory
     *  Factory used to create Pokemon Objects.
     */
    public PokemonService(PokemonRepository pokemonRepository, PokemonFactory pokemonFactory,
                          PokemonDtoFactory pokemonDtoFactory) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonFactory = pokemonFactory;
        this.pokemonDtoFactory = pokemonDtoFactory;
    }

    /**
     * Gets a Pokemon from PokemonRepository by its id.
     * @param id
     *  The Pokemon's id we want to search by.
     * @return
     *  The PokemonDTO with Pokemon data from PokemonRepository
     */
    public PokemonDTO getPokemon(Long id) {
        Pokemon pokemon = pokemonRepository.getPokemonById(id);
        return pokemonDtoFactory.createFromPokemon(pokemon);
    }

    /**
     * Creates a Pokemon based off of the given PokemonDTO object on a database through PokemonRepository
     * @param pokemonDTO
     *  The PokemonDTO object that will be persisted to a database.
     * @return
     *  The persisted PokemonDTO.
     */
    public PokemonDTO createPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = pokemonFactory.createFromPokemonDTO(pokemonDTO);
        pokemon = pokemonRepository.savePokemon(pokemon);
        pokemonDTO.setId(pokemon.getId());
        return pokemonDTO;
    }
}
