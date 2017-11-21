package service;

import data.Pokemon;
import dto.PokemonDTO;
import dto.TextPokemonDTO;
import factory.PokemonDtoFactory;
import factory.PokemonFactory;
import model.GetPokemonRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.MoveRepository;
import repository.PokemonRepository;
import repository.TypeRepository;

import java.util.ArrayList;
import java.util.List;

public class PokemonService {

    private final static Logger logger = LoggerFactory.getLogger(PokemonService.class);

    private final PokemonRepository pokemonRepository;
    private final TypeRepository typeRepository;
    private final MoveRepository moveRepository;
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
    public PokemonService(PokemonRepository pokemonRepository, TypeRepository typeRepository,
                          MoveRepository moveRepository, PokemonFactory pokemonFactory,
                          PokemonDtoFactory pokemonDtoFactory) {
        this.pokemonRepository = pokemonRepository;
        this.typeRepository = typeRepository;
        this.moveRepository = moveRepository;
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

        List<String> typeStrings = new ArrayList<>();
        typeRepository.getTypesByPokemonId(id).forEach(type -> typeStrings.add(type.getName()));

        List<String> moveStrings = new ArrayList<>();
        moveRepository.getMovesByPokemonId(id).forEach(move -> moveStrings.add(move.getName()));

        return pokemonDtoFactory.createPokemonDTO(pokemon, typeStrings, moveStrings);
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

        typeRepository.saveTypes(pokemon.getId(), pokemonDTO.getTypes());
        moveRepository.saveMoves(pokemon.getId(), pokemonDTO.getMoves());

        pokemonDTO.setId(pokemon.getId());
        return pokemonDTO;
    }

    public TextPokemonDTO createPokemon(TextPokemonDTO textPokemonDTO) {
        PokemonDTO pokemonDTO = pokemonDtoFactory.createPokemonDTO(textPokemonDTO);
        Pokemon pokemon = pokemonFactory.createPokemon(pokemonDTO);
        pokemon = pokemonRepository.savePokemon(pokemon);

        if (pokemon == null) {
            return null;
        }

        typeRepository.saveTypes(pokemon.getId(), pokemonDTO.getTypes());
        moveRepository.saveMoves(pokemon.getId(), pokemonDTO.getMoves());

        textPokemonDTO.setId(pokemon.getId());
        return textPokemonDTO;
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

            List<String> typeStrings = new ArrayList<>();
            typeRepository.getTypesByPokemonId(pokemon.getId()).forEach(type -> typeStrings.add(type.getName()));

            List<String> moveStrings = new ArrayList<>();
            moveRepository.getMovesByPokemonId(pokemon.getId()).forEach(move -> moveStrings.add(move.getName()));

            pokemonDtoList.add(pokemonDtoFactory.createPokemonDTO(pokemon, typeStrings, moveStrings));
        }
        return pokemonDtoList;
    }
}
