package repository;

import data.PokemonMove;
import factory.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoveRepository extends Repository {

    private final static String selectMovesByPokemonIdQuery = "SELECT * FROM pokemon_move WHERE pokemon_id = ?";

    private final static Logger logger = LoggerFactory.getLogger(MoveRepository.class);
    private final DataSource dataSource;

    public MoveRepository(DataSourceFactory dataSourceFactory) {
        this.dataSource = dataSourceFactory.getDataSource();
    }

    public List<String> saveMoves(Long pokemonId, List<String> moves) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO pokemon_move (name, slot, pokemon_id) VALUES");
        for (int i = 0; i < moves.size(); i++) {
            if (i == moves.size() - 1) {
                stringBuilder.append(" (?, ?, ?)");
            } else {
                stringBuilder.append(" (?, ?, ?),");
            }
        }

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(stringBuilder.toString());

            for (int i = 0; i < moves.size(); i++) {
                statement.setString((3 * i) + 1, moves.get(i));
                statement.setInt((3 * i) + 2, i + 1);
                statement.setLong((3 * i) + 3, pokemonId);
            }

            logger.info("Database Call -> " + statement.toString());
            int affectedRows = statement.executeUpdate();
            connection.commit();

            if (affectedRows == 0) {
                throw new SQLException("No rows were effected by SQL insert!");
            }

            return moves;

        } catch (SQLException e) {
            logger.error("Error inserting moves into database. Call -> saveMoves(" +
                pokemonId + ", " + moves.toString() + ")", e);
            _rollbackConnection(connection, logger);
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
        }

        return new ArrayList<>();
    }

    public List<PokemonMove> getMovesByPokemonId(Long pokemonId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(selectMovesByPokemonIdQuery);
            statement.setLong(1, pokemonId);

            logger.info("Database call -> " + statement.toString());
            resultSet = statement.executeQuery();
            connection.commit();
            return _convertResultSetToPokemonMoves(resultSet);
        } catch (SQLException e) {
            logger.error("Error selecting moves by pokemonId. Call -> getMovesByPokemonId(" + pokemonId + ")");
            _rollbackConnection(connection, logger);
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
        }

        return new ArrayList<>();
    }

    private List<PokemonMove> _convertResultSetToPokemonMoves(ResultSet rs) throws SQLException {
        List<PokemonMove> pokemonMoves = new ArrayList<>();
        while (rs.next()) {
            pokemonMoves.add(_convertResultSetToPokemonMoveNoNextCall(rs));
        }
        return _sortBySlot(pokemonMoves);
    }

    private PokemonMove _convertResultSetToPokemonMoveNoNextCall(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        Integer slot = rs.getInt("slot");
        Long pokemonId = rs.getLong("pokemon_id");

        return new PokemonMove.PokemonMoveBuilder()
                .withId(id)
                .withName(name)
                .withSlot(slot)
                .withPokemonId(pokemonId)
                .build();
    }

    private List<PokemonMove> _sortBySlot(List<PokemonMove> pokemonMoves) {
        pokemonMoves.sort(Comparator.comparingInt(PokemonMove::getSlot));
        return pokemonMoves;
    }
}
