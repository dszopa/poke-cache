package factory;

import data.RandomPokemon;
import dto.RandomPokemonDTO;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RandomPokemonDtoFactoryUTest {

    private RandomPokemonDtoFactory randomPokemonDtoFactory;

    @Before
    public void setup() throws Exception {
        randomPokemonDtoFactory = new RandomPokemonDtoFactory();
    }

    @Test
    public void createRandomPokemonDTO() throws Exception {
        RandomPokemon randomPokemon = new RandomPokemon.RandomPokemonBuilder()
                .withId(1L)
                .withName("Name")
                .withNickname("Nickname")
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

        RandomPokemonDTO randomPokemonDTO = randomPokemonDtoFactory.createRandomPokemonDTO(randomPokemon);

        assertEquals(randomPokemon.getId(), randomPokemonDTO.getId());
        assertEquals(randomPokemon.getName(), randomPokemonDTO.getName());
        assertEquals(randomPokemon.getNickname(), randomPokemonDTO.getNickname());
        assertEquals(randomPokemon.getItem(), randomPokemonDTO.getItem());
        assertEquals(randomPokemon.getAbility(), randomPokemonDTO.getAbility());
        assertEquals(randomPokemon.getLevel(), randomPokemonDTO.getLevel());
        assertEquals(randomPokemon.getType1(), randomPokemonDTO.getType1());
        assertEquals(randomPokemon.getType2(), randomPokemonDTO.getType2());
        assertEquals(randomPokemon.getHp(), randomPokemonDTO.getHp());
        assertEquals(randomPokemon.getAttack(), randomPokemonDTO.getAttack());
        assertEquals(randomPokemon.getDefence(), randomPokemonDTO.getDefence());
        assertEquals(randomPokemon.getSpecialAttack(), randomPokemonDTO.getSpecialAttack());
        assertEquals(randomPokemon.getSpecialDefence(), randomPokemonDTO.getSpecialDefence());
        assertEquals(randomPokemon.getSpeed(), randomPokemonDTO.getSpeed());
        assertEquals(randomPokemon.getMove1(), randomPokemonDTO.getMove1());
        assertEquals(randomPokemon.getMove2(), randomPokemonDTO.getMove2());
        assertEquals(randomPokemon.getMove3(), randomPokemonDTO.getMove3());
        assertEquals(randomPokemon.getMove4(), randomPokemonDTO.getMove4());
    }
}
