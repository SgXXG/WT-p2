package by.bsuir.lab4.repository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsuir.lab4.entity.Entity;
import by.bsuir.lab4.exception.RepositoryException;

import java.sql.*;

public abstract class DbAbstractRepository<T extends Entity> implements Repository<T> {

    private static Logger log = LogManager.getLogger("repository");

    protected Connection connection;

    public PreparedStatement preparedStatement(String sql) throws RepositoryException {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            log.error("Can't create statement", e);
            throw new RepositoryException(e);
        }
        return ps;
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                log.error("Can't close statement");
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                log.error("Can't close ResultSet");
            }
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Can't close connection");

            }
        }
    }
}
