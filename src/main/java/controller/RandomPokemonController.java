package controller;

import com.google.gson.Gson;
import dto.RandomPokemonDTO;
import service.RandomPokemonService;
import transformer.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.post;

public class RandomPokemonController {

    private final Gson gson;
    private final RandomPokemonService randomPokemonService;

    public RandomPokemonController(Gson gson, RandomPokemonService randomPokemonService) {
        this.gson = gson;
        this.randomPokemonService = randomPokemonService;
        _setupRoutes();
    }

    private void _setupRoutes() {
        get("/random/pokemon/:id", "application/json", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            return randomPokemonService.getRandomPokemon(id);
        }, new JsonTransformer());

        post("/random/pokemon", (req, res) -> {
            RandomPokemonDTO randomPokemon = gson.fromJson(req.body(), RandomPokemonDTO.class);
            return randomPokemonService.createRandomPokemon(randomPokemon);
        }, new JsonTransformer());
    }
}
