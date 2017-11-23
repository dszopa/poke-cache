package factory;

import data.Pokemon;
import dto.PokemonDTO;
import dto.TextPokemonDTO;
import junit.framework.TestCase;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonDtoFactoryUTest {

    private PokemonDtoFactory pokemonDtoFactory;
    private HttpClientFactory mockHttpClientFactory;

    @Before
    public void setup() {
        mockHttpClientFactory = mock(HttpClientFactory.class);
        pokemonDtoFactory = new PokemonDtoFactory(mockHttpClientFactory);
    }

    @Test
    public void createPokemonDTOFromPokemonTypesAndMoves() throws Exception {
        List<String> types = Collections.singletonList("Water");
        List<String> moves = Arrays.asList("Bubble", "Brine", "Peck", "Hydro Pump");

        Pokemon pokemon = new Pokemon.PokemonBuilder()
                .withId(1L)
                .withName("Piplup")
                .withNickname("Droop")
                .withItem("Toxic Orb")
                .withAbility("Hydration")
                .withLevel(5)
                .withGender("M")
                .withShiny(true)
                .withNature("Brave")
                .withHappiness(255)
                .withHpEVs(4)
                .withAttackEVs(4)
                .withDefenceEVs(4)
                .withSpecialAttackEVs(4)
                .withSpecialDefenceEVs(4)
                .withSpeedEVs(4)
                .withHpIVs(4)
                .withAttackIVs(4)
                .withDefenceIVs(4)
                .withSpecialAttackIVs(4)
                .withSpecialDefenceIVs(4)
                .withSpeedIVs(4)
                .build();

        PokemonDTO pokemonDTO = pokemonDtoFactory.createPokemonDTO(pokemon, types, moves);
        assertEquals(pokemon.getId(), pokemonDTO.getId());
        assertEquals(pokemon.getName(), pokemonDTO.getName());
        assertEquals(pokemon.getNickname(), pokemonDTO.getNickname());
        assertEquals(pokemon.getItem(), pokemonDTO.getItem());
        assertEquals(pokemon.getAbility(), pokemonDTO.getAbility());
        assertEquals(pokemon.getLevel(), pokemonDTO.getLevel());
        assertEquals(pokemon.getGender(), pokemonDTO.getGender());
        assertEquals(pokemon.getShiny(), pokemonDTO.getShiny());
        assertEquals(pokemon.getNature(), pokemonDTO.getNature());
        assertEquals(pokemon.getHappiness(), pokemonDTO.getHappiness());
        assertEquals(pokemon.getHpEVs(), pokemonDTO.getHpEVs());
        assertEquals(pokemon.getAttackEVs(), pokemonDTO.getAttackEVs());
        assertEquals(pokemon.getDefenceEVs(), pokemonDTO.getDefenceEVs());
        assertEquals(pokemon.getSpecialAttackEVs(), pokemonDTO.getSpecialAttackEVs());
        assertEquals(pokemon.getSpecialDefenceEVs(), pokemonDTO.getSpecialDefenceEVs());
        assertEquals(pokemon.getSpeedEVs(), pokemonDTO.getSpeedEVs());
        assertEquals(pokemon.getHpIVs(), pokemonDTO.getHpIVs());
        assertEquals(pokemon.getAttackIVs(), pokemonDTO.getAttackIVs());
        assertEquals(pokemon.getDefenceIVs(), pokemonDTO.getDefenceIVs());
        assertEquals(pokemon.getSpecialAttackIVs(), pokemonDTO.getSpecialAttackIVs());
        assertEquals(pokemon.getSpecialDefenceIVs(), pokemonDTO.getSpecialDefenceIVs());
        assertEquals(pokemon.getSpeedIVs(), pokemonDTO.getSpeedIVs());
        assertEquals(moves, pokemonDTO.getMoves());
        assertEquals(types, pokemonDTO.getTypes());
    }

    @Test
    public void createPokemonDTOFromTextPokemonDTO() throws Exception {
        HttpClient httpClient = mock(HttpClient.class);
        HttpResponse httpResponse = mock(HttpResponse.class);
        HttpEntity stringEntity = new StringEntity(
                "{" +
                        "\"types\": [" +
                        "   {" +
                        "       \"slot\": 2," +
                        "       \"type\": {" +
                        "           \"name\": \"flying\"" +
                        "       }" +
                        "   }," +
                        "   {" +
                        "       \"slot\": 1," +
                        "       \"type\": {" +
                        "           \"name\": \"fighting\"" +
                        "       }" +
                        "   }" +
                        "]" +
                        "}"
        );

        when(mockHttpClientFactory.getHttpClient()).thenReturn(httpClient);
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        when(httpResponse.getEntity()).thenReturn(stringEntity);

        String textPokemon = "()@_#($*@#)$ (Hawlucha) (F) @ Eviolite  \n" +
                "Ability: Limber  \n" +
                "Level: 95  \n" +
                "Shiny: Yes  \n" +
                "Happiness: 251  \n" +
                "EVs: 12 HP / 8 Atk / 8 Def / 28 SpA / 8 SpD / 16 Spe   \n" +
                "Modest Nature  \n" +
                "IVs: 12 HP / 1 Atk / 29 Def / 6 SpA / 2 SpD / 5 Spe  \n" +
                "- Baton Pass  \n" +
                "- Agility  \n" +
                "- Focus Blast  \n" +
                "- Hidden Power [Ground]    ";

        PokemonDTO pokemonDTO = pokemonDtoFactory.createPokemonDTO(new TextPokemonDTO.TextPokemonDTOBuilder()
                .withText(textPokemon)
                .build());

        TestCase.assertEquals("()@_#($*@#)$", pokemonDTO.getNickname());
        TestCase.assertEquals("Hawlucha", pokemonDTO.getName());
        TestCase.assertEquals("F", pokemonDTO.getGender());
        TestCase.assertEquals("Eviolite", pokemonDTO.getItem());
        TestCase.assertEquals("Limber", pokemonDTO.getAbility());
        TestCase.assertEquals(Integer.valueOf(95), pokemonDTO.getLevel());
        assertTrue(pokemonDTO.getShiny());
        TestCase.assertEquals(Integer.valueOf(251), pokemonDTO.getHappiness());
        TestCase.assertEquals(Integer.valueOf(12), pokemonDTO.getHpEVs());
        TestCase.assertEquals(Integer.valueOf(8), pokemonDTO.getAttackEVs());
        TestCase.assertEquals(Integer.valueOf(8), pokemonDTO.getDefenceEVs());
        TestCase.assertEquals(Integer.valueOf(28), pokemonDTO.getSpecialAttackEVs());
        TestCase.assertEquals(Integer.valueOf(8), pokemonDTO.getSpecialDefenceEVs());
        TestCase.assertEquals(Integer.valueOf(16), pokemonDTO.getSpeedEVs());
        TestCase.assertEquals("Modest", pokemonDTO.getNature());
        TestCase.assertEquals(Integer.valueOf(12), pokemonDTO.getHpIVs());
        TestCase.assertEquals(Integer.valueOf(1), pokemonDTO.getAttackIVs());
        TestCase.assertEquals(Integer.valueOf(29), pokemonDTO.getDefenceIVs());
        TestCase.assertEquals(Integer.valueOf(6), pokemonDTO.getSpecialAttackIVs());
        TestCase.assertEquals(Integer.valueOf(2), pokemonDTO.getSpecialDefenceIVs());
        TestCase.assertEquals(Integer.valueOf(5), pokemonDTO.getSpeedIVs());
        assertEquals("Baton Pass", pokemonDTO.getMoves().get(0));
        assertEquals("Agility", pokemonDTO.getMoves().get(1));
        assertEquals("Focus Blast", pokemonDTO.getMoves().get(2));
        assertEquals("Hidden Power [Ground]", pokemonDTO.getMoves().get(3));
        assertEquals("FIGHTING", pokemonDTO.getTypes().get(0));
        assertEquals("FLYING", pokemonDTO.getTypes().get(1));
    }
}
