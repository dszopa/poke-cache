package factory;

import data.PokemonTeam;
import dto.PokemonDTO;
import dto.PokemonTeamDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PokemonTeamFactoryUTest {

    private PokemonTeamFactory pokemonTeamFactory;

    @Before
    public void setup() throws Exception {
        pokemonTeamFactory = new PokemonTeamFactory();
    }

    @Test
    public void createPokemonTeam() throws Exception {
        List<Long> idList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
        List<PokemonDTO> pokemonDTOList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            pokemonDTOList.add(new PokemonDTO.PokemonDTOBuilder()
                    .withId((long) i)
                    .build());
        }

        PokemonTeamDTO pokemonTeamDTO = new PokemonTeamDTO.PokemonTeamDTOBuilder()
                .withId(5L)
                .withTeamName("Super Duper Team")
                .withFormat("UU")
                .withPokemonList(pokemonDTOList)
                .build();

        PokemonTeam pokemonTeam = pokemonTeamFactory.createPokemonTeam(pokemonTeamDTO);

        assertEquals(pokemonTeamDTO.getId(), pokemonTeam.getId());
        assertEquals(pokemonTeamDTO.getTeamName(), pokemonTeam.getTeamName());
        assertEquals(pokemonTeamDTO.getFormat(), pokemonTeam.getFormat());
        assertEquals(idList, pokemonTeam.getPokemonIdList());
    }
}
