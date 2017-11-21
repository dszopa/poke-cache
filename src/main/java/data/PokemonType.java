package data;

import java.io.Serializable;

public class PokemonType implements Serializable {

    private static Long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Integer slot;
    private Long pokemonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
    }


    public static final class PokemonTypeBuilder {
        private Long id;
        private String name;
        private Integer slot;
        private Long pokemonId;

        public PokemonTypeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PokemonTypeBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PokemonTypeBuilder withSlot(Integer slot) {
            this.slot = slot;
            return this;
        }

        public PokemonTypeBuilder withPokemonId(Long pokemonId) {
            this.pokemonId = pokemonId;
            return this;
        }

        public PokemonType build() {
            PokemonType pokemonType = new PokemonType();
            pokemonType.setId(id);
            pokemonType.setName(name);
            pokemonType.setSlot(slot);
            pokemonType.setPokemonId(pokemonId);
            return pokemonType;
        }
    }
}
