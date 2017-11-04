package service;

import data.Pokemon;
import dto.PokemonDTO;
import factory.PokemonDtoFactory;
import factory.PokemonFactory;
import model.GetPokemonRequest;
import repository.PokemonRepository;

import java.util.ArrayList;
import java.util.List;

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

    public List<PokemonDTO> getPokemon(GetPokemonRequest getPokemonRequest) {
        List<Pokemon> pokemonList = pokemonRepository.getPokemon(
                getPokemonRequest.getIds(),
                getPokemonRequest.getType(),
                getPokemonRequest.getName());
        return _convertPokemonListToPokemonDtoList(pokemonList);
    }

    /**
     * Gets a PokemonDTO from PokemonRepository by its id.
     * @param id
     *  The Pokemon's id.
     * @return
     *  A PokemonDTO with values filled from the database.
     */
    public PokemonDTO getPokemonById(Long id) {
        Pokemon pokemon = pokemonRepository.getPokemonById(id);
        if (pokemon == null) {
            return null;
        }
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
        if (pokemon == null) {
            return null;
        }
        pokemonDTO.setId(pokemon.getId());
        return pokemonDTO;
    }

    /**
     * Converts a list of Pokemon into a list of PokemonDTOs.
     * @param pokemonList
     *  The list of Pokemon to convert.
     * @return
     *  A list of PokemonDTOs converted from pokemonList.
     */
    private List<PokemonDTO> _convertPokemonListToPokemonDtoList(List<Pokemon> pokemonList) {
        List<PokemonDTO> pokemonDtoList = new ArrayList<>();
        for (Pokemon pokemon : pokemonList) {
            pokemonDtoList.add(pokemonDtoFactory.createPokemonDTO(pokemon));
        }
        return pokemonDtoList;
    }
}
