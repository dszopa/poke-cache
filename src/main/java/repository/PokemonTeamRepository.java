package repository;

import data.PokemonTeam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonTeamRepository {

    private static final String insertPokemonTeamQuery = "INSERT INTO pokemon_team (team_name, format, pokemon1_id, " +
            "pokemon2_id, pokemon3_id, pokemon4_id, pokemon5_id, pokemon6_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String selectPokemonTeamByIdQuery = "SELECT * FROM pokemon_team WHERE id = ? LIMIT 1";

    private static final String selectPokemonTeamsByFormatQuery = "SELECT * FROM pokemon_team WHERE format = ?";

    private static final String selectPokemonTeamsByTeamNameQuery = "SELECT * FROM pokemon_team WHERE team_name = ?";

    private final static Logger logger = LoggerFactory.getLogger(PokemonTeamRepository.class);
    private final Connection connection;

    /**
     * Repository for managing creating, retrieval, and editing of PokemonTeam entities.
     * @param dbConnectionService
     *  A database connection service, used to get the current connection to the database.
     */
    public PokemonTeamRepository(DbConnectionService dbConnectionService) {
        this.connection = dbConnectionService.getConnection();
    }

    // TODO: it might be possible to abstract this code with a generic function
    /**
     * Saves a PokemonTeam to the database.
     * @param pokemonTeam
     *  The PokemonTeam that will be saved.
     * @return
     *  The PokemonTeam with its new database id attached.
     */
    public PokemonTeam savePokemonTeam(PokemonTeam pokemonTeam) {
        try {
            PreparedStatement preparedStatement = _createSavePokemonTeamStatement(pokemonTeam);

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
            logger.error("Error with SQL Statement.", e);
            return null;
        }
    }

    /**
     * Get a PokemonTeam from the database by its id.
     * @param id
     *  The PokemonTeam's id.
     * @return
     *  The PokemonTeam with id, id, from the database.
     */
    public PokemonTeam getPokemonTeamById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(selectPokemonTeamByIdQuery);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            return _convertResultSetToPokemonTeam(rs);
        } catch (SQLException e) {
            logger.error("Getting PokemonTeam from database by id failed.", e);
            return null;
        }
    }

    /**
     * Get a List of PokemonTeam from the database by format.
     * @param format
     *  The format to search by.
     * @return
     *  A list of PokemonTeam where each PokemonTeam has its format matching the provided format.
     */
    public List<PokemonTeam> getPokemonTeamsByFormat(String format) {
        try {
            PreparedStatement statement = connection.prepareStatement(selectPokemonTeamsByFormatQuery);
            statement.setString(1, format);
            ResultSet rs = statement.executeQuery();
            return _convertResultSetToPokemonTeams(rs);
        } catch (SQLException e) {
            logger.error("Getting PokemonTeams from database by format failed.", e);
            return new ArrayList<>();
        }
    }

    /**
     * Get a List of PokemonTeam from the database by teamName
     * @param teamName
     *  The teamName to search by.
     * @return
     *  A list of PokemonTeam where each PokemonTeam has its teamName matching the provided teamName.
     */
    public List<PokemonTeam> getPokemonTeamsByTeamName(String teamName) {
        try {
            PreparedStatement statement = connection.prepareStatement(selectPokemonTeamsByTeamNameQuery);
            statement.setString(1, teamName);
            ResultSet rs = statement.executeQuery();
            return _convertResultSetToPokemonTeams(rs);
        } catch (SQLException e) {
            logger.error("Getting PokemonTeams from database by teamName failed.", e);
            return new ArrayList<>();
        }
    }

    /**
     * Helper function which returns a PreparedStatement for saving a PokemonTeam object.
     * @param pokemonTeam
     *  The PokemonTeam object the PreparedStatement is being prepared for.
     * @return
     *  A PreparedStatement for saving the given PokemonTeam object.
     * @throws SQLException
     *  Thrown when there is a problem with creating the PreparedStatement.
     */
    private PreparedStatement _createSavePokemonTeamStatement(PokemonTeam pokemonTeam) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                insertPokemonTeamQuery, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, pokemonTeam.getTeamName());
        preparedStatement.setString(2, pokemonTeam.getFormat());

        for (int i = 0; i < pokemonTeam.getPokemonIdList().size(); i++) {
            preparedStatement.setLong(i + 3, pokemonTeam.getPokemonIdList().get(i));
        }

        return preparedStatement;
    }

    /**
     * Helper function to convert a ResultSet to a Pokemon object.
     * @param rs
     *  The ResultSet the PokemonTeam object will be made from.
     * @return
     *  The created PokemonTeam object.
     * @throws SQLException
     *  Thrown when there is a problem converting the ResultSet to a PokemonTeam object.
     */
    private PokemonTeam _convertResultSetToPokemonTeam(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String teamName = rs.getString("team_name");
        String format = rs.getString("format");
        Long pokemon1Id = rs.getLong("pokemon1_id");
        Long pokemon2Id = rs.getLong("pokemon2_id");
        Long pokemon3Id = rs.getLong("pokemon3_id");
        Long pokemon4Id = rs.getLong("pokemon4_id");
        Long pokemon5Id = rs.getLong("pokemon5_id");
        Long pokemon6Id = rs.getLong("pokemon6_id");

        return new PokemonTeam(id, teamName, format,
                Arrays.asList(pokemon1Id, pokemon2Id, pokemon3Id, pokemon4Id, pokemon5Id, pokemon6Id));
    }

    /**
     * Helper function to convert a ResultSet into a list of Pokemon objects.
     * @param rs
     *  The ResultSet the PokemonTeam list will be made from.
     * @return
     *  The created PokemonTeam object.
     * @throws SQLException
     *  Thrown when there is a problem converting the ResultSet into a list of PokemonTeam objects.
     */
    private List<PokemonTeam> _convertResultSetToPokemonTeams(ResultSet rs) throws SQLException {
        List<PokemonTeam> pokemonTeams = new ArrayList<>();
        while(rs.next()) {
            pokemonTeams.add(_convertResultSetToPokemonTeam(rs));
        }
        return pokemonTeams;
    }
}
