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
import java.util.List;

public class PokemonTeamService {

    private PokemonTeamRepository pokemonTeamRepository;
    private PokemonRepository pokemonRepository;
    private PokemonDtoFactory pokemonDtoFactory;
    private PokemonFactory pokemonFactory;
    private PokemonTeamDtoFactory pokemonTeamDtoFactory;
    private PokemonTeamFactory pokemonTeamFactory;

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

        // Grab the Pokemon on the team from the database.
        List<PokemonDTO> pokemonDtoList = new ArrayList<>();
        for (Long pokemonId : pokemonTeam.getPokemonIdList()) {
            Pokemon pokemon = pokemonRepository.getPokemonById(pokemonId);
            if (pokemon != null) {
                pokemonDtoList.add(pokemonDtoFactory.createPokemonDTO(pokemon));
            }
        }

        return pokemonTeamDtoFactory.createPokemonTeamDto(pokemonTeam, pokemonDtoList);
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
}
