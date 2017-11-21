package model;

import constant.Format;

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

    @Override
    public String toString() {
        return "GetPokemonTeamsRequest{" +
                "format=" + format +
                ", teamName='" + teamName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetPokemonTeamsRequest that = (GetPokemonTeamsRequest) o;

        if (format != that.format) return false;
        return teamName != null ? teamName.equals(that.teamName) : that.teamName == null;
    }

    @Override
    public int hashCode() {
        int result = format != null ? format.hashCode() : 0;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        return result;
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
