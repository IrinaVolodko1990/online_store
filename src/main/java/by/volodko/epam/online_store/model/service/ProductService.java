package by.volodko.epam.online_store.model.service;

import by.volodko.epam.online_store.exception.ServiceException;
import by.volodko.epam.online_store.model.entity.Product;
import by.volodko.epam.online_store.model.repository.Specification;

import java.util.List;

public interface ProductService {
    boolean insert(Product product) throws ServiceException;

    boolean update(Product product) throws ServiceException;

    List<Product> query(Specification specification) throws ServiceException;

}
