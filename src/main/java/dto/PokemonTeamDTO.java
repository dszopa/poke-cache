package dto;

import model.Format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonTeamDTO {

    private static final String invalidFormat = "Not a valid format, valid formats are: " + Arrays.toString(Format.values());

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

    public List<ErrorDTO> validate() {
        List<ErrorDTO> errors = new ArrayList<>();

        if (teamName == null) {
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
