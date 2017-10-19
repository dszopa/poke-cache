package factory;

import data.PokemonTeam;
import dto.PokemonDTO;
import dto.PokemonTeamDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PokemonTeamDtoFactory {

    public PokemonTeamDTO createPokemonTeamDto(PokemonTeam pokemonTeam, List<PokemonDTO> pokemonDtoList) {
        return new PokemonTeamDTO(pokemonTeam.getId(), pokemonTeam.getTeamName(), pokemonTeam.getFormat(),
                pokemonDtoList);
    }

    public PokemonTeamDTO createPokemonTeamDto(PokemonTeam pokemonTeam, Map<Long, PokemonDTO> pokemonDtoMap) {
        List<PokemonDTO> pokemonDtoList = new ArrayList<>();

        for (Long id : pokemonTeam.getPokemonIdList()) {
            pokemonDtoList.add(pokemonDtoMap.get(id));
        }

        return new PokemonTeamDTO(pokemonTeam.getId(), pokemonTeam.getTeamName(), pokemonTeam.getFormat(),
                pokemonDtoList);
    }
}
