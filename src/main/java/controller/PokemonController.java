package controller;

import com.google.gson.Gson;
import dto.PokemonDTO;
import service.PokemonService;
import transformer.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.post;

public class PokemonController {

    private final Gson gson;
    private final PokemonService pokemonService;

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
            PokemonDTO pokemon = gson.fromJson(req.body(), PokemonDTO.class);
            return pokemonService.createPokemon(pokemon);
        }, new JsonTransformer());
    }
}
