package factory;

import data.PokemonTeam;
import dto.PokemonDTO;
import dto.PokemonTeamDTO;

import java.util.ArrayList;
import java.util.List;

public class PokemonTeamFactory {

    public PokemonTeam createPokemonTeam(PokemonTeamDTO pokemonTeamDTO) {
        List<Long> pokemonIds = new ArrayList<>();
        for (PokemonDTO pokemonDTO : pokemonTeamDTO.getPokemonList()) {
            pokemonIds.add(pokemonDTO.getId());
        }
        return new PokemonTeam(pokemonTeamDTO.getId(), pokemonTeamDTO.getTeamName(), pokemonTeamDTO.getFormat(),
                pokemonIds);
    }
}
