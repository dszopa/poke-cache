package service;

import data.Pokemon;
import data.PokemonTeam;
import dto.PokemonDTO;
import dto.PokemonTeamDTO;
import factory.PokemonDtoFactory;
import factory.PokemonFactory;
import factory.PokemonTeamDtoFactory;
import factory.PokemonTeamFactory;
import repository.PokemonRepository;
import repository.PokemonTeamRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonTeamService {

    private final PokemonTeamRepository pokemonTeamRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonDtoFactory pokemonDtoFactory;
    private final PokemonFactory pokemonFactory;
    private final PokemonTeamDtoFactory pokemonTeamDtoFactory;
    private final PokemonTeamFactory pokemonTeamFactory;

    /**
     * Interacts with a PokemonRepository & PokemonTeamRepository to provide a wrapper for error handling as well
     * as a nicer interface for saving, updating, and retrieving PokemonTeams.
     * @param pokemonTeamRepository
     *  A PokemonTeamRepository with access to a database.
     * @param pokemonRepository
     *  A PokemonRepository with access to a database.
     * @param pokemonFactory
     *  Reusable factory used to create Pokemon objects.
     * @param pokemonDtoFactory
     *  Reusable factory used to create PokemonDTO objects.
     * @param pokemonTeamFactory
     *  Reusable factory to create PokemonTeam objects.
     * @param pokemonTeamDtoFactory
     *  Reusable factory to create PokemonTeamDTO objects.
     */
    public PokemonTeamService(PokemonTeamRepository pokemonTeamRepository, PokemonRepository pokemonRepository,
                              PokemonFactory pokemonFactory, PokemonDtoFactory pokemonDtoFactory,
                              PokemonTeamFactory pokemonTeamFactory, PokemonTeamDtoFactory pokemonTeamDtoFactory) {
        this.pokemonTeamRepository = pokemonTeamRepository;
        this.pokemonRepository = pokemonRepository;
        this.pokemonFactory = pokemonFactory;
        this.pokemonDtoFactory = pokemonDtoFactory;
        this.pokemonTeamFactory = pokemonTeamFactory;
        this.pokemonTeamDtoFactory = pokemonTeamDtoFactory;
    }

    /**
     * Gets a PokemonTeamDTO by its database id.
     * @param id
     *  The PokemonTeam's id.
     * @return
     *  A PokemonTeamDTO with values filled from the database.
     */
    public PokemonTeamDTO getPokemonTeam(Long id) {
        PokemonTeam pokemonTeam = pokemonTeamRepository.getPokemonTeamById(id);
        Map<Long, PokemonDTO> pokemonDtoMap = _createPokemonPokemonDtoMapFromPokemonIdList(pokemonTeam.getPokemonIdList());
        return pokemonTeamDtoFactory.createPokemonTeamDto(pokemonTeam, pokemonDtoMap);
    }

    /**
     * Gets a List of PokemonTeamDTO where each DTO has a format matching the provided format.
     * @param format
     *  The format to search by.
     * @return
     *  A list of PokemonTeamDTO where each DTO has its values filled from the database.
     */
    public List<PokemonTeamDTO> getPokemonTeamsByFormat(String format) {
        List<PokemonTeam> pokemonTeams = pokemonTeamRepository.getPokemonTeamsByFormat(format);
        return _convertPokemonTeamsToPokemonTeamDtos(pokemonTeams);
    }

    /**
     * Gets a list of PokemonTeamDTO where each DTO has a format matching the provided format.
     * @param teamName
     *  The teamName to search by.
     * @return
     *  A list of PokemonTeamDTO where each DTO has its values filled from the database.
     */
    public List<PokemonTeamDTO> getPokemonTeamsByTeamName(String teamName) {
        List<PokemonTeam> pokemonTeams = pokemonTeamRepository.getPokemonTeamsByTeamName(teamName);
        return _convertPokemonTeamsToPokemonTeamDtos(pokemonTeams);
    }

    /**
     * Persists a PokemonTeam based off of the given PokemonTeamDTO object.
     * @param pokemonTeamDto
     *  The PokemonTeamDTO object that will be persisted.
     * @return
     *  The persisted PokemonTeamDTO.
     */
    public PokemonTeamDTO createPokemonTeam(PokemonTeamDTO pokemonTeamDto) {
        // Create Pokemon if they don't already exist
        for (PokemonDTO pokemonDTO : pokemonTeamDto.getPokemonList()) {
            if (pokemonDTO.getId() == null) {
                Pokemon pokemon = pokemonFactory.createPokemon(pokemonDTO);
                pokemon = pokemonRepository.savePokemon(pokemon);
                pokemonDTO.setId(pokemon.getId());
            }
        }

        PokemonTeam pokemonTeam = pokemonTeamFactory.createPokemonTeam(pokemonTeamDto);
        pokemonTeam = pokemonTeamRepository.savePokemonTeam(pokemonTeam);
        pokemonTeamDto.setId(pokemonTeam.getId());
        return pokemonTeamDto;
    }

    /**
     * Converts a list of PokemonTeams into a list of PokemonTeamDtos.
     * @param pokemonTeams
     *  The list of PokemonTeams to convert.
     * @return
     *  The converted PokemonTeamDTO list.
     */
    private List<PokemonTeamDTO> _convertPokemonTeamsToPokemonTeamDtos(List<PokemonTeam> pokemonTeams) {
        List<PokemonTeamDTO> pokemonTeamDtoList = new ArrayList<>();

        for (PokemonTeam pokemonTeam : pokemonTeams) {
            Map<Long, PokemonDTO> pokemonDtoMap = _createPokemonPokemonDtoMapFromPokemonIdList(
                    pokemonTeam.getPokemonIdList());
            pokemonTeamDtoList.add(pokemonTeamDtoFactory.createPokemonTeamDto(pokemonTeam, pokemonDtoMap));
        }

        return pokemonTeamDtoList;
    }

    /**
     * Creates a Map of id to PokemonDTO for a list of Pokemon ids.
     * @param ids
     *  The ids that the map will be created from.
     * @return
     *  A Map with key id and value PokemonDTO where the id is the Pokemon's id and value is the converted Pokemon.
     */
    private Map<Long, PokemonDTO> _createPokemonPokemonDtoMapFromPokemonIdList(List<Long> ids) {
        List<Pokemon> pokemonList = pokemonRepository.getPokemonByIds(ids);
        Map<Long, PokemonDTO> pokemonDtoMap = new HashMap<>();
        for (Pokemon pokemon : pokemonList) {
            pokemonDtoMap.put(pokemon.getId(), pokemonDtoFactory.createPokemonDTO(pokemon));
        }
        return pokemonDtoMap;
    }
}
