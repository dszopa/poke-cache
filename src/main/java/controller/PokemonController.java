package controller;

import com.google.gson.Gson;
import dto.PokemonDTO;
import dto.StatusMessageDTO;
import service.PokemonService;
import spark.Request;
import spark.Response;
import transformer.JsonTransformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static util.RegExps.listRegex;

public class PokemonController {

    private final Gson gson;
    private final PokemonService pokemonService;

    public PokemonController(Gson gson, PokemonService pokemonService) {
        this.gson = gson;
        this.pokemonService = pokemonService;
        _setupRoutes();
    }

    private void _setupRoutes() {
        // Get Pokemon By Id.
        get("/pokemon/id/:id", "application/json", (req, res) -> {
            try {
                Long id = Long.parseLong(req.params(":id"));
                return pokemonService.getPokemonById(id);
            } catch (NumberFormatException e) {
                return _validateGetPokemonById(req, res);
            }
        }, new JsonTransformer());

        // Get a List of Pokemon by a list of Ids.
        // Should be in the format 1,2,3...
        get("/pokemon/ids/:ids", "application/json", (req, res) -> {
            String idsListString = req.params(":ids");

            if (idsListString.matches(listRegex)) {
                String[] idStrings = idsListString.split(",");
                List<Long> ids = new ArrayList<>();

                for (String id : idStrings) {
                    ids.add(Long.parseLong(id));
                }

                return pokemonService.getPokemonByIds(ids);
            } else {
                res.status(400);
                return "Malformed request, ids was not in the form 1,2,3,...";
            }

        }, new JsonTransformer());

        // Get a list of Pokemon by type.
        get("/pokemon/type/:type", "application/json", (req, res) -> {
           String type = req.params(":type");
           return pokemonService.getPokemonByType(type);
        }, new JsonTransformer());

        // Get a list of Pokemon by pokemon name
        get("/pokemon/name/:name", "application/json", (req, res) -> {
            String name = req.params(":name");
            return pokemonService.getPokemonByName(name);
        }, new JsonTransformer());

        // Create a new Pokemon.
        post("/pokemon", "application/json", (req, res) -> {
            PokemonDTO pokemon = gson.fromJson(req.body(), PokemonDTO.class);
            return pokemonService.createPokemon(pokemon);
        }, new JsonTransformer());
    }

    private StatusMessageDTO _validateGetPokemonById(Request req, Response res) {
        int statusCode = 400;
        res.status(statusCode);

        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("id", req.params("id"));

        return new StatusMessageDTO.StatusMessageDTOBuilder()
                .withStatus(statusCode)
                .withMessage("Malformed request, id must be a number between 0 and " + Long.MAX_VALUE + ".")
                .withErrors(errorMap)
                .build();
    }
}
