package dto;

import java.util.ArrayList;
import java.util.List;

public class TextPokemonDTO {

    private Long id;
    private String text;

    public List<ErrorDTO> validate() {
        List<ErrorDTO> errors = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            errors.add(new ErrorDTO("text", "attribute was not given, text must be provided"));
        }

        return errors;
    }

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

    @Override
    public String toString() {
        return "TextPokemonDTO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextPokemonDTO that = (TextPokemonDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return text != null ? text.equals(that.text) : that.text == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
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
