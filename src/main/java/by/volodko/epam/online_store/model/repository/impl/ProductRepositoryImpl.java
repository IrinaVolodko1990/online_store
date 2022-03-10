package by.volodko.epam.online_store.model.repository.impl;

import by.volodko.epam.online_store.exception.RepositoryException;
import by.volodko.epam.online_store.model.connection.ConnectionPool;
import by.volodko.epam.online_store.model.entity.Product;
import by.volodko.epam.online_store.model.entity.ProductCategory;
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


public class ProductRepositoryImpl implements Repository<Product> {
    private static final Logger logger = LogManager.getLogger();
    private static final String ADD_PRODUCT_QUERY = "";
    private static final String UPDATE_PRODUCT_QUERY = "";
    private static ProductRepositoryImpl instance;

    private ProductRepositoryImpl() {
    }

    public static ProductRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ProductRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void insert(Product product) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT_QUERY);
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getBrand());
            statement.setString(3, product.getDescription());
            statement.setBigDecimal(4, product.getPrice());
            statement.setString(5, product.getProductCategory().getValue());
            statement.setBinaryStream(6, product.getImage());
            statement.setInt(8, product.getNumberInStock());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            logger.log(Level.ERROR, "Can't create query. Exception: ", throwables);
            throw new RepositoryException("Can't create query. Exception: ", throwables);
        }

    }

    @Override
    public void update(Product product) throws RepositoryException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_QUERY);
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getBrand());
            statement.setString(3, product.getDescription());
            statement.setBigDecimal(4, product.getPrice());
            statement.setString(5, product.getProductCategory().getValue());
            statement.setBinaryStream(6, product.getImage());
            statement.setInt(8, product.getNumberInStock());
            statement.setLong(9, product.getProductId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            logger.log(Level.ERROR, "Can't create query. Exception: ", throwables);
            throw new RepositoryException("Can't create query. Exception: ", throwables);
        }
    }


    @Override
    public List query(Specification specification) throws RepositoryException {
        List<Product> productList = new ArrayList<>();
        PreparedStatement statement = (PreparedStatement) specification.getStatement();
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product.ProductBuilder()
                        .setProductId(resultSet.getLong(PRODUCT_ID))
                        .setProductName(resultSet.getString(PRODUCT_NAME))
                        .setBrand(resultSet.getString(PRODUCT_BRAND))
                        .setDescription(resultSet.getString(PRODUCT_DESCRIPTION))
                        .setPrice(resultSet.getBigDecimal(PRODUCT_PRICE))
                        .setProductCategory(ProductCategory.valueOf(resultSet.getString(PRODUCT_CATEGORY)))
                        .setImage(resultSet.getBinaryStream(PRODUCT_IMAGE))
                        .setNumberInStock(resultSet.getInt(PRODUCT_NUMBER_IN_STOCK))
                        .build();
                productList.add(product);
            }
        } catch (SQLException throwables) {
            logger.log(Level.ERROR, "Can't create query. Exception: ", throwables);
            throw new RepositoryException("Can't create query. Exception: ", throwables);
        }
        return productList;
    }
}
