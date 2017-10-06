package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionService{

    private final static Logger logger = LoggerFactory.getLogger(DbConnectionService.class);
    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            synchronized (DbConnectionService.class) {
                if (connection == null) {
                    try {
                        // TODO: need to add driver
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:test?" +
                                "user=minty&password=greatsqldb");
                    } catch (SQLException e) {
                        // TODO: There was an error in trying to connect to the database, make sure to log it.
                        logger.error("Failed to connect to database!", e);
                        connection = null;
                    }
                }
            }
        }
        return connection;
    }
}
