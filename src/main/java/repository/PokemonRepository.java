package repository;

import data.Pokemon;
import service.DbConnectionService;

import java.sql.*;

public class PokemonRepository {

    private Connection connection;

    public PokemonRepository(DbConnectionService dbConnectionService) {
        this.connection = dbConnectionService.getConnection();
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
            String query = "INSERT INTO pokemon (name, nickname, item, ability, level, type1, type2, hp, attack, defence, " +
                    "special_attack, special_defence, speed, move1, move2, move3, move4) " +
                    "VALUES " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pokemon.getName());
            preparedStatement.setString(2, pokemon.getNickname());
            preparedStatement.setString(3, pokemon.getItem());
            preparedStatement.setString(4, pokemon.getAbility());
            preparedStatement.setInt(5, pokemon.getLevel());
            preparedStatement.setString(6, pokemon.getType1());
            preparedStatement.setString(7, pokemon.getType2());
            preparedStatement.setInt(8, pokemon.getHp());
            preparedStatement.setInt(9, pokemon.getAttack());
            preparedStatement.setInt(10, pokemon.getDefence());
            preparedStatement.setInt(11, pokemon.getSpecialAttack());
            preparedStatement.setInt(12, pokemon.getSpecialDefence());
            preparedStatement.setInt(13, pokemon.getSpeed());
            preparedStatement.setString(14, pokemon.getMove1());
            preparedStatement.setString(14, pokemon.getMove2());
            preparedStatement.setString(14, pokemon.getMove3());
            preparedStatement.setString(14, pokemon.getMove4());

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
            return null;
        }
    }

    // TODO:
    public Pokemon getPokemonById(Long id) {
        return null;
    }
}
