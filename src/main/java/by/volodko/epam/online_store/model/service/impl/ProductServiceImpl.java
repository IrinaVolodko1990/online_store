package by.volodko.epam.online_store.model.service.impl;

import by.volodko.epam.online_store.exception.RepositoryException;
import by.volodko.epam.online_store.exception.ServiceException;
import by.volodko.epam.online_store.model.entity.Product;
import by.volodko.epam.online_store.model.repository.Specification;
import by.volodko.epam.online_store.model.repository.impl.ProductRepositoryImpl;
import by.volodko.epam.online_store.model.service.ProductService;
import by.volodko.epam.online_store.model.validator.ProductValidator;
import org.apache.logging.log4j.Level;
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
        boolean flag = false;
        try {
            if (ProductValidator.isValidProductName(product.getProductName()) & ProductValidator.isValidBrand(product.getBrand())
                    & ProductValidator.isValidNumberInStock(product.getNumberInStock()) & ProductValidator.isValidPrice(product.getPrice())) {
                repository.insert(product);
                flag = true;
            }
        } catch (RepositoryException e) {
            logger.log(Level.ERROR, "Something wrong with connection to database", e);
            throw new ServiceException(e);
        }
        return flag;

    }

    @Override
    public boolean update(Product product) throws ServiceException {
        boolean flag = false;
        try {
            if (ProductValidator.isValidProductName(product.getProductName()) & ProductValidator.isValidBrand(product.getBrand())
                    & ProductValidator.isValidNumberInStock(product.getNumberInStock()) & ProductValidator.isValidPrice(product.getPrice())) {
                repository.update(product);
                flag = true;
            }
        } catch (RepositoryException e) {
            logger.log(Level.ERROR, "Something wrong with connection to database", e);
            throw new ServiceException(e);
        }
        return flag;
    }

    @Override
    public List<Product> query(Specification specification) throws ServiceException {
        try {
            return repository.query(specification);
        } catch (RepositoryException e) {
            logger.log(Level.ERROR, "Something wrong with connection to database", e);
            throw new ServiceException(e);
        }
    }
}
