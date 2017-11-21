package model;

import constant.Type;

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

    @Override
    public String toString() {
        return "GetPokemonRequest{" +
                "ids=" + ids +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetPokemonRequest that = (GetPokemonRequest) o;

        if (ids != null ? !ids.equals(that.ids) : that.ids != null) return false;
        if (type != that.type) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = ids != null ? ids.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
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
