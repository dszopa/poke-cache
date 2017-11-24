package factory;

import data.PokemonTeam;
import dto.PokemonDTO;
import dto.PokemonTeamDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PokemonTeamDtoFactory {

    // TODO: might be able to get rid of this? The preferred method for making a TeamDTO
    // should be by passing a map
    public PokemonTeamDTO createPokemonTeamDto(PokemonTeam pokemonTeam, List<PokemonDTO> pokemonDtoList) {
        return new PokemonTeamDTO.PokemonTeamDTOBuilder()
                .withId(pokemonTeam.getId())
                .withTeamName(pokemonTeam.getTeamName())
                .withFormat(pokemonTeam.getFormat())
                .withPokemonList(pokemonDtoList)
                .build();
    }

    public PokemonTeamDTO createPokemonTeamDto(PokemonTeam pokemonTeam, Map<Long, PokemonDTO> pokemonDtoMap) {
        List<PokemonDTO> pokemonDtoList = new ArrayList<>();

        for (Long id : pokemonTeam.getPokemonIdList()) {
            pokemonDtoList.add(pokemonDtoMap.get(id));
        }

        return new PokemonTeamDTO.PokemonTeamDTOBuilder()
                .withId(pokemonTeam.getId())
                .withTeamName(pokemonTeam.getTeamName())
                .withFormat(pokemonTeam.getFormat())
                .withPokemonList(pokemonDtoList)
                .build();
    }
}
