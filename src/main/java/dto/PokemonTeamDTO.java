package dto;

import constant.Format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonTeamDTO {

    static final String invalidFormat = "Not a valid format, valid formats are: " + Arrays.toString(Format.values());

    private Long id;
    private String teamName;
    private String format;
    private List<PokemonDTO> pokemonList = new ArrayList<>(); // Max size 6

    public List<ErrorDTO> validate() {
        List<ErrorDTO> errors = new ArrayList<>();

        if (teamName == null || teamName.isEmpty()) {
            errors.add(new ErrorDTO("teamName", "attribute was not given, teamName must be provided"));
        }

        if (format == null) {
            errors.add(new ErrorDTO("format", "attribute was not given, format must be provided"));
        }

        if (format != null) {
            try {
                Format.valueOf(format.toUpperCase().replace(" ", "_"));
            } catch (IllegalArgumentException e) {
                errors.add(new ErrorDTO("format", invalidFormat));
            }
        }

        if (pokemonList == null) {
            errors.add(new ErrorDTO("pokemonList", "attribute was not given, pokemonList must be provided"));
        }

        if (pokemonList != null) {
            if (pokemonList.size() > 6) {
                errors.add(new ErrorDTO("pokemonList", "a PokemonTeam's pokemonList cannot contain" +
                        "more than 6 pokemon"));
            }

            for (PokemonDTO pokemonDTO : pokemonList) {
                List<ErrorDTO> pokemonErrors = pokemonDTO.validate();
                for (ErrorDTO error : pokemonErrors) {
                    error.setAttribute("pokemon1." + error.getAttribute());
                }
                errors.addAll(pokemonErrors);
            }
        }

        return errors;
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

    @Override
    public String toString() {
        return "PokemonTeamDTO{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", format='" + format + '\'' +
                ", pokemonList=" + pokemonList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonTeamDTO that = (PokemonTeamDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (teamName != null ? !teamName.equals(that.teamName) : that.teamName != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        return pokemonList != null ? pokemonList.equals(that.pokemonList) : that.pokemonList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (pokemonList != null ? pokemonList.hashCode() : 0);
        return result;
    }

    public static final class PokemonTeamDTOBuilder {
        private Long id;
        private String teamName;
        private String format;
        private List<PokemonDTO> pokemonList = new ArrayList<>(); // Max size 6

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
