package repository;

import data.Pokemon;
import factory.PokemonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DbConnectionService;

import java.sql.*;

public class PokemonRepository {

    private static String savePokemonQuery = "INSERT INTO pokemon (name, nickname, item, ability, level, type1, type2," +
            " hp_evs, attack_evs, defence_evs, special_attack_evs, special_defence_evs, speed_evs," +
            " hp_ivs, attack_ivs, defence_ivs, special_attack_ivs, special_defence_ivs, speed_ivs," +
            " move1, move2, move3, move4) " +
            "VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static String selectPokemonByIdQuery = "SELECT * FROM pokemon WHERE id = ? LIMIT 1";

    private final static Logger logger = LoggerFactory.getLogger(PokemonRepository.class);
    private Connection connection;
    private PokemonFactory pokemonFactory;

    /**
     * Repository for managing creation, retrieval, and editing of Pokemon entities
     * @param dbConnectionService
     *  A database connection service, used to get the current connection to the database.
     * @param pokemonFactory
     *  A PokemonFactory for creating Pokemon objects.
     */
    public PokemonRepository(DbConnectionService dbConnectionService, PokemonFactory pokemonFactory) {
        this.connection = dbConnectionService.getConnection();
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Save a Pokemon to the database.
     * @param pokemon
     *  The Pokemon that we wish to save.
     * @return
     *  The Pokemon with its database id attached.
     */
    public Pokemon savePokemon(Pokemon pokemon) {
        try {
            PreparedStatement preparedStatement = _createSavePokemonStatement(pokemon);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating Pokemon failed, no rows affected.");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                pokemon.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Creating Pokemon failed, no ID obtained.");
            }

            return pokemon;

        } catch (SQLException e) {
            logger.error("Error with SQL Statement.", e);
            return null;
        }
    }

    /**
     * Helper function which returns a PreparedStatement for saving a Pokemon object.
     * @param pokemon
     *  The Pokemon object the PreparedStatement is being prepared for.
     * @return
     *  A PreparedStatement for saving the given Pokemon object.
     * @throws SQLException
     *  Thrown when there is a problem with creating the PreparedStatement.
     */
    private PreparedStatement _createSavePokemonStatement(Pokemon pokemon) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                savePokemonQuery, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, pokemon.getName());
        preparedStatement.setString(2, pokemon.getNickname());
        preparedStatement.setString(3, pokemon.getItem());
        preparedStatement.setString(4, pokemon.getAbility());
        preparedStatement.setInt(5, pokemon.getLevel());
        preparedStatement.setString(6, pokemon.getType1());
        preparedStatement.setString(7, pokemon.getType2());
        preparedStatement.setInt(8, pokemon.getHpEVs());
        preparedStatement.setInt(9, pokemon.getAttackEVs());
        preparedStatement.setInt(10, pokemon.getDefenceEVs());
        preparedStatement.setInt(11, pokemon.getSpecialAttackEVs());
        preparedStatement.setInt(12, pokemon.getSpecialDefenceEVs());
        preparedStatement.setInt(13, pokemon.getSpeedEVs());
        preparedStatement.setInt(14, pokemon.getHpIVs());
        preparedStatement.setInt(15, pokemon.getAttackIVs());
        preparedStatement.setInt(16, pokemon.getDefenceIVs());
        preparedStatement.setInt(17, pokemon.getSpecialAttackIVs());
        preparedStatement.setInt(18, pokemon.getSpecialDefenceIVs());
        preparedStatement.setInt(19, pokemon.getSpeedIVs());
        preparedStatement.setString(20, pokemon.getMove1());
        preparedStatement.setString(21, pokemon.getMove2());
        preparedStatement.setString(22, pokemon.getMove3());
        preparedStatement.setString(23, pokemon.getMove4());

        return preparedStatement;
    }

    /**
     * Get a pokemon from the database by its id.
     * @param id
     *  The Pokemon's id
     * @return
     *  The Pokemon with id, id, from the database.
     */
    public Pokemon getPokemonById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(selectPokemonByIdQuery);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return pokemonFactory.createPokemonFromResultSet(rs);
            } else {
                throw new SQLException("ResultSet did not contain any pokemon. Database query returned 0 results.");
            }
        } catch (SQLException e) {
            logger.error("Getting Pokemon from database failed.", e);
            return null;
        }
    }
}
