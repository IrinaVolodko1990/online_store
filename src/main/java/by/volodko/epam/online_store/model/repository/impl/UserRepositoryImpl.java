package by.volodko.epam.online_store.model.repository.impl;

import by.volodko.epam.online_store.exception.RepositoryException;
import by.volodko.epam.online_store.model.connection.ConnectionPool;
import by.volodko.epam.online_store.model.entity.Role;
import by.volodko.epam.online_store.model.entity.Status;
import by.volodko.epam.online_store.model.entity.User;
import by.volodko.epam.online_store.model.entity.UserDiscount;
import by.volodko.epam.online_store.model.repository.Repository;
import by.volodko.epam.online_store.model.repository.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.volodko.epam.online_store.model.repository.ColumnName.*;

public class UserRepositoryImpl implements Repository<User> {
    private static final Logger logger = LogManager.getLogger();
    private static final String ADD_USER_QUERY = "INSERT INTO users (login,password, name, surname, email, " +
            "phone_number, user_status_id, user_role_id, discount_id, birhtday_date)" +
            " VALUES (?,?,?,?,?,?,(SELECT id FROM users_status WHERE status_description = ?)," +
            "(SELECT id FROM users_roles WHERE role_description = ?),(SELECT id FROM users_discounts WHERE discount = ?), ?);";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET login=?,password=?, name=?, surname=?, email=?, phone_number=?," +
            "user_status_id = (SELECT id FROM users_status WHERE status_description = ?), " +
            "user_role_id = (SELECT id FROM users_roles WHERE role_description = ?)," +
            "discount_id = (SELECT id FROM users_discounts WHERE discount = ?),birhtday_date=? WHERE id=?";
    private static UserRepositoryImpl instance;

    private UserRepositoryImpl() {
    }

    public static UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }


    @Override
    public void insert(User user) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_QUERY);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSurname());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getStatus().getValue());
            preparedStatement.setString(8, user.getRole().getValue());
            preparedStatement.setString(9, user.getDiscount().getValue());
            preparedStatement.setString(10, user.getBirthdayDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Can't create query. Exception: ", e);
            throw new RepositoryException("Can't create query. Exception: ", e);
        }

    }

    @Override
    public void update(User user) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSurname());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getStatus().getValue());
            preparedStatement.setString(8, user.getRole().getValue());
            preparedStatement.setString(9, user.getDiscount().getValue());
            preparedStatement.setString(10, user.getBirthdayDate());
            preparedStatement.setLong(11, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Can't create query. Exception: ", e);
            throw new RepositoryException("Can't create query. Exception: ", e);
        }

    }

    @Override
    public List<User> query(Specification specification) throws RepositoryException {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement = (PreparedStatement) specification.getStatement();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User.UserBuilder()
                        .setId(resultSet.getLong(USER_ID))
                        .setLogin(resultSet.getString(USER_LOGIN))
                        .setPassword(resultSet.getString(USER_PASSWORD))
                        .setName(resultSet.getString(USER_NAME))
                        .setSureName(resultSet.getString(USER_SURNAME))
                        .setEmail(resultSet.getString(USER_EMAIL))
                        .setPhone(resultSet.getString(USER_PHONE))
                        .setStatus(Status.valueOf(resultSet.getString(USER_STATUS)))
                        .setRole(Role.valueOf(resultSet.getString(USER_ROLE)))
                        .setDiscount(UserDiscount.valueOf(resultSet.getString(USER_DISCOUNT)))
                        .setBirthdayDate(resultSet.getString(USER_BIRTHDAY))
                        .build();
                userList.add(user);


            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Can't create query. Exception: ", e);
            throw new RepositoryException("Can't create query. Exception: ", e);
        }

        return userList;
    }
}

