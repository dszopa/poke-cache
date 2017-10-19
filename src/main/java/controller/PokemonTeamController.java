package controller;

import com.google.gson.Gson;
import dto.PokemonTeamDTO;
import service.PokemonTeamService;
import transformer.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.post;

public class PokemonTeamController {

    private Gson gson;
    private PokemonTeamService pokemonTeamService;

    public PokemonTeamController(Gson gson, PokemonTeamService pokemonTeamService) {
        this.gson = gson;
        this.pokemonTeamService = pokemonTeamService;
        _setupRoutes();
    }

    private void _setupRoutes() {
        get("/team/pokemon/:id", "application/json", (req, res) -> {
            Long id = Long.parseLong(req.params(":id"));
            return pokemonTeamService.getPokemonTeam(id);
        }, new JsonTransformer());

        get("/team/pokemon/format/:format", "application/json", (req, res) -> {
            String format = req.params(":format");
            return pokemonTeamService.getPokemonTeamsByFormat(format);
        }, new JsonTransformer());

        get("/team/pokemon/teamName/:teamName", "application/json", (req, res) -> {
            String teamName = req.params(":teamName");
            return pokemonTeamService.getPokemonTeamsByTeamName(teamName);
        }, new JsonTransformer());

        post("/team/pokemon", (req, res) -> {
            PokemonTeamDTO pokemonTeam = gson.fromJson(req.body(), PokemonTeamDTO.class);
            return pokemonTeamService.createPokemonTeam(pokemonTeam);
        }, new JsonTransformer());
    }
}
