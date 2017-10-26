package dto;

import java.util.List;

public class PokemonTeamDTO {

    private Long id;
    private String teamName;
    private String format;
    private List<PokemonDTO> pokemonList; // Max size 6

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

    public static final class PokemonTeamDTOBuilder {
        private Long id;
        private String teamName;
        private String format;
        private List<PokemonDTO> pokemonList; // Max size 6

        public PokemonTeamDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PokemonTeamDTOBuilder withTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public PokemonTeamDTOBuilder withFormat(String format) {
            this.format = format;
            return this;
        }

        public PokemonTeamDTOBuilder withPokemonList(List<PokemonDTO> pokemonList) {
            this.pokemonList = pokemonList;
            return this;
        }

        public PokemonTeamDTO build() {
            PokemonTeamDTO pokemonTeamDTO = new PokemonTeamDTO();
            pokemonTeamDTO.setId(id);
            pokemonTeamDTO.setTeamName(teamName);
            pokemonTeamDTO.setFormat(format);
            pokemonTeamDTO.setPokemonList(pokemonList);
            return pokemonTeamDTO;
        }
    }
}
