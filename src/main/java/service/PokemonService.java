package service;

import data.Pokemon;
import dto.PokemonDTO;
import factory.PokemonDtoFactory;
import factory.PokemonFactory;
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

    /**
     * Gets a PokemonDTO from PokemonRepository by its id.
     * @param id
     *  The Pokemon's id.
     * @return
     *  A PokemonDTO with values filled from the database.
     */
    public PokemonDTO getPokemonById(Long id) {
        Pokemon pokemon = pokemonRepository.getPokemonById(id);
        return pokemonDtoFactory.createPokemonDTO(pokemon);
    }

    /**
     * Gets a list of PokemonDTOs from PokemonRepository by their ids.
     * @param ids
     *  The ids of Pokemon to search for.
     * @return
     *  A list of PokemonDTOs where each PokemonDTO's id is in ids.
     */
    public List<PokemonDTO> getPokemonByIds(List<Long> ids) {
        List<Pokemon> pokemonList = pokemonRepository.getPokemonByIds(ids);
        return _convertPokemonListToPokemonDtoList(pokemonList);
    }

    /**
     * Gets a list of PokemonDTOs from PokemonRepository by their ids.
     * @param type
     *  The type of Pokemon to search for.
     * @return
     *  A list of PokemonDTOs where each PokemonDTO's primary or secondary type is type.
     */
    public List<PokemonDTO> getPokemonByType(String type) {
        List<Pokemon> pokemonList = pokemonRepository.getPokemonByType(type);
        return _convertPokemonListToPokemonDtoList(pokemonList);
    }

    /**
     * Gets a list of PokemonDTOs from PokemonRepository by their name.
     * @param name
     *  The name of Pokemon to search for.
     * @return
     *  A list of PokemonDTOs where each PokemonDTO's name is name.
     */
    public List<PokemonDTO> getPokemonByName(String name) {
        List<Pokemon> pokemonList = pokemonRepository.getPokemonByName(name);
        return _convertPokemonListToPokemonDtoList(pokemonList);
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
