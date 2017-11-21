package data;

import java.io.Serializable;
import java.util.List;

public class PokemonTeam implements Serializable {

    private static Long serialVersionUID = 1L;

    private Long id;
    private String teamName;
    private String format;
    private List<Long> pokemonIdList; // Max size 6

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<Long> getPokemonIdList() {
        return pokemonIdList;
    }

    public void setPokemonIdList(List<Long> pokemonIdList) {
        this.pokemonIdList = pokemonIdList;
    }

    @Override
    public String toString() {
        return "PokemonTeam{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", format='" + format + '\'' +
                ", pokemonIdList=" + pokemonIdList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonTeam that = (PokemonTeam) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (teamName != null ? !teamName.equals(that.teamName) : that.teamName != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        return pokemonIdList != null ? pokemonIdList.equals(that.pokemonIdList) : that.pokemonIdList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (pokemonIdList != null ? pokemonIdList.hashCode() : 0);
        return result;
    }

    public static final class PokemonTeamBuilder {
        private Long id;
        private String teamName;
        private String format;
        private List<Long> pokemonIdList; // Max size 6

        public PokemonTeamBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PokemonTeamBuilder withTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public PokemonTeamBuilder withFormat(String format) {
            this.format = format;
            return this;
        }

        public PokemonTeamBuilder withPokemonIdList(List<Long> pokemonIdList) {
            this.pokemonIdList = pokemonIdList;
            return this;
        }

        public PokemonTeam build() {
            PokemonTeam pokemonTeam = new PokemonTeam();
            pokemonTeam.setId(id);
            pokemonTeam.setTeamName(teamName);
            pokemonTeam.setFormat(format);
            pokemonTeam.setPokemonIdList(pokemonIdList);
            return pokemonTeam;
        }
    }
}
