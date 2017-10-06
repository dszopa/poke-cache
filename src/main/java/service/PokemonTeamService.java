package service;

import data.Pokemon;
import data.PokemonTeam;
import repository.PokemonRepository;
import repository.PokemonTeamRepository;

public class PokemonTeamService {

    private PokemonTeamRepository pokemonTeamRepository;
    private PokemonRepository pokemonRepository;

    public PokemonTeamService(PokemonTeamRepository pokemonTeamRepository, PokemonRepository pokemonRepository) {
        this.pokemonTeamRepository = pokemonTeamRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonTeam createPokemonTeam(PokemonTeam pokemonTeam) {
        for (Pokemon pokemon : pokemonTeam.getPokemonList()) {
            if (pokemon != null && pokemon.getId() == null) {
                // Create a new one!
                Pokemon savedPokemon = pokemonRepository.savePokemon(pokemon);
                pokemon.setId(savedPokemon.getId());
            }
        }

        return pokemonTeamRepository.savePokemonTeam(pokemonTeam);
    }
}
