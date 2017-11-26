package dto;

import org.junit.Test;

import java.util.List;

import static dto.RandomPokemonDTO.invalidType;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class RandomPokemonDTOUTest {

    @Test
    public void randomPokemonDTOValid() throws Exception {
        RandomPokemonDTO randomPokemonDTO = new RandomPokemonDTO.RandomPokemonDTOBuilder()
                .withName("Piplup")
                .withItem("Mystic Water")
                .withAbility("Torrent")
                .withLevel(100)
                .withType1("WATER")
                .withHp(100)
                .withAttack(100)
                .withDefence(100)
                .withSpecialAttack(200)
                .withSpecialDefence(300)
                .withSpeed(200)
                .withMove1("Bubble")
                .withMove2("Hydro Pump")
                .withMove3("Brine")
                .withMove4("Peck")
                .build();

        List<ErrorDTO> errors = randomPokemonDTO.validate();

        assertEquals(0, errors.size());
    }

    @Test
    public void randomPokemonDTODefaultConstructor() throws Exception {
        RandomPokemonDTO randomPokemonDTO = new RandomPokemonDTO.RandomPokemonDTOBuilder().build();

        List<ErrorDTO> errors = randomPokemonDTO.validate();

        assertEquals(14, errors.size());
        assertTrue(errors.contains(new ErrorDTO("name", "attribute was not given, name must be provided")));
        assertTrue(errors.contains(new ErrorDTO("item", "attribute was not given, item must be provided")));
        assertTrue(errors.contains(new ErrorDTO("ability", "attribute was not given, ability must be provided")));
        assertTrue(errors.contains(new ErrorDTO("level", "level must be a number between 1 and 100")));
        assertTrue(errors.contains(new ErrorDTO("hp", "hp must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("attack", "attack must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("defence", "defence must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("specialAttack", "specialAttack must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("specialDefence", "specialDefence must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("speed", "speed must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("move1", "attribute not given, move1 must be provided")));
        assertTrue(errors.contains(new ErrorDTO("move2", "attribute not given, move2 must be provided")));
        assertTrue(errors.contains(new ErrorDTO("move3", "attribute not given, move3 must be provided")));
        assertTrue(errors.contains(new ErrorDTO("move4", "attribute not given, move4 must be provided")));
    }

    @Test
    public void randomPokemonDTONullValues() throws Exception {
        RandomPokemonDTO randomPokemonDTO = new RandomPokemonDTO.RandomPokemonDTOBuilder()
                .withId(null)
                .withName(null)
                .withItem(null)
                .withAbility(null)
                .withLevel(null)
                .withType1(null)
                .withType2(null)
                .withHp(null)
                .withAttack(null)
                .withDefence(null)
                .withSpecialAttack(null)
                .withSpecialDefence(null)
                .withSpeed(null)
                .withMove1(null)
                .withMove2(null)
                .withMove3(null)
                .withMove4(null)
                .build();

        List<ErrorDTO> errors = randomPokemonDTO.validate();

        assertEquals(14, errors.size());
        assertTrue(errors.contains(new ErrorDTO("name", "attribute was not given, name must be provided")));
        assertTrue(errors.contains(new ErrorDTO("item", "attribute was not given, item must be provided")));
        assertTrue(errors.contains(new ErrorDTO("ability", "attribute was not given, ability must be provided")));
        assertTrue(errors.contains(new ErrorDTO("level", "level must be a number between 1 and 100")));
        assertTrue(errors.contains(new ErrorDTO("hp", "hp must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("attack", "attack must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("defence", "defence must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("specialAttack", "specialAttack must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("specialDefence", "specialDefence must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("speed", "speed must be a number greater than 0")));
        assertTrue(errors.contains(new ErrorDTO("move1", "attribute not given, move1 must be provided")));
        assertTrue(errors.contains(new ErrorDTO("move2", "attribute not given, move2 must be provided")));
        assertTrue(errors.contains(new ErrorDTO("move3", "attribute not given, move3 must be provided")));
        assertTrue(errors.contains(new ErrorDTO("move4", "attribute not given, move4 must be provided")));
    }

    @Test
    public void randomPokemonDTOInvalidTypes() throws Exception {
        RandomPokemonDTO randomPokemonDTO = new RandomPokemonDTO.RandomPokemonDTOBuilder()
                .withType1("typeowipo")
                .withType2("walko")
                .build();

        List<ErrorDTO> errors = randomPokemonDTO.validate();

        assertEquals(16, errors.size());
        assertTrue(errors.contains(new ErrorDTO("type1", invalidType)));
        assertTrue(errors.contains(new ErrorDTO("type2", invalidType)));
    }
}
