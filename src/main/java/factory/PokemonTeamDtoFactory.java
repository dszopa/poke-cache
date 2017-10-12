package factory;

import data.PokemonTeam;
import dto.PokemonDTO;
import dto.PokemonTeamDTO;

import java.util.List;

public class PokemonTeamDtoFactory {

    public PokemonTeamDTO createPokemonTeamDto(PokemonTeam pokemonTeam, List<PokemonDTO> pokemonDtoList) {
        return new PokemonTeamDTO(pokemonTeam.getId(), pokemonTeam.getTeamName(), pokemonTeam.getFormat(),
                pokemonDtoList);
    }
}
