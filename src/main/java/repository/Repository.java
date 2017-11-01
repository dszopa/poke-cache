package repository;

import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Repository {

    /**
     * Close the given objects so that the ConnectionPool works properly.
     * @param connection
     *  A Connection object to close.
     * @param statement
     *  A Statement object to close.
     * @param resultSet
     *  A ResultSet object to close.
     * @param logger
     *  A Logger object used to log if there is an error.
     */
    protected void _closeIfNotNull(Connection connection, Statement statement, ResultSet resultSet, Logger logger) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            logger.error("Unable to close connection properly.", e);
        }
    }
}
