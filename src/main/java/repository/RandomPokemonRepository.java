package repository;

import data.RandomPokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DbConnectionService;

import java.sql.*;

public class RandomPokemonRepository {

    private static final String saveRandomPokemonQuery = "INSERT INTO random_pokemon (name, nickname, item, ability, level, " +
            "type1, type2, hp, attack, defence, special_attack, special_defence, speed, move1, move2, move3, move4) " +
            "VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String selectRandomPokemonByIdQuery = "SELECT * FROM random_pokemon where id = ? LIMIT 1";

    private final static Logger logger = LoggerFactory.getLogger(RandomPokemonRepository.class);
    private final Connection connection;

    /**
     * Repository for managing creation, retrieval, and editing of RandomPokemon entities.
     * @param dbConnectionService
     *  A database connection service, used to get the current connection to the database.
     */
    public RandomPokemonRepository(DbConnectionService dbConnectionService) {
        this.connection = dbConnectionService.getConnection();
    }

    /**
     * Save a RandomPokemon to the database.
     * @param randomPokemon
     *  The RandomPokemon that will be saved.
     * @return
     *  The RandomPokemon with its new database id attached.
     */
    public RandomPokemon saveRandomPokemon(RandomPokemon randomPokemon) {
        try {
            PreparedStatement preparedStatement = _createSaveRandomPokemonStatement(randomPokemon);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating RandomPokemon failed, no rows affected.");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                randomPokemon.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Creating RandomPokemon failed, no ID obtained.");
            }

            return randomPokemon;

        } catch (SQLException e) {
            logger.error("Error with SQL Statement.", e);
            return null;
        }
    }

    /**
     * Get a RandomPokemon from the database by its id.
     * @param id
     *  The RandomPokemon's id.
     * @return
     *  The RandomPokemon with id, id, from the database.
     */
    public RandomPokemon getRandomPokemonById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(selectRandomPokemonByIdQuery);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            return _convertResultSetToRandomPokemon(rs);
        } catch (SQLException e) {
            logger.error("Getting RandomPokemon from database failed.", e);
            return null;
        }
    }

    /**
     * Helper function which returns a PreparedStatement for saving a RandomPokemon object.
     * @param randomPokemon
     *  The RandomPokemon object the PreparedStatement is being prepared for.
     * @return
     *  A PreparedStatement for saving the given RandomPokemon object.
     * @throws SQLException
     *  Thrown when there is a problem creating the PreparedStatement.
     */
    private PreparedStatement _createSaveRandomPokemonStatement(RandomPokemon randomPokemon) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                saveRandomPokemonQuery, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, randomPokemon.getName());
        preparedStatement.setString(2, randomPokemon.getNickname());
        preparedStatement.setString(3, randomPokemon.getItem());
        preparedStatement.setString(4, randomPokemon.getAbility());
        preparedStatement.setInt(5, randomPokemon.getLevel());
        preparedStatement.setString(6, randomPokemon.getType1());
        preparedStatement.setString(7, randomPokemon.getType2());
        preparedStatement.setInt(8, randomPokemon.getHp());
        preparedStatement.setInt(9, randomPokemon.getAttack());
        preparedStatement.setInt(10, randomPokemon.getDefence());
        preparedStatement.setInt(11, randomPokemon.getSpecialAttack());
        preparedStatement.setInt(12, randomPokemon.getSpecialDefence());
        preparedStatement.setInt(13, randomPokemon.getSpeed());
        preparedStatement.setString(14, randomPokemon.getMove1());
        preparedStatement.setString(15, randomPokemon.getMove2());
        preparedStatement.setString(16, randomPokemon.getMove3());
        preparedStatement.setString(17, randomPokemon.getMove4());

        return preparedStatement;
    }

    /**
     * Helper function to convert a ResultSet to a RandomPokemon object.
     * @param rs
     *  The ResultSet the RandomPokemon object will be made from.
     * @return
     *  The created RandomPokemon object.
     * @throws SQLException
     *  Thrown when there is a problem converting the ResultSet to a RandomPokemon object.
     */
    private RandomPokemon _convertResultSetToRandomPokemon(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String nickname = rs.getString("nickname");
        String item = rs.getString("item");
        String ability = rs.getString("ability");
        Integer level = rs.getInt("level");
        String type1 = rs.getString("type1");
        String type2 = rs.getString("type2");
        Integer hp = rs.getInt("hp");
        Integer attack = rs.getInt("attack");
        Integer defence = rs.getInt("defence");
        Integer specialAttack = rs.getInt("special_attack");
        Integer specialDefence = rs.getInt("special_defence");
        Integer speed = rs.getInt("speed");
        String move1 = rs.getString("move1");
        String move2 = rs.getString("move2");
        String move3 = rs.getString("move3");
        String move4 = rs.getString("move4");

        return new RandomPokemon(id, name, nickname, item, ability, level, type1, type2,
                hp, attack, defence, specialAttack, specialDefence, speed,
                move1, move2, move3, move4);
    }
}
