package data;

import java.io.Serializable;
import java.util.List;

public class PokemonTeam implements Serializable {

    private static Long serialVersionUID = 1L;

    private Long id;
    private String teamName;
    private String format;
    private List<Long> pokemonIdList; // Max size 6

    public PokemonTeam(String teamName, String format, List<Long> pokemonIdList) {
        this.teamName = teamName;
        this.format = format;
        this.pokemonIdList = pokemonIdList;
    }

    public PokemonTeam(Long id, String teamName, String format, List<Long> pokemonIdList) {
        this.id = id;
        this.teamName = teamName;
        this.format = format;
        this.pokemonIdList = pokemonIdList;
    }

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
}
