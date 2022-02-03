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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();
    private static final String RESOURCE = "database/pool.properties";
    private final static int DEFAULT_POOL_SIZE = 32;

    private static ConnectionPool instance;
    private static AtomicBoolean isInstanceHas = new AtomicBoolean();
    private static ReentrantLock lock = new ReentrantLock(true);

    private BlockingQueue<ProxyConnection> freeConnections;
    private BlockingQueue<ProxyConnection> usedConnections;
    private int poolSize;

    private ConnectionPool() {
        Properties properties = new Properties();
        try (InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream(RESOURCE)) {
            properties.load(inputStream);
           Object propertiesPoolSize = properties.get("poolsize");
            poolSize = propertiesPoolSize != null ? Integer.parseInt((String) propertiesPoolSize) : DEFAULT_POOL_SIZE;
            freeConnections = new LinkedBlockingDeque<>(poolSize);
            usedConnections = new LinkedBlockingDeque<>();
            for (int i = 0; i < poolSize; i++) {
                ProxyConnection proxyConnection = (ProxyConnection) ConnectionFactory.getConnection();
                freeConnections.add(proxyConnection);
            }
        } catch (IOException e) {
            logger.log(Level.WARN, "IO Exception: ", e);

        } catch (ConnectionPoolException e) {
            logger.log(Level.ERROR, "Unable to create connection", e);
        }
        if (freeConnections.isEmpty()) {
            logger.log(Level.ERROR, "Unable to create connection, connection pool is empty");
            throw new RuntimeException("Unable to create connection, connection pool is empty");
        }

    }

    public static ConnectionPool getInstance() {
        if (!isInstanceHas.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                    isInstanceHas.getAndSet(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.log(Level.ERROR, "The current thread is interrupted: ", e);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection.getClass() == ProxyConnection.class && usedConnections.remove(connection)) {
            try {
                freeConnections.put((ProxyConnection) connection);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.log(Level.ERROR, "The current thread is interrupted: ", e);
            }

        } else {
            logger.log(Level.ERROR, "Wrong connection detected");
            throw new RuntimeException("Wrong connection detected");
        }
    }

    public void destroyPool() {
        for (int i = 0; i < poolSize; i++) {
            try {
                freeConnections.take().fullCloseConnection();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.log(Level.ERROR, "The current thread is interrupted: ", e);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Exception in method of closing connection", e);
            }
            deregisterDrivers();
        }

    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Driver deregistration exception", e);
            }
        });

    }

}
