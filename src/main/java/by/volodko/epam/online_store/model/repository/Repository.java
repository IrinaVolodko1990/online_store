package by.volodko.epam.online_store.model.repository;

import by.volodko.epam.online_store.exception.RepositoryException;

import java.util.List;

public interface Repository <T> {

    void insert(T ob) throws RepositoryException;
    void update (T ob) throws RepositoryException;
    List<T> query (Specification specification) throws RepositoryException;
}
