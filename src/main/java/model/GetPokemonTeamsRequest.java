package model;

public class GetPokemonTeamsRequest {

    private Format format;
    private String teamName;

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public static final class GetPokemonTeamsRequestBuilder {
        private Format format;
        private String teamName;

        public GetPokemonTeamsRequestBuilder withFormat(Format format) {
            this.format = format;
            return this;
        }

        public GetPokemonTeamsRequestBuilder withTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public GetPokemonTeamsRequest build() {
            GetPokemonTeamsRequest getPokemonTeamsRequest = new GetPokemonTeamsRequest();
            getPokemonTeamsRequest.setFormat(format);
            getPokemonTeamsRequest.setTeamName(teamName);
            return getPokemonTeamsRequest;
        }
    }
}
