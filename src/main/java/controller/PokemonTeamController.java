package controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dto.ErrorDTO;
import dto.PokemonTeamDTO;
import dto.StatusMessageDTO;
import constant.Format;
import model.GetPokemonTeamsRequest;
import service.PokemonTeamService;
import transformer.JsonTransformer;

import java.util.Arrays;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;
import static util.StatusCodes.clientError;
import static util.StatusCodes.noContent;

public class PokemonTeamController {

    private static final String malformedIdMessage =
            "Malformed request, id must be a number between 0 and " + Long.MAX_VALUE + ".";

    private final Gson gson;
    private final PokemonTeamService pokemonTeamService;

    public PokemonTeamController(Gson gson, PokemonTeamService pokemonTeamService) {
        this.gson = gson;
        this.pokemonTeamService = pokemonTeamService;
        _setupRoutes();
    }

    private void _setupRoutes() {

        // Create & Save a PokemonTeam.
        post("/pokemon-team", (req, res) -> {
            try {
                PokemonTeamDTO pokemonTeam = gson.fromJson(req.body(), PokemonTeamDTO.class);
                if (pokemonTeam == null) {
                    res.status(clientError);
                    return new StatusMessageDTO("Unable to create PokemonTeam, no body provided");
                }

                List<ErrorDTO> errors = pokemonTeam.validate();
                if (!errors.isEmpty()) {
                    res.status(clientError);
                    return new StatusMessageDTO("Unable to create PokemonTeam.", errors);
                }

                return pokemonTeamService.createPokemonTeam(pokemonTeam);
            } catch (JsonSyntaxException e) {
                res.status(clientError);
                return new StatusMessageDTO("Invalid JSON, please send a valid PokemonTeam.");
            }
        }, new JsonTransformer());

        // Get PokemonTeam By id
        get("/pokemon-team/:id", "application/json", (req, res) -> {
            try {
                Long id = Long.parseLong(req.params(":id"));

                if (id <= 0) {
                    throw new NumberFormatException();
                }

                PokemonTeamDTO pokemonTeamDTO = pokemonTeamService.getPokemonTeamById(id);
                if (pokemonTeamDTO == null) {
                    res.status(noContent);
                }

                return pokemonTeamDTO;
            } catch (NumberFormatException e) {
                res.status(clientError);
                return new StatusMessageDTO(malformedIdMessage);
            }
        }, new JsonTransformer());


        // Get PokemonTeam Endpoint.
        // Supports query parameters format & teamName.
        get("/pokemon-teams", "application/json", (req, res) -> {
            String formatString = req.queryParams("format");
            String teamName = req.queryParams("teamName");
            Format format = null;

            if (formatString != null) {
                try {
                    format = Format.valueOf(formatString.replace(" ", "_").toUpperCase());
                } catch (IllegalArgumentException e) {
                    res.status(clientError);
                    return new StatusMessageDTO("Malformed request, format must be one of the following values: " +
                        Arrays.toString(Format.values()));
                }
            }

            return pokemonTeamService.getPokemonTeams(
                    new GetPokemonTeamsRequest.GetPokemonTeamsRequestBuilder()
                        .withFormat(format)
                        .withTeamName(teamName)
                        .build());

        }, new JsonTransformer());
    }
}
