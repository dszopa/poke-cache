package factory;

import data.PokemonTeam;
import dto.PokemonDTO;
import dto.PokemonTeamDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class PokemonTeamDtoFactoryUTest {

    private PokemonTeamDtoFactory pokemonTeamDtoFactory;

    @Before
    public void setup() throws Exception {
        pokemonTeamDtoFactory = new PokemonTeamDtoFactory();
    }

    @Test
    public void createPokemonTeamDTOFromPokemonTeamAndPokemonDTOList() throws Exception {
        PokemonTeam pokemonTeam = new PokemonTeam.PokemonTeamBuilder()
                .withId(5L)
                .withTeamName("Super Team")
                .withFormat("OU")
                .withPokemonIdList(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L))
                .build();

        List<PokemonDTO> pokemonDTOList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            pokemonDTOList.add(new PokemonDTO.PokemonDTOBuilder()
                .withId((long) i)
                .build());
        }

        PokemonTeamDTO pokemonTeamDTO = pokemonTeamDtoFactory.createPokemonTeamDto(pokemonTeam, pokemonDTOList);

        assertEquals(pokemonTeam.getId(), pokemonTeamDTO.getId());
        assertEquals(pokemonTeam.getTeamName(), pokemonTeamDTO.getTeamName());
        assertEquals(pokemonTeam.getFormat(), pokemonTeamDTO.getFormat());
        assertEquals(pokemonDTOList, pokemonTeamDTO.getPokemonList());
    }

    @Test
    public void createPokemonTeamDTOFromPokemonTeamAndPokemonDTOMap() throws Exception {
        PokemonTeam pokemonTeam = new PokemonTeam.PokemonTeamBuilder()
                .withId(5L)
                .withTeamName("Super Team")
                .withFormat("OU")
                .withPokemonIdList(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L))
                .build();

        List<PokemonDTO> pokemonDTOList = new ArrayList<>();
        Map<Long, PokemonDTO> pokemonDtoMap = new HashMap<>();
        for (int i = 1; i < 7; i++) {
            PokemonDTO pokemonDTO = new PokemonDTO.PokemonDTOBuilder()
                    .withId((long) i)
                    .build();

            pokemonDTOList.add(pokemonDTO);
            pokemonDtoMap.put((long) i, pokemonDTO);
        }

        PokemonTeamDTO pokemonTeamDTO = pokemonTeamDtoFactory.createPokemonTeamDto(pokemonTeam, pokemonDtoMap);

        assertEquals(pokemonTeam.getId(), pokemonTeamDTO.getId());
        assertEquals(pokemonTeam.getTeamName(), pokemonTeamDTO.getTeamName());
        assertEquals(pokemonTeam.getFormat(), pokemonTeamDTO.getFormat());
        assertEquals(pokemonDTOList, pokemonTeamDTO.getPokemonList());
    }
}
