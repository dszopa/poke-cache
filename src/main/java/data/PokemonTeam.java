package data;

import java.util.List;

public class PokemonTeam {

    private Long id;
    private String teamName;
    private String format;

    // Max size 6
    private List<Pokemon> pokemonList;

    public PokemonTeam(String teamName, String format, List<Pokemon> pokemonList) {
        this.teamName = teamName;
        this.format = format;
        this.pokemonList = pokemonList;
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

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
