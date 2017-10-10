package controller;

import com.google.gson.Gson;
import data.Pokemon;
import service.PokemonService;
import transformer.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.post;

public class PokemonController {

    private Gson gson;
    private PokemonService pokemonService;

    public PokemonController(Gson gson, PokemonService pokemonService) {
        this.gson = gson;
        this.pokemonService = pokemonService;
        _setupRoutes();
    }

    private void _setupRoutes() {
        get("/pokemon/:id", "application/json", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            return pokemonService.getPokemon(id);
        }, new JsonTransformer());

        post("/pokemon", "application/json", (req, res) -> {
            Pokemon pokemon = gson.fromJson(req.body(), Pokemon.class);
            return pokemonService.createPokemon(pokemon);
        }, new JsonTransformer());
    }
}
