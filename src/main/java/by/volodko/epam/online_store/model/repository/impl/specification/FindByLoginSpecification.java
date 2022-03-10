package by.volodko.epam.online_store.model.repository.impl.specification;

import by.volodko.epam.online_store.model.connection.ConnectionPool;
import by.volodko.epam.online_store.model.repository.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class FindByLoginSpecification implements Specification {
private static final Logger logger = LogManager.getLogger();
private static final String GET_BY_LOGIN_QUERY = "SELECT users.user_id,login,password,name,surname," +
        "email,phone_number,user_status_id,user_role_id,discount_id, birthday_date " +
        "FROM users,users_roles,users_status " +
        "WHERE user_role_id = users_roles.id AND user_status_id = users_status.id " +
        "AND discount_id = users_discounts.id AND login=?";
private String login;
public FindByLoginSpecification (String login){
    this.login = login;
}
    @Override
    public Statement getStatement() {
        PreparedStatement preparedStatement = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(GET_BY_LOGIN_QUERY);
            preparedStatement.setString(1,login);
        } catch (SQLException e){
            logger.log(Level.ERROR, "Can't create query. Exception: ", e);
        }
        return preparedStatement;
    }
}
