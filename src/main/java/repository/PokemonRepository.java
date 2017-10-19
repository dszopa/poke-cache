package repository;

import data.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {

    private static String insertPokemonQuery = "INSERT INTO pokemon (name, nickname, item, ability, level, type1, type2," +
            " hp_evs, attack_evs, defence_evs, special_attack_evs, special_defence_evs, speed_evs," +
            " hp_ivs, attack_ivs, defence_ivs, special_attack_ivs, special_defence_ivs, speed_ivs," +
            " move1, move2, move3, move4) " +
            "VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static String selectPokemonByIdQuery = "SELECT * FROM pokemon WHERE id = ? LIMIT 1";

    private static String selectPokemonByIdsQueryStart = "SELECT * FROM pokemon_team WHERE id IN (";

    private final static Logger logger = LoggerFactory.getLogger(PokemonRepository.class);
    private Connection connection;

    /**
     * Repository for managing creation, retrieval, and editing of Pokemon entities
     * @param dbConnectionService
     *  A database connection service, used to get the current connection to the database.
     */
    public PokemonRepository(DbConnectionService dbConnectionService) {
        this.connection = dbConnectionService.getConnection();
    }

    /**
     * Save a Pokemon to the database.
     * @param pokemon
     *  The Pokemon that will be saved.
     * @return
     *  The Pokemon with its new database id attached.
     */
    public Pokemon savePokemon(Pokemon pokemon) {
        try {
            PreparedStatement preparedStatement = _createInsertPokemonStatement(pokemon);

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
     * Get a Pokemon from the database by its id.
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
                return _convertResultSetToPokemon(rs);
            } else {
                throw new SQLException("ResultSet did not contain any Pokemon. Database query returned 0 results.");
            }
        } catch (SQLException e) {
            logger.error("Getting Pokemon from database failed.", e);
            return null;
        }
    }

    /**
     * Get a list of Pokemon by ids
     * @param ids
     *  The ids to get the list of Pokemon by
     * @return
     *  A list of Pokemon objects.
     */
    public List<Pokemon> getPokemonByIds(List<Long> ids) {
        try {
            PreparedStatement statement = _createSelectPokemonByIdsStatement(ids);
            ResultSet rs = statement.executeQuery();
            return _convertResultSetToPokemonList(rs);
        } catch (SQLException e) {
            logger.error("Getting Pokemon from database failed.", e);
            return new ArrayList<>();
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
    private PreparedStatement _createInsertPokemonStatement(Pokemon pokemon) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                insertPokemonQuery, Statement.RETURN_GENERATED_KEYS);

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
     * Helper function which returns a PreparedStatement for selecting
     * @param ids
     *  The list of ids the PreparedStatement is being prepared for.
     * @return
     *  A PreparedStatement for selecting Pokemon from the database.
     * @throws SQLException
     *  Thrown when there is a problem with creating the PreparedStatement.
     */
    private PreparedStatement _createSelectPokemonByIdsStatement(List<Long> ids) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(selectPokemonByIdsQueryStart);

        for (int i = 0; i < ids.size(); i++) {
            stringBuilder.append(ids.get(i).toString());
            if (i == ids.size() - 1) {
                stringBuilder.append(")");
            } else {
                stringBuilder.append(", ");
            }
        }
        return connection.prepareStatement(stringBuilder.toString());
    }

    /**
     * Helper function to convert a ResultSet to a Pokemon object.
     * @param rs
     *  The ResultSet the Pokemon object will be made from.
     * @return
     *  The created Pokemon object.
     * @throws SQLException
     *  Thrown when there is a problem converting the ResultSet to a Pokemon object.
     */
    private Pokemon _convertResultSetToPokemon(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String nickname = rs.getString("nickname");
        String item = rs.getString("item");
        String ability = rs.getString("ability");
        int level = rs.getInt("level");
        String type1 = rs.getString("type1");
        String type2 = rs.getString("type2");
        int hpEVs = rs.getInt("hp_evs");
        int attackEVs = rs.getInt("attack_evs");
        int defenceEVs = rs.getInt("defence_evs");
        int specialAttackEVs = rs.getInt("special_attack_evs");
        int specialDefenceEVs = rs.getInt("special_defence_evs");
        int speedEVs = rs.getInt("speed_evs");
        int hpIVs = rs.getInt("hp_ivs");
        int attackIVs = rs.getInt("attack_ivs");
        int defenceIVs = rs.getInt("defence_ivs");
        int specialAttackIVs = rs.getInt("special_attack_ivs");
        int specialDefenceIVs = rs.getInt("special_defence_ivs");
        int speedIVs = rs.getInt("speed_ivs");
        String move1 = rs.getString("move1");
        String move2 = rs.getString("move2");
        String move3 = rs.getString("move3");
        String move4 = rs.getString("move4");

        return new Pokemon(id, name, nickname, item, ability, level, type1, type2,
                hpEVs, attackEVs, defenceEVs, specialAttackEVs, specialDefenceEVs, speedEVs,
                hpIVs, attackIVs, defenceIVs, specialAttackIVs, specialDefenceIVs, speedIVs,
                move1, move2, move3, move4);
    }

    /**
     * Helper function to convert a ResultSet to a list of Pokemon.
     * @param rs
     *  The ResultSet that will be converted.
     * @return
     *  The created list of Pokemon
     * @throws SQLException
     *  Thrown when there is a problem converting the ResultSet to a list of Pokemon.
     */
    private List<Pokemon> _convertResultSetToPokemonList(ResultSet rs) throws SQLException {
        List<Pokemon> pokemonList = new ArrayList<>();
        while (rs.next()) {
            pokemonList.add(_convertResultSetToPokemon(rs));
        }
        return pokemonList;
    }
}
