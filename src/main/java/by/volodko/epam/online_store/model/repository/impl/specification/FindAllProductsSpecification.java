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

public class FindAllProductsSpecification implements Specification {
    private static final Logger logger = LogManager.getLogger();
    private static final String GET_ALL = "";

    public FindAllProductsSpecification() {
    }

    @Override
    public Statement getStatement() {
        PreparedStatement preparedStatement = null;
        try(Connection connection = ConnectionPool.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement(GET_ALL);

        } catch (SQLException throwables) {
            logger.log(Level.ERROR, "Can't create query. Exception: ", throwables);
        }
        return preparedStatement;
    }
}
