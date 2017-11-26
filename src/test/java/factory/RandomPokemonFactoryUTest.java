package factory;

import data.RandomPokemon;
import dto.RandomPokemonDTO;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RandomPokemonFactoryUTest {

    private RandomPokemonFactory randomPokemonFactory;

    @Before
    public void setup() throws Exception {
        randomPokemonFactory = new RandomPokemonFactory();
    }

    @Test
    public void createRandomPokemon() throws Exception {
        RandomPokemonDTO randomPokemonDTO = new RandomPokemonDTO.RandomPokemonDTOBuilder()
                .withId(1L)
                .withName("Name")
                .withItem("Item")
                .withAbility("Ability")
                .withLevel(100)
                .withType1("FIRE")
                .withType2("WATER")
                .withHp(100)
                .withAttack(200)
                .withDefence(300)
                .withSpecialAttack(400)
                .withSpecialDefence(500)
                .withSpeed(600)
                .withMove1("Move1")
                .withMove2("Move2")
                .withMove3("Move3")
                .withMove4("Move4")
                .build();

        RandomPokemon randomPokemon = randomPokemonFactory.createRandomPokemon(randomPokemonDTO);

        assertEquals(randomPokemonDTO.getId(), randomPokemon.getId());
        assertEquals(randomPokemonDTO.getName(), randomPokemon.getName());
        assertEquals(randomPokemonDTO.getItem(), randomPokemon.getItem());
        assertEquals(randomPokemonDTO.getAbility(), randomPokemon.getAbility());
        assertEquals(randomPokemonDTO.getLevel(), randomPokemon.getLevel());
        assertEquals(randomPokemonDTO.getType1(), randomPokemon.getType1());
        assertEquals(randomPokemonDTO.getType2(), randomPokemon.getType2());
        assertEquals(randomPokemonDTO.getHp(), randomPokemon.getHp());
        assertEquals(randomPokemonDTO.getAttack(), randomPokemon.getAttack());
        assertEquals(randomPokemonDTO.getDefence(), randomPokemon.getDefence());
        assertEquals(randomPokemonDTO.getSpecialAttack(), randomPokemon.getSpecialAttack());
        assertEquals(randomPokemonDTO.getSpecialDefence(), randomPokemon.getSpecialDefence());
        assertEquals(randomPokemonDTO.getSpeed(), randomPokemon.getSpeed());
        assertEquals(randomPokemonDTO.getMove1(), randomPokemon.getMove1());
        assertEquals(randomPokemonDTO.getMove2(), randomPokemon.getMove2());
        assertEquals(randomPokemonDTO.getMove3(), randomPokemon.getMove3());
        assertEquals(randomPokemonDTO.getMove4(), randomPokemon.getMove4());
    }
}
