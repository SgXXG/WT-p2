package by.bsuir.lab4.connection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsuir.lab4.exception.ConnectionPoolException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static Logger log = LogManager.getLogger("connection");

    private static ConnectionPool instance;
    private BlockingQueue<ProxyConnection> availableConnections;
    private List<ProxyConnection> usedConnections;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean isCreated = new AtomicBoolean(false);
    private static ConnectionProperties connectionProperties = ConnectionProperties.getInstance();
    private int poolSize = connectionProperties.getDbPoolSize();

    private ConnectionPool() {
        registerDriver(connectionProperties.getDbDriver());
        init();
    }

    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    isCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    private void init() {
        availableConnections = new LinkedBlockingQueue<>(poolSize);
        usedConnections = new ArrayList<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            availableConnections.add(ConnectionPool.createConnection());
            log.debug("Connection pool initialized");
        }
    }

    private static ProxyConnection createConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getDbUser(),
                    connectionProperties.getDbPass());
        } catch (SQLException e) {
            log.fatal("Can't create database connection", e);
            throw new RuntimeException(e);
        }
        return new ProxyConnection(connection);
    }

    public Connection takeConnection() throws InterruptedException {
        ProxyConnection connection;
        connection = availableConnections.take();
        usedConnections.add(connection);
        log.debug("Connection taken");
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection instanceof ProxyConnection) {
            ProxyConnection proxyConnection = (ProxyConnection) connection;
            availableConnections.add(proxyConnection);
            usedConnections.remove(connection);
            log.debug("Connection released");
        }
    }

    public void closePool() throws ConnectionPoolException {
        for (int i = 0; i < connectionProperties.getDbPoolSize(); i++) {
            ProxyConnection proxyConnection = null;
            try {
                proxyConnection = availableConnections.take();
                proxyConnection.realClose();
            } catch (SQLException | InterruptedException e) {
                throw new ConnectionPoolException(e);
            }
        }
    }

    public static void registerDriver(String driverName) {
        if (driverName != null) {
            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException e) {
                log.fatal("Driver registration error", e);
                throw new RuntimeException("Driver registration failed", e);
            }
        }
    }
}
