package dto;

import java.util.ArrayList;
import java.util.List;

public class TextPokemonDTO {

    private Long id;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ErrorDTO> validate() {
        List<ErrorDTO> errors = new ArrayList<>();

        if (text == null) {
            errors.add(new ErrorDTO("text", "attribute was not given, text must be provided"));
        }

        return errors;
    }


    public static final class TextPokemonDTOBuilder {
        private Long id;
        private String text;

        public TextPokemonDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TextPokemonDTOBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public TextPokemonDTO build() {
            TextPokemonDTO textPokemonDTO = new TextPokemonDTO();
            textPokemonDTO.setId(id);
            textPokemonDTO.setText(text);
            return textPokemonDTO;
        }
    }
}
