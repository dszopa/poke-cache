package controller;

import com.google.gson.Gson;
import dto.PokemonTeamDTO;
import service.PokemonTeamService;
import transformer.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.post;

public class PokemonTeamController {

    private final Gson gson;
    private final PokemonTeamService pokemonTeamService;

    public PokemonTeamController(Gson gson, PokemonTeamService pokemonTeamService) {
        this.gson = gson;
        this.pokemonTeamService = pokemonTeamService;
        _setupRoutes();
    }

    private void _setupRoutes() {
        // Get a PokemonTeam by id.
        get("/team/pokemon/id/:id", "application/json", (req, res) -> {
            Long id = Long.parseLong(req.params(":id"));
            return pokemonTeamService.getPokemonTeam(id);
        }, new JsonTransformer());

        // Get all PokemonTeams for a given format.
        get("/team/pokemon/format/:format", "application/json", (req, res) -> {
            String format = req.params(":format");
            return pokemonTeamService.getPokemonTeamsByFormat(format);
        }, new JsonTransformer());

        // Get all PokemonTeams by team name.
        get("/team/pokemon/teamName/:teamName", "application/json", (req, res) -> {
            String teamName = req.params(":teamName");
            return pokemonTeamService.getPokemonTeamsByTeamName(teamName);
        }, new JsonTransformer());

        // Create & Save a PokemonTeam.
        post("/team/pokemon", (req, res) -> {
            PokemonTeamDTO pokemonTeam = gson.fromJson(req.body(), PokemonTeamDTO.class);
            return pokemonTeamService.createPokemonTeam(pokemonTeam);
        }, new JsonTransformer());
    }
}
