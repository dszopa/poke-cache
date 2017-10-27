package service;

import data.Pokemon;
import dto.PokemonDTO;
import factory.PokemonDtoFactory;
import factory.PokemonFactory;
import repository.PokemonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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
    @SuppressWarnings("unchecked")
    public List<PokemonDTO> getPokemonByIds(List<Long> ids) {
        return _getPokemonList(param -> pokemonRepository.getPokemonByIds((List<Long>) param), ids);
    }

    /**
     * Gets a list of PokemonDTOs from PokemonRepository by their ids.
     * @param type
     *  The type of Pokemon to search for.
     * @return
     *  A list of PokemonDTOs where each PokemonDTO's primary or secondary type is type.
     */
    public List<PokemonDTO> getPokemonByType(String type) {
        return _getPokemonList(param -> pokemonRepository.getPokemonByType((String) param), type);
    }

    /**
     * Gets a list of PokemonDTOs from PokemonRepository by their name.
     * @param name
     *  The name of Pokemon to search for.
     * @return
     *  A list of PokemonDTOs where each PokemonDTO's name is name.
     */
    public List<PokemonDTO> getPokemonByName(String name) {
        return _getPokemonList(param -> pokemonRepository.getPokemonByName((String) param), name);
    }

    /**
     * Takes a function returning a list of Pokemon objects and an object to invoke on the function and returns
     * a list of PokemonDTOs
     * @param function
     *  A function with one parameter returning a list of Pokemon.
     * @param param
     *  The parameter for function.
     * @return
     *  The result of function invoked with parameter then converted to a list.
     */
    private List<PokemonDTO> _getPokemonList(Function<Object, List<Pokemon>> function, Object param) {
        List<Pokemon> pokemonList = function.apply(param);
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
