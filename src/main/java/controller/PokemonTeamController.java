package controller;

import service.PokemonTeamService;

public class PokemonTeamController {

    private PokemonTeamService pokemonTeamService;

    public PokemonTeamController(PokemonTeamService pokemonTeamService) {
        this.pokemonTeamService = pokemonTeamService;
    }
}
