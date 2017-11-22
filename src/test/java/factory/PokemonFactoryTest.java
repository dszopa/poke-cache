// TODO: fix
//package factory;
//
//import data.Pokemon;
//import dto.PokemonDTO;
//import dto.TextPokemonDTO;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.entity.StringEntity;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class PokemonFactoryTest {
//
//    private PokemonFactory pokemonFactory;
//    private HttpClientFactory httpClientFactory;
//
//    @Before
//    public void setup() {
//        httpClientFactory = mock(HttpClientFactory.class);
//        pokemonFactory = new PokemonFactory(httpClientFactory);
//    }
//
//    @Test
//    public void createPokemonFromPokemonDTO() throws Exception {
//        List<String> types = Collections.singletonList("Water");
//        List<String> moves = Arrays.asList("Bubble", "Brine", "Peck", "Hydro Pump");
//
//        PokemonDTO pokemonDTO = new PokemonDTO.PokemonDTOBuilder()
//                .withId(1L)
//                .withName("Piplup")
//                .withNickname("Droop")
//                .withItem("Toxic Orb")
//                .withAbility("Hydration")
//                .withLevel(5)
//                .withGender("M")
//                .withShiny(true)
//                .withNature("Brave")
//                .withHappiness(255)
//                .withTypes(types)
//                .withHpEVs(4)
//                .withAttackEVs(4)
//                .withDefenceEVs(4)
//                .withSpecialAttackEVs(4)
//                .withSpecialDefenceEVs(4)
//                .withSpeedEVs(4)
//                .withHpIVs(4)
//                .withAttackIVs(4)
//                .withDefenceIVs(4)
//                .withSpecialAttackIVs(4)
//                .withSpecialDefenceIVs(4)
//                .withSpeedIVs(4)
//                .withMoves(moves)
//                .build();
//
//        Pokemon pokemon = pokemonFactory.createPokemon(pokemonDTO);
//        assertEquals(pokemonDTO.getId(), pokemon.getId());
//        assertEquals(pokemonDTO.getName(), pokemon.getName());
//        assertEquals(pokemonDTO.getNickname(), pokemon.getNickname());
//        assertEquals(pokemonDTO.getItem(), pokemon.getItem());
//        assertEquals(pokemonDTO.getAbility(), pokemon.getAbility());
//        assertEquals(pokemonDTO.getLevel(), pokemon.getLevel());
//        assertEquals(pokemonDTO.getGender(), pokemon.getGender());
//        assertEquals(pokemonDTO.getShiny(), pokemon.getShiny());
//        assertEquals(pokemonDTO.getNature(), pokemon.getNature());
//        assertEquals(pokemonDTO.getHappiness(), pokemon.getHappiness());
//        assertEquals(pokemonDTO.getHpEVs(), pokemon.getHpEVs());
//        assertEquals(pokemonDTO.getAttackEVs(), pokemon.getAttackEVs());
//        assertEquals(pokemonDTO.getDefenceEVs(), pokemon.getDefenceEVs());
//        assertEquals(pokemonDTO.getSpecialAttackEVs(), pokemon.getSpecialAttackEVs());
//        assertEquals(pokemonDTO.getSpecialDefenceEVs(), pokemon.getSpecialDefenceEVs());
//        assertEquals(pokemonDTO.getSpeedEVs(), pokemon.getSpeedEVs());
//        assertEquals(pokemonDTO.getHpIVs(), pokemon.getHpIVs());
//        assertEquals(pokemonDTO.getAttackIVs(), pokemon.getAttackIVs());
//        assertEquals(pokemonDTO.getDefenceIVs(), pokemon.getDefenceIVs());
//        assertEquals(pokemonDTO.getSpecialAttackIVs(), pokemon.getSpecialAttackIVs());
//        assertEquals(pokemonDTO.getSpecialDefenceIVs(), pokemon.getSpecialDefenceIVs());
//        assertEquals(pokemonDTO.getSpeedIVs(), pokemon.getSpeedIVs());
//        assertEquals(pokemonDTO.getMoves(), pokemon.getMoves());
//
//
//    }
//
//    @Test
//    public void testCreatePokemonFromText() throws Exception {
//
//        HttpClient httpClient = mock(HttpClient.class);
//        HttpResponse httpResponse = mock(HttpResponse.class);
//        HttpEntity stringEntity = new StringEntity(
//                        "{" +
//                            "\"types\": [" +
//                                "{" +
//                                    "\"slot\" : 2," +
//                                    "\"type\": {" +
//                                        "\"name\": \"flying\" " +
//                                    "}" +
//                                "}," +
//                                "{" +
//                                    "\"slot\": 1," +
//                                    "\"type\": {" +
//                                        "\"name\": \"fighting\"" +
//                                    "}" +
//                                "}" +
//                            "]" +
//                        "}");
//
//        when(httpClientFactory.getHttpClient()).thenReturn(httpClient);
//        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
//        when(httpResponse.getEntity()).thenReturn(stringEntity);
//
//        String textPokemon = "()@_#($*@#)$ (Hawlucha) (F) @ Eviolite  \n" +
//                "Ability: Limber  \n" +
//                "Level: 95  \n" +
//                "Shiny: Yes  \n" +
//                "Happiness: 251  \n" +
//                "EVs: 12 HP / 8 Atk / 8 Def / 28 SpA / 8 SpD / 16 Spe   \n" +
//                "Modest Nature  \n" +
//                "IVs: 12 HP / 1 Atk / 29 Def / 6 SpA / 2 SpD / 5 Spe  \n" +
//                "- Baton Pass  \n" +
//                "- Agility  \n" +
//                "- Focus Blast  \n" +
//                "- Hidden Power [Ground]    ";
//
//        Pokemon pokemon = pokemonFactory.createPokemon(new TextPokemonDTO.TextPokemonDTOBuilder()
//                .withText(textPokemon)
//                .build());
//
//        assertEquals("()@_#($*@#)$", pokemon.getNickname());
//        assertEquals("Hawlucha", pokemon.getName());
//        assertEquals("F", pokemon.getGender());
//        assertEquals("Eviolite", pokemon.getItem());
//        assertEquals("Limber", pokemon.getAbility());
//        assertEquals(Integer.valueOf(95), pokemon.getLevel());
//        assertTrue(pokemon.getShiny());
//        assertEquals(Integer.valueOf(251), pokemon.getHappiness());
//        assertEquals(Integer.valueOf(12), pokemon.getHpEVs());
//        assertEquals(Integer.valueOf(8), pokemon.getAttackEVs());
//        assertEquals(Integer.valueOf(8), pokemon.getDefenceEVs());
//        assertEquals(Integer.valueOf(28), pokemon.getSpecialAttackEVs());
//        assertEquals(Integer.valueOf(8), pokemon.getSpecialDefenceEVs());
//        assertEquals(Integer.valueOf(16), pokemon.getSpeedEVs());
//        assertEquals("Modest", pokemon.getNature());
//        assertEquals(Integer.valueOf(12), pokemon.getHpIVs());
//        assertEquals(Integer.valueOf(1), pokemon.getAttackIVs());
//        assertEquals(Integer.valueOf(29), pokemon.getDefenceIVs());
//        assertEquals(Integer.valueOf(6), pokemon.getSpecialAttackIVs());
//        assertEquals(Integer.valueOf(2), pokemon.getSpecialDefenceIVs());
//        assertEquals(Integer.valueOf(5), pokemon.getSpeedIVs());
//        assertEquals("Baton Pass", pokemon.getMoves().get(0));
//        assertEquals("Agility", pokemon.getMoves().get(1));
//        assertEquals("Focus Blast", pokemon.getMoves().get(2));
//        assertEquals("Hidden Power [Ground]", pokemon.getMoves().get(3));
//        assertEquals("FIGHTING", pokemon.getTypes().get(0));
//        assertEquals("FLYING", pokemon.getTypes().get(1));
//    }
//
//}
