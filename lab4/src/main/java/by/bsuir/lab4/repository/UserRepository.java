package by.bsuir.lab4.repository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsuir.lab4.connection.ConnectionPool;
import by.bsuir.lab4.entity.User;
import by.bsuir.lab4.exception.RepositoryException;
import by.bsuir.lab4.specification.Specification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends DbAbstractRepository<User> {

    private static Logger log = LogManager.getLogger("repository");

    private static final String ADD_USER = "INSERT INTO user(login, password, email,"
            + " first_name, last_name, phone_number, country, birthday, isAdmin) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_USER = "UPDATE user "
            + "SET login = ?, password = ?, email = ?, first_name = ?, last_name = ?, phone_number = ?, "
            + "country = ?, birthday = ?, isAdmin = ? " + "WHERE login = ?;";

    @Override
    public boolean add(User user) throws RepositoryException {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = preparedStatement(ADD_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getCountry());
            preparedStatement.setString(8, user.getBirthday().toString());
            preparedStatement.setBoolean(9, user.isAdmin());

            preparedStatement.executeUpdate();
            log.debug(user + "was added successfully to database");
            return true;
        } catch (InterruptedException | SQLException e) {
            log.error("Can't add to UserRepository", e);
            throw new RepositoryException(e);
        } finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    @Override
    public boolean remove(User user) {
        return false;
    }

    @Override
    public boolean update(User user) throws RepositoryException {
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = preparedStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getCountry());
            preparedStatement.setString(8, user.getBirthday().toString());
            preparedStatement.setBoolean(9, user.isAdmin());
            preparedStatement.setString(10, user.getLogin());
            preparedStatement.executeUpdate();
            log.debug(user + "was updated successfully");
            return true;
        } catch (InterruptedException | SQLException e) {
            log.error("Can't update user", e);
            throw new RepositoryException(e);
        } finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }

    }

    @Override
    public List<User> query(Specification specification) throws RepositoryException {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = ConnectionPool.getInstance().takeConnection();
            preparedStatement = specification.specify(connection);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String login = resultSet.getString(1);
                String password = resultSet.getString(2);
                String email = resultSet.getString(3);
                String first_name = resultSet.getString(4);
                String last_name = resultSet.getString(5);
                String phone_number = resultSet.getString(6);
                String country = resultSet.getString(7);
                LocalDate birthday = LocalDate.parse(resultSet.getString(8));
                boolean isAdmin = Boolean.parseBoolean(resultSet.getString(9));
                User user = new User(login, password, first_name, last_name, email, country, phone_number, birthday,
                        isAdmin);
                users.add(user);
            }
        } catch (SQLException | InterruptedException e) {
            log.error("Error in execution query UserRepository", e);
            throw new RepositoryException(e);
        } finally {
            closeResultSet(resultSet);
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
        return users;
    }
}
