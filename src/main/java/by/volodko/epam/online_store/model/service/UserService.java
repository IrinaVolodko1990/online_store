package by.volodko.epam.online_store.model.service;

import by.volodko.epam.online_store.exception.ServiceException;
import by.volodko.epam.online_store.model.entity.User;
import by.volodko.epam.online_store.model.repository.Specification;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> authenticate(String login, String password) throws ServiceException;

    boolean insert(User user) throws ServiceException;

    boolean update(User user) throws ServiceException;

    List<User> query(Specification specification) throws ServiceException;

}
