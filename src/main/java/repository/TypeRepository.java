package repository;

import data.PokemonType;
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

public class TypeRepository extends Repository {

    private final static String selectTypesByPokemonIdQuery = "SELECT * FROM pokemon_type WHERE pokemon_id = ?";

    private final static Logger logger = LoggerFactory.getLogger(TypeRepository.class);
    private final DataSource dataSource;

    public TypeRepository(DataSourceFactory dataSourceFactory) {
        this.dataSource = dataSourceFactory.getDataSource();
    }

    public List<PokemonType> saveTypes(Long pokemonId, List<String> types) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO pokemon_type (name, slot, pokemon_id) VALUES");
        for (int i = 0; i < types.size(); i++) {
            if (i == types.size() - 1) {
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

            for (int i = 0; i < types.size(); i++) {
                statement.setString(i + 1, types.get(i));
                statement.setInt(i + 2, i + 1);
                statement.setLong(i + 3, pokemonId);
            }

            logger.info("Database Call -> " + statement.toString());
            resultSet = statement.executeQuery();
            return _convertResultSetToPokemonTypes(resultSet);

        } catch (SQLException e) {
            logger.error("Error inserting types into database. Call -> saveTypes(" +
                pokemonId + ", " + types.toString() + ")", e);
            _rollbackConnection(connection, logger);
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
        }

        return new ArrayList<>();
    }

    public List<PokemonType> getTypesByPokemonId(Long pokemonId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(selectTypesByPokemonIdQuery);
            statement.setLong(1, pokemonId);

            logger.info("Database call -> " + statement.toString());
            resultSet = statement.executeQuery();
            return _convertResultSetToPokemonTypes(resultSet);
        } catch (SQLException e) {
            logger.error("Error selecting moves by pokemonId. Call -> getMovesByPokemonId(" + pokemonId + ")");
            _rollbackConnection(connection, logger);
        } finally {
            _closeIfNotNull(connection, statement, resultSet, logger);
        }

        return new ArrayList<>();
    }

    private List<PokemonType> _convertResultSetToPokemonTypes(ResultSet rs) throws SQLException {
        List<PokemonType> pokemonTypes = new ArrayList<>();
        while (rs.next()) {
            pokemonTypes.add(_convertResultSetToPokemonTypeNoNextCall(rs));
        }
        return _sortBySlot(pokemonTypes);
    }

    private PokemonType _convertResultSetToPokemonTypeNoNextCall(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        Integer slot = rs.getInt("slot");
        Long pokemonId = rs.getLong("pokemon_id");

        return new PokemonType.PokemonTypeBuilder()
                .withId(id)
                .withName(name)
                .withSlot(slot)
                .withPokemonId(pokemonId)
                .build();
    }

    private List<PokemonType> _sortBySlot(List<PokemonType> pokemonTypes) {
        pokemonTypes.sort(Comparator.comparingInt(PokemonType::getSlot));
        return pokemonTypes;
    }
}
