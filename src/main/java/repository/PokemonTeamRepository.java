package repository;

import data.PokemonTeam;
import service.DbConnectionService;

import java.sql.*;

public class PokemonTeamRepository {

    private Connection connection;

    // Seems wrong that this is
    public PokemonTeamRepository(DbConnectionService dbConnectionService) {
        this.connection = dbConnectionService.getConnection();
    }

    public PokemonTeam savePokemonTeam(PokemonTeam pokemonTeam) {
        // Now all the pokemon in the team will exist in the database.
        String query = "INSERT INTO pokemon_team (team_name, format, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, " +
                "pokemon6) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pokemonTeam.getTeamName());
            preparedStatement.setString(2, pokemonTeam.getFormat());

            for (int i = 0; i < pokemonTeam.getPokemonList().size(); i++) {
                preparedStatement.setLong(i + 2, pokemonTeam.getPokemonList().get(i).getId());
            }

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating PokemonTeam failed, no rows affected.");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                pokemonTeam.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Creating PokemonTeam failed, no ID obtained.");
            }

            return pokemonTeam;
        } catch (SQLException e) {
            return null;
        }
    }
}
