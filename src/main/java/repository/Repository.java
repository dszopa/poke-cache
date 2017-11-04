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

    /**
     * Rollback what has happened to the database during the connection if possible.
     * @param connection
     *  The database connection to rollback.
     * @param logger
     *  A Logger from the implementing class to log the rollback process.
     */
    protected void _rollbackConnection(Connection connection, Logger logger) {
        if (connection != null) {
            try {
                logger.info("Attempting to rollback connection...");
                connection.rollback();
                logger.info("Connection rollback successful.");
            } catch (SQLException e) {
                logger.error("Failed to rollback connection.", e);
            }
        }
    }
}
