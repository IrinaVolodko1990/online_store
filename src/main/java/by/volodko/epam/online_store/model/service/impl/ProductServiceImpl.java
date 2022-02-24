package by.volodko.epam.online_store.model.service.impl;

import by.volodko.epam.online_store.exception.ServiceException;
import by.volodko.epam.online_store.model.entity.Product;
import by.volodko.epam.online_store.model.repository.Specification;
import by.volodko.epam.online_store.model.repository.impl.ProductRepositoryImpl;
import by.volodko.epam.online_store.model.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LogManager.getLogger();
    private ProductRepositoryImpl repository = ProductRepositoryImpl.getInstance();
    private static ProductServiceImpl instance;

    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean insert(Product product) throws ServiceException {
        boolean falg = false;
        try{
            if ()
        }
    }

    @Override
    public boolean update(Product product) throws ServiceException {
        return false;
    }

    @Override
    public List<Product> query(Specification specification) throws ServiceException {
        return null;
    }
}
