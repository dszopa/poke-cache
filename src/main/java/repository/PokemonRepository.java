package repository;

import data.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {

    private static final String insertPokemonQuery = "INSERT INTO pokemon (name, nickname, item, ability, level, type1, type2," +
            " hp_evs, attack_evs, defence_evs, special_attack_evs, special_defence_evs, speed_evs," +
            " hp_ivs, attack_ivs, defence_ivs, special_attack_ivs, special_defence_ivs, speed_ivs," +
            " move1, move2, move3, move4) " +
            "VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String selectPokemonByIdQuery = "SELECT * FROM pokemon WHERE id = ? LIMIT 1";

    private static final String selectPokemonByIdsQueryStart = "SELECT * FROM pokemon WHERE id IN (";

    private static final String selectPokemonByTypeQuery = "SELECT * FROM pokemon WHERE type1 = ? OR type2 = ?";

    private static final String selectPokemonByName = "SELECT * FROM pokemon WHERE name = ?";

    private final static Logger logger = LoggerFactory.getLogger(PokemonRepository.class);
    private final Connection connection;

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
            logger.error("Getting Pokemon from database by id failed.", e);
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
            logger.error("Getting Pokemon from database by ids failed.", e);
            return new ArrayList<>();
        }
    }

    /**
     * Get a list of Pokemon by type.
     * @param type
     *  The type to search by.
     * @return
     *  A list of Pokemon objects where each pokemon's primary or secondary type will be the provided type.
     */
    public List<Pokemon> getPokemonByType(String type) {
        try {
            PreparedStatement statement = connection.prepareStatement(selectPokemonByTypeQuery);
            statement.setString(1, type);
            statement.setString(2, type);
            ResultSet rs = statement.executeQuery();
            return _convertResultSetToPokemonList(rs);

        } catch (SQLException e) {
            logger.error("Getting Pokemon from database by type failed.", e);
            return new ArrayList<>();
        }
    }

    /**
     * Get a list of Pokemon by name.
     * @param name
     *  The name of Pokemon to search by.
     * @return
     *  A list of Pokemon objects where each Pokemon's name is name.
     */
    public List<Pokemon> getPokemonByName(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(selectPokemonByName);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            return _convertResultSetToPokemonList(rs);
        } catch (SQLException e) {
            logger.error("Getting Pokemon from database by type failed", e);
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
        Integer level = rs.getInt("level");
        String type1 = rs.getString("type1");
        String type2 = rs.getString("type2");
        Integer hpEVs = rs.getInt("hp_evs");
        Integer attackEVs = rs.getInt("attack_evs");
        Integer defenceEVs = rs.getInt("defence_evs");
        Integer specialAttackEVs = rs.getInt("special_attack_evs");
        Integer specialDefenceEVs = rs.getInt("special_defence_evs");
        Integer speedEVs = rs.getInt("speed_evs");
        Integer hpIVs = rs.getInt("hp_ivs");
        Integer attackIVs = rs.getInt("attack_ivs");
        Integer defenceIVs = rs.getInt("defence_ivs");
        Integer specialAttackIVs = rs.getInt("special_attack_ivs");
        Integer specialDefenceIVs = rs.getInt("special_defence_ivs");
        Integer speedIVs = rs.getInt("speed_ivs");
        String move1 = rs.getString("move1");
        String move2 = rs.getString("move2");
        String move3 = rs.getString("move3");
        String move4 = rs.getString("move4");

        return new Pokemon.PokemonBuilder()
                .withId(id)
                .withName(name)
                .withNickname(nickname)
                .withItem(item)
                .withAbility(ability)
                .withLevel(level)
                .withType1(type1)
                .withType2(type2)
                .withHpEVs(hpEVs)
                .withAttackEVs(attackEVs)
                .withDefenceEVs(defenceEVs)
                .withSpecialAttackEVs(specialAttackEVs)
                .withSpecialDefenceEVs(specialDefenceEVs)
                .withSpeedEVs(speedEVs)
                .withHpIVs(hpIVs)
                .withAttackIVs(attackIVs)
                .withDefenceIVs(defenceIVs)
                .withSpecialAttackIVs(specialAttackIVs)
                .withSpecialDefenceIVs(specialDefenceIVs)
                .withSpeedIVs(speedIVs)
                .withMove1(move1)
                .withMove2(move2)
                .withMove3(move3)
                .withMove4(move4)
                .build();
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
