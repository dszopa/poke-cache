package data;

import java.io.Serializable;

public class PokemonMove implements Serializable {

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

    @Override
    public String toString() {
        return "PokemonMove{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slot=" + slot +
                ", pokemonId=" + pokemonId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonMove that = (PokemonMove) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (slot != null ? !slot.equals(that.slot) : that.slot != null) return false;
        return pokemonId != null ? pokemonId.equals(that.pokemonId) : that.pokemonId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (slot != null ? slot.hashCode() : 0);
        result = 31 * result + (pokemonId != null ? pokemonId.hashCode() : 0);
        return result;
    }

    public static final class PokemonMoveBuilder {
        private Long id;
        private String name;
        private Integer slot;
        private Long pokemonId;

        public PokemonMoveBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PokemonMoveBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PokemonMoveBuilder withSlot(Integer slot) {
            this.slot = slot;
            return this;
        }

        public PokemonMoveBuilder withPokemonId(Long pokemonId) {
            this.pokemonId = pokemonId;
            return this;
        }

        public PokemonMove build() {
            PokemonMove pokemonMove = new PokemonMove();
            pokemonMove.setId(id);
            pokemonMove.setName(name);
            pokemonMove.setSlot(slot);
            pokemonMove.setPokemonId(pokemonId);
            return pokemonMove;
        }
    }
}
