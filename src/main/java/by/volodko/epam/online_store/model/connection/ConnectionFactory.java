package by.volodko.epam.online_store.model.connection;

import by.volodko.epam.online_store.exception.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


class ConnectionFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    private static final String DB_RESOURCE = "database/db.properties";
    private static final Properties connectionProperties = new Properties();


    static {
        String driverName = "";

        try (InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream(DB_RESOURCE)) {
            connectionProperties.load(inputStream);
            driverName = (String) connectionProperties.get("driver");
            Class.forName(driverName);
            URL = (String) connectionProperties.get("url");
            USER = (String) connectionProperties.get("user");
            PASSWORD = (String) connectionProperties.get("password");
        } catch (ClassNotFoundException e) {
            logger.log(Level.ERROR, "Unable register driver: " + driverName, e);
            throw new RuntimeException("Unable register driver: " + driverName, e);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable load properties file: " + DB_RESOURCE, e);
            throw new RuntimeException("Unable load properties file:: " + DB_RESOURCE, e);
        }
    }

    private ConnectionFactory() {
    }

    static Connection getConnection() throws ConnectionPoolException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new ConnectionPoolException("Unable to connect to URL = " + URL, e);
        }
        return new ProxyConnection(connection);
    }
}





