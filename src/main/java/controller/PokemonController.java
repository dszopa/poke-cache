package controller;

import service.PokemonService;
import transformer.JsonTransformer;

import static spark.Spark.get;

public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;

        get("/pokemon/:id", "application/json", (req, res) -> {
                return pokemonService.getPokemon(Long.parseLong(req.params(":id")));
        }, new JsonTransformer());
    }
}
