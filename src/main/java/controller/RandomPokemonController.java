package controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dto.ErrorDTO;
import dto.RandomPokemonDTO;
import dto.StatusMessageDTO;
import service.RandomPokemonService;
import transformer.JsonTransformer;

import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;
import static constant.StatusCodes.clientError;

public class RandomPokemonController {

    private final Gson gson;
    private final RandomPokemonService randomPokemonService;

    public RandomPokemonController(Gson gson, RandomPokemonService randomPokemonService) {
        this.gson = gson;
        this.randomPokemonService = randomPokemonService;
        _setupRoutes();
    }

    private void _setupRoutes() {
        post("/random-pokemon", (req, res) -> {
            try {
                RandomPokemonDTO randomPokemon = gson.fromJson(req.body(), RandomPokemonDTO.class);
                if (randomPokemon == null) {
                    res.status(clientError);
                    return new StatusMessageDTO("Unable to create RandomPokemon, no body provided");
                }
                List<ErrorDTO> errors = randomPokemon.validate();
                if (!errors.isEmpty()) {
                    res.status(clientError);
                    return new StatusMessageDTO("Unable to create RandomPokemon.", errors);
                }
                return randomPokemonService.createRandomPokemon(randomPokemon);
            } catch (JsonSyntaxException e) {
                res.status(clientError);
                return new StatusMessageDTO("Invalid JSON, please send a valid RandomPokemon.");
            }
        }, new JsonTransformer());


        get("/random-pokemon/:id", "application/json", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            return randomPokemonService.getRandomPokemonById(id);
        }, new JsonTransformer());
    }
}
