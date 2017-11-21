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
