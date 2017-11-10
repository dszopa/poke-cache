package controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dto.TextPokemonDTO;
import dto.ErrorDTO;
import dto.StatusMessageDTO;
import service.PokemonService;

import java.util.List;

import static constant.StatusCodes.clientError;
import static spark.Spark.post;

public class TextPokemonController {

    private final Gson gson;
    private final PokemonService pokemonService;

    public TextPokemonController(Gson gson, PokemonService pokemonService) {
        this.gson = gson;
        this.pokemonService = pokemonService;
        _setupRoutes();
    }

    private void _setupRoutes() {

        post("/text-pokemon", (req, res) -> {
            try {
                TextPokemonDTO textPokemonDTO = gson.fromJson(req.body(), TextPokemonDTO.class);
                if (textPokemonDTO == null) {
                    res.status(clientError);
                    return new StatusMessageDTO("Unable to create TextPokemonDTO, no body provided");
                }

                List<ErrorDTO> errors = textPokemonDTO.validate();
                if (!errors.isEmpty()) {
                    res.status(clientError);
                    return new StatusMessageDTO("Unable to create TextPokemonDTO.", errors);
                }

                return pokemonService.createPokemon(textPokemonDTO);
            } catch (JsonSyntaxException e) {
                res.status(clientError);
                return new StatusMessageDTO("Invalid JSON, please send a valid TextPokemonDTO");
            }
        });
    }
}
