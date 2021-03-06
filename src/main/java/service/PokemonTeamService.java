package service;

import data.Pokemon;
import data.PokemonTeam;
import dto.PokemonDTO;
import dto.PokemonTeamDTO;
import factory.PokemonDtoFactory;
import factory.PokemonFactory;
import factory.PokemonTeamDtoFactory;
import factory.PokemonTeamFactory;
import model.GetPokemonTeamsRequest;
import repository.MoveRepository;
import repository.PokemonRepository;
import repository.PokemonTeamRepository;
import repository.TypeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonTeamService {

    private final PokemonTeamRepository pokemonTeamRepository;
    private final PokemonRepository pokemonRepository;
    private final TypeRepository typeRepository;
    private final MoveRepository moveRepository;
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
                              TypeRepository typeRepository, MoveRepository moveRepository,
                              PokemonFactory pokemonFactory, PokemonDtoFactory pokemonDtoFactory,
                              PokemonTeamFactory pokemonTeamFactory, PokemonTeamDtoFactory pokemonTeamDtoFactory) {
        this.pokemonTeamRepository = pokemonTeamRepository;
        this.pokemonRepository = pokemonRepository;
        this.typeRepository = typeRepository;
        this.moveRepository = moveRepository;
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
    public PokemonTeamDTO getPokemonTeamById(Long id) {
        PokemonTeam pokemonTeam = pokemonTeamRepository.getPokemonTeamById(id);
        if (pokemonTeam == null) {
            return null;
        }
        Map<Long, PokemonDTO> pokemonDtoMap = _createPokemonPokemonDtoMapFromPokemonIdList(pokemonTeam.getPokemonIdList());
        return pokemonTeamDtoFactory.createPokemonTeamDto(pokemonTeam, pokemonDtoMap);
    }

    public List<PokemonTeamDTO> getPokemonTeams(GetPokemonTeamsRequest getPokemonTeamsRequest) {
        List<PokemonTeam> pokemonTeams = pokemonTeamRepository.getPokemonTeams(
                getPokemonTeamsRequest.getFormat(),
                getPokemonTeamsRequest.getTeamName());
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

        if (pokemonTeam == null) {
            return null;
        }

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
        List<Pokemon> pokemonList = pokemonRepository.getPokemon(ids, null, null);
        Map<Long, PokemonDTO> pokemonDtoMap = new HashMap<>();
        for (Pokemon pokemon : pokemonList) {
            List<String> moveStrings = new ArrayList<>();
            moveRepository.getMovesByPokemonId(pokemon.getId()).forEach(move -> moveStrings.add(move.getName()));

            List<String> typeStrings = new ArrayList<>();
            typeRepository.getTypesByPokemonId(pokemon.getId()).forEach(type -> typeStrings.add(type.getName()));

            pokemonDtoMap.put(pokemon.getId(), pokemonDtoFactory.createPokemonDTO(pokemon, typeStrings, moveStrings));
        }
        return pokemonDtoMap;
    }
}
