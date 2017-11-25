package dto;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static dto.PokemonTeamDTO.invalidFormat;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PokemonTeamDTOUTest {

    @Test
    public void pokemonTeamDTODefaultConstructor() throws Exception {
        PokemonTeamDTO pokemonTeamDTO = new PokemonTeamDTO.PokemonTeamDTOBuilder().build();

        List<ErrorDTO> errors = pokemonTeamDTO.validate();

        assertEquals(2, errors.size());
        assertTrue(errors.contains(new ErrorDTO("teamName", "attribute was not given, teamName must be provided")));
        assertTrue(errors.contains(new ErrorDTO("format", "attribute was not given, format must be provided")));
    }

    @Test
    public void pokemonTeamDTOValid() throws Exception {
        PokemonTeamDTO pokemonTeamDTO = new PokemonTeamDTO.PokemonTeamDTOBuilder()
                .withTeamName("teamName")
                .withFormat("OU")
                .build();

        List<ErrorDTO> errors = pokemonTeamDTO.validate();

        assertEquals(0,  errors.size());
    }

    @Test
    public void pokemonTeamDTOInvalidFormat() throws Exception {
        PokemonTeamDTO pokemonTeamDTO = new PokemonTeamDTO.PokemonTeamDTOBuilder()
                .withFormat("LOL")
                .build();

        List<ErrorDTO> errors = pokemonTeamDTO.validate();

        assertEquals(2, errors.size());
        assertTrue(errors.contains(new ErrorDTO("teamName", "attribute was not given, teamName must be provided")));
        assertTrue(errors.contains(new ErrorDTO("format", invalidFormat)));
    }

    @Test
    public void pokemonTeamDTONullPokemonList() throws Exception {
        PokemonTeamDTO pokemonTeamDTO = new PokemonTeamDTO.PokemonTeamDTOBuilder()
                .withPokemonList(null)
                .build();

        List<ErrorDTO> errors = pokemonTeamDTO.validate();

        assertEquals(3, errors.size());
        assertTrue(errors.contains(new ErrorDTO("teamName", "attribute was not given, teamName must be provided")));
        assertTrue(errors.contains(new ErrorDTO("format", "attribute was not given, format must be provided")));
        assertTrue(errors.contains(new ErrorDTO("pokemonList", "attribute was not given, pokemonList must be provided")));
    }

    @Test
    public void pokemonTeamDTOInvalidPokemon() throws Exception {
        PokemonTeamDTO pokemonTeamDTO = new PokemonTeamDTO.PokemonTeamDTOBuilder()
                .withPokemonList(Collections.singletonList(new PokemonDTO.PokemonDTOBuilder().build()))
                .build();

        List<ErrorDTO> errors = pokemonTeamDTO.validate();

        assertEquals(4, errors.size());
        assertTrue(errors.contains(new ErrorDTO("teamName", "attribute was not given, teamName must be provided")));
        assertTrue(errors.contains(new ErrorDTO("format", "attribute was not given, format must be provided")));
        assertTrue(errors.contains(new ErrorDTO("pokemon1.name", "attribute was not given, name must be provided")));
        assertTrue(errors.contains(new ErrorDTO("pokemon1.ability", "attribute was not given, ability must be provided")));
    }

    @Test
    public void pokemonTeamDTOTooManyPokemon() throws Exception {
        PokemonDTO pokemonDTO = new PokemonDTO.PokemonDTOBuilder().build();
        PokemonTeamDTO pokemonTeamDTO = new PokemonTeamDTO.PokemonTeamDTOBuilder()
                .withPokemonList(Arrays.asList(pokemonDTO, pokemonDTO, pokemonDTO, pokemonDTO, pokemonDTO, pokemonDTO,
                        pokemonDTO))
                .build();

        List<ErrorDTO> errors = pokemonTeamDTO.validate();

        assertTrue(errors.contains(new ErrorDTO("pokemonList", "a PokemonTeam's pokemonList cannot contain" +
                "more than 6 pokemon")));
    }
}
