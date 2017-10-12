import com.google.gson.Gson;
import controller.PokemonController;
import controller.PokemonTeamController;
import controller.RandomPokemonController;
import factory.*;
import repository.PokemonRepository;
import repository.PokemonTeamRepository;
import repository.RandomPokemonRepository;
import service.DbConnectionService;
import service.PokemonService;
import service.PokemonTeamService;
import service.RandomPokemonService;

import static spark.Spark.port;

public class App {

    public static void main(String[] args) {
        // --- Instantiate Dependencies ---
        Gson gson = new Gson();
        DbConnectionService dbConnectionService = new DbConnectionService();

        // Create Object Factories
        PokemonFactory pokemonFactory = new PokemonFactory();
        PokemonDtoFactory pokemonDtoFactory = new PokemonDtoFactory();
        PokemonTeamFactory pokemonTeamFactory = new PokemonTeamFactory();
        PokemonTeamDtoFactory pokemonTeamDtoFactory = new PokemonTeamDtoFactory();
        RandomPokemonFactory randomPokemonFactory = new RandomPokemonFactory();
        RandomPokemonDtoFactory randomPokemonDtoFactory = new RandomPokemonDtoFactory();

        // Create Repositories
        PokemonRepository pokemonRepository = new PokemonRepository(dbConnectionService);
        PokemonTeamRepository pokemonTeamRepository = new PokemonTeamRepository(dbConnectionService);
        RandomPokemonRepository randomPokemonRepository = new RandomPokemonRepository(dbConnectionService);

        // Create Services
        PokemonService pokemonService = new PokemonService(pokemonRepository, pokemonFactory, pokemonDtoFactory);
        PokemonTeamService pokemonTeamService = new PokemonTeamService(pokemonTeamRepository, pokemonRepository,
                pokemonFactory, pokemonDtoFactory, pokemonTeamFactory, pokemonTeamDtoFactory);
        RandomPokemonService randomPokemonService = new RandomPokemonService(randomPokemonRepository,
                randomPokemonFactory, randomPokemonDtoFactory);

        // --- Configure Spark ---
        port(4567);

        // --- Setup Routes ---
        new PokemonController(gson, pokemonService);
        new PokemonTeamController(gson, pokemonTeamService);
        new RandomPokemonController(gson, randomPokemonService);
    }
}
