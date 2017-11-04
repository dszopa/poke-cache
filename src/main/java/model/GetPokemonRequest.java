package model;

import java.util.List;

public class GetPokemonRequest {

    List<Long> ids;
    Type type;
    String name;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class GetPokemonRequestBuilder {
        List<Long> ids;
        Type type;
        String name;

        public GetPokemonRequestBuilder withIds(List<Long> ids) {
            this.ids = ids;
            return this;
        }

        public GetPokemonRequestBuilder withType(Type type) {
            this.type = type;
            return this;
        }

        public GetPokemonRequestBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public GetPokemonRequest build() {
            GetPokemonRequest getPokemonRequest = new GetPokemonRequest();
            getPokemonRequest.setIds(ids);
            getPokemonRequest.setType(type);
            getPokemonRequest.setName(name);
            return getPokemonRequest;
        }
    }
}
