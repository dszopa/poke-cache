package dto;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static dto.PokemonDTO.invalidGender;
import static dto.PokemonDTO.invalidNature;
import static dto.PokemonDTO.invalidType;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PokemonDTOUTest {

    @Test
    public void pokemonDTODefaultConstructor() throws Exception {
        PokemonDTO pokemonDTO = new PokemonDTO();

        List<ErrorDTO> errors = pokemonDTO.validate();

        assertEquals(2, errors.size());
        assertTrue(errors.contains(new ErrorDTO("name", "attribute was not given, name must be provided")));
        assertTrue(errors.contains(new ErrorDTO("ability", "attribute was not given, ability must be provided")));
    }

    @Test
    public void pokemonDTOAllNullValues() throws Exception {
        PokemonDTO pokemonDTO = new PokemonDTO.PokemonDTOBuilder()
                .withId(null)
                .withName(null)
                .withNickname(null)
                .withItem(null)
                .withAbility(null)
                .withLevel(null)
                .withGender(null)
                .withShiny(null)
                .withNature(null)
                .withHappiness(null)
                .withTypes(null)
                .withMoves(null)
                .withHpEVs(null)
                .withAttackEVs(null)
                .withDefenceEVs(null)
                .withSpecialAttackEVs(null)
                .withSpecialDefenceEVs(null)
                .withSpeedEVs(null)
                .withHpIVs(null)
                .withAttackIVs(null)
                .withDefenceIVs(null)
                .withSpecialAttackIVs(null)
                .withSpecialDefenceIVs(null)
                .withSpeedIVs(null)
                .build();

        List<ErrorDTO> errors = pokemonDTO.validate();

        assertEquals(21, errors.size());
        assertTrue(errors.contains(new ErrorDTO("name", "attribute was not given, name must be provided")));
        assertTrue(errors.contains(new ErrorDTO("ability", "attribute was not given, ability must be provided")));
        assertTrue(errors.contains(new ErrorDTO("level", "level must be a number between 1 and 100")));
        assertTrue(errors.contains(new ErrorDTO("gender", invalidGender)));
        assertTrue(errors.contains(new ErrorDTO("shiny", "shiny must be TRUE or FALSE")));
        assertTrue(errors.contains(new ErrorDTO("nature", invalidNature)));
        assertTrue(errors.contains(new ErrorDTO("happiness", "happiness must be a number between 0 and 255")));
        assertTrue(errors.contains(new ErrorDTO("types", "types must not be null, please provide a list of types")));
        assertTrue(errors.contains(new ErrorDTO("moves", "moves must not be null, please provide a list of moves")));
        assertTrue(errors.contains(new ErrorDTO("hpEVs", "hpEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("attackEVs", "attackEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("defenceEVs", "defenceEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("specialAttackEVs", "specialAttackEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("specialDefenceEVs", "specialDefenceEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("speedEVs", "speedEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("hpIVs", "hpIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("attackIVs", "attackIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("defenceIVs", "defenceIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("specialAttackIVs", "specialAttackIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("specialDefenceIVs", "specialDefenceIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("speedIVs", "speedIVs must be a number between 0 and 31")));
    }

    @Test
    public void pokemonDTOInvalidEnumValues() throws Exception {
        PokemonDTO pokemonDTO = new PokemonDTO.PokemonDTOBuilder()
                .withGender("LOL")
                .withNature("LOL")
                .withTypes(Collections.singletonList("LOL"))
                .build();

        List<ErrorDTO> errors = pokemonDTO.validate();

        assertEquals(5, errors.size());
        assertTrue(errors.contains(new ErrorDTO("name", "attribute was not given, name must be provided")));
        assertTrue(errors.contains(new ErrorDTO("ability", "attribute was not given, ability must be provided")));
        assertTrue(errors.contains(new ErrorDTO("gender", invalidGender)));
        assertTrue(errors.contains(new ErrorDTO("nature", invalidNature)));
        assertTrue(errors.contains(new ErrorDTO("type1", invalidType)));
    }

    @Test
    public void pokemonDTOInvalidNonNullValues() throws Exception {
        PokemonDTO pokemonDTO = new PokemonDTO.PokemonDTOBuilder()
                .withName("Name")
                .withAbility("Ability")
                .withLevel(101)
                .withHappiness(-1)
                .withHpEVs(-1)
                .withAttackEVs(-1)
                .withDefenceEVs(-1)
                .withSpecialAttackEVs(-1)
                .withSpecialDefenceEVs(-1)
                .withSpeedEVs(-1)
                .withHpIVs(-1)
                .withAttackIVs(-1)
                .withDefenceIVs(-1)
                .withSpecialAttackIVs(-1)
                .withSpecialDefenceIVs(-1)
                .withSpeedIVs(-1)
                .build();

        List<ErrorDTO> errors = pokemonDTO.validate();

        assertEquals(14, errors.size());
        assertTrue(errors.contains(new ErrorDTO("level", "level must be a number between 1 and 100")));
        assertTrue(errors.contains(new ErrorDTO("happiness", "happiness must be a number between 0 and 255")));
        assertTrue(errors.contains(new ErrorDTO("hpEVs", "hpEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("attackEVs", "attackEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("defenceEVs", "defenceEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("specialAttackEVs", "specialAttackEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("specialDefenceEVs", "specialDefenceEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("speedEVs", "speedEVs must be a number between 0 and 252")));
        assertTrue(errors.contains(new ErrorDTO("hpIVs", "hpIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("attackIVs", "attackIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("defenceIVs", "defenceIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("specialAttackIVs", "specialAttackIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("specialDefenceIVs", "specialDefenceIVs must be a number between 0 and 31")));
        assertTrue(errors.contains(new ErrorDTO("speedIVs", "speedIVs must be a number between 0 and 31")));
    }
}
