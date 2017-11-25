package dto;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TextPokemonDTOUTest {

    @Test
    public void textPokemonDTOValid() throws Exception {
        TextPokemonDTO textPokemonDTO = new TextPokemonDTO.TextPokemonDTOBuilder()
                .withText("Some Text")
                .build();

        List<ErrorDTO> errorDtos = textPokemonDTO.validate();

        assertEquals(0, errorDtos.size());
    }

    @Test
    public void textPokemonDTOInvalid() throws Exception {
        TextPokemonDTO textPokemonDTO = new TextPokemonDTO.TextPokemonDTOBuilder().build();

        List<ErrorDTO> errorDtos = textPokemonDTO.validate();

        assertEquals(1, errorDtos.size());
        assertTrue(errorDtos.contains(new ErrorDTO("text", "attribute was not given, text must be provided")));
    }
}
