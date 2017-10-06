import controller.PokemonController;
import controller.PokemonTeamController;
import repository.PokemonRepository;
import repository.PokemonTeamRepository;
import service.DbConnectionService;
import service.PokemonService;
import service.PokemonTeamService;

import static spark.Spark.port;

public class App {

    public static void main(String[] args) {
        // --- Instantiate Dependencies ---
        DbConnectionService dbConnectionService = new DbConnectionService();

        // Create Repositories
        PokemonRepository pokemonRepository = new PokemonRepository(dbConnectionService);
        PokemonTeamRepository pokemonTeamRepository = new PokemonTeamRepository(dbConnectionService);

        // Create Services
        PokemonService pokemonService = new PokemonService(pokemonRepository);
        PokemonTeamService pokemonTeamService = new PokemonTeamService(pokemonTeamRepository, pokemonRepository);

        // --- Configure Spark ---
        port(4567);

        // --- Setup Routes ---
        new PokemonController(pokemonService);
        new PokemonTeamController(pokemonTeamService);
    }
}
