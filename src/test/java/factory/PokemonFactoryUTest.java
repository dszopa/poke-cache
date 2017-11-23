package factory;

import data.Pokemon;
import dto.PokemonDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PokemonFactoryUTest {

    private PokemonFactory pokemonFactory;

    @Before
    public void setup() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void createPokemonFromPokemonDTO() throws Exception {
        List<String> types = Collections.singletonList("Water");
        List<String> moves = Arrays.asList("Bubble", "Brine", "Peck", "Hydro Pump");

        PokemonDTO pokemonDTO = new PokemonDTO.PokemonDTOBuilder()
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
                .withTypes(types)
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
                .withMoves(moves)
                .build();

        Pokemon pokemon = pokemonFactory.createPokemon(pokemonDTO);
        assertEquals(pokemonDTO.getId(), pokemon.getId());
        assertEquals(pokemonDTO.getName(), pokemon.getName());
        assertEquals(pokemonDTO.getNickname(), pokemon.getNickname());
        assertEquals(pokemonDTO.getItem(), pokemon.getItem());
        assertEquals(pokemonDTO.getAbility(), pokemon.getAbility());
        assertEquals(pokemonDTO.getLevel(), pokemon.getLevel());
        assertEquals(pokemonDTO.getGender(), pokemon.getGender());
        assertEquals(pokemonDTO.getShiny(), pokemon.getShiny());
        assertEquals(pokemonDTO.getNature(), pokemon.getNature());
        assertEquals(pokemonDTO.getHappiness(), pokemon.getHappiness());
        assertEquals(pokemonDTO.getHpEVs(), pokemon.getHpEVs());
        assertEquals(pokemonDTO.getAttackEVs(), pokemon.getAttackEVs());
        assertEquals(pokemonDTO.getDefenceEVs(), pokemon.getDefenceEVs());
        assertEquals(pokemonDTO.getSpecialAttackEVs(), pokemon.getSpecialAttackEVs());
        assertEquals(pokemonDTO.getSpecialDefenceEVs(), pokemon.getSpecialDefenceEVs());
        assertEquals(pokemonDTO.getSpeedEVs(), pokemon.getSpeedEVs());
        assertEquals(pokemonDTO.getHpIVs(), pokemon.getHpIVs());
        assertEquals(pokemonDTO.getAttackIVs(), pokemon.getAttackIVs());
        assertEquals(pokemonDTO.getDefenceIVs(), pokemon.getDefenceIVs());
        assertEquals(pokemonDTO.getSpecialAttackIVs(), pokemon.getSpecialAttackIVs());
        assertEquals(pokemonDTO.getSpecialDefenceIVs(), pokemon.getSpecialDefenceIVs());
        assertEquals(pokemonDTO.getSpeedIVs(), pokemon.getSpeedIVs());
    }
}
