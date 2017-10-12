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

        post("/team/pokemon", (req, res) -> {
            PokemonTeamDTO pokemonTeam = gson.fromJson(req.body(), PokemonTeamDTO.class);
            return pokemonTeamService.createPokemonTeam(pokemonTeam);
        }, new JsonTransformer());
    }
}
