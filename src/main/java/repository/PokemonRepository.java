package repository;

import data.Pokemon;
import factory.DataSourceFactory;
import constant.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonRepository extends Repository {

    private static final String selectPokemonByIdQuery = "SELECT * FROM pokemon WHERE id = ?";
    private static final String insertPokemonQuery = "INSERT INTO pokemon (name, nickname, item, ability, level, gender," +
            " shiny, nature, happiness, hp_evs, attack_evs, defence_evs, special_attack_evs, special_defence_evs," +
            " speed_evs, hp_ivs, attack_ivs, defence_ivs, special_attack_ivs, special_defence_ivs, speed_ivs)" +
            " VALUES" +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final static Logger logger = LoggerFactory.getLogger(PokemonRepository.class);
    private final DataSource dataSource;

    /**
     * Repository for managing creation, retrieval, and editing of Pokemon entities
     * @param dataSourceFactory
     *  A factory for getting a DataSource object that manages database connections.
     */
    public PokemonRepository(DataSourceFactory dataSourceFactory) {
        this.dataSource = dataSourceFactory.getDataSource();
    }

    /**
     * Gets a Pokemon list with each pokemon matching the given parameters.
     * @param ids
     *  A list of Long ids used to specify Pokemon id.
     * @param type
     *  A Type object, used to specify Pokemon type1 or type 2.
     * @param name
     *  A String object, used to specify Pokemon name.
     * @return
     *  A list of Pokemon matching the given parameters.
     */
    public List<Pokemon> getPokemon(List<Long> ids, Type type, String name) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM pokemon");

        if ((ids != null && !ids.isEmpty()) || type != null || name != null) {
            stringBuilder.append(" WHERE");
        }

        int idsIndexStart = 0;
        int idsIndexEnd = 0;
        int typeIndex = 0;
        int nameIndex = 0;
        int count = 0;

        if (ids != null && !ids.isEmpty()) {
            idsIndexStart = count;
            stringBuilder.append(" id IN (");
            for (int i = 0; i < ids.size(); i++) {
                if (i == ids.size() -1) {
                    stringBuilder.append(" ?");
                } else {
                    stringBuilder.append(" ?,");
                }
                count++;
            }
            stringBuilder.append(" )");
            idsIndexEnd = count;
        }
        if (type != null) {
            if (count >= 1) {
                stringBuilder.append(" AND");
            }
            // No need to UPPER ?'s, type.value can never be lowercase.
            stringBuilder.append(" ( UPPER(type1) = ? OR UPPER(type2) = ?)"); // TODO: need to update
            count++;
            typeIndex = count;
            count++;
        }
        if (name != null) {
            if (count >= 1) {
                stringBuilder.append(" AND");
            }
            stringBuilder.append(" UPPER(name) = UPPER(?)");
            count++;
            nameIndex = count;
        }

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(stringBuilder.toString());

            if (ids != null && !ids.isEmpty()) {
                for (int i = idsIndexStart; i < idsIndexEnd; i++) {
                    statement.setLong(i + 1, ids.get(i - idsIndexStart));
                }
            }
            if (type != null) {
                statement.setString(typeIndex, type.name());
                statement.setString(typeIndex + 1, type.name());
            }
            if (name != null) {
                statement.setString(nameIndex, name);
            }

            logger.info("Database Call -> " + statement.toString());
            resultSet = statement.executeQuery();
            connection.commit();
            return _convertResultSetToPokemonList(resultSet);

        } catch (SQLException e) {
            logger.error("Error querying for Pokemon from database. Call -> getPokemon(" + ids + ", "
                    + type + ", " + name + ")", e);
            _rollbackConnection(connection, logger);
            return new ArrayList<>();
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
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
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(selectPokemonByIdQuery);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            connection.commit();
            return _convertResultSetToPokemon(resultSet);
        } catch (SQLException e) {
            logger.error("Getting Pokemon from database by id failed. Call -> getPokemonById(" + id + ")", e);
            _rollbackConnection(connection, logger);
            return null;
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
        }
    }

    /**
     * Save a Pokemon to the database.
     * @param pokemon
     *  The Pokemon that will be saved.
     * @return
     *  The Pokemon with its new database id attached.
     */
    public Pokemon savePokemon(Pokemon pokemon) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = _createInsertPokemonStatement(pokemon, connection);

            int affectedRows = statement.executeUpdate();
            connection.commit();
            if (affectedRows == 0) {
                throw new SQLException("Creating Pokemon failed, no rows affected.");
            }

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                pokemon.setId(resultSet.getLong(1));
            } else {
                throw new SQLException("Creating Pokemon failed, no ID obtained.");
            }

            return pokemon;
        } catch (SQLException e) {
            logger.error("Error with SQL Statement. Call -> savePokemon(" + pokemon.toString() + ")", e);
            _rollbackConnection(connection, logger);
            return null;
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
        }
    }

    /**
     * Helper function which returns a PreparedStatement for saving a Pokemon object.
     * @param pokemon
     *  The Pokemon object the PreparedStatement is being prepared for.
     * @param connection
     *  The Connection object used to create the statement.
     * @return
     *  A PreparedStatement for saving the given Pokemon object.
     * @throws SQLException
     *  Thrown when there is a problem with creating the PreparedStatement.
     */
    private PreparedStatement _createInsertPokemonStatement(Pokemon pokemon, Connection connection)
            throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                insertPokemonQuery, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, pokemon.getName());
        preparedStatement.setString(2, pokemon.getNickname());
        preparedStatement.setString(3, pokemon.getItem());
        preparedStatement.setString(4, pokemon.getAbility());
        preparedStatement.setInt(5, pokemon.getLevel());
        preparedStatement.setString(6, pokemon.getGender());
        preparedStatement.setBoolean(7, pokemon.getShiny());
        preparedStatement.setString(8, pokemon.getNature());
        preparedStatement.setInt(9, pokemon.getHappiness());
        preparedStatement.setInt(10, pokemon.getHpEVs());
        preparedStatement.setInt(11, pokemon.getAttackEVs());
        preparedStatement.setInt(12, pokemon.getDefenceEVs());
        preparedStatement.setInt(13, pokemon.getSpecialAttackEVs());
        preparedStatement.setInt(14, pokemon.getSpecialDefenceEVs());
        preparedStatement.setInt(15, pokemon.getSpeedEVs());
        preparedStatement.setInt(16, pokemon.getHpIVs());
        preparedStatement.setInt(17, pokemon.getAttackIVs());
        preparedStatement.setInt(18, pokemon.getDefenceIVs());
        preparedStatement.setInt(19, pokemon.getSpecialAttackIVs());
        preparedStatement.setInt(20, pokemon.getSpecialDefenceIVs());
        preparedStatement.setInt(21, pokemon.getSpeedIVs());

        return preparedStatement;
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
            pokemonList.add(_convertResultSetToPokemonNoNextCall(rs));
        }
        return pokemonList;
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
        if (rs.next()) {
            return _convertResultSetToPokemonNoNextCall(rs);
        } else {
            return null;
        }
    }

    /**
     * Helper function which contains the actual logic to convert a ResultSet to a Pokemon object.
     * Does not call rs.next()
     * @param rs
     *  The ResultSet the Pokemon object will be made from.
     * @return
     *  The created Pokemon object.
     * @throws SQLException
     *  Thrown when there is a problem converting the ResultSet to a Pokemon object.
     */
    private Pokemon _convertResultSetToPokemonNoNextCall(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String nickname = rs.getString("nickname");
        String item = rs.getString("item");
        String ability = rs.getString("ability");
        Integer level = rs.getInt("level");
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

        return new Pokemon.PokemonBuilder()
                .withId(id)
                .withName(name)
                .withNickname(nickname)
                .withItem(item)
                .withAbility(ability)
                .withLevel(level)
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
                .build();
    }
}
