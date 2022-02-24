package by.volodko.epam.online_store.model.repository.impl;

import by.volodko.epam.online_store.exception.RepositoryException;
import by.volodko.epam.online_store.model.repository.Repository;
import by.volodko.epam.online_store.model.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class ProductRepositoryImpl implements Repository {
    private static final Logger logger = LogManager.getLogger();
    private static final String ADD_PRODUCT_QUERY = "";
    private static final String UPDATE_PRODUCT_QUERY = "";
    private static ProductRepositoryImpl instance;

    private ProductRepositoryImpl() {
    }
    public static ProductRepositoryImpl getInstance(){
        if(instance==null){
            instance= new ProductRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void insert(Object ob) throws RepositoryException {

    }

    @Override
    public void update(Object ob) throws RepositoryException {

    }

    @Override
    public List query(Specification specification) throws RepositoryException {
        return null;
    }
}
