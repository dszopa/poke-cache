package controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dto.ErrorDTO;
import dto.PokemonDTO;
import dto.StatusMessageDTO;
import model.GetPokemonRequest;
import constant.Type;
import service.PokemonService;
import transformer.JsonTransformer;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;
import static constant.RegExps.commaListNoAlphabet;
import static constant.StatusCodes.clientError;
import static constant.StatusCodes.noContent;

public class PokemonController {

    private static final String malformedIdMessage =
            "Malformed request, id must be a number between 0 and " + Long.MAX_VALUE + ".";
    private static final String malformedIdsMessage =
            "Malformed request. ids was not in the form 1,2,3...";

    private final Gson gson;
    private final PokemonService pokemonService;

    public PokemonController(Gson gson, PokemonService pokemonService) {
        this.gson = gson;
        this.pokemonService = pokemonService;
        _setupRoutes();
    }

    private void _setupRoutes() {

        // Create a new Pokemon.
        post("/pokemon", "application/json", (req, res) -> {
            try {
                PokemonDTO pokemon = gson.fromJson(req.body(), PokemonDTO.class);
                if (pokemon == null) {
                    res.status(clientError);
                    return new StatusMessageDTO("Unable to create Pokemon, no body provided");
                }
                List<ErrorDTO> errors = pokemon.validate();
                if (!errors.isEmpty()) {
                    res.status(clientError);
                    return new StatusMessageDTO("Unable to create Pokemon.", errors);
                }
                return pokemonService.createPokemon(pokemon);
            } catch (JsonSyntaxException e) {
                res.status(clientError);
                return new StatusMessageDTO("Invalid JSON, please send a valid Pokemon.");
            }
        }, new JsonTransformer());


        // Get Pokemon Endpoint
        // Supports getting pokemon by ids, type, and name
        get("/pokemon", "application/json", (req, res) -> {
            String idStringList = req.queryParams("ids");
            String typeString = req.queryParams("type");
            String name = req.queryParams("name");
            List<Long> ids = new ArrayList<>();
            Type type = null;

            if (idStringList != null) {
                if (!commaListNoAlphabet.matcher(idStringList).find()) {
                    res.status(clientError);
                    return new StatusMessageDTO(malformedIdsMessage);
                }
                String[] idStrings = idStringList.split(",");
                try {
                    for (String idString : idStrings) {
                        Long id = Long.parseLong(idString);
                        if (id <= 0) {
                            throw new NumberFormatException();
                        }
                        ids.add(id);
                    }
                } catch (NumberFormatException e) {
                    res.status(clientError);
                    return new StatusMessageDTO(malformedIdMessage);
                }
            }

            if (typeString != null) {
                try {
                    type = Type.valueOf(typeString.toUpperCase());
                } catch (IllegalArgumentException e) {
                    res.status(clientError);
                    return new StatusMessageDTO("Malformed request, type: " + typeString +
                            " is not a valid pokemon type.");
                }
            }

            return pokemonService.getPokemon(
                    new GetPokemonRequest.GetPokemonRequestBuilder()
                            .withIds(ids)
                            .withType(type)
                            .withName(name)
                            .build());

        }, new JsonTransformer());


        // Get Pokemon By Id.
        get("/pokemon/:id", "application/json", (req, res) -> {
            try {
                Long id = Long.parseLong(req.params(":id"));
                if (id <= 0) {
                    throw new NumberFormatException();
                }

                PokemonDTO pokemonDTO = pokemonService.getPokemonById(id);
                if (pokemonDTO == null) {
                    res.status(noContent); // 204 ignores the body
                }

                return pokemonDTO;

            } catch (NumberFormatException e) {
                res.status(clientError);
                return new StatusMessageDTO(malformedIdMessage);
            }
        }, new JsonTransformer());
    }
}
