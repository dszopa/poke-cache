package dto;

import java.util.List;

public class PokemonTeamDTO {

    private Long id;
    private String teamName;
    private String format;
    private List<PokemonDTO> pokemonList; // Max size 6

    public PokemonTeamDTO() {}

    public PokemonTeamDTO(String teamName, String format, List<PokemonDTO> pokemonList) {
        this.teamName = teamName;
        this.format = format;
        this.pokemonList = pokemonList;
    }

    public PokemonTeamDTO(Long id, String teamName, String format, List<PokemonDTO> pokemonList) {
        this.id = id;
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

    public List<PokemonDTO> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<PokemonDTO> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
