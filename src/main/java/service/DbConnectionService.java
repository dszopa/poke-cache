package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionService{

    private final static Logger logger = LoggerFactory.getLogger(DbConnectionService.class);
    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            synchronized (DbConnectionService.class) {
                if (connection == null) {

                    Properties properties = new Properties();
                    InputStream inputStream = null;

                    try {
                        inputStream = DbConnectionService.class.getResourceAsStream("/config.properties");
                        properties.load(inputStream);

                        String url = properties.getProperty("database.url");
                        String username = properties.getProperty("database.username");
                        String password = properties.getProperty("database.password");
                        String connectionString = "jdbc:mysql://" + url + "?user=" + username + "&password=" + password;

                        try {
                            // Load Driver
                            Class.forName("com.mysql.jdbc.Driver");
                            connection = DriverManager.getConnection(connectionString);
                        } catch (SQLException | ClassNotFoundException e) {
                            logger.error("Failed to connect to database!", e);
                        }
                    } catch (Exception e) {
                        logger.error("Failed to load \"config.properties\".", e);
                    } finally {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                logger.error("Failed to close input stream.", e);
                            }
                        }
                    }
                }
            }
        }
        return connection;
    }
}
