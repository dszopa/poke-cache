package repository;

import data.PokemonTeam;
import factory.DataSourceFactory;
import model.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonTeamRepository extends Repository {

    private static final String selectPokemonTeamByIdQuery = "SELECT * FROM pokemon_team WHERE id = ? LIMIT 1";
    private static final String insertPokemonTeamQuery = "INSERT INTO pokemon_team (team_name, format, pokemon1_id, " +
            "pokemon2_id, pokemon3_id, pokemon4_id, pokemon5_id, pokemon6_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


    private final static Logger logger = LoggerFactory.getLogger(PokemonTeamRepository.class);
    private final DataSource dataSource;

    /**
     * Repository for managing creating, retrieval, and editing of PokemonTeam entities.
     * @param dataSourceFactory
     *  A factory for getting a DataSource object that manages database connections.
     */
    public PokemonTeamRepository(DataSourceFactory dataSourceFactory) {
        this.dataSource = dataSourceFactory.getDataSource();
    }

    public List<PokemonTeam> getPokemonTeams(Format format, String teamName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM pokemon_team");

        if (format != null || teamName != null) {
            stringBuilder.append(" WHERE");
        }

        int formatIndex = 0;
        int teamNameIndex = 0;
        int count = 0;

        if (format != null) {
            stringBuilder.append(" UPPER(format) = ?");
            count++;
            formatIndex = count;
        }
        if (teamName != null) {
            if (count >= 1) {
                stringBuilder.append(" AND");
            }
            stringBuilder.append(" UPPER(team_name) = UPPER(?)");
            count++;
            teamNameIndex = count;
        }

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(stringBuilder.toString());

            if (format != null) {
                statement.setString(formatIndex, format.name());
            }
            if (teamName != null) {
                statement.setString(teamNameIndex, teamName);
            }

            logger.info("Database Call -> " + statement.toString());
            resultSet = statement.executeQuery();
            return _convertResultSetToPokemonTeams(resultSet);

        } catch (SQLException e) {
            logger.error("Error querying for PokemonTeams from database. Call -> getPokemonTeams("
                    + format + ", " + teamName + ")", e);
            _rollbackConnection(connection, logger);
            return new ArrayList<>();
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
        }
    }

    /**
     * Saves a PokemonTeam to the database.
     * @param pokemonTeam
     *  The PokemonTeam that will be saved.
     * @return
     *  The PokemonTeam with its new database id attached.
     */
    public PokemonTeam savePokemonTeam(PokemonTeam pokemonTeam) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = _createInsertPokemonTeamStatement(pokemonTeam, connection);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating PokemonTeam failed, no rows affected.");
            }

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                pokemonTeam.setId(resultSet.getLong(1));
            } else {
                throw new SQLException("Creating PokemonTeam failed, no ID obtained.");
            }

            return pokemonTeam;
        } catch (SQLException e) {
            logger.error("Error with SQL Statement. Called -> savePokemonTeam(" + pokemonTeam.toString() + ")", e);
            _rollbackConnection(connection, logger);
            return null;
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
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
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(selectPokemonTeamByIdQuery);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            return _convertResultSetToPokemonTeam(resultSet);
        } catch (SQLException e) {
            logger.error("Getting PokemonTeam from database by id failed. Call -> getPokemonTeamById(" + id + ")", e);
            _rollbackConnection(connection, logger);
            return null;
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
        }
    }

    /**
     * Helper function which returns a PreparedStatement for saving a PokemonTeam object.
     * @param pokemonTeam
     *  The PokemonTeam object the PreparedStatement is being prepared for.
     * @param connection
     *  A Connection object used to create the statement.
     * @return
     *  A PreparedStatement for saving the given PokemonTeam object.
     * @throws SQLException
     *  Thrown when there is a problem with creating the PreparedStatement.
     */
    private PreparedStatement _createInsertPokemonTeamStatement(PokemonTeam pokemonTeam, Connection connection)
            throws SQLException {
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
            pokemonTeams.add(_convertResultSetToPokemonTeamNoNextCall(rs));
        }
        return pokemonTeams;
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
        if (rs.next()) {
            return _convertResultSetToPokemonTeamNoNextCall(rs);
        } else {
            return null;
        }
    }

    /**
     * Helper function to handle the actual logic of converting a ResultSet to a pokemon object.
     * @param rs
     *  The ResultSet the PokemonTeam object will be made from.
     * @return
     *  The created PokemonTeam object.
     * @throws SQLException
     *  Thrown when there is a problem converting the ResultSet to a PokemonTeam object.
     */
    private PokemonTeam _convertResultSetToPokemonTeamNoNextCall(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String teamName = rs.getString("team_name");
        String format = rs.getString("format");
        Long pokemon1Id = rs.getLong("pokemon1_id");
        Long pokemon2Id = rs.getLong("pokemon2_id");
        Long pokemon3Id = rs.getLong("pokemon3_id");
        Long pokemon4Id = rs.getLong("pokemon4_id");
        Long pokemon5Id = rs.getLong("pokemon5_id");
        Long pokemon6Id = rs.getLong("pokemon6_id");

        return new PokemonTeam.PokemonTeamBuilder()
                .withId(id)
                .withTeamName(teamName)
                .withFormat(format)
                .withPokemonIdList(Arrays.asList(pokemon1Id, pokemon2Id, pokemon3Id, pokemon4Id,
                        pokemon5Id, pokemon6Id))
                .build();
    }
}
