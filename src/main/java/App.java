import com.google.gson.Gson;
import controller.PokemonController;
import controller.PokemonTeamController;
import controller.RandomPokemonController;
import factory.*;
import repository.*;
import service.PokemonService;
import service.PokemonTeamService;
import service.RandomPokemonService;

import static spark.Spark.port;

public class App {

    public static void main(String[] args) {
        // --- Instantiate Dependencies ---
        Gson gson = new Gson();
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        HttpClientFactory httpClientFactory = new HttpClientFactory();

        // Create Object Factories
        PokemonFactory pokemonFactory = new PokemonFactory();
        PokemonDtoFactory pokemonDtoFactory = new PokemonDtoFactory(httpClientFactory);
        PokemonTeamFactory pokemonTeamFactory = new PokemonTeamFactory();
        PokemonTeamDtoFactory pokemonTeamDtoFactory = new PokemonTeamDtoFactory();
        RandomPokemonFactory randomPokemonFactory = new RandomPokemonFactory();
        RandomPokemonDtoFactory randomPokemonDtoFactory = new RandomPokemonDtoFactory();

        // Create Repositories
        PokemonRepository pokemonRepository = new PokemonRepository(dataSourceFactory);
        PokemonTeamRepository pokemonTeamRepository = new PokemonTeamRepository(dataSourceFactory);
        RandomPokemonRepository randomPokemonRepository = new RandomPokemonRepository(dataSourceFactory);
        TypeRepository typeRepository = new TypeRepository(dataSourceFactory);
        MoveRepository moveRepository = new MoveRepository(dataSourceFactory);

        // Create Services
        PokemonService pokemonService = new PokemonService(pokemonRepository, typeRepository, moveRepository,
                pokemonFactory, pokemonDtoFactory);
        PokemonTeamService pokemonTeamService = new PokemonTeamService(pokemonTeamRepository, pokemonRepository,
                typeRepository, moveRepository, pokemonFactory, pokemonDtoFactory, pokemonTeamFactory,
                pokemonTeamDtoFactory);
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
