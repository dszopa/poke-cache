package factory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceFactory {

    private final static Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);
    private static DataSource dataSource = null;

    /**
     * Returns a DataSource object which manages connections to the database.
     * @return
     *  A DataSource object which manages connections to the database.
     */
    public DataSource getDataSource() {
            if (dataSource == null) {
                synchronized (DataSourceFactory.class) {
                    Properties properties = new Properties();
                    InputStream inputStream = null;

                    try {
                        inputStream = DataSourceFactory.class.getResourceAsStream("/config.properties");
                        properties.load(inputStream);

                        String url = properties.getProperty("database.url");
                        String username = properties.getProperty("database.username");
                        String password = properties.getProperty("database.password");
                        String connectionString = "jdbc:mysql://" + url;

                        BasicDataSource ds = new BasicDataSource();
                        ds.setUrl(connectionString);
                        ds.setUsername(username);
                        ds.setPassword(password);
                        ds.setDriverClassName("com.mysql.jdbc.Driver");
                        ds.setDefaultAutoCommit(false);

                        ds.setTestOnBorrow(true);
                        ds.setLogAbandoned(true);
                        ds.setValidationQuery("select 1 as dbcp_connection_test");

//                        These settings can make it easy to debug connection problems
//                        ds.setRemoveAbandonedTimeout(2);
//                        ds.setRemoveAbandonedOnBorrow(true);
//                        ds.setRemoveAbandonedOnMaintenance(true);

                        dataSource = ds;
                    } catch (IOException e) {
                        logger.error("Unable to load config.properties.", e);
                    } finally {
                        try {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (IOException e) {
                            logger.error("Failed to close input stream.", e);
                        }
                    }
                }
            }
        return dataSource;
    }
}
